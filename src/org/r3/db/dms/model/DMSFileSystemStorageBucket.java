package org.r3.db.dms.model;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.r3.db.dms.file.DMSFileDTO;
import org.r3.db.dms.file.DMSFileDataTableAdapter;
import org.r3.db.dms.model.SimpleDMSConstants.DMSFolderAddFileMode;
import org.r3.system.util.ContentTypeUtil;
import org.r3.system.util.FileActionErrorEvent;
import org.r3.system.util.FileCopierMover;

public class DMSFileSystemStorageBucket extends DMSStorageBucket
{
    public DMSFileSystemStorageBucket(DMSDevice aDevice, String aPhysicalName) throws DMSException
    {
        super(aDevice, aPhysicalName);
    }

    @Override
    public boolean exists(DMSContext aDmsContext) throws DMSException
    {
        File bucketFile = getBucketFile(aDmsContext);
        return bucketFile.exists();
    }

    @Override
    public boolean fileExists(DMSContext aDmsContext, String aFileName) throws DMSException
    {
        File bucketFile = getFile(aDmsContext, aFileName);
        return bucketFile.exists() && bucketFile.isFile();
    }

    @Override
    public boolean mkdir(DMSContext aDmsContext) throws DMSException
    {
        File bucketFile = getBucketFile(aDmsContext);
        if (bucketFile.exists())
            return true;

        return bucketFile.mkdirs();
    }

    @Override
    protected String addFileImpl(DMSContext aDmsContext, InputStream aFileInputStream, DMSFileMetadata aFileMetadata, DMSFolderAddFileMode addMode) throws DMSException
    {
        String folderFileName = wellFormFileName(aFileMetadata.getFileName());
        switch(addMode)
        {
            case NONEIFPRESENT: 
                    if (fileExists(aDmsContext, folderFileName))  return null;
                    break;
            case REPLACEIFPRESENT:
                    break;
            case NEWNAMEIFPRESENT:
                    if (fileExists(aDmsContext, folderFileName))
                        folderFileName = generateFileName(aDmsContext, folderFileName);    // aFileMetadata.getFileName()
                    break;
        }
                
        File targetFile = getFile(aDmsContext, folderFileName);
        FileCopierMover cp = new FileCopierMover(false);
        cp.setSourceInputStream(aFileInputStream);
        // TODO
        cp.setInputDestinationPath(targetFile.getAbsolutePath());
        // cp.setDestinationOutputStream( (new OutputStreamWriter(new FileOutputStream(targetFile), "UTF-8"));
        
        cp.setReplaceIfPresent(true);
        FileActionErrorEvent act = cp.process();
        if (act != null) { 
            throw new DMSException("$DMS_EXC_CODE$: Error in adding a file to a storageBucket! " + act.getReason()); 
        }
     
        aFileMetadata.setContentLength(targetFile.length());
        
        File metadataFile = getFile(aDmsContext, getMetadataFileName(folderFileName));
        saveMetadata(aFileMetadata, metadataFile);
        
        return folderFileName;
    }

    
    /* Funzione che provvede ad individuare il file che contiene metadati e provvede
     * a caricare tale file. Nel caso il file non sia disponibile allora provvede ad inserire
     * delle informazioni di 'default'. Esegue comunque l'override della dimensione del file
     * che potrebbe non essere presente nel file di metadati ma che serve quando viene eseguito lo
     * streaming del tutto.
     * 
     * (non-Javadoc)
     * @see it.gwf_struts.gwfdms.model.DMSStorageBucket#getFileMetadata(java.lang.String)
     */
    @Override
    public DMSFileMetadata getFileMetadata(DMSContext aDmsContext, String fileName) throws DMSException
    {
        File metadataFile = getFile(aDmsContext, getMetadataFileName(fileName));
        
        DMSFileMetadata metadata = null;
        if (metadataFile.exists() && metadataFile.isFile())
        {
            metadata = loadMetadata(metadataFile);
            metadata.setContentLength(getFile(aDmsContext, fileName).length());            
        }
        else 
        {
            metadata = augmentMetadata(getFile(aDmsContext, fileName), null);
        }
        
        return metadata;
    }

    @Override
    public void setFileMetadata(DMSContext aDmsContext, String fileName, DMSFileMetadata metadata) throws DMSException
    {
        File metadataFile = getFile(aDmsContext, getMetadataFileName(fileName));
        metadata = augmentMetadata(getFile(aDmsContext, fileName), metadata);
        saveMetadata(metadata, metadataFile);
    }

    @Override
    public void deleteAllFiles(DMSContext aDmsContext) throws DMSException
    {
        if (!exists(aDmsContext))  return;
        
        File bucketFile = getBucketFile(aDmsContext);
        FilenameFilter filenameFilter = 
            new FilenameFilter() 
            {
                public boolean accept(File directory, String fileName)
                {
                    File fileObj = new File(directory, fileName);
                    if (fileObj.isDirectory())
                        return false;
                    
                    return true;
                }
            };
        
        File[] listOfFiles = bucketFile.listFiles(filenameFilter);
        if (listOfFiles == null || listOfFiles.length == 0)  
             return ;
        
        for(File f : listOfFiles)
        {
        	f.delete();
        }
    }
    
    /* OPerazione di cancellazione del bucket */
    @Override
    public void delete(DMSContext aDmsContext) throws DMSException
    {
    	File bucketFile = getBucketFile(aDmsContext);
    	if (bucketFile.exists())
    		bucketFile.delete();
    }

    @Override
    public void delete(DMSContext aDmsContext, String aFileName) throws DMSException
    {
        if (!exists(aDmsContext))  return;
                
        File metadataFile = getFile(aDmsContext, this.getMetadataFileName(aFileName));        
        if (metadataFile.exists())
            if (!metadataFile.delete())
                throw new DMSException("$DMS_EXC_CODE$: Error in deleting file of metadata! " + metadataFile.getAbsolutePath());
        
        File actualFile = this.getFile(aDmsContext, aFileName);
        if (actualFile.exists())
            if (!actualFile.delete())
                throw new DMSException("$DMS_EXC_CODE$: Error in deleting file ! " + actualFile.getAbsolutePath());
    }
    
    @Override
    public long getFileContent(DMSContext aDmsContext, String aFileName, OutputStream anOutputStream) throws DMSException
    {
        byte buf[] = new byte[2048];
        long writtenBytes = 0L;
        int counter = 0;

        FileInputStream sourceFileInputStream = null;

        try
        {
            sourceFileInputStream = new FileInputStream(getFile(aDmsContext, aFileName));
            while ((counter = sourceFileInputStream.read(buf)) != -1)
            {
                anOutputStream.write(buf, 0, counter);
                writtenBytes += counter;
            }

            return writtenBytes;
        }
        catch (IOException exc)
        {
            exc.printStackTrace();
            throw new DMSException("$DMS_EXC_CODE$: Error in reading file " + aFileName + " from a bucket! ");
        }
        finally
        {
            if (sourceFileInputStream != null)
                try { sourceFileInputStream.close(); } catch(IOException e2)  { e2.printStackTrace(); }
        }

    }
    
    private DMSFileMetadata augmentMetadata(File aFile, DMSFileMetadata aFileMetadata)
    {
        if (aFileMetadata == null)
        {
            aFileMetadata = new DMSFileMetadata();
        }
        aFileMetadata.setFileName(wellFormFileName(aFile.getName()));
        aFileMetadata.setContentLength(aFile.length());
        aFileMetadata.setContentType(ContentTypeUtil.findMimeType(aFile.getName()));
        return aFileMetadata;
    }

    private File getBucketFile(DMSContext aDmsContext) throws DMSException
    {
        return getFile(aDmsContext, null);
    }

    // Funzione che ritorna la lista dei files presenti in una directory
    @Override
    public DMSFileDataTableAdapter getFiles(DMSContext aDmsContext, DMSFileSystemUrl aFolderUrl, String sEcho, int iDisplayStart, int iDisplayLength, boolean countElements) throws DMSException
    {
        File bucketFile = getBucketFile(aDmsContext);
        FilenameFilter filenameFilter = 
            new FilenameFilter() 
            {
                public boolean accept(File directory, String fileName)
                {
                    if (fileName.toUpperCase().endsWith(SimpleDMSConstants.DMSMETAFILENAMESCHEME_SUFFIX)) 
                        return false;
                    
                    File fileObj = new File(directory, fileName);
                    if (fileObj.isDirectory())
                        return false;
                    
                    return true;
                }
            };
        
        File[] listOfFiles = bucketFile.listFiles(filenameFilter);
        if (listOfFiles == null || listOfFiles.length == 0)  
             return null;
        
        int startRecord = iDisplayStart;
        int endRecord   = iDisplayStart + iDisplayLength;
        if (listOfFiles.length <= startRecord)
        {
            startRecord = 0;
            endRecord =  iDisplayLength;
        }
                
        List<DMSFileDTO> listOfDataBean = new ArrayList<DMSFileDTO>(listOfFiles.length);
        for(int i = startRecord; i < listOfFiles.length && i <= endRecord; i++)
        {
            DMSFileDTO fileDataBean = new DMSFileDTO();
            fileDataBean.setFileUrl(new DMSFileSystemUrl(aFolderUrl, listOfFiles[i].getName()));
            fileDataBean.setFileid("FILE_" + i);            
            fileDataBean.setFilelength(listOfFiles[i].length());
            fileDataBean.setFilename(listOfFiles[i].getName());
            fileDataBean.setFilephysicalpath(getBucketPath(aDmsContext));
            fileDataBean.setMimetype(ContentTypeUtil.findMimeType(listOfFiles[i].getName()));
            listOfDataBean.add(fileDataBean);
        }
        
        DMSFileDataTableAdapter dt = new DMSFileDataTableAdapter(); 
        dt.setiTotalRecords(listOfFiles.length);
        dt.setAaData(listOfDataBean);
        
        return dt;        
    }
    
    /**
     * Funzione che ritorna il java.io.File corrispondente alla cartella fisica
     * (aFileName nullo) oppure al file richiesto all'interno della cartella.
     * 
     * @param aFileName
     * @return
     * @throws DMSException
     */
    @Override
    public File getFile(DMSContext aDmsContext, String aFileName) throws DMSException
    {
        String bucketPath = getBucketPath(aDmsContext);
        URI bucketUri     = null;
        
        if (bucketPath.startsWith("file://"))
        {
            if (aFileName != null)
                bucketPath = bucketPath + "/" + aFileName;
            
            try
            {
                bucketUri = new URI(bucketPath);
            }
            catch (URISyntaxException e)
            {
                e.printStackTrace();
                throw new DMSException("$DMS_EXC_CODE$: Invalid URI for bucket! ");
            }
            
            return new File(bucketUri);
        }
        else
        {
            if (aFileName != null)
                return new File(bucketPath, aFileName);

            return new File(bucketPath);
        }
    }

    /**
     * Funzione che accede al device, recupera il nome fisico del device e
     * costruisce il nome completo del file.
     * 
     * @return
     * @throws DMSException
     */
    private String getBucketPath(DMSContext aDmsContext) throws DMSException
    {
        DMSDeviceAlias alias = getDevice().getAlias(aDmsContext);
        DMSFileSystemDeviceUrl deviceUrl = (DMSFileSystemDeviceUrl)(alias.getDevphysicalnameAsUrl());

        String pathName = buildPhysicalPath(deviceUrl.getPath(), getPhysicalName());
        return pathName;
    }

    private String buildPhysicalPath(String devicePhysicalName, String path)
    {
        return devicePhysicalName + path;
    }
    
    /**
     * Funzione che provvede alla persistenza delle informazioni di metadata di un file. La funzione gestisce anche
     * il caso in cui le informazioni non vi siano e il file debba nel caso essere cancellato.
     * 
     * @param aFileMetadata
     * @param aMetadataFile
     * @throws DMSException
     */
    private void saveMetadata(DMSFileMetadata aFileMetadata, File aMetadataFile) throws DMSException
    {
        if (aFileMetadata != null)
        {
        	if (aFileMetadata.getCreationDate() == null)
        		aFileMetadata.setCreationDate();
        	
            FileOutputStream fout = null;
            try
            {
                fout = new FileOutputStream(aMetadataFile);
                aFileMetadata.store(fout);
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
                throw new DMSException("$DMS_EXC_CODE$: Cannot find file for metadata " + aMetadataFile);
            }
            catch (IOException e)
            {
                e.printStackTrace();
                throw new DMSException("$DMS_EXC_CODE$: Cannot store metadata to file " + aMetadataFile);
            }
            finally
            {
                if (fout != null)
                    try { fout.close(); } catch(IOException e)  { e.printStackTrace(); }
            }
        }
        else
        {
            // Nel caso non sia stata passata una informazione di metadata allora
            // debbo eventualmente cancellarne una pre-esistente.
            if (aMetadataFile.exists())
            {
                aMetadataFile.delete();
            }
        }
    }

    /**
     * Funzione che provvede allalettura delle informazioni di metadata di un file.
     * 
     * @param aFileMetadata
     * @param aMetadataFile
     * @throws DMSException
     */
    private DMSFileMetadata loadMetadata(File aMetadataFile) throws DMSException
    {
        DMSFileMetadata aFileMetadata = new DMSFileMetadata();
        FileInputStream finp = null;
        try
        {
            finp = new FileInputStream(aMetadataFile);
            aFileMetadata.load(finp);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            throw new DMSException("$DMS_EXC_CODE$: Cannot find file for metadata " + aMetadataFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            throw new DMSException("$DMS_EXC_CODE$: Cannot store metadata to file " + aMetadataFile);
        }
        finally
        {
            if (finp != null)
                try
                {
                    finp.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
        }

        return aFileMetadata;
    }

}

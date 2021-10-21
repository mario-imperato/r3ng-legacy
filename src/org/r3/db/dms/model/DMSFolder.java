package org.r3.db.dms.model;



import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.r3.db.dms.file.DMSFileDataTableAdapter;
import org.r3.db.dms.folder.DMSFolderDTO;
import org.r3.db.dms.folder.DMSFolderPersistence;
import org.r3.db.dms.model.SimpleDMSConstants.DMSFolderAddFileMode;

public class DMSFolder extends DMSFolderDTO
{		    
    private DMSFileSystemUrl folderUrl               = null;
    private DMSStorageBucket storageBucket = null;
    
    // Costruttore invocato solamente dalle funzioni interne (es. getChildren()).
    protected DMSFolder()
    {
        
    }
    
    public DMSFolder(DMSContext aDmsContext, DMSFileSystemUrl aFolderUrl) throws DMSException
    {
        setFolderUrl(aFolderUrl);
        findFolder(aDmsContext, aFolderUrl);               
    }

    public DMSFolder(DMSContext aDmsContext, String aFolderIdentifier) throws DMSException
    {
        findFolder(aDmsContext, aFolderIdentifier);    
    }

    public File getFolderFile(DMSContext aDmsContext) throws DMSException
    {
        if (!exists())  
            throw new DMSException("$DMS_EXC_CODE$: Cannot retrieve file folder for a not-existent folder!");
        
        if (!isBound())
            throw new DMSException("$DMS_EXC_CODE$: Cannot retrieve file folder for a not-bound folder!");

        DMSStorageBucket storageBucket = this.getStorageBucket();         
        return storageBucket.getFile(aDmsContext, null);
    }
    
    public String getName()
    {
        return folderUrl.getName();    
    }
    
    /* (non-Javadoc)
     * @see it.gwf_struts.gwfdms.db.entities.gwfdmsfolder.IGWFDMSFolderDataBean#getFolderlogicalpath()
     */
    public String getFolderlogicalpath()
    {
        return folderUrl.getPath();
    }
    
    public boolean exists()
    {
        return folderid != null;
    }
    
    public boolean isBound()
    {
        return this.getStorageBucket() != null;    
    }
    
    public boolean isRoot()
    {
        return folderUrl.isRoot();    
    }
    
    public DMSFolder getParent(DMSContext aDmsContext) throws DMSException
    {
        if (folderUrl.isRoot())  return null;
        
        return new DMSFolder(aDmsContext, folderUrl.getParent());    
    }
    
    public DMSFolder createChild(DMSContext aDmsContext, String childName) throws DMSException
    {
        DMSFolder folder = new DMSFolder(aDmsContext, new DMSFileSystemUrl(getFolderUrl(), childName));
        if (folder.exists())
            throw new DMSException("$DMS_EXC_CODE$: the child folder already exists!");
        
        folder.mkdir(aDmsContext);        
        return folder;
    }
    
    public boolean hasChildren(DMSContext aDmsContext) throws DMSException
    {
        
        try
        {
        	DMSFolderPersistence p = DMSFolderPersistence.createPersistenceObject(aDmsContext.getPersistenceContext(),
							aDmsContext.getSession());
        	            
            return p.hasChildren(folderUrl.getPath().toUpperCase(), folderUrl.getUrlDepth() + 1, aDmsContext.getPersistenceContext().getPersistenceConfigInfo()); 

        }
        catch (Exception e)
        {
            e.printStackTrace(System.err);
            throw new DMSException(e);
        }
        finally
        {
        }
        
    }
    
    /**
     * Questa funzione di cancellazione, al momento, si limita a cancellare la struttura dei folder ma
     * nulla fa per quanto riguarda i file nel caso in cui i folder siano bounded. L'attivita' andrebbe
     * effettuata attraverso un job, se in cascata...
     * 
     * @throws DMSException
     */
    public void setEnabled(DMSContext aDmsContext, FolderStatus enabledFlag)  throws DMSException
    {        
        try
        {
        	DMSFolderPersistence p = DMSFolderPersistence.createPersistenceObject(aDmsContext.getPersistenceContext(),
							aDmsContext.getSession());
            
            setFolderstatus(enabledFlag.toString());            
            p.markFolderEnabledByFolderlogicalpath(this, folderUrl.getPath().toUpperCase(), aDmsContext.getPersistenceContext().getPersistenceConfigInfo());
            
            if (enabledFlag == FolderStatus.sys_recdeleted)
            {
            	File f = getFolderFile(aDmsContext);
            	if (f != null && f.exists() && f.canWrite())
            	{
            		File newFileName = new File(f.getParent(), f.getName() + ".deleted");
            		boolean rc = f.renameTo(newFileName);
            		if (!rc)
            		{
            			System.out.println("Could Not Rename As Deleted File: " + f.getAbsolutePath());
            		}
            	}
            }
        }
        catch (Exception e)
        {
            e.printStackTrace(System.err);
            throw new DMSException(e);
        }
        finally
        {
        }        
    }

    public void unbind(DMSContext aDmsContext) throws DMSException
    {
        if (!exists())  
            throw new DMSException("$DMS_EXC_CODE$: Cannot bind a folder that doesn't exist!");
        
        if (!isBound())
            throw new DMSException("$DMS_EXC_CODE$: Cannot bind a folder that is NOT bound!");

        this.storageBucket = null;
        setDeviceid(null);
        setFolderphysicalpath(null);

        persistFolder(aDmsContext);
    }

    public void bindToParent(DMSContext aDmsContext) throws DMSException
    {
        bindToParent(aDmsContext, false, false);
    }

    public void bindToParent(DMSContext aDmsContext, boolean recurseFlag) throws DMSException
    {
        bindToParent(aDmsContext, recurseFlag, false);
    }

    protected void bindToParent(DMSContext aDmsContext, boolean recurseFlag, boolean forceFlag) throws DMSException
    {
        if (!exists())  
            throw new DMSException("$DMS_EXC_CODE$: Cannot bind a folder that doesn't exist!");
        
        if (isBound() && !forceFlag)
            throw new DMSException("$DMS_EXC_CODE$: Cannot re-bind a folder that is already bound: use the unbind operation first!");
     
        DMSFolder parentFolder = getParent(aDmsContext);
        if (!parentFolder.isBound())
        {
            if (!recurseFlag || parentFolder.isRoot())
                throw new DMSException("$DMS_EXC_CODE$: Cannot bind a folder to a not-bound parent folder!");
            
            parentFolder.bindToParent(aDmsContext, recurseFlag, forceFlag);
        }
            
        
        DMSStorageBucket parentBucket = parentFolder.getStorageBucket();
        DMSDevice theParentDevice = parentBucket.getDevice();
        
        String parentFolderName = parentBucket.getPhysicalName();
        DMSFileSystemUrl thePhysicalUrl = new DMSFileSystemUrl(parentFolderName, getFolderUrl().getName());
        
        DMSStorageBucket bucket = theParentDevice.getStorageBucket(thePhysicalUrl.getPath());
        
        if (!bucket.exists(aDmsContext))
            bucket.mkdir(aDmsContext);
        
        bind(aDmsContext, bucket, false, forceFlag);
    }
    
    public void bind(DMSContext aDmsContext, DMSStorageBucket aStorageBucket) throws DMSException
    {
        bind(aDmsContext, aStorageBucket, false, false);
    }

    public void bind(DMSContext aDmsContext, DMSStorageBucket aStorageBucket, boolean recurseFlag) throws DMSException
    {
        bind(aDmsContext, aStorageBucket, recurseFlag, false);
    }

    public void rebind(DMSContext aDmsContext, DMSStorageBucket aStorageBucket, boolean recurseFlag) throws DMSException
    {
        bind(aDmsContext, aStorageBucket, recurseFlag, true);
    }

    protected void bind(DMSContext aDmsContext, DMSStorageBucket aStorageBucket, boolean recurseFlag, boolean forceFlag) throws DMSException
    {
        if (!exists())  
            throw new DMSException("$DMS_EXC_CODE$: Cannot bind a folder that doesn't exist!");
        
        // L'operazione di re-bind puo' provocare dei detriti... Dovrei trasportare tutto da un'altra parte.
        // Molto meglio fare con altre tecniche. Eventualmente pensare ad un job oppure una coda di tipo locale in maniera da
        // permettere di specificare anche i dati di accesso ai bucket per il trasferimento eventuale.
        if (isBound() && !forceFlag)
            throw new DMSException("$DMS_EXC_CODE$: Cannot re-bind a folder that is already bound: use the unbind operation first!");

        if (!aStorageBucket.exists(aDmsContext))
            throw new DMSException("$DMS_EXC_CODE$: Cannot bind a folder to a not existing storageBucket!");

        setStorageBucket(aStorageBucket);                        
        persistFolder(aDmsContext);        
        
        if (recurseFlag)
        {
            List<DMSFolder> listOfChildren = getChildren(aDmsContext, true, true);
            if (listOfChildren != null && listOfChildren.size() > 0)
            {
                for(DMSFolder aChildFolder : listOfChildren )
                {                
                   // L'operazione non viene eseguita ricorsivamente....
                   aChildFolder.bindToParent(aDmsContext, true);
                }
            }
        }
    }

    private boolean findFolder(DMSContext aDmsContext, DMSFileSystemUrl aFolderUrl) throws DMSException
    {
        
        try
        {
        	DMSFolderPersistence p = DMSFolderPersistence.createPersistenceObject(aDmsContext.getPersistenceContext(),
							aDmsContext.getSession());
            
            DMSFolderDTO folderDataBean = p.selectByFolderlogicalpath(aFolderUrl.getPath().toUpperCase(), aDmsContext.getPersistenceContext().getPersistenceConfigInfo());
                                               
            if (folderDataBean != null)
            {
                this.copyFrom(folderDataBean);                
                if (getDeviceid() != null)
                {
                    DMSDevice device = new DMSDeviceFactory().findDevice(aDmsContext, getDeviceid());
                    this.setStorageBucket(device.getStorageBucket(getFolderphysicalpath()));
                }
                
                return true;
            }
            
            return false;
        }
        catch (Exception e)
        {
            e.printStackTrace(System.err);
            throw new DMSException(e);
        }
        finally
        {
        }
    }

    private boolean findFolder(DMSContext aDmsContext, String folderIdentifier) throws DMSException
    {        
        try
        {
        	DMSFolderPersistence p = DMSFolderPersistence.createPersistenceObject(aDmsContext.getPersistenceContext(),
							aDmsContext.getSession());
            
            DMSFolderDTO folderDataBean = p.selectByFolderid(folderIdentifier, aDmsContext.getPersistenceContext().getPersistenceConfigInfo());                                   
            
            if (folderDataBean != null)
            {
                this.copyFrom(folderDataBean);
                setFolderUrl(folderDataBean.getFolderlogicalpath());
                if (getDeviceid() != null)
                {
                    DMSDevice device = new DMSDeviceFactory().findDevice(aDmsContext, getDeviceid());
                    this.setStorageBucket(device.getStorageBucket(getFolderphysicalpath()));
                }

                return true;
            }
            
            throw new DMSException("$DMS_EXC_CODE$: Folder could not be found");
        }
        catch (Exception e)
        {
            e.printStackTrace(System.err);
            throw new DMSException(e);
        }
        finally
        {
        }
    }

    private void setFolderUrl(DMSFileSystemUrl folderUrl)
    {
        this.folderUrl = folderUrl;
    }

    private void setFolderUrl(String folderUrl) throws DMSException
    {
        this.folderUrl = new DMSFileSystemUrl(folderUrl);
    }

    public DMSFileSystemUrl getFolderUrl()
    {
        return folderUrl;
    }

//    public GWFDMSFolderPrimaryKeyDataBean getPrimaryKey()
//    {
//        GWFDMSFolderPrimaryKeyDataBean pk = new GWFDMSFolderPrimaryKeyDataBean();
//        pk.setFolderid(getFolderid());
//        return pk;
//    }
    

    public DMSFile addFile(DMSContext aDmsContext, InputStream anInputStream, DMSFileMetadata aFileMetadata, DMSFolderAddFileMode addMode) throws DMSException
    {
    	// || aFileMetadata.getContentLength() <= 0 || aFileMetadata.getCreationDate() == null
    	
    	if (aFileMetadata.getContentType() == null  ||
                aFileMetadata.getFileName() == null )
        {
            throw new DMSException("$DMS_EXC_CODE$: Cannot find required file metadata in adding from inputStream.");
        }

        if (!exists())  
            throw new DMSException("$DMS_EXC_CODE$: Cannot add a file to a not-existent folder!");
        
        if (!isBound())
            throw new DMSException("$DMS_EXC_CODE$: Cannot add a file to a not-bound folder!");

        DMSStorageBucket storageBucket = this.getStorageBucket();         
        String savedFileName = storageBucket.addFile(aDmsContext, anInputStream, aFileMetadata, addMode);
        
        return new DMSFile(new DMSFileSystemUrl(getFolderUrl(), savedFileName));
    }

    /**
     * Funzione che permette di inserire un file all'interno di un folder. Alcune caratteristiche del file
     * sono desunte dall'oggetto File (dimensione, tipo - dall'estensione -, nome) e vanno  a popolare i valori
     * all'interno dei metadati
     * @param aLocalFile
     */
    public DMSFile addFile(DMSContext aDmsContext, File aLocalFile, DMSFileMetadata aFileMetadata, DMSFolderAddFileMode addMode) throws DMSException
    {
        if (!aLocalFile.exists() || !aLocalFile.canRead() || !aLocalFile.isFile())
            throw new DMSException("$DMS_EXC_CODE$: Cannot add a not-existent file to a folder.");
        
        if (!exists())  
            throw new DMSException("$DMS_EXC_CODE$: Cannot add a file to a not-existent folder!");
        
        if (!isBound())
            throw new DMSException("$DMS_EXC_CODE$: Cannot add a file to a not-bound folder!");

        DMSStorageBucket storageBucket = this.getStorageBucket();         
        String savedFileName = storageBucket.addFile(aDmsContext, aLocalFile, aFileMetadata, addMode);
        
        return new DMSFile(new DMSFileSystemUrl(getFolderUrl(), savedFileName));
    }
    
    public boolean mkdir(DMSContext aDmsContext) throws DMSException
    {
        if (exists())
            return true;

        // Verifico prima il parent: se e' nullo oppure esiste
        // allora posso procedere alla creazione: in questo modo prendo anche il caso
        // anomalo di creazione della root "/" (che non dovrebbe capitare in quanto la base
        // dati dovrebbe essere propriamente pre-popolata.
        // In caso viceversa il parentFolder esista (e quindi non si tratta della root)
        // e contemporaneamente il padre non esista allora mi costruisco la chain.
        DMSFolder parentFolder = getParent(aDmsContext);
        if (parentFolder != null && !parentFolder.exists())
        {
            List<DMSFileSystemUrl> listOfUrls = folderUrl.getChainOfUrls();
            if (listOfUrls == null)
                return false;

            for (DMSFileSystemUrl url : listOfUrls)
            {
                DMSFolder folder = new DMSFolder(aDmsContext, url);
                if (!folder.exists())
                {
                    if (!folder.mkdirImpl(aDmsContext))
                        return false;
                }
            }
        }
        return mkdirImpl(aDmsContext);
    }

    private boolean mkdirImpl(DMSContext aDmsContext)  throws DMSException
    {
        if (exists())  return true;
        
        DMSFolder parentFolder = getParent(aDmsContext);
        if (parentFolder == null || parentFolder.exists())
        {
            setFolderlogicalpath(folderUrl.getPath());
            setFolderdepth(folderUrl.getUrlDepth());
            setFolderstatus(FolderStatus.sys_recact.toString());
            persistFolder(aDmsContext);
            
            return true;
        }
        
        return false;
    }


    public void persistFolder(DMSContext aDmsContext) throws DMSException
    {        
        try
        {
        	DMSFolderPersistence p = DMSFolderPersistence.createPersistenceObject(aDmsContext.getPersistenceContext(),
							aDmsContext.getSession());

        	if (getFolderid() != null)
               p.updateByPrimaryKey(this, aDmsContext.getPersistenceContext().getPersistenceConfigInfo());
        	else 
        		p.insert(this, aDmsContext.getPersistenceContext().getPersistenceConfigInfo());
        }
        catch (Exception e)
        {
            e.printStackTrace(System.err);
            throw new DMSException(e);
        }
        finally
        {
        }
    }

    protected void setStorageBucket(DMSStorageBucket storageBucket)
    {
        this.storageBucket = storageBucket;
        setDeviceid(storageBucket.getDevice().getDeviceid());
        setFolderphysicalpath(storageBucket.getPhysicalName());
    }

    public DMSStorageBucket getStorageBucket()
    {
        return storageBucket;
    }
    
    public List<DMSFolder> getChildren(DMSContext aDmsContext) throws DMSException
    {
        return  getChildren(aDmsContext, false, false);
    }
    
    public List<DMSFolder> getChildren(DMSContext aDmsContext, boolean recurse, boolean parentFirstFlag) throws DMSException
    {

        List<DMSFolder> resultList = null;
        try
        {
        	DMSFolderPersistence p = DMSFolderPersistence.createPersistenceObject(aDmsContext.getPersistenceContext(),
							aDmsContext.getSession());
            
            List<DMSFolderDTO> listOfChildren = null;
            if (recurse)
            {
                listOfChildren = p.selectHierarchy(getFolderUrl().getPath(), parentFirstFlag, aDmsContext.getPersistenceContext().getPersistenceConfigInfo());
            }
            else
            {
                listOfChildren = p.selectChildren(getFolderUrl().getPath(), getFolderUrl().getUrlDepth() + 1, aDmsContext.getPersistenceContext().getPersistenceConfigInfo());
            }
            
            if (listOfChildren != null)
            {
                for (DMSFolderDTO dataBean : listOfChildren)
                {
                    DMSFolder aFolder = new DMSFolder();
                    aFolder.copyFrom(dataBean);
                    aFolder.setFolderUrl(dataBean.getFolderlogicalpath());

                    if (dataBean.getDeviceid() != null)
                    {
                        DMSDevice device = new DMSDeviceFactory().findDevice(aDmsContext, dataBean.getDeviceid());
                        aFolder.setStorageBucket(device.getStorageBucket(dataBean.getFolderphysicalpath()));
                    }

                    if (resultList == null)
                        resultList = new ArrayList<DMSFolder>();
                    resultList.add(aFolder);
                }

            }

        }
        catch (Exception e)
        {
            e.printStackTrace(System.err);
            throw new DMSException(e);
        }
        finally
        {         
        }

        return resultList;
    }

    public DMSFileDataTableAdapter getFiles(DMSContext aDmsContext, String sEcho, int iDisplayStart, int iDisplayLength, boolean countElements) throws DMSException
    {
        if (!isBound())
        {
            return null;
        }
        
        DMSStorageBucket bucket = getStorageBucket();
        DMSDevice device = bucket.getDevice();

        DMSFileDataTableAdapter resultList = bucket.getFiles(aDmsContext, getFolderUrl(), sEcho, iDisplayStart, iDisplayLength, countElements); 
        return resultList;
    }
    
    // Convenience method to create a tree of bound folder to parent.
    public DMSFolder makeFoldersBoundToParent(DMSContext aDmsContext, String[] subFoldersPath) throws DMSException
    {
    	DMSFolder documentFolder = null;
        String subPath = getFolderlogicalpath();
    	for(String subPathPart : subFoldersPath)
    	{
    	    StringBuilder stb = new StringBuilder();
    	    stb.append(subPath)
    	      .append("/")
    	      .append(subPathPart);
    	    
    	    subPath = stb.toString();
    	    DMSUrl documentFolderUrl = DMSUrlFactory.newInstance(subPath);
            documentFolder = new DMSFolder(aDmsContext, (DMSFileSystemUrl) documentFolderUrl);

            if (!documentFolder.exists())
            {
        	   documentFolder = documentFolder.getParent(aDmsContext).createChild(aDmsContext, subPathPart);
        	   documentFolder.setFolderstatus(FolderStatus.sys_recact.toString());
        	   documentFolder.persistFolder(aDmsContext);
        	   documentFolder.bindToParent(aDmsContext);
            }
    	}
    	
    	return documentFolder;
    }
    
    public DMSFolder makeFoldersBoundToParent(DMSContext aDmsContext, Path subFoldersPath) throws DMSException
    {
    	DMSFolder documentFolder = null;
        String subPath = getFolderlogicalpath();
        for(int i = 0; i < subFoldersPath.getNameCount(); i++)
    	// for( : subFoldersPath.iterator())
    	{
        	String subPathPart = subFoldersPath.getName(i).toString();
    	    StringBuilder stb = new StringBuilder();
    	    stb.append(subPath)
    	      .append("/")
    	      .append(subPathPart);
    	    
    	    subPath = stb.toString();
    	    DMSUrl documentFolderUrl = DMSUrlFactory.newInstance(subPath);
            documentFolder = new DMSFolder(aDmsContext, (DMSFileSystemUrl) documentFolderUrl);

            if (!documentFolder.exists())
            {
        	   documentFolder = documentFolder.getParent(aDmsContext).createChild(aDmsContext, subPathPart);
        	   documentFolder.setFolderstatus(FolderStatus.sys_recact.toString());
        	   documentFolder.persistFolder(aDmsContext);
        	   documentFolder.bindToParent(aDmsContext);
            }
    	}
    	
    	return documentFolder;
    }
    
    
// public boolean bindTo(_IDMSStorageBucket aStorageBucket) throws DMSException;
// public _IDMSStorageBucket getBinding();
// public boolean unbind(boolean keepContent) throws DMSException;
//    
//    public boolean mkdir()  throws DMSException;
//    public boolean mkdirs() throws DMSException;
//    
//    public boolean canRead();
//    public boolean canWrite();  
//    public boolean isEnabled();
//    
//    public List getListOfSubFolders() throws DMSException;
//    public List getListOfFiles()      throws DMSException;
//    
//    public _IDMSFolderInfo getInfo()   throws DMSException;
//    
//    public void addExternalFile(File aLocalFile, _DMSFileMetadata fileMetadata) throws DMSException;
//    public void copyFile(_IDMSFile aFile) throws DMSException;    
//    public void moveFile(_IDMSFile aFile) throws DMSException;
//    
//    public void setReadOnly(boolean aFlag);
//    public void setEnabled(boolean aFlag);
}
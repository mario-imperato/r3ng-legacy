package org.r3.db.dms.model;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.r3.db.dms.file.DMSFileDTO;
import org.r3.db.dms.file.DMSFileDataTableAdapter;
import org.r3.db.dms.file.DMSFilePersistence;
import org.r3.db.dms.fileproperty.DMSFilePropertyDTO;
import org.r3.db.dms.fileproperty.DMSFilePropertyPersistence;
import org.r3.db.dms.model.SimpleDMSConstants.DMSFolderAddFileMode;
import org.r3.db.system.sequence.SequencePersistence;
import org.r3.system.util.SystemUtils;

public class DMSDBStorageBucket extends DMSStorageBucket
{
    public DMSDBStorageBucket(DMSDevice aDevice, String aPhysicalName) throws DMSException
    {
        super(aDevice, aPhysicalName);
    }

    /* Questa implementazione torna sempre vero in quanto la chiamata non ha senso ma viene lasciata per compatibilita'
     * con altri tipi di device (es. FileSystem)
     * 
     * (non-Javadoc)
     * @see it.gwf_struts.gwfdms.model.DMSStorageBucket#exists()
     */
    @Override
    public boolean exists(DMSContext aDmsContext) throws DMSException
    {
        return true;
    }

    /* (non-Javadoc)
     * @see it.gwf_struts.gwfdms.model.DMSStorageBucket#fileExists(java.lang.String)
     */
    @Override
    public boolean fileExists(DMSContext aDmsContext, String aFileName) throws DMSException
    {
        return getFileDataBean(aDmsContext, aFileName) != null;
    }

    /* Questa implementazione torna sempre vero in quanto la chiamata non ha senso ma viene lasciata per compatibilita'
     * con altri tipi di device (es. FileSystem)
     * 
     * @see it.gwf_struts.gwfdms.model.DMSStorageBucket#mkdir()
     */
    @Override
    public boolean mkdir(DMSContext aDmsContext) throws DMSException
    {
        return true;
    }

    @Override
    public void deleteAllFiles(DMSContext aDmsContext) throws DMSException
    {
        try
        {
        	DMSFilePropertyPersistence p1 = DMSFilePropertyPersistence.createPersistenceObject(aDmsContext.getPersistenceContext(), aDmsContext.getSession());

        	//p1.setTargetTableName(getMetadataTableName(aDmsContext));            
            p1.physicalDeleteByFilephysicalpath(getPhysicalName(), aDmsContext.getPersistenceContext().getPersistenceConfigInfo());

        	DMSFilePersistence p = DMSFilePersistence.createPersistenceObject(aDmsContext.getPersistenceContext(), aDmsContext.getSession());
             
        	// fileEnt.setTargetTableName(this.getTableName(aDmsContext));
        	p.deleteByFilephysicalpath(getPhysicalName(), aDmsContext.getPersistenceContext().getPersistenceConfigInfo());        	
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
    
    /* L'operazione di cancellazione del bucket e' nulla nel caso di tabella. */
    @Override
    public void delete(DMSContext aDmsContext) throws DMSException
    {
    	
    }
    
    @Override
    public void delete(DMSContext aDmsContext, String aFileName) throws DMSException
    {
        try
        {
        	DMSFilePersistence p = DMSFilePersistence.createPersistenceObject(aDmsContext.getPersistenceContext(), aDmsContext.getSession());
            // p.setTargetTableName(this.getTableName(aDmsContext));
            
        	DMSFileDTO dto = p.selectByFilenameFolderphysicalpath(aFileName, this.getPhysicalName(), aDmsContext.getPersistenceContext().getPersistenceConfigInfo());
            if (dto != null)
            {
            	DMSFilePropertyPersistence p1 = DMSFilePropertyPersistence.createPersistenceObject(aDmsContext.getPersistenceContext(), aDmsContext.getSession());
                // p1.setTargetTableName(getMetadataTableName(aDmsContext));
                p1.deleteByFileid(dto.getFileid(), aDmsContext.getPersistenceContext().getPersistenceConfigInfo());
                p.deleteByFileid(dto.getFileid(), aDmsContext.getPersistenceContext().getPersistenceConfigInfo());
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
    
    private String getFileIdentifier(DMSContext aDmsContext) throws Exception
    {
        // Debbo generare un identificativo univoco per il file in questione. Ho
        // bisogno di un ConnectionManager e di una connessione 'eventualmente' separata.

        String fileId = null;
        try
        {
        	SequencePersistence p = aDmsContext.getPersistenceContext().getSequencePersistence();
        	fileId = p.getSequence("DFL");
        }
        catch (Exception e)
        {
            e.printStackTrace(System.err);
            throw e;
        }
        finally
        {
        }

        return fileId;
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
            	    delete(aDmsContext, folderFileName);
            	    
            	    break;
            case NEWNAMEIFPRESENT:
                    if (fileExists(aDmsContext, folderFileName))
                        folderFileName = generateFileName(aDmsContext, folderFileName);
                    break;
        }
       
        DMSFileDTO fileDb = null;
        try
        {            
        	DMSFilePersistence p = DMSFilePersistence.createPersistenceObject(aDmsContext.getPersistenceContext(), aDmsContext.getSession());
            // p.setTargetTableName(this.getTableName(aDmsContext));
            
            fileDb = new DMSFileDTO();
            
            // Setto il fileId ottenuto in altra maniera
            fileDb.setFileid(getFileIdentifier(aDmsContext));
            
            fileDb.setFilelength(aFileMetadata.getContentLength());
            fileDb.setMimetype(aFileMetadata.getContentType());
            fileDb.setFilename(folderFileName);
            fileDb.setFilephysicalpath(getPhysicalName());
            fileDb.setCreationdate(new java.sql.Timestamp(aFileMetadata.getCreationDate().getTime()));
            p.insert(fileDb, aDmsContext.getPersistenceContext().getPersistenceConfigInfo());
            
            storeFile(aDmsContext, fileDb.getFileid(), aFileInputStream, (int)aFileMetadata.getContentLength());
            
            saveMetadata(aDmsContext, fileDb.getFileid(), aFileMetadata);
        }
        catch (Exception e)
        {
            e.printStackTrace(System.err);
            throw new DMSException(e);
        }
        finally
        {
        }
        
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
    	DMSFileMetadata metadata = null;
    	
        DMSFileDTO fileDb = getFileDataBean(aDmsContext, fileName);
        if (fileDb != null)
        {
            metadata = augmentMetadata(fileDb, null);
            if (false)
            {
            try
            {
                metadata = loadMetadata(aDmsContext, fileDb.getFileid());
                if (metadata == null)
                    metadata = augmentMetadata(fileDb, null);
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
        }

        return metadata;
    }
    
    @Override
    public void setFileMetadata(DMSContext aDmsContext, String fileName, DMSFileMetadata metadata) throws DMSException
    {
        DMSFileDTO fileDb = getFileDataBean(aDmsContext, fileName);
        try
        {            
            metadata = augmentMetadata(fileDb, metadata);
            this.saveMetadata(aDmsContext, fileDb.getFileid(), metadata);
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
    
    @Override
	public long getFileContent(DMSContext aDmsContext, String aFileName, OutputStream anOutputStream) throws DMSException
	{
		DMSFileDTO dto = null;
		try
		{
			DMSFilePersistence p = DMSFilePersistence
							.createPersistenceObject(aDmsContext.getPersistenceContext(), aDmsContext.getSession());
			// p.setTargetTableName(this.getTableName(aDmsContext));
			dto = p.selectByFilenameFolderphysicalpath(aFileName, this.getPhysicalName(), aDmsContext.getPersistenceContext().getPersistenceConfigInfo());
			if (dto != null)
			{
				p.streamFilebodyByFileid(anOutputStream, dto.getFileid(), aDmsContext);
				return dto.getFilelengthAsLong();
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

		return 0L;
	}
 
    /**
     * Funzione di utilita' che arricchisce il dato a partire dal contenuto del record database
     * @param aFileDataBean
     * @param aFileMetadata
     * @return
     */
    private DMSFileMetadata augmentMetadata(DMSFileDTO aFileDataBean, DMSFileMetadata aFileMetadata)
    {
        if (aFileMetadata == null)
        {
            aFileMetadata = new DMSFileMetadata();
        }
        aFileMetadata.setFileName(aFileDataBean.getFilename());
        aFileMetadata.setContentLength(aFileDataBean.getFilelength());
        aFileMetadata.setContentType(aFileDataBean.getMimetype());
        aFileMetadata.setCreationDate(aFileDataBean.getCreationdate());
        return aFileMetadata;
    }


    private void storeFile(DMSContext aDmsContext, String aFileId, InputStream finp, int contentLength) throws IOException, DMSException
    {        
        DMSFilePersistence p = DMSFilePersistence.createPersistenceObject(aDmsContext.getPersistenceContext(), aDmsContext.getSession());
        // fileEnt.setTargetTableName(this.getTableName(aDmsContext));
        System.out.println("Target Table: " + this.getTableName(aDmsContext));
        p.storeFilebodyByFileid(finp, aFileId, contentLength, aDmsContext.getPersistenceContext().getPersistenceConfigInfo());
    }
    
    /**
     * Questa funzione provvede a recuperare il databean associato al file in questione 
     * @param aFileName
     * @return
     * @throws DMSException
     */
    private DMSFileDTO getFileDataBean(DMSContext aDmsContext, String aFileName) throws DMSException
    {
    	DMSFileDTO dto = null;
        try
        {
            DMSFilePersistence p = DMSFilePersistence.createPersistenceObject(aDmsContext.getPersistenceContext(), aDmsContext.getSession()); 
            // fileEnt.setTargetTableName(this.getTableName(aDmsContext));
            dto = p.selectByFilenameFolderphysicalpath(aFileName, this.getPhysicalName(), aDmsContext.getPersistenceContext().getPersistenceConfigInfo());            
        }
        catch (Exception e)
        {
            e.printStackTrace(System.err);
            throw new DMSException(e);
        }
        finally
        {
        }

        return dto;
    }

    /**
     * Funzione che accede al device, recupera il nome fisico del device e
     * costruisce il riferimento per la base dati.
     * 
     * @return
     * @throws DMSException
     */
    public String getConnectionManagerInstanceName(DMSContext aDmsContext) throws DMSException
    {
        DMSDeviceAlias alias = getDevice().getAlias(aDmsContext);
        DMSDBDeviceUrl deviceUrl = (DMSDBDeviceUrl)alias.getDevphysicalnameAsUrl();
              
        return deviceUrl.getPoolName();
    }

    /**
     * Funzione che accede al device, recupera il nome fisico del device e
     * costruisce il riferimento per la tabella.
     *
     * @return
     * @throws DMSException
     */
    public String getTableName(DMSContext aDmsContext) throws DMSException
    {
        DMSDeviceAlias alias = getDevice().getAlias(aDmsContext);
        DMSDBDeviceUrl deviceUrl = (DMSDBDeviceUrl)alias.getDevphysicalnameAsUrl();
              
        return deviceUrl.getDataTableName();             
    }

    /**
     * Funzione che accede al device, recupera il nome fisico del device e
     * costruisce il riferimento per la tabella dei metadati.
     *
     * @return
     * @throws DMSException
     */
    public String getMetadataTableName(DMSContext aDmsContext) throws DMSException
    {
        DMSDeviceAlias alias = getDevice().getAlias(aDmsContext);
        DMSDBDeviceUrl deviceUrl = (DMSDBDeviceUrl)alias.getDevphysicalnameAsUrl();
              
        return deviceUrl.getMetadataTableName();             
    }

    /**
     * Funzione che provvede alla persistenza delle informazioni di metadata di un file. La funzione 
     * provvede prima di tutto alla eliminazione di tutte le proprieta' presenti e poi alla loro inizializzazione.
     * 
     * @param aFileMetadata
     * @param aMetadataFile
     * @throws DMSException
     * @throws EntityException 
     * @throws DMSException 
     */
    private void saveMetadata(DMSContext aDmsContext, String aFileId, DMSFileMetadata aFileMetadata) throws DMSException
    {
    	return ;
    	
 // Metadata are not saved...
//        DMSFilePropertyPersistence p = DMSFilePropertyPersistence.createPersistenceObject(aDmsContext.getPersistenceContext(), aDmsContext.getSession()); 
//        // p.setTargetTableName(getMetadataTableName(aDmsContext));
//        
//        p.deleteByFileid(aFileId, aDmsContext.getPersistenceContext().getPersistenceConfigInfo());
//        
//        if (aFileMetadata != null)
//        {
//            Enumeration en = aFileMetadata.propertyNames();
//            
//            if (en != null)
//            {
//                DMSFilePropertyDTO pDBean = new DMSFilePropertyDTO();
//                for( ; en.hasMoreElements(); )
//                {
//                    String pName = (String)en.nextElement();
//                    String pVal  = aFileMetadata.getProperty(pName, null);
//                    
//                    pDBean.setFileid(aFileId);
//                    pDBean.setPropertyname(pName);
//                    pDBean.setPropertyvalue(pVal);
//                    
//                    p.insert(pDBean, aDmsContext.getPersistenceContext().getPersistenceConfigInfo());
//                }
//            }
//        }
    }

    /**
     * Funzione che provvede allalettura delle informazioni di metadata di un file.
     * 
     * @param aFileMetadata
     * @param aMetadataFile
     * @throws DMSException
     * @throws EntityException 
     * @throws DMSException 
     */
    private DMSFileMetadata loadMetadata(DMSContext aDmsContext, String aFileId) throws DMSException
    {
        DMSFileMetadata aFileMetadata = new DMSFileMetadata();

        if (false)
        {
        DMSFilePropertyPersistence p = DMSFilePropertyPersistence.createPersistenceObject(aDmsContext.getPersistenceContext(), aDmsContext.getSession()); 
        // p.setTargetTableName(getMetadataTableName(aDmsContext));

        List<DMSFilePropertyDTO> listOfProps = p.selectByFileid(aFileId, aDmsContext.getPersistenceContext().getPersistenceConfigInfo());
        if (listOfProps != null)
        {
            for( DMSFilePropertyDTO dto : listOfProps )
            {
                aFileMetadata.setProperty(dto.getPropertyname(), dto.getPropertyvalue());
            }
        }
        }
        
        return aFileMetadata;
    }

    @Override
    public DMSFileDataTableAdapter getFiles(DMSContext aDmsContext, DMSFileSystemUrl aFolderUrl, String sEcho, int iDisplayStart, int iDisplayLength, boolean countElements) throws DMSException
    {    	    	
        try
        {
        	// DMSFileDAO
            DMSFilePersistence p = DMSFilePersistence.createPersistenceObject(aDmsContext.getPersistenceContext(), aDmsContext.getSession());
            DMSFileDataTableAdapter dt = p.selectFilesInFolder(getPhysicalName(), aDmsContext.getPersistenceContext().getPersistenceConfigInfo(), sEcho, iDisplayStart, iDisplayLength, countElements);
            
            // TODO
        	// DMSFileDAO queryObject = new DMSFileDAO(aFolderUrl);
            // queryObject.setTargetTableName(getTableName(aDmsContext));
            
            return dt;
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

	@Override
	public File getFile(DMSContext aDmsContext, String aFileName) throws DMSException
	{
		if (aFileName == null)
			return null;
		
		File tempFile = null;
		FileOutputStream outputStream = null;
		try
		{
			tempFile = File.createTempFile(aFileName, ".tmp");
			outputStream = new FileOutputStream(tempFile);
			getFileContent(aDmsContext, aFileName, outputStream);
			
			return tempFile;
		}
		catch (Exception ex)
		{
            ex.printStackTrace();
            throw new DMSException(ex.getMessage());
		}
		finally
		{
			SystemUtils.close(outputStream);
		}				

	}


}

package org.r3.db.dms.model;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.r3.db.dms.file.DMSFileDTO;
import org.r3.db.dms.model.SimpleDMSConstants.DMSFolderAddFileMode;
import org.r3.system.util.ContentTypeUtil;

public class DMSFile extends DMSFileDTO implements DMSContentStreamer
{
  
        
    public DMSFile()
    {    	
    }
    
    public DMSFile(DMSFileSystemUrl aUrl)
    {
        super();
        setFileUrl(aUrl);
    }
    
    public DMSFileMetadata getMetadata(DMSContext aDmsContext) throws DMSException
    {
        if (!exists(aDmsContext))  return null;
        
        DMSStorageBucket bucket = getStorageBucket(aDmsContext);
        return bucket.getFileMetadata(aDmsContext, getName());
    }

    public DMSFileMetadata getCopyOfMetadata(DMSContext aDmsContext) throws DMSException, CloneNotSupportedException
    {
        if (!exists(aDmsContext))  return null;
        
        DMSStorageBucket bucket = getStorageBucket(aDmsContext);
        DMSFileMetadata  metadata = bucket.getFileMetadata(aDmsContext, getName()); 
        return metadata.clone();
    }

    /**
     * Questa funzione procede ad aggiornare i metadati collegati al file.
     * @throws DMSException
     */
    public void setMetadata(DMSContext aDmsContext, DMSFileMetadata metadata) throws DMSException
    {
        if (exists(aDmsContext)) 
        {
            DMSStorageBucket bucket = getStorageBucket(aDmsContext);
            bucket.setFileMetadata(aDmsContext, getName(), metadata);            
        }
    }
    
    public File getFile(DMSContext aDmsContext) throws DMSException
    {
    	if (!exists(aDmsContext)) 
            return null;
       
       DMSStorageBucket bucket = getStorageBucket(aDmsContext);
       return bucket.getFile(aDmsContext, getName());
    }
    
    public DMSFolder getFolder(DMSContext aDmsContext) throws DMSException
    {
        DMSFolder theFolder = new DMSFolder(aDmsContext, getFileUrl().getParent());
        return theFolder;
    }
    
    public boolean exists(DMSContext aDmsContext) throws DMSException
    {
        DMSStorageBucket bucket = getStorageBucket(aDmsContext);
        if (bucket != null && bucket.fileExists(aDmsContext, getName()))
                return true;
        
        return false;
    }
    
    public String getName()
    {
        return getFileUrl().getName();
    }

    public long streamContent(DMSContext aDmsContext, OutputStream anOutputStream) throws DMSException
    {
        if (!exists(aDmsContext)) 
             return 0;
        
        DMSStorageBucket bucket = getStorageBucket(aDmsContext);
        return bucket.getFileContent(aDmsContext, getName(), anOutputStream);
     }
    
    private DMSStorageBucket getStorageBucket(DMSContext aDmsContext) throws DMSException
    {
        DMSFolder parentFolder = getFolder(aDmsContext);
        if (parentFolder == null || !parentFolder.exists() || !parentFolder.isBound())
        {
            return null;
        }
        
        return parentFolder.getStorageBucket();      
    }
    
    public String getStreamMimeType()
    {        
        return ContentTypeUtil.findMimeType(getName());
    }

    public String getStreamName(DMSContext aDmsContext)
    {
        DMSFileMetadata fileMetadata = null;
        try
        {
            fileMetadata = getMetadata(aDmsContext);
        }
        catch (DMSException e)
        {
            e.printStackTrace();
        }
        
        if (fileMetadata != null)
                  return fileMetadata.getFileName();

        return getName();
    }

    public long getStreamLastModified(DMSContext aDmsContext)
    {
        DMSFileMetadata fileMetadata = null;
        try
        {
            fileMetadata = getMetadata(aDmsContext);
        }
        catch (DMSException e)
        {
            e.printStackTrace();
        }
        
        if (fileMetadata != null)
        {
            java.util.Date streamDate = fileMetadata.getCreationDate();
            if (streamDate != null)
                return streamDate.getTime();
        }           
        
        return -1;
    }
    
    public int getStreamSize(DMSContext aDmsContext)
    {
        DMSFileMetadata fileMetadata = null;
        try
        {
            fileMetadata = getMetadata(aDmsContext);
        }
        catch (DMSException e)
        {
            e.printStackTrace();
        }

        if (fileMetadata != null)
            return (int)fileMetadata.getContentLength();

        return 0;
    }    

    public void delete(DMSContext aDmsContext) throws DMSException
    {
        DMSStorageBucket bucket = getStorageBucket(aDmsContext);
        bucket.delete(aDmsContext, getName());        
    }
    
    public void exportFileTo(DMSContext aDmsContext, File outFile) throws DMSException
    {
        FileOutputStream fout = null;
        try
        {
            fout = new FileOutputStream(outFile);
            streamContent(aDmsContext, fout);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new DMSException(e.getMessage());
        }
        finally
        {
            if (fout != null)
                try
                {
                    fout.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
        }
    }
    
	public DMSFile copyTo(DMSContext aDmsContext, DMSFolder targetFolder, String targetName, DMSFolderAddFileMode addMode) throws DMSException
	{
		File tempFile = null;
		try
		{
			tempFile = File.createTempFile(getName(), ".tmp");
			exportFileTo(aDmsContext, tempFile);
			
			DMSFileMetadata fileMetadata = getCopyOfMetadata(aDmsContext);
	        fileMetadata.setCreationDate();
	        
			if (targetName != null)
	            fileMetadata.setFileName(targetName);

			DMSFile copiedFile = targetFolder.addFile(aDmsContext, tempFile, fileMetadata, addMode);
			return copiedFile;
		}
		catch (Exception ex)
		{
            ex.printStackTrace();
            throw new DMSException(ex.getMessage());
		}
		finally
		{
			if (tempFile != null)
			{
				tempFile.delete();
			}
		}				
	}

}

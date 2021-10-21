package org.r3.system.storage;

import java.io.ByteArrayInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.dms.model.DMSContext;
import org.r3.db.dms.model.DMSException;
import org.r3.db.dms.model.DMSFile;
import org.r3.db.dms.model.DMSFileMetadata;
import org.r3.db.dms.model.DMSFileSystemUrl;
import org.r3.db.dms.model.DMSFolder;
import org.r3.db.dms.model.SimpleDMSConstants.DMSFolderAddFileMode;

public class DMSStorageManager extends StorageManager
{
	private DMSContext dmsContext;
	
	public DMSStorageManager(PersistenceContext pcfg, SqlSession aSession, StorageManagerConfig config)
	{
		dmsContext = new DMSContext(pcfg, aSession);
		setStorageManagerConfig(config);
	}

	@Override
	public StorageObject newStorageObjectInstance()
	{		
		return new DMSStorageObject();
	}

	@Override
	public StorageObject put(Path aFolderPath, StorageObject anObject) throws StorageException
	{
		DMSStorageObject dmsStorageObject = (DMSStorageObject) anObject;
		try
		{
			DMSFolder dmsFolder = getFolder4Path(dmsContext, Paths.get(getStorageManagerConfig().getContainer()).resolve(aFolderPath));

			DMSFileMetadata theFileMetadata = dmsStorageObject.getFileMetadata(null);
			DMSFile theFile = null;

			theFile = dmsFolder.addFile(dmsContext, new ByteArrayInputStream(anObject.getData()), theFileMetadata, DMSFolderAddFileMode.NEWNAMEIFPRESENT);

			anObject.setName(theFileMetadata.getFileName());
			anObject.setObjectid(theFile.getFileid());
			dmsStorageObject.setDmsUrl(theFile.getFileUrl().getUrl());
		}
		catch (DMSException dmsException)
		{
			dmsException.printStackTrace();
			throw new StorageException(dmsException);
		}

		return dmsStorageObject;
	}

	@Override
	public StorageObject get(StorageUrl aUrl)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	private static DMSFolder getFolder4Path(DMSContext dmsContext, Path aPath) throws DMSException
	{
		DMSFileSystemUrl url = new DMSFileSystemUrl("/");
        DMSFolder rootFolder = new DMSFolder(dmsContext, url);

        DMSFolder documentFolder = null;
        if (rootFolder.exists())
        {   	    	
        	documentFolder = rootFolder.makeFoldersBoundToParent(dmsContext, aPath);
        }
		
        return documentFolder;
	}

}

package org.r3.ws.system.dms;



import java.io.File;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.DTOBase;
import org.r3.db.PersistenceContext;
import org.r3.db.dms.model.DMSContext;
import org.r3.db.dms.model.DMSException;
import org.r3.db.dms.model.DMSFileSystemUrl;
import org.r3.db.dms.model.DMSFolder;
import org.r3.db.dms.model.DMSStorageBucket;
import org.r3.db.dms.model.SimpleDMSConstants.DMSFolderAddFileMode;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class TestAddFile  extends ServicePattern
{
    
	public TestAddFile(ServletContext ctx,  ServiceEnvironment serviceEnvironment)
	{
		super(ctx, serviceEnvironment);
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)  throws ServicePatternException
	{
        DMSContext dmsContext = new DMSContext(pcfg, aSession);	
        
        DMSFileSystemUrl url;
		try
		{
			url = new DMSFileSystemUrl("/DB");
	        DMSFolder folder = new DMSFolder(dmsContext, url);
	        
	        if (folder.exists())
	        {
	        	System.out.println("Folder is Bound: " + folder.isBound());
	        	DMSStorageBucket storageBucket = folder.getStorageBucket();
	        	if (!storageBucket.exists(dmsContext))
	        		storageBucket.mkdir(dmsContext);
	        	
	        	DMSFolder docFolder = getDocumentFolder(dmsContext, folder, "DOC0000007235");
	        		        	
	        	docFolder.addFile(dmsContext, new File("c:/tmp/DFL000000002712.JPG"), null, DMSFolderAddFileMode.NEWNAMEIFPRESENT);
	        }
		}
		catch (DMSException e)
		{
			e.printStackTrace();
			throw new ServicePatternException(e.getMessage());
		}
        
		return null;
	}

    protected DMSFolder getDocumentFolder(DMSContext dmsContext, DMSFolder rootFolder, String aDocumentId) throws DMSException
    {
    	int seqNumber = DTOBase.getNumberFromGWFSequenceId(aDocumentId);
    	int level1FolderIndex = (seqNumber >> 12) & 0x3F;
    	int level2FolderIndex = (seqNumber >> 6) & 0x3f;
    	
    	String[] documentFolderRelativePath = new String[] { 
    			new StringBuilder().append("DFLD").append(level1FolderIndex).toString(),
    			new StringBuilder().append("DFLD").append(level2FolderIndex).toString(),
    			aDocumentId
    	};
    	
    	DMSFolder documentFolder = rootFolder.makeFoldersBoundToParent(dmsContext, documentFolderRelativePath);

        return documentFolder;
    }

}

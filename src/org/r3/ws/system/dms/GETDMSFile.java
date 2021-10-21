package org.r3.ws.system.dms;


import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.ws.rs.core.CacheControl;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.DTOBase;
import org.r3.db.PersistenceContext;
import org.r3.db.dms.model.DMSContext;
import org.r3.db.dms.model.DMSException;
import org.r3.db.dms.model.DMSFile;
import org.r3.db.dms.model.DMSFileSystemUrl;
import org.r3.db.dms.model.DMSFolder;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.util.ContentTypeUtil;

public class GETDMSFile extends ServicePattern
{
    private String fileDmsUrl;
    private String guessedFileName;
    private String mimeType;
    private boolean forceDownload;
    
	public GETDMSFile(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aFileDmsUrl, boolean aForceDownloadFlag)
	{
		super(ctx, serviceEnvironment);
		if (aFileDmsUrl.startsWith("DMS_FILE"))
		       fileDmsUrl = aFileDmsUrl;
		else   fileDmsUrl = "/" + aFileDmsUrl;
		
		mimeType = ContentTypeUtil.findMimeType(aFileDmsUrl);
		guessedFileName = ContentTypeUtil.guessFileName(aFileDmsUrl, mimeType);
		forceDownload = aForceDownloadFlag;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)  throws ServicePatternException
	{        
		DMSContext dmsContext = new DMSContext(pcfg, aSession);
		
		File actualFile = null;
		try
		{
			DMSFile f = new DMSFile(new DMSFileSystemUrl(fileDmsUrl));
			actualFile = f.getFile(dmsContext);
		}
		catch (DMSException e)
		{
			e.printStackTrace();
		}
		
		return actualFile;
		// return new File("c:/tmp/37089690-Twp-Cdc-Cookbook-0206.pdf");
	}

	@Override
	protected String getMediaType()
	{
		return mimeType;
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

	@Override
	protected Map<String, String> returningHeaders()
	{
		if (forceDownload)
		{
		    Map<String, String> hs = new HashMap<String, String>(); 	
		    hs.put("Content-Transfer-Encoding", "binary");
		    hs.put("Accept-Ranges", "bytes");
		    hs.put("Content-Encoding", "none");
		    hs.put("Content-Disposition", "attachment; filename=" + guessedFileName);
		    
		    System.out.println("Returning Headers");
		    return hs;
		}
		
		return super.returningHeaders();
	}

	@Override
	protected CacheControl getCacheControl()
	{
		CacheControl cc = new CacheControl();
		cc.setPrivate(true);		
		return null;
	}
}

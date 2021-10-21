package org.r3.ws.bbs.topic;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.bbs.bbsthread.BBSThreadPersistence;
import org.r3.db.bbs.bbsthreadnode.BBSThreadNodePersistence;
import org.r3.db.bbs.bbstopic.BBSTopicDTO;
import org.r3.db.bbs.bbstopic.BBSTopicPersistence;
import org.r3.db.dms.folder.DMSFolderDTO.FolderStatus;
import org.r3.db.dms.model.DMSContext;
import org.r3.db.dms.model.DMSException;
import org.r3.db.dms.model.DMSFolder;
import org.r3.db.dms.model.DMSFolderHelper;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class DELETEBBSTopic extends ServicePattern
{
    private String topicId;
    
	public DELETEBBSTopic(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aTopicId)
	{
		super(ctx, serviceEnvironment);
		topicId = aTopicId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		BBSTopicPersistence p = BBSTopicPersistence.createPersistenceObject(pcfg, aSession);
		BBSTopicDTO topicDTO = p.selectBySiteTopicid(senv.getRequestSiteId(), topicId, pcfg.getPersistenceConfigInfo());

		if (topicDTO != null)
		{
            if (topicDTO.getCardid() != null)
            {
			try
			{
				DMSContext dmsContext = new DMSContext(pcfg, aSession);

				DMSFolder f = DMSFolderHelper.getCMSCardFolder(dmsContext, getServiceEnvironment().getRequestSiteId(), topicDTO.getCardid(), true);
				if (f != null) 
					f.setEnabled(dmsContext, FolderStatus.sys_recdeleted);
			}
			catch (DMSException e)
			{
				e.printStackTrace();
			}
            }

    		BBSThreadNodePersistence pthreadnode = BBSThreadNodePersistence.createPersistenceObject(pcfg, aSession);
    		pthreadnode.deleteBySiteTopicid(senv.getRequestSiteId(), topicId, pcfg.getPersistenceConfigInfo());

    		BBSThreadPersistence pthread = BBSThreadPersistence.createPersistenceObject(pcfg, aSession);
            pthread.deleteBySiteTopicid(senv.getRequestSiteId(), topicId, pcfg.getPersistenceConfigInfo());
            
			p.deleteBySiteTopicid(senv.getRequestSiteId(), topicId, pcfg.getPersistenceConfigInfo());
		}
		
		return RestServiceDTO.SuccessDTO;
	}

}

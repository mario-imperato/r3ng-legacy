package org.r3.ws.wbs;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.bbs.bbstopic.BBSTopicDTO;
import org.r3.db.bbs.bbstopic.BBSTopicPersistence;
import org.r3.db.wbs.wbs.WBSDTO;
import org.r3.db.wbs.wbs.WBSPersistence;
import org.r3.db.wbs.wbsactor.WBSActorDTO;
import org.r3.db.wbs.wbsactor.WBSActorDTO.WBSActorRole;
import org.r3.db.wbs.wbsactor.WBSActorPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTWBS extends ServicePattern
{
	private String wbsid;
	private WBSActionForm actionForm;
    
    
	public PUTWBS(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aWbsId, WBSActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		wbsid = aWbsId;
		actionForm = anActionForm;		
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		WBSPersistence p = WBSPersistence.createPersistenceObject(pcfg, aSession);

		WBSDTO dto1 = p.selectBySiteWbsid(senv.getRequestSiteId(), wbsid, pcfg.getPersistenceConfigInfo());
		if (dto1 != null)
		{
			dto1 = actionForm.getDTO4Update(dto1);

			if (actionForm.isDiscussionEnabled())
			{
				String topicId = null;
				
			    BBSTopicPersistence bbstopicp = BBSTopicPersistence.createPersistenceObject(pcfg, aSession);
			    BBSTopicDTO topicDTO = null;
			    
			    if (dto1.getBbstopicid() != null)
			    {
			    	topicId = dto1.getBbstopicid();
			    }
			    else
			    {
			    	topicId = dto1.getWbsid();			    	
			    }
			    
			    topicDTO = bbstopicp.selectBySiteTopicid(senv.getRequestSiteId(), topicId, pcfg.getPersistenceConfigInfo());
			    if (topicDTO == null)
			    {
			        topicDTO = actionForm.getTopicDTO4Insert(senv.getRequestSiteId(), topicId);
			        bbstopicp.insert(topicDTO, pcfg.getPersistenceConfigInfo());
			    }
			    
			    dto1.setBbstopicid(topicId);
			}	
			else dto1.setBbstopicid(null);
		}
		
		p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());

		WBSActorPersistence wbsap = WBSActorPersistence.createPersistenceObject(pcfg, aSession);
		wbsap.deleteManagingActorsBySiteWbsid(senv.getRequestSiteId(), dto1.getWbsid(), pcfg.getPersistenceConfigInfo());
		
		WBSActorDTO wbsactorDTO = null;
		if (actionForm.getWbsmanager() != null)
		{
			wbsactorDTO = new WBSActorDTO();
			wbsactorDTO.setSite(senv.getRequestSiteId());
			wbsactorDTO.setActorid(actionForm.getWbsmanager());
			wbsactorDTO.setActorrole(WBSActorRole.manager.toString());
			wbsactorDTO.setWbsid(dto1.getWbsid());
			wbsap.insert(wbsactorDTO, pcfg.getPersistenceConfigInfo());
		}
		
		if (actionForm.getWbscoach() != null)
		{
			wbsactorDTO = new WBSActorDTO();
			wbsactorDTO.setSite(senv.getRequestSiteId());
			wbsactorDTO.setActorid(actionForm.getWbscoach());
			wbsactorDTO.setActorrole(WBSActorRole.coach.toString());
			wbsactorDTO.setWbsid(dto1.getWbsid());
			wbsap.insert(wbsactorDTO, pcfg.getPersistenceConfigInfo());
		}
		
		if (actionForm.getWbssponsor() != null)
		{
			wbsactorDTO = new WBSActorDTO();
			wbsactorDTO.setSite(senv.getRequestSiteId());
			wbsactorDTO.setActorid(actionForm.getWbssponsor());
			wbsactorDTO.setActorrole(WBSActorRole.sponsor.toString());
			wbsap.insert(wbsactorDTO, pcfg.getPersistenceConfigInfo());
		}
		
		return dto1;
	}

}

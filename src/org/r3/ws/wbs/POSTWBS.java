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
import org.r3.db.wbs.wbsnode.WBSNodeDTO;
import org.r3.db.wbs.wbsnode.WBSNodePersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTWBS extends ServicePattern
{
	private WBSActionForm actionForm;

	public POSTWBS(ServletContext ctx, ServiceEnvironment serviceEnvironment, WBSActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		WBSPersistence p = WBSPersistence.createPersistenceObject(pcfg, aSession);

		WBSDTO dto1 = actionForm.getDTO4Insert(senv.getRequestSiteId());
		p.insert(dto1, pcfg.getPersistenceConfigInfo());

		WBSNodePersistence wbn = WBSNodePersistence.createPersistenceObject(pcfg, aSession);
		WBSNodeDTO dto2 = actionForm.getDTO4WBSRoot(senv.getRequestSiteId(), dto1.getWbsid());
		wbn.insert(dto2, pcfg.getPersistenceConfigInfo());
		
		if (actionForm.isDiscussionEnabled())
		{
			String topicId = dto1.getWbsid();
			
		    BBSTopicPersistence bbstopicp = BBSTopicPersistence.createPersistenceObject(pcfg, aSession);
		    BBSTopicDTO topicDTO = bbstopicp.selectBySiteTopicid(senv.getRequestSiteId(), dto1.getWbsid(), pcfg.getPersistenceConfigInfo());
		    if (topicDTO == null)
		    {
			    topicDTO = actionForm.getTopicDTO4Insert(senv.getRequestSiteId(), topicId);
			    bbstopicp.insert(topicDTO, pcfg.getPersistenceConfigInfo());
		    }
		    
		    dto1.setBbstopicid(topicDTO.getTopicid());		
		    p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());
		}
		
		WBSActorPersistence wbsap = WBSActorPersistence.createPersistenceObject(pcfg, aSession);
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

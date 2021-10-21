package org.r3.ws.sailevent.application;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.DTOBase;
import org.r3.db.PersistenceContext;
import org.r3.db.dms.model.DMSContext;
import org.r3.db.dms.model.DMSFolder;
import org.r3.db.dms.model.DMSFolderHelper;
import org.r3.db.sailevent.application.SailApplicationDTO;
import org.r3.db.sailevent.application.SailApplicationPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTSailApplication extends ServicePattern
{
    private String userId;
    
	public POSTSailApplication(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aUserId)
	{
		super(ctx, serviceEnvironment);
		
		if (aUserId != null)
		     userId = aUserId;
		else userId = serviceEnvironment.getUserProfile().getUserid();
			
	}

	// 25/01/2017 14:32:18 - Inserito il rethrow della ServicePatternException
	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		SailApplicationPersistence p = SailApplicationPersistence.createPersistenceObject(pcfg, aSession);

		SailApplicationDTO dto1 = getDTO4Insert(senv.getRequestSiteId(), userId);
		
	    p.insert(dto1, pcfg.getPersistenceConfigInfo());

	    DMSContext dmsContext = new DMSContext(pcfg, aSession);	
	    try
		{
			DMSFolder f = DMSFolderHelper.getSailApplicationFolder(dmsContext, senv.getRequestSiteId(), dto1.getApplicationid(), true);
			f = DMSFolderHelper.getSailApplicationFolder(dmsContext, getServiceEnvironment().getRequestSiteId(), dto1.getApplicationid(), false);	
			
			dto1.setDmsfolderurl(f.getFolderUrl().getUrl());
			p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new ServicePatternException(e);
		}	    
	    
		return dto1;
	}

	private SailApplicationDTO getDTO4Insert(String anEventId, String aUserid)
	{
		SailApplicationDTO dto = new SailApplicationDTO();
		dto.setEventid(anEventId);
		dto.setUserid(aUserid);
		dto.setCompletionstatus(SailApplicationDTO.CompletionStatus.r3ea_empty.toString());
		dto.setVerificationstatus(SailApplicationDTO.VerificationStatus.r3ea_unknown.toString());
		dto.setCreatetimestamp(DTOBase.currentTimestamp());
		return  dto;
	}
}

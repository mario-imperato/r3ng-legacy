package org.r3.ws.cms.card;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.card.CardDTO;
import org.r3.db.cms.card.CardPersistence;
import org.r3.db.dms.folder.DMSFolderDTO.FolderStatus;
import org.r3.db.dms.model.DMSContext;
import org.r3.db.dms.model.DMSFolder;
import org.r3.db.dms.model.DMSFolderHelper;
import org.r3.db.system.script.RunSqlPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.util.velocity.VelocityTemplateModel;
import org.r3.ws.cms.CardServicePattern;

public class DELETECard extends CardServicePattern
{    

	private VelocityTemplateModel velocityEngine;
	
	public DELETECard(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aSite, String aCardId)
	{
		super(ctx, serviceEnvironment, aSite, null, aCardId);
				
		velocityEngine = VelocityTemplateModel.getVelocityPlugInModel(ctx);	
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		CardPersistence p = CardPersistence.createPersistenceObject(pcfg, aSession);
		CardDTO dto = p.selectBySiteCardid(site, cardId, pcfg.getPersistenceConfigInfo());
		
		if (dto != null)
		{
	    try
		{
	    	DMSContext dmsContext = new DMSContext(pcfg, aSession);		    	
	    	
	    	DMSFolder f = DMSFolderHelper.getCMSCardFolder(dmsContext, site, dto.getCardid(), true);
	    	if (f != null) 
				f.setEnabled(dmsContext, FolderStatus.sys_recdeleted);	    	
	    	
			f = DMSFolderHelper.getCMSCardFolder(dmsContext, site, dto.getCardid(), false);
			if (f != null) 
				f.setEnabled(dmsContext, FolderStatus.sys_recdeleted);			
			
			RunSqlPersistence scriptPersistence = 
			RunSqlPersistence.createPersistenceObject(aSession, velocityEngine, "CardDeletionSQLScript");
							
			scriptPersistence.addParameter("cardDTO", dto);							
			scriptPersistence.execute(pcfg, aSession);			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		}
	    
		return RestServiceDTO.SuccessDTO;
	}
}

package org.r3.ws.cms.card;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.DTOBase;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.card.CardDTO;
import org.r3.db.cms.card.CardPersistence;
import org.r3.db.cms.cardchannel.CardChannelPersistence;
import org.r3.db.cms.carddescr.CardDescrDTO;
import org.r3.db.cms.carddescr.CardDescrPersistence;
import org.r3.db.cms.cardgroup.CardGroupPersistence;
import org.r3.db.dms.model.DMSContext;
import org.r3.db.dms.model.DMSFolder;
import org.r3.db.dms.model.DMSFolderHelper;
import org.r3.db.system.script.RunSqlPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.util.velocity.VelocityTemplateModel;

public class POSTCard extends ServicePattern
{
	private VelocityTemplateModel velocityEngine;
    private CardActionForm actionForm;
    
	public POSTCard(ServletContext ctx,  ServiceEnvironment serviceEnvironment, CardActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		velocityEngine = VelocityTemplateModel.getVelocityPlugInModel(ctx);		
	}

	// 25/01/2017 14:32:18 - Inserito il rethrow della ServicePatternException
	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		CardPersistence p = CardPersistence.createPersistenceObject(pcfg, aSession);
		CardDTO cardDTO = null;
		
		String cardId = actionForm.getCardid();
		if (cardId != null)
		{
		   // Non accetto codici scheda con Id che possono essere confusi per Id di dominio.
		   if (CardDTO.isDomainScope(cardId))
			   return new RestServiceDTO(Status.fail, "RESTDTO_ERROR_358", "Codice Scheda Non Ammissibile Per il Contesto corrente");
			   
		   cardDTO = p.selectBySiteCardid(getServiceEnvironment().getRequestSiteId(), cardId, pcfg.getPersistenceConfigInfo());
		}
		
		if (cardDTO != null)
			return new RestServiceDTO(Status.fail, "RESTDTO_ERROR_357", "Codice Scheda gia' presenta a sistema");
				
		CardDTO dto1 = actionForm.getDTO4Insert(getServiceEnvironment().getRequestSiteId());		
	    p.insert(dto1, pcfg.getPersistenceConfigInfo());
	    
	    CardChannelPersistence channelPersistence = CardChannelPersistence.createPersistenceObject(pcfg, aSession);
	    String[] cardChannelArray = DTOBase.string2Array(actionForm.getPubchannels(), ",");
    	if (cardChannelArray != null)
    	{
             for(String channelId : cardChannelArray)
             {
            	 channelPersistence.insert(channelId, dto1.getSite(), dto1.getCardid(), pcfg.getPersistenceConfigInfo());
             }             
    	}
    		    	    
	    // Inserisco il System Title come titolo per la lingua correntemente usata. Debbo avere almneno un record di descrizione.
	    CardDescrPersistence pDescr = CardDescrPersistence.createPersistenceObject(pcfg, aSession);	
	    CardDescrDTO dtoDescr = actionForm.getDescrDTO4Insert(getServiceEnvironment().getRequestSiteId(), dto1.getCardid(), getServiceEnvironment().getRequestLanguage());
	    pDescr.insert(dtoDescr, pcfg.getPersistenceConfigInfo());
		   
	    CardGroupPersistence gp = CardGroupPersistence.createPersistenceObject(pcfg, aSession);
	    String[] cardGroupArray = actionForm.getCardgroup();
    	if (cardGroupArray != null)
    	{
             for(String groupId : cardGroupArray)
             {
            	 gp.insertCardIntoGroup(senv.getRequestSiteId(), dto1.getCardid(), groupId, pcfg.getPersistenceConfigInfo());
             }
             
    	}
    	
		DMSContext dmsContext = new DMSContext(pcfg, aSession);	
	    try
		{
			DMSFolder f = DMSFolderHelper.getCMSCardFolder(dmsContext, getServiceEnvironment().getRequestSiteId(), dto1.getCardid(), true);
			f = DMSFolderHelper.getCMSCardFolder(dmsContext, getServiceEnvironment().getRequestSiteId(), dto1.getCardid(), false);
			
	    	RunSqlPersistence scriptPersistence = 
			RunSqlPersistence.createPersistenceObject(aSession, velocityEngine, "CardCreationSQLScript");
							
			scriptPersistence.addParameter("cardDTO", dto1);							
			scriptPersistence.execute(pcfg, aSession);			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new ServicePatternException(e);
		}	    

//	    UserRolePersistence p2 = UserRolePersistence.createPersistenceObject(pcfg, aSession);
//	    
//	    String[] ruolipostaliz = actionForm.getRoles();
//	    if (ruolipostaliz != null && ruolipostaliz.length > 0)
//	    {
//	    	UserRoleDTO dto2 = new UserRoleDTO();
//	    	dto2.setUserid(dto1.getUserid());
//	    	for(String r : ruolipostaliz)
//	    	{
//	    		dto2.setRoleid(r);
//	    		p2.insert(dto2, pcfg.getPersistenceConfigInfo());
//	    	}	         
//	    }
    	    
		return dto1;
	}

}

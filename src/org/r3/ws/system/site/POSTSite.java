package org.r3.ws.system.site;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.card.CardDTO;
import org.r3.db.cms.card.CardPersistence;
import org.r3.db.dms.model.DMSContext;
import org.r3.db.dms.model.DMSFolder;
import org.r3.db.dms.model.DMSFolderHelper;
import org.r3.db.mongo.script.JSONHelperFormatter;
import org.r3.db.mongo.script.MongoSimpleImport;
import org.r3.db.sailevent.event.SailEventDTO;
import org.r3.db.sailevent.event.SailEventPersistence;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.script.RunSqlPersistence;
import org.r3.db.system.site.SiteDTO;
import org.r3.db.system.site.SitePersistence;
import org.r3.db.system.siteproperty.SitePropertyDTO;
import org.r3.db.system.siteproperty.SitePropertyPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.util.velocity.VelocityTemplateModel;

public class POSTSite extends ServicePattern
{
	private VelocityTemplateModel velocityEngine;
    private SiteActionForm actionForm;
    
	public POSTSite(ServletContext ctx,  ServiceEnvironment serviceEnvironment, SiteActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		velocityEngine = VelocityTemplateModel.getVelocityPlugInModel(ctx);		
	}

	// 25/01/2017 14:32:18 - Inserito il rethrow della ServicePatternException
	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		SitePersistence p = SitePersistence.createPersistenceObject(pcfg, aSession);
		SiteDTO siteDTO = p.selectBySite(actionForm.getSite(), pcfg.getPersistenceConfigInfo());
		if (siteDTO != null)
			return new RestServiceDTO(Status.fail, "RESTDTO_ERROR_1000", "Codice Sito gia' presente a sistema");
		
		SiteDTO parentSiteDTO = p.selectBySite(getServiceEnvironment().getRequestSiteId(), pcfg.getPersistenceConfigInfo());
		
		// Creo la Card di sistema collegata e assegno l'id al sito.
	    CardPersistence cardPersistence = CardPersistence.createPersistenceObject(pcfg, aSession);
	    CardDTO cardDTO = actionForm.getCMSCardDTO4Insert(getServiceEnvironment().getRequestSiteId());
	    cardPersistence.insert(cardDTO, pcfg.getPersistenceConfigInfo());
	    
		SiteDTO dto1 = actionForm.getDTO4Insert(parentSiteDTO, cardDTO.getCardid());	
		List<SitePropertyDTO> listOfSiteConfigProperties = dto1.retrieveSitePropertiesFromSiteDTO();
		
	    p.insert(dto1, pcfg.getPersistenceConfigInfo());
	    
	    if (listOfSiteConfigProperties != null)
	    {
	    	SitePropertyPersistence spersistence = SitePropertyPersistence.createPersistenceObject(pcfg, aSession);
	    	for(SitePropertyDTO spdto : listOfSiteConfigProperties)
	    	{
	    		spersistence.insert(spdto, pcfg.getPersistenceConfigInfo());
	    	}
	    }
	    
	    SailEventDTO sevDTO = null;
	    if (dto1.isRegatta())
	    {
	    	SailEventPersistence sev = SailEventPersistence.createPersistenceObject(pcfg, aSession);
	    	sevDTO = actionForm.getSailEventDTO4Insert(parentSiteDTO);
	    	sev.insert(sevDTO, pcfg.getPersistenceConfigInfo());	    
	    }
	    
	    // Ottengo un codice del tipo SITE0000000000x. Se tolgo i primi quattro ottengo un numerico. I quattro caratteri poi me li uso variamente
	    // per creare degli id all'interno dello script velocity.
	    String siteSequence = p.getSite_sequence(pcfg.getPersistenceConfigInfo());
	    
		DMSContext dmsContext = new DMSContext(pcfg, aSession);	
	    try
		{
            DMSFolder f = DMSFolderHelper.getSiteFolder(dmsContext, dto1.getSite(), true);
            f = DMSFolderHelper.getSiteFolder(dmsContext, dto1.getSite(), false);
			
            // 20160130 - Questo sembra sbagliato in quanto crea il folder anche sotto il sito di creazione...
			// f = DMSFolderHelper.getCMSCardFolder(dmsContext, getServiceEnvironment().getRequestSiteId(), cardDTO.getCardid(), true);
			// f = DMSFolderHelper.getCMSCardFolder(dmsContext, getServiceEnvironment().getRequestSiteId(), cardDTO.getCardid(), false);
			
			// 
			// BOF CommonSQLScript
			//
			RunSqlPersistence scriptCommonPersistence = 
					RunSqlPersistence.createPersistenceObject(aSession, velocityEngine, dto1.getCommonSQLScriptCreation());
			scriptCommonPersistence.setStatementSeparator(";\\(EOS\\)");
			    	
			scriptCommonPersistence.addParameter("siteDTO", dto1);
					
			if (sevDTO != null)
				scriptCommonPersistence.addParameter("sevEventDTO", sevDTO);
			
			scriptCommonPersistence.addParameter("cardDTO", cardDTO);
			scriptCommonPersistence.addParameter("siteSequence", siteSequence.substring(4));
			scriptCommonPersistence.addParameter("userDTO", senv.getUserProfile());
			scriptCommonPersistence.execute(pcfg, aSession);				
			// 
			// EOF CommonSQLScript
			//
			
			// 
			// BOF SQLScript
			//
	    	RunSqlPersistence scriptPersistence = 
			RunSqlPersistence.createPersistenceObject(aSession, velocityEngine, dto1.getSQLScriptCreation());
	    	scriptPersistence.setStatementSeparator(";\\(EOS\\)");
	    	
			scriptPersistence.addParameter("siteDTO", dto1);
			
			if (sevDTO != null)
			   scriptPersistence.addParameter("sevEventDTO", sevDTO);
			
			scriptPersistence.addParameter("cardDTO", cardDTO);
			scriptPersistence.addParameter("siteSequence", siteSequence.substring(4));
			scriptPersistence.addParameter("userDTO", senv.getUserProfile());
			scriptPersistence.execute(pcfg, aSession);					
			// 
			// EOF SQLScript
			//			
			
			// 
			// BOF Mongo Insert
			//
		    if (pcfg.isMongoDbAvailable())
		    {
		    	MongoSimpleImport simpleImport = MongoSimpleImport.createPersistenceObject(velocityEngine, "MongoSiteCollectionScript_common");
		    	simpleImport.setStatementSeparator(";\\(EOS\\)");
		    	simpleImport.addParameter("siteDTO", dto1);
		    	simpleImport.addParameter("userDTO", senv.getUserProfile());
		    	simpleImport.addParameter("jsonHelper", new JSONHelperFormatter());	
				simpleImport.execute(pcfg.getMongoPersistenceContext());
		    }
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new ServicePatternException(e);
		}	    
    	    
	    LUTManager.getLUTManager().invalidateLUT(LUTName.site);
	    LUTManager.getLUTManager().invalidateLUT(LUTName.userprofile);
	    LUTManager.getLUTManager().invalidateLUT(LUTName.cms_page);
	    LUTManager.getLUTManager().invalidateLUT(LUTName.cms_attachtype);
	    
		return dto1;
	}

}

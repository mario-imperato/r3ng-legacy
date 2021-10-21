package org.r3.ws.system.site;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.dms.model.DMSContext;
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
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.util.velocity.VelocityTemplateModel;

public class PUTSite extends ServicePattern
{
	private VelocityTemplateModel velocityEngine;
	private String theSite;
    private SiteActionForm actionForm;
    
	public PUTSite(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aSite, SiteActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		theSite = aSite;
		velocityEngine = VelocityTemplateModel.getVelocityPlugInModel(ctx);		
	}

	// 25/01/2017 14:32:18 - Inserito il rethrow della ServicePatternException	
	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		SitePersistence p = SitePersistence.createPersistenceObject(pcfg, aSession);
		
		SiteDTO dto1 = actionForm.getDTO4Update(getServiceEnvironment().getRequestSiteId(), theSite);	
		
		// Dovrebbero tornare solo le properties da toccare. Una  strageia piu' safe sarebbe quella di tirarle su tutte.
		// ELiminare quelle che non ci sono e modificare le altre, cancennare dal db tutto il package e risalvarle...
		List<SitePropertyDTO> listOfSiteConfigProperties = dto1.retrieveSitePropertiesFromSiteDTO();
		
	    p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());
	    
	    if (listOfSiteConfigProperties != null)
	    {
	    	SitePropertyPersistence spersistence = SitePropertyPersistence.createPersistenceObject(pcfg, aSession);
	    	for(SitePropertyDTO spdto : listOfSiteConfigProperties)
	    	{
	    		// Procedo con l'update. CHiaramente se qualcosa mi va a null potrei non riuscire a salvarla perche' non la trovo...
	    		spersistence.updateByPrimaryKey(spdto, pcfg.getPersistenceConfigInfo());
	    	}
	    }

	    SailEventPersistence sev = SailEventPersistence.createPersistenceObject(pcfg, aSession);
	    SailEventDTO sevDTO = actionForm.getSailEventDTO4Update(getServiceEnvironment().getRequestSiteId(), theSite);
	    sev.updateByPrimaryKey(sevDTO, pcfg.getPersistenceConfigInfo());

	    // Ottengo un codice del tipo SITE0000000000x. Se tolgo i primi quattro ottengo un numerico. I quattro caratteri poi me li uso variamente
	    // per creare degli id all'interno dello script velocity.
	    String siteSequence = p.getSite_sequence(pcfg.getPersistenceConfigInfo());
	    
		DMSContext dmsContext = new DMSContext(pcfg, aSession);	
	    try
		{
//			DMSFolder f = DMSFolderHelper.getCMSCardFolder(dmsContext, getServiceEnvironment().getRequestSiteId(), dto1.getSite(), true);
//			f = DMSFolderHelper.getCMSCardFolder(dmsContext, getServiceEnvironment().getRequestSiteId(), dto1.getSite(), false);
			
	    	RunSqlPersistence scriptPersistence = 
			RunSqlPersistence.createPersistenceObject(aSession, velocityEngine, "SiteRegattaUpdateSQLScript");
							
			scriptPersistence.addParameter("siteDTO", dto1);		
			scriptPersistence.addParameter("sevEventDTO", sevDTO);
			scriptPersistence.addParameter("siteSequence", siteSequence.substring(4));	
			
			scriptPersistence.execute(pcfg, aSession);			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new ServicePatternException(e);
		}	    
    	    
	    LUTManager.getLUTManager().invalidateLUT(LUTName.site);
		return dto1;
	}

}

package org.r3.ws.system.siteproperty;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.siteproperty.SitePropertyDTO;
import org.r3.db.system.siteproperty.SitePropertyPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTSiteProperties extends ServicePattern
{
    private SitePropertiesActionForm actionForm;
    private String thePackage;
    private boolean invalidateSiteLUT;
    
	public POSTSiteProperties(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aPackage, SitePropertiesActionForm anActionForm, boolean invalidateSiteLUTFlag)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		thePackage = aPackage;
		invalidateSiteLUT = invalidateSiteLUTFlag;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		SitePropertyPersistence p = SitePropertyPersistence.createPersistenceObject(pcfg, aSession);
		p.deleteBySitePropertyscope(senv.getRequestSiteId(), thePackage, pcfg);
		
		List<SitePropertyDTO> listOfProps = actionForm.getDTO4UpdateProperties(senv.getRequestSiteId(), thePackage);				
	    if (listOfProps != null)
	    {
	    	for(SitePropertyDTO dto : listOfProps)
	    	{
	    		p.insert(dto, pcfg.getPersistenceConfigInfo());
	    	}
	    }
	    
	    LUTManager.getLUTManager().invalidateLUT(LUTName.siteproperty);
	    
	    if (invalidateSiteLUT)
	       LUTManager.getLUTManager().invalidateLUT(LUTName.site);
	    
		return RestServiceDTO.SuccessDTO;
	}

}

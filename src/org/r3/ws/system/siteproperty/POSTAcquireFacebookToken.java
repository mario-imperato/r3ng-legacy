package org.r3.ws.system.siteproperty;

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

public class POSTAcquireFacebookToken extends ServicePattern
{
    private FBAcquirePageTokenActionForm actionForm;
    private String thePackage;
    private boolean invalidateSiteLUT;
    
	public POSTAcquireFacebookToken(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aPackage, FBAcquirePageTokenActionForm anActionForm, boolean invalidateSiteLUTFlag)
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

		SitePropertyDTO dto = null;
		
		dto = actionForm.getDTO4Insert(senv.getRequestSiteId(), thePackage, "fbpageid", actionForm.getFbpageid());
		p.insert(dto, pcfg.getPersistenceConfigInfo());

		dto = actionForm.getDTO4Insert(senv.getRequestSiteId(), thePackage, "fbpagename", actionForm.getFbpagename());
		p.insert(dto, pcfg.getPersistenceConfigInfo());

		dto = actionForm.getDTO4Insert(senv.getRequestSiteId(), thePackage, "fbaccesstoken", actionForm.getFbaccesstoken());
		p.insert(dto, pcfg.getPersistenceConfigInfo());

		dto = actionForm.getDTO4Insert(senv.getRequestSiteId(), thePackage, "fbpagetoken", actionForm.getFbpagetoken());
		p.insert(dto, pcfg.getPersistenceConfigInfo());

		dto = actionForm.getDTO4Insert(senv.getRequestSiteId(), thePackage, "fbuserid", actionForm.getFbuserid());
		p.insert(dto, pcfg.getPersistenceConfigInfo());
				    
	    LUTManager.getLUTManager().invalidateLUT(LUTName.siteproperty);
	    
	    if (invalidateSiteLUT)
	       LUTManager.getLUTManager().invalidateLUT(LUTName.site);
	    
		return RestServiceDTO.SuccessDTO;
	}

}

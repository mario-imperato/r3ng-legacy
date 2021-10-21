package org.r3.ws.system.site;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.site.SiteDTO;
import org.r3.db.system.site.SitePersistence;
import org.r3.db.system.siteproperty.SitePropertyDTO;
import org.r3.db.system.siteproperty.SitePropertyDTOCollection;
import org.r3.db.system.siteproperty.SitePropertyPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETSiteDetail extends ServicePattern
{
    private String regattaId;
    
	public GETSiteDetail(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aRegattaId)
	{
		super(ctx, serviceEnvironment);
		regattaId = aRegattaId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		SitePersistence p = SitePersistence.createPersistenceObject(pcfg, aSession);
						
		SiteDTO dto1 = p.selectBySite(regattaId, pcfg.getPersistenceConfigInfo());	
		SitePropertyPersistence sitePropertyPersistence = SitePropertyPersistence.createPersistenceObject(pcfg, aSession);
		List<SitePropertyDTO> listOfProperties = 
				sitePropertyPersistence.selectPropertiesInPropertyScope(regattaId, "site.config", pcfg.getPersistenceConfigInfo());
		
		if (listOfProperties != null)
		{
			SitePropertyDTOCollection c = new SitePropertyDTOCollection();
			c.addAll(listOfProperties);
			dto1.setSiteProperties(c);
			
			dto1.resolveSiteDTOFromSiteProperties();
		}				
		
		return dto1;
	}

}

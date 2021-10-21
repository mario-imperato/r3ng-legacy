package org.r3.ws.system.siteconfig;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.siteportletcfg.SitePortletConfigDTO;
import org.r3.db.system.siteportletcfg.SitePortletConfigPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTPortletConfig extends ServicePattern
{
    private PortletConfigActionForm actionForm;
    
    private String pageId;
    private String positionId;
    
	public PUTPortletConfig(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aPageId, String aPositionId, PortletConfigActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		
		pageId = aPageId;
		positionId = aPositionId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		SitePortletConfigPersistence p = SitePortletConfigPersistence.createPersistenceObject(pcfg, aSession);		
				
		SitePortletConfigDTO newDto = actionForm.getDTO4InsertUpdate(senv.getRequestSiteId(), pageId, positionId);		
		SitePortletConfigDTO dto1 = p.selectBySitePageidPositionid(senv.getRequestSiteId(), pageId, positionId, pcfg.getPersistenceConfigInfo());
		
        if (dto1 != null)
        {
        	if (actionForm.isPositionConfigured())
        	{        		
        		p.updateByPrimaryKey(newDto, pcfg.getPersistenceConfigInfo());
        	}
        	else
        	{
        		p.deleteBySitePageidPositionid(senv.getRequestSiteId(), pageId, positionId, pcfg.getPersistenceConfigInfo());
        	}
        }
        else
        {
        	if (actionForm.isPositionConfigured())
        	{        		
        		p.insert(newDto, pcfg.getPersistenceConfigInfo());        		
        	}
        }
        	    
        LUTManager.getLUTManager().invalidateLUT(LUTName.siteportletconfig);
		return newDto;
	}

}

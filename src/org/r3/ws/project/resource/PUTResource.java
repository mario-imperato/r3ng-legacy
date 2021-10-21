package org.r3.ws.project.resource;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.project.resource.ResourceDTO;
import org.r3.db.project.resource.ResourcePersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.util.velocity.VelocityTemplateModel;

public class PUTResource extends ServicePattern
{
	
    private ResourceActionForm actionForm;
    private String resourceId;
    private VelocityTemplateModel velocityEngine;
    
	public PUTResource(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aResourceId, ResourceActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		resourceId = aResourceId;
		
		velocityEngine = VelocityTemplateModel.getVelocityPlugInModel(ctx);	
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		ResourcePersistence p = ResourcePersistence.createPersistenceObject(pcfg, aSession);		
		ResourceDTO dtoResource = p.selectByResourceid(resourceId, pcfg.getPersistenceConfigInfo());
		if (dtoResource != null)
		{
			ResourceDTO newDtoActor = actionForm.getDTO4Update(dtoResource);		
		    p.updateByPrimaryKey(newDtoActor, pcfg.getPersistenceConfigInfo());	    
		}
		
//		TeamResourcePersistence rp = TeamResourcePersistence.createPersistenceObject(pcfg, aSession);
//		TeamResourceDTO rdto = rp.selectBySiteTeamidResourceid(senv.getRequestSiteId(), resourceId, pcfg.getPersistenceConfigInfo());
//		if (rdto != null)
//		{
//			rdto = actionForm.getDTO4SiteResourceUpdate(rdto);		
//			rp.updateByPrimaryKey(rdto, pcfg.getPersistenceConfigInfo());			
//		}
//		else
//		{
//			rdto = actionForm.getDTO4SiteResourceInsert(senv.getRequestSiteId(), resourceId);
//			rp.insert(rdto, pcfg.getPersistenceConfigInfo());				
//		}
		    
		return dtoResource;
	}
	
	
	
}

package org.r3.ws.project.resource;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.project.resource.ResourceDTO;
import org.r3.db.project.resource.ResourcePersistence;
import org.r3.db.system.script.RunSqlPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.util.velocity.VelocityTemplateModel;

public class DELETEResource extends ServicePattern
{    
    private String site;
    private String resourceId;
	private VelocityTemplateModel velocityEngine;
	
	public DELETEResource(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aSite, String aResourceId)
	{
		super(ctx, serviceEnvironment);
		
		site = aSite;
		resourceId = aResourceId;
		
		velocityEngine = VelocityTemplateModel.getVelocityPlugInModel(ctx);	
	}

	// 25/01/2017 14:32:18 - Inserito il rethrow della ServicePatternException
	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		ResourcePersistence p = ResourcePersistence.createPersistenceObject(pcfg, aSession);
		ResourceDTO dto = p.selectByResourceid(resourceId, pcfg.getPersistenceConfigInfo());
		
		if (dto != null)
		{
	    try
		{						
			RunSqlPersistence scriptPersistence = 
			RunSqlPersistence.createPersistenceObject(aSession, velocityEngine, "delete_prj_resource");
							
			scriptPersistence.addParameter("resourceDTO", dto);							
			scriptPersistence.execute(pcfg, aSession);			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new ServicePatternException(e);
		}
		}
	    
		return RestServiceDTO.SuccessDTO;
	}
}

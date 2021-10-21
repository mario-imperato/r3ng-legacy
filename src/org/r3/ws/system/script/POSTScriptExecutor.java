package org.r3.ws.system.script;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.script.RunSqlPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.util.velocity.VelocityTemplateModel;

public class POSTScriptExecutor extends ServicePattern
{
    private String scriptName;
    private VelocityTemplateModel m;
    
	public POSTScriptExecutor(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aScriptName)
	{
		super(ctx, serviceEnvironment);
		scriptName = aScriptName;
		m = VelocityTemplateModel.getVelocityPlugInModel(ctx);
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)  throws ServicePatternException
	{
		int[] rowsAffected = null;
		try
		{
		RunSqlPersistence scriptPersistence = 
						RunSqlPersistence.createPersistenceObject(aSession, m, scriptName);
													
		rowsAffected = scriptPersistence.execute(pcfg, aSession);        
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ServicePatternException(e.getMessage());
		}
		
		int totalNumberOfRowsAffected = 0;
		if (rowsAffected != null && rowsAffected.length > 0)
		{
			for(int i = 0; i < rowsAffected.length; i++)
			{
				totalNumberOfRowsAffected += rowsAffected[i];
			}
		}
		
		RestServiceDTO restDTO = new RestServiceDTO(Status.ok, String.format("Operazione terminata correttamente: elaborati %d statements che hanno riguardato %d righe", rowsAffected.length, totalNumberOfRowsAffected));		
		return restDTO;
	}


}

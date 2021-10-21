package org.r3.ws.system.lut;



import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTManager;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class LUTReload extends ServicePattern
{    
	public LUTReload(ServletContext ctx,  ServiceEnvironment serviceEnvironment)
	{
		super(ctx, serviceEnvironment);
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		LUTManager  lutManager = LUTManager.getLUTManager();
		lutManager.reload(pcfg, aSession);
		return RestServiceDTO.SuccessDTO;
	}

    
}

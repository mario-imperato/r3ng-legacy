package org.r3.ws.user.authrole;


import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.user.authrole.AuthRoleFilter;
import org.r3.db.system.user.authrole.AuthRolePersistence;
import org.r3.system.rest.LUTConditionalGetPattern;
import org.r3.system.rest.ServiceEnvironment;

public class GETAuthRoleLUTItems extends LUTConditionalGetPattern
{

	public GETAuthRoleLUTItems(ServletContext ctx,  ServiceEnvironment serviceEnvironment)
	{
		super(ctx, serviceEnvironment,LUTName.authrole.toString());
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		AuthRolePersistence p = AuthRolePersistence.createPersistenceObject(pcfg, aSession);

		AuthRoleFilter filter = new AuthRoleFilter();
		filter.setOrderByClause(" roledescr ");
				
		return p.query(filter, pcfg.getPersistenceConfigInfo(), "1", 0, -1, false);
	}

}

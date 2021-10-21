package org.r3.ws.user.userrole;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.user.userrole.UserRolePersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class DELETEUserRole extends ServicePattern
{   
	private UserRolesActionForm actionForm;
	private String roleId;
	
	public DELETEUserRole(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aRoleId, UserRolesActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		roleId = aRoleId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		UserRolePersistence p = UserRolePersistence.createPersistenceObject(pcfg, aSession);	
		
		String[] a = actionForm.getUserid();
		if (a != null && a.length > 0)
		{
			for(String userId : a)
			{
				// L'utente stesso non si puo' togliere il ruolo assegnato..
				if (userId.equalsIgnoreCase(senv.getUserProfile().getUserid()))
					continue ;
				
				int n = p.deleteBySiteUseridRoleid(senv.getRequestSiteId(), userId, roleId, pcfg.getPersistenceConfigInfo());
			}
		}
		
		return RestServiceDTO.SuccessDTO;
	}

}

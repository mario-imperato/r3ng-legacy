package org.r3.ws.user.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.user.userrole.UserRoleDTO;
import org.r3.db.system.user.userrole.UserRoleFilter;
import org.r3.db.system.user.userrole.UserRolePersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTUpdateUserRoles extends ServicePattern
{
    private String serializedRoles;
    private String userId;
    
	public PUTUpdateUserRoles(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aUserId, String aSerializedRoles)
	{
		super(ctx, serviceEnvironment);
		serializedRoles = aSerializedRoles;
		userId = aUserId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
        UserRolePersistence p2 = UserRolePersistence.createPersistenceObject(pcfg, aSession);
	    UserRoleFilter userFilter = new UserRoleFilter();
	    userFilter.or().andUseridEqualTo(userId);
	    p2.delete(userFilter, pcfg.getPersistenceConfigInfo());

		List<UserRoleDTO> listOf = parseSerializedRoles(userId, serializedRoles);
		if (listOf != null)
		{
            for(UserRoleDTO dto : listOf)
            {
                p2.insert(dto,  pcfg.getPersistenceConfigInfo());            	
            }
		}
			
	    
	    LUTManager.getLUTManager().invalidateLUT(LUTName.userprofile);
	    
		return RestServiceDTO.SuccessDTO;
	}
	
	private List<UserRoleDTO> parseSerializedRoles(String aUserId, String aSerializedRoles)
	{
		if (aSerializedRoles == null || aSerializedRoles.trim().length() == 0)
			return null;
		
		List<UserRoleDTO> listOf = new ArrayList<UserRoleDTO>();
	    String[] listOfSitesRoles = aSerializedRoles.split(";");
	    for(int i = 0; i < listOfSitesRoles.length; i++)
	    {
	    	int ndx = listOfSitesRoles[i].indexOf('=');
	    	if (ndx > 0)
	    	{
	    		String site = listOfSitesRoles[i].substring(0, ndx);
	    		String[] roles = listOfSitesRoles[i].substring(ndx + 1).split(",");
	    		if (roles != null)
	    		{
	    			for(int j = 0; j < roles.length; j++)
	    			{
	    				UserRoleDTO dto = new UserRoleDTO();
	    				dto.setSite(site);
	    				dto.setUserid(aUserId);
	    				dto.setRoleid(roles[j]);
	    				
	    				listOf.add(dto);
	    			}
	    		}
	    	}
	    }
	    
	    return listOf;
	}
	
	
}

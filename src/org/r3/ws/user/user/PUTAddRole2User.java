package org.r3.ws.user.user;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.user.userrole.UserRoleDTO;
import org.r3.db.system.user.userrole.UserRolePersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTAddRole2User extends ServicePattern
{
    private String roleId;
    private String userId;
    
	public PUTAddRole2User(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aUserId, String aRoleId)
	{
		super(ctx, serviceEnvironment);
		roleId = aRoleId;
		userId = aUserId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
        UserRolePersistence p2 = UserRolePersistence.createPersistenceObject(pcfg, aSession);
        UserRoleDTO dto = p2.selectBySiteUseridRoleid(senv.getRequestSiteId(), userId, roleId, pcfg.getPersistenceConfigInfo());
        if (dto == null)
        {
        	dto = new UserRoleDTO();
        	dto.setSite(senv.getRequestSiteId());
        	dto.setUserid(userId);
        	dto.setRoleid(roleId);
        	
        	int n = p2.insert(dto, pcfg.getPersistenceConfigInfo());
    	    LUTManager.getLUTManager().invalidateLUT(LUTName.userprofile);
        }
        			
	    	    
		return RestServiceDTO.SuccessDTO;
	}
	
	
	
}

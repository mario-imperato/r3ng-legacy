package org.r3.ws.user.user;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.user.user.UserDTO;
import org.r3.db.system.user.user.UserPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTChangeUserPassword extends ServicePattern
{
    private UserActionForm actionForm;
    private String userId;
    
	public PUTChangeUserPassword(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aUserId, UserActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		userId = aUserId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		UserPersistence p = UserPersistence.createPersistenceObject(pcfg, aSession);		
				
		UserDTO dto1 = actionForm.getDTO4ChangePassword(userId);
		
	    p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());

//	    UserRolePersistence p2 = UserRolePersistence.createPersistenceObject(pcfg, aSession);
//	    UserRoleFilter userFilter = new UserRoleFilter();
//	    userFilter.or().andUseridEqualTo(userId);
//	    p2.delete(userFilter, pcfg.getPersistenceConfigInfo());
//	    
//	    String[] ruolipostaliz = actionForm.getRoles();
//	    if (ruolipostaliz != null && ruolipostaliz.length > 0)
//	    {
//	    	UserRoleDTO dto2 = new UserRoleDTO();
//	    	dto2.setUserid(dto1.getUserid());
//	    	for(String r : ruolipostaliz)
//	    	{
//	    		dto2.setRoleid(r);
//	    		p2.insert(dto2, pcfg.getPersistenceConfigInfo());
//	    	}	         
//	    }
	    
	    LUTManager.getLUTManager().invalidateLUT(LUTName.userprofile);
	    
		return RestServiceDTO.SuccessDTO;
	}
}

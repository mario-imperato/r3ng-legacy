package org.r3.ws.user.user;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.user.user.UserDTO;
import org.r3.db.system.user.user.UserFilter;
import org.r3.db.system.user.user.UserPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTChangeMyPassword extends ServicePattern
{
    private UserActionForm actionForm;
    
	public POSTChangeMyPassword(ServletContext ctx, ServiceEnvironment serviceEnvironment, UserActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		UserPersistence p = UserPersistence.createPersistenceObject(pcfg, aSession);		
				
		UserFilter filterUserDTO = actionForm.getDTO4FilterUpdateChangeMyPassword(senv.getUserProfile());
		UserDTO updateUserDTO = actionForm.getDTO4ChangeMyPassword();		
		int numberOfRows = p.update(updateUserDTO, filterUserDTO, pcfg.getPersistenceConfigInfo());
	    	    
	    LUTManager.getLUTManager().invalidateLUT(LUTName.userprofile);	    	    

	    if (numberOfRows == 0)
	        return new RestServiceDTO(Status.fail, "USR_ERROR_003", "Il cambio della password non è andato a buon fine");
	    
		return RestServiceDTO.SuccessDTO;
	}
}

package org.r3.ws.user.user;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.user.user.UserDTO;
import org.r3.db.system.user.user.UserPersistence;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.system.rest.LoginFailedException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTApplyMembershipId extends ServicePattern
{
    private LoginActionForm actionForm;
    private String          nickname;
    
	public POSTApplyMembershipId(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aLoginUserName, LoginActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		nickname = aLoginUserName;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws LoginFailedException
	{	
		UserProfileViewDTO userProfile = senv.getUserProfile();
		
		if (actionForm.getMembershipid() == null)
		{
			return new RestServiceDTO(Status.fail, "SYSERR", "Errore Nei Parametri");
		}
		
		UserPersistence p = UserPersistence.createPersistenceObject(pcfg, aSession);		
		if (p.check4DuplicateCompanyid(pcfg.getPersistenceConfigInfo(), userProfile.getNickname(), actionForm.getMembershipid()))
		{
			return new RestServiceDTO(Status.fail, "DUPMEMBERSHIPID", "Il numero di tessera risulta gia' in uso ad un altro utente.");
		}
		
		UserDTO dto1 = p.selectByNickname(userProfile.getNickname(), pcfg.getPersistenceConfigInfo());

		if (dto1 == null)
		{
			return new RestServiceDTO(Status.fail, "SYSERR", "Si e' verificato un problema con i parametri passati");
		}
		
		dto1.setCompanyid(actionForm.getMembershipid());
		p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());
		LUTManager.getLUTManager().invalidateLUT(LUTName.userprofile);
		return RestServiceDTO.SuccessDTO;
	}

}

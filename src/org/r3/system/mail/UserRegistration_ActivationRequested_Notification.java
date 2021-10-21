package org.r3.system.mail;

import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.siteproperty.SitePropertyDTO;
import org.r3.db.system.user.user.UserDTO;
import org.r3.system.util.velocity.VelocityTemplateModel;

public class UserRegistration_ActivationRequested_Notification extends UserMailNotification
{
		
	public UserRegistration_ActivationRequested_Notification(VelocityTemplateModel aVelocityEngine, Properties aContextProperties, UserDTO aUser, boolean oneTimePassword)
	{
		super(aVelocityEngine, aContextProperties, aUser, oneTimePassword);
	}
		
	public void notify(PersistenceContext ctx, SqlSession aSession) throws Exception
	{
		notify(ctx, aSession, "UserRegistration_RequestActivatationMailMessage", SitePropertyDTO.REGIST_MAILTITLE);
	}
	
	
}

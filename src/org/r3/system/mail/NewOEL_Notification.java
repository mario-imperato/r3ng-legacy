package org.r3.system.mail;

import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.site.SiteDTO;
import org.r3.db.system.siteproperty.SitePropertyDTO;
import org.r3.db.system.user.user.UserDTO;
import org.r3.system.util.velocity.VelocityTemplateModel;

public class NewOEL_Notification extends NewSiteRequestNotification
{
	
	public NewOEL_Notification(VelocityTemplateModel aVelocityEngine, Properties aContextProperties, SiteDTO aSiteDTO, UserDTO aUser, boolean oneTimePassword)
	{
		super(aVelocityEngine, aContextProperties, aSiteDTO, aUser, oneTimePassword);
	}
		
	@Override
	public void notify(PersistenceContext ctx, SqlSession aSession) throws Exception
	{
		notify(ctx, aSession, "NewOELRequest_NotificationMailMessage", SitePropertyDTO.SMTP_SYSSUBJECT);
	}
	
}

package org.r3.system.mail;

import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.site.SiteDTO;
import org.r3.db.system.user.user.UserDTO;
import org.r3.system.util.velocity.VelocityTemplateModel;
import org.r3.system.util.velocity.VelocityTemplateRenderer;

public class NewSiteRequestNotification extends UserMailNotification
{
    protected SiteDTO targetSite;
	
	public NewSiteRequestNotification(VelocityTemplateModel aVelocityEngine, Properties aContextProperties, SiteDTO aSiteDTO, UserDTO aUser, boolean oneTimePassword)
	{
		super(aVelocityEngine, aContextProperties, aUser, oneTimePassword);
		targetSite = aSiteDTO;
	}

	@Override
	protected VelocityTemplateRenderer getVelocityTemplateRenderer(PersistenceContext pcfg, SqlSession aSession, String aTemplateName)
	{
		VelocityTemplateRenderer renderer = super.getVelocityTemplateRenderer(pcfg, aSession, aTemplateName);	
		renderer.add("siteObj", targetSite);		

		return renderer;
	}

}

package org.r3.system.mail;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.otp.OTPDTO;
import org.r3.db.system.otp.OTPPersistence;
import org.r3.db.system.queues.simplemail.MailRecipient;
import org.r3.db.system.queues.simplemail.SimpleNotifier;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.util.velocity.VelocityTemplateModel;
import org.r3.system.util.velocity.VelocityTemplateRenderer;

public abstract class MailNotification
{	
	private static final int NUMBER_OF_RETRIES = 2;
	private VelocityTemplateModel velocityEngine;
	private Properties contextProperties;
	private List<MailRecipient>  listOfRecipients;
	private String messageSender;
	private String messageBody;
	private String messageTitle;
	
	public MailNotification(VelocityTemplateModel aVelocityEngine, Properties aContextProperties)
	{
		velocityEngine = aVelocityEngine;
		contextProperties = aContextProperties;
	}

	protected void addRecipient(String anEmail, int mailRecipientType)
	{
		if (listOfRecipients == null)
			listOfRecipients = new ArrayList<MailRecipient>();
		
		MailRecipient mr =  MailRecipient.newRecipient(anEmail, mailRecipientType);
		listOfRecipients.add(mr);
	}
		
	protected String getTargetSite()
	{
		return (String)contextProperties.get(ServiceEnvironment.SENV_SITE);
	}
	
	protected String getTargetLanguage()
	{
		return (String)contextProperties.get(ServiceEnvironment.SENV_LANGUAGE);
	}
	
	protected String getTargetSiteDomain()
	{
		return (String)contextProperties.get(ServiceEnvironment.SENV_SITEDOMAINID);
	}
	
	protected String getTargetSchemeHostPort()
	{
		return (String)contextProperties.get(ServiceEnvironment.SENV_SCHEMEHOSTPORT);
	}
	
	protected List<MailRecipient> getRecipients()
	{		
		return listOfRecipients;		
	}
		
	protected void setSender(String s)
	{
		messageSender = s;
	}
	
	private String getSender()
	{
		return messageSender;		
	}
	
	protected void setTitle(String s)
	{
		messageTitle = s;
	}

	private String getTitle()
	{
		return messageTitle;		
	}
	
	protected void setBody(String s)
	{
		messageBody = s;
	}
	
	private String getBody()
	{
		return messageBody;		
	}
	
	protected OTPDTO getOneTimePasswordDataBean(PersistenceContext pcfg, SqlSession aSession, String aUserId)
	{
		OTPPersistence otpPersistence = OTPPersistence.createPersistenceObject(pcfg, aSession); 
        OTPDTO otpDataBean = new OTPDTO();
        otpDataBean.setOTPInfo(aUserId, 5);
        otpPersistence.insert(otpDataBean, pcfg.getPersistenceConfigInfo());

        return otpDataBean;
	}
	
	protected VelocityTemplateRenderer getVelocityTemplateRenderer(PersistenceContext pcfg, SqlSession aSession, String aTemplateName)
	{
		VelocityTemplateRenderer renderer = velocityEngine.newRendererInstance(aTemplateName,  getTargetSiteDomain());
		
		renderer.add("targetSite", getTargetSite());
		renderer.add("targetLanguage", getTargetLanguage());
		renderer.add("schemehostport", getTargetSchemeHostPort());
		renderer.add("targetSiteDomain", getTargetSiteDomain());				
		
		return renderer;
	}
	
	public void notify(PersistenceContext ctx, SqlSession aSession) throws Exception
	{       		
        SimpleNotifier wm = new SimpleNotifier(); 

        wm.setMessageSender(getSender());
        wm.setMessageTitle(getTitle());
                
        wm.notify(ctx, aSession, getTargetSite(), getBody(), getRecipients(), null, NUMBER_OF_RETRIES);	
	}
	
}

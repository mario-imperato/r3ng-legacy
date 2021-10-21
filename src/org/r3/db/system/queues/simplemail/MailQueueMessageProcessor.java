package org.r3.db.system.queues.simplemail;

import java.io.File;
import java.security.Security;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.queues.model.QueueMessage;
import org.r3.db.system.queues.model.QueueMessageProcessor;
import org.r3.db.system.queues.model.QueueMessageProcessorException;
import org.r3.db.system.queues.model.QueueProcessorContext;
import org.r3.db.system.siteproperty.SitePropertyDTO;
import org.r3.db.system.siteproperty.SitePropertyDTO.PropertyScope;
import org.r3.db.system.siteproperty.SitePropertyLUT;

public class MailQueueMessageProcessor extends QueueMessageProcessor
{
	static
	{
		// Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	}
	
	private String siteContext;
	
	private Session mailSession;
	private boolean debug = false;
	private boolean initialized = false;

	@Override
	public void initialize(String aSiteContext, QueueProcessorContext processContext)
	{
		siteContext = aSiteContext;
		
		if (!initialized)
		{
			initialized = true;
			Properties props = new Properties();

			props.setProperty("mail.transport.protocol", "smtp");
			
			String pvalue = getSmtpProperty(aSiteContext, SitePropertyDTO.MAILHOST).getPropertyvalue();
			props.setProperty("mail.host", pvalue);
			System.out.printf("MAIL Processor Using: %s as Host\n", pvalue);
			
			pvalue = getSmtpProperty(aSiteContext, SitePropertyDTO.SMTPAUTH).getPropertyvalue();
			props.put("mail.smtp.auth", pvalue);
			System.out.printf("MAIL Processor Using: %s as Account\n", pvalue);

			String mailConfigProfile = getSmtpProperty(aSiteContext, SitePropertyDTO.MAILPROFILE).getPropertyvalue();
			if (mailConfigProfile != null && mailConfigProfile.equalsIgnoreCase(SitePropertyDTO.MailProfile.google.toString()))
			{
			props.put("mail.smtp.port", getSmtpProperty(aSiteContext, SitePropertyDTO.SMTPPORT).getPropertyvalue());
			props.put("mail.smtp.socketFactory.port", getSmtpProperty(aSiteContext, SitePropertyDTO.SMTPSOCKETFACTORYPORT).getPropertyvalue());
			props.put("mail.smtp.socketFactory.class", getSmtpProperty(aSiteContext, SitePropertyDTO.SMTPSOCKETFACTORYCLASS).getPropertyvalue());
			props.put("mail.smtp.socketFactory.fallback", getSmtpProperty(aSiteContext, SitePropertyDTO.SMTPSOCKETFACTORYFALLBACK).getPropertyvalue());
			props.setProperty("mail.smtp.quitwait", getSmtpProperty(aSiteContext, SitePropertyDTO.SMTPQUITWAIT).getPropertyvalue());
			}
			
			mailSession = Session.getInstance(props, getAuthenticator());
			mailSession.setDebug(debug);
		}
	}

	@Override
	public void release()
	{
	}

	@Override
	public boolean process(QueueProcessorContext processContext, QueueMessage aQueueMessage) throws QueueMessageProcessorException
	{
		MailMessage s = (MailMessage)aQueueMessage;
		
		if (s == null)
			return true;

		try
		{
			MimeMessage msg = new MimeMessage(mailSession);

			// Initialize the sender
			if (s.getFrom() != null)
				msg.setFrom(new InternetAddress(s.getFrom().getInternetRecipient().getRecipientId()));
			else
			{
				msg.setFrom(new InternetAddress(getSmtpProperty(siteContext, SitePropertyDTO.SMTP_SYSFROM).getPropertyvalue()));
			}

			// Iterator utilizzato per l'inizializzazione dei recipients.

			InternetAddress[] address = null;

			// Initialize the TO recipients
			List<MailRecipient> aList = s.getRecipients(Recipient.INET_ADDRESS, MailRecipient.TO_RECIPIENT);
			if (aList != null)
			{
				ListIterator<MailRecipient> iter = aList.listIterator();
				address = new InternetAddress[aList.size()];
				for (int i = 0; iter.hasNext(); i++)
				{
					Recipient r = iter.next();
					address[i] = new InternetAddress(r.getRecipientId());
				}

				msg.setRecipients(Message.RecipientType.TO, address);
			}

			// Initialize the CC recipients
			aList = s.getRecipients(Recipient.INET_ADDRESS, MailRecipient.CC_RECIPIENT);
			if (aList != null)
			{
				ListIterator<MailRecipient> iter = aList.listIterator();
				address = new InternetAddress[aList.size()];
				for (int i = 0; iter.hasNext(); i++)
				{
					Recipient r = iter.next();
					address[i] = new InternetAddress(r.getRecipientId());
				}
				msg.setRecipients(Message.RecipientType.CC, address);
			}

			// Initialize the BCC recipients
			aList = s.getRecipients(Recipient.INET_ADDRESS, MailRecipient.BCC_RECIPIENT);
			if (aList != null)
			{
				ListIterator<MailRecipient> iter = aList.listIterator();
				address = new InternetAddress[aList.size()];
				for (int i = 0; iter.hasNext(); i++)
				{
					Recipient r = iter.next();
					address[i] = new InternetAddress(r.getRecipientId());
				}
				msg.setRecipients(Message.RecipientType.BCC, address);
			}

			if (s.getSubject() != null)
				msg.setSubject(s.getSubject());
			else
				msg.setSubject(getSmtpProperty(siteContext, SitePropertyDTO.SMTP_SYSSUBJECT).getPropertyvalue());

			msg.setSentDate(new java.util.Date());

			// create the Multipart and its parts to it
			Multipart mp = new MimeMultipart();

			MimeBodyPart mbp1 = getTextBodyPart(s.getText(), s.isHtml());
			mp.addBodyPart(mbp1);

			List<String> listOfFiles = s.getListOfFiles();
			if (listOfFiles != null && listOfFiles.size() > 0)
			{
				for(String fileName : listOfFiles)
				{
				File f = new File(fileName);
				if (f.exists() && f.isFile() && f.canRead())
				{
					mbp1 = getAttachmentBodyPart(f);
					
					StringBuilder cid = new StringBuilder().append('<').append(f.getName()).append('>');
					mbp1.setContentID(cid.toString());
					mp.addBodyPart(mbp1);
				}
				}
			}

			// add the Multipart to the message
			msg.setContent(mp);

			// send the message
			Transport.send(msg);

			// logMailNotification(cn, s);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();

			if (ex != null)
				s.error = ex.toString();

			return false;
		}

		return true;
	}

	/**
	 * @return Returns the session.
	 */
	public Session getMailSession()
	{
		return mailSession;
	}

	private SitePropertyDTO getSmtpProperty(String aSiteContext, String propertyName)
	{
		SitePropertyLUT sitePropertyLUT = (SitePropertyLUT) LUTManager.getLUTManager().getLUT(LUTName.siteproperty, null);

		SitePropertyDTO property = sitePropertyLUT.getItem(aSiteContext, PropertyScope.mail, propertyName);
		return property;
	}

	private boolean getSmtpPropertyAsBoolean(String aSiteContext, String propertyName)
	{
		SitePropertyDTO property = getSmtpProperty(aSiteContext, propertyName);
		if (property != null)
			return property.getPropertyvalueAsBoolean();

		return false;
	}

	private javax.mail.Authenticator getAuthenticator()
	{
		javax.mail.Authenticator authenticator = null;

		if (getSmtpPropertyAsBoolean(siteContext, SitePropertyDTO.SMTPAUTH))
		{
			authenticator = new javax.mail.Authenticator()
			{
				protected javax.mail.PasswordAuthentication getPasswordAuthentication()
				{
					String account = getSmtpProperty(siteContext, SitePropertyDTO.SMTPAUTHACCOUNT).getPropertyvalue();
					String pwd = getSmtpProperty(siteContext, SitePropertyDTO.SMTPAUTHPASSWD).getPropertyvalue();
					System.out.printf("MAIL Processor Using: %s as Account with %s\n", account, pwd);
					
					return new javax.mail.PasswordAuthentication(account, pwd);
				}
			};
		}

		return authenticator;
	}

	private MimeBodyPart getAttachmentBodyPart(File attachmentFile) throws MessagingException
	{
		MimeBodyPart mbp = new MimeBodyPart();
		mbp.setFileName(attachmentFile.getName());

		DataSource ds = new FileDataSource(attachmentFile);
		DataHandler dh = new DataHandler(ds);
		mbp.setDataHandler(dh);

		return mbp;
	}

	protected MimeBodyPart getTextBodyPart(String aText, boolean htmlText) throws MessagingException
	{
		// create and fill the first message part
		MimeBodyPart mbp1 = new MimeBodyPart();
		if (htmlText)
			mbp1.setContent(aText, "text/html");

		else
			mbp1.setText(aText);
		return mbp1;
	}


}

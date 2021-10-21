package org.r3.db.system.queues.simplemail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.queues.model.QueueException;
import org.r3.db.system.queues.model.QueueMessage.MessagePriority;

public class SimpleNotifier
{
    private String                        messageSummary  = null;

    private String                        messageTitle    = null;

    private String                        messageSender   = null;

    private String                        messageClass    = null;

    public SimpleNotifier() 
    {
    }

    protected String getMailQueueName()
    {
        return "MailQueue";
    }
    
    public void notify(PersistenceContext pcfg, SqlSession aConnection, String aSiteContext, String aMessageBody, List<MailRecipient> listOfRecipients, List<String> aListOfFiles, int numberOfRetries)
            throws Exception
    {
        notify(pcfg, aConnection, aSiteContext, listOfRecipients, aListOfFiles, aMessageBody, numberOfRetries);
    }

    public void notify(PersistenceContext pcfg, SqlSession aConnection, String aSiteContext, String aMessageBody, MailRecipient aRecipient, List<String> aListOfFiles, int numberOfRetries)
            throws Exception
    {
        List<MailRecipient> listOfRecipients = new ArrayList<MailRecipient>();
        listOfRecipients.add(aRecipient);
        
        notify(pcfg, aConnection,  aSiteContext, listOfRecipients, aListOfFiles, aMessageBody, numberOfRetries);
    }

    public void notify(PersistenceContext pcfg, SqlSession aConnection, String aSiteContext, List<MailRecipient> listOfRecipients, List<String> aListOfFiles, String aMessage, int numberOfRetries)
            throws IOException, QueueException
    {
        MailMessage aMailMessage = new MailMessage();
        aMailMessage.setSiteContext(aSiteContext);
        aMailMessage.setMaxNumberOfRetries(numberOfRetries);
        aMailMessage.setListOfFiles(aListOfFiles);
        
        for (MailRecipient recipient : listOfRecipients)
        {
            aMailMessage.addRecipient(recipient);
        }
        
        MailSender theSender = getMailSender();
        if (theSender != null)
            aMailMessage.setFrom(theSender);

        aMailMessage.setSubject(getMessageTitle());
        aMailMessage.setSummary(getMessageSummary());
        aMailMessage.setText(aMessage, getContentTypeFromMessage(aMessage));
        aMailMessage.setMessageClass(getMessageClass());

        MailTransport aTransport = new MailTransport();
        aTransport.send(pcfg, aConnection, aMailMessage, getMailQueueName(), MessagePriority.qmsg_highprio);
    }

    private String getContentTypeFromMessage(String message)
    {
        return "text/html";
    }

    protected MailSender getMailSender()
    {
        if (getMessageSender() == null)
            return null;
        
        MailRecipient to4Recipient;
        MailSender theSender;
        theSender = new MailSender();
        to4Recipient = MailRecipient.newRecipient(getMessageSender(), MailRecipient.TO_RECIPIENT);
        theSender.setRecipient(to4Recipient);
        return theSender;
    }

    public void setMessageSummary(String messageSummary)
    {
        this.messageSummary = messageSummary;
    }

    public String getMessageSummary()
    {
        return messageSummary;
    }

    public void setMessageTitle(String messageTitle)
    {
        this.messageTitle = messageTitle;
    }

    public String getMessageTitle()
    {
        return messageTitle;
    }

    public void setMessageSender(String messageSender)
    {
        this.messageSender = messageSender;
    }

    public String getMessageSender()
    {
        return messageSender;
    }

    public void setMessageClass(String messageClass)
    {
        this.messageClass = messageClass;
    }

    public String getMessageClass()
    {
        return messageClass;
    }
}

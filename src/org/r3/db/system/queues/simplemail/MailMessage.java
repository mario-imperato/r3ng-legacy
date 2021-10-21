package org.r3.db.system.queues.simplemail;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.r3.db.system.queues.model.QueueMessage;

public class MailMessage extends QueueMessage
{
    private int            maxNumberOfRetries = 1;
    private int            numberOfRetries = 0;
    public  String         error  = null;
    private String         status = null;
    
    private MailSender from      = null;
    
    private ArrayList<MailRecipient> listOfRecipients = null;
    private String                   attachmentFileName = null;
    
    private List<String>             listOfFiles = null;
    
    private String   text              = null;
    private String   textContentType   = null;
    
    private String   summary           = null;
    private String   subject           = null;
    
    public MailMessage()
    {
        setNumberOfRetries(0);    
        setMessageProcessor(MailQueueMessageProcessor.class);	
    }
    
    // Questo campo e' in diretta relazione con il campo inboxClassId che permette di
    // introdurre delle policy di gestione.
    private String   messageClass      = null;
    
    public void addRecipient(MailRecipient aRecipient)
    {
       if (listOfRecipients == null)  listOfRecipients = new ArrayList<MailRecipient>();
       listOfRecipients.add(aRecipient);
    }

	public List<MailRecipient> getRecipients(int aRecipientType, int aRecipientRole) 
	{
	    // Torno la lista completa nel caso li voglio tutti oppure non ve ne sia nessuno
	    if ((aRecipientType == Recipient.ANY_RECIPIENTTYPE && aRecipientRole == MailRecipient.ANY_RECIPIENTROLE) || 
	            listOfRecipients == null) 
	         return listOfRecipients;
	    	    
	    ArrayList<MailRecipient> aList = null;
	    for( MailRecipient aRecipient : listOfRecipients )
	    {
	        if (((aRecipientType != Recipient.ANY_RECIPIENTTYPE && aRecipient.getRecipientType() == aRecipientType)  ||
	             aRecipientType  == Recipient.ANY_RECIPIENTTYPE) &&
	             ((aRecipientRole != MailRecipient.ANY_RECIPIENTROLE && aRecipient.getRecipientRole() == aRecipientRole) ||
	             aRecipientRole   == MailRecipient.ANY_RECIPIENTROLE)	            
	            )
	        {
	            if (aList == null) aList = new ArrayList<MailRecipient>();
	            aList.add(aRecipient);
	        }	              
	    }
	    
		return aList;
	}

	public int getNumberOfRecipients(int aRecipientType, int aRecipientRole) 
	{
	    // Torno la lista completa nel caso li voglio tutti oppure non ve ne sia nessuno
	    if ((aRecipientType == Recipient.ANY_RECIPIENTTYPE && aRecipientRole == MailRecipient.ANY_RECIPIENTROLE) || 
	            listOfRecipients == null) 
	         return (listOfRecipients == null) ? 0 : listOfRecipients.size();
	    	    
	    int numberOfRecipients = 0;	    
	    for( MailRecipient aRecipient : listOfRecipients )
	    {
	        if (((aRecipientType != Recipient.ANY_RECIPIENTTYPE && aRecipient.getRecipientType() == aRecipientType)  ||
	             aRecipientType  == Recipient.ANY_RECIPIENTTYPE) &&
	             ((aRecipientRole != MailRecipient.ANY_RECIPIENTROLE && aRecipient.getRecipientRole() == aRecipientRole) ||
	             aRecipientRole   == MailRecipient.ANY_RECIPIENTROLE)	            
	            )
	        {
	            numberOfRecipients++;
	        }	              
	    }
	    
		return numberOfRecipients;
	}
	
	public boolean hasInternetRecipients()
	{
	    return getNumberOfRecipients(Recipient.INET_ADDRESS, MailRecipient.ANY_RECIPIENTROLE) > 0 ? true : false;
	}
	
	public boolean hasSystemRecipients()
	{
	    return getNumberOfRecipients(Recipient.SYSTEM_ID, MailRecipient.ANY_RECIPIENTROLE) > 0 ? true : false;	    
	}
	
	/**
	 * @return Returns the from.
	 */
	public MailSender getFrom() {
		return from;
	}
	
	/**
	 * @param from The from to set.
	 */
	public void setFrom(MailSender aFrom) {
		this.from = aFrom;
		
	}
	
	/**
	 * @return Returns the subject.
	 */
	public String getSubject() {
		return subject;
	}
	
	/**
	 * @param subject The subject to set.
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/**
	 * @return Returns the text.
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * @param text The text to set.
	 */
	public void setText(String text) {
		setText(text, null);
	}

    /**
     * @param text The text to set.
     */
    public void setText(String text, String aContentType) {
        this.text = text;
        textContentType = aContentType;
    }

    public boolean isHtml()
    {
        if (textContentType != null && textContentType.equalsIgnoreCase("text/html"))
            return true;
        
        return false;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    public void setMaxNumberOfRetries(int numberOfRetries)
    {
        maxNumberOfRetries = numberOfRetries;
    }
    
    public int getMaxNumberOfRetries()
    {
        return maxNumberOfRetries;
    }
    
    public void setNumberOfRetries(int numberOfRetries)
    {
        this.numberOfRetries = numberOfRetries > 0 ? numberOfRetries : 1;
    }

    public int getNumberOfRetries()
    {
        return numberOfRetries;
    }

    public void incNumberOfRetries()
    {
        numberOfRetries++;    
    }

    public void setSummary(String summary)
    {
        this.summary = summary;
    }

    public String getSummary()
    {
        return summary;
    }

    public void setMessageClass(String messageClass)
    {
        this.messageClass = messageClass;
    }

    public String getMessageClass()
    {
        return messageClass;
    }

    public void setListOfFiles(List<String> aListOfFiles)
    {
        listOfFiles = aListOfFiles;	
    }

    public List<String> getListOfFiles()
    {
        return listOfFiles;	
    }

//    public void setAttachmentFileName(String attachmentFileName)
//	{
//		this.attachmentFileName = attachmentFileName;
//	}
//
//	public String getAttachmentFileName()
//	{
//		return attachmentFileName;
//	}

	public String toString()
    {
    	StringBuffer stb = new StringBuffer();
    	stb.append("MAIL: \n")
           .append("da: ").append(from);
    	
        stb.append("\na: ");
        List aList = this.getRecipients(Recipient.ANY_RECIPIENTTYPE, MailRecipient.TO_RECIPIENT);
        if (aList != null)
        {
            ListIterator iter = aList.listIterator();
            for ( ; iter.hasNext(); )
            {
			   stb.append(iter.next()).append("  ");
            }
        }
        
        stb.append("\ncc: ");
        aList = this.getRecipients(Recipient.ANY_RECIPIENTTYPE, MailRecipient.CC_RECIPIENT);
        if (aList != null)
        {
            ListIterator iter = aList.listIterator();
            for ( ; iter.hasNext(); )
            {
			   stb.append(iter.next()).append("  ");
            }
        }

        stb.append("\nbcc: ");
        aList = this.getRecipients(Recipient.ANY_RECIPIENTTYPE, MailRecipient.BCC_RECIPIENT);
        if (aList != null)
        {
            ListIterator iter = aList.listIterator();
            for ( ; iter.hasNext(); )
            {
			   stb.append(iter.next()).append("  ");
            }
        }        

		stb.append("\n Titolo: ").append(subject);
		if (summary != null)  stb.append("Summary: ").append(summary);
		stb.append("\n\n").append(text);
        
        return stb.toString();
    }

    public boolean tooManyRetries()
    {
        if (numberOfRetries > maxNumberOfRetries && maxNumberOfRetries >= 0)
            return true;
        
        return false;
    }    
    
}
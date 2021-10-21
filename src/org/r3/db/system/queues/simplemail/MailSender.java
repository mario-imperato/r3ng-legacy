/*
 * Created on 16-giu-2005
 *
 */
package org.r3.db.system.queues.simplemail;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class MailSender implements Serializable
{
    private Recipient internetRecipient = null;
    private Recipient systemRecipient   = null;
    
    /**
     * 
     */
    public MailSender()
    {
        super();
    }

    public void setRecipient(Recipient aRecipient)
    {
        if (aRecipient.isSystemRecipient())
            this.systemRecipient = aRecipient;
        
        if (aRecipient.isInternetRecipient())
            this.internetRecipient = aRecipient;        
    }

    public Recipient getSystemRecipient()
    {
        return systemRecipient;
    }

    public Recipient getInternetRecipient()
    {
        return internetRecipient;
    }

    public String toString()
    {
        StringBuffer stb = new StringBuffer();
        if (getInternetRecipient() != null) stb.append(getInternetRecipient()).append(" ");
        if (getSystemRecipient()   != null) stb.append(getSystemRecipient());
        
        return stb.toString();
    }
}

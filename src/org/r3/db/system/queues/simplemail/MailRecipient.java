/*
 * Created on 15-giu-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Precipients - Java - Code Style - Code Templates
 */
package org.r3.db.system.queues.simplemail;


/**
 * @author Administrator
 *
 */
public class MailRecipient extends Recipient
{
    public static final int ANY_RECIPIENTROLE = -1;
    
    public static final int TO_RECIPIENT   = 0;
    public static final int CC_RECIPIENT   = 1;
    public static final int BCC_RECIPIENT  = 2;
        
    private int    recipientRole = TO_RECIPIENT;
    
    public MailRecipient(String aRecipientId, int aRecipientRole, int aRecipientType)
    {
        super(aRecipientId, aRecipientType);
        recipientRole = aRecipientRole;
    }

//    public void setRecipient(String aRecipientId)
//    {
//        setRecipientId(aRecipientId, INET_ADDRESS, TO_RECIPIENT);
//    }
//
//    public void setInternetRecipient(String aRecipientId)
//    {
//        setRecipientId(aRecipientId, INET_ADDRESS, TO_RECIPIENT);
//    }
//    
//    public void setInternetRecipient(String aRecipientId, int aRecipientRole)
//    {
//        setRecipientId(aRecipientId, INET_ADDRESS, aRecipientRole);
//    }
//
//    public void setSystemRecipient(String aRecipientId)
//    {
//        setRecipientId(aRecipientId, SYSTEM_ID, TO_RECIPIENT);
//    }
//
//    public void setSystemRecipient(String aRecipientId, int aRecipientRole)
//    {
//        setRecipientId(aRecipientId, SYSTEM_ID, aRecipientRole);
//    }
//
//    protected void setRecipientId(String aRecipientId, int aRecipientType, int aRecipientRole)
//    {
//        super.setRecipientId(aRecipientId, aRecipientType);
//        this.recipientRole = aRecipientRole;
//    }

    public int getRecipientRole()
    {
        return recipientRole;
    }       

    public static MailRecipient newRecipient(String aRecipientId)
    {
        return newRecipient(aRecipientId, TO_RECIPIENT);
    }

    public static MailRecipient newRecipient(String aRecipientId, int aRecipientRole)
    {
        if (isInternetRecipient(aRecipientId))
            return new InternetRecipient(aRecipientId, aRecipientRole);
        
        return new SystemRecipient(aRecipientId, aRecipientRole);
    }
    
    public static boolean isInternetRecipient(String aRecipientId)
    {
        if (aRecipientId != null && aRecipientId.indexOf('@') >= 0)
            return true;
        
        return false;
    }

    public static boolean isSystemRecipient(String aRecipientId)
    {
        if (aRecipientId != null && aRecipientId.indexOf('@') < 0)
            return true;
        
        return false;
    }

}

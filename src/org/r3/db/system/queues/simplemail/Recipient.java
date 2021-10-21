/*
 * Created on 16-giu-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.r3.db.system.queues.simplemail;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class Recipient implements Serializable
{    
    public static final int ANY_RECIPIENTTYPE = -1;
    public static final int SYSTEM_ID         = 0;
    public static final int INET_ADDRESS      = 1;
    
    private String recipientId = null;
    
    private int    recipientType = SYSTEM_ID;
    
    public Recipient(String aRecipientId, int aRecipientType)
    {
        super();
        recipientId = aRecipientId;
        recipientType = aRecipientType;
    }

//    public void setRecipient(String aRecipientId)
//    {
//        setRecipientId(aRecipientId, INET_ADDRESS);
//    }
//
//    public void setInternetRecipient(String aRecipientId)
//    {
//        setRecipientId(aRecipientId, INET_ADDRESS);
//    }
//
//    public void setSystemRecipient(String aRecipientId)
//    {
//        setRecipientId(aRecipientId, SYSTEM_ID);
//    }
//
//    protected void setRecipientId(String aRecipientId, int aRecipientType)
//    {
//        this.recipientId = aRecipientId;
//        this.recipientType = aRecipientType;
//    }

    public String getRecipientId()
    {
        return recipientId;
    }
    
    public int getRecipientType()
    {
        return recipientType;
    }
    
    public boolean isSystemRecipient()
    {
        return recipientType == SYSTEM_ID;   
    }
    
    public boolean isInternetRecipient()
    {
        return recipientType == INET_ADDRESS;   
    }
    
    public String toString()
    {
        return recipientId;       
    }
    
}

package org.r3.db.system.queues.simplemail;

public class InternetRecipient extends MailRecipient
{

    public InternetRecipient(String aRecipientId, int aRecipientRole)
    {
        super(aRecipientId, aRecipientRole, INET_ADDRESS);
    }

}

package org.r3.db.system.queues.simplemail;

public class SystemRecipient extends MailRecipient
{
    public SystemRecipient(String aRecipientId, int aRecipientRole)
    {
        super(aRecipientId, aRecipientRole, SYSTEM_ID);
    }

}

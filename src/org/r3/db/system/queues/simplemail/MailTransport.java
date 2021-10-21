/*
 * Created on 16-giu-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.r3.db.system.queues.simplemail;

import java.util.List;
import java.util.ListIterator;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.queues.model.Queue;
import org.r3.db.system.queues.model.QueueException;
import org.r3.db.system.queues.model.QueueMessage.MessagePriority;

/**
 * @author Administrator
 *
 */
public class MailTransport
{
    /**
     *
     */
    public MailTransport()
    {
        super();
    }

    public void send(PersistenceContext pcfg, SqlSession aConnection, MailMessage aMessage, MessagePriority aPriority)
            throws QueueException
    {
         send(pcfg, aConnection, aMessage, null, aPriority);
    }

    public void send(PersistenceContext pcfg, SqlSession aConnection, MailMessage aMessage, String queueName, MessagePriority aPriority)
            throws QueueException
    {
         aMessage.setPriority(aPriority);
         if (aMessage.hasSystemRecipients())
         {
              enqueueSystemMessage(pcfg, aConnection, aMessage);
         }

         if (aMessage.hasInternetRecipients())
         {
              enqueueInternetMessage(pcfg, aConnection, aMessage, queueName);
         }
    }

    private void enqueueSystemMessage(PersistenceContext pcfg, SqlSession aConnection, MailMessage aMessage)                
    {
        List aList = aMessage.getRecipients(Recipient.SYSTEM_ID, MailRecipient.ANY_RECIPIENTROLE);
        if (aList != null)
        {
            MailSender theSender = aMessage.getFrom();
            ListIterator iter = aList.listIterator();
            for( ; iter.hasNext(); )
            {
                Recipient r = (Recipient)iter.next();
                createInboxMessage(pcfg, aConnection, r, theSender, aMessage);
            }
        }
    }

    private void createInboxMessage(
    				 PersistenceContext pcfg, SqlSession aConnection,
                     Recipient aSystemRecipient, MailSender aSender, MailMessage aMessage)     
    {
    }
    
    private void enqueueInternetMessage(PersistenceContext pcfg, SqlSession aConnection, MailMessage aMessage, String queueName)
            throws QueueException
    {
        if (queueName == null)
            queueName = "MailQueue";

        Queue aQueue = getSendQueue(pcfg, aConnection, queueName);
        if (aQueue != null)
        {
            aQueue.put(aMessage);
        }
    }

    protected Queue getSendQueue(PersistenceContext pcfg, SqlSession aConnection, String aQueueName) throws QueueException
    {
        Queue aQueue = null;
        // System.out.println("queuename = " + queueName);
        if (aQueueName != null)
        {
            aQueue = Queue.newInstance(pcfg, aConnection, aQueueName);
        }

        return aQueue;
    }

}
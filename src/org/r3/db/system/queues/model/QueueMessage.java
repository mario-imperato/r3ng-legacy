/*
 * Created on 2-feb-2005
 *
 */
package org.r3.db.system.queues.model;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.r3.db.system.siteproperty.SitePropertyDTO.SiteIdentifier;
import org.r3.system.util.Codecs;

/**
 * @author Administrator
 *
 */
public class QueueMessage implements Serializable
{
    private static final long serialVersionUID = 1000000L;
    
    public enum MessageStatus   { qmsg_deleted, qmsg_active, qmsg_consumed, qmsg_failed };
    public enum MessagePriority { qmsg_lowprio, qmsg_midprio, qmsg_highprio };
        
    private String   siteContext;
    private String   messageId;
    private String   correlationId;
    private String   messageProcessor;
    private MessagePriority  priority;
    private String   srcMessageId;
    
    private int            maxNumberOfRetries = -1;
    private int            numberOfRetries = 0;

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

    public boolean tooManyRetries()
    {
        if (numberOfRetries > maxNumberOfRetries && maxNumberOfRetries >= 0)
            return true;
        
        return false;
    }    

    /**
     * 
     */
    public QueueMessage()
    {
        super();
        priority = MessagePriority.qmsg_lowprio;
        siteContext = SiteIdentifier.__any__.toString();
    }

    public void setSiteContext(String aSite)
    {
        siteContext = aSite;	
    }
        
    public String getSiteContext()
	{
		return siteContext;
	}

	public void setPriority(MessagePriority priority)
    {
        this.priority = priority;
    }

    public MessagePriority getPriority()
    {
        return priority;
    }

    public String getSrcMessageId()
	{
		return srcMessageId;
	}

	public void setSrcMessageId(String srcMessageId)
	{
		this.srcMessageId = srcMessageId;
	}
	
    public void setMessageProcessor(Class anObjectClass)
    {
        if (anObjectClass == null ) this.messageProcessor = null;
        else this.messageProcessor = anObjectClass.getName();
    }

    public String getMessageProcessor()
    {
        return messageProcessor;
    }

    public QueueMessageProcessor getMessageProcessorInstance()
    {
    	if (getMessageProcessor() != null)
    	{
			try
			{
				Class c = Class.forName(getMessageProcessor());
	            Object o = c.newInstance();
	            if (o instanceof QueueMessageProcessor)
	            	return (QueueMessageProcessor)o;
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (InstantiationException e)
			{
				e.printStackTrace();
			}
			catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
    	}
    	
        return null;
    }
    
    public void setCorrelationid(String aCorrelationId)
    {
        this.correlationId = aCorrelationId;
    }

    public String getCorrelationid()
    {
        return correlationId;
    }

    public void setMessageid(String messageid)
    {
        this.messageId = messageid;
    }

    public String getMessageid()
    {
        return messageId;
    }

    /**
     * Metodo per ottenere una serializzazione della primarykey.
     */ 
   public String toSerializedString()
   {
       ObjectOutputStream os;
       String serializedString = null;
       
       try
       {
           ByteArrayOutputStream baos = new ByteArrayOutputStream();
           os = new ObjectOutputStream(baos);
           os.writeObject(this);
           os.close();
           
           serializedString = Codecs.byteToHex(baos.toByteArray());
       }
       catch (IOException e)
       {
           e.printStackTrace();
       }

       return serializedString;
   }

   public byte[] toSerializedByteArray()
   {
       ObjectOutputStream os;
       
       try
       {
           ByteArrayOutputStream baos = new ByteArrayOutputStream();
           os = new ObjectOutputStream(baos);
           os.writeObject(this);
           os.close();
           
           return baos.toByteArray();
       }
       catch (IOException e)
       {
           e.printStackTrace();
       }

       return null;
   }

// COMMENTED
//   public void enqueue(PersistenceContext pcfg, SqlSession aSession, String queueName) throws QueueException
//   {	   
//       Queue theQueue = Queue.newInstance(pcfg, aSession, queueName);           
//       theQueue.put(pcfg, aSession, this);
//   }
   public boolean process(QueueProcessorContext processContext) throws QueueMessageProcessorException
   {
		QueueMessageProcessor mproc = getMessageProcessorInstance();
		if (mproc != null)
		{
			try
			{
				mproc.initialize(siteContext, processContext);
			    boolean b = mproc.process(processContext, this);
			    return b;
			}
			finally
			{
				mproc.release();
			}
		}
		
		return true;
   }

   public static QueueMessage newQueueMessageFromSerializedVersion(String aSerializedMessage)
   {
       return newQueueMessageFromSerializedVersion(Codecs.hexToByteArray(aSerializedMessage));
   }

   public static QueueMessage newQueueMessageFromSerializedVersion(byte[] aSerializedMessage)
   {        
       ObjectInputStream ois;
       Object            deserializedObject = null;
       try
       {
           ByteArrayInputStream bais = new ByteArrayInputStream(aSerializedMessage);
           ois = new ObjectInputStream(bais);
           deserializedObject = ois.readObject();
           ois.close();            
       }
       catch (IOException e)
       {
           e.printStackTrace();
       }
       catch (ClassNotFoundException e)
       {
           e.printStackTrace();
       }

       if (deserializedObject instanceof QueueMessage)
            return (QueueMessage)deserializedObject;
            
       return null;
   }

}

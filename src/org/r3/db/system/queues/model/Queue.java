/*
 * Created on 2-feb-2005
 *
 */
package org.r3.db.system.queues.model;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.queues.queue.QueueDTO;
import org.r3.db.system.queues.queue.QueueMapper;
import org.r3.db.system.queues.queue.QueuePersistence;
import org.r3.db.system.queues.queuemessage.QueueMessageDTO;
import org.r3.db.system.queues.queuemessage.QueueMessagePersistence;
import org.r3.db.system.queues.queuework.QueueWorkDTO;
import org.r3.db.system.queues.queuework.QueueWorkPersistence;
import org.r3.db.utils.BlobDTO;

/**
 * @author Administrator
 *  
 */
public class Queue
{
    private QueueDTO queueDataBean = null;
	private QueuePersistence queuePersistence;
    private QueueMessagePersistence messagePersistence;
    private QueueWorkPersistence workQueuePersistence;
    private PersistenceContext pcfg;
    
    private Queue  deadQueue;
    private Queue  notifyQueue;
    private Queue  retryQueue;
    
    /**
     *  
     */
    protected Queue(PersistenceContext aPcfg, 
    				QueuePersistence pq, 
    				QueueMessagePersistence p, 
    				QueueWorkPersistence workp,
    				QueueDTO aQueueDataBean)
    {
        super();
        queueDataBean = aQueueDataBean;
        messagePersistence = p;
        pcfg = aPcfg;
        queuePersistence = pq;
        workQueuePersistence = workp;
    }
    
    public static Queue newInstance(PersistenceContext pcfg, SqlSession aConnection, String aQueueName) throws QueueException
    {
        Queue aQueue = null;

        QueueDTO aQueueDataBean;
        try
        {
        	QueuePersistence p = new QueuePersistence();
        	p.setMapper(aConnection.getMapper(QueueMapper.class));
        	
        	aQueueDataBean = p.selectByQueueid(aQueueName, pcfg.getPersistenceConfigInfo());
        	
            if (aQueueDataBean != null)
            {
            	QueueMessagePersistence pm = QueueMessagePersistence.createPersistenceObject(pcfg, aConnection);
            	QueueWorkPersistence wp = QueueWorkPersistence.createPersistenceObject(pcfg, aConnection);
                aQueue = new Queue(pcfg, p, pm, wp, aQueueDataBean);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new QueueException(e);
        }

        return aQueue;
    }

	public Queue getNotifyQueue() throws QueueException
	{
		if (notifyQueue == null)
			notifyQueue = getQueue(pcfg, queuePersistence, messagePersistence, null, queueDataBean.getNotifyqueueid());

		return notifyQueue;
	}

	public Queue getDeadQueue() throws QueueException
	{
		if (deadQueue == null)
			deadQueue = getQueue(pcfg, queuePersistence, messagePersistence, null, queueDataBean.getDeadqueueid());

		return deadQueue;
	}

	public Queue getRetryQueue() throws QueueException
	{
		if (retryQueue == null)
			retryQueue = getQueue(pcfg, queuePersistence, messagePersistence, null, queueDataBean.getRetryqueueid());

		return retryQueue;
	}

	private Queue getQueue(PersistenceContext pcfg, QueuePersistence p, QueueMessagePersistence pm, QueueWorkPersistence wp, String aQueueName) throws QueueException
	{
		Queue aQueue = null;
		if (aQueueName != null)
		{
			QueueDTO aQueueDataBean = p.selectByQueueid(aQueueName, pcfg.getPersistenceConfigInfo());
        	
            if (aQueueDataBean != null)
            {
                aQueue = new Queue(pcfg, p, pm, wp, aQueueDataBean);
            }			
		}

		return aQueue;
	}

    public String workQueue(String ambitId, String entityId)
                    throws QueueException
    {
    	return workQueue(ambitId, entityId, null);
    }
    
    public String workQueue(String ambitId, String entityId, String messageType)
                    throws QueueException
    {
    	QueueWorkDTO aQueueMessageDataBean = new QueueWorkDTO();
    	aQueueMessageDataBean.setQueueid(queueDataBean.getQueueid());
    	aQueueMessageDataBean.setRefambitid(ambitId);
    	aQueueMessageDataBean.setRefentityid(entityId);
    	aQueueMessageDataBean.setMessagestatus(QueueMessage.MessageStatus.qmsg_active.toString());
    	aQueueMessageDataBean.setMessagetype(messageType);
    	
        try
        {
        	workQueuePersistence.insert(aQueueMessageDataBean, pcfg.getPersistenceConfigInfo());
            return aQueueMessageDataBean.getQueueworkid();            
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new QueueException(e);
        }
        finally
        {
        }        
    }
    
    public void put(QueueMessage aMessage)
                  throws QueueException
    {
        QueueMessageDTO aQueueMessageDataBean = new QueueMessageDTO();
        aQueueMessageDataBean.setMessagestatus(QueueMessage.MessageStatus.qmsg_active.toString());
        aQueueMessageDataBean.setQueueid(queueDataBean.getQueueid());
        aQueueMessageDataBean.setPutdate();        
        aQueueMessageDataBean.setPriority(aMessage.getPriority().toString());
        aQueueMessageDataBean.setMessagetype(aMessage.getMessageProcessor());
        aQueueMessageDataBean.setCorrelationid(aMessage.getCorrelationid());      
        
        // In questo caso provvedo ad aggiornare il source message id. 
        // Nel caso in cui siano entrambi null l'operazione non ha effetto. L'operazione ha effetto solo se si tratta di una put corrispondente
        // ad una get di un messaggio presente (esempio retryQueue oppure deadQueue). In questo caso dovrebbe mantenersi il messaggio originale
        // 
        if (aMessage.getSrcMessageId() == null)
        	aMessage.setSrcMessageId(aMessage.getMessageid());
        
       aQueueMessageDataBean.setSrcqueuemessageid(aMessage.getMessageid());
       
        // aQueueMessageDataBean.setPutaddress(GWFQueueMessageEntity.getHostAddress());       
    	
        try
        {
        	messagePersistence.insert(aQueueMessageDataBean, pcfg.getPersistenceConfigInfo());
            aMessage.setMessageid(aQueueMessageDataBean.getQueuemessageid());
            
            messagePersistence.storeMessagebodyByQueuemessageid(aMessage.toSerializedByteArray(), aQueueMessageDataBean.getQueuemessageid(), pcfg.getPersistenceConfigInfo());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new QueueException(e);
        }
        finally
        {
        }
    }

    public QueueMessage get()  throws QueueException
    {
        return get(false);
    }

    public QueueMessage peek() throws QueueException
    {
        return get(true);
    }

    public QueueMessage get(boolean peekOnly) throws QueueException
    {
        QueueMessage resultMessage = null;
        
        try
        {
            List<QueueMessageDTO> aListOfDataBean = null;
                        
            if (queueDataBean.isLocalQueue())
            {
               // Limita la ricerca a quei messaggi che sono stati inseriti dal localhost
               aListOfDataBean = messagePersistence.selectByQueueidMessagestatusPutaddress(
            				   queueDataBean.getQueueid(), QueueMessage.MessageStatus.qmsg_active.toString(), null, pcfg.getPersistenceConfigInfo());
            }               
            else
                aListOfDataBean = messagePersistence.selectByQueueidMessagestatusPutaddress(
             				   queueDataBean.getQueueid(), QueueMessage.MessageStatus.qmsg_active.toString(), null, pcfg.getPersistenceConfigInfo());
            
            if (aListOfDataBean == null || (aListOfDataBean != null && aListOfDataBean.size() == 0))
            {
            	System.out.printf("%s could not find a message\n", Thread.currentThread().getName());
            	return null;            	
            }
            
            for(QueueMessageDTO aDataBean : aListOfDataBean)
            {
                resultMessage = consumeMessage(aDataBean, peekOnly);
                if (resultMessage == null)
                	System.out.printf("%s could not consume the message %s\n", Thread.currentThread().getName(), aDataBean.getQueuemessageid());

                if (resultMessage != null)
                    break;
            }  
            
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new QueueException(e);
        }

        return resultMessage;
    }

    /*
     * Provo ad ottenere il messaggio e a consumarlo secondo una logica di locking ottimistico. In partica se non riesco a cambiare lo stato
     * ritorno null...... Evidentemente un altro thread sta operando sul record...
     */
    private QueueMessage consumeMessage(
               QueueMessageDTO aDataBean, 
               boolean peekOnly)
    {
        ByteArrayOutputStream baos = null;
        QueueMessage resultMessage = null;
                
        try
        {
            BlobDTO aBlob = messagePersistence.selectMessagebodyByQueuemessageid(aDataBean.getQueuemessageid(), pcfg.getPersistenceConfigInfo());
            
            if (aBlob != null && aBlob.size() > 0)
            {
               resultMessage = QueueMessage.newQueueMessageFromSerializedVersion(aBlob.getBlobData());
            }

            // Se per qualche ragione (campo nullo piuttosto che errore nella fase di deserializzazione)
            // il messaggio viene marcato come fallito.
            int impactedRows = 1;
            if (resultMessage == null)
            {
                	impactedRows = messagePersistence.markAsFailedByMessageid(aDataBean.getQueuemessageid(), pcfg.getPersistenceConfigInfo());
            }
            else
            {
                if (!peekOnly)
                    impactedRows = messagePersistence.markAsConsumedByMessageid(aDataBean.getQueuemessageid(), pcfg.getPersistenceConfigInfo());
            }            
            
            if (impactedRows == 0)
            {
                resultMessage = null;
            }
        }
        finally
        {
        }
        
        return resultMessage;
    }
    
    public QueueMessage getFirst(String aReferenceMessageId) throws QueueException
    {
        List<QueueMessage> aListOf = get(aReferenceMessageId, 1, false);
        if (aListOf != null && aListOf.size() > 0)
        {
            return aListOf.get(0);
        }
        
        return null;
    }
    
    public List<QueueMessage> get(String aReferenceMessageId) throws QueueException
    {
        return get(aReferenceMessageId, 1, false);
    }

    public List<QueueMessage> get(String aReferenceMessageId, int fetchLimit) throws QueueException
    {
        return get(aReferenceMessageId, fetchLimit, false);
    }

    public List<QueueMessage> peek(String aReferenceMessageId) throws QueueException
    {
        return get(aReferenceMessageId, 1, true);
    }

    public List<QueueMessage> peek(String aReferenceMessageId, int fetchLimit) throws QueueException
    {
        return get(aReferenceMessageId, fetchLimit, true);
    }

    public List<QueueMessage> get(String aCorrelationId, 
                    int fetchLimit, boolean peekOnly)
               throws QueueException
    {       
        ArrayList<QueueMessage> resultList = null;

        try
        {
            List<QueueMessageDTO> aListOfDataBean = null;

            if (queueDataBean.isLocalQueue())
            {
               // Limita la ricerca a quei messaggi che sono stati inseriti dal localhost
               aListOfDataBean = messagePersistence.selectByQueueidMessagestatusPutaddress(
            				   queueDataBean.getQueueid(), QueueMessage.MessageStatus.qmsg_active.toString(), null, pcfg.getPersistenceConfigInfo());
            }               
            else
                aListOfDataBean = messagePersistence.selectByQueueidMessagestatusPutaddress(
             				   queueDataBean.getQueueid(), QueueMessage.MessageStatus.qmsg_active.toString(), null, pcfg.getPersistenceConfigInfo());
            
            if (aListOfDataBean == null || (aListOfDataBean != null && aListOfDataBean.size() == 0))
                return null;

            resultList = new ArrayList<QueueMessage>();
            for(QueueMessageDTO aDataBean : aListOfDataBean)
            {
                QueueMessage resultMessage = consumeMessage(aDataBean, peekOnly);
                if (resultMessage != null)
                    resultList.add(resultMessage);
            }            

        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new QueueException(e);
        }

        return resultList;
    }


}
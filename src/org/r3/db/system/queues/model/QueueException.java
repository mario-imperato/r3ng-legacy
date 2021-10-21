/*
 * Created on 4-feb-2005
 *
 */
package org.r3.db.system.queues.model;

/**
 * @author Administrator
 *
 */
public class QueueException extends Exception
{

    /**
     * 
     */
    public QueueException()
    {
        super();
    }

    /**
     * @param message
     */
    public QueueException(String message)
    {
        super(message);
    }

    /**
     * @param cause
     */
    public QueueException(Throwable cause)
    {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public QueueException(String message, Throwable cause)
    {
        super(message, cause);
    }

}

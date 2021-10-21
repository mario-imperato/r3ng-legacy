//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.queues.queuework;

public class QueueWorkKey
{
    protected java.lang.String  queueworkid;


    /**
      * DataBean constructor.
      */
    public QueueWorkKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public QueueWorkKey(QueueWorkKey another) 
    {    	
       queueworkid = another.getQueueworkid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getQueueworkid()         { return queueworkid; }
    
    public void setQueueworkid(String  p)
    {
         queueworkid = p;
    }
}

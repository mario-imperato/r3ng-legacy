//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.queues.queuemessage;

public class QueueMessageDTO extends QueueMessageDTOBase
{
    public QueueMessageDTO()
    {
        super();
    }

    public QueueMessageDTO(QueueMessageDTO another)
    {
        super(another);
    }

    public void setPutdate()
    {
        setPutdate(currentTimestamp());        
    }

}

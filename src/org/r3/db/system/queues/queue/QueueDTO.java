//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.queues.queue;

public class QueueDTO extends QueueDTOBase
{
    public QueueDTO()
    {
        super();
    }

    public QueueDTO(QueueDTO another)
    {
        super(another);
    }

    public boolean isLocalQueue()
    {
    	return false;
    }

}

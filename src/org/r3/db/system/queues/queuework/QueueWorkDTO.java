//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.queues.queuework;

public class QueueWorkDTO extends QueueWorkDTOBase
{
	public enum WorkQueue { 
		queuerest_post, queuerest_pub, queuerest_esiti, queuerest_image, docqueue, queueinesitati,
	    queuefastexpire	
	};
	
    public QueueWorkDTO()
    {
        super();
    }

    public QueueWorkDTO(QueueWorkDTO another)
    {
        super(another);
    }

}

//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.outmailattachment;

public class OutMailAttachmentKey
{
    protected java.lang.String  attachmentid;


    /**
      * DataBean constructor.
      */
    public OutMailAttachmentKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public OutMailAttachmentKey(OutMailAttachmentKey another) 
    {    	
       attachmentid = another.getAttachmentid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getAttachmentid()         { return attachmentid; }
    
    public void setAttachmentid(String  p)
    {
         attachmentid = p;
    }
}

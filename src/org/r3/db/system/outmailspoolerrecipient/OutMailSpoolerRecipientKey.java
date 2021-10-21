//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.outmailspoolerrecipient;

public class OutMailSpoolerRecipientKey
{
    protected java.lang.Integer  recipientid;


    /**
      * DataBean constructor.
      */
    public OutMailSpoolerRecipientKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public OutMailSpoolerRecipientKey(OutMailSpoolerRecipientKey another) 
    {    	
       recipientid = another.getRecipientid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.Integer   getRecipientid() { return recipientid; }
    
    public void setRecipientid(java.lang.Integer  p)
    {
    	recipientid = p;
    }
    public void setRecipientid(int p)
    {
    	setRecipientid(new java.lang.Integer(p));
    }
    public void setRecipientid()
    {
    	setRecipientid(0);
    }
}

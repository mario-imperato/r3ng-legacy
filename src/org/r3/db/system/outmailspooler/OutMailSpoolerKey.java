//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.outmailspooler;

public class OutMailSpoolerKey
{
    protected java.lang.String  site;
    protected java.lang.String  messageid;


    /**
      * DataBean constructor.
      */
    public OutMailSpoolerKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public OutMailSpoolerKey(OutMailSpoolerKey another) 
    {    	
       site = another.getSite();
       messageid = another.getMessageid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getSite()         { return site; }
    
    public void setSite(String  p)
    {
         site = p;
    }
    
    public java.lang.String   getMessageid()         { return messageid; }
    
    public void setMessageid(String  p)
    {
         messageid = p;
    }
}

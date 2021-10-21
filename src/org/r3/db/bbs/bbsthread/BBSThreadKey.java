//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.bbs.bbsthread;

public class BBSThreadKey
{
    protected java.lang.String  site;
    protected java.lang.String  threadid;


    /**
      * DataBean constructor.
      */
    public BBSThreadKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public BBSThreadKey(BBSThreadKey another) 
    {    	
       site = another.getSite();
       threadid = another.getThreadid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getSite()         { return site; }
    
    public void setSite(String  p)
    {
         site = p;
    }
    
    public java.lang.String   getThreadid()         { return threadid; }
    
    public void setThreadid(String  p)
    {
         threadid = p;
    }
}

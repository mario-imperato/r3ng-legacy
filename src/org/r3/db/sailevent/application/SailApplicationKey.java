//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.application;

public class SailApplicationKey
{
    protected java.lang.String  eventid;
    protected java.lang.String  applicationid;


    /**
      * DataBean constructor.
      */
    public SailApplicationKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public SailApplicationKey(SailApplicationKey another) 
    {    	
       eventid = another.getEventid();
       applicationid = another.getApplicationid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getEventid()         { return eventid; }
    
    public void setEventid(String  p)
    {
         eventid = p;
    }
    
    public java.lang.String   getApplicationid()         { return applicationid; }
    
    public void setApplicationid(String  p)
    {
         applicationid = p;
    }
}

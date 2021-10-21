//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.event;

public class SailEventKey
{
    protected java.lang.String  eventid;


    /**
      * DataBean constructor.
      */
    public SailEventKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public SailEventKey(SailEventKey another) 
    {    	
       eventid = another.getEventid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getEventid()         { return eventid; }
    
    public void setEventid(String  p)
    {
         eventid = p;
    }
}

//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.orc.rms;

public class RMSKey
{
    protected java.lang.String  rmsid;


    /**
      * DataBean constructor.
      */
    public RMSKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public RMSKey(RMSKey another) 
    {    	
       rmsid = another.getRmsid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getRmsid()         { return rmsid; }
    
    public void setRmsid(String  p)
    {
         rmsid = p;
    }
}

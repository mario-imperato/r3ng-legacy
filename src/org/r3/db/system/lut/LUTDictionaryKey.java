//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.lut;

public class LUTDictionaryKey
{
    protected java.lang.String  lutid;


    /**
      * DataBean constructor.
      */
    public LUTDictionaryKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public LUTDictionaryKey(LUTDictionaryKey another) 
    {    	
       lutid = another.getLutid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getLutid()         { return lutid; }
    
    public void setLutid(String  p)
    {
         lutid = p;
    }
}

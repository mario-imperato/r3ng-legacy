//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.wbs.wbs;

public class WBSKey
{
    protected java.lang.String  site;
    protected java.lang.String  wbsid;


    /**
      * DataBean constructor.
      */
    public WBSKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public WBSKey(WBSKey another) 
    {    	
       site = another.getSite();
       wbsid = another.getWbsid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getSite()         { return site; }
    
    public void setSite(String  p)
    {
         site = p;
    }
    
    public java.lang.String   getWbsid()         { return wbsid; }
    
    public void setWbsid(String  p)
    {
         wbsid = p;
    }
}

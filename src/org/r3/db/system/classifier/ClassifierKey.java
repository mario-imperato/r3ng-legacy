//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.classifier;

public class ClassifierKey
{
    protected java.lang.String  site;
    protected java.lang.String  clsid;


    /**
      * DataBean constructor.
      */
    public ClassifierKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public ClassifierKey(ClassifierKey another) 
    {    	
       site = another.getSite();
       clsid = another.getClsid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getSite()         { return site; }
    
    public void setSite(String  p)
    {
         site = p;
    }
    
    public java.lang.String   getClsid()         { return clsid; }
    
    public void setClsid(String  p)
    {
         clsid = p;
    }
}

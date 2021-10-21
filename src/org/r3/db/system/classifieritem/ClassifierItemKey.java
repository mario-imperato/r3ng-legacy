//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.classifieritem;

public class ClassifierItemKey
{
    protected java.lang.String  clsitemid;


    /**
      * DataBean constructor.
      */
    public ClassifierItemKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public ClassifierItemKey(ClassifierItemKey another) 
    {    	
       clsitemid = another.getClsitemid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getClsitemid()         { return clsitemid; }
    
    public void setClsitemid(String  p)
    {
         clsitemid = p;
    }
}

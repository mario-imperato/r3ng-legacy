//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.wbs.wbsnode;

public class WBSNodeKey
{
    protected java.lang.String  wbsnodeid;


    /**
      * DataBean constructor.
      */
    public WBSNodeKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public WBSNodeKey(WBSNodeKey another) 
    {    	
       wbsnodeid = another.getWbsnodeid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getWbsnodeid()         { return wbsnodeid; }
    
    public void setWbsnodeid(String  p)
    {
         wbsnodeid = p;
    }
}

//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.bbs.bbsthreadnode;

public class BBSThreadNodeKey
{
    protected java.lang.String  threadnodeid;


    /**
      * DataBean constructor.
      */
    public BBSThreadNodeKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public BBSThreadNodeKey(BBSThreadNodeKey another) 
    {    	
       threadnodeid = another.getThreadnodeid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getThreadnodeid()         { return threadnodeid; }
    
    public void setThreadnodeid(String  p)
    {
         threadnodeid = p;
    }
}

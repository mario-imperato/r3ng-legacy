//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.wbs.wbsactor;

public class WBSActorKey
{
    protected java.lang.String  wbsactorid;


    /**
      * DataBean constructor.
      */
    public WBSActorKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public WBSActorKey(WBSActorKey another) 
    {    	
       wbsactorid = another.getWbsactorid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getWbsactorid()         { return wbsactorid; }
    
    public void setWbsactorid(String  p)
    {
         wbsactorid = p;
    }
}

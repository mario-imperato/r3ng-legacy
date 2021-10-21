//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.resourcetimesheet;

public class ResourceTimesheetKey
{
    protected java.lang.String  tsentryid;


    /**
      * DataBean constructor.
      */
    public ResourceTimesheetKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public ResourceTimesheetKey(ResourceTimesheetKey another) 
    {    	
       tsentryid = another.getTsentryid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getTsentryid()         { return tsentryid; }
    
    public void setTsentryid(String  p)
    {
         tsentryid = p;
    }
}

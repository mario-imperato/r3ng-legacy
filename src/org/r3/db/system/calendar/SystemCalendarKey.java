//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.calendar;

public class SystemCalendarKey
{
    protected java.lang.String  sitedomain;
    protected java.lang.String  calendarid;
    protected java.sql.Date  caldate;


    /**
      * DataBean constructor.
      */
    public SystemCalendarKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public SystemCalendarKey(SystemCalendarKey another) 
    {    	
       sitedomain = another.getSitedomain();
       calendarid = another.getCalendarid();
       caldate = another.getCaldate();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getSitedomain()         { return sitedomain; }
    
    public void setSitedomain(String  p)
    {
         sitedomain = p;
    }
    
    public java.lang.String   getCalendarid()         { return calendarid; }
    
    public void setCalendarid(String  p)
    {
         calendarid = p;
    }
    
    public java.sql.Date   getCaldate() { return caldate; }
    
    public void setCaldate(java.sql.Date  p)
    {
    	 caldate = p;
    }
}

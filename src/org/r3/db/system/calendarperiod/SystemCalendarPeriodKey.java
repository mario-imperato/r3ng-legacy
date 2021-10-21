//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.calendarperiod;

public class SystemCalendarPeriodKey
{
    protected java.lang.Integer  periodindex;
    protected java.lang.String  periodtype;


    /**
      * DataBean constructor.
      */
    public SystemCalendarPeriodKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public SystemCalendarPeriodKey(SystemCalendarPeriodKey another) 
    {    	
       periodindex = another.getPeriodindex();
       periodtype = another.getPeriodtype();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.Integer   getPeriodindex() { return periodindex; }
    
    public void setPeriodindex(java.lang.Integer  p)
    {
    	periodindex = p;
    }
    public void setPeriodindex(int p)
    {
    	setPeriodindex(new java.lang.Integer(p));
    }
    public void setPeriodindex()
    {
    	setPeriodindex(0);
    }
    
    public java.lang.String   getPeriodtype()         { return periodtype; }
    
    public void setPeriodtype(String  p)
    {
         periodtype = p;
    }
}

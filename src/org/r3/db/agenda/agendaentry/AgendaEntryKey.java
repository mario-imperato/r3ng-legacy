//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.agenda.agendaentry;

public class AgendaEntryKey
{
    protected java.lang.String  agendaentryid;


    /**
      * DataBean constructor.
      */
    public AgendaEntryKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public AgendaEntryKey(AgendaEntryKey another) 
    {    	
       agendaentryid = another.getAgendaentryid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getAgendaentryid()         { return agendaentryid; }
    
    public void setAgendaentryid(String  p)
    {
         agendaentryid = p;
    }
}

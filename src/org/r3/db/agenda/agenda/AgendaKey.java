//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.agenda.agenda;

public class AgendaKey
{
    protected java.lang.String  agendaid;


    /**
      * DataBean constructor.
      */
    public AgendaKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public AgendaKey(AgendaKey another) 
    {    	
       agendaid = another.getAgendaid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getAgendaid()         { return agendaid; }
    
    public void setAgendaid(String  p)
    {
         agendaid = p;
    }
}

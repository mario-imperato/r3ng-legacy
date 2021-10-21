//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.appcrewmember;

public class SailApplicationCrewMemberKey
{
    protected java.lang.String  crewmemberid;


    /**
      * DataBean constructor.
      */
    public SailApplicationCrewMemberKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public SailApplicationCrewMemberKey(SailApplicationCrewMemberKey another) 
    {    	
       crewmemberid = another.getCrewmemberid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getCrewmemberid()         { return crewmemberid; }
    
    public void setCrewmemberid(String  p)
    {
         crewmemberid = p;
    }
}

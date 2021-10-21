//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.appcrewmemberview;

import java.util.List;

public class SailApplicationCrewMemberViewSummaryDTO  extends org.r3.db.DTOBase
{
    public SailApplicationCrewMemberViewSummaryDTO()
    {
        super();
    }

    protected java.lang.String  eventid;
    protected java.lang.String  applicationid;
    protected java.lang.String  sailnumber;
    protected java.lang.String  yachtname;
    
	public java.lang.String getEventid()
	{
		return eventid;
	}
	
	public void setEventid(java.lang.String eventid)
	{
		this.eventid = eventid;
	}
	
	public java.lang.String getApplicationid()
	{
		return applicationid;
	}
	
	public void setApplicationid(java.lang.String applicationid)
	{
		this.applicationid = applicationid;
	}
	
	public java.lang.String getSailnumber()
	{
		return sailnumber;
	}
	
	public void setSailnumber(java.lang.String sailnumber)
	{
		this.sailnumber = sailnumber;
	}
	
	public java.lang.String getYachtname()
	{
		return yachtname;
	}
	
	public void setYachtname(java.lang.String yachtname)
	{
		this.yachtname = yachtname;
	}
    
    public List<SailApplicationCrewMemberViewDTO> listOfCrewMembers;

	public List<SailApplicationCrewMemberViewDTO> getListOfCrewMembers()
	{
		return listOfCrewMembers;
	}

	public void setListOfCrewMembers(List<SailApplicationCrewMemberViewDTO> listOfCrewMembers)
	{
		this.listOfCrewMembers = listOfCrewMembers;
	}
    
    
}

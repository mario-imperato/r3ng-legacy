//
// generated by jGAMe Software - GPA Gruppo Progetti Avanzati s.r.l. 2016-2017
//
//
// README Section
//


package org.r3.db.sailevent.attendancesheetview;

import org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewDTO;

public class SailAttendanceSheetViewDataTableAdapter extends org.r3.db.utils.DataTableAdapter
{
  public SailAttendanceSheetViewDataTableAdapter()
  {
  }

  public SailAttendanceSheetViewDataTableAdapter(java.util.List<SailAttendanceSheetViewDTO> l, String asEcho)
  {
     setsEcho(asEcho);
	   
	   if (l != null)
	        setiTotalRecords(l.size());
	   else setiTotalRecords(0);
	   
	   if (l != null)	   
	        setiTotalDisplayRecords(l.size());
	   else setiTotalDisplayRecords(0);
	   
	   setAaData(l);
  }
  
  private java.util.List<SailAttendanceSheetViewDTO> aaData;
	
	@javax.xml.bind.annotation.XmlElement(name="aaData")
	public java.util.List<SailAttendanceSheetViewDTO> getAaData() 
	{
		return aaData;
	}
	
	public void setAaData(java.util.List<SailAttendanceSheetViewDTO> aaData) 
	{
		this.aaData = aaData;
	}

}
  
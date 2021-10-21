//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.smsqueueitem;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name="resultSet")
public class SMSQueueItemDataTableAdapter extends org.r3.db.utils.DataTableAdapter
{
  public SMSQueueItemDataTableAdapter()
  {
  }

  public SMSQueueItemDataTableAdapter(java.util.List<SMSQueueItemDTO> l, String asEcho)
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
  
  private java.util.List<SMSQueueItemDTO> aaData;
	
	@javax.xml.bind.annotation.XmlElement(name="aaData")
	public java.util.List<SMSQueueItemDTO> getAaData() 
	{
		return aaData;
	}
	
	public void setAaData(java.util.List<SMSQueueItemDTO> aaData) 
	{
		this.aaData = aaData;
	}

}
  

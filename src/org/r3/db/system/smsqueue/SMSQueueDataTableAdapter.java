//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.smsqueue;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name="resultSet")
public class SMSQueueDataTableAdapter extends org.r3.db.utils.DataTableAdapter
{
  public SMSQueueDataTableAdapter()
  {
  }

  public SMSQueueDataTableAdapter(java.util.List<SMSQueueDTO> l, String asEcho)
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
  
  private java.util.List<SMSQueueDTO> aaData;
	
	@javax.xml.bind.annotation.XmlElement(name="aaData")
	public java.util.List<SMSQueueDTO> getAaData() 
	{
		return aaData;
	}
	
	public void setAaData(java.util.List<SMSQueueDTO> aaData) 
	{
		this.aaData = aaData;
	}

}
  

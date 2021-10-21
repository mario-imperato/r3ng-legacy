//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.address;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name="resultSet")
public class AddressDataTableAdapter extends org.r3.db.utils.DataTableAdapter
{
  public AddressDataTableAdapter()
  {
  }

  public AddressDataTableAdapter(java.util.List<AddressDTO> l, String asEcho)
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
  
  private java.util.List<AddressDTO> aaData;
	
	@javax.xml.bind.annotation.XmlElement(name="aaData")
	public java.util.List<AddressDTO> getAaData() 
	{
		return aaData;
	}
	
	public void setAaData(java.util.List<AddressDTO> aaData) 
	{
		this.aaData = aaData;
	}

}
  

//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.siteresource;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name="resultSet")
public class SiteResourceDataTableAdapter extends org.r3.db.utils.DataTableAdapter
{
  public SiteResourceDataTableAdapter()
  {
  }

  public SiteResourceDataTableAdapter(java.util.List<SiteResourceDTO> l, String asEcho)
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
  
  private java.util.List<SiteResourceDTO> aaData;
	
	@javax.xml.bind.annotation.XmlElement(name="aaData")
	public java.util.List<SiteResourceDTO> getAaData() 
	{
		return aaData;
	}
	
	public void setAaData(java.util.List<SiteResourceDTO> aaData) 
	{
		this.aaData = aaData;
	}

}
  

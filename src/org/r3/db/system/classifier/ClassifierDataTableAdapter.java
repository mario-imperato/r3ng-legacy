//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.classifier;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name="resultSet")
public class ClassifierDataTableAdapter extends org.r3.db.utils.DataTableAdapter
{
  public ClassifierDataTableAdapter()
  {
  }

  public ClassifierDataTableAdapter(java.util.List<ClassifierDTO> l, String asEcho)
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
  
  private java.util.List<ClassifierDTO> aaData;
	
	@javax.xml.bind.annotation.XmlElement(name="aaData")
	public java.util.List<ClassifierDTO> getAaData() 
	{
		return aaData;
	}
	
	public void setAaData(java.util.List<ClassifierDTO> aaData) 
	{
		this.aaData = aaData;
	}

}
  

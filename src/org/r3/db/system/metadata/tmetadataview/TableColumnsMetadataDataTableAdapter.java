//
// generated by jGAMe Software - GPA Gruppo Progetti Avanzati s.r.l. 2016-2017
//
//
// README Section
//


package org.r3.db.system.metadata.tmetadataview;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name="resultSet")
public class TableColumnsMetadataDataTableAdapter extends org.r3.db.utils.DataTableAdapter
{
  public TableColumnsMetadataDataTableAdapter()
  {
  }

  public TableColumnsMetadataDataTableAdapter(java.util.List<TableColumnsMetadataDTO> l, String asEcho)
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
  
  private java.util.List<TableColumnsMetadataDTO> aaData;
	
	@javax.xml.bind.annotation.XmlElement(name="aaData")
	public java.util.List<TableColumnsMetadataDTO> getAaData() 
	{
		return aaData;
	}
	
	public void setAaData(java.util.List<TableColumnsMetadataDTO> aaData) 
	{
		this.aaData = aaData;
	}

}
  

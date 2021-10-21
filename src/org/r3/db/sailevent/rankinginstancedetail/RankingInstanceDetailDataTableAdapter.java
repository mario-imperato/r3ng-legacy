//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.rankinginstancedetail;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name="resultSet")
public class RankingInstanceDetailDataTableAdapter extends org.r3.db.utils.DataTableAdapter
{
  public RankingInstanceDetailDataTableAdapter()
  {
  }

  public RankingInstanceDetailDataTableAdapter(java.util.List<RankingInstanceDetailDTO> l, String asEcho)
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
  
  private java.util.List<RankingInstanceDetailDTO> aaData;
	
	@javax.xml.bind.annotation.XmlElement(name="aaData")
	public java.util.List<RankingInstanceDetailDTO> getAaData() 
	{
		return aaData;
	}
	
	public void setAaData(java.util.List<RankingInstanceDetailDTO> aaData) 
	{
		this.aaData = aaData;
	}

}
  

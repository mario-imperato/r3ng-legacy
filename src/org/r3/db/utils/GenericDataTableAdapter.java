package org.r3.db.utils;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@XmlRootElement(name="resultSet")
public class GenericDataTableAdapter<T> 
{
    private int iTotalRecords;
    
    @XmlElement(name="totalrecords")
	public int getiTotalRecords() {
		return iTotalRecords;
	}
	
	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	@XmlElement(name="aadata")
	private T aaData = null;
	
	public void setAaData(List<T> aaData) {
		if (aaData!=null && aaData.size() > 0)
	         this.aaData = aaData.get(0);
    }

//    private List<T> aaData;
//	
//	// @XmlElement(name="aadata")
//	@XmlAnyElement(lax=true)
//	public List<T> getAaData() {
//		return aaData;
//	}
//	
//	public void setAaData(List<T> aaData) {
//		this.aaData = aaData;
//	}

}

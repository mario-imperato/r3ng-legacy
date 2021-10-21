package org.r3.db.utils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@XmlRootElement(name="resultSet")
public class DataTableAdapter 
{
	private String sEcho;
    private int iTotalRecords;
    private int iTotalDisplayRecords;
    
    @XmlElement(name="iTotalRecords")
	public int getiTotalRecords() {
		return iTotalRecords;
	}
	
	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

    @XmlElement(name="sEcho")
	public String getsEcho()
	{
		return sEcho;
	}

	public void setsEcho(String sEcho)
	{
		this.sEcho = sEcho;
	}

    @XmlElement(name="iTotalDisplayRecords")
	public int getiTotalDisplayRecords()
	{
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(int iTotalDisplayRecords)
	{
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
	
	
}

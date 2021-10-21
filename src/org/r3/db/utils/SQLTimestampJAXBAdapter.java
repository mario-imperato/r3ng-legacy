package org.r3.db.utils;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class SQLTimestampJAXBAdapter extends XmlAdapter<JAXBAdaptedSQLTimestamp, java.sql.Timestamp> 
{      
	@Override     
	public java.sql.Timestamp unmarshal(JAXBAdaptedSQLTimestamp adaptedSQLTimestamp) throws Exception 
	{         
		return new java.sql.Timestamp(adaptedSQLTimestamp.getTime());     
	}      
	
	@Override public JAXBAdaptedSQLTimestamp marshal(java.sql.Timestamp aTimestamp) throws Exception 
	{         
		JAXBAdaptedSQLTimestamp adaptedCustomer = new JAXBAdaptedSQLTimestamp();   
		if (aTimestamp != null)
		adaptedCustomer.setTime(aTimestamp.getTime());                  
		return adaptedCustomer;  
	} 

}

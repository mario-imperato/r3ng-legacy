package org.r3.db.utils;



import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.core.StreamingOutput;

import org.r3.db.DTOBase;

public abstract class DTOCSVStreamingOutput implements StreamingOutput
{
	protected static final char DEFAULT_CSV_SEPARATOR = ',';
    public static CSVStreamInfo unmatchedStreamInfo = new CSVStreamInfo(1000, "__No_Attr__", "__No_Header__", null);
    
	public static class CSVStreamInfo implements Comparable
	{
		Integer  indexInfo;
		String   attribute;
		String   header;
	    Method   method;

	    public CSVStreamInfo()
	    {
	    	this(0, "__No_Attr__", "__No_Header__", null);
	    }

	    public CSVStreamInfo(int i, String attr_header)
	    {
	    	this(i, "__No_Attr__", "__No_Header__", null);
	    	if (attr_header != null && attr_header.length() > 0)
	    	{
	    		int ndx = attr_header.indexOf(':');
	    		if (ndx > 0 && ndx < (attr_header.length() - 1))
	    		{
	    			attribute = attr_header.substring(0, ndx);
	    			header = attr_header.substring(ndx + 1);
	    		}
	    		else
	    		{
	    			attribute = attr_header;
	    			header = attr_header;
	    		}
	    	}
	    }

	    public CSVStreamInfo(int i, String h, Method m)
	    {
	    	this(i, h, h, m);
	    }
	  
	    public CSVStreamInfo(int i, String attrName, String h, Method m)
	    {
	    	indexInfo = i;
	    	attribute = attrName;
	    	header = (h == null) ? attrName : h;
	    	method = m;
	    }

	    public String getAttribute()
	    {
	    	return attribute;
	    }

	    public String getHeader()
	    {
	    	return header;
	    }
	    
	    public String getValue(DTOBase targetObject)
	    {
	    	try
			{
	    		if (method != null)
				      return (String)method.invoke(targetObject, (Object[])null);
	    		else  return "__No_Method__";
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
	    	
	    	return "";
	    }

		public int compareTo(Object o)
		{
			CSVStreamInfo another = (CSVStreamInfo)o;
			return indexInfo.compareTo(another.indexInfo);
		}
	};

    private char separator;
    private java.util.List<CSVStreamInfo> providerInfo;

	public DTOCSVStreamingOutput(Class class1)
	{
    	separator = DEFAULT_CSV_SEPARATOR;
    	providerInfo = this.getProviderInfo(class1); 
	}

//	public DTOCSVStreamingOutput(Class class1, String aConfig)
//	{
//    	separator = DEFAULT_CSV_SEPARATOR;
//    	providerInfo = this.getProviderInfo(class1, aConfig); 
//	}

	public DTOCSVStreamingOutput(Class class1, String aConfig, char aSeparator)
	{
    	separator = aSeparator;
    	providerInfo = this.getProviderInfo(class1, aConfig); 
	}
	
    public void setSeparator(char aSeparator)
    {
         separator = aSeparator;	
    }

	protected void println(PrintWriter prt, DTOBase dto)
	{
		StringBuilder stb = new StringBuilder();
		
		int i = 0;
		if (providerInfo != null)
		{
		for(CSVStreamInfo info : providerInfo)
		{
			if (i > 0)
				stb.append(separator);
			
			stb.append(info.getValue(dto));
			i++;
		}
		}
		
		prt.print(stb.toString());
		prt.print("\r\n");
	}

	protected void printlnHeader(PrintWriter prt)
	{
		StringBuilder stb = new StringBuilder();
		
		int i = 0;
		
		if (providerInfo != null)
		{
		for(CSVStreamInfo info : providerInfo)
		{
			if (i > 0)
				stb.append(separator);
			
			stb.append(info.getHeader());
			i++;
		}
		}
		
		prt.print(stb.toString());
		prt.print("\r\n");
	}

	protected List<CSVStreamInfo> getProviderInfo(Class targetClass)
	{
		return getProviderInfo(targetClass, null);
	}
	
	protected List<CSVStreamInfo> getProviderInfo(Class targetClass, String aConfig)
	{
		List<CSVStreamInfo> listOf = new ArrayList<CSVStreamInfo>();
		
		if (aConfig != null)
		{
		    String[] cfgs = aConfig.split(String.valueOf(separator));		    
		    for(int i = 0; i < cfgs.length; i++)
		    {
		    	listOf.add(new CSVStreamInfo(i, cfgs[i]));
		    }
		}
		
		Method[] listOfMethods = targetClass.getMethods();
		if (listOfMethods != null && listOfMethods.length > 0)
		{
			for(Method m : listOfMethods)
			{
				String mName = m.getName();
				if (mName.startsWith("get"))
				{
					CSVAnnotation csvAnnotation = m.getAnnotation(CSVAnnotation.class);
					if (csvAnnotation != null)
					{
						if (aConfig == null)
						   listOf.add(new CSVStreamInfo(csvAnnotation.streamPosition(), csvAnnotation.attribute(), csvAnnotation.header(), m));
						else
						{
							CSVStreamInfo streamInfo = findCVSStreamInfoByAttribute(listOf, csvAnnotation.attribute());
							if (streamInfo != null)
							{
								streamInfo.method = m;
							}
						}
					}
				}				
			}
			
			Collections.sort(listOf);

		}
		
		if (listOf.size() == 0)
			listOf.add(unmatchedStreamInfo);
		
		return listOf; 
	}

	private CSVStreamInfo findCVSStreamInfoByAttribute(List<CSVStreamInfo> listOf, String attr)
	{
		for(CSVStreamInfo csv : listOf)
		{
			if (csv.getAttribute().equalsIgnoreCase(attr))
				return csv;
		}
		
		return null;
	}

}

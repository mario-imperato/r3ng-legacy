/*
 * Created on 18-dic-2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.r3.system.taglibs.r3_lang;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ExportScriptVariableTEI extends TagExtraInfo {

	/**
	 * 
	 */
	public ExportScriptVariableTEI() {
		super();
	}
	
	public VariableInfo[] getVariableInfo(TagData data)
	{
	   VariableInfo[] rc = null;
	   
	   if (data.getAttributeString(getVariableAttribute(data)) != null)
	   {
           // Apparently this field doesn't have any impact on
           // Tomcat. Forcing a declare but redeclaring in the page doesn't
           // create a problem. The code is kept here just in case.   	   

	   	   // boolean declare = new Boolean(data.getAttributeString("declare")).booleanValue();
	   	   
	   	   boolean declare = true;
	   	   rc = new VariableInfo[1];
   	   	   rc[0] = new VariableInfo(data.getAttributeString(getVariableAttribute(data)), 
   	   	   		                    getVariableClassName(data), getVariableDeclare(data), getVariableScope(data));
	   }
	   
	   return rc;	   	     
	}
	
	protected String getVariableClassName(TagData data)
	{
		return "java.lang.String";
    }

    protected String getVariableAttribute(TagData data)
	{
		return "id";
    }
    
    protected int getVariableScope(TagData data)
    {
    	return VariableInfo.AT_BEGIN;
    }

    protected boolean getVariableDeclare(TagData data)
    {
    	return true;
    }
}

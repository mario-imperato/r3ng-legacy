/*
 * Created on 18-dic-2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.r3.system.taglibs.r3_lang;

import javax.servlet.jsp.tagext.TagData;

/**
 * @author Administrator
 *
 */
public class BooleanVariableTEI extends ExportScriptVariableTEI 
{
	/**
	 * 
	 */
	public BooleanVariableTEI() {
		super();
	}
    
  	protected String getVariableClassName(TagData data)
	{
		return "java.lang.Boolean";
    }
	
}

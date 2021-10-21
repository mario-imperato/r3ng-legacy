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
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class UseBeanTEI extends ExportScriptVariableTEI 
{
	/**
	 * 
	 */
	public UseBeanTEI() {
		super();
		// TODO Auto-generated constructor stub
	}

    // protected boolean getVariableDeclare(TagData data)
    // {
    // 	return new Boolean(data.getAttributeString("declare")).booleanValue();
    // }
    
  	protected String getVariableClassName(TagData data)
	{
		return data.getAttributeString("type");
    }
	
}

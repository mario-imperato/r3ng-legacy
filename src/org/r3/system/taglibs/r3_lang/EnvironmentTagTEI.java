/*
 * Created on 18-dic-2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.r3.system.taglibs.r3_lang;

import javax.servlet.jsp.tagext.TagData;

import org.r3.system.struts.RequestEnvironment;


/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EnvironmentTagTEI extends ExportScriptVariableTEI 
{
	/**
	 * 
	 */
	public EnvironmentTagTEI() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected String getVariableClassName(TagData data)
	{
		return RequestEnvironment.class.getName();
    }
	
}

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
public class TagPathResolverTEI extends ExportScriptVariableTEI 
{
	/**
	 * 
	 */
	public TagPathResolverTEI() {
		super();
	}

    protected boolean getVariableDeclare(TagData data)
    {
    	return new Boolean(data.getAttributeString("declare")).booleanValue();
    }
	
}

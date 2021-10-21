package org.r3.system.util.velocity;


public class VelocityTemplateHelper
{

	public VelocityTemplateHelper()
	{
		
	}
	
	public String makeSQLString(String aString)
	{
		if (aString == null)
			return "null";
		
		StringBuffer ret = new StringBuffer().append("'");

        String lookFor = "'";
        int curChar = 0;
        int index;
        int lookForLen = lookFor.length();

        while ((index = aString.indexOf(lookFor, curChar)) >= 0)
        {
            ret.append(aString.substring(curChar, index));

            ret.append("''");
            curChar = index + lookForLen;
        }

        ret.append(aString.substring(curChar, aString.length()))
           .append("'");
        
		return ret.toString();
	}

}

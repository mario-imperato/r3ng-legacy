package org.r3.db.mongo.script;

public class JSONHelperFormatter
{

	public JSONHelperFormatter()
	{

	}
	
	public String toJSONQuotedString(String s)
	{
		if (s == null)
			return "null";
		
		StringBuilder resultString = new StringBuilder();
		resultString.append('"');
		
		for(int i = 0; i < s.length(); i++)
		{
			resultString.append(escapeCharacter(s.charAt(i)));
		}
		
		resultString.append('"');
		return resultString.toString();			
	}


	private String escapeCharacter(char c)
	{
		String resultString = null;
		
		switch (c)
		{
		case '\\': {
			resultString = "\\\\";
			break;
		}
		case '"': {
			resultString = "\\\"";
			break;
		}
		case '\r':
			resultString = "\\r";
			break;
			
		case '\n': 
			resultString = "\\n";
			break;
		
		default: {
			if (c > 128)
			{
				// System.out.println(" Character: " + c + " as int: " + (int)c);
			}
			
			resultString = String.valueOf(c);
		}
		}

		return resultString;
	}

	
}

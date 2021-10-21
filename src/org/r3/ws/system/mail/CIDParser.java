package org.r3.ws.system.mail;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class CIDParser
{
    private String message;
    
	public CIDParser(String aMessage)
	{
	    message = aMessage;	
	}

	public String parse()
	{
		if (message == null)
			return null;
		
		boolean modified = false;
		Document jsoupDocument = Jsoup.parseBodyFragment(message);
		for(Element e : jsoupDocument.getAllElements())
		{
			if (e.tagName().equalsIgnoreCase("img"))
			{
				String classAttribute = e.attr("class");
				String src = e.attr("src");
				if (classAttribute != null && classAttribute.equalsIgnoreCase("cid") && src != null)
				{
					int ndx = src.lastIndexOf('/');
					if (ndx >= 0)
					{
						StringBuilder stb = new StringBuilder();
						stb.append("cid:").append(src.substring(ndx + 1));
						e.attr("src", stb.toString());
						modified = true;
					}
				}						
			}			
		}
		
		return modified ? jsoupDocument.toString() : message;
		
	}
}

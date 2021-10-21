package org.r3.system.util.nls_dictionary;

import java.util.HashMap;
import java.util.Map;

public class NamespaceBundle
{	
    private Map<String, String> dictionary;
    private String language;
    private String namespace;
    
	public NamespaceBundle(String aNamespace, String aLanguage)
	{
		dictionary = new HashMap<String, String>();
		namespace = aNamespace;
		language = aLanguage;
	}

	public void put(String stringIdentifier, String translation)
	{
		dictionary.put(stringIdentifier, translation);
	}
	
	public String get(String aStringIdentifier)
	{
		return dictionary.get(aStringIdentifier);
	}

	public String getLanguage()
	{
		return language;
	}

	public String getNamespace()
	{
		return namespace;
	}
	
	public String getKey()
	{		
		return getKey(namespace, language);
	}
	
	public int size()
	{
	    return dictionary.size();	
	}
	
	public static String getKey(String aName, String aLanguage)
	{
		StringBuilder stb = new StringBuilder().append(aName).append('_').append(aLanguage);
		return stb.toString();
	}
	

}

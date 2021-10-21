package org.r3.system.util.velocity;

import java.util.HashMap;

public class VelocityTemplateGroup
{
	public static final String TemplateDefaultLocaleParameter = "it";
	public static final String TemplateDefaultDomainParameter = "__DEFAULTDOMAIN__";
	
    private HashMap<String, VelocityTemplate>  listOfGroupMembers;
 
    private HashMap<String, VelocityTemplate> getListOfgroupMembers()
    {
    	if (listOfGroupMembers == null)
    		listOfGroupMembers = new HashMap<String, VelocityTemplate>();
    	
    	return listOfGroupMembers;
    }
    
    private int numberOfgroupMembers()
    {
    	if (listOfGroupMembers == null)
    		return 0;
    	
    	return listOfGroupMembers.size();
    }
    
    public void addTemplate(VelocityTemplate aTemplate)
    {
    	getListOfgroupMembers().put(aTemplate.getLocalizedDomainName().toUpperCase(), aTemplate);
    }
    
    public VelocityTemplate getTemplate(String aDomainName, String aLocale)
    {
    	if (numberOfgroupMembers() == 0)
    		return null;
    	
    	if (aDomainName == null)
    		aDomainName = VelocityTemplateGroup.TemplateDefaultDomainParameter;
    	
    	String localizedName = VelocityTemplate.getLocalizedName(aDomainName, aLocale);
    	VelocityTemplate v = getListOfgroupMembers().get(localizedName.toUpperCase());
    	if (v == null && aLocale != null)
    	{
    		v = getListOfgroupMembers().get(aDomainName.toUpperCase());
    	}
    		
    	if (v == null && !aDomainName.equalsIgnoreCase(VelocityTemplateGroup.TemplateDefaultDomainParameter))
    	{
    		localizedName = VelocityTemplate.getLocalizedName(VelocityTemplateGroup.TemplateDefaultDomainParameter, aLocale);
    		v = getListOfgroupMembers().get(localizedName.toUpperCase());
    	}
    	
    	if (v == null && !aDomainName.equalsIgnoreCase(VelocityTemplateGroup.TemplateDefaultDomainParameter) && aLocale != null)
    	{
    		v = getListOfgroupMembers().get(VelocityTemplateGroup.TemplateDefaultDomainParameter);
    	}
    	
    	// Se non trovo niente allora provo con il primo... se no ciccia....
    	if (v == null)
    	{
    		v = getListOfgroupMembers().values().iterator().next();
    	}
    	
    	return v;
    }
    
}

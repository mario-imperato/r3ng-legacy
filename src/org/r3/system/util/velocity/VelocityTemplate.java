package org.r3.system.util.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.app.Velocity;

public class VelocityTemplate
{

	private String id;
        
    /**
     * @param id
     *            the id to set
     */
    public void setName(String id)
    {
        this.id = id;
    }

    /**
     * @return the id
     */
    public String getName()
    {
        return id;
    }

    private String title;

    private String filename;

    private String locale;

    private String domain;
    
    public String getLocale()
	{
		return locale;
	}

	public void setLocale(String locale)
	{
		this.locale = locale;
	}

	private Template template;

	public static String getLocalizedName(String aName, String aLocale)
    {    	
    	if (aLocale != null)
    	{
    		StringBuilder stb = new StringBuilder().append(aName).append("_").append(aLocale);
    		return stb.toString();
    		
    	}
        return aName;
    }
	
    public String getLocalizedDomainName()
    {    
    	return getLocalizedName(getDomain(), getLocale());
    }
    
    public Template getTemplate()
    {
        return template;
    }
    
    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    public String getDomain()
	{
    	if (domain == null)
    		return VelocityTemplateGroup.TemplateDefaultDomainParameter;
    	
		return domain;
	}

	public void setDomain(String domain)
	{
		this.domain = domain;
	}

	/**
     * @param fileName
     *            the fileName to set
     */
    public void setFilename(String aFileName)
    {
        this.filename = aFileName;
        loadTemplate();
    }

    /**
     * @return the fileName
     */
    public String getFilename()
    {
        return filename;
    }

    private void loadTemplate()
    {
    try
    {
        template = Velocity.getTemplate(getFilename(), "UTF8");            
    }
    catch (Exception e)
    {
        template = null;
        e.printStackTrace();
    }
    }

}

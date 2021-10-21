//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.system.siteproperty;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SitePropertyDTO extends SitePropertyDTOBase
{
	public enum SiteIdentifier {
		__any__, __tmpl__
	};

    public enum PropertyScope { system, webui, google, sevapplication, mail, facebook, storage };
	public static final String SITEPROPERTY_TEMPDIR = "sys.config.tempdir";
	public static final String SITEPROPERTY_RESOURCESDIR = "sys.config.resourcedir";
	
    public boolean canReadWrite()
    {
    	if (propertyvalue != null)
    	{
    		File f = new File(propertyvalue);
    		return f.isDirectory() && f.canRead() && f.canWrite();
    	}
    	
    	return false;
    }

	public static SitePropertyDTO NullProperty = new SitePropertyDTO();
	
	public enum MailProfile { smtpdefault, google };
	
	public static final String MAILPROFILE               = "mail_profile";
	public static final String MAILHOST                  = "mail_host";
	public static final String SMTPAUTH                  = "smtp_auth";
	public static final String SMTPPORT                  = "smtp_port";
	public static final String SMTPSOCKETFACTORYPORT     = "smtp_socketFactory_port";
	public static final String SMTPSOCKETFACTORYCLASS    = "smtp_socketFactory_class";
	public static final String SMTPSOCKETFACTORYFALLBACK = "smtp_socketFactory_fallback";
	public static final String SMTPQUITWAIT              = "smtp_quitwait";
	public static final String SMTPAUTHACCOUNT           = "mail_auth_account";
	public static final String SMTPAUTHPASSWD            = "mail_auth_passwd";
	
	public static final String SMTP_SYSFROM              = "smtp_sysfrom";
	public static final String SMTP_SYSSUBJECT           = "smtp_systitle";
	public static final String SMTP_SYSBCC               = "smtp_sysbcc";
	
	public static final String REGIST_MAILTITLE          = "mail_regtitle";
		
	public static final String RESETPWD_MAILTITLE        = "mail_resettitle";

	public static final String SMS_SYSTEM_PKG            = "system.sms";
	
	// Property Value For the SMS_GATEWAYNAME property
	public static final String SMS_GATEWAYNAME_TEST      = "gtway_test";
	public static final String SMS_GATEWAYNAME_SMSBIZ    = "gtway_smsbiz";
	
	public static final String SMS_PKG                    = "sms";
	
	public static final String SMS_GATEWAYNAME            = "gatewayname";
	public static final String SMS_URL                    = "url";
	public static final String SMS_HOST                   = "host";
	public static final String SMS_PORT                   = "port";
	public static final String SMS_IP                     = "ip";
	
	public static final String SMS_SENDER                 = "smssender";
	public static final String SMS_LOGIN                  = "smslogin";
	public static final String SMS_PASSWD                 = "smspasswd";

	public static final String UI_CFG_PKG                 = "ui.cfg";	
	public static final String UI_CFG_MENUS               = "menus";	
	public static final String UI_CFG_MENUSITEMS          = "menusitems";	

	public static final String GOOGLE_ANALYTICS_PKG       = "google.analytics";
	public static final String GOOGLE_ANALYTICS_TRACKERID = "google.analytics.trackerid";
	public static final String GOOGLE_ANALYTICS_DOMAIN    = "google.analytics.domain";

	public static final String SYSTEM_PKG                 = "system";
	
	public static final String SEV_APPLICATION_PKG        = "sev.app";
	public static final String SEV_RANKING_PKG            = "sev.ranking";
	
	public static final String FB_APPID                   = "appid";
	public static final String FB_APPSECRET               = "appsecret";
	
	public static final String FB_APPDOMAIN_PACKAGE       			= "facebook.domain";
	public static final String FB_SERVERNAME_FACEBOOKAPP_PACKAGE 	= "%s.facebook.app";
	public static final String FB_SERVERNAME_FACEBOOKAPP_APPSECRET	= "appsecret";
	public static final String FB_SERVERNAME_FACEBOOKAPP_APPID 		= "appid";
	public static final String FB_SERVERNAME_FACEBOOKAPP_APPNAME 	= "appname";
	
	public static final String FB_PAGEPUB_SCOPE 	= "facebook.page.pub";
	public static final String FB_PAGEPUB_PAGEID 	= "fbpageid";
	public static final String FB_PAGEPUB_PAGETOKEN = "fbpagetoken";
	
	// public static final String UI_CFG_HOME_PORTLETS_PKG   = "ui.cfg.homeportlet";
	
	public SitePropertyDTO()
	{
		super();
	}

	public SitePropertyDTO(SitePropertyDTO another)
	{
		super(another);
	}

	public SitePropertyDTO(String aSite, String aPropertyScope, String aPropertyKey, String aPropertyValue)
	{
		setSite(aSite);
		setPropertyscope(aPropertyScope);
		setPropertykey(aPropertyKey);
		setPropertyvalue(aPropertyValue);
	}
	
	@Override
	public String getDtokey()
	{
		return getDtokey(site, propertyscope, propertykey);
	}

//    @Override
//    public String getDtokey()
//    {
//        StringBuilder stb = new StringBuilder();
//        stb.append(propertykey);
//        return stb.toString();
//    }
//
//    @Override
//    public String getDtodescr()
//    {
//        StringBuilder stb = new StringBuilder();
//        stb.append(propertyvalue);
//        return stb.toString();
//    }

	public static String getDtokey(String aSite, String aPropertyscope, String aPropertykey)
	{
		StringBuilder stb = new StringBuilder();
		stb.append(aSite);
		stb.append("_");
		stb.append(aPropertyscope);
		stb.append("_");
		stb.append(aPropertykey);
		return stb.toString();
	}

	public String getPropertyname()
	{
		String s = this.getPropertykey();
		if (s == null)
			return s;
			    
	    int ndx = s.lastIndexOf(".");
	    if (ndx >= 0)
	    	return s.substring(ndx + 1);
	    
	    return s;
	}
	
	public String getPropertypackage()
	{
		String s = this.getPropertykey();
		if (s == null)
			return s;
			    
	    int ndx = s.lastIndexOf(".");
	    if (ndx >= 0)
	    	return s.substring(0, ndx);
		
	    return this.getPropertyscope();
	}
	
	@JsonIgnore
	public String getPropertyname2()
	{
		String ps = this.getPropertyscope();
		String pk = this.getPropertykey();

		if (ps == null || pk == null)
			return null;
			    
		// Se il propertyscope ha punti allora ritorno direttamente la chiave.
	    if (ps.indexOf(".") >= 0)
	    	return pk;
		
	    // Se la chiave ha punti (ma il propertyscope no) allora spezzo la chiave...
	    int ndx = pk.lastIndexOf(".");
	    if (ndx >= 0)
	    	return pk.substring(ndx + 1);
	    
	    return pk;			    
	}
	
	@JsonIgnore
	public String getPackage()
	{
		String ps = this.getPropertyscope();
		String pk = this.getPropertykey();
		if (ps == null)
			return null;
			    
		// Se il propertyscope ha punti allora ritorno il propertyscope.
	    if (ps.indexOf(".") >= 0)
	    	return ps;
		
	    // Se la chiave ha punti (ma il propertyscope no) allora spezzo la chiave...	    
		if (pk == null)
			return null;
			    
	    int ndx = pk.lastIndexOf(".");
	    if (ndx >= 0)
	    	return pk.substring(0, ndx);
		
	    return ps;	    
	}
	
	public String getPropertykey(boolean fullPath)
	{
		if (!fullPath)
			return getPropertyname();
		
		if (this.propertykey.indexOf('.') >= 0)
			return getPropertykey();
		
		StringBuilder stb = new StringBuilder().append(getPropertyscope()).append('.').append(getPropertykey());
		return stb.toString();
	}
	
//    @com.fasterxml.jackson.annotation.JsonIgnore
//    @javax.xml.bind.annotation.XmlTransient	
//	public int getPropertykeyAsInt()
//	{
//    	String s = getPropertyname();
//    	
//    	if (s != null)
//    	{
//    	try
//    	{
//    		return Integer.parseInt(s);
//    	}
//    	catch(Exception e)
//    	{
//    		e.printStackTrace();
//    	}
//    	}
//
//    	return 0;
//	}
	
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient
	public String[] getPropertyvalueAsStringArray(String regExp)
	{
		if (propertyvalue != null)
			return propertyvalue.split(regExp);

		return null;
	}

    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient
	public boolean getPropertyvalueAsBoolean()
	{
		if (propertyvalue != null)
			return Boolean.parseBoolean(propertyvalue);

		return false;
	}

    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient
	public int getPropertyvalueAsInt()
	{
		if (propertyvalue != null)
			return Integer.parseInt(propertyvalue);

		return 0;
	}

    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient
	public boolean isNullProperty()
	{
		if (propertykey == null)
			return true;

		return false;
	}
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient
	public boolean valueMatches(String s)
	{
		if (propertyvalue != null)
			return propertyvalue.equalsIgnoreCase(s);

		return false;
	}
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient
	public boolean valueContains(String s, String leftCharSeparator, String rightCharSeparator)
	{
		if (propertyvalue != null)
		{
			StringBuilder matchString = null;
			if (leftCharSeparator != null && rightCharSeparator != null)
			{
				matchString = new StringBuilder()
				   .append(leftCharSeparator)
				   .append(s)
				   .append(rightCharSeparator);
				
				s = matchString.toString();
			}
			
			return propertyvalue.indexOf(s) >= 0;
		}
			
		return false;
	}
    
    public static SitePropertyDTO getPropertyDTOFromList(List<SitePropertyDTO> aListOf, String aPropertyScope, String aPropertyName)
    {
		if (aListOf != null && aListOf.size() > 0)
		{
			for(SitePropertyDTO dto : aListOf)
			{
				if (dto.getPropertykey().equalsIgnoreCase(aPropertyName) && dto.getPropertyscope().equalsIgnoreCase(aPropertyScope))
					return dto;
			}
		}
		
		return null;		
    }

    public static String getPropertyFromList(List<SitePropertyDTO> aListOf, String aPropertyScope, String aPropertyName)
    {
    	SitePropertyDTO dto = getPropertyDTOFromList(aListOf, aPropertyScope, aPropertyName);
    	if (dto != null)
    		return dto.getPropertyvalue();
    	
    	return null;
    }
}

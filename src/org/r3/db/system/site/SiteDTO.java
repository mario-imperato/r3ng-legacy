//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.site;

import java.util.ArrayList;
import java.util.List;

import org.r3.db.DTOBase;
import org.r3.db.cms.cardproperty.CardPropertyDTO;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.sitecmspropertyview.SiteCMSPropertyLUT;
import org.r3.db.system.sitecmspropertyview.SiteCMSPropertyLUTDTO;
import org.r3.db.system.siteportletcfg.SitePortletConfigDTOCollection;
import org.r3.db.system.siteportletcfg.SitePortletConfigLUT;
import org.r3.db.system.siteportletcfg.SitePortletConfigLUTDTO;
import org.r3.db.system.siteproperty.GoogleAnalyticsTracker;
import org.r3.db.system.siteproperty.SitePropertyDTO;
import org.r3.db.system.siteproperty.SitePropertyDTOCollection;
import org.r3.ws.system.dms.UNEPWsDMS;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SiteDTO extends SiteDTOBase
{
	public static final String SITERESOURCEPATH_MOUNTPOINT = "/r3ng/resources/sites";
	
	//
	// Le risorse referenziate dalla proprieta' siteresourcepath in SiteDTO sono costruite a partire da 4 valori che vengono concatenati.
	// SITERESOURCEPATH_MOUNTPOINT, siteresourcepath, resourcetype, resourceName
	//
	public static final String SITERESOURCEPATH_ABSOLUTEFORMAT = "%s/%s/%s/%s";
	
	public enum SiteType { 
		
	   undef, rootsite, regatta, yachtclub, speedsails, workshop, mastersite, cptes, 
	   shakeus, shkneighb, shkshop;
	
	   public static SiteType valueOf(String s, SiteType aDefaultSiteType)
	   {
		   if (s == null || s.length() == 0)
			   return aDefaultSiteType;
		   
		   return valueOf(s);
	   }
	   
	   public static String getCommonSQLScriptCreation(String s)
	   {
		   String sqlScriptName = "SiteCreationSQLScript_common";
		   return sqlScriptName;
	   }
	   
	   public static String getSQLScriptCreation(String s)
	   {
		   String sqlScriptName = "SiteCreationSQLScript_common";
		   		   
		   switch(SiteType.valueOf(s, SiteType.undef))
		   {
		   case regatta:
			   sqlScriptName = "SiteCreationSQLScript_regatta";
			   break;
		   			   
		   case yachtclub:
			   sqlScriptName = "SiteCreationSQLScript_yachtclub";
			   break;
			   
		   case speedsails:
			   sqlScriptName = "SiteCreationSQLScript_speedsails";
			   break;
			   
		   case workshop:
			   sqlScriptName = "SiteCreationSQLScript_workshop";
			   break;
			   
		   case mastersite:
			   sqlScriptName = "SiteCreationSQLScript_mastersite";
			   break;
			   
		   case cptes:
			   sqlScriptName = "SiteCreationSQLScript_cptes";
			   break;

		   case shakeus:
			   sqlScriptName = "SiteCreationSQLScript_shakeus";
			   break;

		   case shkneighb:
			   sqlScriptName = "SiteCreationSQLScript_shkneighb";
			   break;

		   case shkshop:
			   sqlScriptName = "SiteCreationSQLScript_shkshop";
			   break;			   
			   
		   default: 
			   sqlScriptName = "SiteCreationSQLScript_common";
		   }
		   
		   return sqlScriptName;
	   }
	   	   
	};
	
	public enum RefSiteType { 
		
	   site_none, site_external, site_internal;  

	   public static RefSiteType valueOf(String s, RefSiteType aDefaultSiteType)
	   {
		   if (s == null || s.length() == 0)
			   return aDefaultSiteType;
		   
		   return valueOf(s);
	   }		
	};	

	public enum SiteResourceType { 
		
		   any, iconicmenu;
		
		   public static SiteResourceType valueOf(String s, SiteResourceType aDefaultSiteType)
		   {
			   if (s == null || s.length() == 0)
				   return aDefaultSiteType;
			   
			   return valueOf(s);
		   }		   
	};

	public enum SiteProfile { 
		
		   profilebase, profile1;
		
		   public static SiteProfile valueOf(String s, SiteProfile aDefaultSiteType)
		   {
			   if (s == null || s.length() == 0)
				   return aDefaultSiteType;
			   
			   return valueOf(s);
		   }		   
	};
	
	public SiteProfile getSiteprofile()
	{	    
    	String[] opt = DTOBase.string2Array(getOptions(), ",");
    	if (opt != null)
    	{
    		for(String o : opt)
    		{
    			if (o.startsWith("profile"))
    				return SiteProfile.valueOf(o, SiteProfile.profilebase);
    		}
    	}
	    
	    return SiteProfile.profilebase;
	}
	
    public SiteDTO()
    {
        super();
        
        siteProperties = new SitePropertyDTOCollection();
    }

    public SiteDTO(SiteDTO another)
    {
        super(another);
    }

    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient    
    public String getCommonSQLScriptCreation()
    {
        return SiteType.getCommonSQLScriptCreation(getSitetype());	
    }
        
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient    
    public String getSQLScriptCreation()
    {
        return SiteType.getSQLScriptCreation(getSitetype());	
    }
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    public boolean isRegatta()
    {
        return 	SiteType.valueOf(sitetype, SiteType.undef) == SiteType.regatta;
    }

    @com.fasterxml.jackson.annotation.JsonIgnore
    public boolean isYachtclub()
    {
        return 	SiteType.valueOf(sitetype, SiteType.undef) == SiteType.yachtclub;
    }

    @com.fasterxml.jackson.annotation.JsonIgnore
    public boolean isDomainSite()
    {
        return 	site.equalsIgnoreCase(sitedomain);
    }
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    public boolean isMasterSite()
    {
        return 	SiteType.valueOf(sitetype, SiteType.undef) == SiteType.mastersite;
    }

	public boolean isOfType(SiteType aSiteType)
	{
		return 	SiteType.valueOf(sitetype, SiteType.undef) == aSiteType;
	}
	
	public boolean supports(String requestLanguage)
	{
		return true;
	}

	// Usata in JSP
	public RefSiteType getRefsitetypeAsEnum()
	{
		return RefSiteType.valueOf(getRefsitetype(), RefSiteType.site_none);
	}

	public boolean isRefsiteVisibleAsBoolean()
	{
		if (getRefsitetypeAsEnum() == RefSiteType.site_none)
			return false;
		
		if (getBTrueFalseAsBoolean(getRefsitevisible()))
			return true;
		
		return false;
	}

	public boolean isAdmrefsiteVisibleAsBoolean()
	{
		if (getAdmrefsitetypeAsEnum() == RefSiteType.site_none)
			return false;
		
		if (getBTrueFalseAsBoolean(getAdmrefsitevisible()))
			return true;
		
		return false;		
	}

	public RefSiteType getAdmrefsitetypeAsEnum()
	{
		return RefSiteType.valueOf(getAdmrefsitetype(), RefSiteType.site_none);
	}

	public String getRefsiteUrl(String appContext, String aLanguageCode)
	{
		String u = null;
		switch(RefSiteType.valueOf(getRefsitetype(), RefSiteType.site_none))
		{
		case site_none:
			break;
		case site_external:
			u = getRefsite();
			break;
		case site_internal:
			u = new StringBuilder().append("/").append(appContext).append("/").append(getRefsite()).append("/").append(aLanguageCode).append("/org/r3/home.do").toString();
			break;
		}
		
		return u;
	}

	public String getRefsiteConsoleUrl(String appContext, String aLanguageCode)
	{
		String u = null;
		switch(RefSiteType.valueOf(getAdmrefsitetype(), RefSiteType.site_none))
		{
		case site_none:
			break;
		case site_external:
			u = getAdmrefsite();
			break;
		case site_internal:
			u = new StringBuilder().append("/").append(appContext).append("/").append(getAdmrefsite()).append("/").append(aLanguageCode).append("/org/r3/console/home.do").toString();
			break;
		}
		
		return u;
	}

	public boolean isCSSDefined()
	{
		return getSitecss() != null; // Utilizzo sempre e comunque un default basato sul tipo di sito sitecss != null;
	}



	public boolean isConsoleCSSDefined()
	{		
		return getSiteconsolecss() != null; 
	}



	private GoogleAnalyticsTracker googleAnalyticsTracker;
    
	public GoogleAnalyticsTracker getGoogleAnalyticsTracker()
    {
    	if (googleAnalyticsTracker == null)
    	{
    		SitePropertyDTO tId     = getSiteProperties().getPropertyByPropertykey(SitePropertyDTO.GOOGLE_ANALYTICS_TRACKERID);
    		SitePropertyDTO tDomain = getSiteProperties().getPropertyByPropertykey(SitePropertyDTO.GOOGLE_ANALYTICS_DOMAIN);
    		
    		if (!tId.isNullProperty() && !tDomain.isNullProperty())
    		{
    			googleAnalyticsTracker = new GoogleAnalyticsTracker(tId.getPropertyvalue(), tDomain.getPropertyvalue());
    		}
    	}
    	
    	return googleAnalyticsTracker;
    }
    
	// private List<SitePropertyDTO> siteProperties;
	private SitePropertyDTOCollection siteProperties;	
	
	public SitePropertyDTOCollection getSiteProperties()
	{
		return siteProperties;
	}

	public void setSiteProperties(SitePropertyDTOCollection siteProperties)
	{
		this.siteProperties = siteProperties;
	}

	public SitePortletConfigDTOCollection getPortletConfigCollection(String aPageId)
	{
		SitePortletConfigLUT lut = (SitePortletConfigLUT)LUTManager.getLUTManager().getLUT(LUTName.siteportletconfig, null);
		SitePortletConfigLUTDTO dto = lut.getItem(getSite(), aPageId);
		if (dto != null)
			return dto.getPositions();
		
		return SitePortletConfigDTOCollection.NullPortletConfigCollection;		
	}

	public ArrayList<CardPropertyDTO> getCMSPropertyCollection()
	{
		SiteCMSPropertyLUT lut = (SiteCMSPropertyLUT)LUTManager.getLUTManager().getLUT(LUTName.sitecmsproperties, null);
		SiteCMSPropertyLUTDTO dto = lut.getItem(getSite());
		if (dto != null) 
			return dto.getCmsProperties();
		
		return null;		
	}
	
	public CardPropertyDTO getCMSProperty4PropertyRole(String aPropertyRole)
	{
		SiteCMSPropertyLUT lut = (SiteCMSPropertyLUT)LUTManager.getLUTManager().getLUT(LUTName.sitecmsproperties, null);
		SiteCMSPropertyLUTDTO dto = lut.getItem(getSite());
		if (dto != null)
		{
			for(CardPropertyDTO crp : dto.getCmsProperties())
			{
				if (crp.getPropertyrole().equalsIgnoreCase(aPropertyRole))
					return crp;
			}
		}
					
		return null;		
	}
	
	public String getCMSPropertyValueAsURL(String aSite, String aLanguage, String aPropertyRole, String aPropertyDefault)
	{
		SiteCMSPropertyLUT lut = (SiteCMSPropertyLUT)LUTManager.getLUTManager().getLUT(LUTName.sitecmsproperties, aLanguage);
		SiteCMSPropertyLUTDTO dto = lut.getItem(getSite());
		if (dto != null)
		{
			for(CardPropertyDTO crp : dto.getCmsProperties())
			{				
				if (crp.getPropertyrole().equalsIgnoreCase(aPropertyRole))
				{
					String pv = crp.getPropertyvalue();
					if (pv.startsWith("DMS_FILE:"))
					{							    	
					    return UNEPWsDMS.getDMSUrl4(aSite, aLanguage, pv);					    	
					}					
				}
			}
		}
					
		return aPropertyDefault;		
	}
	


	public String getResourceAbslutePath(SiteResourceType aResourceType, String aResourceName)
	{
		String aPath = String.format(SITERESOURCEPATH_ABSOLUTEFORMAT, SITERESOURCEPATH_MOUNTPOINT, getSiteresourcepath(), aResourceType.toString(), aResourceName);
		return aPath;
	}

	public void resolveSiteDTOFromSiteProperties()	
	{
		SitePropertyDTOCollection siteProperties = getSiteProperties();
		List<SitePropertyDTO> configProperties = (siteProperties != null) ? siteProperties.getPropertiesByPropertyPackage("site.config") : null;	
		resolveSiteDTOFromSiteProperties(configProperties);
	}
	
	public void resolveSiteDTOFromSiteProperties(List<SitePropertyDTO> configProperties)
	{
		if (configProperties != null)
		{
			for (SitePropertyDTO property : configProperties)
			{
				switch (property.getPropertykey())
				{
				case "sitelayout":
					setSitelayout(property.getPropertyvalue());
					break;
				case "siteresourcepath":
					setSiteresourcepath(property.getPropertyvalue());
					break;
				case "sitecss":
					setSitecss(property.getPropertyvalue());
					break;
				case "siteconsolecss":
					setSiteconsolecss(property.getPropertyvalue());
					break;
				case "sitetheme":
					setSitetheme(property.getPropertyvalue());
					break;
				case "refsitetype":
					setRefsitetype(property.getPropertyvalue());
					break;
				case "refsite":
					setRefsite(property.getPropertyvalue());
					break;
				case "refsitevisible":
					setRefsitevisible(property.getPropertyvalue());
					break;
				case "refsitedescr":
					setRefsitedescr(property.getPropertyvalue());
					break;
				case "admrefsitetype":
					setAdmrefsitetype(property.getPropertyvalue());
					break;
				case "admrefsite":
					setAdmrefsite(property.getPropertyvalue());
					break;
				case "admrefsitevisible":
					setAdmrefsitevisible(property.getPropertyvalue());
					break;
				case "admrefsitedescr":
					setAdmrefsitedescr(property.getPropertyvalue());
					break;
				case "cardid":
					setCardid(property.getPropertyvalue());
					break;
				case "options":
					setOptions(property.getPropertyvalue());
					break;
				}
			}
		}
		
		resolvedAttributes = true;
	}

	public List<SitePropertyDTO> retrieveSitePropertiesFromSiteDTO()
	{
		List<SitePropertyDTO> siteProperties = new ArrayList<SitePropertyDTO>();
		SitePropertyDTO sp = null;

		if (getSitelayout() != null)
		{
			sp = new SitePropertyDTO(getSite(), "site.config", "sitelayout", getSitelayout());
			siteProperties.add(sp);
		}
		if (getSiteresourcepath() != null)
		{
			sp = new SitePropertyDTO(getSite(), "site.config", "siteresourcepath", getSiteresourcepath());
			siteProperties.add(sp);
		}
		if (getSitecss() != null)
		{
			sp = new SitePropertyDTO(getSite(), "site.config", "sitecss", getSitecss());
			siteProperties.add(sp);
		}
		if (getSiteconsolecss() != null)
		{
			sp = new SitePropertyDTO(getSite(), "site.config", "siteconsolecss", getSiteconsolecss());
			siteProperties.add(sp);
		}
		if (getSitetheme() != null)
		{
			sp = new SitePropertyDTO(getSite(), "site.config", "sitetheme", getSitetheme());
			siteProperties.add(sp);
		}
		if (getRefsitetype() != null)
		{
			sp = new SitePropertyDTO(getSite(), "site.config", "refsitetype", getRefsitetype());
			siteProperties.add(sp);
		}
		if (getRefsite() != null)
		{
			sp = new SitePropertyDTO(getSite(), "site.config", "refsite", getRefsite());
			siteProperties.add(sp);
		}
		if (getRefsitevisible() != null)
		{
			sp = new SitePropertyDTO(getSite(), "site.config", "refsitevisible", getRefsitevisible());
			siteProperties.add(sp);
		}
		if (getRefsitedescr() != null)
		{
			sp = new SitePropertyDTO(getSite(), "site.config", "refsitedescr", getRefsitedescr());
			siteProperties.add(sp);
		}
		if (getAdmrefsitetype() != null)
		{
			sp = new SitePropertyDTO(getSite(), "site.config", "admrefsitetype", getAdmrefsitetype());
			siteProperties.add(sp);
		}
		if (getAdmrefsite() != null)
		{
			sp = new SitePropertyDTO(getSite(), "site.config", "admrefsite", getAdmrefsite());
			siteProperties.add(sp);
		}
		if (getAdmrefsitevisible() != null)
		{
			sp = new SitePropertyDTO(getSite(), "site.config", "admrefsitevisible", getAdmrefsitevisible());
			siteProperties.add(sp);
		}
		if (getAdmrefsitedescr() != null)
		{
			sp = new SitePropertyDTO(getSite(), "site.config", "admrefsitedescr", getAdmrefsitedescr());
			siteProperties.add(sp);
		}
		if (getCardid() != null)
		{
			sp = new SitePropertyDTO(getSite(), "site.config", "cardid", getCardid());
			siteProperties.add(sp);
		}
		if (getOptions() != null)
		{
			sp = new SitePropertyDTO(getSite(), "site.config", "options", getOptions());
			siteProperties.add(sp);
		}

		return siteProperties;
	}
	
	@JsonIgnore
	private boolean resolvedAttributes = false;

    protected java.lang.String  sitelayout;
    protected java.lang.String  siteresourcepath;
    protected java.lang.String  sitecss;
    protected java.lang.String  siteconsolecss;
    protected java.lang.String  sitetheme;
    protected java.lang.String  refsitetype;
    protected java.lang.String  refsite;
    protected java.lang.String  refsitevisible;
    protected java.lang.String  refsitedescr;
    protected java.lang.String  admrefsitetype;
    protected java.lang.String  admrefsite;
    protected java.lang.String  admrefsitevisible;
    protected java.lang.String  admrefsitedescr;
    protected java.lang.String  cardid;
    protected java.lang.String  options;

	public void setSitelayout(java.lang.String sitelayout)
	{
		this.sitelayout = sitelayout;
	}

	public void setSiteresourcepath(java.lang.String siteresourcepath)
	{
		this.siteresourcepath = siteresourcepath;
	}

	public void setSitecss(java.lang.String sitecss)
	{
		this.sitecss = sitecss;
	}

	public void setSiteconsolecss(java.lang.String siteconsolecss)
	{
		this.siteconsolecss = siteconsolecss;
	}

	public void setSitetheme(java.lang.String sitetheme)
	{
		this.sitetheme = sitetheme;
	}

	public void setRefsitetype(java.lang.String refsitetype)
	{
		this.refsitetype = refsitetype;
	}

	public void setRefsite(java.lang.String refsite)
	{
		this.refsite = refsite;
	}

	public void setRefsitevisible(java.lang.String refsitevisible)
	{
		this.refsitevisible = refsitevisible;
	}

	public void setRefsitedescr(java.lang.String refsitedescr)
	{
		this.refsitedescr = refsitedescr;
	}

	public void setAdmrefsitetype(java.lang.String admrefsitetype)
	{
		this.admrefsitetype = admrefsitetype;
	}

	public void setAdmrefsite(java.lang.String admrefsite)
	{
		this.admrefsite = admrefsite;
	}

	public void setAdmrefsitevisible(java.lang.String admrefsitevisible)
	{
		this.admrefsitevisible = admrefsitevisible;
	}

	public void setAdmrefsitedescr(java.lang.String admrefsitedescr)
	{
		this.admrefsitedescr = admrefsitedescr;
	}

	public void setCardid(java.lang.String cardid)
	{
		this.cardid = cardid;
	}

	public void setOptions(java.lang.String options)
	{
		this.options = options;
	}

	public java.lang.String getSitelayout()
	{
		if (!resolvedAttributes)
			resolveSiteDTOFromSiteProperties();

		return sitelayout;
	}

	public String getSiteresourcepath()
	{
		if (!resolvedAttributes)
			resolveSiteDTOFromSiteProperties();

		String p = siteresourcepath;
		if (p == null)
		{
			return "default";
		}

		return p;
	}

	public java.lang.String getSitecss()
	{
		if (!resolvedAttributes)
			resolveSiteDTOFromSiteProperties();
		return sitecss;
	}

	public java.lang.String getSiteconsolecss()
	{
		if (!resolvedAttributes)
			resolveSiteDTOFromSiteProperties();
		return siteconsolecss;
	}

	public java.lang.String getSitetheme()
	{
		if (!resolvedAttributes)
			resolveSiteDTOFromSiteProperties();
		return sitetheme;
	}

	public java.lang.String getRefsitetype()
	{
		if (!resolvedAttributes)
			resolveSiteDTOFromSiteProperties();
		return refsitetype;
	}

	public java.lang.String getRefsite()
	{
		if (!resolvedAttributes)
			resolveSiteDTOFromSiteProperties();
		return refsite;
	}

	public java.lang.String getRefsitevisible()
	{
		if (!resolvedAttributes)
			resolveSiteDTOFromSiteProperties();
		return refsitevisible;
	}

	public java.lang.String getRefsitedescr()
	{
		if (!resolvedAttributes)
			resolveSiteDTOFromSiteProperties();
		return refsitedescr;
	}

	public java.lang.String getAdmrefsitetype()
	{
		if (!resolvedAttributes)
			resolveSiteDTOFromSiteProperties();
		return admrefsitetype;
	}

	public java.lang.String getAdmrefsite()
	{
		if (!resolvedAttributes)
			resolveSiteDTOFromSiteProperties();
		return admrefsite;
	}

	public java.lang.String getAdmrefsitevisible()
	{
		if (!resolvedAttributes)
			resolveSiteDTOFromSiteProperties();
		return admrefsitevisible;
	}

	public java.lang.String getAdmrefsitedescr()
	{
		if (!resolvedAttributes)
			resolveSiteDTOFromSiteProperties();
		return admrefsitedescr;
	}

	public java.lang.String getCardid()
	{
		if (!resolvedAttributes)
			resolveSiteDTOFromSiteProperties();
		return cardid;
	}

	public java.lang.String getOptions()
	{
		if (!resolvedAttributes)
			resolveSiteDTOFromSiteProperties();
		return options;
	}
	
}

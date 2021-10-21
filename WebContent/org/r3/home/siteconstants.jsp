<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/javascript; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*,
    org.r3.db.system.site.SiteDTO,
    org.r3.db.system.siteproperty.SitePropertyDTO  
    " %>

<r3_lang:environment id="r3Env">

<%
  SiteDTO targetSite = r3Env.getRequestSite();
  List<SitePropertyDTO> googleAnalyticsProperties = 
       targetSite.getSiteProperties().getPropertiesByPropertyPackage(/* SitePropertyDTO.PropertyScope.google, */ SitePropertyDTO.GOOGLE_ANALYTICS_PKG);

  List<SitePropertyDTO> sevApplicationProperties = 
	       targetSite.getSiteProperties().getPropertiesByPropertyPackage(/* SitePropertyDTO.PropertyScope.sevapplication, */ SitePropertyDTO.SEV_APPLICATION_PKG);

  List<SitePropertyDTO> sevRankingProperties = 
	       targetSite.getSiteProperties().getPropertiesByPropertyPackage(SitePropertyDTO.SEV_RANKING_PKG);

  String homeEntryListMode = "wall";
  if (targetSite.getSite().equalsIgnoreCase("cvfitpimperiali"))
	  homeEntryListMode = "list";
  
  String requestLanguage = r3Env.getRequestLanguage();
  
%>
  
$.r3Utils.namespace("org.r3");

org.r3.SiteConstants = 
{
    "sitedomain"      : "<%=targetSite.getSitedomain()%>",
    "siteresourcepath": "<%=targetSite.getSiteresourcepath()%>",
    "siteprofile"     : "<%=targetSite.getSiteprofile()%>",
    
    getSiteResourceUrl: function(aResourceType, aResourceFileName)
    { 
        var p = org.r3.Constants.applicationContext + "/resources/sites/" + this.siteresourcepath + "/" + aResourceType + "/" + aResourceFileName;
        return p;
    },
    
    "is10Gen": function()
    {
       if (this.siteprofile && this.siteprofile == 'profile1')
       {
           return true;
       }
       
       return false;
    },
    
    getSiteresourcepathUrl4FileName: function(aResourceFileName)
    {
        var p = org.r3.Constants.applicationContext + "/resources/sites/" + this.siteresourcepath + "/pages/" + aResourceFileName;
        return p;
    },
    
    <%
    if (targetSite.isRefsiteVisibleAsBoolean())
    {
    switch(targetSite.getRefsitetypeAsEnum())
    {
    case site_none: %>
    "referrerWebSite": {
          
          "homeName": null,
          "homeUrl" : null,          
    },    
    <%
		break;
	case site_external: %>
      "referrerWebSite": {
            
            "homeName": "<%=targetSite.getRefsitedescr()%>",
            "homeUrl" : "<%=targetSite.getRefsiteUrl(r3Env.getAppContext(), requestLanguage)%>",            
    },    
    <%    
		break;
	case site_internal:	%>
    "referrerWebSite": {
        
        "homeName": "<%=targetSite.getRefsitedescr()%>",
        "homeUrl" : "<%=targetSite.getRefsiteUrl(r3Env.getAppContext(), requestLanguage)%>",        
     },    
     <%    	
		break;
	}
    }
    else
    { 
    %>
     "referrerWebSite": {
          
          "homeName": null,
          "homeUrl" : null,          
     },        
    <%  
    }
    %>

    <% 
    if (targetSite.isAdmrefsiteVisibleAsBoolean())
    {
    switch(targetSite.getAdmrefsitetypeAsEnum())
    {
    case site_none: %>
    "referrerWebSiteConsole": {
                    
          "consoleName": null,
          "consoleUrl" : null
    },    
    <%
    break;
    case site_external: %>
        "referrerWebSiteConsole": {
                            
          "consoleName": "<%=targetSite.getAdmrefsitedescr()%>",
          "consoleUrl" : "<%=targetSite.getRefsiteConsoleUrl(r3Env.getAppContext(), requestLanguage)%>"
      },    
      <%    
      break;
    case site_internal: %>
      "referrerWebSiteConsole": {
                    
          "consoleName": "<%=targetSite.getAdmrefsitedescr()%>",
          "consoleUrl" : "<%=targetSite.getRefsiteConsoleUrl(r3Env.getAppContext(), requestLanguage)%>"
       },    
       <%     
      break;
    }
    }
    else
    {
    %>
    "referrerWebSiteConsole": {
                    
          "consoleName": null,
          "consoleUrl" : null
    },        
    <% 
    }
    %>
    
    hasReferrerWebSiteHomeReferences: function()
    {
          return this.referrerWebSite && this.referrerWebSite.homeUrl && this.referrerWebSite.homeUrl.length;                   
    },
    
    referrerWebSiteHomeName: function()
    {
        if (this.referrerWebSite.homeName && this.referrerWebSite.homeName.length)
              return this.referrerWebSite.homeName;
              
        return this.referrerWebSite.homeUrl;
    },

    referrerWebSiteHomeUrl: function()
    {
        return this.referrerWebSite.homeUrl;
    },

    hasReferrerWebSiteConsoleReferences: function()
    {
          return this.referrerWebSiteConsole && this.referrerWebSiteConsole.consoleUrl && this.referrerWebSiteConsole.consoleUrl.length;                   
    },
    
    referrerWebSiteConsoleName: function()
    {
        if (this.referrerWebSiteConsole.consoleName && this.referrerWebSiteConsole.consoleName.length)
              return this.referrerWebSiteConsole.consoleName;
              
        return this.referrerWebSiteConsole.consoleUrl;
    },

    referrerWebSiteConsoleUrl: function()
    {
        return this.referrerWebSiteConsole.consoleUrl;
    },
    
    "targetSiteName"   : '<%=targetSite.getSitedescr()%>',
    "targetSite"       : '<%=targetSite.getSite()%>',   
    "targetSiteType"   : '<%=targetSite.getSitetype()%>',
    
    getSiteCollectionIconUrl: function()
    {
    	return "/r3ng/was/<%=targetSite.getSite()%>/it/sitecollection/<%=targetSite.getSite()%>/graphics/sitesquared;imagerole=icon";    
    },
    
    "home"             : {
       "entrylist"     : {
         "ui": '<%=homeEntryListMode%>'
       },
       
       "ranking"       : {
          "enabled": true
       }
    }
    
    <r3_lang:ifinclude include="<%=googleAnalyticsProperties!=null%>" >
    ,"googleAnalytics" : {
    
       "propertypackage" : "<%=SitePropertyDTO.GOOGLE_ANALYTICS_PKG%>"
    <% 
       for(SitePropertyDTO propDto : googleAnalyticsProperties)
       {
    	  %>, "<%=propDto.getPropertyname()%>" : "<%=propDto.getPropertyvalue()%>" <%
       }
     %>
    }
    </r3_lang:ifinclude>

    <r3_lang:ifinclude include="<%=sevApplicationProperties!=null%>" >
    ,"sailEventApplication" : {
    
       "propertypackage" : "<%=SitePropertyDTO.SEV_APPLICATION_PKG%>"
       
    <% 
       for(SitePropertyDTO propDto : sevApplicationProperties)
       {
    	  %>, "<%=propDto.getPropertyname()%>" : "<%=propDto.getPropertyvalue()%>" <%
       }
     %>
    }
    </r3_lang:ifinclude>    

    <r3_lang:ifinclude include="<%=sevRankingProperties!=null%>" >
    ,"sailEventRanking" : {
    
       "propertypackage" : "<%=SitePropertyDTO.SEV_RANKING_PKG%>"
       
    <% 
       for(SitePropertyDTO propDto : sevRankingProperties)
       {
    	  %>, "<%=propDto.getPropertyname()%>" : "<%=propDto.getPropertyvalue()%>" <%
       }
     %>
    }
    </r3_lang:ifinclude>    
    
};

</r3_lang:environment>

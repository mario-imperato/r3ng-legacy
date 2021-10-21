<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/javascript; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*,
    org.r3.db.system.site.SiteDTO
    " %>

<!-- Appunti Deploy -->
<!-- Buildare JS. Modificare Questo file in corrispondenza del getDMSPublicMountPoint -->
<!-- Modificare UNEPWsDMS per la stessa ragione -->
<!-- Modificare web.xml -->
<r3_lang:environment id="r3Env">

$.r3Utils.namespace("org.r3");

org.r3.Constants = 
{
   serverName: "<%=r3Env.getRequestSchemeHostPort()%>",
   
   _browserHistory_enabled : true,
   
   browserHistory_isEnabled: function()
   {
		return Modernizr.history && this._browserHistory_enabled;
   },
	
   applicationContext: "<%=org.r3.system.R3Application.ApplicationCookieContext%>",
   restServicesContext: "/r3ng/was",
   restServicesConfigDictionary: "/org/r3/RESTConfigDictionary.json",
   
   dmsServiceUrl: "/r3ng/was/default/it/system/dms",
   r3_ui_version: "V.2.E",
   
   applicationVersion: "V.2.E",
   
   site: "default",
   language: "it",
   defaultLanguage: "it",
   
   isI18NTranslationRequired: function()
   {
       return false; // this.language != this.defaultLanguage;
   },
   
   cms_default_icon: "/r3ng/resources/img/cms_default_icon.png",
   
   init: function(aSite, aLanguage)
   {
	   this.site = aSite;
	   this.language = aLanguage;
   },
   
   getRestServicesContext: function()
   {
	   return this.restServicesContext + "/" + this.site + "/" + this.language;
   },

   getDMSServicesContext: function()
   {
	   return this.restServicesContext + "/" + this.site + "/" + this.language + '/system/dms';
   },

   getMongoDMSServiceContext: function()
   {
	   return this.restServicesContext + "/" + this.site + "/" + this.language + '/system/mdbdms';   
   },

   getDMSPublicMountPoint: function()
   {
	   return "";
	   // return org.r3.Constants.getDMSServicesContext() + "/document/PUB";
   },

   getDMSPublicCardFolderUrl: function(aCardId)
   {
       // Da sostituire con l'algoritmo corretto per il calcolo...
       var t = this.getDMSPublicMountPoint() + '/' + this.site.toUpperCase() + '/CMS/DFLD0/DFLD0/' + aCardId + '/';    
	   return t;
   },

   getStrutsActionContext: function(aSite)
   {
       if (aSite)
          return this.applicationContext + "/" + aSite + "/" + this.language;
          
	   return this.applicationContext + "/" + this.site + "/" + this.language;
   },
   
   boatIconMaxWidth: 110,  // 100,
   boatIconMaxHeight: 110, // 80,

   defaultBoatIcon: '/resources/img/sailevent/sailboat_icon.png',
   defaultBoatIconWidth: 100,
   defaultBoatIconHeight: 80,
   
   getDefaultBoatIcon: function()
   {
	   return this.applicationContext +  this.defaultBoatIcon;
   },
   
   getStaticFileReference: function(filePath)
   {
       return this.applicationContext +  filePath;
   },
   
   getSiteResourceUrl: function(filePath)
   {
   	   return this.applicationContext + '/resources/sites/' + this.site + '/' + filePath;
   },
   
   passwordValidationMinLength: 6
      
};   

</r3_lang:environment>

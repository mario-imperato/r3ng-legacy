<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>
    
<r3_lang:environment id="r3Env">

  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorDTO.js" />
  
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appdata/SailApplicationDataQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appdata/SailApplicationDataDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appdata/SailApplicationDataDTO.js" />
  
  <r3_lang:script path2resolve="/org/r3/db/sailevent/application/SailApplicationQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/application/SailApplicationDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/application/SailApplicationDTO.js" />
  
  <r3_lang:script path2resolve="/org/r3/home/speedsails/PageManager.js" />
  <r3_lang:script path2resolve="/org/r3/home/speedsails/messages.js" />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/login/LoginActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/login/LoginActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/login/LoginActionForm_validation.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/myapp/MyAppActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/myapp/MyAppActionFormView.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/newslettersubscription/NewsletterSubscriptionActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/newslettersubscription/NewsletterSubscriptionActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/newslettersubscription/NewsletterSubscriptionActionForm_validation.js" />
  
  <r3_lang:script path2resolve="/org/r3/db/sailevent/homeentrylist/SailHomeEntryListQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/homeentrylist/SailHomeEntryListDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/homeentrylist/SailHomeEntryListDTO.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homeentrylist/HomeEntryListActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homeentrylist/HomeEntryListActionFormView.js" />

  <script type="text/javascript">
  $(document).ready(function()
  {
	org.r3.Constants.init('<%=r3Env.getRequestSiteId()%>', '<%=r3Env.getRequestLanguage()%>');
	org.r3.PageManager.init();
    org.r3.PageManager.wait("org.r3.message.waiting");


      
    org.r3.PageManager.networkInitialization(
    {
      success : function()
      {
    	  org.r3.PageManager.canvasInitialization(); 
        
        org.r3.home.speedsails.PageManager.init();
        org.r3.PageManager.closeNotifier();
      },

      error : function()
      {
        org.r3.PageManager.error("org.r3.message.initializationerror");
      },

      verifyIdentity : true
    });
  });
  </script>   

</r3_lang:environment>
      
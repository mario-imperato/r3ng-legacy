<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>
    
<r3_lang:environment id="r3Env">

  
  <r3_lang:script path2resolve="/org/r3/home/shakeus_guest/PageManager.js" />
  <r3_lang:script path2resolve="/org/r3/home/shakeus_guest/messages.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/login/LoginActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/login/LoginActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/login/LoginActionForm_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/login/messages.js" />

  <r3_lang:script path2resolve="/org/r3/registration/messages.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/registration/RegistrationActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/registration/RegistrationActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/registration/RegistrationActionForm_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/registration/messages.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/registration/messages_pt.json" ifLanguage='pt' />
  
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
        
        org.r3.home.shakeus_guest.PageManager.init();
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
      
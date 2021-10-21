<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
<r3_lang:environment id="r3Env">

  <r3_lang:script path2resolve="/org/r3/user/resetuserpwd/PageManager.js" />
  <r3_lang:script path2resolve="/org/r3/user/resetuserpwd/messages.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/resetuserpwd/ResetUserPasswordActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/resetuserpwd/ResetUserPasswordActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/resetuserpwd/ResetUserPasswordActionForm_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/resetuserpwd/messages.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/resetuserpwd/messages_pt.json" ifLanguage='pt' />
  
  <script type="text/javascript">
  $(document).ready(function()
  {
	org.r3.Constants.init('<%=r3Env.getRequestSiteId()%>', '<%=r3Env.getRequestLanguage()%>');
	org.r3.PageManager.init();
    org.r3.PageManager.wait("org.r3.message.waiting");
    $('#pageAction_home').attr('href', "../home.do");


      
    org.r3.PageManager.networkInitialization(
    {
      success : function()
      {
    	  org.r3.PageManager.canvasInitialization(); 
        
        org.r3.user.resetuserpwd.PageManager.init();
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
      
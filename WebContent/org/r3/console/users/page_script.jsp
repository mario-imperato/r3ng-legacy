<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
<r3_lang:environment id="r3Env">

  <r3_lang:script path2resolve="/org/r3/db/system/user/userroleview/UserRoleViewDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/user/userroleview/UserRoleViewDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/user/userroleview/UserRoleViewQueryActionFormView.js" />
  
  <r3_lang:script path2resolve="/org/r3/console/users/PageManager.js" />
  <r3_lang:script path2resolve="/org/r3/console/users/UserQueryActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/console/users/UserQueryActionForm_validation.js" />
  <r3_lang:script path2resolve="/org/r3/console/users/UserQueryAdvancedSearchActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/console/users/UserQueryAdvancedSearchActionForm_validation.js" />
  <r3_lang:script path2resolve="/org/r3/console/users/messages.js" />
  <r3_lang:script path2resolve="/org/r3/console/users/messages_pt.json" ifLanguage='pt' />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/UserDetailActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/UserDetailActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/UserDetailActionFormView_TabGenerale.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/UserDetailActionFormView_TabGenerale_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/UserDetailActionFormView_TabSiteRoles.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/UserDetailActionFormView_TabSiteRoles_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/messages.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/messages_pt.json" ifLanguage='pt' />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/ChangePasswordActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/ChangePasswordActionForm_validation.js" />
  
  <r3_lang:comment>
  <r3_lang:script path2resolve="/org/r3/console/users/UserDetailActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/console/users/UserDetailActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/console/users/UserDetailActionFormView_TabGenerale.js" />
  <r3_lang:script path2resolve="/org/r3/console/users/UserDetailActionFormView_TabGenerale_validation.js" />
  <r3_lang:script path2resolve="/org/r3/console/users/UserDetailActionFormView_TabSiteRoles.js" />
  <r3_lang:script path2resolve="/org/r3/console/users/UserDetailActionFormView_TabSiteRoles_validation.js" />
    
  <r3_lang:script path2resolve="/org/r3/console/users/ChangePasswordActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/console/users/ChangePasswordActionForm_validation.js" />
  </r3_lang:comment>
  
  <script type="text/javascript">
  $(document).ready(function()
  {
	org.r3.Constants.init('<%=r3Env.getRequestSiteId()%>', '<%=r3Env.getRequestLanguage()%>');
	org.r3.PageManager.init();
    org.r3.PageManager.wait("org.r3.message.waiting");
    $('#pageAction_home').attr('href', "home.do");

      
    org.r3.PageManager.networkInitialization(
    {
      success : function()
      {
    	  org.r3.PageManager.canvasInitialization(); 
        
        org.r3.console.users.PageManager.init();
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
      
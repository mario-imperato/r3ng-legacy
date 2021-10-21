<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
<r3_lang:environment id="r3Env">

  <r3_lang:script path2resolve="/org/r3/user/myr3_profile1/PageManager.js" />
  <r3_lang:script path2resolve="/org/r3/user/myr3_profile1/UserProfileActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/user/myr3_profile1/messages.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/rndphotosidebar/RandomPhotoSideBarActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/rndphotosidebar/RandomPhotoSideBarActionFormView.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/taskcompletionsidebar/TaskCompletionSideBarActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/taskcompletionsidebar/TaskCompletionSideBarActionFormView.js" />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/imageupload/ImageUploadActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/imageupload/ImageUploader.js" />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/address/AddressActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/address/AddressActionForm_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/address/messages.js" />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/BusinessCardInfoActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/BusinessCardInfoActionFormView_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/messages.js" />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/changeuserpwd/ChangeUserPasswordActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/changeuserpwd/ChangeUserPasswordActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/changeuserpwd/ChangeUserPasswordActionForm_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/changeuserpwd/messages.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/changeuserpwd/messages_pt.json" ifLanguage="pt" />
        
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
        
        org.r3.user.myr3_profile1.PageManager.init();
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
      
<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
<r3_lang:environment id="r3Env">

  <r3_lang:script path2resolve="/resources/fckeditor/ckeditor.js" scriptEnv="any" />
  <r3_lang:script path2resolve="/resources/fckeditor/adapters/jquery.js" scriptEnv="any" />

  <r3_lang:script path2resolve="/org/r3/db/wbs/wbs/WBSDTO.js" />  
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbs/WBSDTOAdapter.js" />  
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbs/WBSQueryActionFormView.js" />  
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbs/WBSDictionary.js" />  
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbs/WBSDictionary_pt.json" ifLanguage='pt' /> 

  <r3_lang:script path2resolve="/org/r3/console/wbs/PageManager.js" />
  <r3_lang:script path2resolve="/org/r3/console/wbs/messages.js" />
  <r3_lang:script path2resolve="/org/r3/console/wbs/messages_pt.json" ifLanguage='pt' />
  
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsnode/WBSNodeDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsnode/WBSNodeDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsnode/WBSNodeQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsnode/messages.js" />
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsnode/messages_pt.json"  ifLanguage="pt" />
  
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsactor/WBSActorDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsactor/WBSActorDTO.js" />
        
  <r3_lang:script path2resolve="/org/r3/jsportlet/wbs/WBSQueryActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/wbs/WBSActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/wbs/WBSActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/wbs/TabWBS_WBSActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/wbs/TabWBSNode_Miller_WBSActionFormView.js" />    
  <r3_lang:script path2resolve="/org/r3/jsportlet/wbs/TabWBSNode_Detail_WBSActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/wbs/TABWBSNode_Detail_WBSActionFormView_validation.js" />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/wbs/WBSActionFormView_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/wbs/messages.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/wbs/messages_pt.json" ifLanguage='pt' />
  
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
        
        org.r3.console.wbs.PageManager.init();
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
      
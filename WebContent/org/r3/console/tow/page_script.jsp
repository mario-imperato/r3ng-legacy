<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
<r3_lang:environment id="r3Env">

  <r3_lang:comment>
  <r3_lang:script path2resolve="/resources/fckeditor/ckeditor.js" scriptEnv="any" />
  <r3_lang:script path2resolve="/resources/fckeditor/adapters/jquery.js" scriptEnv="any" />
  </r3_lang:comment>
  
  <r3_lang:script path2resolve="/resources/ckeditor_4.6.1/ckeditor.js" scriptEnv="any" />
  <r3_lang:script path2resolve="/resources/ckeditor_4.6.1/adapters/jquery.js" scriptEnv="any" />
  
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbs/WBSDTO.js" />  
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbs/WBSDTOAdapter.js" />  
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbs/WBSQueryActionFormView.js" />  
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbs/WBSDictionary.js" />  
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbs/WBSDictionary_pt.json" ifLanguage='pt' /> 

  <r3_lang:script path2resolve="/org/r3/console/tow/PageManager.js" />
  <r3_lang:script path2resolve="/org/r3/console/tow/WBSQueryActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/console/tow/WBSActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/console/tow/WBSActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/console/tow/TabWBS_WBSActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/console/tow/WBSActionFormView_validation.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/teammemberprofile/TeamMemberProfileActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/teammemberprofile/TeamMemberProfileActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/teammemberprofile/TeamMemberProfileActionFormView_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/teammemberprofile/messages.js" />

  <r3_lang:script path2resolve="/org/r3/db/project/teammemberprofile/TeamMemberProfileDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/teammemberprofile/TeamMemberProfileDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/teammemberprofile/TeamMemberProfileDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/teammemberprofile/TeamMemberProfileQueryActionFormView.js" />
    
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/dashboard/TeamWBSNodeTabularDashBoard.js" />
  
  <r3_lang:script path2resolve="/org/r3/db/project/resourcetimesheet/ResourceTimesheetDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/resourcetimesheet/ResourceTimesheetDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/resourcetimesheet/ResourceTimesheetDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/resourcetimesheet/ResourceTimesheetQueryActionFormView.js" />  
    
  <r3_lang:script path2resolve="/org/r3/db/project/wbsnodeteammemberprofile/WBSNodeTeamMemberProfileDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/wbsnodeteammemberprofile/WBSNodeTeamMemberProfileDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/wbsnodeteammemberprofile/WBSNodeTeamMemberProfileDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/wbsnodeteammemberprofile/WBSNodeTeamMemberProfileQueryActionFormView.js" />
            
  <r3_lang:script path2resolve="/org/r3/db/project/wbsnodeteammemberprofileview/WBSNodeTeamMemberProfileViewDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/wbsnodeteammemberprofileview/WBSNodeTeamMemberProfileViewDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/wbsnodeteammemberprofileview/WBSNodeTeamMemberProfileViewDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/wbsnodeteammemberprofileview/WBSNodeTeamMemberProfileViewQueryActionFormView.js" />
              
  <r3_lang:script path2resolve="/org/r3/console/tow/TabWBSNode_Miller_WBSActionFormView.js" />    
  <r3_lang:script path2resolve="/org/r3/console/tow/TabWBSNode_Detail_WBSActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/console/tow/TABWBSNode_Detail_WBSActionFormView_validation.js" />
  
  <r3_lang:script path2resolve="/org/r3/console/tow/messages.js" />
  <r3_lang:script path2resolve="/org/r3/console/tow/messages_pt.json" ifLanguage='pt' />
  
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsnode/WBSNodeDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsnode/WBSNodeDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsnode/WBSNodeQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsnode/messages.js" />
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsnode/messages_pt.json"  ifLanguage="pt" />
  
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsactor/WBSActorDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsactor/WBSActorDTO.js" />
        
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
        
        org.r3.console.tow.PageManager.init();
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
      
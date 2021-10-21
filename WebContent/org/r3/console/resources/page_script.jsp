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
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/dialog/DialogConfirmationActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/dialog/DialogConfirmationActionFormView.js" />
  
  <r3_lang:script path2resolve="/org/r3/console/resources/PageManager.js" />
  <r3_lang:script path2resolve="/org/r3/console/resources/messages.js" />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/team/messages.js" />    
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/team/TeamQueryActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/team/TeamDetailActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/team/TeamDetailActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/team/TeamCreateActionFormView.js" />  
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/team/TeamDetailActionFormView_validation.js" />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/team/TeamDetailActionFormView_TabResources.js" />  
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/team/TeamDetailActionFormView_TabResources_validation.js" />
    
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/resource/messages.js" />    
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/resource/ResourceQueryActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/resource/ResourceQueryActionForm_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/resource/ResourceDetailActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/resource/ResourceDetailActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/resource/ResourceCreateActionFormView.js" />  
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/resource/ResourceDetailActionFormView_validation.js" />  
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/resource/ResourceDetailActionFormView_TabTeams.js" />  
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/resource/ResourceDetailActionFormView_TabTeams_validation.js" />

  <r3_lang:script path2resolve="/org/r3/db/project/resource/ResourceQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/resource/ResourceDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/resource/ResourceDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/resource/ResourceDictionary.js" /> 

  <r3_lang:script path2resolve="/org/r3/db/project/team/TeamQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/team/TeamDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/team/TeamDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/team/TeamDictionary.js" /> 
  
  <r3_lang:script path2resolve="/org/r3/db/project/teamresource/TeamResourceQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/teamresource/TeamResourceDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/teamresource/TeamResourceDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/teamresource/TeamResourceDictionary.js" /> 

  <r3_lang:script path2resolve="/org/r3/db/project/teamresourceview/TeamResourceViewQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/teamresourceview/TeamResourceViewDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/teamresourceview/TeamResourceViewDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/teamresourceview/TeamResourceViewDictionary.js" /> 
    
  <r3_lang:script path2resolve="/org/r3/jsportlet/teammemberprofile/TeamMemberProfileActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/teammemberprofile/TeamMemberProfileActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/teammemberprofile/TeamMemberProfileActionFormView_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/teammemberprofile/messages.js" />

  <r3_lang:script path2resolve="/org/r3/db/project/teammemberprofile/TeamMemberProfileDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/teammemberprofile/TeamMemberProfileDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/teammemberprofile/TeamMemberProfileDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/teammemberprofile/TeamMemberProfileQueryActionFormView.js" />
    
  <r3_lang:script path2resolve="/org/r3/db/system/siteproperty/SitePropertyQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/siteproperty/SitePropertyDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/siteproperty/SitePropertyDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/siteproperty/SitePropertyDTOTableAdapter.js" />

  <r3_lang:script path2resolve="/org/r3/db/cms/carddescr/CardDescrDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/carddescr/CardDescrDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/carddescr/CardDescrQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/carddescr/CardDescrDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/carddescr/CardDescrDictionary_pt.json" ifLanguage='pt' />
  
  <!--  Dependencies for User Picker -->
  <r3_lang:script path2resolve="/org/r3/db/system/user/userroleview/UserRoleViewDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/user/userroleview/UserRoleViewDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/user/userroleview/UserRoleViewQueryActionFormView.js" />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/UserPickerActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/UserQueryActionForm_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/UserQueryAdvancedSearchActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/UserQueryAdvancedSearchActionForm_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/messages.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/messages_pt.json" ifLanguage='pt' />

  <r3_lang:script path2resolve="/org/r3/jsportlet/user/UserDetailActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/UserDetailActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/UserDetailActionFormView_TabGenerale.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/UserDetailActionFormView_TabGenerale_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/UserDetailActionFormView_TabSiteRoles.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/UserDetailActionFormView_TabSiteRoles_validation.js" />
    
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/ChangePasswordActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/ChangePasswordActionForm_validation.js" />

  <r3_lang:script path2resolve="/org/r3/db/system/classifieritem/ClassifierItemDTO.js" />  
  <r3_lang:script path2resolve="/org/r3/db/system/classifieritem/ClassifierItemDTOAdapter.js" />  
  <r3_lang:script path2resolve="/org/r3/db/system/classifieritem/ClassifierItemQueryActionFormView.js" />  

  <r3_lang:script path2resolve="/org/r3/db/system/classifier/ClassifierDTO.js" />  
  <r3_lang:script path2resolve="/org/r3/db/system/classifier/ClassifierDTOAdapter.js" />  
  <r3_lang:script path2resolve="/org/r3/db/system/classifier/ClassifierQueryActionFormView.js" />  

  <r3_lang:script path2resolve="/org/r3/jsportlet/classifier/ClassifierActionForm.js" />  
  <r3_lang:script path2resolve="/org/r3/jsportlet/classifier/ClassifierActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/classifier/ClassifierActionFormView_validation.js" /> 
  <r3_lang:script path2resolve="/org/r3/jsportlet/classifier/ClassifierItemActionFormView.js" />  
  <r3_lang:script path2resolve="/org/r3/jsportlet/classifier/ClassifierItemActionFormView_validation.js" />  

 <!-- JS teamtimesheet dependencies -->
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/teamtimesheet/messages.js" />    
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/teamtimesheet/TeamTimesheetActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/teamtimesheet/TeamTimesheetActionFormView_validation.js" />
  
  <r3_lang:script path2resolve="/org/r3/db/project/resourcetimesheetview/ResourceTimesheetViewQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/resourcetimesheetview/ResourceTimesheetViewDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/resourcetimesheetview/ResourceTimesheetViewDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/resourcetimesheetview/ResourceTimesheetViewDictionary.js" /> 
              
  <!-- JS dependencies -->
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/teamtimesheetreport/messages.js" />    
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/teamtimesheetreport/TeamTimesheetReportActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/teamtimesheetreport/TeamTimesheetReportActionFormView_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/teamtimesheetreport/TeamTimesheetReportActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/teamtimesheetreport/TeamTimesheetPrintableReportActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/teamtimesheetreport/TeamTimesheetPrintableReportActionFormView.js" />
  
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
        
        org.r3.console.resources.PageManager.init();
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
      
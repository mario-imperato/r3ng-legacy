<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>
    
<r3_lang:environment id="r3Env">


  <r3_lang:script path2resolve="/org/r3/console/sev/application/PageManager.js" />
  <r3_lang:script path2resolve="/org/r3/console/sev/application/messages.js" />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/rndphotosidebar/RandomPhotoSideBarActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/rndphotosidebar/RandomPhotoSideBarActionFormView.js" />
    
  <r3_lang:script path2resolve="/org/r3/console/sev/application/SailApplicationViewQueryActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/console/sev/application/SailApplicationViewQueryActionForm_validation.js" />
  <r3_lang:script path2resolve="/org/r3/console/sev/application/CrewVerificationActionsActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/console/sev/application/CrewVerificationActionsActionFormView_validation.js" />
  
  <r3_lang:script path2resolve="/org/r3/console/sev/application/AdminApplicationActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/console/sev/application/AdminApplicationActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/console/sev/application/AdminApplicationActionFormView_TabAdminInfo_validation.js" />
  <r3_lang:script path2resolve="/org/r3/console/sev/application/AdminApplicationActionFormView_TabAdminInfo_CloneForm_validation.js" />
  
  <r3_lang:script path2resolve="/org/r3/console/sev/application/AdminApplicationActionFormView_TabTechInfo_validation.js" />
  <r3_lang:script path2resolve="/org/r3/console/sev/application/AdminApplicationActionFormView_TabCrewInfo_validation.js" />  
  <r3_lang:script path2resolve="/org/r3/console/sev/application/AdminApplicationActionFormView_TabAdminInfo.js" />
  <r3_lang:script path2resolve="/org/r3/console/sev/application/AdminApplicationActionFormView_TabTechInfo.js" />
  <r3_lang:script path2resolve="/org/r3/console/sev/application/AdminApplicationActionFormView_TabCrewInfo.js" />

  <r3_lang:script path2resolve="/org/r3/db/sailevent/appcrewmemberview/SailApplicationCrewMemberViewQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appcrewmemberview/SailApplicationCrewMemberViewDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appcrewmemberview/SailApplicationCrewMemberViewDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appcrewmemberview/SailApplicationCrewMemberViewSummaryDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appcrewmemberview/SailApplicationCrewMemberViewSummaryDTO.js" />
    
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appeventlogview/SailApplicationEventLogViewQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appeventlogview/SailApplicationEventLogViewDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appeventlogview/SailApplicationEventLogViewDTO.js" />

  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorDTO.js" />

  <r3_lang:script path2resolve="/org/r3/db/sailevent/applicationview/SailApplicationViewQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/applicationview/SailApplicationViewDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/applicationview/SailApplicationViewDTO.js" />
  
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appdata/SailApplicationDataQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appdata/SailApplicationDataDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appdata/SailApplicationDataDTO.js" />
  
  <r3_lang:script path2resolve="/org/r3/db/sailevent/application/SailApplicationQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/application/SailApplicationDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/application/SailApplicationDTO.js" />

  <r3_lang:script path2resolve="/org/r3/db/sailevent/appcrewmember/SailApplicationCrewMemberQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appcrewmember/SailApplicationCrewMemberDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appcrewmember/SailApplicationCrewMemberDTO.js" />

  <r3_lang:script path2resolve="/org/r3/db/sailevent/appdocument/SailApplicationDocumentQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appdocument/SailApplicationDocumentDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appdocument/SailApplicationDocumentDTO.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/application/messages.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/application/ApplicationActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/application/ApplicationWizardNavigatorActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/application/BoatInfoActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/application/BoatInfoActionFormView_validation.js" />
    
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/application/ClassInfoActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/application/ClassInfoActionFormView_validation.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/application/OwnerInfoActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/application/OwnerInfoActionFormView_validation.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/application/CrewInfoActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/application/CrewInfoActionFormView_validation.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/application/AuthorInfoActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/application/AuthorInfoActionFormView_validation.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/application/DocInfoActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/application/DocInfoActionFormView_validation.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/application/PayInfoActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/application/SummaryInfoActionFormView.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/application/UploadFileActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/application/UploadFileActionFormView_validation.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/application/UploadCrewInfoFileActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/application/UploadCrewInfoFileActionFormView_validation.js" />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/appviewer/AppViewerActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/appviewer/AppViewerActionForm.js" />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/crewreportviewer/CrewReportViewerActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/crewreportviewer/CrewReportViewerActionForm.js" />
  
  <r3_lang:script path2resolve="/org/r3/db/system/siteproperty/SitePropertyQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/siteproperty/SitePropertyDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/siteproperty/SitePropertyDTOTableAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/siteproperty/SitePropertyDTO.js" />
  
        
  <script type="text/javascript">
  $(document).ready(function()
  {
	org.r3.Constants.init('<%=r3Env.getRequestSiteId()%>', '<%=r3Env.getRequestLanguage()%>');
	$('#pageAction_home').attr('href', "home.do");
	
	org.r3.PageManager.init();
    org.r3.PageManager.wait("org.r3.message.waiting");


      
    org.r3.PageManager.networkInitialization(
    {
      success : function()
      {
    	  org.r3.PageManager.canvasInitialization(); 
        
        org.r3.console.sev.application.PageManager.init(null);
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
      
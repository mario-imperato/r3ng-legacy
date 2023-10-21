<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>
    
<r3_lang:environment id="r3Env">

<r3_lang:useBean id="currentApplication" scope="request"
                  name="org.r3.db.sailevent.application.SailApplicationDTO"
                  type="org.r3.db.sailevent.application.SailApplicationDTO" >
    <!--  CompanyDTO Not present -->                  
</r3_lang:useBean>


  <r3_lang:script path2resolve="/org/r3/sev/application/PageManager.js" />
  <r3_lang:script path2resolve="/org/r3/sev/application/messages.js" />

  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorDTO.js" />
  
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appdata/SailApplicationDataQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appdata/SailApplicationDataDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appdata/SailApplicationDataDTO.js" />
  
  <r3_lang:script path2resolve="/org/r3/db/sailevent/application/SailApplicationQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/application/SailApplicationDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/application/SailApplicationDTO.js" />

  <r3_lang:script path2resolve="/org/r3/db/sailevent/appcrewmember/SailApplicationCrewMemberQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appcrewmember/SailApplicationCrewMemberDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appcrewmember/SailApplicationCrewMemberDTO.js" />

  <r3_lang:script path2resolve="/org/r3/db/sailevent/appcrewmemberview/SailApplicationCrewMemberViewQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appcrewmemberview/SailApplicationCrewMemberViewDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appcrewmemberview/SailApplicationCrewMemberViewDTO.js" />

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

  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/application/AttendanceSheetActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/application/AttendanceSheetActionFormView_validation.js" />
  
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
        
        org.r3.sev.application.PageManager.init('<%=currentApplication.getApplicationid()%>');
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
      
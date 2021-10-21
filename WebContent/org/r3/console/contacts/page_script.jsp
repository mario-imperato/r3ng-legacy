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
  
  <r3_lang:script path2resolve="/org/r3/console/contacts/PageManager.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/messages.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/messages_pt.json" ifLanguage='pt' />
  
  <r3_lang:script path2resolve="/org/r3/console/contacts/ActorQueryActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/ActorQueryActionForm_validation.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/ActorDetailActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/ActorDetailActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/ActorDetailActionFormView_validation.js" />

  <r3_lang:script path2resolve="/org/r3/console/contacts/ExportContactsActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/ExportContactsActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/ExportContactsActionFormView_validation.js" />

  <r3_lang:script path2resolve="/org/r3/console/contacts/SMSDetailActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/SMSDetailActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/SMSDetailActionFormView_validation.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/SMSQueryActionForm.js" />

  <r3_lang:script path2resolve="/org/r3/console/contacts/OutMailQueryActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/outmail/SentMailMessageActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/outmail/SentMailMessageActionFormView.js" />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/outmail/messages.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/outmail/OutMailMessageActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/outmail/OutMailMessageActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/outmail/OutMailMessageActionFormView_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/outmail/UploadFileActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/outmail/messages_pt.json" ifLanguage='pt' />
  
  <r3_lang:script path2resolve="/org/r3/console/contacts/ActorGroupAddActorsActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/ActorGroupDetailActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/ActorGroupDetailActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/ActorGroupDetailActionFormView_validation.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/ActorGroupQueryActionForm.js" />
  
  <r3_lang:script path2resolve="/org/r3/console/contacts/ImportActorsFromChildSiteActionFormView_validation.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/ImportActorsFromChildSiteActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/ImportActorsFromChildSiteActionForm.js" />    
  
  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorDictionary_pt.json" ifLanguage="pt" />

  <r3_lang:script path2resolve="/org/r3/db/system/outmailspooler/OutMailSpoolerQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/outmailspooler/OutMailSpoolerDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/outmailspooler/OutMailSpoolerDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/outmailspooler/OutMailSpoolerDictionary.js" />
  
  <r3_lang:script path2resolve="/org/r3/db/system/outmailspoolerrecipient/OutMailSpoolerRecipientQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/outmailspoolerrecipient/OutMailSpoolerRecipientDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/outmailspoolerrecipient/OutMailSpoolerRecipientDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/outmailspoolerrecipient/OutMailSpoolerRecipientDictionary.js" />
    
  <r3_lang:script path2resolve="/org/r3/db/system/smsqueue/SMSQueueQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/smsqueue/SMSQueueDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/smsqueue/SMSQueueDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/smsqueue/SMSQueueDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/smsqueue/SMSQueueDictionary_pt.json" ifLanguage='pt' />

  <r3_lang:script path2resolve="/org/r3/db/actor/group/ActorGroupQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/group/ActorGroupDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/group/ActorGroupDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/group/ActorGroupDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/group/ActorGroupDictionary_pt.json" ifLanguage='pt' />
  
  <r3_lang:script path2resolve="/org/r3/db/system/siteproperty/SitePropertyQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/siteproperty/SitePropertyDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/siteproperty/SitePropertyDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/siteproperty/SitePropertyDTOTableAdapter.js" />

  <r3_lang:script path2resolve="/org/r3/db/system/fileimport/fileimport/FileImportDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/fileimport/fileimport/FileImportDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/fileimport/fileimport/FileImportQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/fileimport/fileimport/FileImportDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/fileimport/fileimport/FileImportDictionary_pt.json" ifLanguage='pt' />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/fileupload/UploadFileActionForm.js" /> 
  <r3_lang:script path2resolve="/org/r3/jsportlet/fileupload/UploadFileActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/fileupload/UploadFileActionFormView_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/fileupload/FileImportQueryActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/fileupload/FileImportDetailActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/fileupload/FileImportDetailActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/fileupload/FileImportDetailActionFormView_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/fileupload/messages.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/fileupload/messages_pt.json" ifLanguage='pt' />

  <r3_lang:script path2resolve="/org/r3/db/cms/carddescr/CardDescrDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/carddescr/CardDescrDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/carddescr/CardDescrQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/carddescr/CardDescrDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/carddescr/CardDescrDictionary_pt.json" ifLanguage='pt' />

  <r3_lang:script path2resolve="/org/r3/db/project/siteresource/SiteResourceDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/siteresource/SiteResourceDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/siteresource/SiteResourceQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/siteresource/SiteResourceDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/project/siteresource/SiteResourceDictionary_pt.json" ifLanguage='pt' />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/siteresource/SiteResourceActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/siteresource/SiteResourceActionFormView_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/siteresource/SiteResourceActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/siteresource/messages.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/project/siteresource/messages_pt.json" ifLanguage="pt" />
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
  <r3_lang:comment>
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/UserDetailActionFormView_TabSiteRoles.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/UserDetailActionFormView_TabSiteRoles_validation.js" />
  </r3_lang:comment>
    
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/ChangePasswordActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/user/ChangePasswordActionForm_validation.js" />

            
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
        
        org.r3.console.contacts.PageManager.init();
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
      
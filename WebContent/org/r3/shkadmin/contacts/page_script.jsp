<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
<r3_lang:environment id="r3Env">
  
  <r3_lang:script path2resolve="/resources/ckeditor_4.6.1/ckeditor.js" scriptEnv="any" />
  <r3_lang:script path2resolve="/resources/ckeditor_4.6.1/adapters/jquery.js" scriptEnv="any" />
   
  <r3_lang:script path2resolve="/org/r3/shkadmin/contacts/PageManager.js" />
  <r3_lang:script path2resolve="/org/r3/shkadmin/contacts/messages.js" />
     
  <r3_lang:script path2resolve="/org/r3/jsportlet/dialog/DialogConfirmationActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/dialog/DialogConfirmationActionFormView.js" />
  
  <r3_lang:script path2resolve="/org/r3/console/contacts/messages.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/messages_pt.json" ifLanguage='pt' />
  
  <r3_lang:script path2resolve="/org/r3/console/contacts/ActorQueryActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/ActorQueryActionForm_validation.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/ActorDetailActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/ActorDetailActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/ActorDetailActionFormView_validation.js" />
  
  <r3_lang:script path2resolve="/org/r3/console/contacts/ActorGroupAddActorsActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/ActorGroupDetailActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/ActorGroupDetailActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/ActorGroupDetailActionFormView_validation.js" />
  <r3_lang:script path2resolve="/org/r3/console/contacts/ActorGroupQueryActionForm.js" />
    
  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorDictionary_pt.json" ifLanguage="pt" />
  
  <r3_lang:script path2resolve="/org/r3/db/actor/group/ActorGroupQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/group/ActorGroupDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/group/ActorGroupDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/group/ActorGroupDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/group/ActorGroupDictionary_pt.json" ifLanguage='pt' />
  
  <r3_lang:script path2resolve="/org/r3/db/system/siteproperty/SitePropertyQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/siteproperty/SitePropertyDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/siteproperty/SitePropertyDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/siteproperty/SitePropertyDTOTableAdapter.js" />

  <r3_lang:script path2resolve="/org/r3/db/cms/carddescr/CardDescrDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/carddescr/CardDescrDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/carddescr/CardDescrQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/carddescr/CardDescrDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/carddescr/CardDescrDictionary_pt.json" ifLanguage='pt' />
          
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
        
        org.r3.shkadmin.contacts.PageManager.init();
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
      
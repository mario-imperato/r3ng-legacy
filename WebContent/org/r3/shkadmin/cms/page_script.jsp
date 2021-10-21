<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
<r3_lang:environment id="r3Env">

  <r3_lang:script path2resolve="/resources/ckeditor_4.6.1/ckeditor.js" scriptEnv="any" />
  <r3_lang:script path2resolve="/resources/ckeditor_4.6.1/adapters/jquery.js" scriptEnv="any" />
   
  <r3_lang:script path2resolve="/org/r3/shkadmin/cms/PageManager.js" />

  <r3_lang:script path2resolve="/org/r3/shkadmin/cms/messages.js" />
     
  <r3_lang:script path2resolve="/org/r3/db/mongo/postcollection/PostCollectionDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/postcollection/PostCollectionDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/postcollection/PostCollectionDictionary.js" />     
  <r3_lang:script path2resolve="/org/r3/db/mongo/postcollection/PostCollectionQueryActionFormView.js" />

  <r3_lang:script path2resolve="/org/r3/db/mongo/timelinecollection/TimelineCollectionDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/timelinecollection/TimelineCollectionDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/timelinecollection/TimelineCollectionDictionary.js" />     
  <r3_lang:script path2resolve="/org/r3/db/mongo/timelinecollection/TimelineCollectionQueryActionFormView.js" />
  
  <r3_lang:script path2resolve="/org/r3/db/mongo/contentdefinitioncollection/ContentDefinitionDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/contentdefinitioncollection/ContentDefinitionDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/contentdefinitioncollection/ContentObjectModel.js" />
    
  <r3_lang:script path2resolve="/org/r3/db/mongo/contentdefinitioncollection/crewask/crewask_model.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/contentdefinitioncollection/crewask/crewask_validation.js" />   
  <r3_lang:script path2resolve="/org/r3/db/mongo/contentdefinitioncollection/crewoffer/crewoffer_model.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/contentdefinitioncollection/crewoffer/crewoffer_validation.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/contentdefinitioncollection/shkmessage/shkmessage_model.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/contentdefinitioncollection/shkmessage/shkmessage_validation.js" />  
  <r3_lang:script path2resolve="/org/r3/db/mongo/contentdefinitioncollection/shcask/shcask_model.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/contentdefinitioncollection/shcask/shcask_validation.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/contentdefinitioncollection/shcoffer/shcoffer_model.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/contentdefinitioncollection/shcoffer/shcoffer_validation.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/mongocms/TimelineQueryActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongocms/TimelineDetailActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongocms/TimelineDetailActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongocms/TimelineDetailActionFormView_validation.js" />
       
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongocms/CardQueryActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongocms/CardQueryActionForm_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongocms/CardQueryAdvancedSearchActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongocms/CardQueryAdvancedSearchActionForm_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongocms/messages.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongocms/messages_pt.json" ifLanguage="pt" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongocms/CardDetailActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongocms/CardDetailActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongocms/CardDetailActionFormView_TabGenerale.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongocms/CardDetailActionFormView_TabGenerale_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongocms/CardDetailActionFormView_TabCardText.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongocms/CardDetailActionFormView_TabCardText_validation.js" />  
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongocms/CardDetailActionFormView_TabCardFile_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongocms/CardDetailActionFormView_TabCardFile.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongocms/CardDetailActionFormView_TabCardPhoto.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongocms/CardDetailActionFormView_TabCardContent.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongocms/CardDetailActionFormView_TabCardLink_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongocms/CardDetailActionFormView_TabCardLink.js" />  
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongocms/CardDetailActionFormView_TabPublishing_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongocms/CardDetailActionFormView_TabPublishing.js" />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/imageupload/ImageUploadActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/imageupload/ImageUploader.js" />  
  <r3_lang:script path2resolve="/org/r3/jsportlet/fileupload/UploadFileActionForm.js" /> 
  <r3_lang:script path2resolve="/org/r3/jsportlet/fileupload/UploadFileActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/fileupload/UploadFileActionFormView_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/fileupload/messages.js" />
          
  <r3_lang:script path2resolve="/org/r3/db/system/siteproperty/SitePropertyQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/siteproperty/SitePropertyDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/siteproperty/SitePropertyDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/siteproperty/SitePropertyDTOTableAdapter.js" />
            
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
        
        org.r3.shkadmin.cms.PageManager.init();
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
      
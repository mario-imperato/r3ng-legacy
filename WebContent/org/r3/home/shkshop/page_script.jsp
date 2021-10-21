<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>
    
<r3_lang:environment id="r3Env">

  
  <r3_lang:script path2resolve="/org/r3/db/system/site/SiteDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/site/SiteDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/site/SiteQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/site/SiteDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/site/SiteDictionary_pt.json" ifLanguage='pt' />
    
  <r3_lang:script path2resolve="/org/r3/db/mongo/timelinecollection/TimelineCollectionDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/timelinecollection/TimelineCollectionDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/timelinecollection/TimelineCollectionDictionary.js" />
      
  <r3_lang:script path2resolve="/org/r3/db/mongo/postcollection/PostCollectionDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/postcollection/PostCollectionDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/postcollection/PostCollectionDictionary.js" />

  <r3_lang:script path2resolve="/org/r3/db/mongo/postcommentcollection/PostCommentCollectionDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/postcommentcollection/PostCommentCollectionDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/postcommentcollection/PostCommentCollectionDictionary.js" />
        
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
  <r3_lang:script path2resolve="/org/r3/db/mongo/contentdefinitioncollection/shknews/shknews_model.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/contentdefinitioncollection/shknews/shknews_validation.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/contentdefinitioncollection/shkarticle/shkarticle_model.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/contentdefinitioncollection/shkarticle/shkarticle_validation.js" />
  
  <r3_lang:script path2resolve="/org/r3/db/mongo/contentdefinitioncollection/shkstruct/shkstruct_model.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/contentdefinitioncollection/shkstruct/shkstruct_validation.js" />
  
  <r3_lang:script path2resolve="/org/r3/db/mongo/contentdefinitioncollection/shcaskoffer/shcaskoffer_model.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/contentdefinitioncollection/shcaskoffer/shcaskoffer_validation.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/contentdefinitioncollection/shcofferbook/shcofferbook_model.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/contentdefinitioncollection/shcofferbook/shcofferbook_validation.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/contentdefinitioncollection/tweet/tweet_model.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/contentdefinitioncollection/tweet/tweet_validation.js" />
      
  <r3_lang:script path2resolve="/org/r3/db/mongo/sitecollection/SiteCollectionConfigDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/sitecollection/SiteCollectionConfigDTOAdapter.js" />  

  <r3_lang:script path2resolve="/org/r3/jsportlet/mongotimeline/tuner/TimelineTunerActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongotimeline/tuner/TimelineTunerActionFormView.js" /> 
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongotimeline/TimelineActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongotimeline/TimelineActionFormView.js" />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongotimeline/PostActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mongotimeline/PostActionFormView.js" />
              
  <r3_lang:script path2resolve="/org/r3/jsportlet/site/sitemember/SiteMemberPortletActionForm.js" />  
  <r3_lang:script path2resolve="/org/r3/jsportlet/site/sitemember/SiteMemberPortletActionFormView.js" />  

  <r3_lang:script path2resolve="/org/r3/jsportlet/site/please_login_or_register/PleaseLogInOrRegisterPortletActionForm.js" />  
  <r3_lang:script path2resolve="/org/r3/jsportlet/site/please_login_or_register/PleaseLogInOrRegisterPortletActionFormView.js" />  
  
  <r3_lang:script path2resolve="/org/r3/home/shkshop/PageManager.js" />
  <r3_lang:script path2resolve="/org/r3/home/shkshop/messages.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/imageupload/FileUploader.js" />
        
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
        
        org.r3.home.shkshop.PageManager.init();
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
      
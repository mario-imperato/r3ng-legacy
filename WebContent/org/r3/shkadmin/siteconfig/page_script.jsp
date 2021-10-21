<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
<r3_lang:environment id="r3Env">

  <r3_lang:script path2resolve="/resources/ckeditor_4.6.1/ckeditor.js" scriptEnv="any" />
  <r3_lang:script path2resolve="/resources/ckeditor_4.6.1/adapters/jquery.js" scriptEnv="any" />

  <r3_lang:script path2resolve="/org/r3/shkadmin/siteconfig/PageManager.js" />
  <r3_lang:script path2resolve="/org/r3/shkadmin/siteconfig/messages.js" />      
  <r3_lang:script path2resolve="/org/r3/shkadmin/siteconfig/AddressActionForm.js" />
  
  <r3_lang:script path2resolve="/org/r3/shkadmin/siteconfig/SiteInfoActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/shkadmin/siteconfig/SiteInfoActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/shkadmin/siteconfig/SiteInfoActionFormView_validation.js" />
    
  <r3_lang:script path2resolve="/org/r3/shkadmin/siteconfig/FacebookConfigActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/shkadmin/siteconfig/FacebookConfigActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/shkadmin/siteconfig/FacebookConfigActionFormView_validation.js" />
    
  <r3_lang:script path2resolve="/org/r3/shkadmin/siteconfig/AdminsActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/shkadmin/siteconfig/AdminsActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/shkadmin/siteconfig/AdminsActionFormView_validation.js" />
      
  <r3_lang:script path2resolve="/org/r3/jsportlet/address/messages.js" />         
  <r3_lang:script path2resolve="/org/r3/jsportlet/address/AddressActionFormView.js" />      
  <r3_lang:script path2resolve="/org/r3/jsportlet/address/AddressActionForm_validation.js" />      
 
 
  <r3_lang:script path2resolve="/org/r3/db/system/site/SiteDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/site/SiteDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/site/SiteQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/site/SiteDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/site/SiteDictionary_pt.json" ifLanguage='pt' />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/imageupload/ImageUploadActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/imageupload/messages.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/imageupload/ImageUploadActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/imageupload/ImageUploader.js" />
  
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


      
    org.r3.PageManager.networkInitialization(
    {
      success : function()
      {
    	  org.r3.PageManager.canvasInitialization(); 
        
        org.r3.shkadmin.siteconfig.PageManager.init();
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
      
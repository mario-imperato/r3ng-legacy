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
  <r3_lang:script path2resolve="/org/r3/db/system/site/SiteDictionary_pt.json" ifLanguage='pt'/>
  
  <r3_lang:script path2resolve="/org/r3/shakeus/newsite/neighborhood/PageManager.js" />
  <r3_lang:script path2resolve="/org/r3/shakeus/newsite/neighborhood/messages.js" />
  
  <r3_lang:script path2resolve="/org/r3/shakeus/newsite/messages.js" />
  <r3_lang:script path2resolve="/org/r3/shakeus/newsite/TermsAndConditionActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/shakeus/newsite/TermsAndConditionActionFormView.js" />
    <r3_lang:script path2resolve="/org/r3/shakeus/newsite/SiteRequestAcceptedActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/shakeus/newsite/SiteRequestAcceptedActionFormView.js" />
  
  <r3_lang:script path2resolve="/org/r3/shakeus/newsite/SiteInfoActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/shakeus/newsite/SiteInfoActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/shakeus/newsite/SiteInfoActionFormView_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/rndphotosidebar/RandomPhotoSideBarActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/rndphotosidebar/RandomPhotoSideBarActionFormView.js" />  
  

  
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
        
    	  org.r3.shakeus.newsite.neighborhood.PageManager.init();
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
      
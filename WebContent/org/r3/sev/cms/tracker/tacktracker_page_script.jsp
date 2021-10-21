<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>
    
<r3_lang:environment id="r3Env">

  <r3_lang:script path2resolve="/org/r3/sev/cms/tracker/PageManager.js" />
  <r3_lang:script path2resolve="/org/r3/sev/cms/tracker/messages.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/rndphotosidebar/RandomPhotoSideBarActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/rndphotosidebar/RandomPhotoSideBarActionFormView.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/cms/CMSHTMLPageViewerActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cms/CMSHTMLPageViewerActionFormView.js" />

  <r3_lang:script path2resolve="/org/r3/sev/cms/tracker/CMSPageActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/sev/cms/tracker/CMSPageActionFormView.js" />
          
  <script type="text/javascript">
  $(document).ready(function()
  {
	// New Version Of Script
	org.r3.Constants.init('<%=r3Env.getRequestSiteId()%>', '<%=r3Env.getRequestLanguage()%>');
	$('#pageAction_home').attr('href', "home.do");
	
	org.r3.PageManager.init();
    org.r3.PageManager.wait("org.r3.message.waiting");


      
    org.r3.PageManager.networkInitialization(
    {
      success : function()
      {
    	  org.r3.PageManager.canvasInitialization(); 
        
        org.r3.sev.cms.tracker.PageManager.init();
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
      
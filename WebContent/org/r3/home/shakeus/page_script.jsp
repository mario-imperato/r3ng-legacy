<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>
    
<r3_lang:environment id="r3Env">

  
  <r3_lang:script path2resolve="/org/r3/home/shakeus/PageManager.js" />
  <r3_lang:script path2resolve="/org/r3/home/shakeus/messages.js" />

  <r3_lang:script path2resolve="/org/r3/db/mongo/postcollection/PostCollectionDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/postcollection/PostCollectionDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/postcollection/PostCollectionDictionary.js" />     
  <r3_lang:script path2resolve="/org/r3/db/mongo/postcollection/PostCollectionQueryActionFormView.js" />


  <r3_lang:script path2resolve="/org/r3/jsportlet/mapexplore/MapExplorerActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mapexplore/MapExplorerActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mapexplore/MapExplorerActionForm_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/mapexplore/messages.js" />
  
  <r3_lang:script path2resolve="/org/r3/db/system/site/SiteDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/site/SiteDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/site/SiteQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/site/SiteDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/site/SiteDictionary_pt.json" ifLanguage='pt' />
    

      
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
        
        org.r3.home.shakeus.PageManager.init();
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
      
<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>
    
<r3_lang:environment id="r3Env">

  <r3_lang:script path2resolve="/org/r3/sev/ranking/PageManager.js" />
  <r3_lang:script path2resolve="/org/r3/sev/ranking/messages.js" />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/rankingview/RankingSynopticActionForm.js" /> 
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/rankingview/RankingSynopticActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/rankingview/RankingInstanceViewerCyFileActionForm.js" /> 
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/rankingview/RankingInstanceViewerCyFileActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/rankingview/RankingInstanceViewerCyFilePrintableActionFormView.js" />
      
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/rankingview/RankingInstanceViewerActionForm.js" /> 
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/rankingview/RankingInstanceViewerActionFormView.js" />
        
  <r3_lang:script path2resolve="/org/r3/db/sailevent/ranking/RankingQueryActionFormView.js" /> 
  <r3_lang:script path2resolve="/org/r3/db/sailevent/ranking/RankingDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/ranking/RankingDTOAdapter.js" />       

  <r3_lang:script path2resolve="/org/r3/db/sailevent/rankingview/RankingViewQueryActionFormView.js" /> 
  <r3_lang:script path2resolve="/org/r3/db/sailevent/rankingview/RankingViewDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/rankingview/RankingViewDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/rankingview/RankingViewSynopticDTO.js" />              
  <r3_lang:script path2resolve="/org/r3/db/sailevent/rankingview/RankingViewSynopticDTOAdapter.js" />       

  <r3_lang:script path2resolve="/org/r3/db/sailevent/rankinginstance/RankingInstanceQueryActionFormView.js" /> 
  <r3_lang:script path2resolve="/org/r3/db/sailevent/rankinginstance/RankingInstanceDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/rankinginstance/RankingInstanceDTOAdapter.js" />       

  <r3_lang:script path2resolve="/org/r3/db/sailevent/rankinginstancedetailview/RankingInstanceDetailViewQueryActionFormView.js" /> 
  <r3_lang:script path2resolve="/org/r3/db/sailevent/rankinginstancedetailview/RankingInstanceDetailViewDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/rankinginstancedetailview/RankingInstanceDetailViewDTOAdapter.js" />       
  <r3_lang:script path2resolve="/org/r3/db/sailevent/rankinginstancedetailview/RankingInstanceDetailViewDictionary.js" />       

  <r3_lang:script path2resolve="/org/r3/db/sailevent/rankinginstanceview/RankingInstanceViewQueryActionFormView.js" /> 
  <r3_lang:script path2resolve="/org/r3/db/sailevent/rankinginstanceview/RankingInstanceViewDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/rankinginstanceview/RankingInstanceViewDTOAdapter.js" />       
        
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
        
        org.r3.sev.ranking.PageManager.init();
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
      
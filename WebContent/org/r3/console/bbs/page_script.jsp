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

  <r3_lang:script path2resolve="/org/r3/console/bbs/PageManager.js" />
  <r3_lang:script path2resolve="/org/r3/console/bbs/messages.js" />
  <r3_lang:script path2resolve="/org/r3/console/bbs/messages_pt.json" ifLanguage='pt' />
  
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbstopicview/BBSTopicViewDTO.js" />  
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbstopicview/BBSTopicViewDTOAdapter.js" />  
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbstopicview/BBSTopicViewQueryActionFormView.js" />  
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbstopicview/BBSTopicViewDictionary.js" />  
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbstopicview/BBSTopicViewDictionary_pt.json" ifLanguage='pt' /> 
 
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbstopic/BBSTopicDictionary.js" />  
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbstopic/BBSTopicDictionary_pt.json" ifLanguage='pt' /> 
  
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbsthreadnodeview/BBSThreadNodeViewDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbsthreadnodeview/BBSThreadNodeViewDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbsthreadnodeview/BBSThreadNodeViewQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbsthreadnodeview/BBSThreadNodeViewDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbsthreadnodeview/BBSThreadNodeViewDictionary_pt.json" ifLanguage='pt' />
   
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbsthreadnode/BBSThreadNodeDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbsthreadnode/BBSThreadNodeDictionary_pt.json" ifLanguage='pt'  />
  
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbsthread/BBSThreadDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbsthread/BBSThreadDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbsthread/BBSThreadQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbsthread/BBSThreadDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbsthread/BBSThreadDictionary_pt.json" ifLanguage='pt'  />
    
  <r3_lang:script path2resolve="/org/r3/console/bbs/BBSTopicQueryActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/console/bbs/BBSTopicDetailActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/console/bbs/BBSTopicDetailActionFormView.js" />  
  <r3_lang:script path2resolve="/org/r3/console/bbs/BBSTopicDetailActionFormView_validation.js" />

  <r3_lang:script path2resolve="/org/r3/console/bbs/BBSThreadDetailActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/console/bbs/BBSThreadDetailActionFormView.js" />  
  <r3_lang:script path2resolve="/org/r3/console/bbs/BBSThreadDetailActionFormView_validation.js" />

  <r3_lang:script path2resolve="/org/r3/console/bbs/BBSThreadNodeDetailActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/console/bbs/BBSThreadNodeDetailActionFormView.js" />  
  <r3_lang:script path2resolve="/org/r3/console/bbs/BBSThreadNodeDetailActionFormView_validation.js" />
  
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
        
        org.r3.console.bbs.PageManager.init();
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
      
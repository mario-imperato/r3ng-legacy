<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*,
    org.r3.system.util.StringUtils
    " %>
    
<r3_lang:environment id="r3Env">

  <r3_lang:useBean id="pageDTO" scope="request"
                  name="org.r3.db.cms.pageview.PageViewDTO"
                  type="org.r3.db.cms.pageview.PageViewDTO" >
    <!--  CompanyDTO Not present -->                  
  </r3_lang:useBean>
  
  <r3_lang:useBean id="cardDTO" scope="request"
                  name="org.r3.db.cms.card.CardDTO"
                  type="org.r3.db.cms.card.CardDTO" >
    <!--  CompanyDTO Not present -->                  
  </r3_lang:useBean>

  <r3_lang:script path2resolve="/resources/fckeditor/ckeditor.js" scriptEnv="any" />
  <r3_lang:script path2resolve="/resources/fckeditor/adapters/jquery.js" scriptEnv="any" />
  
    
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbs/WBSQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbs/WBSDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbs/WBSDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbs/WBSDictionary.js" />  
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbs/WBSDictionary_pt.json" ifLanguage='pt' /> 
  
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsnode/WBSNodeQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsnode/WBSNodeDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsnode/WBSNodeDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsnode/messages.js" />
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsnode/messages_pt.json"  ifLanguage="pt" /> 
  
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsactor/WBSActorDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/wbs/wbsactor/WBSActorDTO.js" />
    
  <r3_lang:script path2resolve="/org/r3/wbs/wbsfillout/PageManager.js" />
  <r3_lang:script path2resolve="/org/r3/wbs/wbsfillout/messages.js" />
  <r3_lang:script path2resolve="/org/r3/wbs/wbsfillout/messages_pt.json" ifLanguage="pt" />
  <r3_lang:script path2resolve="/org/r3/wbs/wbsfillout/NavigatorActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/wbs/wbsfillout/NavigatorActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/wbs/wbsfillout/WBSDetailActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/wbs/wbsfillout/WBSDetailActionFormView.js" />  
  <r3_lang:script path2resolve="/org/r3/wbs/wbsfillout/WBSNodeDetailActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/wbs/wbsfillout/WBSNodeDetailActionFormView.js" />  
  <r3_lang:script path2resolve="/org/r3/wbs/wbsfillout/WBSNodeDetailActionFormView_validation.js" />  
    
  <r3_lang:script path2resolve="/org/r3/jsportlet/bbs/BBSThreadPortletView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/bbs/BBSThreadPortletView_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/bbs/messages.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/bbs/messages_pt.json" ifLanguage='pt' />
    

  <r3_lang:script path2resolve="/org/r3/db/bbs/bbstopic/BBSTopicDTO.js" />  
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbstopic/BBSTopicDTOAdapter.js" />  
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbstopic/BBSTopicQueryActionFormView.js" />  
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbstopic/BBSTopicDictionary.js" />  
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbstopic/BBSTopicDictionary_pt.json" ifLanguage='pt' /> 
  
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbsthreadnodeview/BBSThreadNodeViewDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbsthreadnodeview/BBSThreadNodeViewDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbsthreadnodeview/BBSThreadNodeViewQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbsthreadnodeview/BBSThreadNodeViewDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbsthreadnodeview/BBSThreadNodeViewDictionary_pt.json" ifLanguage='pt' />
  
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbsthread/BBSThreadDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbsthread/BBSThreadDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbsthread/BBSThreadQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbsthread/BBSThreadDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbsthread/BBSThreadDictionary_pt.json" ifLanguage='pt' />
  <r3_lang:script path2resolve="/org/r3/db/bbs/bbsthread/BBSThreadDTO_Default_Profile.js" />
      
  <r3_lang:script path2resolve="/org/r3/jsportlet/cms/CMSPage_CardIndexDetailActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cms/CMSPage_CardIndexDetailActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cms/CMSPage_PageDecoratorActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cms/CMSPage_PageDecoratorActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cms/CMSPage_PaginationHelper.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cms/CMSPage_GalleryView.js" />

 
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
        
        org.r3.wbs.wbsfillout.PageManager.init({ pageid : '<%=pageDTO.getPageidAsString()%>', pagetype : '<%=pageDTO.getPagetypeAsString()%>' }, { cardid : '<%=cardDTO.getCardidAsString()%>', title : <%=StringUtils.convert2JSONString(cardDTO.getSystemtitleAsString())%>  });
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
      
<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
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
  
  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/actor/actor/ActorDTO.js" />
  
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appdata/SailApplicationDataQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appdata/SailApplicationDataDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/appdata/SailApplicationDataDTO.js" />
  
  <r3_lang:script path2resolve="/org/r3/db/sailevent/application/SailApplicationQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/application/SailApplicationDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/application/SailApplicationDTO.js" />
  
  <r3_lang:script path2resolve="/org/r3/cms/ss/veleria/PageManager.js" />
  <r3_lang:script path2resolve="/org/r3/cms/ss/veleria/messages.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cms/CMSPage_CardIndexDetailActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cms/CMSPage_CardIndexDetailActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cms/CMSPage_PageDecoratorActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cms/CMSPage_PageDecoratorActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cms/CMSPage_PaginationHelper.js" />    
  <r3_lang:script path2resolve="/org/r3/jsportlet/cms/CMSPage_GalleryView.js" />


  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/myapp/MyAppActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/myapp/MyAppActionFormView.js" />


  <r3_lang:script path2resolve="/org/r3/db/sailevent/homeentrylist/SailHomeEntryListQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/homeentrylist/SailHomeEntryListDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/homeentrylist/SailHomeEntryListDTO.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homeentrylist/HomeEntryListActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/sev/homeentrylist/HomeEntryListActionFormView.js" />

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
        
        org.r3.cms.ss.veleria.PageManager.init({ pageid : '<%=pageDTO.getPageidAsString()%>', pagetype : '<%=pageDTO.getPagetypeAsString()%>' }, { cardid : '<%=cardDTO.getCardidAsString()%>', title : <%=StringUtils.convert2JSONString(cardDTO.getSystemtitleAsString())%>  });
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
      
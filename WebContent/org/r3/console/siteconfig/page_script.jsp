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

  <r3_lang:script path2resolve="/org/r3/console/siteconfig/PageManager.js" />
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/messages.js" />
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/messages_pt.json" ifLanguage='pt' />
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/HomePortletCfgActionForm.js" />  
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/HomePortletCfgActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/HomePortletCfgActionFormView_validation.js" />
  
  <r3_lang:script path2resolve="/org/r3/db/system/siteproperty/SitePropertyQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/siteproperty/SitePropertyDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/siteproperty/SitePropertyDTOTableAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/siteproperty/SitePropertyDTO.js" />

  <r3_lang:script path2resolve="/org/r3/db/system/siteportletcfg/SitePortletConfigQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/siteportletcfg/SitePortletConfigDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/siteportletcfg/SitePortletConfigDTO.js" />

  <r3_lang:script path2resolve="/org/r3/console/siteconfig/SitePropertyActionForm.js" />  
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/SitePropertyActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/SitePropertyActionFormView_PkgUiCfg.js" />
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/SitePropertyActionFormView_PkgUiCfg_validation.js" />

  <r3_lang:script path2resolve="/org/r3/console/siteconfig/SitePropertyActionFormView_PkgGoogle.js" />
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/SitePropertyActionFormView_PkgGoogleAnalytics_validation.js" />

  <r3_lang:script path2resolve="/org/r3/console/siteconfig/SitePropertyActionFormView_PkgSevApp.js" />
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/SitePropertyActionFormView_PkgSevApp_validation.js" />

  <r3_lang:script path2resolve="/org/r3/console/siteconfig/SitePropertyActionFormView_PkgSevRanking.js" />
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/SitePropertyActionFormView_PkgSevRanking_validation.js" />

  <r3_lang:script path2resolve="/org/r3/console/siteconfig/SitePropertyActionFormView_PkgSms.js" />
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/SitePropertyActionFormView_PkgSms_validation.js" />

  <r3_lang:script path2resolve="/org/r3/console/siteconfig/SitePropertyActionFormView_PkgMail.js" />
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/SitePropertyActionFormView_PkgMail_validation.js" />
  
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/SitePropertyActionFormView_PkgFiv.js" />
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/SitePropertyActionFormView_PkgFiv_validation.js" />

  <r3_lang:script path2resolve="/org/r3/console/siteconfig/SitePropertyActionFormView_Address.js" />
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/SitePropertyActionFormView_Address_validation.js" />
  
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/calendar/CalendarActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/calendar/CalendarActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/calendar/CalendarActionFormView_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/calendar/messages.js" />

  <r3_lang:script path2resolve="/org/r3/jsportlet/calendar/CalendarEventActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/calendar/CalendarEventActionFormView_validation.js" />
  
  <r3_lang:script path2resolve="/org/r3/db/system/classifieritem/ClassifierItemDTO.js" />  
  <r3_lang:script path2resolve="/org/r3/db/system/classifieritem/ClassifierItemDTOAdapter.js" />  
  <r3_lang:script path2resolve="/org/r3/db/system/classifieritem/ClassifierItemQueryActionFormView.js" />  

  <r3_lang:script path2resolve="/org/r3/db/system/classifier/ClassifierDTO.js" />  
  <r3_lang:script path2resolve="/org/r3/db/system/classifier/ClassifierDTOAdapter.js" />  
  <r3_lang:script path2resolve="/org/r3/db/system/classifier/ClassifierQueryActionFormView.js" />  

  <r3_lang:script path2resolve="/org/r3/jsportlet/classifier/ClassifierActionForm.js" />  
  <r3_lang:script path2resolve="/org/r3/jsportlet/classifier/ClassifierActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/classifier/ClassifierActionFormView_validation.js" /> 
  <r3_lang:script path2resolve="/org/r3/jsportlet/classifier/ClassifierItemActionFormView.js" />  
  <r3_lang:script path2resolve="/org/r3/jsportlet/classifier/ClassifierItemActionFormView_validation.js" />  
  <r3_lang:script path2resolve="/org/r3/jsportlet/classifier/messages.js" />  

  <r3_lang:script path2resolve="/org/r3/db/cms/pagedescr/PageDescrDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/pagedescr/PageDescrDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/pagedescr/PageDescrQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/pagedescr/PageDescrDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/pagedescr/PageDescrDictionary_pt.json" ifLanguage='pt' />
      

 
  <r3_lang:script path2resolve="/org/r3/db/system/site/SiteDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/site/SiteDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/site/SiteQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/site/SiteDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/site/SiteDictionary_pt.json" ifLanguage='pt' />
  
  <r3_lang:script path2resolve="/org/r3/db/sailevent/event/SailEventDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/event/SailEventDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/sailevent/event/SailEventQueryActionFormView.js" />

  <r3_lang:script path2resolve="/org/r3/console/siteconfig/site/SiteDetailActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/site/SiteDetailActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/site/SiteDetailActionFormView_TabGenerale.js" />  
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/site/SiteDetailActionFormView_TabGenerale_validation.js" />
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/site/SiteDetailActionFormView_TabCardGraphics.js" />  
  <r3_lang:script path2resolve="/org/r3/jsportlet/imageupload/ImageUploadActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/imageupload/ImageUploader.js" />
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/site/messages.js" />
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/site/messages_pt.json" ifLanguage='pt' />

  <r3_lang:script path2resolve="/org/r3/console/siteconfig/page/PageQueryActionForm.js" /> 
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/page/PageDetailActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/page/PageDetailActionFormView.js" />

  <r3_lang:script path2resolve="/org/r3/console/siteconfig/page/messages.js" />
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/page/messages_pt.json" ifLanguage='pt' />
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/page/PageDetailActionFormView_TabGenerale.js" />
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/page/PageDetailActionFormView_TabGenerale_validation.js" />

  <r3_lang:script path2resolve="/org/r3/console/siteconfig/page/PageDetailActionFormView_TabPageText.js" />
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/page/PageDetailActionFormView_TabPageText_validation.js" />

  
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/site/SiteDetailActionFormView_TabCardFile_validation.js" />
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/site/SiteDetailActionFormView_TabCardFile.js" />
  
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/site/UploadFileActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/console/siteconfig/site/UploadFileActionFormView.js" />

  <!-- cmsconsole js dependencies -->
  <r3_lang:script path2resolve="/org/r3/db/cms/card/CardDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/card/CardDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/card/CardQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/card/CardDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/card/CardDictionary_pt.json" ifLanguage='pt' />

  <r3_lang:script path2resolve="/org/r3/db/cms/group/GroupDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/group/GroupDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/group/GroupQueryActionFormView.js" />

  <r3_lang:script path2resolve="/org/r3/db/cms/channel/ChannelDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/channel/ChannelDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/channel/ChannelQueryActionFormView.js" />

  <r3_lang:script path2resolve="/org/r3/db/cms/carddescr/CardDescrDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/carddescr/CardDescrDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/carddescr/CardDescrQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/carddescr/CardDescrDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/carddescr/CardDescrDictionary_pt.json" ifLanguage='pt' />

  <r3_lang:script path2resolve="/org/r3/db/cms/cardproperty/CardPropertyDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/cardproperty/CardPropertyDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/cardproperty/CardPropertyQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/cardproperty/CardPropertyDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/cardproperty/CardPropertyDictionary_pt.json" ifLanguage='pt' />
       
  <r3_lang:script path2resolve="/org/r3/jsportlet/cmsconsole/CardQueryActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cmsconsole/CardPickerActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cmsconsole/CardQueryActionForm_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cmsconsole/CardQueryAdvancedSearchActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cmsconsole/CardQueryAdvancedSearchActionForm_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cmsconsole/messages.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cmsconsole/messages_pt.json" ifLanguage="pt" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cmsconsole/CardDetailActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cmsconsole/CardDetailActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cmsconsole/CardDetailActionFormView_TabGenerale.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cmsconsole/CardDetailActionFormView_TabGenerale_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cmsconsole/CardDetailActionFormView_TabCardText.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cmsconsole/CardDetailActionFormView_TabCardText_validation.js" />  
  <r3_lang:script path2resolve="/org/r3/jsportlet/cmsconsole/CardDetailActionFormView_TabCardFile_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cmsconsole/CardDetailActionFormView_TabCardFile.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cmsconsole/CardDetailActionFormView_TabCardLink_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cmsconsole/CardDetailActionFormView_TabCardLink.js" />  
  <r3_lang:script path2resolve="/org/r3/jsportlet/cmsconsole/UploadFileActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cmsconsole/UploadFileActionFormView.js" />

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
        
        org.r3.console.siteconfig.PageManager.init();
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
      
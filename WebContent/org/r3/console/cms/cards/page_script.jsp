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
   
  <r3_lang:script path2resolve="/org/r3/console/cms/cards/PageManager.js" />
  <r3_lang:script path2resolve="/org/r3/console/cms/cards/CardChannelQueryActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/console/cms/cards/CardChannelQueryActionForm_validation.js" />
  <r3_lang:script path2resolve="/org/r3/console/cms/cards/messages.js" />
  <r3_lang:script path2resolve="/org/r3/console/cms/cards/messages_pt.json" ifLanguage="pt" />
     
  <r3_lang:script path2resolve="/org/r3/db/cms/card/CardDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/card/CardDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/card/CardQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/card/CardDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/card/CardDictionary_pt.json" ifLanguage='pt' />

  <r3_lang:script path2resolve="/org/r3/db/cms/cardchannelview/CardChannelViewDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/cardchannelview/CardChannelViewDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/cardchannelview/CardChannelViewQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/cardchannelview/CardChannelViewDictionary.js" />
  
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
    $('#pageAction_home').attr('href', "../home.do");

      
    org.r3.PageManager.networkInitialization(
    {
      success : function()
      {
    	  org.r3.PageManager.canvasInitialization(); 
        
        org.r3.console.cms.cards.PageManager.init();
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
      
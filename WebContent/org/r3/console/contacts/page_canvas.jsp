<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env" namespace='org.r3.console.contacts'>
  
  <div id="actorQueryActionForm"  class="actionForm"></div>
  <div id="actorDetailActionForm" class="actionForm"></div>

  <div id="actorGroupDeleteConfirmationDialogActionForm" class="actionForm"></div>
  
  <div id="actorGroupQueryActionForm" class="actionForm"></div>
  <div id="actorGroupDetailActionForm" class="actionForm"></div>
  <div id="actorGroupActorQueryActionForm" class="actionForm"></div>
  <div id="actorGroupAddActorsActionForm" class="actionForm"></div>
  <div id="smsDetailActionForm" class="actionForm"></div>
  <div id="smsQueryActionForm" class="actionForm"></div>
  <div id="mailQueryActionForm" class="actionForm"></div>
  <div id="outMailMessageActionForm" class="actionForm"></div>
  <div id="outMailMessageAttachmentsActionForm" class="actionForm"></div>
  <div id="exportContactsActionForm" class="actionForm"></div>
  <div id="uploadFileActionForm" class="actionForm"></div>
  <div id="fileImportQueryActionForm" class="actionForm"></div>
  <div id="fileImportDetailActionForm" class="actionForm"></div>
  <div id="importActorsFromChildSiteActionForm" class="actionForm"></div>
  <div id="userPickerAdvancedSearchActionForm" class="advancedSearchActionForm" style="display:none"></div>
  <div id='userPickerActionForm' class='actionForm'></div>
  
  <div id="userDetailActionForm" class="actionForm" style="display:none"></div>
  <div id="siteRolesActionForm"  class="actionForm" style="display:none;"></div>
    
<!--   <div style='padding-left: 500px'> -->
<!--   <button id='do-toggle'>do-toggle</button> -->
<!--   <button id='do-toggle-2'>do-toggle-2</button> -->
<!--   <button id='do-untoggle'>do-untoggle</button> -->
<!--   </div> -->
  
</r3_lang:environment>        
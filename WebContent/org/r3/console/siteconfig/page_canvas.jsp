<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env" namespace='org.r3.console.siteconfig'>
<r3_lang:comment>
<%
    String myFile = "file.html";
 %>
<jsp:include page="<%=myFile%>" flush="true" />
</r3_lang:comment>

  
  <div id="siteDetailActionForm" class="actionForm" style="display:none"></div>
  <div id="uploadFileActionForm" class="actionForm" style="display:none"></div>
  
  <div id="homePortletCfgActionForm" class="actionForm" style='display: none'></div>
  <div id="sitePropertiesActionForm" class="actionForm" style='display: none'></div>
  
  <div id="classifierActionForm"            style='margin-bottom: 15px; margin-top: 20px; display: none'></div>
  
  <div id="classifierItemActionForm"  style='display: none'>
  <ul class="list-group">
    <li class="list-group-item">
  		<div id="classifierItemDetailActionForm"  ></div>
    </li>
    <li class="list-group-item">
  		<div id="classifierItemListActionForm"    ></div>
    </li>
  </ul>
  </div>
  
  <div id="calendarDetailActionForm" class="actionForm" ></div>
  <div id="calendarListActionForm" class="actionForm" ></div>
  
  
  <div id="wbsQueryActionForm" class="actionForm" style='display: none'></div>
  <div id="wbsActionForm"      class="actionForm" style='display: none'></div>
  
  
  <div id="pageQueryActionForm"       class="actionForm" style='display: none'></div>
  <div id="pageDetailActionForm"      class="actionForm" style='display: none'></div>
  
  <!-- CMS Console Canvas dependencies -->
  <div id="cardQueryActionForm"  class="actionForm" style="display:none"></div>
  <div id="cardDetailActionForm" class="actionForm" style="display:none"></div>
  <div id="uploadFileActionForm" class="actionForm" style="display:none"></div>
  <div id="cardQueryAdvancedSearchActionForm" class="advancedSearchActionForm"></div>
  
</r3_lang:environment>        
<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env" namespace='org.r3.console.resources'>
<r3_lang:comment>
<%
    String myFile = "file.html";
 %>
<jsp:include page="<%=myFile%>" flush="true" />
</r3_lang:comment>
  
  <div id="teamQueryActionForm"  class="actionForm"></div>
  <div id="teamDetailActionForm" class="actionForm" ></div>
    
  <div id="resourceQueryActionForm"  class="actionForm"></div>
  <div id="resourceDetailActionForm" class="actionForm" ></div>
  
  <div id="userPickerAdvancedSearchActionForm" class="advancedSearchActionForm" style="display:none"></div>
  <div id='userPickerActionForm' class='actionForm'></div>
  
  <div id="userDetailActionForm" class="actionForm" style="display:none"></div>
  <div id="siteRolesActionForm"  class="actionForm" style="display:none;"></div>
    
  <div id="teamMemberProfileDetailActionForm" class="actionForm" ></div>		
  <div id="teamMemberProfileQueryActionForm" class="actionForm" ></div> 
  
  <div id="teamtmesheetQueryActionForm"  class="actionForm"></div>

  <div id="teamtmesheetReportActionForm"  class="actionForm"></div>
  
  <div id="classifierActionForm" ></div>
  
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
      
<!--   <div style='padding-left: 500px'> -->
<!--   <button id='do-toggle'>do-toggle</button> -->
<!--   <button id='do-toggle-2'>do-toggle-2</button> -->
<!--   <button id='do-untoggle'>do-untoggle</button> -->
<!--   </div> -->
  
</r3_lang:environment>        
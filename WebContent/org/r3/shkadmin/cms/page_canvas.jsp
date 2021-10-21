<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env" namespace='org.r3.shkadmin.cms'>
<r3_lang:comment>
<%
    String myFile = "file.html";
 %>
<jsp:include page="<%=myFile%>" flush="true" />
</r3_lang:comment>


  <div id="cardQueryActionForm"  class="actionForm" style="display:none"></div>
  <div id="cardDetailActionForm" class="actionForm" style="display:none"></div>
  <div id="uploadFileActionForm" class="actionForm" style="display:none"></div>
  <div id="timelineQueryActionForm"  class="actionForm" style="display:none"></div>  
  <div id="timelineDetailActionForm"  class="actionForm" style="display:none"></div>  
  
  <div id="cardQueryAdvancedSearchActionForm" class="advancedSearchActionForm"></div>
  <div id="cardChannelQueryActionForm" class="actionForm" style="display:none"></div>
  
</r3_lang:environment>        


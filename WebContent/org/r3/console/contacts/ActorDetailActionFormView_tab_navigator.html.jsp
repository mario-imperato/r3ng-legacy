<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<%
   String mode = request.getParameter("mode");
   boolean isDetail = mode.equalsIgnoreCase("detail") && false;
   boolean isCreate = !isDetail;
%>

  
<!-- Nav tabs -->
 <ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#actorDetailActionFormView_tab_generale" role="tab" data-toggle="tab">{%=org.r3.console.contacts.message.actorDetailActionFormView_tab_generale_legend%}</a></li>
    <r3_lang:ifinclude include="<%=isDetail%>" >
    <li role="presentation"><a href="#actorDetailActionFormView_tab_siteresource" role="tab" data-toggle="tab">{%=org.r3.console.contacts.message.actorDetailActionFormView_tab_siteresource_legend%}</a></li>
    </r3_lang:ifinclude>
  </ul>

  <div class="tab-content" >
  <div id="actorDetailActionFormView_tab_generale"     class='tab-pane active tab-pane-framed' ></div>
  <!-- 
  <div id="actorDetailActionFormView_tab_siteresource" class='tab-pane tab-pane-framed' ></div>
   -->
   </div>
  
  

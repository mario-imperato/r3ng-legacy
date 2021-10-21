<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<%
   String mode = request.getParameter("mode");
   String traverseRelationship = request.getParameter("traverseRelationship"); 
   
   boolean isDetail = mode.equalsIgnoreCase("detail");
   boolean isTraverseRelationship = traverseRelationship.equalsIgnoreCase("true");   
   boolean isCreate = !isDetail;
%>

  
<!-- Nav tabs -->
 <ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#teamDetailActionFormView_tab_generale" role="tab" data-toggle="tab">{%=org.r3.jsportlet.project.team.message.teamDetailActionFormView_tab_generale_legend%}</a></li>
    <r3_lang:ifinclude include='<%=isDetail && isTraverseRelationship%>'>
    <li role="presentation" ><a href="#teamDetailActionFormView_tab_resources" role="tab" data-toggle="tab">{%=org.r3.jsportlet.project.team.message.teamDetailActionFormView_tab_resources_legend%}</a></li>
    </r3_lang:ifinclude>
  </ul>

  <div class="tab-content" >
  <div id="teamDetailActionFormView_tab_generale"     class='tab-pane active tab-pane-framed' ></div>
  
  <r3_lang:ifinclude include="<%=isDetail && isTraverseRelationship%>" >
  <div id="teamDetailActionFormView_tab_resources"        class='tab-pane tab-pane-framed' ></div>
  </r3_lang:ifinclude>
  </div>
  
  

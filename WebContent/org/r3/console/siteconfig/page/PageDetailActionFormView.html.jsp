<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<%
   String mode = request.getParameter("mode");
   boolean isDetail = mode.equalsIgnoreCase("detail");
   boolean isCreate = !isDetail;
%>

<div id="pageDetailActionFormTabs" >

<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#pageDetailActionForm_tab_generale" role="tab" data-toggle="tab">{%=org.r3.console.siteconfig.page.message.pageDetailActionForm_tab_generale%}</a></li>
    
  <r3_lang:ifinclude include="<%=isDetail%>" >       
    <li role="presentation" ><a href="#pageDetailActionForm_tab_pagetext" role="tab" data-toggle="tab">{%=org.r3.console.siteconfig.page.message.pageDetailActionForm_tab_pagetext%}</a></li>
    </r3_lang:ifinclude>
</ul>

<div class="tab-content" >  
  <div id="pageDetailActionForm_tab_generale"  class='tab-pane active tab-pane-framed'></div> 
  <r3_lang:ifinclude include="<%=isDetail%>" >   
  <div id="pageDetailActionForm_tab_pagetext"  class='tab-pane tab-pane-framed' ></div>  
  </r3_lang:ifinclude>
</div>  
  
</div>

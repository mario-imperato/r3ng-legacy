<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env">
 
<%
   org.r3.db.system.site.SiteDTO targetSite = r3Env.getRequestSite();
   String lyt = targetSite.getSitelayout();
   
   // Forzo ad un layout standard senza skins o altro.
   lyt = "shakeusblanklayout";
%>

<tiles:insert definition="<%=lyt%>" >
   
   <tiles:put  name="windowLayout_pageTitle" >Landing Page</tiles:put>
   <tiles:put  name="windowLayout_pagestyle" >
   <style>
   @import '<r3_lang:pathResolver path="/org/r3/home/shakeus/page_style.css" />'; 
   @import '<r3_lang:pathResolver path="/org/r3/jsportlet/mapexplore/mapexplorer.css" />'; 
   </style>     
   </tiles:put>
    
   <tiles:putList name="windowLayout_canvasList">
      <tiles:add value="/org/r3/home/shakeus/page_canvas.jsp" />      
   </tiles:putList>

   <tiles:putList name="windowLayout_scriptList">
      <tiles:add value="/org/r3/home/shakeus/page_script.jsp" />
   </tiles:putList>
   
                   
</tiles:insert>                                  

</r3_lang:environment>


<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env" namespace='org.r3.cms.grouppage1'>
 
<r3_lang:useBean id="pageDTO" scope="request"
                  name="org.r3.db.cms.pageview.PageViewDTO"
                  type="org.r3.db.cms.pageview.PageViewDTO" >
    <!--  CompanyDTO Not present -->                  
</r3_lang:useBean>
  
<%
   org.r3.db.system.site.SiteDTO targetSite = r3Env.getRequestSite();
   String lyt = targetSite.getSitelayout();

%>

<tiles:insert definition="<%=lyt%>" >
   
   <tiles:put  name="windowLayout_pageTitle" ><%=pageDTO.getPagetitle()%></tiles:put>
   <tiles:put  name="windowLayout_pagestyle" >
   <style>
   @import '<r3_lang:pathResolver path="/org/r3/cms/grouppage1/page_style.css" />'; 
   </style>       
   </tiles:put>
   
   <tiles:putList name="windowLayout_canvasList">
      <tiles:add value="/org/r3/cms/grouppage1/page_canvas.jsp" />
      
   </tiles:putList>

   <tiles:putList name="windowLayout_scriptList">
      <tiles:add value="/org/r3/cms/grouppage1/page_script.jsp" />
   </tiles:putList>
   
                   
</tiles:insert>                                  

</r3_lang:environment>


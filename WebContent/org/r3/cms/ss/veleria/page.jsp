<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env">
 
<tiles:insert definition="speedsails_windowLayout" >
   
   <tiles:put  name="windowLayout_pageTitle" >Veleria SpeedSails - La Veleria</tiles:put>
   <tiles:put  name="windowLayout_pagestyle" >
   <style>
   @import '<r3_lang:pathResolver path="/org/r3/cms/ss/veleria/page_style.css" />'; 
   </style>       
   </tiles:put>
   
   <tiles:putList name="windowLayout_canvasList">
      <tiles:add value="/org/r3/cms/ss/veleria/page_canvas.jsp" />
      
   </tiles:putList>

   <tiles:putList name="windowLayout_scriptList">
      <tiles:add value="/org/r3/cms/ss/veleria/page_script.jsp" />
   </tiles:putList>
   
                   
</tiles:insert>                                  

</r3_lang:environment>


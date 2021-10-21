<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env" namespace='org.r3.shkadmin.contacts'>
 
<%
   org.r3.db.system.site.SiteDTO targetSite = r3Env.getRequestSite();
   String lyt = "shkadminlayout";
%>

<tiles:insert definition="<%=lyt%>" >
   
   <tiles:put  name="windowLayout_pageTitle" >Contatti</tiles:put>
   <tiles:putList name="windowLayout_canvasList">
      <tiles:add value="/org/r3/shkadmin/contacts/page_canvas.jsp" />
   </tiles:putList>

   <tiles:putList name="windowLayout_scriptList">
      <tiles:add value="/org/r3/shkadmin/contacts/page_script.jsp" />
   </tiles:putList>   
                   
</tiles:insert>                                  

</r3_lang:environment>


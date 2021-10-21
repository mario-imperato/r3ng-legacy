<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env">
<r3_lang:comment>
<%
    String myFile = "file.html";
 %>
<jsp:include page="<%=myFile%>" flush="true" />
</r3_lang:comment>

 
     <div id="sailApplicationViewQueryActionFormView" class="actionForm" style="display: none"></div>  
 
</r3_lang:environment>        
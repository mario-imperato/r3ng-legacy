<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*,
    org.r3.db.system.site.SiteDTO
    " %>

<r3_lang:environment id="r3Env">

<%
  SiteDTO targetSite = r3Env.getRequestSite();
%>

<video autoplay  poster="/r3ng/org/r3/home/speedsails/poster.jpg" id="bgvid">
<source src="/video/speedsails/porti_imperiali.webm" type="video/webm">
<source src="/video/speedsails/porti_imperiali.mp4" type="video/mp4">
</video>
            
</r3_lang:environment>
<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
{%
 if (o.aaData && o.aaData.length)
 {
%}
<div class="featured_events_canvas" >
<ul class="list-unstyled">
{% for (var i=0; i < o.aaData.length; i++) { 
     var anEvent=o.aaData[i];
%}
 <li >
  <h2 class="eventName" ><a href="/r3ng/{%=anEvent.site%}/{%=org.r3.Constants.language%}/org/r3/home.do">{%=anEvent.sitedescr%}</a>
  </h2>
  <p>{%=anEvent.sitesummary%}</p>
  <div class='action-bar'><a href="/r3ng/{%=anEvent.site%}/{%=org.r3.Constants.language%}/org/r3/home.do">{%=org.r3.home.mastersite.message.user_site%}</a>&nbsp;|&nbsp;<a href="/r3ng/{%=anEvent.site%}/{%=org.r3.Constants.language%}/org/r3/console/home.do">{%=org.r3.home.mastersite.message.admin_console%}</a>
  </div>
 </li>
{%
 }
%}

</ul>
</div>
{%
 }
%}
        
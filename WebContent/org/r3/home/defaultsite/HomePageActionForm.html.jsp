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
<ul>
{% for (var i=0; i < o.aaData.length; i++) { 
     var anEvent=o.aaData[i];
%}
 <li >
  <h3 class="eventName" ><a href="/r3ng/{%=anEvent.site%}/it/org/r3/home.do">{%=anEvent.sitedescr%}</a></h3>
  <span>{%=anEvent.sitesummary%}</span>
 </li>
{%
 }
%}

</ul>
</div>
{%
 }
%}
        
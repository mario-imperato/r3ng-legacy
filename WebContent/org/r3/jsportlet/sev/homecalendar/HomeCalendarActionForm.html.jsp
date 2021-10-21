<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

{% if (o.calendarData && o.calendarData.length) { %}
<div class="box box-solid box-grade1">
  <div class="box-header with-border">
    <h3 class="box-title"><a href='sev/cmspage.do?pageid=tracker'>Date Importanti</a></h3>    
  </div>
  <div class="box-body">
 <table class='table'>
{% for ( var i = 0; i < o.calendarData.length; i++)
   {
	   var item = o.calendarData[i];
       %} <tr ><td >{%=item.dataBean.entrydescr%}</td><td style='text-align: right'><span style="color: #00aa00; ">{%=item.getStartdate()%}</span></td></tr> {%	    
   }
%}   
</table>
  </div>
</div>
{% } %}



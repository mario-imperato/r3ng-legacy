<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<div id='calendar_canvas'></div>
<form id="calendar_form">
   <input type='hidden' name='calendarid' id='calendar_form_calendarid' />
   <input type='hidden' name='allday' id='calendar_form_allday' />
   <input type='hidden' name='title' id='calendar_form_title' />
   <input type='hidden' name='startdate_date' id='calendar_form_startdate_date' />
   <input type='hidden' name='startdate_time' id='calendar_form_startdate_time' />
   <input type='hidden' name='enddate_date' id='calendar_form_enddate_date' />
   <input type='hidden' name='enddate_time' id='calendar_form_enddate_time' />   
</form>





   
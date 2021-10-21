<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    

{% if (o.buttons)  { %}
 <div class="action-bar position-top">
  {% for(var i = 0; i < o.buttons.length; i++) { %}
    <button type="button" class="btn btn-primary start" id="{%=o.buttons[i].id%}"{% if (o.buttons[i].disabled) { %} disabled {% } %} >
      <span>{%=o.buttons[i].label%}</span>
    </button>
    {% } %}
 </div>
{% } %}

 <table id="ResourceTimesheetReportViewQueryActionFormView" style='width: 100%' class="table table-striped table-bordered table-hover" >
        <tbody>
        </tbody>
 </table>

   



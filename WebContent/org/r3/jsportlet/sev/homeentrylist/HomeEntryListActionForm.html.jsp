<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<div class="box box-solid box-primary">
  <div class="box-header with-border">
    <h3 class="box-title">Lista Iscritti</h3>
    <div class="box-tools pull-right">
       <a href='javascript:void(0)' id="homeentrylistactionform_action_goto_entrylist"  class="btn btn-box-tool" title="Vai alla Pagina">
            <i class="fa fa-chevron-circle-right"></i>
       </a>            
    </div>
  </div>
  <div class="box-body">
  
{%  if (o.apps.getNumberOfItems() > 0) 
    {
       %} <table class='table'> {%
       var notAva = "Non inserito";
       var editable = false;    
       for (var i = 0; i < o.apps.getNumberOfItems(); i++) {  
           
           var theItem = o.apps.getItem(i); 
           if (theItem.dataBean.userid == o.userid)
               editable = false;
           %}

        <tr>
            <td style="width: 20%;" class="boatIcon-cell"> 
            {% if (theItem.hasBoatImage()) { %}         
               <div class="boatIcon"><a href='{%=theItem.getBoatImageUrl()%}' rel="lightbox-homeentrylist"><img src='{%=theItem.getBoatIconUrl()%}' border='0' style="margin-top: {%=theItem.getBoatIconMarginTop()%}px;" /></a></div>
            {% } else { %}
               <div class="boatIcon"><img src='{%=theItem.getBoatIconUrl()%}' border='0' style="margin-top: {%=theItem.getBoatIconMarginTop()%}px;" /></div>
            {% } %}               
            </td>
            <td style="width: 15%" >
              {% if (editable) { %} <a id="{%=theItem.dataBean.applicationid%}" class="homeentrylistactionform_action_editapp" href='javascript:void(0)'> {% } %}
              {%=theItem.dataBean.sailnumber || notAva%}
              {% if (editable) { %} </a> {% } %}
            </td>
            <td style="width: 30%" >
              {% if (editable) { %} <a id="{%=theItem.dataBean.applicationid%}" class="homeentrylistactionform_action_editapp" href='javascript:void(0)'> {% } %}
              {%=theItem.dataBean.yachtname || notAva%}
              {% if (editable) { %} </a> {% } %}
            </td>            
            <td style="width: 35%" >
              {% if (editable) { %} <a id="{%=theItem.dataBean.applicationid%}" class="homeentrylistactionform_action_editapp" href='javascript:void(0)'> {% } %}
              {%=theItem.dataBean.yachttype || notAva%}
              {% if (editable) { %} </a> {% } %}
            </td>
        </tr>
           
    {%  } %}
    
    </table>
        
  {% } else {
       %} Non sono presenti barche iscritte {%
    }
%}
  
  </div>
</div>




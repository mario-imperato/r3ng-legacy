<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>


{% if (!o.guest) {  %}

<div class="box box-solid box-grade6">
  <div class="box-header with-border">
    <h3 class="box-title">Le Mie Iscrizioni</h3>    
  </div>
  <div class="box-body">

{% 
   if (o.numberOfDraftApplications > 0 || o.numberOfCommitApplications > 0) 
   {  %}
<table class='table'>
{%  var notAva = "Non inserito";    
    for (var i = 0; i < o.apps.getNumberOfItems(); i++) 
    {  
      var theItem = o.apps.getItem(i);

      if (theItem.isEmpty())
         continue;

      if (o.apps.getNumberOfItems() > 2)
      { %}
        <tr>
            <td style="width: 15%" ><a id="{%=theItem.dataBean.applicationid%}" class="myappactionform_action_editapp" href='javascript:void(0)'>{%=theItem.dataBean.sailnumber || notAva%}</a></td>
            <td style="width: 40%" ><a id="{%=theItem.dataBean.applicationid%}" class="myappactionform_action_editapp" href='javascript:void(0)'>{%=theItem.dataBean.yachtname || notAva%}</a></td>            
            <td style="width: 40%" ><a id="{%=theItem.dataBean.applicationid%}" class="myappactionform_action_editapp" href='javascript:void(0)'>{%=theItem.dataBean.yachttype || notAva%}</a></td>
            <td style="width: 5%"  ><a id="{%=theItem.dataBean.applicationid%}" class="myappactionform_action_editapp" href='javascript:void(0)'>{%=theItem.getCompletionstatusText()%}</a></td>
        </tr>
   {% } else 
      { %}
        <tr>
            <td style="width: 20%;" class="boatIcon-cell">
              <div class="boatIcon"><a id="{%=theItem.dataBean.applicationid%}" class="myappactionform_action_editapp" href='javascript:void(0)'><img src='{%=theItem.getBoatIconUrl()%}' border='0' style="max-width: 100px; margin-top: {%=theItem.getBoatIconMarginTop()%}px;" /></a></div>
            </td>
            <td style="width: 15%; vertical-align: middle" ><a id="{%=theItem.dataBean.applicationid%}" class="myappactionform_action_editapp" href='javascript:void(0)'>{%=theItem.dataBean.sailnumber || notAva%}</a></td>
            <td style="width: 30%; vertical-align: middle" ><a id="{%=theItem.dataBean.applicationid%}" class="myappactionform_action_editapp" href='javascript:void(0)'>{%=theItem.dataBean.yachtname || notAva%}</a></td>            
            <td style="width: 30%; vertical-align: middle" ><a id="{%=theItem.dataBean.applicationid%}" class="myappactionform_action_editapp" href='javascript:void(0)'>{%=theItem.dataBean.yachttype || notAva%}</a></td>
            <td style="width: 5%;  vertical-align: middle" ><a id="{%=theItem.dataBean.applicationid%}" class="myappactionform_action_editapp" href='javascript:void(0)'>{%=theItem.getCompletionstatusText()%}</a></td>
        </tr>
   {% } %}
   
{% } %}
</table>
{% }  
   else { %}
 <p class="description">
  
  Per procedere con l'iscrizione attivare il pulsante successivo
   <!-- false && 
 <span style='color: #ff0000'>Le Nuove Iscrizioni Sono Bloccate Per Esaurimento Disponibilita'. Contattare la Segreteria per maggiori informazioni</span>
  -->
 </p>
{% } %}  

{% if (o.numberOfDraftApplications == 0) {  %}
    <div class="action-bar">
    {% if (o.emptyApplicationId) {  %}
        <button type="button" id="{%=o.emptyApplicationId%}" class='btn btn-default myappactionform_action_editapp'  >
          <span>Iscrivi una nuova barca</span>
        </button>       
    {% }
       else { %}
        <button type="button" id='myappactionform_action_newapp' class="btn btn-default" >
          <span>Iscrivi una nuova barca</span>
        </button>
    {% } %}                 
    </div>
{% } %}  

  </div> <!-- EOF Body -->
</div>

{%    } %}


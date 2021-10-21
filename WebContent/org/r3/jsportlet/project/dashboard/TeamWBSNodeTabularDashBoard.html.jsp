<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
{%
    var tableTotals = { previsionalEffort: 0, actualEffort: 0 };
 %}
     
<table class="table table-bordered table-hover table-striped">
  
  <thead>
  <tr>
  <th>&nbsp;</th>
  <th class='text-center'>&nbsp;</th>
  {% for(var i = 0; i < o.model.columns.length; i++) { %}
     <th class='text-center'>{%=o.model.columns[i].colInfo%}</th>
  {% } %}
  </tr>
  </thead>
  
  <tbody>
  {% for(var i = 0; i < o.model.rows.length; i++) {  
        tableTotals.previsionalEffort += o.model.rows[i].previsionalEffort;
        tableTotals.actualEffort += o.model.rows[i].actualEffort;
  %}
     <tr>
     	<td >{%=o.model.rows[i].rowInfo.getProfiledescr()%}</td>
     	<td class='text-center'>{%=o.model.rows[i].previsionalEffort || '0'%} / {%=o.model.rows[i].actualEffort || '-'%}</td>
	  {% for(var j = 0; j < o.model.columns.length; j++) { %}
     	<td class='text-center'>{%=o.model.rows[i].cellInfo[j].previsionalEffort || '0'%} / {%=o.model.rows[i].cellInfo[j].actualEffort || '-'%}</td>
  	  {% } %}
     
     </tr>     
  {% } %}
  
  </tbody>

 <tfoot>
  <tr>
  <th>&nbsp;</th>
  <th class='text-center'>{%=tableTotals.previsionalEffort || '0'%} / {%=tableTotals.actualEffort || '-'%}</th>
  {% for(var i = 0; i < o.model.columns.length; i++) { %}
     <th class='text-center'>{%=o.model.columns[i].previsionalEffort%} / {%=o.model.columns[i].actualEffort  || '-' %}</th>
  {% } %}
  </tr>
  </tfoot>
  
</table>



         
  
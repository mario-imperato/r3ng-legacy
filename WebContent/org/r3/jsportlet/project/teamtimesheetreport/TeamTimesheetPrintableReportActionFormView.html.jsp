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
 

<div class="timesheet-report">

<div class="box box-default">
  <div class="box-header with-border">
    <h3 class="box-title">Parametri di ricerca.</h3>
    <div class="box-tools pull-right">
      <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
    </div>
  </div>
  
  <div class="box-body">

{% if (o.queryParams && o.queryParams.length) 
   {     
      var paramsHash = {};
      
      for(var j = 0; j < o.queryParams.length; j++) 
      {
         var p = o.queryParams[j];
         paramsHash[p.name] = p.text;
      }   
   
 %}
     
   <div class='row'>
   <div class='col-md-4 col-xs-4'>
   <div class="form-group">
    <label>{%=org.r3.jsportlet.project.teamtimesheet.message.resourcedescr%}</label>
    <p class="form-control">{%=paramsHash['resourceid']%}</p>
   </div>
       
   <div class="form-group">
    <label>{%=org.r3.db.project.teamresourceview.message.profileid%}</label>
    <p class="form-control">{%=paramsHash['profileid']%}</p>
   </div>
   </div>
   <div class='col-md-4 col-xs-4'>
   <div class="form-group">
    <label>Periodo (da)</label>
    <p class="form-control">{%=paramsHash['periodindexfrom']%}</p>
   </div>
   
   <div class="form-group">
    <label>(a)</label>
    <p class="form-control">{%=paramsHash['periodindexto']%}</p>
   </div>
   </div>
   <div class='col-md-4 col-xs-4'>
   <div class="form-group">
    <label>Raggruppa Per</label>
    <p class="form-control">{%=paramsHash['groupby']%}</p>
   </div>
   </div>   
   </div>

{% } 
   else { %}
   
   <p>Non sono indicati filtri</p>
   
{% }  %}
   

  </div>
</div>

{% if (o.dtoTableAdapter && o.dtoTableAdapter.getNumberOfItems()) {  

      var columnIds = o.columns.split(",");
%}

 <table style='width: 100%' class="table table-striped table-bordered dt-responsive table-hover" >
  <thead>
  <tr>
  {% for(var colNdx = 0; colNdx < columnIds.length; colNdx++) {  %}  
  <th class='{%=o.columnDefinitions[columnIds[colNdx]].sClass%}'>{%=o.columnDefinitions[columnIds[colNdx]].sTitle%}</th>  
  {% }  %}  
  </tr>
  </thead>
  <tbody>
  {% for(var i = 0; i < o.dtoTableAdapter.getNumberOfItems(); i++) 
     { 
       var item = o.dtoTableAdapter.getItem(i);
   %}
  <tr>
  {% for(var colNdx = 0; colNdx < columnIds.length; colNdx++) {  %}  
  <td class='{%=o.columnDefinitions[columnIds[colNdx]].sClass%}'>{%=o.columnDefinitions[columnIds[colNdx]].render(item)%}</td>  
  {% }  %}  
  </tr>
  {% } %}
  </tbody>
 </table>
 
{% } %}

</div>

</r3_lang:environment>
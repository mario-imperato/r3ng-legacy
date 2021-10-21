<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
<div class="panel panel-light">
  <div class="panel-heading clearfix" >  
    <h3 class="panel-title" style='line-height: 2em'>Report Consuntivazione</span>
    </h3>
  </div>
  
  <div class="panel-body">
 
  <div class="panel ">
  <div class="panel-body ">
  <div id="teamtimesheetreportform_fieldset_message" ></div>
  
  <form id="teamtimesheetreportform_form" method="POST" >
   
   <div class='row'>
   <div class='col-md-4'>
   <div class="form-group">
    <label>{%=org.r3.jsportlet.project.teamtimesheet.message.resourcedescr%}</label>
    <select class="form-control"  name="resourceid" id="teamtimesheetreportform_resourceid" ></select>
   </div>
       
   <div class="form-group">
    <label>{%=org.r3.db.project.teamresourceview.message.profileid%}</label>
    <select class="form-control"  name="profileid" id="teamtimesheetreportform_profileid" ></select>
   </div>
   </div>
   <div class='col-md-4'>
   <div class="form-group">
    <label>Periodo (da)</label>
    <select class="form-control"  name="periodindexfrom" id="teamtimesheetreportform_periodindexfrom" ></select>
   </div>
   
   <div class="form-group">
    <label>(a)</label>
    <select class="form-control"  name="periodindexto" id="teamtimesheetreportform_periodindexto" ></select>
   </div>
   </div>
   <div class='col-md-4'>
   <div class="form-group">
    <label>Raggruppa Per</label>
    <div>
    <select class="form-control"  name="groupby" id="teamtimesheetreportform_groupby" multiple>
    
    <option value="caleveyear">Anno</option>
    <option value="calevequarter">Trimestre</option>
    <option value="calevemonth">Mese</option>
        
    <option value="resourceid">Risorsa</option>
    <option value="resourcedescr">Nominativo</option>
    
    <option value="teamid">Id. Team</option>
    <option value="profileid">Profilo Professionale</option>
    
    <option value="site">Sito</option>
    <option value="companyid">Fornitore</option>
    
    <option value="costcenter1">Centro di costo 3o Liv.</option>
    <option value="costcenter2">Centro di costo 4o Liv.</option>
    <option value="costcenter3">Centro di costo 5o Liv.</option>
        
    </select>
    </div>
   </div>
   
   </div>   
   </div>
      
  </form>
  
  <div class="form-action-bar">
		
        <button type="button" id="teamtimesheetreportform_action_query" class="btn btn-default" >
          <span>Ricerca</span>
        </button>

        <button type="button" id="teamtimesheetreportform_action_clear" class="btn btn-default" >
          <span>Pulisci</span>
        </button>            
   </div>
      
  </div>
</div>

<div id='teamTimesheetReportDatatableActionForm'></div>
 
</div>
</div>

   



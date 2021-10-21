<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
<div class="panel panel-light">
  <div class="panel-heading clearfix" >  
    <h3 class="panel-title" style='line-height: 2em'>Giorno di consuntivazione: <span id='teamtimesheetform_timesheetday_descr'></span>
    
  <div style='text-align: right; float: right'>   
  <button type="button" id='teamwf_action_oncomplete_ok' class="btn btn-primary teamwf_action" style='display: none'>On_Complete_OK</button>      
  <button type="button" id='teamwf_action_oncomplete_ko'   class="btn btn-warning teamwf_action" style='display: none'>On_Complete_KO</button>    
  </div>
    </h3>
  </div>
  
  <div class="panel-body">
 
  <div class="panel ">
  <div class="panel-body ">
  
  <form id="teamtimesheetform_form" method="POST" class='form-horizontal'>
  <input type='hidden' name="teamid"       id="teamtimesheetform_teamid" />
  <input type='hidden' name="timesheetday" id="teamtimesheetform_timesheetday" />
   
  <div class='row'>
  <div class='col-md-4'>
  
  <div id="datepicker" class='r3_datepicker datepicker-framed' ></div>
           
  </div>
  
  <div class='col-md-8'>
  
   <div id="teamtimesheet_fieldset_message" ></div>
   
   <div class="form-group">
    <label class="col-md-2 control-label fieldRequired">{%=org.r3.jsportlet.project.teamtimesheet.message.resourcedescr%}</label>
    <div class='col-md-10'>
    <select class="form-control"  name="resourceid" id="teamtimesheetform_resourceid" ></select>
    </div>
   </div>

   <div class="form-group">
    <label class="col-md-2 control-label fieldRequired">&nbsp;</label>
    <div class='col-md-10'>
    <div style='float: left; width: 100px; margin: 0 10px'>
    <div style='text-align: center; font-size: 1.2em; margin-bottom: 5px;'>T.Ord: <span id="teamtimesheetform_ordeffort_klabel">0</span></div>
    <input type="text" class='knob-dial' name="ordeffort"  id="teamtimesheetform_ordeffort" value='0'   data-width="100" data-height="100" >
    </div>
   
  <div style='float: left; width: 100px; margin: 0 10px'>
    <div style='text-align: center; font-size: 1.2em; margin-bottom: 5px;'>T.Straord: <span id="teamtimesheetform_exteffort_klabel">0</span></div>
    <input type="text" class='knob-dial' name="exteffort" id="teamtimesheetform_exteffort" value='0' data-fgColor="#515175"  data-width="100" data-height="100" >
    </div>
   
   <div style='float: left; width: 100px; margin: 0 10px'>
    <div style='text-align: center; font-size: 1.2em; margin-bottom: 5px;'>T.Reperib: <span id="teamtimesheetform_oncalleffort_klabel">0</span></div>
    <input type="text" class='knob-dial' name="oncalleffort" id="teamtimesheetform_oncalleffort" value='0' data-fgColor="#f39c12"  data-width="100" data-height="100" >
   </div>
    
    </div>
    </div>
  </div>
        
  </div>
       
  </form>
  
  <div class="form-action-bar">
		
        <button type="button" id="teamtimesheetform_action_save" class="btn btn-default" >
          <span>Salva</span>
        </button>

        <button type="button" id="teamtimesheetform_action_clear" class="btn btn-default" >
          <span>Pulisci</span>
        </button>            
   </div>
      
  </div>
</div>

{% if (o.buttons)  { %}
 <div class="action-bar position-top">
  {% for(var i = 0; i < o.buttons.length; i++) { %}
    <button type="button" class="btn btn-primary start" id="{%=o.buttons[i].id%}"{% if (o.buttons[i].disabled) { %} disabled {% } %} >
      <span>{%=o.buttons[i].label%}</span>
    </button>
    {% } %}
 </div>
 {% } %}
 
 <table id="ResourceTimesheetViewQueryActionFormView" style='width: 100%' class="table table-striped table-bordered table-hover {%=o.gradeLevel%}" >
        <tbody>
        </tbody>
 </table>

</div>
</div>

   



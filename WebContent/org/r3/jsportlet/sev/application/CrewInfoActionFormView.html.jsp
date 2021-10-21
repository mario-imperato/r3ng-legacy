<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>


  <ul class="list-group">
  <li class="list-group-item">
  <h4 style='margin-bottom: 15px'><span id="crewinfoform_applicationid">&nbsp;</span> - Equipaggio</h4>
  
  <div id="crewinfoform_fieldset_message" ></div>
  
  <form id="crewinfoform_form" method="POST" class="form-horizontal">
  <input type="hidden" id="crewinfoform_crewmemberid" name="crewmemberid" />
  <input type="hidden" id="crewinfoform_crewcovidurl" name="crewcovidurl" />
  
  <div class='row'>
  <div class='col-md-7'>
  
  <div class="form-group">
    <label class="col-sm-4 control-label fieldRequired">No. tessera FIV</label>
    <div class='col-sm-8'>
    <input type="text" class="form-control"  name="crewcardnumber" id="crewinfoform_crewcardnumber" maxlength="8"  />
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-4 control-label fieldRequired">Nominativo</label>
    <div class='col-sm-8'>
    <input type="text"  class="form-control" name="crewmembername" id="crewinfoform_crewmembername" maxlength="80"  />
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-4  control-label fieldRequired">Certificazione COVID</label>
    <label class="col-sm-8  control-label fieldLink" style='text-align: left' id="crewinfoform_crewcovidurl_link" style='overflow: hidden'>&nbsp;</label>
  </div>
    
  </div>
  
  <div class='col-md-5'>
  
  <div class="form-group">
    <label class="col-sm-4 control-label fieldRequired">Titolare / Riserva</label>
    <div class='col-sm-8'>
    <select class="form-control" name="memberstatus" id="crewinfoform_memberstatus" ></select>
    </div>
  </div>
      
  <div class="form-group">
    <label class="col-sm-4 control-label fieldRequired">Ruolo a bordo</label>
    <div class='col-sm-8'>
    <select class="form-control" name="crewmemberrole" id="crewinfoform_crewmemberrole" ></select>
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-4 control-label fieldRequired">Peso (solo per ORC)</label>
    <div class='col-sm-8'>
    <input type="text" class="form-control"  name="crewweight" id="crewinfoform_crewweight" maxlength="10"  />
    </div>
  </div>
  </div>
  </div>
   <div class="form-action-bar">
                
        <button type="button" id="crewinfoform_action_uloadinfo" class="btn btn-default">
          <span>Carica Certificazione COVID</span>
        </button>

        <button type="button" id="crewinfoform_action_save" class="btn btn-default">
          <span>Salva</span>
        </button>

        <button type="button" id="crewinfoform_action_clear" class="btn btn-default">
          <span>Pulisci</span>
        </button>
        
   </div>   
   
   
  
   </form>
  </li>

  <li class="list-group-item">
  <h4 style='margin-bottom: 15px'>Lista Equipaggio</h4>
  
  <div class="row">
  <div class='col-md-10'>
  <table id="SailApplicationCrewMemberQueryActionFormView" class="table table-striped table-bordered table-hover grade_level1" >
        <tbody>
        </tbody>
  </table>
  </div>
  
  <div class='col-md-2'>
    {% for(var i = 0; i < o.buttons.length; i++) { %}
    <button type="button" class="btn btn-primary start btn-block" id="{%=o.buttons[i].id%}"{% if (o.buttons[i].disabled) { %} disabled {% } %} >
      <span>{%=o.buttons[i].label%}</span>
    </button>
    {% } %}
  </div>
  
  </div>
        
  </li>
  
  </ul>
    
  <div class="action-bar">
        <button type="button" id="crewinfoform_action_prev" class="btn btn-default" >
          <span>Precedente</span>
        </button>

        <button type="button" id="crewinfoform_action_next" class="btn btn-default" >
          <span>Successivo</span>
        </button>
            
   </div>




   
<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.io.*,
    java.util.*
    "%>


<div class="panel tabbed-panel">
  <div class="panel-heading">
    <h3 class="panel-title">{%=o.legend%}</h3>
  </div>
  <div class="panel-body">
    
      {% if (o.getActionBarPosition() == 'top') { %} 
            
      <div class="action-bar position-top">
      {% 
         for(var i = 0; i < o.buttons.length; i++)
         {      
      %}      
         <button type="button" class="btn btn-primary start" id="{%=o.buttons[i].id%}"  {% if (o.buttons[i].disabled) { %} disabled {% } %} >         
         <span>{%=o.buttons[i].label%}</span>
         </button>
      {% 
         }      
      %}      
      </div>            

    <div class="panel" id="adminapp_submitcrewcheckform_actionform" style='display: none'>
    <div class="panel-body" >
    <p>Per richiedere il controllo delle tessere e' necessario indicare il codice FIV del Circolo e la corrispondente parola chiave.</p>
    <div id="adminapp_submitcrewcheckform_fieldset_message" ></div>
    <form id="adminapp_submitcrewcheckform_form" method="POST" class='form-horizontal'>
    
 <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >&nbsp;</label>
     <div class="col-md-10 columns" >
         <label class='checkbox-inline'>
             <input id="adminapp_submitcrewcheckform_entirefleet_btrue" type="checkbox" value="btrue" name="entirefleet" >Richiedi il controllo per tutta la flotta             
          </label>     
     </div>
</div> 
    
 <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >Id Accesso Sito FIV</label>
     <div class="col-md-10" >
          <input type="text" class='form-control' name="yachtclubcode" id="adminapp_submitcrewcheckform_yachtclubcode" maxlength="15" />        
     </div>
 </div>
 
  <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >Parola chiave sito FIV</label>
     <div class="col-md-10" >
          <input type="password" class='form-control' name="yachtclubpwd" id="adminapp_submitcrewcheckform_yachtclubpwd" maxlength="15" />        
     </div>
 </div>
 
  <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >Conf. Parola chiave</label>
     <div class="col-md-10" >
          <input type="password" class='form-control' name="confirm_yachtclubpwd" id="adminapp_submitcrewcheckform_confirm_yachtclubpwd" maxlength="15" />        
     </div>
 </div>      
            
    </form>
    
     <div class="form-action-bar">
        <button type="button" id="adminapp_submitcrewcheckform_action_submit" class="btn btn-default" style="margin-top: 5px">
          <span>Conferma Richiesta</span>
        </button>
        
        <button type="button" id="adminapp_submitcrewcheckform_action_cancelsubmit" class="btn btn-default" style="margin-top: 5px">
          <span>Chiudi</span>
        </button>
    </div>
    </div>
     </div>

                  
      {% } %}

      {% if (o.getActionBarPosition() == 'right') { %}      
      <div class='row'>
      <div class='col-md-10'>       
      {% } %}
          
      <div class="dataTables_wrapper">      
      {% if (o.isSearchEnabled()) { %}      
      <div id="{%=o.dataTableId%}_filter" class="dataTables_filter">
      
      <a class="{%=o.dataTableId%}_filter_search" href="javascript:void(0)" >{%=o.getSearchLabel()%}</a>
      {% if (o.isAdvancedSearchEnabled()) { 
            for(var i = 0; i < o.getNumberOfAdvancedSearchOptions(); i++)
            {
      %}
      &nbsp;|&nbsp;<a href="javascript:void(0)" id="{%=o.dataTableId%}_filter_advsearch_{%=i+''%}" class="{%=o.dataTableId%}_filter_advsearch">{%=o.getAdvancedSearchLabel(i)%}</a>      
      {% }} %}
      <span class="search_icon {%=o.dataTableId%}_filter_search" ></span>
      <form id="{%=o.dataTableId%}_filter_searchform">
      {% if (o.isSearchWidgetSelect()) { %}

          <select name="filter_item" class='form-control' style='display: inline-block; width: 50%' id="{%=o.dataTableId%}_filter_searchitem" >
          </select>
                   
      {% } 
         else { %}
          <input type="text" name="filter_item" id="{%=o.dataTableId%}_filter_searchitem" class='form-control' style='display: inline-block; width: 50%'>
      {% } %}
      </form>
      
      </div>
      {% } %}	
                        
      <form id="{%=o.dataTableId%}_tableform">
      <table id="{%=o.dataTableId%}" style='width: 100%' class="table table-striped table-bordered table-hover {%=o.gradeLevel%}" >
        <tbody>
        </tbody>
      </table>
      </form>
      
      </div>
      
      {% if (o.getActionBarPosition() == 'right') { %}      
      </div>
      <div class='col-md-2'>
      {% for(var i = 0; i < o.buttons.length; i++) { %}
        <button type="button" class="btn btn-primary start btn-block" id="{%=o.buttons[i].id%}"{% if (o.buttons[i].disabled) { %} disabled {% } %} >
          <span>{%=o.buttons[i].label%}</span>
        </button>
      {% } %}      
      </div>
      </div>             
      {% } %}
                         
  </div>
</div>
    


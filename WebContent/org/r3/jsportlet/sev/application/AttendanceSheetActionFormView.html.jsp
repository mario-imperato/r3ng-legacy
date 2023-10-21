<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>


<div id="attendancesheetform_fieldset_message" ></div>
<form id="attendancesheetform_form" method="POST" class="form-horizontal">
  <input type='hidden' name='attendancesheetactiveitem' id='attendancesheetform_active_item' value="{%=o.activeItemKey%}" />
  <ul class="list-group">
  <li class="list-group-item">
  <h4 style='margin-bottom: 15px'><span id="attendancesheetform_applicationid">&nbsp;</span> - Foglio Presenze</h4>
  
{% 
   for(var i = 0; i < o.widgets.length; i++)
   {
      var wInfo = o.widgets[i]; 
%}
  <div class="form-group">
    <label class="col-sm-4 control-label">Regata del {%=wInfo.label%}<!-- <a id="attendancesheetform_{%=wInfo.cardid%}" 
           class="attendancesheetform_authcard_link" href="#attendancesheetform_authcard_anchor">Leggi il testo</a> --></label>
    <div class='col-sm-8 columns' id="attendancesheetform_{%=wInfo.id%}_cnt">
    <label class="checkbox-inline" style="width: 220px; ">
             <input  type="checkbox" value="btrue" id="prop_{%=wInfo.id%}_attendanceyes" name="prop_{%=wInfo.id%}_attendanceyes" {%=wInfo.attendanceyes%} {%=wInfo.disabled%}>La barca partecipa alla regata</label>
             
    <label class="checkbox-inline" style="width: 220px; ">
             <input  type="checkbox" value="btrue" id="prop_{%=wInfo.id%}_crewregular" name="prop_{%=wInfo.id%}_crewregular" {%=wInfo.crewregular%} {%=wInfo.disabled%}>L'equipaggio a bordo e' in regola con il tesseramento e con quanto dichiarato nella lista equipaggio</label>             
             
    </div>
  </div>
{% } %}

  </li>
  
  <li class="list-group-item">
    <a name='#attendancesheetform_authcard_anchor' />
    <div id="attendancesheetform_authcard"></div>
  </li>
  </ul>
  
  <div class="form-action-bar">
        
         <button type="button" id="attendancesheetform_action_prev" class="btn btn-default">
          <span>Precedente</span>
        </button>

        <button type="button" id="attendancesheetform_action_next" class="btn btn-default">
          <span>Successivo</span>
        </button>
        
   </div>     
   
</form>



   
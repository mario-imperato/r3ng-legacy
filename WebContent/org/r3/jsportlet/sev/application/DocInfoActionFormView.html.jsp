<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

  
<form id="docinfoform_form" method="POST">

<ul class="list-group">
  <li class="list-group-item">
  <h4 style='margin-bottom: 15px'>Lista Documenti</h4>
  
  <div class="row">
  <div class='col-md-10'>
  <table id="SailApplicationDocumentQueryActionFormView" class="table table-striped table-bordered table-hover grade_level1" >
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

  <div class="form-action-bar">
        
         <button type="button" id="docinfoform_action_prev" class="btn btn-default">
          <span>Precedente</span>
        </button>

        <button type="button" id="docinfoform_action_next" class="btn btn-default">
          <span>Successivo</span>
        </button>
        
   </div>     
        
</form>
   





   
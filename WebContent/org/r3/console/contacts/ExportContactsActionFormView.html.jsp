<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
<div class="panel panel-default">
  <div class="panel-heading" style='background: white'>  
    <h3 class="panel-title" >{%=org.r3.console.contacts.message.exportcontactsactionform_form_legend%}</h3>
  </div>
  
  <div class="panel-body">
  
  <div id="exportcontactsactionform_fieldset_message" ></div>
  <form id="exportcontactsactionform_form" method="POST" class='form-horizontal'>
  

      
  <div class="form-group">
    <label class="col-md-2 control-label fieldRequired ">{%=org.r3.console.contacts.message.exportcontactsactionform_csvformat%}</label>
    <div class='col-md-10'>    
    <select class="form-control" name='csvformat' id='exportcontactsactionform_csvformat'></select>
    </div>
  </div>
  
  <div class="form-group" >
    <label class="col-md-2 control-label ">{%=org.r3.console.contacts.message.exportcontactsactionform_limit2groups%}</label>
    <div class='col-md-10'>    
     <select name='groupid'  id='exportcontactsactionform_groupid' multiple='multiple'></select>
    </div>
  </div>
 
       
  </form>
  
  <div class="form-action-bar">
        <button type="button" id="exportcontactsactionform_action_export" class="btn btn-default" >
          <span>{%=org.r3.message.action_export%}</span>
        </button>                 
   </div> 
   
  </div>
</div>


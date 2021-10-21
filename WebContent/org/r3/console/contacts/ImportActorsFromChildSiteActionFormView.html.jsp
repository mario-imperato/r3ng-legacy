<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<div class="panel panel-default">
  <div class="panel-heading" style='background: white'>  
    <h3 class="panel-title" >{%=org.r3.console.contacts.message.importactorgroupfromchildsiteactionform_form_legend%}</h3>
  </div>
  
  <div class="panel-body">
  
  <div id="importactorgroupfromchildsiteactionform_fieldset_message" ></div>
  <form id="importactorgroupfromchildsiteactionform_form" method="POST" class='form-horizontal'>
  

  <div id="importactorgroupfromchildsiteactionform_cascade">
  <div class="form-group">
    <label class="col-md-2 control-label fieldRequired">{%=org.r3.console.contacts.message.importactorgroupfromchildsiteactionform_sourcesite%}</label>
    <div class='col-md-10'>    
    <select name="sourcesite" class="form-control" id="importactorgroupfromchildsiteactionform_sourcesite" ></select>    
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-md-2 control-label ">{%=org.r3.console.contacts.message.importactorgroupfromchildsiteactionform_sourcegroup%}</label>
    <div class='col-md-10'>    
     <select name="sourcegroup" class="form-control" id="importactorgroupfromchildsiteactionform_sourcegroup" ></select>  
    </div>
  </div>  
  </div>
  
  <div class="form-group" >
    <label class="col-md-2 control-label ">{%=org.r3.console.contacts.message.importactorgroupfromchildsiteactionform_actorgroup%}</label>
    <div class='col-md-10'>    
    <select name="actorgroup" class="form-control" id="importactorgroupfromchildsiteactionform_actorgroup" ></select>
    </div>
  </div>
 
       
  </form>
  
  <div class="form-action-bar">
        <button type="button" id="importactorgroupfromchildsiteactionform_action_import" class="btn btn-default" >
          <span>{%=org.r3.message.action_save%}</span>
        </button>                 
   </div> 
   
  </div>
</div>


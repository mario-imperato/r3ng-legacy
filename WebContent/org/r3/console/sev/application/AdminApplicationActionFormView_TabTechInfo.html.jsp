<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.io.*,
    java.util.*
    "%>

<div class="panel tabbed-panel">
  <div class="panel-heading" >  
    <h3 class="panel-title" >Info raggruppamento, BSF ...</h3>
  </div>
  
  <div class="panel-body">
  <div id="adminraceinfoapplicationactionform_fieldset_message"></div>
  <form id="adminraceinfoapplicationactionform_form" method="POST" class='form-horizontal form-medium'>
  
  <div id="adminapplicationactionform_adminracegrooup_cascade">
 <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >Raggruppamento</label>
     <div class="col-md-10" >
            <select name="adminracegroup" class='form-control' id="adminapplicationactionform_adminracegroup" ></select>        
     </div>
 </div>
 
  <div class="form-group">
     <label class="col-md-2 control-label "  >Classe</label>
     <div class="col-md-10" >
            <select name="adminraceclass" class='form-control'  id="adminapplicationactionform_adminraceclass" ></select>        
     </div>
 </div>  
  </div>
  
 <div class="form-group">
     <label class="col-md-2 control-label "  >BSF</label>
     <div class="col-md-10" >
            <input type="text" name="yachtbsf" class='form-control' id="adminapplicationactionform_yachtbsf" maxlength="10"  />        
     </div>
 </div>
 
  <div class="form-group">
     <label class="col-md-2 control-label "  >GPH</label>
     <div class="col-md-10" >
            <input type="text" name="yachtgph" class='form-control' id="adminapplicationactionform_yachtgph" maxlength="10"  />               
     </div>
 </div>
   
  </form>
  
  <div class="form-action-bar">
    <button type="button" id="adminapplicationactionform_action_saveadminraceinfo" class="btn btn-default" >
      <span>Salva</span>
    </button>
  </div>

  
  </div>
</div>



  
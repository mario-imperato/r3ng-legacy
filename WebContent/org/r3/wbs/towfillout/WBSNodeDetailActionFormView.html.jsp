<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>


<div class="panel panel-default">
  <div class="panel-heading" style='background: white'>  
    <h3 class="panel-title" id="wbsnodeactionform_nodename">{%#org.r3.wbs.towfillout.message.wbsnodeactionform_nodename%}</h3>
  </div>
  <div class="panel-body">

  <div id="wbsnodeactionform_fieldset_message" ></div>

  <form id="wbsnodeactionform_form" method="POST" class="form-horizontal">          
  <input type='hidden' name='tsentryid' id='wbsnodeactionform_form_tsentryid' />
  
 <div class="row">
 <div class="col-md-6">
 <div class="form-group">
     <label class="col-md-4 control-label fieldRequired"  >{%#org.r3.db.project.resourcetimesheet.message.resourceid%}</label>
     <div class="col-md-8" >
          <select name="resourceid" class='form-control' id="wbsnodeactionform_form_resourceid" ></select>        
     </div>
 </div>

 <div class="form-group">
     <label class="col-md-4 control-label fieldRequired"  >{%#org.r3.db.project.resourcetimesheet.message.effort%}</label>
     <div class="col-md-8" >
          <input name="effort" class='form-control' id="wbsnodeactionform_form_effort" type="text" />        
     </div>
 </div>
 </div>
 <div class="col-md-6">
 <div class="form-group">
     <label class="col-md-4 control-label fieldRequired"  >{%#org.r3.db.project.resourcetimesheet.message.startperiod%}</label>
     <div class="col-md-8" >
          <input name="startperiod" class='form-control r3_datepicker' id="wbsnodeactionform_form_startperiod" type="text" />        
     </div>
 </div>

 <div class="form-group">
     <label class="col-md-4 control-label fieldRequired"  >{%#org.r3.db.project.resourcetimesheet.message.endperiod%}</label>
     <div class="col-md-8" >
          <input name="endperiod" class='form-control r3_datepicker' id="wbsnodeactionform_form_endperiod" type="text" />        
     </div>
 </div>
 </div>
 </div>
 
 
<!--   <div class="form-group"> -->
<!--     <label class="col-md-4  control-label  fieldRequired">{%#org.r3.db.project.resourcetimesheet.message.startperiod%}</label> -->
<!--     <div class="col-md-8"> -->
<!--        <div class="input-daterange input-group r3_datepicker validation-error-anchor">     -->
<!--        <input type="text" class="input-sm form-control" name="startperiod" id="wbsnodeactionform_form_startperiod"  /> -->
<!--        <span class="input-group-addon">{%#org.r3.db.project.resourcetimesheet.message.endperiod%}</span> -->
<!--        <input type="text" class="input-sm form-control" name="endperiod" id="wbsnodeactionform_form_endperiod" /> -->
<!--        </div> -->
<!--     </div> -->
<!--     </div> -->
    
 
      
  <div class="form-action-bar">
        <button type="button" id="wbsnodeactionform_action_saveitem" class="btn btn-default" >
          <span>{%#org.r3.message.action_save%}</span>
        </button>
        
        <button type="button" id="wbsnodeactionform_action_cancel" class="btn btn-default" >
          <span>{%#org.r3.message.action_cancel%}</span>
        </button>
   </div> 
   
  </form>
  
  </div>
</div>


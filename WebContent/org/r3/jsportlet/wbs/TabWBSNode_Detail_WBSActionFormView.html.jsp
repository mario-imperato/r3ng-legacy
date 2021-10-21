<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.io.*,
    java.util.*
    "%>


<div class="panel ">
  <div class="panel-heading" >  
    <h3 class="panel-title" >{%=org.r3.jsportlet.wbs.message.wbsnodeactionform_form_legend_title%}</h3>
  </div>
  
  <div class="panel-body">
  <div id="wbsnodeactionform_fieldset_message" ></div>
  <form id="wbsnodeactionform_form" method="POST" class='form-horizontal'>

  <div class='row'>
  
  <div class='col-md-6'>
 <div class="form-group">
     <label class="col-md-4 control-label fieldRequired"  >{%#org.r3.db.wbs.wbsnode.message.nodetype%}</label>
     <div class="col-md-8" >
          <select name="nodetype" class='form-control' id="wbsnodeactionform_nodetype" >
          <option value="node">Nessuno</option>
          <option value="action">Azione</option>
          </select>                  
     </div>
 </div>  
 
 <div class="form-group">
     <label class="col-md-4 control-label fieldRequired"  >{%#org.r3.db.wbs.wbsnode.message.stereotype%}</label>
     <div class="col-md-8" >
          <select name="stereotype" class='form-control' id="wbsnodeactionform_stereotype" >
          <option value="stynone">Generico</option>
          </select>         
     </div>
 </div>
 
  <div class="form-group">
     <label class="col-md-4 control-label fieldRequired"  >{%#org.r3.db.wbs.wbsnode.message.nodename%}</label>
     <div class="col-md-8" >
          <input type="text" class='form-control' name="nodename" id="wbsnodeactionform_nodename" maxlength="40"  />        
     </div>
 </div>
 
 <div class="form-group">
     <label class="col-md-4 control-label fieldRequired"  >{%#org.r3.db.wbs.wbsnode.message.assignedto%}</label>
     <div class="col-md-8" >
          <select name="assignedto" class='form-control' id="wbsnodeactionform_assignedto" ></select>         
     </div>
 </div>
 
  </div>
  
  <div class='col-md-6'>
  
 <div class="form-group">
     <label class="col-md-4 control-label fieldRequired"  >{%#org.r3.db.wbs.wbsnode.message.startdate%}</label>
     <div class="col-md-8" >
          <input name="startdate" class='form-control r3_datepicker' id="wbsnodeactionform_form_startdate" type="text" />        
     </div>
 </div>
   
  <div class="form-group">
     <label class="col-md-4 control-label fieldRequired"  >{%#org.r3.db.wbs.wbsnode.message.duration%}</label>
     <div class="col-md-8" >
       <div class="input-group validation-error-anchor">
        <input type="text" class='form-control' name="duration" id="wbsnodeactionform_duration" maxlength="5"  />     
        <span class="input-group-addon">{%#org.r3.db.wbs.wbsnode.message.unit_duration%}</span>   
       </div>
     </div>
 </div>
 
 <div class="form-group">
     <label class="col-md-4 control-label"  >{%#org.r3.db.wbs.wbsnode.message.enddate%}</label>
     <div class="col-md-8" >
        <label class="control-label"  id="wbsnodeactionform_form_enddate">&nbsp;</label>
     </div>
 </div>
 
  </div>
  
  </div>

  <hr />
    
  <div class='row'>

  <div class='col-md-6'>
  
 <div class="form-group">
     <label class="col-md-4 control-label "  >{%#org.r3.jsportlet.wbs.message.wbsnodeactionform_completion%}</label>
     <div class="col-md-8" >
        <label class=" form-control "  id="wbsnodeactionform_completion">&nbsp;</label>
     </div>
 </div>
 
 <div class="form-group">
     <label class="col-md-4 control-label fieldRequired"  >{%#org.r3.db.wbs.wbsnode.message.completiontype%}</label>
     <div class="col-md-8 columns radio-medium" >
        <label class='radio-inline'>
          <input name="completiontype" id="wbsnodeactionform_completiontype_percentage" type="radio" value="percentage" checked /> {%#org.r3.db.wbs.wbsnode.message.completiontype_percentage%}</label> 
        <label class='radio-inline'>
          <input name="completiontype" id="wbsnodeactionform_completiontype_int_pos_range" value="int_pos_range" type="radio" /> {%#org.r3.db.wbs.wbsnode.message.completiontype_int_pos_range%}</label>             
     </div>
</div>

 <div class="form-group">
     <label class="col-md-4 control-label fieldRequired"  >{%#org.r3.jsportlet.wbs.message.wbsnodeactionform_completion_note%}</label>
     <div class="col-md-8" >
        <input type="text" class='form-control' name="completiondescr" id="wbsnodeactionform_completiondescr" maxlength="80"  />
     </div>
 </div>
 
  <div class="form-group">
     <label class="col-md-4 control-label fieldRequired"  >{%#org.r3.db.wbs.wbsnode.message.completionfrom%}</label>
     <div class="col-md-8" >
       <div class="input-group validation-error-anchor">    
       <input type="text" class='input-sm form-control' name="completionfrom" id="wbsnodeactionform_completionfrom" maxlength="5"  />   
       <span class="input-group-addon">{%#org.r3.db.wbs.wbsnode.message.completionto%}</span>
       <input type="text" class='input-sm form-control' name="completionto" id="wbsnodeactionform_completionto" maxlength="5"  />
       </div>                         
     </div>
 </div>
 
  </div>

  <div class='col-md-6'>
  
 <div class="form-group">
     <label class="col-md-4 control-label fieldRequired"  >{%#org.r3.db.wbs.wbsnode.message.completioneffort%}</label>
     <div class="col-md-8" >
        <input type="text" class='form-control' name="completioneffort" id="wbsnodeactionform_completioneffort" maxlength="5"  />
     </div>
 </div>
 
  <div class="form-group">
     <label class="col-md-4 control-label fieldRequired"  >{%#org.r3.db.wbs.wbsnode.message.economicvalue3%}</label>
     <div class="col-md-8" >
          <input type="text" class='form-control' name="economicvalue3" id="wbsnodeactionform_economicvalue3" maxlength="5"  />        
     </div>
 </div>
   
  <div class="form-group">
     <label class="col-md-4 control-label fieldRequired"  >{%#org.r3.db.wbs.wbsnode.message.economicvalue%}</label>
     <div class="col-md-8" >
          <input type="text" class='form-control' name="economicvalue" id="wbsnodeactionform_economicvalue" maxlength="5"  />        
     </div>
 </div>
 
 <div class="form-group">
     <label class="col-md-4 control-label fieldRequired"  >{%#org.r3.db.wbs.wbsnode.message.economicvalue2%}</label>
     <div class="col-md-8" >
          <input type="text" class='form-control' name="economicvalue2" id="wbsnodeactionform_economicvalue2" maxlength="5"  />        
     </div>
 </div>
 
  </div>
  
  </div>
 
  <hr />
   
  <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >{%#org.r3.db.wbs.wbsnode.message.nodesummary%}</label>
     <div class="col-md-10" >
<textarea  name="nodesummary" class='form-control' id="wbsnodeactionform_nodesummary" rows="5" ></textarea>        
     </div>
 </div>
 
  </form>

    <div class="form-action-bar">
        <button type="button" id="wbsnodeactionform_action_saveitem" class="btn btn-default" >
          <span>{%=org.r3.message.action_save%}</span>
        </button>                       
    </div>

  </div>
</div>


       
           

      
           
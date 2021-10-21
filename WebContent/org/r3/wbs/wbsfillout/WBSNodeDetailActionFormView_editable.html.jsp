<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<div id='wbsnode_infoLine_page' style='margin-top: 10px'></div>

<div class="panel panel-default">
  <div class="panel-heading" style='background: white'>  
    <h3 class="panel-title" id="wbsnodeactionform_nodename">{%#org.r3.wbs.wbsfillout.message.wbsnodeactionform_nodename%}</h3>
  </div>
  <div class="panel-body">

  
  <div id="wbsnodeactionform_fieldset_message" ></div>

  <form id="wbsnodeactionform_form" method="POST" class="form-horizontal">          
  <input type='hidden' name='completion' id='wbsnodeactionform_completion' />
  <input type="hidden" name="current_completioneffort" id="wbsnodeactionform_current_completioneffort" />
  
  <div class="form-group">
    <label class="col-sm-3 control-label fieldRequired">{%#org.r3.wbs.wbsfillout.message.wbsnodeactionform_nodename%}</label>
    <label class="col-sm-9  control-label" style='text-align: left' id="wbsnodeactionform_nodesummary">{%#org.r3.db.wbs.wbsnode.message.summary%}</label>       
  </div>
  
  <div class="form-group">
    <label class="col-sm-3 control-label fieldRequired" id="wbsnodeactionform_completioncaption">{%#org.r3.db.wbs.wbsnode.message.completion%}</label>
    <label class="col-sm-1 control-label"  id="wbsnodeactionform_completion_label"></label>
    
    <div class='col-sm-8'>
    <div class="well well-sm" style='padding: 5px 5px 5px 20px'>
	   <input id="wbsnodeactionform_completion_slider" data-slider-id='ex1Slider' type="text" />
	 </div>
	<!--  
    <div id="wbsnodeactionform_completion_slider"></div>-->		
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-3 control-label fieldRequired">{%#org.r3.db.wbs.wbsnode.message.completioneffort%}</label>
    <div class='col-sm-4'>
    <input class="form-control" name="completioneffort" id="wbsnodeactionform_completioneffort" maxlength="5" />
    </div>
  </div>
    
  <div class="form-group">
    <label class="col-sm-3 control-label fieldRequired">{%#org.r3.db.wbs.wbsnode.message.economicvalue%}</label>
    <div class='col-sm-4'>
    <input class="form-control" name="economicvalue" id="wbsnodeactionform_economicvalue" maxlength="5"  />
    </div>
  </div>
      
  <div class="form-group" style='margin-top: 20px'>
    <div class='col-md-12'>
      <textarea class="ckeditor"  id="wbsnodeactionform_nodetext" name="nodetext" style="width: 90%;" rows="5"></textarea>
    </div>
  </div>
    
  <div class="form-action-bar">
        <button type="button" id="wbsnodeactionform_action_saveitem" class="btn btn-default" >
          <span>{%#org.r3.message.action_save%}</span>
        </button>
   </div> 
   
  </form>
  
  </div>
</div>


<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
<div class="panel tabbed-panel">
  <div class="panel-heading" >  
    <h3 class="panel-title" >{%=org.r3.jsportlet.wbs.message.wbsactionform_form_legend_title%}</h3>
  </div>
  
  <div class="panel-body">
  <div id="wbsactionform_fieldset_message" ></div>
  <form id="wbsactionform_form" method="POST" class='form-horizontal'>

<div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >{%=org.r3.jsportlet.wbs.message.wbsactionform_options%}</label>
     <div class="col-md-10 columns" >
          <label class='checkbox-inline'> 
            <input id="wbsactionform_options_notify" type="checkbox" value="notify" name="options"  >{%=org.r3.jsportlet.wbs.message.wbsactionform_options_notify%}</label>  
          <label class='checkbox-inline'> 
            <input id="wbsactionform_options_discussion" type="checkbox" value="discussion" name="options"  >{%=org.r3.jsportlet.wbs.message.wbsactionform_options_discussion%}</label>                    
     </div>
</div>

 <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >{%=org.r3.jsportlet.wbs.message.wbsactionform_wbstitle%}</label>
     <div class="col-md-10" >
          <input type="text" class='form-control' name="wbstitle" id="wbsactionform_wbstitle" maxlength="255"  />        
     </div>
 </div>
 
  <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >{%=org.r3.jsportlet.wbs.message.wbsactionform_wbscoach%}</label>
     <div class="col-md-10" >
          <select name="wbscoach" class='form-control' id="wbsactionform_wbscoach" ></select>         
     </div>
 </div>
 
  <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >{%=org.r3.jsportlet.wbs.message.wbsactionform_wbsmanager%}</label>
     <div class="col-md-10" >
       <select name="wbsmanager" class='form-control' id="wbsactionform_wbsmanager" ></select>          
     </div>
 </div>
 
  <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >{%=org.r3.jsportlet.wbs.message.wbsactionform_wbssponsor%}</label>
     <div class="col-md-10" >
          <select name="wbssponsor" class='form-control' id="wbsactionform_wbssponsor" ></select>        
     </div>
 </div>

 <div class="form-group">
     <label class="col-md-2 control-label "  >{%=org.r3.jsportlet.wbs.message.wbsactionform_bbstopicid%}</label>
     <div class="col-md-10" >
        <label class="form-control "id="wbsactionform_bbstopicid" disabled>&nbsp;</label>
     </div>
 </div>
 
  <textarea class="ckeditor"  id="wbsactionform_wbstext" name="wbstext" style="width: 90%" rows="5"></textarea>

  </form>
  
  <div class="form-action-bar">
        <button type="button" id="wbsactionform_action_saveitem" class="btn btn-default" >
          <span>{%=org.r3.message.action_save%}</span>
        </button>                       
  </div>

  
  </div>
</div>


    
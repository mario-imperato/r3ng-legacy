<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
<div class="panel panel-default">
  <div class="panel-heading" style='background: white'>  
    <h3 class="panel-title">{%=org.r3.jsportlet.outmail.message.outmailmessageactionform_form_legend%}</h3>
  </div>
  
  <div class="panel-body">
  <div id="outmailmessageactionform_fieldset_message" ></div>
      
  <form id="outmailmessageactionform_form" method="POST" class='form-horizontal'>
  <input type='hidden' id='outmailmessageactionform_attachmentgroupid' name='attachmentgroupid' />
  <input type='hidden' id='outmailmessageactionform_msgfrom' name='msgfrom' />
  
  <div class="form-group">
    <label class="col-md-2  control-label fieldRequired">{%=org.r3.jsportlet.outmail.message.outmailmessageactionform_msgfrom%}</label>    
    <div class='col-md-10 '>
    <label class="form-control" id="outmailmessageactionform_msgfrom_label" disabled>&nbsp;</label>
    </div>
  </div> 
  
  <div class="form-group">
    <label class="col-md-2  control-label">{%=org.r3.jsportlet.outmail.message.outmailmessageactionform_msgto%}</label>
    <div class='col-md-10 '>
    <input name="msgto" class='form-control' id="outmailmessageactionform_msgto" maxlength="255"  />
    </div>
  </div> 

  <div class="form-group">
    <label class="col-md-2  control-label">{%=org.r3.jsportlet.outmail.message.outmailmessageactionform_msgcc%}</label>
    <div class='col-md-10 '>
    <input name="msgcc" class='form-control' id="outmailmessageactionform_msgcc" maxlength="255"  />
    </div>
  </div> 

  <div class="form-group">
    <label class="col-md-2  control-label">{%=org.r3.jsportlet.outmail.message.outmailmessageactionform_msgbcc%}</label>
    <div class='col-md-10 '>
    <input name="msgbcc" class='form-control' id="outmailmessageactionform_msgbcc" maxlength="255"  />
    </div>
  </div> 
  
  <div class="form-group">
    <label class="col-md-2  control-label fieldRequired">{%=org.r3.jsportlet.outmail.message.outmailmessageactionform_msgtitle%}</label>
    <div class='col-md-10 '>
    <input type="text" class='form-control' name="msgtitle" id="outmailmessageactionform_msgtitle" maxlength="255"  />
    </div>
  </div> 

  <div class="form-group">
    <label class="col-md-2  control-label">{%=org.r3.jsportlet.outmail.message.outmailmessageactionform_mailopt2_cnt%}</label>
    <div class='col-md-10 columns' id="outmailmessageactionform_mailopt2_cnt">
        <label class="radio-inline">
            <input id="outmailmessageactionform_mailopt_msg_regular" type="radio" value="msg_regular" name="msgmode" >
              {%=org.r3.jsportlet.outmail.message.outmailmessageactionform_mailopt_msg_regular%}
        </label>

        <label class="radio-inline">
            <input id="outmailmessageactionform_mailopt_msg_undisclosed" type="radio" value="msg_undisclosed" name="msgmode" checked>
              {%=org.r3.jsportlet.outmail.message.outmailmessageactionform_mailopt_msg_undisclosed%}
        </label>
    </div>
  </div> 

  <div class="form-group">
    <label class="col-md-2  control-label">{%=org.r3.jsportlet.outmail.message.outmailmessageactionform_gruppi_actorgroup%}</label>
    <div class='col-md-10 '>    
    <div style='float: left; margin-right: 10px'>
    <div class='validation-error-anchor'>
    <select name='actorgroup' class='form-control' id='outmailmessageactionform_gruppi_actorgroup' multiple='multiple'></select> 
    </div>
    </div>
    <div class='columns' id="smsdetailactionform_mailopt_cnt">
        <label class='checkbox-inline'>
            <input id="smsdetailactionform_mailopt_send2all" type="checkbox" value="send2all" name="mailopt" >
              {%=org.r3.jsportlet.outmail.message.smsdetailactionform_mailopt_send2all%}
        </label>  
    </div>
    </div>
    
  </div> 
      
  <div class="form-group">
    <div class='col-md-12 '>
     <textarea class="ckeditor"  class='form-control' id="outmailmessageactionform_msgtext" name="msgtext" style="width: 90%" rows="5"></textarea>
    </div>
  </div> 
        
  </form>
  
  <div class="form-action-bar">
        <button type="button" id="outmailmessageactionform_action_saveitem" class="btn btn-default" >
          <span>{%=org.r3.message.action_save%}</span>
        </button>                         
   </div> 
   
  </div>
</div>
   
  
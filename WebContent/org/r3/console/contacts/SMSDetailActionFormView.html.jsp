<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    

<div class="panel panel-default">
  <div class="panel-heading" style='background: white'>  
    <h3 class="panel-title" >{%=org.r3.console.contacts.message.smsdetailactionform_form_legend%}</h3>
  </div>
  
  <div class="panel-body">
  <div id="smsdetailactionform_fieldset_message" ></div>

  <form id="smsdetailactionform_form" method="POST" class='form-horizontal'>
  
  <div class='row'>
  <div class='col-md-8 col-sm-12'>
 <div class="form-group">
    <label class="col-md-3  control-label fieldRequired">{%=org.r3.console.contacts.message.smsdetailactionform_smslogin%}</label>
    <div class='col-md-9 '>
    <input type="text" class="form-control" name="smslogin" id="smsdetailactionform_smslogin" maxlength="15"  />
    </div>
  </div>  

  <div class="form-group">
    <label class="col-md-3  control-label fieldRequired">{%=org.r3.console.contacts.message.smsdetailactionform_smspasswd%}</label>
    <div class='col-md-9 '>
    <input type="password" class="form-control" name="smspasswd" id="smsdetailactionform_smspasswd" maxlength="15"  />
    </div>
  </div>

  <div class="form-group">
    <label class="col-md-3  control-label fieldRequired">{%=org.r3.console.contacts.message.smsdetailactionform_smssender%}</label>
    <div class='col-md-9 '>
    <input type="text" name="smssender" class="form-control" id="smsdetailactionform_smssender" maxlength="11"  />
    </div>
  </div>

  <div class="form-group">
    <label class="col-md-3  control-label">{%=org.r3.console.contacts.message.smsdetailactionform_smsopts_cnt%}</label>
    <div class='col-md-9 columns checkbox-large' id="smsdetailactionform_smsopts_cnt">
    </div>
  </div>

  <div class="form-group">
    <label class="col-md-3  control-label">&nbsp;</label>
    <div class='col-md-9 columns checkbox-large' id="smsdetailactionform_smsopts2_cnt">

        <label class="checkbox-inline" >
        <input id="smsdetailactionform_smsopts_charlimit" type="checkbox" value="smsopt_charlimit" name="smsopts2" checked>
              {%=org.r3.console.contacts.message.smsdetailactionform_smsopts_charlimit%}
        </label>

        <label class="checkbox-inline" >
            <input id="smsdetailactionform_smsopts_send2all" type="checkbox" value="smsopt_send2all" name="send2all" >
              {%=org.r3.console.contacts.message.smsdetailactionform_smsopts_send2all%}           
        </label>
  
    </div>
  </div>

  </div>
  
  <div class='col-md-4 col-sm-12'>
    <div id="smsdetailactionform_numberofsmscredits" class="smscredits_viewport"></div>
  </div>  
  </div>
   
  <div class='row'>
  <div class='col-md-12'>
  <div class="form-group">
    <label class="col-md-2  control-label fieldRequired"><span class="">{%=org.r3.console.contacts.message.smsdetailactionform_smstext%}</span> <br />{%=org.r3.console.contacts.message.smsdetailactionform_smstext_maxchars%}<br />{%=org.r3.console.contacts.message.smsdetailactionform_smstext_numchars%}: <span id='smsdetailactionform_smstext_numchars'>0</span></label>
    <div class='col-md-10 ' >
     <textarea  name='smstext' id="smsdetailactionform_smstext" class="form-control" rows="5" ></textarea>
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-md-2  control-label ">{%=org.r3.console.contacts.message.smsdetailactionform_gruppi_actorgroup%}</label>
    <div class='col-md-10'>
    <div class='validation-error-anchor'>
    <select name='actorgroup' id='smsdetailactionform_gruppi_actorgroup' class="form-control" multiple='multiple'></select>  
    </div>
    </div>
  </div>
  
  </div>
  </div>
  </form>
  
  <div class="form-action-bar">
        <button type="button" id="smsdetailactionform_action_saveitem" class="btn btn-default" >
          <span>{%=org.r3.message.action_save%}</span>
        </button>

        <button type="button" id="smsdetailactionform_action_checksmscredits" class="btn btn-default" >
          <span>{%=org.r3.console.contacts.message.smsdetailactionform_action_checksmscredits%}</span>
        </button>                  
   </div>   
  </div>
</div>

 
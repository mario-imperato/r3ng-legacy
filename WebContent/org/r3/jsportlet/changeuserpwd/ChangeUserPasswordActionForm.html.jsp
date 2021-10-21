<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
  
  
<div class="panel tabbed-panel">
  <div class="panel-heading" style='background: white'>  
    <h3 class="panel-title">{%#org.r3.jsportlet.changeuserpwd.message.panel_title%}</h3>
  </div>
  <div class="panel-body">
  <p>{%#org.r3.jsportlet.changeuserpwd.message.panel_info%}</p>
  <div id="changeuserpwdform_fieldset_message" ></div>
  
  <form id="changeuserpwdform_form" method="POST" class="form-horizontal">
  <div class="form-group">
    <label class="col-sm-4 control-label fieldRequired">{%#org.r3.jsportlet.changeuserpwd.message.current_password%}</label>
    <div class='col-sm-8'>
    <input name="currentpassword" class="form-control" id="changeuserpwdform_currentpassword" type="password" maxlength="10"/>
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-4 control-label fieldRequired">{%#org.r3.jsportlet.changeuserpwd.message.password%}</label>
    <div class='col-sm-8'>
    <input name="password" class="form-control" id="changeuserpwdform_password" type="password" maxlength="10"/>
    </div>
  </div>

  <div class="form-group">
    <label class="col-sm-4 control-label fieldRequired">{%#org.r3.jsportlet.changeuserpwd.message.confirmpassword%}</label>
    <div class='col-sm-8'>
    <input name="confpasswd" class="form-control" id="changeuserpwdform_confpasswd" type="password" maxlength="10"/>
    </div>
  </div>
          
   <div class="form-action-bar">
        <button type="button" id="changeuserpwdButton" class="btn btn-default" >
          <span>{%#org.r3.message.action_confirm_request%}</span>
        </button>
   </div>       
   </form>
  
  </div>
</div>
  
    
 
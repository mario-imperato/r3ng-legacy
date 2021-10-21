<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
<div class="panel panel-default">
  <div class="panel-heading" style='background: white'>  
    <h3 class="panel-title">{%=org.r3.shkadmin.siteconfig.message.adminsactionform_legend%}</h3>
  </div>
  
  <div class="panel-body">
  <div id="adminsactionform_fieldset_message" ></div>
  <form id="adminsactionform_form" method="POST" class="form-horizontal">
  <input type='hidden' name='userid' id='adminsactionform_userid' />
    
  <div class="form-group">
  <label class="col-md-2 control-label fieldRequired ">{%=org.r3.db.system.user.user.message.email%}</label>
   <div class='col-md-10'>
      <input type="text" class='form-control' data-provide="typeahead" id="adminsactionform_email">
   </div>
  </div>

  <div class="form-group">
  <label class="col-md-2 control-label  ">{%=org.r3.db.system.user.user.message.firstname%}</label>
   <div class='col-md-10'>
      <input type="text" class='form-control' id="adminsactionform_firstname" readonly>
   </div>
  </div>

  <div class="form-group">
  <label class="col-md-2 control-label  ">{%=org.r3.db.system.user.user.message.lastname%}</label>
   <div class='col-md-10'>
      <input type="text" class='form-control'  id="adminsactionform_lastname" readonly>
   </div>
  </div>
	  
  </form>
  
<div class="form-action-bar">
        <button type="button" id="adminsactionform_action_saveitem" class="btn btn-default" disabled>
          <span>{%=org.r3.message.action_save%}</span>
        </button>

      <button type="button" id="adminsactionform_action_cancel" class="btn btn-danger" >
        <span>{%=org.r3.message.action_delete%}</span>
      </button>
                  
   </div> 
     
  </div>
</div>

 

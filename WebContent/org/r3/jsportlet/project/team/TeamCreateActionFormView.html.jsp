<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    

<div class="panel panel-light">
  <div class="panel-heading" >  
    <h3 class="panel-title" >{%=org.r3.jsportlet.project.team.message.teamdetailactionform_form_legend%}</span></h3>
  </div>
  
  
  <div class="panel-body">
  <div id="teamdetailactionform_fieldset_message" ></div>
  <form id="teamdetailactionform_form" method="POST" class="form-horizontal">
  <div class='row'>
  <div class='col-md-6 col-sm-12'>
  <div class="form-group">
    <label class="col-md-4  control-label">{%=org.r3.db.project.team.message.teamdescr%}</label>
    <div class='col-md-8 '>
    <input class="form-control" type="text" name="teamdescr" id="teamdetailactionform_teamdescr" maxlength="40"  />
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-md-4  control-label fieldRequired">{%=org.r3.db.project.team.message.periodindex%}</label>
    <div class='col-md-8 '>
    <select class="form-control"  name="periodindex" id="teamdetailactionform_periodindex" ></select>
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-md-4  control-label">{%=org.r3.db.project.team.message.templateteamid%}</label>
    <div class='col-md-8 '>
    <select class="form-control" name="templateteamid" id="teamdetailactionform_templateteamid" ></select>
    </div>
  </div>
  
  </div>
  
  <div class='col-md-6 col-sm-12'>  
  
  </div>
  </div>
      
  <div class="form-action-bar">
          
        <button type="button" id="teamdetailactionform_action_saveitem" class="btn btn-default" >
          <span>{%=org.r3.message.action_save%}</span>
        </button>

        <button type="button" id="teamdetailactionform_form_action_cancel" class="btn btn-default" >
          <span>{%=org.r3.message.action_cancel%}</span>
        </button>

      <button type="button" id="teamdetailactionform_action_delete" class="btn btn-danger" >
        <span>{%=org.r3.message.action_delete%}</span>
      </button>
                  
   </div> 
  </form>       
  </div>
  
</div>





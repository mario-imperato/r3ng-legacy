<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    

<div class="panel tabbed-panel">
  <div class="panel-heading" >  
    <h3 class="panel-title" >{%=org.r3.console.resources.message.resourcedetailactionform_form_legend%}</h3>
  </div>
  
  <form id="resourcedetailactionform_form" method="POST" class="form-horizontal">
  <input type='hidden' id='resourcedetailactionform_resourceid' name='resourceid' />
  
  <div class="panel-body">
  <div id="resourcedetailactionform_fieldset_message" ></div>
  
  <div class='row'>
  <div class='col-md-6 col-sm-12'>
  <div class="form-group">
    <label class="col-md-2  control-label fieldRequired">{%=org.r3.db.project.resource.message.ssn%}</label>
  <div class='col-md-10 '>
  <div class="form-group row">
  <div class="col-md-9 col-sm-10" style="padding-right: 0">
     <input type="text" class="form-control " style="display: inline-block; width: 100%" name="ssn" id="resourcedetailactionform_ssn" maxlength="16">
  </div>
  <div class="col-md-3 col-sm-2" style="padding: 0">
     <button id="resourcedetailactionform_ssn_action_search" class="btn btn-default" 
         style="margin-left: 5px"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
  </div>
  </div>
  </div>
  </div>
  </div>
  </div>
  
  <div class='row'>
  <div class='col-md-6 col-sm-12'>
  <div class="form-group">
    <label class="col-md-2  control-label fieldRequired">{%=org.r3.db.project.resource.message.firstname%}</label>
    <div class='col-md-10 '>
    <input class="form-control resource-domain-data" type="text" name="firstname" id="resourcedetailactionform_firstname" maxlength="30"  />
    </div>
  </div>

  <div class="form-group">
    <label class="col-md-2  control-label fieldRequired">{%=org.r3.db.project.resource.message.lastname%}</label>
    <div class='col-md-10 '>
    <input class="form-control resource-domain-data" type="text" name="lastname" id="resourcedetailactionform_lastname" maxlength="30"  />
    </div>
  </div>
  </div>
  
  <div class='col-md-6 col-sm-12'>  
  <!-- 
  <div class="form-group">
    <label class="col-md-2  control-label ">{%=org.r3.db.project.resource.message.resourceid%}</label>
    <div class='col-md-10 '>
    <label class="form-control"  id="resourcedetailactionform_resourceid" disabled>&nbsp;</label>   
    </div>         
  </div>
   -->
   
  </div>
  </div>

  
  <div class='row'>
  <div class='col-md-6'>
  <div class="form-group">
    <label class="col-md-2 control-label ">{%=org.r3.db.project.resource.message.email%}</label>
    <div class='col-md-10'>
    <input class="form-control" type="text" name="email" id="resourcedetailactionform_email" maxlength="50" />
    </div>
  </div>
  
   <div class="form-group">
    <label class="col-md-2 control-label ">{%=org.r3.db.project.resource.message.cellphone%}</label>
    <div class='col-md-10'>
    <input class="form-control" type="text" name="cellphone" id="resourcedetailactionform_cellphone" maxlength="15" />
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-md-2 control-label ">{%=org.r3.db.project.resource.message.phone%}</label>
    <div class='col-md-10'>
    <input class="form-control" type="text" name="phone" id="resourcedetailactionform_phone" maxlength="15" />
    </div>
  </div>
  </div>
  
  <div class='col-md-6'>    
  <div class="form-group">
    <label class="col-md-2 control-label ">{%=org.r3.db.project.resource.message.address%}</label>
    <div class='col-md-10'>
    <input class="form-control" type="text" name="address" id="resourcedetailactionform_address" maxlength="30"  />
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-md-2 control-label ">{%=org.r3.db.project.resource.message.town%}</label>
    <div class='col-md-10'>
    <input class="form-control" type="text" name="town" id="resourcedetailactionform_town" maxlength="30"  />
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-md-2 control-label ">{%=org.r3.db.project.resource.message.zipcode%}</label>
    <div class='col-md-10'>
    <input class="form-control" type="text" name="zipcode" id="resourcedetailactionform_zipcode" maxlength="5"  />
    </div>
  </div>
  </div>
  </div>
      
  </div>
  
 <div class="panel-heading" >  
    <h3 class="panel-title" >{%=org.r3.console.resources.message.resourcedetailactionform_form_legend_teamprofile%}</h3>
 </div>
   
  <div class="panel-body">
  
  <div class='row'>
  <div class='col-md-6'>
 
  <div class="form-group">
    <label class="col-md-2 control-label fieldRequired">{%=org.r3.db.project.teamresource.message.teamid%}</label>
    <div class='col-md-10'>
    <select class="form-control"  name="teamid" id="resourcedetailactionform_teamid" ></select>
    </div>
  </div>
   
  <div class="form-group">
    <label class="col-md-2 control-label fieldRequired">{%=org.r3.db.project.teamresource.message.profileid%}</label>
    <div class='col-md-10'>
    <select class="form-control"  name="profileid" id="resourcedetailactionform_profileid" ></select>
    </div>
  </div>
    
  </div>
  </div>
  
  <div class="form-action-bar">
          
        <button type="button" id="resourcedetailactionform_action_saveitem" class="btn btn-default" >
          <span>{%=org.r3.message.action_save%}</span>
        </button>

        <button type="button" id="resourcedetailactionform_form_action_cancel" class="btn btn-default" >
          <span>{%=org.r3.message.action_cancel%}</span>
        </button>

      <button type="button" id="resourcedetailactionform_action_delete" class="btn btn-danger" >
        <span>{%=org.r3.message.action_delete%}</span>
      </button>
                  
   </div> 
     
  </div>
  </form>

  

  
</div>





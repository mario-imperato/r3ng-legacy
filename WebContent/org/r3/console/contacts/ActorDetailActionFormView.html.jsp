<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    

<div class="panel tabbed-panel">
  <div class="panel-heading" >  
    <h3 class="panel-title" >{%=org.r3.console.contacts.message.actordetailactionform_form_legend%}</h3>
  </div>
  
  <div class="panel-body">
  <div id="actordetailactionform_fieldset_message" ></div>
  <form id="actordetailactionform_form" method="POST" class="form-horizontal">
  
  <div class='row'>
  <div class='col-md-6 col-sm-12'>
  <div class="form-group">
    <label class="col-md-2  control-label ">{%=org.r3.db.actor.actor.message.actorid%}</label>
    <div class='col-md-10 '>
    <label class="form-control"  id="actordetailactionform_actorid" disabled>&nbsp;</label>   
    </div>         
  </div>  
  
  <div class="form-group">
    <label class="col-md-2 control-label ">{%=org.r3.db.actor.actor.message.email%}</label>
    <div class='col-md-10'>
    <input class="form-control" type="text" name="email" id="actordetailactionform_email" maxlength="50" />
    </div>
  </div>  
  </div>
  
  <div class='col-md-6 col-sm-12'>  

  <div class="form-group">
    <label class="col-md-2  control-label fieldRequired">{%=org.r3.db.actor.actor.message.firstname%}</label>
    <div class='col-md-10 '>
    <input class="form-control" type="text" name="firstname" id="actordetailactionform_firstname" maxlength="30"  />
    </div>
  </div>

  <div class="form-group">
    <label class="col-md-2  control-label fieldRequired">{%=org.r3.db.actor.actor.message.lastname%}</label>
    <div class='col-md-10 '>
    <input class="form-control" type="text" name="lastname" id="actordetailactionform_lastname" maxlength="30"  />
    </div>
  </div>
  
  <!-- 
  <div class="form-group">
    <label class="col-md-2 control-label ">{%=org.r3.db.actor.actor.message.userid%}</label>
    <div class='col-md-10 single_picker' id='actordetailactionform_pickeruserid_cnt'>
    </div>
  </div>
  -->
  </div>
  </div>

  
  <div class='row'>
  <div class='col-md-6'>
  
  <div class="form-group">
    <label class="col-md-2 control-label ">{%=org.r3.db.actor.actor.message.address%}</label>
    <div class='col-md-10'>
    <input class="form-control" type="text" name="address" id="actordetailactionform_address" maxlength="30"  />
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-md-2 control-label ">{%=org.r3.db.actor.actor.message.town%}</label>
    <div class='col-md-10'>
    <input class="form-control" type="text" name="town" id="actordetailactionform_town" maxlength="30"  />
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-md-2 control-label ">{%=org.r3.db.actor.actor.message.zipcode%}</label>
    <div class='col-md-10'>
    <input class="form-control" type="text" name="zipcode" id="actordetailactionform_zipcode" maxlength="5"  />
    </div>
  </div>

  </div>
  
  <div class='col-md-6'>    
   <div class="form-group">
    <label class="col-md-2 control-label ">{%=org.r3.db.actor.actor.message.cellphone%}</label>
    <div class='col-md-10'>
    <input class="form-control" type="text" name="cellphone" id="actordetailactionform_cellphone" maxlength="15" />
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-md-2 control-label ">{%=org.r3.db.actor.actor.message.phone%}</label>
    <div class='col-md-10'>
    <input class="form-control" type="text" name="phone" id="actordetailactionform_phone" maxlength="15" />
    </div>
  </div>
  </div>
  </div>
  
  <div class='row'>
  <div class='col-md-12'>  
  <div class="form-group">
    <label class="col-md-1  control-label ">{%=org.r3.db.actor.actor.message.sysgroups%}</label>
    <label class="col-md-11 control-label " style='text-align: left' id="actordetailactionform_sysgroups">&nbsp;</label>
  </div>
  </div>

  <div class='col-md-12'>  
  <div class="form-group">
    <label class="col-md-1 control-label ">{%=org.r3.db.actor.actor.message.groups%}</label>
    <div class='col-md-11' id="gruppi_ms" >
    </div>
  </div>
  </div>
  </div>
      
   <div class="form-action-bar">
        <button type="button" id="actordetailactionform_action_saveitem" class="btn btn-default" >
          <span>{%=org.r3.message.action_save%}</span>
        </button>

        <button type="button" id="actordetailactionform_form_action_cancel" class="btn btn-default" >
          <span>{%=org.r3.message.action_cancel%}</span>
        </button>

      <button type="button" id="actordetailactionform_action_delete" class="btn btn-danger" >
        <span>{%=org.r3.message.action_delete%}</span>
      </button>
                  
   </div> 
  
  </form>
  </div>
</div>





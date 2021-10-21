<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
<div class="panel panel-default">
  <div class="panel-heading" style='background: white'>  
    <h3 class="panel-title"><label class="fieldReadOnly" id="actorgroupdetailactionform_groupid"></label>{%=org.r3.console.contacts.message.actorgroupdetailactionform_form_legend%}</h3>
  </div>
  
  <div class="panel-body">
  <div id="actorgroupdetailactionform_fieldset_message" ></div>
  <form id="actorgroupdetailactionform_form" method="POST" class="form-horizontal">

<div class="form-group">
     <label class="col-md-2 control-label "  >{%=org.r3.db.actor.group.message.groupprofile%}</label>
     <div class="col-md-10 columns" id="actorgroupdetailactionform_groupprofile_cnt">
        <label class="checkbox-inline" style="width: 220px; ">
           <input id="actorgroupdetailactionform_groupprofile_deletable" type="checkbox" value="deletable" name="groupprofile" />{%=org.r3.db.actor.group.message.groupprofile_deletable%}</label>

        <label class="checkbox-inline" style="width: 220px; ">
           <input id="actorgroupdetailactionform_groupprofile_gmenubar" type="checkbox" value="gmenubar" name="groupprofile" />{%=org.r3.db.actor.group.message.groupprofile_gmenubar%}</label>               
     </div>
 </div>

 <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >{%=org.r3.db.actor.group.message.grouptitle%}</label>
     <div class="col-md-10" >
        <input type="text" class='form-control' name="grouptitle" id="actorgroupdetailactionform_grouptitle" maxlength="30"  />        
     </div>
 </div>
     
 <div class="form-group" id="actorgroupdetailactionform_oncreatefields" style='display: none'>
     <label class="col-md-2 control-label fieldRequired"  >{%=org.r3.console.contacts.message.actorgroupdetailactionform_createfromgroup%}</label>
     <div class="col-md-10" >
        <select name="createfromgroup" class='form-control' id="actorgroupdetailactionform_createfromgroup" >
          <option value="">{%=org.r3.console.contacts.message.actorgroupdetailactionform_createfromgroup_none%}</option>
          <option value="__ALL__">{%=org.r3.console.contacts.message.actorgroupdetailactionform_createfromgroup_all%}</option>                  
        </select>               
     </div>
 </div>

  </form>
  
<div class="form-action-bar">
        <button type="button" id="actorgroupdetailactionform_action_saveitem" class="btn btn-default" >
          <span>{%=org.r3.message.action_save%}</span>
        </button>

      <button type="button" id="actorgroupdetailactionform_action_delete" class="btn btn-danger" >
        <span>{%=org.r3.message.action_delete%}</span>
      </button>
                  
   </div> 
     
  </div>
</div>

 

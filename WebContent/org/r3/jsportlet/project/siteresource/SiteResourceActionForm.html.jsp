<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
<div class="panel tabbed-panel">
  <div class="panel-heading" style='background: white;'>  
    <h3 class="panel-title" >{%=org.r3.jsportlet.project.siteresource.message.siteresourceform_form_legend%}</h3>
  </div>
  
  <div class="panel-body">
  <div id="siteresourceform_fieldset_message" ></div>
  <form id="siteresourceform_form" method="POST" class='form-horizontal'>
  
  <div class="form-group">
    <label class="col-md-2 control-label fieldRequired ">{%=org.r3.db.project.siteresource.message.evalueunit%}</label>
    <div class='col-md-10'>
     <select name="evalueunit" class="form-control"  id="siteresourceform_evalueunit" >
          <option value="day">{%=org.r3.db.project.siteresource.message.evalueunit_daily%}</option>
          <option value="hour">{%=org.r3.db.project.siteresource.message.evalueunit_hourly%}</option>          
     </select> 
    </div>
  </div>

  <div class="form-group">
    <label class="col-md-2 control-label ">{%=org.r3.db.project.siteresource.message.cost%}</label>
    <div class='col-md-10'>
     <input type="text" name="cost" class="form-control"  id="siteresourceform_cost" maxlength="5"  />
    </div>
  </div>
                
  <div class="form-group">
    <label class="col-md-2 control-label ">{%=org.r3.db.project.siteresource.message.price%}</label>
    <div class='col-md-10'>
      <input type="text" name="price" class="form-control"  id="siteresourceform_price" maxlength="5"  />
    </div>
  </div>   
    
  </form>
  
  <div class="form-action-bar">
        <button type="button" id="siteresourceform_action_save" class="btn btn-default" >
          <span>{%=org.r3.message.action_save%}</span>
        </button>
  </div>
  
  </div>
</div>


         
  
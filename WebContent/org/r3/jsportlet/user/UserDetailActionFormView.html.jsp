<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<%
   String mode = request.getParameter("mode");
   boolean isDetail = mode.equalsIgnoreCase("detail");
   boolean isCreate = !isDetail;
%>

<div id="userDetailActionFormTabs" >

 <ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#userDetailActionForm_tab_generale" role="tab" data-toggle="tab">{%=org.r3.jsportlet.user.message.userDetailActionForm_tab_generale%}</a></li>    
  </ul>

  <div class="tab-content" >
  <div id="userDetailActionForm_tab_generale"     class='tab-pane active tab-pane-framed' >
  
  <div id="userDetailActionForm_tab_generale">      

  <div class="panel tabbed-panel">
  <div class="panel-heading" >  
    <h3 class="panel-title">{%=org.r3.jsportlet.user.message.userdetailactionform_form_legend%}</h3>
  </div>
  
  <div class="panel-body">
  <div id="userdetailactionform_fieldset_message" ></div>
  
  <form id="userdetailactionform_form" class='form-horizontal'>
  
  <div class='row'>
  <div class='col-md-6'>
  <div class="form-group">
     <label class="col-md-2 control-label"  >&nbsp;</label>
     <div class="col-md-10 columns" id="userdetailactionform_form_opts_cnt">
        <label class='checkbox-inline checkbox-large' >
                <input id="userdetailactionform_form_createsiteactor" type="checkbox" value="btrue" name="createsiteactor">
                {%=org.r3.jsportlet.user.message.userdetailactionform_createsiteactor%}
        </label>                       
     </div>
 </div>
  </div>
  </div>
  
  <div class='row'>
  <div class='col-md-6'>

   
  <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >{%=org.r3.db.system.user.user.message.recstatus%}</label>
     <div class="col-md-10 ">
        <select name="recstatus" id="userdetailactionform_form_recstatus" class='form-control'></select>
     </div>
  </div>

  <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >{%=org.r3.db.system.user.user.message.nickname%}</label>
     <div class="col-md-10 ">
         <input name="nickname" id="userdetailactionform_form_nickname" type="text"  maxlength="40"  class='form-control' />
     </div>
  </div>
  
  <r3_lang:ifinclude include="<%=isCreate%>" >

  <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >{%=org.r3.jsportlet.user.message.changepasswordactionform_password%}</label>
     <div class="col-md-10 ">
         <input name="password" id="userdetailactionform_form_password" type="password" maxlength="10" class='form-control'/> 
     </div>
  </div>  

  <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >{%=org.r3.jsportlet.user.message.changepasswordactionform_confpasswd%}</label>
     <div class="col-md-10 ">
         <input name="confpasswd" id="userdetailactionform_form_confpasswd" type="password" maxlength="10" class='form-control'/> 
     </div>
  </div>  
  
  </r3_lang:ifinclude>
    
  </div>
  <div class='col-md-6'>
  
  <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >{%=org.r3.db.system.user.user.message.firstname%}</label>
     <div class="col-md-10 ">
         <input name="firstname" id="userdetailactionform_form_firstname" type="text"  maxlength="80"  class='form-control' />     
     </div>
  </div>

  <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >{%=org.r3.db.system.user.user.message.lastname%}</label>
     <div class="col-md-10 ">
         <input name="lastname" id="userdetailactionform_form_lastname" type="text"  maxlength="80"  class='form-control' />  
     </div>
  </div>

  <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >{%=org.r3.db.system.user.user.message.email%}</label>
     <div class="col-md-10 ">
         <input name="email" id="userdetailactionform_form_email" type="text"  maxlength="80"  class='form-control' /> 
     </div>
  </div>
    
  </div>
  </div>
            
  <div class="form-group">
     <label class="col-md-1 control-label"  >{%=org.r3.jsportlet.user.message.userdetailactionform_authrole_cnt%}</label>
     <div class="col-md-11 columns" id="userdetailactionform_authrole_cnt">                           
     </div>
 </div>
    
  </form>
  
   <div class="form-action-bar">
      
     <button type="button" class="btn  btn-default" id="userdetailactionform_action_openchangepasswd" >
       <span>{%=org.r3.jsportlet.user.message.userdetailactionform_action_openchangepasswd%}</span>
     </button>
   
   
     <button type="button" class="btn  btn-default" id="userdetailactionform_action_saveitem" >
        <span>{%=org.r3.message.action_save%}</span>
     </button>

     <button type="button" class="btn  btn-default" id="userdetailactionform_action_cancel" >
        <span>{%=org.r3.message.action_cancel%}</span>
     </button>

   </div>

    
  </div>
  </div>

  <div id="changePasswordActionForm" style="display:none;"></div>
  </div>
    
</div>

</div>
</div>


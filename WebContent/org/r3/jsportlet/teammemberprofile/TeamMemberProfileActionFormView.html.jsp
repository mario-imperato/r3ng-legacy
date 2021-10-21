<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>


<div class="panel panel-light">
  <div class="panel-heading" >  
    <h3 class="panel-title" >Profilo</h3>
  </div>
  
  <div class="panel-body">

  <div id="teammemberprofile_fieldset_message" ></div>
  <form id="teammemberprofile_form" method="POST" class='form-horizontal'>
  <input type='hidden' name="profiledescr" id="teammemberprofile_profiledescr" />
  
  <div class='row'>
  <div class='col-md-6'>
<div class="form-group">
     <label class="col-md-4 control-label "  >Id.</label>
     <div class="col-md-8 columns" >
          <input type="text" class='form-control' name="profileid" id="teammemberprofile_profileid" maxlength="15"  />     
     </div>
</div>
   
<div class="form-group">
     <label class="col-md-4 control-label "  >Ordinamento</label>
     <div class="col-md-8 columns" >
          <input type="text" class='form-control' name="itemorder" id="teammemberprofile_itemorder" maxlength="5"  />
     </div>
</div>
           
  </div>
  
  <div class='col-md-6'>
  
 <div class="form-group">
     <label class="col-md-4 control-label fieldRequired"  >Profilo Professionale</label>
     <div class="col-md-8 columns" >
          <select class='form-control' name="skillprofile" id="teammemberprofile_skillprofile" ></select>     
     </div>
</div>
   
 <div class="form-group">
     <label class="col-md-4 control-label fieldRequired"  >Figura Professionale</label>
     <div class="col-md-8 columns" >
          <select class='form-control'  name="skillambit" id="teammemberprofile_skillambit"  ></select>     
     </div>
</div>
   
  </div>  
  </div>
  
 <!--  
 <div class="form-group">
     <label class="col-md-2 control-label "  >Descrizione</label>
     <div class="col-md-10 columns" >
          <textarea  class='form-control' name="profiledescr" id="teammemberprofile_profiledescr" rows="2" ></textarea>  
     </div>
 </div>
 -->
  
     
  </form>
  
  <div class="form-action-bar">
        <button type="button" id="teammemberprofileform_action_save" class="btn btn-default" >
          <span>Salva</span>
        </button>

        <button type="button" id="teammemberprofileform_action_clear" class="btn btn-default" >
          <span>Pulisci</span>
        </button>            
   </div>
      
  </div>
</div>


   

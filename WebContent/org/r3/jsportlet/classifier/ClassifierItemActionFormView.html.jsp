<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>


  <h4 style='margin-bottom: 15px'>Elemento di Classificazione</h4>

<!-- <div class="panel panel-default"> -->
<!--   <div class="panel-heading" style='background: white'>   -->
<!--     <h3 class="panel-title">Elemento di Classificazione</h3> -->
<!--   </div> -->
  
<!--   <div class="panel-body"> -->
  <div id="classifieritemform_fieldset_message" ></div>
  <form id="classifieritemform_form" method="POST" class='form-horizontal'>
  
  <div class='row'>
  <div class='col-md-6'>
<div class="form-group">
     <label class="col-md-2 control-label "  >Id</label>
     <div class="col-md-10 columns" >
          <input type="text" class='form-control' name="clsitemid" id="classifieritemform_clsitemid" maxlength="15"  />     
     </div>
</div>
   
<div class="form-group">
     <label class="col-md-2 control-label "  >Id. business</label>
     <div class="col-md-10 columns" >
          <input type="text" class='form-control' name="clsitembusid" id="classifieritemform_clsitembusid" maxlength="15"  />
     </div>
</div>
   
<div class="form-group">
     <label class="col-md-2 control-label "  >Ordinamento</label>
     <div class="col-md-10 columns" >
          <input type="text" class='form-control' name="classifieritemorder" id="classifieritemform_classifieritemorder" maxlength="5"  />
     </div>
</div>
           
  </div>
  
  <div class='col-md-6'>
  
 <div class="form-group">
     <label class="col-md-2 control-label "  >User Defined (String)</label>
     <div class="col-md-10 columns" >
          <input type="text" class='form-control' name="classifieritemsattr" id="classifieritemform_classifieritemsattr" maxlength="80"  />     
     </div>
</div>
   
 <div class="form-group">
     <label class="col-md-2 control-label "  >User Defined (Intero)</label>
     <div class="col-md-10 columns" >
          <input type="text" class='form-control' name="classifieritemiattr" id="classifieritemform_classifieritemiattr" maxlength="5"  />     
     </div>
</div>
   
  </div>  
  </div>
  
 <div class="form-group">
     <label class="col-md-1 control-label fieldRequired"  >Descrizione</label>
     <div class="col-md-11 columns" >
          <textarea  class='form-control' name="classifieritemdescr" id="classifieritemform_classifieritemdescr" rows="2" ></textarea>  
     </div>
 </div>
  
 <div class="form-group">
     <label class="col-md-1 control-label "  >Sotto gruppi</label>
     <div class="col-md-11 columns" >
          <textarea  class='form-control' name="subgroups" id="classifieritemform_subgroups" rows="2" ></textarea>
     </div>
 </div>
  
    
  </form>
  
  <div class="form-action-bar">
        <button type="button" id="classifieritemform_action_save" class="btn btn-default" >
          <span>Salva</span>
        </button>

        <button type="button" id="classifieritemform_action_clear" class="btn btn-default" >
          <span>Pulisci</span>
        </button>            
   </div>
      
<!--   </div> -->
<!-- </div> -->


   

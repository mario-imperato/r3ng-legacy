<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.io.*,
    java.util.*
    "%>


<div class="panel tabbed-panel">
  <div class="panel-heading" >  
    <h3 class="panel-title" >Verifiche amministrative domanda di iscrizione</h3>
  </div>
  
  <div class="panel-body">
  <div class="action-bar position_top">

    <button type="button" id="adminapplicationactionform_action_clone" class="btn btn-default" >
      <span>Duplica Su Altro Evento</span>
    </button>
          
    <button type="button" id="adminapplicationactionform_action_view" class="btn btn-default" >
      <span>Visualizza Domanda Iscrizione</span>
    </button>

    <button type="button" id="adminapplicationactionform_action_edit" class="btn btn-default" >
      <span>Modifica Domanda Iscrizione</span>
    </button>
    
    <button type="button" id="adminapplicationactionform_action_delete" class="btn btn-danger">
      <span>Elimina Domanda Iscrizione</span>
    </button>
    
  </div>

 <div class="panel" id="adminapp_cloneform_actionform" style='display: none'>
    <div class="panel-body" >
    <p>E' possibile 'copiare' la domanda di iscrizione su un'altra regata. Si tenga conto che la domanda, successivamente, dovrà essere rivista
    in quanto l'operazione di copia funziona solo per le informazioni comuni ai due eventi.</p>
    
    <div id="adminapp_cloneform_fieldset_message" ></div>
    
    <form id="adminapp_cloneform_form" method="POST" class='form-horizontal form-small'>
    
 <div class="form-group">
     <label class="col-md-2  control-label fieldRequired"  >Regata Target</label>
     <div class="col-md-10" >
        <select name="cloneeventid" class='form-control' id="adminapp_cloneform_cloneeventid" ></select>
     </div>
 </div>
     
    </form>
    
     <div class="form-action-bar">
        <button type="button" id="adminapp_cloneform_action_submit" class="btn btn-default" >
          <span>Conferma Richiesta</span>
        </button>
        
        <button type="button" id="adminapp_cloneform_action_cancelsubmit" class="btn btn-default" >
          <span>Chiudi</span>
        </button>
    </div>
    </div>
  </div>
 
 
  </div>
</div>


 <div class="panel" >
    <div class="panel-body" >
    <div id="adminapplicationactionform_fieldset_message"></div>    
    <form id="adminapplicationactionform_form" method="POST" class='form-horizontal '>

 <div class="form-group">
     <label class="col-md-2  control-label fieldRequired"  >Stato compilazione</label>
     <div class="col-md-10" >
            <select class='form-control' name="completionstatus" id="adminapplicationactionform_completionstatus" >
            <option value="">-- Selezionare --</option>
            <!-- <option value="r3ea_empty">Non Compilata</option>  -->
            <option value="r3ea_draft" >Bozza</option>
            <option value="r3ea_commit">Chiusa</option>
            </select>        
     </div>
 </div>
 
  <div class="form-group">
     <label class="col-md-2  control-label fieldRequired"  >Stato accettazione</label>
     <div class="col-md-10" >
            <select class='form-control' name="verificationstatus" id="adminapplicationactionform_verificationstatus" ></select>        
     </div>
 </div>
 
  <div class="form-group">
     <label class="col-md-2  control-label "  >Annotazioni</label>
     <div class="col-md-10" >
            <textarea class='form-control' name="annotation" id="adminapplicationactionform_annotation"  rows="3" ></textarea>        
     </div>
  </div>
     
<div class="form-group">
     <label class="col-md-2  control-label "  >Verifiche</label>
     <div class="col-md-10 columns" id="adminapplicationactionform_adminchecks_cnt">
     </div>
</div>
     
    </form>

    <div class="form-action-bar">
    <button type="button" id="adminapplicationactionform_action_saveadminchecks" class="btn btn-default" >
      <span>Salva</span>
    </button>
    </div>
      
    </div>
 </div>
             
      

<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<div class="modal fade" id="org_r3_jsportlet_dialog_confirmationdialog" title="Conferma Operazione" role="dialog" aria-labelledby="gridSystemModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
<!--       <div class="modal-header"> -->
<!--         <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button> -->
<!--         <h4 class="modal-title" id="gridSystemModalLabel">Conferma Operazione</h4> -->
<!--       </div> -->
      <div class="modal-body">
      <div class="container-fluid">
       <p>Sei sicuro di voler cancellare gli elementi selezionati?</p>

        <form class='form-horizontal'>
		<div class="form-group" id="org_r3_jsportlet_dialog_confirmationdialog_opt_cnt">			
			<div class="col-md-12 columns">
			
			<label class='checkbox-inline' style='width: 100%; background-color: transparent'>
            <input id="org_r3_jsportlet_dialog_confirmationdialog_opt_delete" type="checkbox" value="btrue" name="confirmationdialog_opt" >
              Cancella Contatti da Rubrica
             </label>
			
			</div>
		</div>
        </form>

	   </div>
    </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Annulla</button>
        <button type="button" class="btn btn-primary" id='org_r3_jsportlet_dialog_confirmationdialog_actionconfirm'>OK</button>
      </div>
          
 </div>
</div>
</div>

    
<!-- <div id="org_r3_jsportlet_dialog_confirmationdialog" title="Conferma Operazione" class="r3_dialog"> -->

<!--     <p><span class='ui-icon ui-icon-alert' style='float: left; margin: 0 7px 20px 0;'></span><span>Sei sicuro di voler cancellare gli elementi selezionati?</span></p> -->
            
<!--     <div class="panel" style='margin-bottom: 0px'>         -->
<!--     <div class="panel_content"> -->
        
<!--     <div class="fieldset layout_classic cf"> -->
<!--       <div class="fieldset_group"> -->

<!--       <div class="fieldRow">         -->
<!--         <div class="fieldValueCell fieldHorizontalRadioGroup" style="width: 400px" id="org_r3_jsportlet_dialog_confirmationdialog_opt_cnt"> -->
<!--         <label style="display: block; width: 100%; float: left"> -->
<!--             <input id="org_r3_jsportlet_dialog_confirmationdialog_opt_delete" type="checkbox" value="btrue" name="confirmationdialog_opt" > -->
<!--               Cancella Contatti da Rubrica -->
<!--         </label> -->
        
<!--         </div> -->
<!--       </div> -->
      
<!--       </div> -->

<!--     </div> -->
<!--     </div> -->
<!--     </div> -->
    
<!-- </div> -->

<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.io.*,
    java.util.*
    "%>

<h4 >Verifica Flotta</h4> 
<!-- <div class="panel"> -->
<!--   <div class="panel-heading" >   -->
<!--     <h3 class="panel-title" >Verifica Flotta</h3> -->
<!--   </div> -->
  
<!--   <div class="panel-body"> -->


      <div class="action-bar position-top">
         <button type="button" class="btn btn-primary start" id="submitcrewcheckform_action_attendancesheetreport" >         
         <span>Rapporto Foglio Presenza</span>
         </button>
               
         <button type="button" class="btn btn-primary start" id="submitcrewcheckform_action_athletesreport" >         
         <span>Rapporto Atleti</span>
         </button>
               
         <button type="button" class="btn btn-primary start" id="submitcrewcheckform_action_fleetreport" >         
         <span>Rapporto Flotta</span>
         </button>
               
         <button type="button" class="btn btn-primary start" id="submitcrewcheckform_action_newcheck" >         
         <span>Richiedi verifica</span>
         </button>
      </div>            

    <div id="submitcrewcheckform_actionform" style='display: none'>
    <p>Per richiedere il controllo delle tessere e' necessario indicare il codice FIV del Circolo e la corrispondente parola chiave.</p>

    <div id="submitcrewcheckform_fieldset_message" ></div>

    <form id="submitcrewcheckform_form" method="POST" class='form-horizontal'>
    
 <div class="form-group">
    <label class="col-md-2  control-label fieldRequired">Id Accesso Sito FIV</label>
    <div class='col-md-4 '>
    <input type="text" class='form-control' name="yachtclubcode" id="submitcrewcheckform_yachtclubcode" maxlength="15" />
    </div>
  </div>

 <div class="form-group">
    <label class="col-md-2  control-label fieldRequired">Parola chiave sito FIV</label>
    <div class='col-md-4 '>
   <input type="password"  class='form-control' name="yachtclubpwd" id="submitcrewcheckform_yachtclubpwd" maxlength="15" />
    </div>
  </div>
    
 <div class="form-group">
    <label class="col-md-2  control-label fieldRequired">Conf. Parola chiave</label>
    <div class='col-md-4 '>
   <input type="password" class='form-control'  name="confirm_yachtclubpwd" id="submitcrewcheckform_confirm_yachtclubpwd" maxlength="15" />
    </div>
  </div>
      
    </form>
    
     <div class="form-action-bar">
        <button type="button" id="submitcrewcheckform_action_submit" class="btn btn-default" >
          <span>Conferma Richiesta</span>
        </button>
        
        <button type="button" id="submitcrewcheckform_action_cancelsubmit" class="btn btn-default" >
          <span>Chiudi</span>
        </button>
    </div>
  
     </div>    
     
<!--   </div> -->
<!-- </div> -->
 
            
             
      


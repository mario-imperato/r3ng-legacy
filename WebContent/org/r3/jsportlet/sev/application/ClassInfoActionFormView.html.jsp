<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

  
<div id="classinfoform_fieldset_message" ></div>
<form id="classinfoform_form" method="POST" class="form-horizontal">
  
  <ul class="list-group">
  <li class="list-group-item">
  <h4 style='margin-bottom: 15px'><span id="classinfoform_applicationid">&nbsp;</span> - Domanda di accesso al raggruppamento</h4>
  
   <div class="form-group">
     <label class="col-md-2 col-sm-3 control-label fieldRequired"  >Raggruppamento</label>
     <div class="col-md-10 col-sm-9 columns" id="classinfoform_racegroup_cnt"></div>
   </div>

   <div class="form-group">
     <label class="col-md-2 col-sm-3 control-label fieldRequired"  >Classifica</label>
     <div class="col-md-10 col-sm-9 columns" id="classinfoform_ranktype_cnt"></div>
   </div>
   
   <div class="form-group">
     <label class="col-md-2 col-sm-3 control-label fieldRequired"  >Certificati</label>
     <div class="col-md-10 col-sm-9 columns" id="classinfoform_rating_cnt"></div>
   </div>
   
   <div class="form-group" id='classinfoform_racegroupdecl_fieldrow'>
     <label class="col-md-2 col-sm-3 control-label "  >&nbsp;</label>
     <div class="col-md-10 col-sm-9 columns" id="classinfoform_racegroupdecl_cnt"></div>
   </div>
   
  </li>
  
  <li class="list-group-item" id='classinfoform_apptype_framedpanel'>
  <h4 style='margin-bottom: 15px'>Tipo iscrizione</h4>
  
   <div class="form-group">
     <label class="col-md-2 col-sm-3 control-label fieldRequired"  >Desidero iscrivermi</label>
     <div class="col-md-10 col-sm-9 columns" id="classinfoform_apptype_cnt"></div>
   </div>
    
  </li>
  
  <li class="list-group-item" style='display: none' id="classinfoform_grancrocieraorc_framedpanel">
  <h4 style='margin-bottom: 15px'>Dichiarazione Appartenenza alla categoria Gran Crociera</h4>
  
   <p>
   Sulla barca devono essere presenti quattro dei parametri sottoelencati, se si utilizzano vele a bassa tecnologia, altrimenti almeno cinque.
   </p>
    
   <div class="form-group">
     <label class="col-md-2 col-sm-3 control-label "  >Parametri</label>
     <div class="col-md-10 col-sm-9 columns" id="classinfoform_grancrocieraorc_cnt"></div>
   </div>
   
  </li>
  
  <li class="list-group-item">
  <h4 style='margin-bottom: 15px'>Dati Assicurazione</h4>
  
    <div class="form-group">
     <label class="col-md-2 col-sm-3 control-label fieldRequired"  >Assicurazione</label>
     <div class="col-md-10 col-sm-9 columns" >     
        <label class="checkbox-inline" style="width: 220px; ">
           <input id="classinfoform_haveinsurance_btrue" type="checkbox" value="btrue" name="prop_haveinsurance" />La mia assicurazione prevede la copertura in caso di Regate</label>
     </div>
   </div>
   
   <div class="form-group">
    <label class="col-md-2 col-sm-3 control-label fieldRequired"  >Compagnia Assicurazione</label>
    <div class='col-md-10 col-sm-9'>
     <input type="text"  class="form-control" name="prop_insuranceinstitution" id="classinfoform_insuranceinstitution" maxlength="30"  />
    </div>
   </div>
   
   <div class="form-group">
    <label class="col-md-2 col-sm-3 control-label fieldRequired"  >Numero polizza R.C.</label>
    <div class='col-md-10 col-sm-9'>
     <input type="text" class="form-control" name="prop_insuranceid" id="classinfoform_insuranceid" maxlength="30"  />
    </div>
   </div>
   
  </li>
  
  <li class="list-group-item">
  <h4 style='margin-bottom: 15px'>Esposizione pubblicit&agrave;</h4>
  
    <div class="form-group">
     <label class="col-md-2 col-sm-3 control-label "  >Esposizione pubblicit&agrave;</label>
     <div class="col-md-10 col-sm-9 columns" >     
        <label class="checkbox-inline" style="width: 220px; ">
           <input id="classinfoform_haveadvertising_btrue" type="checkbox" value="btrue" name="prop_haveadvertising">             
             La mia barca espone della pubblicità (quindi allego una copia della licenza FIV)
        </label>
     </div>
    </div>
   
  </li>
  </ul>
  
  <div class="form-action-bar">
        
    <button type="button" id="classinfoform_action_prev" class="btn btn-default">
     <span>Precedente</span>
    </button>

    <button type="button" id="classinfoform_action_next" class="btn btn-default">
      <span>Successivo</span>
    </button>
        
   </div>  
</form>

           

   
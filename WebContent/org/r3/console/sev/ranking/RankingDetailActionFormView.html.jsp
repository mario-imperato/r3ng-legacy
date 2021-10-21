<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.io.*,
    java.util.*
    "%>


  <h4 ><label class="fieldReadOnly" id="rankingdetailactionform_rankid"></label> Dettaglio Classifica</h4>
  
  <div id="rankingdetailactionform_fieldset_message"></div>
  <form id="rankingdetailactionform_form" method="POST" class='form-horizontal'>
  
  <div class='row'>
  <div class='col-md-6'>
 <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >Indice ordinamento</label>
     <div class="col-md-10" >
<input type="text" name="rankordering" class='form-control' id="rankingdetailactionform_rankordering" maxlength="10" />        
     </div>
 </div>
 
  <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >Raggrup.</label>
     <div class="col-md-10" >
<select name="rankinggroup"  class='form-control' id="rankingdetailactionform_rankinggroup"></select>        
     </div>
 </div>
 
  <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >Titolo</label>
     <div class="col-md-10" >
<input type="text" name="ranktitle"  class='form-control' id="rankingdetailactionform_ranktitle" maxlength="40" />        
     </div>
 </div>
 
  <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >Schema File Singola Prova</label>
     <div class="col-md-10" >
 <input type="text" name="racefilepattern"  class='form-control' id="rankingdetailactionform_racefilepattern" maxlength="60" />        
     </div>
 </div>
 
  <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >Schema File Classifica Generale</label>
     <div class="col-md-10" >
 <input type="text" name="overallfilepattern"  class='form-control' id="rankingdetailactionform_overallfilepattern" maxlength="60" />        
     </div>
 </div>
 
  </div>

  <div class='col-md-6'>

<div class="form-group">
     <label class="col-md-2 control-label "  >Tipo classifica</label>
     <div class="col-md-10 columns" >
      <label class='radio-inline'> 
                <input id="rankingdetailactionform_championship_btrue" type="radio" value="btrue" name="championship" > A Prove</label> 
      <label class='radio-inline'> 
                 <input id="rankingdetailactionform_championship_bfalse" type="radio" value="bfalse" name="championship" > Singola</label>     
     </div>
</div>

<div class="form-group">
     <label class="col-md-2 control-label "  >Rating</label>
     <div class="col-md-10 columns" >
              <label class='radio-inline'> 
                <input id="rankingdetailactionform_rating_rank_irc" type="radio" value="rank_irc" name="rating" > IRC</label> 
              <label class='radio-inline'> 
                 <input id="rankingdetailactionform_rating_rank_orc" type="radio" value="rank_orc" name="rating" > ORC</label>     
     </div>
</div>

 <div class="form-group">
     <label class="col-md-2 control-label "  >Raggrup.</label>
     <div class="col-md-10" >
                <select name="racegroup"  class='form-control' id="rankingdetailactionform_racegroup"></select>        
     </div>
 </div>
 
 <div class="form-group">
     <label class="col-md-2 control-label "  >Classe</label>
     <div class="col-md-10" >
                <select name="raceclass"  class='form-control' id="rankingdetailactionform_raceclass"></select>        
     </div>
 </div>
                
  </div>
  </div>
  
  </form>
  
    <div class="form-action-bar">
      <button type="button" id="rankingdetailactionform_action_saveitem" class="btn btn-default" >
        <span>Salva</span>
      </button>
      
      <button type="button" id="rankingdetailactionform_action_deleteitem" class="btn btn-danger" >
        <span>Elimina</span>
      </button>
            
    </div>
      






<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<div id="ownerinfoform_fieldset_message" ></div>  
<form id="ownerinfoform_form" method="POST" class="form-horizontal">
  
  <ul class="list-group">
  <li class="list-group-item">
  <h4 style='margin-bottom: 15px'><span id="ownerinfoform_applicationid">&nbsp;</span> - Armatore/Charterer</h4>
  
  <div class='row'><div class='col-md-7'>
  
  <div class="form-group">
    <label class="col-sm-4  control-label fieldRequired">Nome</label>
    <div class='col-sm-8 '>
    <input type="text" class="form-control" name="ownerfirstname" id="ownerinfoform_ownerfirstname" maxlength="30"  />
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-4  control-label fieldRequired">Cognome</label>
    <div class='col-sm-8 '>
    <input type="text" class="form-control" name="ownerlastname" id="ownerinfoform_ownerlastname" maxlength="30"  />
    </div>
  </div>

  <div class="form-group">
    <label class="col-sm-4  control-label fieldRequired">e-mail</label>
    <div class='col-sm-8 '>
    <input type="text" class="form-control" name="owneremail" id="ownerinfoform_owneremail" maxlength="50" />
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-4  control-label fieldRequired">Cellulare</label>
    <div class='col-sm-8 '>
    <input type="text" class="form-control" name="ownercellphone" id="ownerinfoform_ownercellphone" maxlength="15" />
    </div>
  </div>

  <div class="form-group">
    <label class="col-sm-4  control-label fieldRequired">Telefono</label>
    <div class='col-sm-8 '>
    <input type="text" class="form-control" name="ownerphone" id="ownerinfoform_ownerphone" maxlength="15" />
    </div>
  </div>
  </div>
  
  <div class='col-md-5'>
  <div class="form-group">
    <label class="col-sm-4  control-label fieldRequired">Indirizzo</label>
    <div class='col-sm-8 '>
     <input type="text" class="form-control" name="owneraddress" id="ownerinfoform_owneraddress" maxlength="30" />
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-4  control-label fieldRequired">Citt&agrave;</label>
    <div class='col-sm-8 '>
     <input type="text" class="form-control" name="ownertown" id="ownerinfoform_ownertown" maxlength="30" />
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-4  control-label fieldRequired">CAP</label>
    <div class='col-sm-8 '>
     <input type="text" class="form-control" name="ownerzipcode" id="ownerinfoform_ownerzipcode" maxlength="5" />
    </div>
  </div>
  
  </div>
  </div>
  </li>

  <li class="list-group-item">
  <h4 style='margin-bottom: 15px'>  
     <input id="ownerinfoform_havehelmsman_btrue" type="checkbox" value="btrue" name="prop_havehelmsman"> Timoniere diverso dall'armatore/charterer
  </h4>
  
  <div id="ownerinfoform_helmsmanpane">
  
  <div class='row'><div class='col-md-7'>
  <div class="form-group">
    <label class="col-sm-4  control-label fieldRequired">Nome</label>
    <div class='col-sm-8 '>
      <input type="text" class="form-control" name="helmsmanfirstname" id="ownerinfoform_helmsmanfirstname" maxlength="30" />
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-4  control-label fieldRequired">Cognome</label>
    <div class='col-sm-8 '>
      <input type="text" class="form-control" name="helmsmanlastname" id="ownerinfoform_helmsmanlastname" maxlength="30" />
        </div>
  </div>

  <div class="form-group">
    <label class="col-sm-4  control-label fieldRequired">e-mail</label>
    <div class='col-sm-8 '>
    <input type="text" class="form-control" name="helmsmanemail" id="ownerinfoform_helmsmanemail" maxlength="50" />
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-4  control-label fieldRequired">Cellulare</label>
    <div class='col-sm-8 '>
    <input type="text" class="form-control" name="helmsmancellphone" id="ownerinfoform_helmsmancellphone" maxlength="15" />
    </div>
  </div>

  <div class="form-group">
    <label class="col-sm-4  control-label fieldRequired">Telefono</label>
    <div class='col-sm-8 '>
    <input type="text" class="form-control" name="helmsmanphone" id="ownerinfoform_helmsmanphone" maxlength="15" />
    </div>
  </div>
  </div>
  
  <div class='col-md-5'>
  <div class="form-group">
    <label class="col-sm-4  control-label fieldRequired">Indirizzo</label>
    <div class='col-sm-8 '>
    <input type="text" class="form-control" name="helmsmanaddress" id="ownerinfoform_helmsmanaddress" maxlength="30" />
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-4  control-label fieldRequired">Citt&agrave;</label>
    <div class='col-sm-8 '>
    <input type="text" class="form-control" name="helmsmantown" id="ownerinfoform_helmsmantown" maxlength="30" />
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-4  control-label fieldRequired">CAP</label>
    <div class='col-sm-8 '>
    <input type="text" class="form-control" name="helmsmanzipcode" id="ownerinfoform_helmsmanzipcode" maxlength="5" />
    </div>
  </div>
  </div>
  </div>
  
  </div>  
  </li>
  </ul>
  
  
  <div class="form-action-bar">
        
         <button type="button" id="ownerinfoform_action_prev" class="btn btn-default">
          <span>Precedente</span>
        </button>

        <button type="button" id="ownerinfoform_action_next" class="btn btn-default">
          <span>Successivo</span>
        </button>
        
   </div> 
   
</form>



   
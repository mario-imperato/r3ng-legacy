<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<!-- 
<div class="panel panel-default">
  <div class="panel-heading" style='background: white'>  
    <h3 class="panel-title"></h3>
  </div>
  <div class="panel-body">
  -->
  
  <div id="boatinfoform_fieldset_message" ></div>
  
  <form id="boatinfoform_form" method="POST" class="form-horizontal">
  <input type='hidden' id='boatinfoform_mooringspec_validatorflag' name='mooringspec_validatorflag' value='N' />

  <ul class="list-group">
  <li class="list-group-item">
  <h4 style='margin-bottom: 15px'><span id="boatinfoform_applicationid">&nbsp;</span> - Informazioni Generali</h4>
  
  <div class='row'><div class='col-md-7'>
  
  <div class="form-group">
    <label class="col-sm-4 control-label">Targa</label>
    <div class='col-sm-8'>
    <input type="text" class="form-control" name="plate" id="boatinfoform_plate" maxlength="15"  />
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-4 control-label fieldRequired">Nome Imbarcazione</label>
    <div class='col-sm-8'>
    <input type="text" class="form-control"  name="yachtname" id="boatinfoform_yachtname" maxlength="30"  />
    </div>
  </div>

  <div class="form-group">
    <label class="col-sm-4 control-label fieldRequired">Circolo di appartenenza</label>
    <div class='col-sm-8'>
    <input type="text" class="form-control" name="yachtclub" id="boatinfoform_yachtclub" maxlength="30"  />
    </div>
  </div>

  <div class="form-group">
    <label class="col-sm-4 control-label fieldRequired">Tipo/Modello</label>
    <div class='col-sm-8'>
    <input type="text" class="form-control" name="yachttype" id="boatinfoform_yachttype" maxlength="30"  />
    </div>
  </div>
 
  <div class="form-group">
    <label class="col-sm-4 control-label ">Progettista</label>
    <div class='col-sm-8'>
    <input type="text" class="form-control" name="prop_designer" id="boatinfoform_designer" maxlength="30"  />
    </div>
   </div>
 
  <div class="form-group">
    <label class="col-sm-4 control-label ">Cantiere</label>
    <div class='col-sm-8'>
    <input type="text" class="form-control" name="prop_yardship" id="boatinfoform_yardship" maxlength="50"  />
    </div>
   </div>
  
  <div class="form-group">
    <label class="col-sm-4 control-label fieldRequired">Anno di costruzione</label>
    <div class='col-sm-8'>
     <select name="prop_year" class="form-control"  id="boatinfoform_year"  >
            <option key="">-- Selezionare l'anno di costruzione --</option>
        <%
            for(int i = Calendar.getInstance().get(Calendar.YEAR); i > 1970; i--)
            {
        %>
             <option id="<%=String.valueOf(i)%>" ><%=String.valueOf(i)%></option>             
        <%
            }
        %>            
     </select>
    </div>
   </div>

  <div class="form-group">
    <label class="col-sm-4 control-label ">Porto di provenienza</label>
    <div class='col-sm-8'>
     <input type="text" class="form-control" name="prop_harbour" id="boatinfoform_harbour" maxlength="30"  />
    </div>
   </div>

  <div class="form-group">
    <label class="col-sm-4 control-label fieldRequired">Ormeggio durante la manifestazione</label>
    <div class='col-sm-8'>
     <select name="mooringloc" class="form-control" id="boatinfoform_mooringloc" ></select>
    </div>
   </div>

  <div class="form-group">
    <label class="col-sm-4 control-label fieldRequired" id="boatinfoform_mooringspec_label" >Dettaglio Posto di ormeggio</label>
    <div class='col-sm-8'>
     <input type="text" class="form-control" name="prop_mooringspec" id="boatinfoform_mooringspec" maxlength="50"  />
    </div>
   </div>
   
   </div>
   
   <div class='col-md-5'>
   
   <div class="form-group">
    <label class="col-sm-4 control-label fieldRequired"  >No Velico (es. ITA15083)</label>
    <div class='col-sm-8'>
     <input type="text" class="form-control" name="sailnumber" id="boatinfoform_sailnumber" maxlength="10"  />
    </div>
   </div>

   <div class="form-group">
    <label class="col-sm-4 control-label "  >Colore scafo</label>
    <div class='col-sm-8'>
     <input type="text" class="form-control" name="prop_hullcolor" id="boatinfoform_hullcolor" maxlength="10"  />
    </div>
    </div>
      
    <div class="form-group">
    <label class="col-sm-4 control-label "  >Lung. fuori tutto</label>
    <div class='col-sm-8'>
     <input type="text" class="form-control" name="prop_loa" id="boatinfoform_loa" maxlength="10" />
    </div>
    </div>

    <div class="form-group">
    <label class="col-sm-4 control-label "  >Lung. Gallegg.</label>
    <div class='col-sm-8'>
     <input type="text" class="form-control" name="prop_lwl" id="boatinfoform_lwl" maxlength="10" />
    </div>
    </div>
     
    <div class="form-group">
    <label class="col-sm-4 control-label "  >Pescaggio</label>
    <div class='col-sm-8'>
     <input type="text" class="form-control" name="prop_draft" id="boatinfoform_draft" maxlength="10" />
    </div>
    </div>

    <div class="form-group">
    <label class="col-sm-4 control-label "  >Baglio Max.</label>
    <div class='col-sm-8'>
     <input type="text" class="form-control" name="prop_beam" id="boatinfoform_beam" maxlength="10" />
    </div>
    </div>
   </div>
   </div>
        
    </li>
  <li class="list-group-item" id="boatinfoform_sailcloth_framedpanel"><h4 style='margin-bottom: 15px'>Materiale di costruzione delle vele</h4>
     
   <div class="form-group">
     <label class="col-sm-4 control-label "  >Materiale delle Vele</label>
     <div class="col-sm-8 columns" id="boatinfoform_sailmaterial_cnt"></div>
   </div>
        
   <div class="form-group">
     <label class="col-sm-4 control-label"  >Altro (Specifica)</label>
     <div class="col-sm-8" >     
		<input type="text"  class="form-control" name="prop_sailmaterialelse" id="boatinfoform_sailmaterialelse" maxlength="30"  />
     </div>
   </div>
      
  </li>
  <li class="list-group-item" id="boatinfoform_otherinfo_framedpanel"><h4 style='margin-bottom: 15px'>Altre caratteristiche</h4>
  
    <div id='boatinfoform_otherfeatures_cnt'>
    </div>
   
<!--     <div class="form-group"> -->
<!--     <label class="col-sm-4 control-label "  >Albero, Appendici e/o parti di scafo in carbonio</label> -->
<!--     <div class='col-sm-8'> -->
<!--      <input type="text" class="form-control" name="prop_carbonstruct" id="boatinfoform_carbonstruct" maxlength="30"  /> -->
<!--     </div> -->
<!--     </div> -->

<!--     <div class="form-group"> -->
<!--     <label class="col-sm-4 control-label "  >Altre modifiche alle appendici generali</label> -->
<!--     <div class='col-sm-8'> -->
<!--      <input type="text" class="form-control"  name="prop_otherchanges" id="boatinfoform_otherchanges" maxlength="30"  /> -->
<!--     </div> -->
<!--     </div> -->
  
  </li>
  </ul>
      
   <div class="form-action-bar">
        
         <button type="button" id="boatinfoform_action_prev" class="btn btn-default">
          <span>Precedente</span>
        </button>

        <button type="button" id="boatinfoform_action_next" class="btn btn-default">
          <span>Successivo</span>
        </button>
        
   </div>       
   
   </form>
  
  <!-- 
  </div>
</div>  -->
  
            
   <!--      
       <label class="fieldRequired fieldLabel" style="width: 250px;" for="company">Materiale di costruzione delle vele</label>
        <div class="fieldValueCell">
          <div class="fieldValueCell fieldHorizontalRadioGroup" style="width: 380px" id="boatinfoform_sailmaterial_cnt"></div>
        </div>

-->


   
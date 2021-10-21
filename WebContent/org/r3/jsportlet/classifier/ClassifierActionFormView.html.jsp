<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<div id="classifier_infoLine"></div>

<div class="panel panel-light" id="classifierform_form_panel" style='display: none'>
  <div class="panel-heading" >  
    <h3 class="panel-title" id="classifierform_form_panel_legend_close"><a href="javascript:void(0)">Gruppo di Classificazione: <span id="classifierform_clsid"></span></a></h3>
  </div>
  
  <div class="panel-body">
  <div id="classifierform_fieldset_message" ></div>
  <form id="classifierform_form" method="POST" class='form-horizontal'>
  
  <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >Descrizione</label>
     <div class="col-md-10" >
        <textarea  name="clsdescr" class='form-control' id="classifierform_clsdescr" rows="2" ></textarea>
     </div>
  </div>
 
  </form>
  
  <div class="form-action-bar" >
        <button type="button" id="classifierform_action_save" class="btn btn-default" >
          <span>Salva</span>
        </button>            
    </div>
  
  </div>
</div>


   
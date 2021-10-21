<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<div class="panel tabbed-panel">
  <div class="panel-heading" style='background: white'>  
    <h3 class="panel-title" >{%=org.r3.console.siteconfig.site.message.sitefileactionform_form_legend%}  <span id='sitefileactionform_form_cardid_label'></span></h3>
  </div>
  
  <div class="panel-body">

  <div id="sitefileactionform_fieldset_message"></div>
  
  <!-- Container per oggetti di tipo image. -->
  <div id="sitefileactionform_detail_container" class='panel' style='display: none'>
  <div class="panel-body">
    
  <form id="sitefileactionform_form" class='form-horizontal'>
  <input  type="hidden" name="propertyid" id="sitefileactionform_form_propertyid" />
  <input  type="hidden" name="propertytypecode" id="sitefileactionform_form_propertytypecode" />
 
    
    <div class='row'>
    <div class='col-md-2'>
    <div id="sitefileactionform_form_icon" ></div>
    </div>
    
    <div class='col-md-10'>

    <div class="form-group">
    <label class="col-md-2  control-label fieldRequired">{%=org.r3.db.cms.cardproperty.message.propertyname%}</label>
    <div class='col-md-10 '>
    <input name="propertyname" class='form-control'  id="sitefileactionform_form_propertyname" type="text" maxlength="80" />
    </div>
    </div>

    <div class="form-group">
    <label class="col-md-2  control-label fieldRequired">{%=org.r3.db.cms.cardproperty.message.propertytypesize%}</label>
    <div class='col-md-10 '>
     <label class="control-label" id="sitefileactionform_form_propertytypesize">&nbsp;</label>
    </div>
    </div>
    
    <div class="form-group">
    <label class="col-md-2  control-label fieldRequired">{%=org.r3.db.cms.cardproperty.message.propertyvalue%}</label>
    <div class='col-md-10 '>
    <label class="control-label fieldLink" id="sitefileactionform_form_propertyvalue" style='overflow: hidden'>&nbsp;</label>
    </div>
    </div>

    <div class="form-group">
    <label class="col-md-2  control-label fieldRequired">{%=org.r3.db.cms.cardproperty.message.url%}</label>
    <div class='col-md-10 '>
    <label class="control-label" id="sitefileactionform_form_url" style='overflow: hidden'>&nbsp;</label>
    </div>
    </div>         
        
    </div>    
    </div>               
    </form>
    
    <div class="form-action-bar" id="sitefileactionform_action_bar" style="display: none">
        <button type="button" id="sitefileactionform_action_saveitem" class="btn btn-default" >
          <span>{%=org.r3.message.action_save%}</span>
        </button>

        <button type="button" id="sitefileactionform_action_ctlcurl" class="btn btn-default" >
          <span>{%=org.r3.message.action_copyurl2clipboard%}</span>
        </button>       

    </div>
    </div>
     
    </div>

<div class='row'>
<div class='col-md-10'>
    <table id="CardSiteFileQueryActionFormView" style='width: 100%' class="table table-striped table-bordered table-hover {%=o.gradeLevel%}" >
        <tbody>
        </tbody>
    </table>
</div>

<div class='col-md-2'>
    
    {% for(var i = 0; i < o.buttons.length; i++) { %}
    <button type="button" class="btn btn-primary start btn-block" id="{%=o.buttons[i].id%}"{% if (o.buttons[i].disabled) { %} disabled {% } %} >
      <span>{%=o.buttons[i].label%}</span>
    </button>
    {% } %}
    
</div>
</div>

</div>
</div>

    
                  


    
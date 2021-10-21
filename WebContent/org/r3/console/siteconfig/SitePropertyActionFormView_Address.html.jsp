<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
  
  
<div class="panel tabbed-panel">
  <div class="panel-heading" style='background: white'>  
    <h3 class="panel-title">{%#org.r3.console.siteconfig.message.address_panel_title%}</h3>
  </div>
  <div class="panel-body">
  <p>{%#org.r3.console.siteconfig.message.address_panel_info%}</p>
  <div id="addressform_fieldset_message" ></div>
  
  <form id="addressform_form" method="POST" class="form-horizontal">
  <input type='hidden' name='street_number' id='addressform_street_number' />
  <input type='hidden' name='locality' id='addressform_locality' />
  <input type='hidden' name='route' id='addressform_route' />
  <input type='hidden' name='administrative_area_level_3' id='addressform_administrative_area_level_3' />
  <input type='hidden' name='administrative_area_level_2' id='addressform_administrative_area_level_2' />
  <input type='hidden' name='administrative_area_level_1' id='addressform_administrative_area_level_1' />
  <input type='hidden' name='country' id='addressform_country' />
  <input type='hidden' name='postal_code' id='addressform_postal_code' />
  <input type='hidden' name='location' id='addressform_location' />
  <input type='hidden' name='northeast' id='addressform_northeast' />
  <input type='hidden' name='southwest' id='addressform_southwest' />
  <input type='hidden' name='place_id' id='addressform_place_id' />
  <input type='hidden' name='formatted_address' id='addressform_formatted_address' />
  
  <div class="form-group">
    <label class="col-sm-2 control-label fieldRequired">{%#org.r3.console.siteconfig.message.address_district%}</label>
    <div class='col-sm-10'>
    <select name="administrative_area_level_1_id" class="form-control" id="addressform_administrative_area_level_1_id" ></select>
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-2 control-label fieldRequired">{%#org.r3.console.siteconfig.message.address_county%}</label>
    <div class='col-sm-10'>
    <select name="administrative_area_level_2_id" class="form-control" id="addressform_administrative_area_level_2_id" ></select>
    </div>
  </div>
    
  <div class="form-group">
    <label class="col-sm-2 control-label fieldRequired">{%#org.r3.console.siteconfig.message.address_town%}</label>
    <div class='col-sm-10'>
    <select name="administrative_area_level_3_id" class="form-control" id="addressform_administrative_area_level_3_id" ></select>
    </div>
  </div>
      
  <div class="form-group">
    <label class="col-sm-2 control-label fieldRequired">{%#org.r3.console.siteconfig.message.address_zipcode%}</label>
    <div class='col-sm-10'>
    <input name="zipcode" class="form-control" id="addressform_zipcode" type="text" maxlength="5"/>
    </div>
  </div>

  <div class="form-group">
    <label class="col-sm-2 control-label fieldRequired">{%#org.r3.console.siteconfig.message.address_address%}</label>
    <div class='col-sm-10'>
     <input name="address" class="form-control" id="addressform_address" type="text" maxlength="40"/>
    </div>
  </div>
  </form>  
  
  <div class="form-action-bar">
        <button type="button" id="addressform_action_save" class="btn btn-default" >
          <span>{%#org.r3.message.action_confirm_request%}</span>
        </button>
  </div>   
  
  <div id="addressform_leafletmap" style='height: 300px;'></div> 
     
 
  
  </div>
</div>
  
    
 
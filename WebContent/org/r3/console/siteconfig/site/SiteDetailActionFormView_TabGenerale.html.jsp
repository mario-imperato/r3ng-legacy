<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
<div class="panel tabbed-panel">
  <div class="panel-heading" >  
    <h3 class="panel-title">{%=org.r3.db.system.site.message.detailactionformview_legend%}</h3>
  </div>
  
  <div class="panel-body">
  <div id="sitedetailactionform_fieldset_message" ></div>  
  <form id="sitedetailactionform_form" class='form-horizontal'>
  
   <div class="form-group">
    <label class="col-md-2  control-label fieldRequired">{%=org.r3.console.siteconfig.site.message.siteDetailActionForm_urlhome%}</label>
    <label class="col-md-10 control-label fieldLink" style='text-align: left' id="regattadetailactionform_form_urlhome" style='overflow: hidden'>&nbsp;</label>
    </div>
              
    <div class="form-group">
    <label class="col-md-2  control-label fieldRequired ">{%=org.r3.console.siteconfig.site.message.siteDetailActionForm_urlhomeconsole%}</label>
    <label class="col-md-10 control-label fieldLink" style='text-align: left' id="regattadetailactionform_form_urlhomeconsole" style='overflow: hidden'>&nbsp;</label>
    </div> 
 
    <div class='row'>
    <div class='col-md-6'>
    <div class="form-group">
	    <label class="col-md-4 control-label fieldRequired ">{%=org.r3.db.system.site.message.site%}</label>
	    <div class='col-md-8'><input type="text" class='form-control' name="site" id="regattadetailactionform_site" maxlength="15"  /></div>
	</div>

    <div class="form-group">
	    <label class="col-md-4 control-label fieldRequired ">{%=org.r3.db.system.site.message.sitedescr%}</label>
	    <div class='col-md-8'><input type="text" class='form-control' name="sitedescr" id="regattadetailactionform_sitedescr" maxlength="40"  /></div>
	</div>
	
	<div class="form-group">
	    <label class="col-md-4 control-label fieldRequired ">{%=org.r3.db.system.site.message.eventdescr%}</label>
	    <div class='col-md-8'><input type="text" class='form-control' name="eventdescr" id="regattadetailactionform_eventdescr" maxlength="40"  /></div>
	</div>
	</div>
	
	<div class='col-md-6'>    
    <div class="form-group">
	    <label class="col-md-4 control-label fieldRequired ">{%=org.r3.db.system.site.message.siteresourcepath%}</label>
	    <div class='col-md-8'><select name='siteresourcepath' class='form-control' id="regattadetailactionform_siteresourcepath">
             <option value='default'>{%=org.r3.db.system.site.message.siteresourcepath_default%}</option>
          </select>
	    </div>
	</div>
        
    <div class="form-group">
	    <label class="col-md-4 control-label fieldRequired ">{%=org.r3.db.system.site.message.sitetheme%}</label>
	    <div class='col-md-8'><select name='sitetheme' class='form-control' id="regattadetailactionform_sitetheme">
             <option value=''>{%=org.r3.db.system.site.message.sitetheme_none%}</option>
             <option value='skin-blue'>{%=org.r3.db.system.site.message.sitetheme_skin_blue%}</option>
             <option value='skin-red'>{%=org.r3.db.system.site.message.sitetheme_skin_red%}</option>
             <option value='skin-yellow'>{%=org.r3.db.system.site.message.sitetheme_skin_yellow%}</option>
             <option value='skin-purple'>{%=org.r3.db.system.site.message.sitetheme_skin_purple%}</option>
             <option value='skin-green'>{%=org.r3.db.system.site.message.sitetheme_skin_green%}</option>
             <option value='skin-black'>{%=org.r3.db.system.site.message.sitetheme_skin_black%}</option>
             <option value='skin-darkgray'>{%=org.r3.db.system.site.message.sitetheme_skin_darkgray%}</option>                               
          </select>
	    </div>
	</div>
	</div>
	</div>
        
  </form>  
  

              
    <div class="form-action-bar">
    
      <button type="button" class="btn  btn-default" id="sitedetailactionform_action_saveitem" >
        <span>{%=org.r3.message.action_save%}</span>
      </button>
    
    </div>
  
  </div>
</div>

                             
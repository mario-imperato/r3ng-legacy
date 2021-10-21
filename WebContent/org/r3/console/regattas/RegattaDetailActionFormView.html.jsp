<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
<div class="panel panel-light">
  <div class="panel-heading" >  
    <h3 class="panel-title">{%=org.r3.db.system.site.message.detailactionformview_legend%}</h3>
  </div>
  
  <div class="panel-body">
  <div id="regattadetailactionform_fieldset_message" ></div>
  <form id="regattadetailactionform_form" method="POST" class='form-horizontal'>
  
    <div class='cf hide_on_create' style="margin-bottom: 10px" >
    <div class="formmessageCanvas info" >{%=org.r3.console.regattas.message.regattadetailactionform_formmessage%}</div>
     
    <div class="form-group">
    <label class="col-md-2  control-label fieldRequired">{%=org.r3.console.regattas.message.regattadetailactionform_urlhome%}</label>
    <label class="col-md-10 control-label fieldLink" style='text-align: left' id="regattadetailactionform_form_urlhome" style='overflow: hidden'>&nbsp;</label>
    </div>
              
    <div class="form-group">
    <label class="col-md-2  control-label fieldRequired ">{%=org.r3.console.regattas.message.regattadetailactionform_urlhomeconsole%}</label>
    <label class="col-md-10 control-label fieldLink" style='text-align: left' id="regattadetailactionform_form_urlhomeconsole" style='overflow: hidden'>&nbsp;</label>
    </div>     
    </div>
      
    <div class="row">
    <div class='col-md-12'>

     <div class="form-group">
     <label class="col-md-2 control-label "  >{%=org.r3.db.system.site.message.options%}</label>
     <div class="col-md-10 columns" id="regattadetailactionform_options_cnt">
        <label class="checkbox-inline" style="width: 220px; ">
           <input id="regattadetailactionform_options_gsidebar" type="checkbox" value="gsidebar" name="options" />{%=org.r3.db.system.site.message.options_gsidebar%}</label>

        <label class="checkbox-inline" style="width: 220px; ">
           <input id="regattadetailactionform_options_profile1" type="checkbox" value="profile1" name="options" />{%=org.r3.db.system.site.message.options_profile1%}</label>               
     </div>
     </div>
    </div>
    </div>
    
    <div class="row">
    <div class='col-md-6'> 
     
	 <div class="form-group">
	    <label class="col-md-4 control-label fieldRequired ">{%=org.r3.db.system.site.message.sitetype%}</label>
	    <div class='col-md-8'>
	    <select name='sitetype' class='form-control' id="regattadetailactionform_sitetype"></select>
	    </div>
	  </div>
	  
     <div class="form-group">
	    <label class="col-md-4 control-label fieldRequired ">{%=org.r3.db.system.site.message.site%}</label>
	    <div class='col-md-8'>
	    <input type="text" name="site" class='form-control' id="regattadetailactionform_site" maxlength="15"  />
	    </div>
	  </div>
	
     <div class="form-group">
     <label class="col-md-4 control-label "  >{%=org.r3.db.system.site.message.sitedomain%}</label>
     <div class="col-md-8 columns" id="regattadetailactionform_sitedomain_cnt">
        <label class="checkbox-inline" style="width: 220px; ">
           <input id="regattadetailactionform_sitedomain_primary" type="checkbox" value="primary" name="sitedomain_opt" />{%=org.r3.db.system.site.message.sitedomain_primary%}</label>                 
     </div>
     </div>
                    
     </div>
     
     <div class='col-md-6'>  
    
     <div class="form-group">
	    <label class="col-md-4 control-label fieldRequired ">{%=org.r3.db.system.site.message.sitedescr%}</label>
	    <div class='col-md-8'>
	    <input type="text" name="sitedescr" class='form-control' id="regattadetailactionform_sitedescr" maxlength="40"  />
	    </div>
	  </div>
	      
     <div class="form-group">
	    <label class="col-md-4 control-label fieldRequired ">{%=org.r3.db.system.site.message.eventdescr%}</label>
	    <div class='col-md-8'>
	    <input type="text" name="eventdescr" class='form-control' id="regattadetailactionform_eventdescr" maxlength="40"  />
	    </div>
	 </div>

     <div class="form-group">
	    <label class="col-md-4 control-label fieldRequired ">{%=org.r3.db.system.site.message.siteresourcepath%}</label>
	    <div class='col-md-8'>
	      <select name='siteresourcepath' class='form-control' id="regattadetailactionform_siteresourcepath">
             <option value='default'>{%=org.r3.db.system.site.message.siteresourcepath_default%}</option>
             <option value='workshop'>{%=org.r3.db.system.site.message.siteresourcepath_workshop%}</option>
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
    
    <hr />
    
    <div class='row'>
    <div class='col-md-6'>

		 <div class="form-group">
		    <label class="col-md-4 control-label fieldRequired ">{%=org.r3.db.system.site.message.refsitevisible%}</label>
		    <div class='col-md-8 columns'>
		    <label class="radio-inline"> 
                <input id="regattadetailactionform_form_refsitevisible_btrue" type="radio" value="btrue" name="refsitevisible" > {%=org.r3.message.boolean_btrue%}</label> 
              <label class="radio-inline"> 
                 <input id="regattadetailactionform_form_refsitevisible_bfalse" type="radio" value="bfalse" name="refsitevisible" > {%=org.r3.message.boolean_bfalse%}</label>
		    </div>
		  </div>
              
          <div class="form-group">
		    <label class="col-md-4 control-label fieldRequired ">{%=org.r3.db.system.site.message.refsitetype%}</label>
		    <div class='col-md-8 columns'>
              <label class="radio-inline">
                <input name="refsitetype" id="regattadetailactionform_form_refsitetype_site_none" type="radio" value="site_none" checked /> {%=org.r3.db.system.site.message.refsitetype_site_none%}</label> 
              <label class="radio-inline">
                <input name="refsitetype" id="regattadetailactionform_form_refsitetype_site_internal" value="site_internal" type="radio" /> {%=org.r3.db.system.site.message.refsitetype_site_internal%}</label> 
              <label class="radio-inline">
                <input name="refsitetype" id="regattadetailactionform_form_refsitetype_site_external" value="site_external" type="radio" /> {%=org.r3.db.system.site.message.refsitetype_site_external%}</label>
		    </div>
		  </div>
		                
		 <div class="form-group">
		    <label class="col-md-4 control-label fieldRequired ">{%=org.r3.db.system.site.message.refsite%}</label>
		    <div class='col-md-8'>
		    <input name="refsite" class='form-control' id="regattadetailactionform_form_refsite" type="text"  maxlength="128" />
		    </div>
		  </div>

		 <div class="form-group">
		    <label class="col-md-4 control-label  fieldRequired">{%=org.r3.db.system.site.message.refsitedescr%}</label>
		    <div class='col-md-8'>
		    <input name="refsitedescr" class='form-control' id="regattadetailactionform_form_refsitedescr" type="text"  maxlength="128" />
		    </div>
		  </div>

    </div>
    <div class='col-md-6'>
          
          <div class="form-group">
		    <label class="col-md-4 control-label  fieldRequired">{%=org.r3.db.system.site.message.admrefsitevisible%}</label>
		    <div class='col-md-8 columns'>
              <label class="radio-inline"> 
                <input id="regattadetailactionform_form_admrefsitevisible_btrue" type="radio" value="btrue" name="admrefsitevisible" > {%=org.r3.message.boolean_btrue%}</label> 
              <label class="radio-inline"> 
                 <input id="regattadetailactionform_form_admrefsitevisible_bfalse" type="radio" value="bfalse" name="admrefsitevisible" > {%=org.r3.message.boolean_bfalse%}</label>             
		    </div>
		  </div>
		  
          <div class="form-group">
		    <label class="col-md-4 control-label  fieldRequired ">{%=org.r3.db.system.site.message.admrefsitetype%}</label>
		    <div class='col-md-8 columns'>
              <label class="radio-inline">
                <input name="admrefsitetype" id="regattadetailactionform_form_admrefsitetype_site_none" type="radio" value="site_none" checked /> {%=org.r3.db.system.site.message.admrefsitetype_site_none%}</label> 
              <label class="radio-inline">
                <input name="admrefsitetype" id="regattadetailactionform_form_admrefsitetype_site_internal" value="site_internal" type="radio" /> {%=org.r3.db.system.site.message.admrefsitetype_site_internal%}</label> 
              <label class="radio-inline">
                <input name="admrefsitetype" id="regattadetailactionform_form_admrefsitetype_site_external" value="site_external" type="radio" /> {%=org.r3.db.system.site.message.admrefsitetype_site_external%}</label>
            </div>
		 </div>

		 <div class="form-group">
		    <label class="col-md-4 control-label  fieldRequired">{%=org.r3.db.system.site.message.admrefsite%}</label>
		    <div class='col-md-8'>
		    <input name="admrefsite" class='form-control' id="regattadetailactionform_form_admrefsite" type="text"  maxlength="128" />
		    </div>
		  </div>

		 <div class="form-group">
		    <label class="col-md-4 control-label  fieldRequired">{%=org.r3.db.system.site.message.admrefsitedescr%}</label>
		    <div class='col-md-8'>
		    <input name="admrefsitedescr" class='form-control' id="regattadetailactionform_form_admrefsitedescr" type="text"  maxlength="128" />
		    </div>
		  </div>		 

    </div>
    </div>
  </form>
  
  <div class="form-action-bar">
        <button type="button" id="regattadetailactionform_action_saveitem" class="btn btn-default" >
          <span>{%=org.r3.message.action_save%}</span>
        </button>
        
        <button type="button" id="regattadetailactionform_form_action_cancel" class="btn btn-default" >
          <span>{%=org.r3.message.action_cancel%}</span>
        </button>
        
        <button type="button" id="regattadetailactionform_action_delete" class="btn btn-default" >
          <span>{%=org.r3.message.action_delete%}</span>
        </button>                        
  </div>
  
  </div>
</div>




<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
<div class="panel panel-light">
  <div class="panel-heading" >  
    <h3 class="panel-title">{%=org.r3.shkadmin.siteconfig.message.siteinfoactionformview_legend%}</h3>
  </div>
  
  <div class="panel-body">
  <div id="siteinfoactionform_fieldset_message" ></div>
  <form id="siteinfoactionform_form" method="POST" class='form-horizontal'>
          
    <div class="row">
    <div class='col-md-12'>
 	  
     <div class="form-group">
	    <label class="col-md-2 control-label fieldRequired ">{%=org.r3.db.mongo.sitecollection.message.site%}</label>
	    <div class='col-md-10'>
	    <input type="text" name="site" class='form-control' id="siteinfoactionform_site" maxlength="15"  />
	    </div>
	  </div>
	
     <div class="form-group">
	    <label class="col-md-2 control-label fieldRequired ">{%=org.r3.db.mongo.sitecollection.message.summary%}</label>
	    <div class='col-md-10'>
	    <textarea name="summary" class='form-control' id="siteinfoactionform_summary" rows='8'>
	    </textarea>
	    </div>
	  </div>
               
     </div>
     
	
    </div>
    
  </form>
  
  <div class="form-action-bar">
        <button type="button" id="siteinfoactionform_action_saveitem" class="btn btn-default" >
          <span>{%=org.r3.message.action_save%}</span>
        </button>                                
  </div>
  
  </div>
</div>




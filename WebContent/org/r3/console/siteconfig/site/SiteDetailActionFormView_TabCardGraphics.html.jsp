<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.io.*,
    java.util.*
    "%>

<div class="panel tabbed-panel">
	<div class="panel-heading" style='background: white'>
		<h3 class="panel-title">{%=org.r3.console.siteconfig.site.message.sitefileactionform_form_legend%}</h3>
	</div>

	<div class="panel-body">
		<div id="sitegraphicsactionform_fieldset_message"></div>
		<div class="panel-body">
		<div class='row'>
		<div class='col-md-12'>
			<div class="form-group">
				<label class="col-md-2  control-label fieldRequired">{%=org.r3.console.siteconfig.site.message.graphicsactionform_cms_attachtype%}</label>
				<div class='col-md-10 '>
					<select name="cms_attachtype" class='form-control'
						id="graphicsactionform_cms_attachtype"></select>
				</div>
			</div>
		</div>
		</div>
		</div>
	</div>
	
	<div id='graphicActionForm'>
	<div class="panel tabbed-panel">
  		<div class="panel-heading" >  
    		<h3 class="panel-title">Upload Immagini</h3>
  		</div>
  
  		<div class="panel-body">
    	<div class='row'>    
    	<div class='col-md-12' id='graphicsactionform_uploadimage_canvas'></div>
    	</div>
    	</div>    	
    </div>
    	
	</div>
</div>






<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env" namespace='org.r3.console.siteconfig'>


	<div class="row">
		<div class="col-md-12">
			<div id='addressActionForm' class="actionForm"></div>
			<div id='siteInfoActionForm' class="actionForm"></div>
            <div id='adminsActionForm' class="actionForm"></div>
            <div id='listOfAdminsActionForm' class="actionForm"></div>
			<div id="facebookConfigActionForm" class="actionForm"></div>

			<div id='imageUploadActionForm' class="actionForm" style='display: none'>

				<div class="panel panel-default">
					<div class="panel-heading" style='background: white'>
						<h3 class="panel-title">Immagine Profilo</h3>
					</div>

					<div class="panel-body">
					
					<div class='imageUploadGraphicCanvas'></div>
					</div>

				</div>
			</div>
		</div>
	</div>

</r3_lang:environment>        
<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.io.*,
    java.util.*
    "%>

<div class="panel panel-light">
	
	<div class="panel-heading">
		<h3 class="panel-title">{%=org.r3.shkadmin.siteconfig.message.facebookconfigactionformview_legend%}</h3>
	</div>

	<div class="panel-body">
	
		<div id="facebookconfigform_fieldset_message"></div>

		<div class='hidewhenacquiringtoken'>
			<form id="facebookconfigform_form" method="POST"
				class='form-horizontal'>

				<div class="row">
					<div class='col-md-12'>

						<div class="form-group">
							<label class="col-md-2 control-label fieldRequired ">{%=org.r3.shkadmin.siteconfig.message.facebook_pageurl%}</label>
							<div class='col-md-10'>
								<input type="text" name="prop_pageurl" class='form-control'
									id="pkg_facebook_pageurl" maxlength="100" />
							</div>
						</div>

					</div>

				</div>
			</form>

			<div class="form-action-bar">
				<button type="button" id="facebookconfigform_action_saveitem"
					class="btn btn-default">
					<span>{%=org.r3.message.action_save%}</span>
				</button>

			</div>

		</div>

		<form id="getfacebookpagetokenform_form" method="POST" class='form-horizontal'>
            <input type='hidden' name="fbuserid" id="getfacebookpagetokenform_fbuserid">
            <input type='hidden' name="fbaccesstoken" id="getfacebookpagetokenform_fbaccesstoken">
            <input type='hidden' name="fbpagename" id="getfacebookpagetokenform_fbpagename">
            <input type='hidden' name="fbpagetoken" id="getfacebookpagetokenform_fbpagetoken">
            
			<div class="row">
				<div class='col-md-12'>

					<div>
						<p>Explanation of what is going on...</p>
					</div>

					<div class="form-group hidewhenacquiringtoken">
						<label class="col-md-2 control-label fieldRequired ">{%=org.r3.shkadmin.siteconfig.message.facebook_pageid%}</label>
						<div class='col-md-10'>
							<input type="text" name="prop_fbpageid" class='form-control'
								id="pkg_facebook_fbpageid" maxlength="15" readonly />
						</div>
					</div>

					<div class="form-group hidewhenacquiringtoken">
						<label class="col-md-2 control-label fieldRequired ">{%=org.r3.shkadmin.siteconfig.message.facebook_pagename%}</label>
						<div class='col-md-10'>
							<input type="text" name="prop_fbpagename" class='form-control'
								id="pkg_facebook_fbpagename" maxlength="15" readonly />
						</div>
					</div>


					<div class="form-group showwhenacquiringtoken">
						<label class="col-md-2 control-label fieldRequired ">{%=org.r3.shkadmin.siteconfig.message.facebook_pageid%}</label>
						<div class='col-md-10'>
							<select name="fbpageid" class='form-control'
								id="getfacebookpagetokenform_fbpageid"></select>
						</div>
					</div>

				</div>

			</div>
		</form>

		<div class="form-action-bar">

			<button type="button"
				id="getfacebookpagetokenform_action_getpagetoken"
				class="btn btn-default hidewhenacquiringtoken">
				<span>{%=org.r3.shkadmin.siteconfig.message.action_getpagetoken%}</span>
			</button>

			<button type="button" id="getfacebookpagetokenform_action_saveitem"
				class="btn btn-default showwhenacquiringtoken">
				<span>{%=org.r3.message.action_save%}</span>
			</button>

			<button type="button" id="getfacebookpagetokenform_action_cancel"
				class="btn btn-default showwhenacquiringtoken">
				<span>{%=org.r3.message.action_cancel%}</span>
			</button>
			
		</div>


	</div>
</div>




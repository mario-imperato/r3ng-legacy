$.r3Utils.namespace("org.r3.jsportlet.sev.submitcrewcheck");

org.r3.jsportlet.sev.submitcrewcheck.SubmitCrewCheckActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},
	
	open : function()
	{
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/submitcrewcheck/SubmitCrewCheckActionFormView.html'),
			dataType : "html"
		});

		networkRequestsQueue.push(
		{
			id : "pkg_fiv_properties",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_FIV_SiteProperties'),
			dataType : "json"
		});
		
		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_SailEvent'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	
			
			$(this.htmlContainerId).html(responseData['view']);

			var pkg_fiv_properties = responseData['pkg_fiv_properties'];
			if (pkg_fiv_properties)
			{
				pkg_fiv_properties = new org.r3.db.system.siteproperty.SitePropertyDTOTableAdapter(pkg_fiv_properties, 
						function(aRowDataBean) { return new org.r3.db.system.siteproperty.SitePropertyDTOAdapter(aRowDataBean); });					

				var property = pkg_fiv_properties.getPropertyByPropertyscopePropertykey("fiv", "fivclubid");
				if (property)
				{
				    $('#submitcrewcheckform_yachtclubcode').val(property.dataBean.propertyvalue);
				}
				
				var property = pkg_fiv_properties.getPropertyByPropertyscopePropertykey("fiv", "fivpasswd");
				if (property)
				{
				    $('#submitcrewcheckform_yachtclubpwd').val(property.dataBean.propertyvalue);
				    $('#submitcrewcheckform_confirm_yachtclubpwd').val(property.dataBean.propertyvalue);
				}
				
			}
						
			$.r3Utils.onEnter('#registrationform_confirm_password', this.actionFormManager, this.actionFormManager.doSubmitCrewCheck, true);

			$("#submitcrewcheckform_form").validate
            ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.jsportlet.sev.submitcrewcheck.submitcrewcheckform_form_validationRules,
		           messages: org.r3.jsportlet.sev.submitcrewcheck.submitcrewcheckform_form_validationMessages    
	        });

			$('#submitcrewcheckform_action_submit').unbind().click($.r3Utils.hitch(this, this.onSubmitClick));
			$('#submitcrewcheckform_fieldset_message').formmessage({});
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
	},
	
	onSubmitClick : function(event)
	{
		console.log("I'm clicked2.... ", this, event);
		this.actionFormManager.doSubmitCrewCheck();
		event.preventDefault();
	}
		
});

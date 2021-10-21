$.r3Utils.namespace("org.r3.jsportlet.registration");

org.r3.jsportlet.registration.RegistrationActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},
	
	open : function(aOptionsHash)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		
		var templateHtml = org.r3.Constants.applicationContext + '/org/r3/jsportlet/registration/RegistrationActionForm.html';
		if (aOptionsHash && aOptionsHash.templateHtml)
			templateHtml = org.r3.Constants.applicationContext + '/org/r3/jsportlet/registration/' + aOptionsHash.templateHtml;
		
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : templateHtml,
			dataType : "html"
		});

		networkRequestsQueue.push(
		{
			id : "captchaToken",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GETCaptchaToken'),
			dataType : "json"
		});

		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_SailEvent'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	

			var captchaToken = responseData['captchaToken'];
			if (captchaToken)
				captchaToken = new org.r3.RestDTOAdapter(captchaToken);
			
            var templatedHtml = tmpl(responseData['view'], captchaToken );
			$(this.htmlContainerId).html(templatedHtml);
									
			$('#registrationform_refreshcaptcha_action').unbind().click($.r3Utils.hitch(this, this.reloadCaptcha));
						
			$('#registrationform_securecode').focus();
			$.r3Utils.onEnter('#registrationform_confirm_password', this.actionFormManager, this.actionFormManager.doRegistration, true);

			$("#registrationform_form").validate
            ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.jsportlet.registration.registrationform_form_validationRules,
		           messages: org.r3.jsportlet.registration.registrationform_form_validationMessages    
	        });

			$('#registrationButton').unbind().click($.r3Utils.hitch(this, this.onRegistrationClick));
			$('#registrationform_form_fieldset_message').formmessage({});
			
			// On Regatta.
			$(this.htmlContainerId + ' .if_' + org.r3.SiteConstants.targetSiteType).show();
			
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
	},
	
	onRegistrationClick : function(event)
	{
		console.log("I'm clicked2.... ", this, event);
		this.actionFormManager.doRegistration();
		event.preventDefault();
	},
	
	reloadCaptcha: function()
	{
		console.info("Reloading Captcha");
		$.ajax(
			{
				"type" : "get",
				"url"  : org.r3.PageManager.getRESTUrl('GETCaptchaToken'),
				"dataType" : "json",
				"success" : function(responseData)
				{
					org.r3.PageManager.closeNotifier();
					var captchaToken = responseData;
					if (captchaToken)
						captchaToken = new org.r3.RestDTOAdapter(captchaToken);

					var tokenValue = encodeURIComponent(captchaToken.correlationid);
					// console.info("From: ", captchaToken.correlationid, encodeURIComponent(captchaToken.correlationid));
					$('#registrationform_captcha_img').attr('src', org.r3.Constants.applicationContext + "/simpleCaptcha.png?token=" + tokenValue);
					$('#registrationform_securetoken').attr('value', captchaToken.correlationid);
				},
				"error" : function(jqXHR, timeout, message)
				{
					console.error("AccettazioneActionForm: ", message);
				}
			});   			
	}
	
});

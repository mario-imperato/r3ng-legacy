$.r3Utils.namespace("org.r3.jsportlet.resetuserpwd");

org.r3.jsportlet.resetuserpwd.ResetUserPasswordActionFormView = org.r3.ActionFormView.extend(
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
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/resetuserpwd/ResetUserPasswordActionForm.html'),
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
									
			$('#resetuserpwdform_refreshcaptcha_action').unbind().click($.r3Utils.hitch(this, this.reloadCaptcha));
						
			$('#resetuserpwdform_securecode').focus();

			$("#resetuserpwdform_form").validate
            ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.jsportlet.resetuserpwd.resetuserpwdform_form_validationRules,
		           messages: org.r3.jsportlet.resetuserpwd.resetuserpwdform_form_validationMessages    
	        });

			$('#resetuserpwdButton').unbind().click($.r3Utils.hitch(this, this.onResetUserPasswordClick));
			$('#resetuserpwdform_fieldset_message').formmessage({});
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
	},
	
	onResetUserPasswordClick : function(event)
	{
		console.log("I'm clicked2.... ", this, event);
		this.actionFormManager.doResetUserPassword();
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
					$('#resetuserpwdform_captcha_img').attr('src', org.r3.Constants.applicationContext + "/simpleCaptcha.png?token=" + tokenValue);
					$('#resetuserpwdform_securetoken').attr('value', captchaToken.correlationid);
				},
				"error" : function(jqXHR, timeout, message)
				{
					console.error("AccettazioneActionForm: ", message);
				}
			});   			
	}
	
});

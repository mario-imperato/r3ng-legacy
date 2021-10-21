$.r3Utils.namespace("org.r3.jsportlet.newslettersubscription");

org.r3.jsportlet.newslettersubscription.NewsletterSubscriptionActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},
	
	open : function(optionsHash)
	{
		var _self = this;
		
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/newslettersubscription/' + optionsHash.template),
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
									
			$('#newslettersubscription_refreshcaptcha_action').unbind().click($.r3Utils.hitch(this, this.reloadCaptcha));
						
			// $('#newslettersubscription_securecode').focus();
			$.r3Utils.onEnter('#newslettersubscription_confirm_email', this.actionFormManager, this.actionFormManager.doRegistration, true);

			$("#newslettersubscription_form").validate
            ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.jsportlet.newslettersubscription.newslettersubscription_form_validationRules,
		           messages: org.r3.jsportlet.newslettersubscription.newslettersubscription_form_validationMessages    
	        });

			_self.asInitVals = [];
			
		    /*
		     * Support functions to provide a little bit of 'user friendlyness' to the textboxes in
		     * the footer
		     */
		    $("#newslettersubscription_form input[type='text']").each( function (i) {
		    	_self.asInitVals[i] = this.value;
		    	$(this).addClass('fieldEmpty');
		    } );
		     
		    $("#newslettersubscription_form input[type='text']").focus( function () {
		    	var item = $(this);
		        if ( item.hasClass("fieldEmpty") )
		        {
		        	item.removeClass('fieldEmpty');
		            item.val('');
		        }
		    } );
		     
		    $("#newslettersubscription_form input[type='text']").blur( function (i) {
		    	var item = $(this);
		        if ( item.val() == "" )
		        {
		        	item.addClass('fieldEmpty');
		            
		            var indexOfItem = $("#newslettersubscription_form input[type='text']").index(this);
		            item.val(_self.asInitVals[indexOfItem]);
		        }
		    } );
		    
			$('#newslettersubscription_confirm_action').unbind().click($.r3Utils.hitch(this, this.onRegistrationClick));
			$('#newslettersubscription_form_fieldset_message').formmessage({});
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
					$('#newslettersubscription_captcha_img').attr('src', org.r3.Constants.applicationContext + "/simpleCaptcha.png?token=" + tokenValue);
					$('#newslettersubscription_securetoken').attr('value', captchaToken.correlationid);
				},
				"error" : function(jqXHR, timeout, message)
				{
					console.error("AccettazioneActionForm: ", message);
				}
			});   			
	}
	
});

$.r3Utils.namespace("org.r3");

org.r3.AjaxUtils =
{
	init : function()
	{	
	},

	submitForm: function(method, restUrl, theForm, onSuccess, onError, confirmationMessageId, systemWaitFlag)
	{
		if (theForm.valid())
		{
			if (confirmationMessageId)
			{
				if (!org.r3.PageManager.confirmation(confirmationMessageId))
				    return ;
			}
			
			if (systemWaitFlag)
				org.r3.PageManager.wait("org.r3.message.waiting");
			
			theForm.ajaxSubmit(
			{
				"type" : method,
				"url" : restUrl,
				"dataType" : "json",
				"success" : function(responseData)
				{
					if (systemWaitFlag)
						org.r3.PageManager.closeNotifier();
					
					if (onSuccess)
						onSuccess(responseData);					
				},
				
				"error" : function(jqXHR, timeout, message)
				{
					if (systemWaitFlag)
						org.r3.PageManager.closeNotifier();
					
					if (onError)
						onError(jqXHR, timeout, message);
				}
				
			});
		}		
	},
	
	ajaxInvoke: function(method, restUrl, onSuccess, onError, confirmationMessageId, systemWaitFlag)
	{
		if (confirmationMessageId)
		{
			if (!org.r3.PageManager.confirmation(confirmationMessageId))
			    return ;
		}
		
		if (systemWaitFlag)
			org.r3.PageManager.wait("org.r3.message.waiting");
		
		$.ajax(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"success" : function(responseData)
			{
				if (systemWaitFlag)
					org.r3.PageManager.closeNotifier();
					
				if (onSuccess)
						onSuccess(responseData);					
			},
				
			"error" : function(jqXHR, timeout, message)
			{
				if (systemWaitFlag)
					org.r3.PageManager.closeNotifier();
				
				if (onError)
					onError(jqXHR, timeout, message);
			}
				
		});		
	},
	
	submitFormData: function(method, restUrl, theFormDataObject, onSuccess, onError, confirmationMessageId, systemWaitFlag)
	{
		
		if (confirmationMessageId)
		{
			if (!org.r3.PageManager.confirmation(confirmationMessageId))
			    return ;
		}
		
		if (systemWaitFlag)
			org.r3.PageManager.wait("org.r3.message.waiting");
		
		$.ajax(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"data": theFormDataObject,
			"processData": false,
			"contentType": false,
			"success" : function(responseData)
			{
				if (systemWaitFlag)
					org.r3.PageManager.closeNotifier();
				
				if (onSuccess)
					onSuccess(responseData);					
			},
			
			"error" : function(jqXHR, timeout, message)
			{
				if (systemWaitFlag)
					org.r3.PageManager.closeNotifier();
				
				if (onError)
					onError(jqXHR, timeout, message);
			}
			
		});
	},
	
	doPostLoginFormData: function(aLoginUrl, aLoginUrlEncodedPostData, onLoginRedirect)
	{
		var method = "post";
		var restUrl = aLoginUrl; 

		$.ajax(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"data": aLoginUrlEncodedPostData,
			"success" : function(responseData) 
			{ 				
				if (org.r3.PageManager.isRestDTO(responseData))
				{
					org.r3.PageManager.closeNotifier();
					var restDto = new org.r3.RestDTOAdapter(responseData);

					if (restDto.isFail())
                    {
						var o = $('#loginform_form_fieldset_message');
						if (o.length) 
						{
							restDto.showMessage('loginform_form_fieldset_message');
							// o.formmessage('setText', { text: restDto.reason, category: 'error' });	
						}								
						else 
						{
							$('#loginform_form .loginform_mainsection .form-group').addClass('has-error');
						}
                    }						
				}
				else 
				{						
					org.r3.PageManager.gotoPage(onLoginRedirect);
				}
			},
			
			"error" : function(jqXHR, timeout, message)
			{ console.log(arguments); $('#loginform_form_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }
			
		});
									
	},	
	
	doLogin: function(aLoginUrl, onLoginRedirect)
	{

		var theForm = $('#loginform_form');
		var method = "post";
		var restUrl = aLoginUrl; 
			
		org.r3.AjaxUtils.submitForm(
				method, 
				restUrl,  
				theForm, 
				function(responseData) { 
					
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						org.r3.PageManager.closeNotifier();
						var restDto = new org.r3.RestDTOAdapter(responseData);

						if (restDto.isFail())
	                    {
							var o = $('#loginform_form_fieldset_message');
							if (o.length) 
								restDto.showMessage('loginform_form_fieldset_message');		
							else 
							{
								$('#loginform_form .loginform_mainsection .form-group').addClass('has-error');
							}
	                    }						
					}
					else 
					{						
						org.r3.PageManager.gotoPage(onLoginRedirect);
					}					
					
				}, 
				function(jqXHR, timeout, message) { console.log(arguments); $('#loginform_form_fieldset_message').formmessage('setText', { text: message, category: 'error' }); },
				null,
		        false);								
	},
	
	logUserActionEvent: function(eventLogAmbit, eventLogUseCase, eventLogRefEntityId)
	{
		var currentSite = org.r3.Constants.site;
		
		org.r3.AjaxUtils.ajaxInvoke(
				'post', 
				org.r3.PageManager.getRESTUrl('POST_EventLOG', [ eventLogAmbit, eventLogUseCase, eventLogRefEntityId ])
		);
	}

	
			
};


$.r3Utils.namespace("org.r3.jsportlet.registration");

org.r3.jsportlet.registration.RegistrationActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.registration.RegistrationActionFormView(aDetailViewContainerId, this);
	},

	close : function()
	{
		this.hide();
	},

	hide : function()
	{
		this.detailView.hide();
	},

	show : function()
	{
		this.detailView.show();
	},

	refresh : function()
	{
	},

	open : function(aOptionsHash)
	{
		this.detailView.open(aOptionsHash);
	},
	
	doRegistration: function()
	{
		var _self = this;
		
		if ($('#registrationform_form').valid())
		{
			org.r3.PageManager.wait("org.r3.message.waiting");

			var method = "post";
			var restUrl = org.r3.PageManager.getRESTUrl('POST_User_Registration');
			$('#registrationform_form').ajaxSubmit(
			{
				"type" : method,
				"url" : restUrl,
				"dataType" : "json",
				"success" : function(responseData)
				{
					org.r3.PageManager.closeNotifier();
					if (org.r3.PageManager.isRestDTO(responseData))
					{						
						var restDto = new org.r3.RestDTOAdapter(responseData);

						if (restDto.isFail())
	                    {
							restDto.showMessage("registrationform_form_fieldset_message");
							if (restDto.reasoncode == 'USR_ERROR_DUPUSER')
							{
								console.error("Duplicate Mail Error");
								$('.registrationform_onduplicateuser').show();
							}
							// $('#registrationform_form_fieldset_message').formmessage('setText', { text: restDto.reason, category: 'error' });						
	                    }						
					}
					else 
					{						
						var cardMessageCanvas = $(_self.detailView.htmlContainerId + " .panel-body");
						if (!cardMessageCanvas.length)
							cardMessageCanvas = $(_self.detailView.htmlContainerId);
						
						if (responseData.recstatus == 'sys_recact')
							cardMessageCanvas.cmsCard({ card_tmpl: "cms_tpl_simple", cardid: "REGACT_OK"});
						else
							cardMessageCanvas.cmsCard({ card_tmpl: "cms_tpl_simple", cardid: "HLP_USRREG_OK"});
						
						// $(_self.detailView.htmlContainerId + " .panel_action_bar").hide();						
					}
										
				},
				"error" : function(jqXHR, timeout, message)
				{
					console.log(arguments);
					org.r3.PageManager.closeNotifier();
					$('#registrationform_form_fieldset_message').formmessage('setText', { text: message, category: 'error' });
				}
			});
		}				
	}
		
});


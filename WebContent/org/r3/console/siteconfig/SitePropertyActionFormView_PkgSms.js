$.r3Utils.namespace("org.r3.console.siteconfig");


org.r3.console.siteconfig.SitePropertyActionFormView_PkgSms = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, siteProperties)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);		
		
		$('#pkg_sms_form_property_package').val("sms");
			
		$('#pkg_sms_action_save').click(
				$.r3Utils.hitch(this, this._onSaveForm));				

	    $('#pkg_sms_fieldset_message').formmessage({});

		$('#pkg_sms_form').validate(
		{
			errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
			rules : org.r3.console.siteconfig.pkg_sms_form_validationRules,
			messages : org.r3.console.siteconfig.pkg_sms_form_validationMessages
		});
		
		var property = siteProperties.getPropertyByPropertyscopePropertykey("sms", "smslogin");
		if (property)
		{
		    $('#pkg_sms_smslogin').val(property.dataBean.propertyvalue);
		}
		
		var property = siteProperties.getPropertyByPropertyscopePropertykey("sms", "smspasswd");
		if (property)
		{
		    $('#pkg_sms_smspasswd').val(property.dataBean.propertyvalue);
		}

		var property = siteProperties.getPropertyByPropertyscopePropertykey("sms", "smssender");
		if (property)
		{
		    $('#pkg_sms_smssender').val(property.dataBean.propertyvalue);
		}

	},
	
	refresh: function()
	{		
	},
	
	_onSaveForm: function()
	{
		var _self = this;
		var restUrl = org.r3.PageManager.getRESTUrl("POST_SiteProperties_Invalidate", [ "sms" ]);
		
		this.actionFormManager.saveForm(
				restUrl,
				$('#pkg_sms_form'),
				function(responseData) { 
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('pkg_sms_fieldset_message');
					}					
		        }, 
				function(jqXHR, timeout, message) { $('#pkg_sms_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	}
		
});

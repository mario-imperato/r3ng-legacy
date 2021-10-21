$.r3Utils.namespace("org.r3.console.siteconfig");


org.r3.console.siteconfig.SitePropertyActionFormView_PkgMail = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, siteProperties)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);		
		
		$('#pkg_mail_form_property_package').val("mail");
			
		$('#pkg_mail_action_save').click(
				$.r3Utils.hitch(this, this._onSaveForm));				

	    $('#pkg_mail_fieldset_message').formmessage({});

		$('#pkg_mail_form').validate(
		{
			errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
			rules : org.r3.console.siteconfig.pkg_mail_form_validationRules,
			messages : org.r3.console.siteconfig.pkg_mail_form_validationMessages
		});
		
		var property = siteProperties.getPropertyByPropertyscopePropertykey("mail", "smtp_auth");
		if (property)
		{
		    $('#pkg_mail_smtp_auth').val(property.dataBean.propertyvalue);
		}
		
		var property = siteProperties.getPropertyByPropertyscopePropertykey("mail", "smtp_port");
		if (property)
		{
		    $('#pkg_mail_smtp_port').val(property.dataBean.propertyvalue);
		}

		var property = siteProperties.getPropertyByPropertyscopePropertykey("mail", "smtp_quitwait");
		if (property)
		{
		    $('#pkg_mail_smtp_quitwait').val(property.dataBean.propertyvalue);
		}
		
		var property = siteProperties.getPropertyByPropertyscopePropertykey("mail", "smtp_socketFactory_class");
		if (property)
		{
		    $('#pkg_mail_smtp_socketFactory_class').val(property.dataBean.propertyvalue);
		}

		var property = siteProperties.getPropertyByPropertyscopePropertykey("mail", "smtp_socketFactory_fallback");
		if (property)
		{
		    $('#pkg_mail_smtp_socketFactory_fallback').val(property.dataBean.propertyvalue);
		}

		var property = siteProperties.getPropertyByPropertyscopePropertykey("mail", "smtp_socketFactory_port");
		if (property)
		{
		    $('#pkg_mail_smtp_socketFactory_port').val(property.dataBean.propertyvalue);
		}

		var property = siteProperties.getPropertyByPropertyscopePropertykey("mail", "smtp_sysfrom");
		if (property)
		{
		    $('#pkg_mail_smtp_sysfrom').val(property.dataBean.propertyvalue);
		}	
		
		var property = siteProperties.getPropertyByPropertyscopePropertykey("mail", "smtp_systitle");
		if (property)
		{
		    $('#pkg_mail_smtp_systitle').val(property.dataBean.propertyvalue);
		}
		
		var property = siteProperties.getPropertyByPropertyscopePropertykey("mail", "mail_host");
		if (property)
		{
		    $('#pkg_mail_mail_host').val(property.dataBean.propertyvalue);
		}

		var property = siteProperties.getPropertyByPropertyscopePropertykey("mail", "mail_auth_account");
		if (property)
		{
		    $('#pkg_mail_mail_auth_account').val(property.dataBean.propertyvalue);
		}
	
		var property = siteProperties.getPropertyByPropertyscopePropertykey("mail", "mail_auth_passwd");
		if (property)
		{
		    $('#pkg_mail_mail_auth_passwd').val(property.dataBean.propertyvalue);
		}		
		
		var property = siteProperties.getPropertyByPropertyscopePropertykey("mail", "mail_profile");
		if (property)
		{
		    $('#pkg_mail_mail_profile_' + property.dataBean.propertyvalue).prop('checked', true);
		}		

		var property = siteProperties.getPropertyByPropertyscopePropertykey("mail", "mail_sevcrewchange");
		if (property)
		{
		    $('#pkg_mail_mail_sevcrewchange').val(property.dataBean.propertyvalue);
		}
				
	},
	
	refresh: function()
	{		
	},
	
	_onSaveForm: function()
	{
		var _self = this;
		var restUrl = org.r3.PageManager.getRESTUrl("POST_SiteProperties_Invalidate", [ "mail" ]);
		
		this.actionFormManager.saveForm(
				restUrl,
				$('#pkg_mail_form'),
				function(responseData) { 
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('pkg_sms_fieldset_message');
					}					
		        }, 
				function(jqXHR, timeout, message) { $('#pkg_mail_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	}
		
});

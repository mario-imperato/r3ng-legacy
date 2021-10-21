$.r3Utils.namespace("org.r3.console.siteconfig");


org.r3.console.siteconfig.SitePropertyActionFormView_PkgFiv = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, siteProperties)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);		
		
		$('#pkg_fiv_form_property_package').val("fiv");
			
		$('#pkg_fiv_action_save').click(
				$.r3Utils.hitch(this, this._onSaveForm));				

	    $('#pkg_fiv_fieldset_message').formmessage({});

		$('#pkg_fiv_form').validate(
		{
			errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
			rules : org.r3.console.siteconfig.pkg_fiv_form_validationRules,
			messages : org.r3.console.siteconfig.pkg_fiv_form_validationMessages
		});
		
		var property = siteProperties.getPropertyByPropertyscopePropertykey("fiv", "fivclubid");
		if (property)
		{
		    $('#pkg_fiv_fivclubid').val(property.dataBean.propertyvalue);
		}
		
		var property = siteProperties.getPropertyByPropertyscopePropertykey("fiv", "fivpasswd");
		if (property)
		{
		    $('#pkg_fiv_fivpasswd').val(property.dataBean.propertyvalue);
		}

	},
	
	refresh: function()
	{		
	},
	
	_onSaveForm: function()
	{
		var _self = this;
		var restUrl = org.r3.PageManager.getRESTUrl("POST_SiteProperties_Invalidate", [ "fiv" ]);
		
		this.actionFormManager.saveForm(
				restUrl,
				$('#pkg_fiv_form'),
				function(responseData) { 
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('pkg_fiv_fieldset_message');
					}					
		        }, 
				function(jqXHR, timeout, message) { $('#pkg_fiv_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	}
		
});

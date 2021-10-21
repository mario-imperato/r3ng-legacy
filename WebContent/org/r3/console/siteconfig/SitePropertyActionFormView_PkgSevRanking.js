$.r3Utils.namespace("org.r3.console.siteconfig");


org.r3.console.siteconfig.SitePropertyActionFormView_PkgSevRanking = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, siteProperties)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);		
		
		$('#pkg_sevranking_form_property_package').val("sev.ranking");
			
		$('#pkg_sevranking_action_save').click(
				$.r3Utils.hitch(this, this._onSaveForm));				

	    $('#pkg_sevranking_fieldset_message').formmessage({});

		$('#pkg_sevranking_form').validate(
		{
			errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
			rules : org.r3.console.siteconfig.pkg_sevranking_form_validationRules,
			messages : org.r3.console.siteconfig.pkg_sevranking_form_validationMessages
		});
		
		var property = siteProperties.getPropertyByPropertyscopePropertykey("sev.ranking", "maxraces");
		if (property)
		{
		    $('#pkg_sevranking_maxraces').val(property.dataBean.propertyvalue);
		}
				
	},
	
	refresh: function()
	{		
	},
	
	_onSaveForm: function()
	{
		var _self = this;
		var restUrl = org.r3.PageManager.getRESTUrl("POST_SiteProperties_Invalidate", [ "sev.ranking" ]);
		
		this.actionFormManager.saveForm(
				restUrl,
				$('#pkg_sevranking_form'),
				function(responseData) { 
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('pkg_sevranking_fieldset_message');
					}					
		        }, 
				function(jqXHR, timeout, message) { $('#pkg_sevranking_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	}
		
});

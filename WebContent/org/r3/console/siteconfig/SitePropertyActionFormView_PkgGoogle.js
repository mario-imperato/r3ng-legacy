$.r3Utils.namespace("org.r3.console.siteconfig");


org.r3.console.siteconfig.SitePropertyActionFormView_PkgGoogle = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, siteProperties)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);		
		
		$('#pkg_googleanalytics_form_property_package').val("google.analytics");
			
		$('#pkg_googleanalytics_action_save').click(
				$.r3Utils.hitch(this, this._onSaveForm));				

	    $('#pkg_googleanalytics_fieldset_message').formmessage({});

		$('#pkg_googleanalytics_form').validate(
		{
			errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
			rules : org.r3.console.siteconfig.pkg_googleanalytics_form_validationRules,
			messages : org.r3.console.siteconfig.pkg_googleanalytics_form_validationMessages
		});
		
		var property = siteProperties.getPropertyByPropertyscopePropertykey("google.analytics", "domain");
		if (property)
		{
		    $('#pkg_googleanalytics_domain').val(property.dataBean.propertyvalue);
		}
		
		var property = siteProperties.getPropertyByPropertyscopePropertykey("google.analytics", "trackerid");
		if (property)
		{
		    $('#pkg_googleanalytics_trackerid').val(property.dataBean.propertyvalue);
		}
		
	},
	
	refresh: function()
	{		
	},
	
	_onSaveForm: function()
	{
		var _self = this;
		var restUrl = org.r3.PageManager.getRESTUrl("POST_SiteProperties_Invalidate", [ "google.analytics" ]);
		
		this.actionFormManager.saveForm(
				restUrl,
				$('#pkg_googleanalytics_form'),
				function(responseData) { 
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('pkg_googleanalytics_fieldset_message');
					}					
		        }, 
				function(jqXHR, timeout, message) { $('#pkg_googleanalytics_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	}
		
});

$.r3Utils.namespace("org.r3.console.siteconfig");


org.r3.console.siteconfig.SitePropertyActionFormView_PkgSevApp = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, siteProperties)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);		
		
		$('#pkg_sevapp_form_property_package').val("sev.app");
		
		$('#pkg_sevapp_form').validate(
		{
			errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
			rules : org.r3.console.siteconfig.pkg_sevapp_form_validationRules,
			messages : org.r3.console.siteconfig.pkg_sevapp_form_validationMessages
		});

		var property = siteProperties.getPropertyByPropertyscopePropertykey("sev.app", "boatinfoform_otherinfo");
		var pvalue = (property && property.dataBean.propertyvalue) || 'bfalse';
	    $('#boatinfoform_otherinfo_' + pvalue).prop('checked', true);

		var property = siteProperties.getPropertyByPropertyscopePropertykey("sev.app", "boatinfoform_sailcloth");
		var pvalue = (property && property.dataBean.propertyvalue) || 'bfalse';
	    $('#boatinfoform_sailcloth_' + pvalue).prop('checked', true);

		var property = siteProperties.getPropertyByPropertyscopePropertykey("sev.app", "classinfoform_apptype");
		var pvalue = (property && property.dataBean.propertyvalue) || 'bfalse';
	    $('#classinfoform_apptype_' + pvalue).prop('checked', true);

		var property = siteProperties.getPropertyByPropertyscopePropertykey("sev.app", "classinfoform_grancrocieraorc");
		var pvalue = (property && property.dataBean.propertyvalue) || 'bfalse';
	    $('#classinfoform_grancrocieraorc_' + pvalue).prop('checked', true);

		var property = siteProperties.getPropertyByPropertyscopePropertykey("sev.app", "classinfoform_racegroupdecl");
		var pvalue = (property && property.dataBean.propertyvalue) || 'bfalse';
	    $('#classinfoform_racegroupdecl_' + pvalue).prop('checked', true);

		$('#pkg_sevapp_action_save').click(
				$.r3Utils.hitch(this, this._onSaveForm));				

	    $('#pkg_sevapp_fieldset_message').formmessage({});
	
	},
	
	refresh: function()
	{		
	},
	
	_onSaveForm: function()
	{
		var _self = this;
		var restUrl = org.r3.PageManager.getRESTUrl("POST_SiteProperties_Invalidate", [ "sev.app" ]);
		
		this.actionFormManager.saveForm(
				restUrl,
				$('#pkg_sevapp_form'),
				function(responseData) { 
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('pkg_sevapp_fieldset_message');
					}					
		        }, 
				function(jqXHR, timeout, message) { $('#pkg_sevapp_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	}
		
});

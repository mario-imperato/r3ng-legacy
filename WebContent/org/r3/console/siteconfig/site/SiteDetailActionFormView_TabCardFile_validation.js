$.r3Utils.namespace("org.r3.console.siteconfig.site", window, function(aNamespace)
{

	// Prodotto...
	aNamespace.sitefileactionform_form_validationRules =
	{
		propertyname :
		{
			required : true,
			maxlength : 80
		}

	};

	aNamespace.sitefileactionform_form_validationMessages =
	{
		propertyname :
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength
		}

	};

});

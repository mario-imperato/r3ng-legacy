$.r3Utils.namespace("org.r3.jsportlet.cmsconsole", window, function(aNamespace)
{

	// Prodotto...
	aNamespace.cardfileactionform_form_validationRules =
	{
		propertyname :
		{
			required : true,
			maxlength : 80
		}

	};

	aNamespace.cardfileactionform_form_validationMessages =
	{
		propertyname :
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength
		}

	};

});

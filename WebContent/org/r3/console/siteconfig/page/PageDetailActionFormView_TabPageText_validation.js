$.r3Utils.namespace("org.r3.console.siteconfig.page", window, function(aNamespace)
{

	// Prodotto...
	aNamespace.pagetextactionform_form_validationRules =
	{
		pagetitle :
		{
			required : true,
			maxlength : 80
		},
		
		summary :
		{
			required : true,
			maxlength : 255
		}

	};

	aNamespace.pagetextactionform_form_validationMessages =
	{
		pagetitle :
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength
		},

	    summary :
	    {
		    required : org.r3.message.field_required,
		    maxlength : org.r3.message.field_maxlength
	    }

	};

});

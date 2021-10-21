$.r3Utils.namespace("org.r3.jsportlet.mongocms", window, function(aNamespace)
{

	// Prodotto...
	aNamespace.cardtextactionform_form_validationRules =
	{
		title :
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

	aNamespace.cardtextactionform_form_validationMessages =
	{
		title :
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

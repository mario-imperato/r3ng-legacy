
$.r3Utils.namespace("org.r3.console.contacts", window, function(aNamespace) 
{

	// Prodotto...
	aNamespace.exportcontactsactionform_form_validationRules =
		{
			csvformat :
			{
				required : true
			}

		};

		aNamespace.exportcontactsactionform_form_validationMessages =
		{
			csvformat :
			{
				required : org.r3.message.field_required
			}
		};
	
});


$.r3Utils.namespace("org.r3.console.contacts", window, function(aNamespace) 
{

	// Prodotto...
	aNamespace.importactorgroupfromchildsiteactionform_form_validationRules =
		{
			sourcesite :
			{
				required : true
			}
		};

		aNamespace.importactorgroupfromchildsiteactionform_form_validationMessages =
		{
			sourcesite :
			{
				required : org.r3.message.field_required
			}
			
		};

	
});

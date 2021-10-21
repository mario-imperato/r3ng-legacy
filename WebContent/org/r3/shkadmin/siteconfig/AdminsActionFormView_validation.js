
$.r3Utils.namespace("org.r3.console.contacts", window, function(aNamespace) 
{

	// Prodotto...
	aNamespace.actorgroupdetailactionform_form_validationRules =
		{
			grouptitle :
			{
				required : true,
				maxlength: 30,
				texttransform: 'uppercase'
			}
		};

		aNamespace.actorgroupdetailactionform_form_validationMessages =
		{
			grouptitle :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			}
			
		};

	
});

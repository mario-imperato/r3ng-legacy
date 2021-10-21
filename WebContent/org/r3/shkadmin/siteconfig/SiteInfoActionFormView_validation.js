
$.r3Utils.namespace("org.r3.shkadmin.siteconfig", window, function(aNamespace) 
{

	// Prodotto...
	aNamespace.siteinfoactionform_form_validationRules =
		{
			
			site :
			{
				required : true,
				maxlength: 15,
				identifier: true,
				texttransform: 'lowercase'
			},

			summary :
			{
				required : true,
				maxlength: 1024
			}
			
		};

		aNamespace.siteinfoactionform_form_validationMessages =
		{
		
			site :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength,
				identifier: org.r3.message.field_identifier
			},

			summary :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			}			
		};

	
});

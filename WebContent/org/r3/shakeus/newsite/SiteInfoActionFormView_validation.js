
$.r3Utils.namespace("org.r3.shakeus.newsite", window, function(aNamespace) 
{

	// Prodotto... 
	aNamespace.siteinfoform_validationRules =
		{
			sitetype :
			{
				required : true
			},			
			
			site :
			{
				required : true,
				maxlength: 15,
				identifier: true,
				texttransform: 'lowercase'
			},

			sitedescr :
			{
				required : true,
				maxlength: 40
			},


			
		};

		aNamespace.siteinfoform_validationMessages =
		{
			sitetype :
			{
				required : org.r3.message.field_required			
			},

			site :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength,
				identifier: org.r3.message.field_identifier
			},

			sitedescr :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			}
			
		};

	
});

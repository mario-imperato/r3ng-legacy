
$.r3Utils.namespace("org.r3.console.tow", window, function(aNamespace) 
{

	// Prodotto...
	aNamespace.wbsactionform_form_validationRules =
		{
			bbstopicid:
			{
				required : false,
				maxlength : 15,
				identifier : true,
				texttransform: 'uppercase'
			},
			
			wbstitle :
			{
				required : true,
				maxlength : 255
			}
			
		};

		aNamespace.wbsactionform_form_validationMessages =
		{
			bbstopicid:
			{
				required : org.r3.message.field_required,
				maxlength : org.r3.message.field_maxlength,
				identifier : org.r3.message.field_identifier
			},
				
			wbstitle :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			}
			
		};

	
});

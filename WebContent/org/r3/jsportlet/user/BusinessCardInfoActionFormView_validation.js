
$.r3Utils.namespace("org.r3.jsportlet.user", window, function(aNamespace) 
{
	
	// Prodotto...
	aNamespace.businesscardinfoactionform_form_validationRules =
	{

		personalstatement :
		{
			required : true,
			maxlength: 1024
		},
		
		email :
		{
			required : false,
			email: true,
			maxlength: 1024
		},
		
		cellphone :
		{
			required : false,			
			maxlength: 1024,
			digits: true,			
		}		
		

	};

	aNamespace.businesscardinfoactionform_form_validationMessages =
	{
			personalstatement :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},
			
			email :
			{
				required : org.r3.message.field_required,
				email: org.r3.message.field_email,
				maxlength: org.r3.message.field_maxlength
			},
			
			cellphone :
			{
				required : org.r3.message.field_required,			
				maxlength: org.r3.message.field_maxlength,
				digits: org.r3.message.field_digits,			
			}					
	};

});

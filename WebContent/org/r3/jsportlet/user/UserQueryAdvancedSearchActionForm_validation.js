$.r3Utils.namespace("org.r3.jsportlet.user", window, function(aNamespace)
{
	aNamespace.advancedsearchform_form_validationRules =
	{
		userid :
		{
			required : false,
			maxlength : 15
		},

		nickname :
		{
			required : false,
			maxlength : 40
		},

		firstname :
		{
			required : false,
			maxlength : 80
		},

		lastname :
		{
			required : false,
			maxlength : 80
		},
		
		email :
		{
			required : false,
			maxlength : 80
		}		

	};

	aNamespace.advancedsearchform_form_validationMessages =
	{
			userid :
			{
				required : org.r3.message.field_required,
				maxlength : org.r3.message.field_maxlength
			},

			nickname :
			{
				required : org.r3.message.field_required,
				maxlength : org.r3.message.field_maxlength
			},

			firstname :
			{
				required : org.r3.message.field_required,
				maxlength : org.r3.message.field_maxlength
			},

			lastname :
			{
				required : org.r3.message.field_required,
				maxlength : org.r3.message.field_maxlength
			},
			
			email :
			{
				required : org.r3.message.field_required,
				maxlength : org.r3.message.field_maxlength
			}				
	};

});

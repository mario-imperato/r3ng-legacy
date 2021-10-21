$.r3Utils.namespace("org.r3.jsportlet.teammemberprofile", window, function(aNamespace)
{
	aNamespace.teammemberprofile_form_validationRules =
	{
		profileid :
		{
			required : false,
			maxlength: 15,
			identifier: true,
			texttransform: 'uppercase'
		},		

		itemorder :
		{
			required : false,
			maxlength: 5,
			digits: true
		},

		profiledescr :
		{
			required : false,
			maxlength: 255
		},

		skillprofile:
		{
			required : true		
		},
		
		skillambit:
		{
			required : true
		}

	};

	aNamespace.teammemberprofile_form_validationMessages =
	{
			profileid :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength,
				identifier: org.r3.message.field_identifier
			},

			itemorder :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength,
				digits: org.r3.message.field_digits
			},

			profiledescr :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			skillprofile:
			{
				required : org.r3.message.field_required		
			},
			
			skillambit:
			{
				required : org.r3.message.field_required
			}

	};

});

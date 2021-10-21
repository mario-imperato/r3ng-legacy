$.r3Utils.namespace("org.r3.jsportlet.sev.application", window, function(aNamespace)
{
	aNamespace.crewinfoform_form_validationRules =
	{
		crewcardnumber :
		{
			required : true,
			maxlength: 8,
			digits: true
		},

		crewmembername :
		{
			required : true,
			maxlength: 80,
			texttransform: 'uppercase'
		},

		crewmemberrole :
		{
			required : true
		},

		crewweight :
		{
			required : true,
			maxlength: 10,
			number: true
		},

		memberstatus :
		{
			required : true
		}

	};

	aNamespace.crewinfoform_form_validationMessages =
	{
			crewcardnumber :
			{
				required : org.r3.message.field_required,
				maxlength : org.r3.message.field_maxlength,
				digits: org.r3.message.field_digits
			},

			crewmembername :
			{
				required : org.r3.message.field_required,
				maxlength : org.r3.message.field_maxlength
			},

			crewmemberrole :
			{
				required : org.r3.message.field_required
			},

			crewweight :
			{
				required : org.r3.message.field_required,
				maxlength : org.r3.message.field_maxlength,
				number: org.r3.message.field_number
			},
			
			memberstatus :
			{
				required : org.r3.message.field_required
			}
		
	};

});

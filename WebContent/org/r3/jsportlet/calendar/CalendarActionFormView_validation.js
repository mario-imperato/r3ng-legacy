$.r3Utils.namespace("org.r3.jsportlet.calendar", window, function(aNamespace)
{
	aNamespace.portletcalendar_form_validationRules =
	{
		clsitemid :
		{
			required : false,
			maxlength: 15,
			identifier: true,
			texttransform: 'uppercase'
		},

		clsitembusid :
		{
			required : false,
			maxlength: 15			
		},

		classifieritemorder :
		{
			required : false,
			maxlength: 5,
			digits: true
		},

		classifieritemdescr :
		{
			required : true,
			maxlength: 255
		},

		classifieritemsattr:
		{
			required : false,
			maxlength: 80			
		},
		
		classifieritemiattr:
		{
			required : false,
			maxlength: 5,
			digits: true
		},
		
		subgroups:
		{
			required : false,
			maxlength: 255
		}

	};

	aNamespace.portletcalendar_form_validationMessages =
	{
			clsitemid :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength,
				identifier: org.r3.message.field_identifier
			},

			clsitembusid :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength			
			},

			classifieritemorder :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength,
				digits: org.r3.message.field_digits
			},

			classifieritemdescr :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			classifieritemsattr:
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength			
			},
			
			classifieritemiattr:
			{
				required : org.r3.message.field_required,
				maxlength:  org.r3.message.field_maxlength,
				digits: org.r3.message.field_digits
			},	

			subgroups:
			{
				required : org.r3.message.field_required,
				maxlength:  org.r3.message.field_maxlength
			}

	};

});

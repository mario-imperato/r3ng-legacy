$.r3Utils.namespace("org.r3.jsportlet.sev.application", window, function(aNamespace)
{
	aNamespace.classinfoform_form_validationRules =
	{
		prop_haveadvertising :
		{
			required : false
		},

		prop_insuranceid :
		{
			required : true,
			maxlength : 30,
			texttransform: 'uppercase'
		},

		prop_insuranceinstitution :
		{
			required : true,
			maxlength : 30,
			texttransform: 'uppercase'
		},

		prop_haveinsurance :
		{
			required : true
		},

		racegroup :
		{
			required : true
		},

		prop_ranktype :
		{
			required : true
		},

		apptype :
		{
			required : true
		},

		prop_rating :
		{
			required : true
		}


	};

	aNamespace.classinfoform_form_validationMessages =
	{
		prop_haveadvertising :
		{
			required : org.r3.message.field_required
		},

		prop_insuranceid :
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength
		},

		prop_insuranceinstitution :
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength
		},

		prop_haveinsurance :
		{
			required : org.r3.message.field_required
		},

		racegroup :
		{
			required : org.r3.message.field_required
		},

		prop_ranktype :
		{
			required : org.r3.message.field_required
		},

		apptype :
		{
			required : org.r3.message.field_required
		},

		prop_rating :
		{
			required : org.r3.message.field_required
		}
		
	};

});

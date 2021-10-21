$.r3Utils.namespace("org.r3.console.sev.ranking", window, function(aNamespace)
{

	// Prodotto...
	aNamespace.rankingdetailactionform_form_validationRules =
	{
		rankordering :
		{
			required : true,
			maxlength : 10,
			digits : true
		},

		rankinggroup:
		{
			required : true
		},
		
		ranktitle :
		{
			required : true,
			maxlength : 40,
			texttransform : 'uppercase'
		},

		racefilepattern :
		{
			required : true,
			maxlength : 60
		},

		overallfilepattern :
		{
			required : true,
			maxlength : 60
		},

		championship :
		{
			required : true
		},

		rating :
		{
			required : true
		}

	};

	aNamespace.rankingdetailactionform_form_validationMessages =
	{
		rankordering :
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength,
			digits : org.r3.message.field_digits
		},

		rankinggroup:
		{
			required : org.r3.message.field_required			
		},

		ranktitle :
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength
		},

		racefilepattern :
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength
		},

		overallfilepattern :
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength
		},

		championship :
		{
			required : org.r3.message.field_required
		},

		rating :
		{
			required : org.r3.message.field_required
		}

	};

});

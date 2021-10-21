$.r3Utils.namespace("org.r3.jsportlet.sev.application", window, function(aNamespace)
{
	aNamespace.boatinfoform_form_validationRules =
	{
		plate :
		{
			required : false,
			maxlength: 15,
			texttransform: 'uppercase'
		},

		yachtname :
		{
			required : true,
			maxlength: 30,
			texttransform: 'uppercase'
		},

		yachtclub :
		{
			required : true,
			maxlength: 30,
			texttransform: 'uppercase'			
		},

		yachttype :
		{
			required : true,
			maxlength: 30,
			texttransform: 'uppercase'
		},

		prop_designer :
		{
			required : false,
			maxlength: 30,
			texttransform: 'uppercase'
		},

		prop_yardship :
		{
			required : false,
			maxlength: 30,
			texttransform: 'uppercase'
		},

		prop_year :
		{
			required : true
		},

		prop_harbour :
		{
			required : false,
			maxlength: 30,
			texttransform: 'uppercase'
		},

		mooringloc :
		{
			required : true
		},

		prop_mooringspec :
		{
			required : function()
			{
				return $('#boatinfoform_mooringspec_validatorflag').val() == 'Y';
			},
			maxlength: 30,
			texttransform: 'uppercase'
		},

		sailnumber :
		{
			required : true,
			sailnumber: true,
			maxlength: 10,
			texttransform: 'uppercase'
		},

		prop_hullcolor :
		{
			required : false,
			maxlength: 10,
			texttransform: 'uppercase'
		},

		prop_loa :
		{
			required : false,
			maxlength: 10,
			number   : true 
		},

		prop_lwl :
		{
			required : false,
			maxlength: 10,
			number   : true 
		},

		prop_draft :
		{
			required : false,
			maxlength: 10,
			number   : true 
		},

		prop_beam :
		{
			required : false,
			maxlength: 10,
			number   : true 
		},

		prop_carbonstruct :
		{
			required : false,
			maxlength: 30,
			texttransform: 'uppercase'
		},

		prop_otherchanges :
		{
			required : false,
			maxlength: 30,
			texttransform: 'uppercase'
		},

		prop_sailmaterial:
		{
			required : true
		}


	};

	aNamespace.boatinfoform_form_validationMessages =
	{

		plate :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		},

		yachtname :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		},

		yachtclub :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		},

		yachttype :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		},

		prop_designer :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		},

		prop_year :
		{
			required : org.r3.message.field_required
		},

		prop_harbour :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		},

		prop_mooringloc :
		{
			required : org.r3.message.field_required
		},

		prop_mooringspec :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		},

		sailnumber :
		{
			required : org.r3.message.field_required,
			sailnumber: org.r3.message.field_sailnumber,
			maxlength: org.r3.message.field_maxlength
		},

		prop_hullcolor :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		},

		prop_loa :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength,
			number   : org.r3.message.field_number 
		},

		prop_lwl :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength,
			number   : org.r3.message.field_number 
		},

		prop_draft :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength,
			number   : org.r3.message.field_number 
		},

		prop_beam :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength,
			number   : org.r3.message.field_number 
		},

		prop_carbonstruct :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		},

		prop_otherchanges :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		},

		prop_sailmaterial:
		{
			required : org.r3.message.field_required
		}
		
	};

});

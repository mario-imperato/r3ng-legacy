$.r3Utils.namespace("org.r3.jsportlet.sev.application", window, function(aNamespace)
{
	aNamespace.ownerinfoform_form_validationRules =
	{
		ownerfirstname :
		{
			required : true,
			maxlength: 30,
			texttransform: 'uppercase'
		},

		ownerlastname :
		{
			required : true,
			maxlength: 30,
			texttransform: 'uppercase'
		},

		owneremail :
		{
			required : true,
			maxlength : 50,
			email: true			
		},

		ownercellphone :
		{
			required : true,
			maxlength : 15,
			digits: true
		},

		ownerphone :
		{
			required : true,
			maxlength : 15,
			digits: true
		},

		owneraddress :
		{
			required : true,
			maxlength: 30,
			texttransform: 'uppercase'
		},

		ownertown :
		{
			required : true,
			maxlength: 30,
			texttransform: 'uppercase'
		},

		ownerzipcode :
		{
			required : true,
			maxlength: 5,
			digits: true
		},

		prop_havehelmsman :
		{
			required : false
		},

		helmsmanfirstname :
		{
			required : true,
			maxlength: 30,
			texttransform: 'uppercase'
		},

		helmsmanlastname :
		{
			required : true,
			maxlength: 30,
			texttransform: 'uppercase'
		},

		helmsmanemail :
		{
			required : true,
			maxlength : 50,
			email: true
		},

		helmsmancellphone :
		{
			required : true,
			maxlength : 15,
			digits: true
		},

		helmsmanphone :
		{
			required : true,
			maxlength : 15,
			digits: true
		},

		helmsmanaddress :
		{
			required : true,
			maxlength: 30,
			texttransform: 'uppercase'
		},

		helmsmantown :
		{
			required : true,
			maxlength: 30,
			texttransform: 'uppercase'
		},

		helmsmanzipcode :
		{
			required : true,
			maxlength: 5,
			digits: true
		}

	};

	aNamespace.ownerinfoform_form_validationMessages =
	{
		ownerfirstname :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		},

		ownerlastname :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		},

		owneremail :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength,
			email: org.r3.message.field_email
		},

		ownercellphone :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength,
			digits: org.r3.message.field_digits
		},

		ownerphone :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength,
			digits: org.r3.message.field_digits
		},

		owneraddress :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		},

		ownertown :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		},

		ownerzipcode :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength,
			digits: org.r3.message.field_digits
		},

		prop_havehelmsman :
		{
			required : org.r3.message.field_required
		},

		helmsmanfirstname :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		},

		helmsmanlastname :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		},

		helmsmanemail :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength,
			email: org.r3.message.field_email
		},

		helmsmancellphone :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength,
			digits: org.r3.message.field_digits
		},

		helmsmanphone :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength,
			digits: org.r3.message.field_digits
		},

		helmsmanaddress :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		},

	    helmsmantown :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		},

		helmsmanzipcode :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength,
			digits: org.r3.message.field_digits
		}
		
	};

});

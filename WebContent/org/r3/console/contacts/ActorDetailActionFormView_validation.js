
$.r3Utils.namespace("org.r3.console.contacts", window, function(aNamespace) 
{

	// Prodotto...
	aNamespace.actordetailactionform_form_validationRules =
		{

			firstname :
			{
				required : true,
				maxlength: 30,
				texttransform: 'uppercase'
			},

			lastname :
			{
				required : true,
				maxlength: 30,
				texttransform: 'uppercase'
			},

		    email :
			{
				required : false,
				maxlength : 50,
				email: true			
			},

			cellphone :
			{
				required : false,
				maxlength : 15,
				digits: true
			},

			phone :
			{
				required : false,
				maxlength : 15,
				digits: true
			},

			address :
			{
				required : false,
				maxlength: 30,
				texttransform: 'uppercase'
			},

			town :
			{
				required : false,
				maxlength: 30,
				texttransform: 'uppercase'
			},

			zipcode :
			{
				required : false,
				maxlength: 5,
				digits: true
			}

		};

		aNamespace.actordetailactionform_form_validationMessages =
		{
			firstname :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			lastname :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			email :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength,
				email: org.r3.message.field_email
			},

			cellphone :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength,
				digits: org.r3.message.field_digits
			},

			phone :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength,
				digits: org.r3.message.field_digits
			},

	        address :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			town :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			zipcode :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength,
				digits: org.r3.message.field_digits
			}

			
		};

	
});

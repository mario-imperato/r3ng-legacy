
$.r3Utils.namespace("org.r3.jsportlet.project.resource", window, function(aNamespace) 
{

	// Prodotto...
	aNamespace.resourcedetailactionform_form_validationRules =
		{

			ssn :
			{
				required : true,
				minlength: 16,
				maxlength: 16,
				texttransform: 'uppercase'
			},
			
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
			},
			
			profileid :
			{
				required : true
			},
				
			teamid :
			{
				required : true
			}

		};

		aNamespace.resourcedetailactionform_form_validationMessages =
		{
			ssn :
			{
				required : org.r3.message.field_required,
				minlength: org.r3.message.field_minlength,
				maxlength: org.r3.message.field_maxlength				
			},
				
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
			},

			profileid :
			{
				required : org.r3.message.field_required
			},
				
			teamid :
			{
				required : org.r3.message.field_required
			}			

			
		};

	
});

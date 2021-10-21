$.r3Utils.namespace("org.r3.console.siteconfig.page", window, function(aNamespace)
{

	// Prodotto...
	aNamespace.pagedetailactionform_form_validationRules =
	{
		pageid :
		{
			required : false,
			maxlength : 25,
			identifier: true
		},

		pagetitle :
		{
			required : true,
			maxlength : 80
		},
		
		pagelink :
		{
			required : true,
			maxlength : 255
		},
		
		pageicon1:
		{
			required : false,
			maxlength : 80
		},

		pageicon2:
		{
			required : false,
			maxlength : 80
		},
		
		permissions: 
		{
			required : false,
			maxlength : 25
		},

		pageorder:
		{
			required : false,
			digits: true,
			maxlength : 5
		},
		
		viewoptions:
		{
			required : false,
			maxlength : 255
		}	
	};

	aNamespace.pagedetailactionform_form_validationMessages =
	{
		pageid :
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength,
			identifier: org.r3.message.field_identifier
		},

		pagetitle :
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength
		},

		pagelink :
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength
		},
		
		pageicon1:
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength
		},

		pageicon2:
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength
		},
		
		permissions: 
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength
		},

		pageorder:
		{
			required : org.r3.message.field_required,
			digits : org.r3.message.field_digits,
			maxlength : org.r3.message.field_maxlength
		},
		
		viewoptions:
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength
		}
		
	};

});

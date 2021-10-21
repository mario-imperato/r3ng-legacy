$.r3Utils.namespace("org.r3.console.siteconfig", window, function(aNamespace)
{
	aNamespace.pkg_fiv_form_validationRules =
	{
			prop_fivclubid :
			{
				required : true,
				maxlength: 15
			},

			prop_fivpasswd :
			{
				required : true,
				maxlength: 15
			}
	};

	aNamespace.pkg_fiv_form_validationMessages =
	{
			prop_prop_fivclubid :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			prop_fivpasswd :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			}
			
	};

});

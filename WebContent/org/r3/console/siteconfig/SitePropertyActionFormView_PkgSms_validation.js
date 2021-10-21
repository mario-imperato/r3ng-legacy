$.r3Utils.namespace("org.r3.console.siteconfig", window, function(aNamespace)
{
	aNamespace.pkg_sms_form_validationRules =
	{
			prop_smslogin :
			{
				required : true,
				maxlength: 15
			},

			prop_smspasswd :
			{
				required : true,
				maxlength: 15
			},

			prop_smssender :
			{
				required : true,
				maxlength : 11	
			}
	};

	aNamespace.pkg_sms_form_validationMessages =
	{
			prop_smslogin :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			prop_smspasswd :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			prop_smssender :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			}
			
	};

});

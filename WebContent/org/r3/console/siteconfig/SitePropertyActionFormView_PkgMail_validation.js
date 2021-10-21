$.r3Utils.namespace("org.r3.console.siteconfig", window, function(aNamespace)
{
	aNamespace.pkg_mail_form_validationRules =
	{
			prop_mail_host :
			{
				required : true,
				maxlength: 40
			},

			prop_mail_auth_account :
			{
				required : true,
				maxlength: 50
			},

			prop_mail_auth_passwd :
			{
				required : true,
				maxlength : 20	
			},
			
			prop_mail_sevcrewchange:
			{
				required : false,
				maxlength: 200
			}			
	};

	aNamespace.pkg_mail_form_validationMessages =
	{
			prop_mail_host :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			prop_mail_auth_account :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			prop_mail_auth_passwd :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},
			
			prop_mail_sevcrewchange:
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			}			
						
	};

});

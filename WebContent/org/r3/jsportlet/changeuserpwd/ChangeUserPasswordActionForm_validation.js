
$.r3Utils.namespace("org.r3.jsportlet.changeuserpwd", window, function(aNamespace) 
{
  aNamespace.changeuserpwdform_form_validationRules = 
  {   		
			currentpassword :
			{
				required : true,
				maxlength: 10
			},

		    password :
			{
				required : true,
				maxlength: 10,
				minlength: org.r3.Constants.passwordValidationMinLength
			},

			confpasswd :
			{
				required : true,
				maxlength: 10,
				minlength: org.r3.Constants.passwordValidationMinLength,
				equalTo: '#changeuserpwdform_password'
			}			
  };
  
  aNamespace.changeuserpwdform_form_validationMessages =
  {
			currentpassword :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},
			
			password :
			{
				required : org.r3.message.field_required,
				minlength: org.r3.message.field_minlength,
				maxlength: org.r3.message.field_maxlength
			},

			confpasswd :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength,
				minlength: org.r3.message.field_minlength,
				equalTo: "La parola chiave di conferma non corrisponde alla parola chiave inserita"
			}

  };
  
});


$.r3Utils.namespace("org.r3.jsportlet.registration", window, function(aNamespace) 
{
  aNamespace.registrationform_form_validationRules = 
  {   		
		securecode:
		{
			required : true,
			maxlength: 8,
			minlength: 5
		},
		
		firstname:
		{
			required : true,
			maxlength: 40,
			texttransform: 'uppercase'
		},

		lastname:
		{
			required : true,
			maxlength: 40,
			texttransform: 'uppercase'
		},

		email:
		{
			required : true,
			maxlength: 60,
			email: true		
		},

		confirmemail:
		{
			required : true,
			maxlength: 60,
			email: true,		
			equalTo: '#registrationform_email'
		},
		
		nickname:
		{
			required : true,
			maxlength: 10,
			texttransform: 'lowercase'
		},

		password:
		{
			required : true,
			maxlength: 10,
			minlength: org.r3.Constants.passwordValidationMinLength
		},
		
		confirm_password:
		{
			required : true,
			maxlength: 10,
			minlength: org.r3.Constants.passwordValidationMinLength,
			equalTo: '#registrationform_password'
		},
		
		activationcode:
		{
			required : false,
			maxlength: 10,
			emptyOrEqualTo: '#registrationform_confactivationcode'
		}
		
			
  };
  
  aNamespace.registrationform_form_validationMessages =
  {
			securecode:
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength,
				minlength: org.r3.message.field_minlength
			},
			
			firstname:
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			lastname:
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength			
			},

			email:
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength,
				email: org.r3.message.field_email		
			},

			confirmemail:
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength,
				email: org.r3.message.field_email,
				equalTo: 'La email inserita non corrisponde alla conferma!' 
			},
			
			nickname:
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			password:
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength,
				minlength: org.r3.message.field_minlength
			},
			
			confirm_password:
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength,
				minlength: org.r3.message.field_minlength,
				equalTo: 'La parola chiave inserita non corrisponde alla conferma!' 
			},
			
			activationcode:
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength,
				emptyOrEqualTo: 'Il codice indicato non corrisponde. Lasciare in bianco se non si dispone di un codice valido fornito dalla Segreteria.'
			}
			
  };
  
});

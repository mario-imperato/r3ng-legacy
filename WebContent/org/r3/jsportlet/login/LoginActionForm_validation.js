
$.r3Utils.namespace("org.r3.jsportlet.login", window, function(aNamespace) 
{
  aNamespace.loginform_form_validationRules = 
  {   		
		nickname:
		{
			required : true,
			maxlength: 60
		},

		password:
		{
			required : true,
			maxlength: 10
		}
			
  };
  
  aNamespace.loginform_form_validationMessages =
  {
		// BOF Customer Selection Validation
		nickname:
		{
			required  : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength
		},

		password:
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength
		}
		  
  };
  
});

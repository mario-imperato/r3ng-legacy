
$.r3Utils.namespace("org.r3.jsportlet.sev.submitcrewcheck", window, function(aNamespace) 
{
  aNamespace.submitcrewcheckform_form_validationRules = 
  {   		

		yachtclubcode:
		{
			required : true,
			maxlength: 15
		},

		yachtclubpwd:
		{
			required : true,
			maxlength: 15
		},
		
		confirm_yachtclubpwd:
		{
			required : true,
			maxlength: 15,
			equalTo: '#submitcrewcheckform_yachtclubpwd'
		}
			
  };
  
  aNamespace.submitcrewcheckform_form_validationMessages =
  {

		    yachtclubcode:
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			yachtclubpwd:
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},
			
			confirm_yachtclubpwd:
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength,
				equalTo: 'La parola chiave inserita non corrisponde alla conferma!' 
			}		  
  };
  
});

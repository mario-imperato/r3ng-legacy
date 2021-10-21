
$.r3Utils.namespace("org.r3.console.sev.application", window, function(aNamespace) 
{

  aNamespace.adminapp_submitcrewcheckform_form_validationRules = 
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
				equalTo: '#adminapp_submitcrewcheckform_yachtclubpwd'
			}
  };
  
  aNamespace.adminapp_submitcrewcheckform_form_validationMessages =
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

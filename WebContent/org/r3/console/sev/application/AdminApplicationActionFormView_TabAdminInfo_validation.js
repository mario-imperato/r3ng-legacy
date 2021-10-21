
$.r3Utils.namespace("org.r3.console.sev.application", window, function(aNamespace) 
{
	
  aNamespace.adminapplicationform_form_validationRules = 
  {   		
			completionstatus :
			{
				required : true
			},

		    verificationstatus :
			{
				required : true
			},

			annotation :
			{
				required : false,
				maxlength: 80
			},

			adminchecks :
			{
				required : false
			}
  };
  
  aNamespace.adminapplicationform_form_validationMessages =
  {
		
			completionstatus :
			{
				required : org.r3.message.field_required
			},

		    verificationstatus :
			{
		    	required : org.r3.message.field_required
			},

			annotation :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			adminchecks :
			{
				required : org.r3.message.field_required
			}

  };


});

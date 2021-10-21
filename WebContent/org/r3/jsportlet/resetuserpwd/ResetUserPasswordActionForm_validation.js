
$.r3Utils.namespace("org.r3.jsportlet.resetuserpwd", window, function(aNamespace) 
{
  aNamespace.resetuserpwdform_form_validationRules = 
  {   		
		securecode:
		{
			required : true,
			maxlength: 8,
			minlength: 5
		},
		
		email:
		{
			required : true,
			maxlength: 60
		},

		nickname:
		{
			required : false,
			maxlength: 10
		}
			
  };
  
  aNamespace.resetuserpwdform_form_validationMessages =
  {
			securecode:
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength,
				minlength: org.r3.message.field_minlength
			},
			
			email:
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			nickname:
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			}

  };
  
});

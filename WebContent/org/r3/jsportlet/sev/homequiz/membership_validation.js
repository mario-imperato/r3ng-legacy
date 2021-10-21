
$.r3Utils.namespace("org.r3.jsportlet.sev.homequiz", window, function(aNamespace) 
{
  aNamespace.membership_form_validationRules = 
  {   		
		membershipid:
		{
			required : true,
			maxlength: 10,
			digits: true
		}
			
  };
  
  aNamespace.membership_form_validationMessages =
  {
		// BOF Customer Selection Validation
		  membershipid:
		{
			required  : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength,
			digits : org.r3.message.field_digits			
		}
		  
  };
  
});

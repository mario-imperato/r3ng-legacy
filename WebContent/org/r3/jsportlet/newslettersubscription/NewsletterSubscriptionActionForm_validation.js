
$.r3Utils.namespace("org.r3.jsportlet.newslettersubscription", window, function(aNamespace) 
{
  aNamespace.newslettersubscription_form_validationRules = 
  {   		
		securecode:
		{
			required : true,
			invalidCSSClass: 'fieldEmpty',
			maxlength: 8,
			minlength: 5
		},
		
		email:
		{
			required : true,
			invalidCSSClass: 'fieldEmpty',
			email: true,
			maxlength: 60
		},

		confirm_email:
		{
			required : true,
			invalidCSSClass: 'fieldEmpty',
			email: true,
			maxlength: 60,
			equalTo: '#newslettersubscription_email'
		}		
					
  };
  
  aNamespace.newslettersubscription_form_validationMessages =
  {			
			securecode:
			{
				required : org.r3.message.field_required,
				invalidCSSClass:  org.r3.message.field_required,
				email: org.r3.message.field_email,
				maxlength: org.r3.message.field_maxlength,
				minlength: org.r3.message.field_minlength
			},
			
			email:
			{
				required : org.r3.message.field_required,
				invalidCSSClass:  org.r3.message.field_required,
				email: org.r3.message.field_email,
				maxlength: org.r3.message.field_maxlength,
			},

			confirm_email:
			{
				required : org.r3.message.field_required,
				invalidCSSClass:  org.r3.message.field_required,
				email: org.r3.message.field_email,
				maxlength: org.r3.message.field_maxlength,
				equalTo: "L''indirizzo di posta elettronica di conferma deve corrispondere" 
			}		
			
  };
  
});

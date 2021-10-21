
$.r3Utils.namespace("org.r3.wbs.towfillout", window, function(aNamespace) 
{

	// Prodotto...
	aNamespace.wbsnodeactionform_form_validationRules =
	{
			
			effort :
			{
				required : true,
				maxlength: 5,
				digits: true
			},
			
			resourceid :
			{
				required : true				
			},
			
			startperiod :
			{
				required : true				
			},
			
			endperiod :
			{
				required : true				
			}			
			
		};

		aNamespace.wbsnodeactionform_form_validationMessages =
		{				
		
				effort :
				{
					required : org.r3.message.field_required,
					maxlength: org.r3.message.field_maxlength,
					digits: org.r3.message.field_digits
				},
				
				resourceid :
				{
					required : org.r3.message.field_required				
				},
				
				startperiod :
				{
					required : org.r3.message.field_required				
				},
				
				endperiod :
				{
					required : org.r3.message.field_required				
				}	
						
		};

	
});

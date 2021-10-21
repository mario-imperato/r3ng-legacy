
$.r3Utils.namespace("org.r3.wbs.wbsfillout", window, function(aNamespace) 
{

	// Prodotto...
	aNamespace.wbsnodeactionform_form_validationRules =
	{
			
			completioneffort :
			{
				required : true,
				maxlength: 5,
				digits: true,
				greaterThan: '#wbsnodeactionform_current_completioneffort'
			},
			
			economicvalue :
			{
				required : true,
				maxlength: 8,
				number: true,
				min : 0
			}

		};

		aNamespace.wbsnodeactionform_form_validationMessages =
		{				
				completioneffort :
				{
					required : org.r3.message.field_required,
					maxlength: org.r3.message.field_maxlength,
					digits: org.r3.message.field_digits,
					greaterThan: org.r3.wbs.wbsfillout.message.wbsnodeactionform_completioneffort_greaterThan_validation
				},
		
		economicvalue :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength,
			number: org.r3.message.field_number,
			min : org.r3.message.field_min
		}
						
		};

	
});

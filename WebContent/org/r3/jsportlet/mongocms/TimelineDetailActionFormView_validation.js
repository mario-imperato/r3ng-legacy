
$.r3Utils.namespace("org.r3.jsportlet.mongocms", window, function(aNamespace) 
{

	// Prodotto...
	aNamespace.timelinedetailactionform_validationRules =
		{
			
			title :
			{
				required : true,
				maxlength: 80
			},
			
			description: 
			{
				required : true,
				maxlength: 512
			}
			
		};

		aNamespace.timelinedetailactionform_validationMessages =
		{
					
			title :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},
			
			description :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			}				
		};

	
});

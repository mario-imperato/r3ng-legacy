
$.r3Utils.namespace("org.r3.console.tow", window, function(aNamespace) 
{

	// Prodotto...
	aNamespace.wbsnodeactionform_form_validationRules =
	{

			nodename :
			{
				required : true,
				maxlength : 40
			},
			
			startdate :
			{
				required : true
			},
			
			enddate :
			{
				required : true
			},
			
			nodesummary :
			{
				required : true,
				maxlength: 255
			}
			
		};

		aNamespace.wbsnodeactionform_form_validationMessages =
		{
				nodename :
				{
					required : org.r3.message.field_required,
					maxlength: org.r3.message.field_maxlength
				},
				
				startdate :
				{
					required : org.r3.message.field_required					
				},
				
				enddate :
				{
					required : org.r3.message.field_required					
				},
				
				nodesummary :
				{
					required : org.r3.message.field_required,
					maxlength: org.r3.message.field_maxlength
				}				
		
		};

	
});


$.r3Utils.namespace("org.r3.console.bbs", window, function(aNamespace) 
{

	// Prodotto...
	aNamespace.threadnodedetailactionform_form_validationRules =
		{
			nodetitle:
			{
				required : true,
				maxlength: 80				
			},
			
			nodetext :
			{
				required : true,
				maxlength: 8192
			}
		};

		aNamespace.threadnodedetailactionform_form_validationMessages =
		{
			nodetext :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			nodetitle:
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			}
			
		};

	
});

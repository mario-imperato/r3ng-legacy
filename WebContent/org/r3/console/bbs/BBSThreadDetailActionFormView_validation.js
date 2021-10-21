$.r3Utils.namespace("org.r3.console.bbs", window, function(aNamespace) {

	// Prodotto...
	aNamespace.threaddetailactionform_form_validationRules = 
	{
		threadid : 
		{
			required : false,
			maxlength : 15,
			identifier : true,
			texttransform: 'uppercase'
		},

		threadtitle : 
		{
			required : true,
			maxlength : 80,
			texttransform : 'uppercase'
		}
	};

	aNamespace.threaddetailactionform_form_validationMessages = 
	{		
		threadid : 
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength,
			identifier : org.r3.message.field_identifier
		},
		
		threadtitle : 
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength
		}

	};

});

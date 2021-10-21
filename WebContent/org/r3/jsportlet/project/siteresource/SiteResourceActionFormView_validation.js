$.r3Utils.namespace("org.r3.jsportlet.project.siteresource", window, function(aNamespace) {
	
	aNamespace.siteresourceform_validationRules = 
	{
		cost : 
		{
			required : true,
			maxlength : 5,
			number : true,
			min: 0
		},

		price : 
		{
			required : true,
			maxlength : 5,
			number : true,
			min: 0
		}

	};

	aNamespace.siteresourceform_validationMessages = 
	{
		cost : 
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength,
			number : org.r3.message.field_number,
			min : org.r3.message.field_min
		},

		price : 
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength,
			number : org.r3.message.field_number,
			min : org.r3.message.field_min
		}

	};

});

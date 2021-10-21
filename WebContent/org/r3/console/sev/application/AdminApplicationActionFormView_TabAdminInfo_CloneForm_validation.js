$.r3Utils.namespace("org.r3.console.sev.application", window, function(aNamespace) {

	aNamespace.adminapp_cloneform_validationRules = 
	{
		cloneeventid : 
		{
			required : true
		}
	};

	aNamespace.adminapp_cloneform_validationMessages = {

		cloneeventid : 		
		{
			required : org.r3.message.field_required
		}

	};

});

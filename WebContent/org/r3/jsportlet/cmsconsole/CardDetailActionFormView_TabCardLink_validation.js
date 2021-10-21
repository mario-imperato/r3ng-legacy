$.r3Utils.namespace("org.r3.jsportlet.cmsconsole", window, function(aNamespace)
{

	// Prodotto...
	aNamespace.cardlinkactionform_form_validationRules =
	{
		propertyname :
		{
			required : true,
			maxlength : 80
		},

		propertyvalue :
		{
			required : true,
			maxlength : 255
		},
		
		refpropertyid :
		{
			required : false
		}
		
	};

	aNamespace.cardlinkactionform_form_validationMessages =
	{
		propertyname :
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength
		},
		
		propertyvalue :
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength
		},
		
		refpropertyid :
		{
			required : org.r3.message.field_required
		}
				
	};

});

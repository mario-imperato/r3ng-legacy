$.r3Utils.namespace("org.r3.jsportlet.mongocms", window, function(aNamespace)
{

	// Prodotto...
	aNamespace.postlinkactionform_validationRules =
	{
		name :
		{
			required : true,
			maxlength : 80
		},

		href :
		{
			required : true,
			maxlength : 255
		},
		
		refattachmentid :
		{
			required : false
		}
		
	};

	aNamespace.postlinkactionform_validationMessages =
	{
		name :
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength
		},
		
		href :
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength
		},
		
		refattachmentid :
		{
			required : org.r3.message.field_required
		}
				
	};

});

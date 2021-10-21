$.r3Utils.namespace("org.r3.db.mongo.contentdefinitioncollection.shkstruct", window, function(aNamespace)
{
	aNamespace.shkstruct_validation_rules =
	{
		message:
		{
			required : true,
			maxlength : 250	
		}
					
	};

	aNamespace.shkstruct_validation_messages =
	{
		message:
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		}
	};

});

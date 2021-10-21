$.r3Utils.namespace("org.r3.db.mongo.contentdefinitioncollection.shkmessage", window, function(aNamespace)
{
	aNamespace.shkmessage_validation_rules =
	{
		message:
		{
			required : true,
			maxlength : 512	
		}
					
	};

	aNamespace.shkmessage_validation_messages =
	{
		message:
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		}
	};

});

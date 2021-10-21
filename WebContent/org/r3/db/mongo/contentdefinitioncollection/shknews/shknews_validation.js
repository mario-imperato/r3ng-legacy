$.r3Utils.namespace("org.r3.db.mongo.contentdefinitioncollection.shknews", window, function(aNamespace)
{
	aNamespace.shknews_validation_rules =
	{
		message:
		{
			required : true,
			maxlength : 250	
		}
					
	};

	aNamespace.shknews_validation_messages =
	{
		message:
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		}
	};

});

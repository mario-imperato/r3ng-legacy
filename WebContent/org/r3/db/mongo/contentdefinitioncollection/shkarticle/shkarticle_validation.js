$.r3Utils.namespace("org.r3.db.mongo.contentdefinitioncollection.shkarticle", window, function(aNamespace)
{
	aNamespace.shkarticle_validation_rules =
	{
		message:
		{
			required : true,
			maxlength : 250	
		}
					
	};

	aNamespace.shkarticle_validation_messages =
	{
		message:
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		}
	};

});

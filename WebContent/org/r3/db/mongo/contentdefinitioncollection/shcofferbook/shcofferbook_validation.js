$.r3Utils.namespace("org.r3.db.mongo.contentdefinitioncollection.shcofferbook", window, function(aNamespace)
{
	aNamespace.shcofferbook_validation_rules =
	{
			message:
		{
			required : true,
			maxlength : 80	
		}
		
		
			
	};

	aNamespace.shcofferbook_validation_messages =
	{
			message:
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		}
	};

});

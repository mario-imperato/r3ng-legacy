$.r3Utils.namespace("org.r3.db.mongo.contentdefinitioncollection.shcaskoffer", window, function(aNamespace)
{
	aNamespace.shcaskoffer_validation_rules =
	{
			shcaskoffer:
		{
			required : true,
			maxlength : 80	
		}
		
		
			
	};

	aNamespace.shcaskoffer_validation_messages =
	{
			shcaskoffer:
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		}
	};

});

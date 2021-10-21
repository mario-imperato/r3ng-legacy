$.r3Utils.namespace("org.r3.db.mongo.contentdefinitioncollection.tweet", window, function(aNamespace)
{
	aNamespace.tweet_validation_rules =
	{
		tweet:
		{
			required : true,
			maxlength : 512	
		}
		
		
			
	};

	aNamespace.tweet_validation_messages =
	{
	    tweet:
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		}
	};

});

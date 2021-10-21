$.r3Utils.namespace("org.r3.db.mongo.contentdefinitioncollection.shcoffer", window, function(aNamespace)
{
	aNamespace.shcoffer_validation_rules =
	{
		what:
		{
			required : true,
			maxlength : 80	
		},

		availability:
		{
			required : true,
			maxlength : 10,
			digits: true
		},									

		unitprice:
		{
			required : true,
			maxlength : 10,
			digits: true
		},									
			
		description:
		{
			required : true,
			maxlength : 255	
		}
			
	};

	aNamespace.shcoffer_validation_messages =
	{
		what:
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		},
		
		availability:
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength,
			digits: org.r3.message.field_digits			
		},
		
		unitprice:
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength,
			digits: org.r3.message.field_digits					
		},
		
		description:
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		}
		
	};

});

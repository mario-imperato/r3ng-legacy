$.r3Utils.namespace("org.r3.db.mongo.contentdefinitioncollection.shcask", window, function(aNamespace)
{
	aNamespace.shcask_validation_rules =
	{
			what:
			{
				required : true,
				maxlength : 80	
			},

			unitprice:
			{
				required : false,
				maxlength : 10,
				digits: true
			},									
				
			description:
			{
				required : true,
				maxlength : 255	
			}			
	};

	aNamespace.shcask_validation_messages =
	{
			what:
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
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

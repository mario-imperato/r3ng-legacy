$.r3Utils.namespace("org.r3.jsportlet.project.team", window, function(aNamespace)
{
	aNamespace.teamresource_form_validationRules =
	{
			resourceid :
			{
				required : true
			},
	
		profileid :
		{
			required : true
		}

	};

	aNamespace.teamresource_form_validationMessages =
	{
			resourceid :
			{
				required : org.r3.message.field_required
			},
			
			profileid :
			{
				required : org.r3.message.field_required
			}

	};

});

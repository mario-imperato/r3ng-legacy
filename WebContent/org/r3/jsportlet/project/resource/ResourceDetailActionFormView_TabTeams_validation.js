$.r3Utils.namespace("org.r3.jsportlet.project.resource", window, function(aNamespace)
{
	aNamespace.resourceteam_form_validationRules =
	{
			teamid :
			{
				required : true
			},
	
		profileid :
		{
			required : true
		}

	};

	aNamespace.resourceteam_form_validationMessages =
	{
			teamid :
			{
				required : org.r3.message.field_required
			},
			
			profileid :
			{
				required : org.r3.message.field_required
			}

	};

});

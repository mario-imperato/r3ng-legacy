$.r3Utils.namespace("org.r3.jsportlet.project.teamtimesheet", window, function(aNamespace)
{
	aNamespace.teamtimesheet_form_validationRules =
	{
	  resourceid :
	  {
				required : true
			},
	
			ordeffort :
		{
			required : true
		}

	};

	aNamespace.teamtimesheet_form_validationMessages =
	{
			resourceid :
			{
				required : org.r3.message.field_required
			},
			
			ordeffort :
			{
				required : org.r3.message.field_required
			}

	};

});

$.r3Utils.namespace("org.r3.jsportlet.project.teamtimesheetreport", window, function(aNamespace)
{
	aNamespace.teamtimesheetreport_form_validationRules =
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

	aNamespace.teamtimesheetreport_form_validationMessages =
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

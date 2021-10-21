$.r3Utils.namespace("org.r3.console.siteconfig", window, function(aNamespace)
{
	aNamespace.pkg_googleanalytics_form_validationRules =
	{
			prop_domain:
			{
				required: true				
			},

			prop_trackerid:
	        {
		       required: true				
	        }
	};

	aNamespace.pkg_googleanalytics_form_validationMessages =
	{
			prop_domain:
			{
				required: org.r3.message.field_required
			},

			prop_trackerid:
	        {
	        	required: org.r3.message.field_required				
	        }
			
	};

});

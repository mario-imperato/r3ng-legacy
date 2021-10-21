$.r3Utils.namespace("org.r3.console.contacts", window, function(aNamespace)
{
	aNamespace.actorQueryActionFormView_filter_searchform_validationRules =
	{
		filter_item :
		{
			required : false
		}

	};

	aNamespace.actorQueryActionFormView_filter_searchform_validationMessages =
	{
		filter_item :
		{
			required : org.r3.message.field_required
		}
	};

});

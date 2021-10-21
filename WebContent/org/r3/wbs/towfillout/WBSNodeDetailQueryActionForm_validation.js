$.r3Utils.namespace("org.r3.wbs.towfillout", window, function(aNamespace)
{
	aNamespace.queryfilter_searchform_validationRules =
	{
		filter_item :
		{
			required : false
		}

	};

	aNamespace.queryfilter_searchform_validationMessages =
	{
		filter_item :
		{
			required : org.r3.message.field_required
		}
	};

});

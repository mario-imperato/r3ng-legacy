$.r3Utils.namespace("org.r3.jsportlet.mongocms", window, function(aNamespace)
{
	aNamespace.advancedsearchform_form_validationRules =
	{
		postid :
		{
			required : false,
			maxlength : 24
		}
	};

	aNamespace.advancedsearchform_form_validationMessages =
	{
			postid :
			{
				required : org.r3.message.field_required,
				maxlength : org.r3.message.field_maxlength
			}
	};

});

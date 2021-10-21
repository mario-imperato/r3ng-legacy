$.r3Utils.namespace("org.r3.jsportlet.cmsconsole", window, function(aNamespace)
{
	aNamespace.advancedsearchform_form_validationRules =
	{
		cardid :
		{
			required : false,
			maxlength : 15
		}
	};

	aNamespace.advancedsearchform_form_validationMessages =
	{
			cardid :
			{
				required : org.r3.message.field_required,
				maxlength : org.r3.message.field_maxlength
			}
	};

});

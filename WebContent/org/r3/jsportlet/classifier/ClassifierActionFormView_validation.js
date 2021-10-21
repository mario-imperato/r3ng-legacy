$.r3Utils.namespace("org.r3.jsportlet.classifier", window, function(aNamespace)
{
	aNamespace.classifier_form_validationRules =
	{
		clsdescr :
		{
			required : true,
			maxlength: 255
  	    }
	};

	aNamespace.classifier_form_validationMessages =
	{
		clsdescr :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
  	    }
	};

});

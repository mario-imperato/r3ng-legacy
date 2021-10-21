
$.r3Utils.namespace("org.r3.jsportlet.project.team", window, function(aNamespace) 
{

	// Prodotto...
	aNamespace.teamdetailactionform_form_validationRules =
		{

			teamdescr :
			{
				required : false,
				maxlength: 40,
				texttransform: 'uppercase'
			}

		};

		aNamespace.teamdetailactionform_form_validationMessages =
		{
				teamdescr :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			}
			
		};

	
});

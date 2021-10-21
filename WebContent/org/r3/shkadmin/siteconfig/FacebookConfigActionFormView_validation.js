
$.r3Utils.namespace("org.r3.shkadmin.siteconfig", window, function(aNamespace) 
{

	// Prodotto...
	aNamespace.facebookconfigform_form_validationRules =
		{
			
			prop_pageurl :
			{
				maxlength: 100
			}
			
		};

		aNamespace.facebookconfigform_form_validationMessages =
		{
		
			prop_pageurl :
			{
				maxlength: org.r3.message.field_maxlength
			}

		};
	
		
		aNamespace.getfacebookpagetokenform_form_validationRules =
		{
			
			fbpageid :
			{
				required: true
			}
			
		};

		aNamespace.getfacebookpagetokenform_form_validationMessages =
		{
		
				fbpageid :
			{
					required: org.r3.message.field_required
			}

		};
		
});

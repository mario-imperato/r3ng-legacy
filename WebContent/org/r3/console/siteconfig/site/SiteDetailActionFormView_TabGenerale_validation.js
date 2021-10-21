$.r3Utils.namespace("org.r3.console.siteconfig.site", window, function(aNamespace)
{

	// Prodotto...
	aNamespace.sitedetailactionform_form_validationRules =
	{
			sitedescr :
			{
				required : true,
				maxlength: 40
			},

		    siteresourcepath :
			{
				required : true
			},						

		    sitetheme :
			{
				required : true
			},	
			
			eventdescr:
			{
				required : true,
				maxlength: 128
			}
		
	};

	aNamespace.sitedetailactionform_form_validationMessages =
	{
			sitedescr :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

		    siteresourcepath :
			{
				required : org.r3.message.field_required
			},
			
		    sitetheme :
			{
				required : org.r3.message.field_required
			},
						
			eventdescr:
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			}
		
	};

});

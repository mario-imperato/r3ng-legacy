
$.r3Utils.namespace("org.r3.console.regattas", window, function(aNamespace) 
{

	// Prodotto...
	aNamespace.regattadetailactionform_form_validationRules =
		{
			sitetype :
			{
				required : true
			},
			
			site :
			{
				required : true,
				maxlength: 15,
				identifier: true,
				texttransform: 'lowercase'
			},

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
			
			refsitetype:
			{
				required : true
			},
				
			refsite:
			{
				required : true,
				maxlength: 128
			},

			refsitedescr:
			{
				required : true,
				maxlength: 128
			},

			admrefsitetype:
			{
				required : true
			},
				
			admrefsite:
			{
				required : true,
				maxlength: 128
			},

			admrefsitedescr:
			{
				required : true,
				maxlength: 128
			},
			
			eventdescr:
			{
				required : true,
				maxlength: 128
			}

			
		};

		aNamespace.regattadetailactionform_form_validationMessages =
		{
			sitetype :
			{
				required : org.r3.message.field_required			
			},

			site :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength,
				identifier: org.r3.message.field_identifier
			},

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
			
			refsitetype:
			{
				required : org.r3.message.field_required
			},
				
			refsite:
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			refsitedescr:
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			admrefsitetype:
			{
				required : org.r3.message.field_required
			},
				
			admrefsite:
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			admrefsitedescr:
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			eventdescr:
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			}
			
		};

	
});

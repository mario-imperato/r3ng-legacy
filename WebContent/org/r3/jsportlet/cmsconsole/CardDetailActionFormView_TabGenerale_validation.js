$.r3Utils.namespace("org.r3.jsportlet.cmsconsole", window, function(aNamespace)
{

	// Prodotto...
	aNamespace.carddetailactionform_form_validationRules =
	{
		cardid :
		{
			required : false,
			maxlength : 25,
			identifier: true
		},

		systemtitle :
		{
			required : true,
			maxlength : 80
		},
		
		categoryid:
		{
			required : true				
		},
		
		validityrule: 
		{
			required : true		
		},
			
		validfrom:
		{
			required : true,		
		},
		
		validto:
		{
			required : true
		},
		
		pagelinktype:
		{
			required : true			
		},

		pagelink:
		{
			required : true,
			maxlength: 255
		},

		pageid:
		{
			required : true			
		},
		
		refdate:
		{
			required : true			
		}
		

	};

	aNamespace.carddetailactionform_form_validationMessages =
	{
		cardid :
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength,
			identifier: org.r3.message.field_identifier
		},

		systemtitle :
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength
		},

		categoryid :
		{
			required : org.r3.message.field_required
		},

		validityrule: 
		{
			required : org.r3.message.field_required
		},
			
		validfrom:
		{
			required : org.r3.message.field_required	
		},
		
		validto:
		{
			required : org.r3.message.field_required
		},

		pagelinktype:
		{
			required : org.r3.message.field_required
		},

		pagelink:
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength
		},

		pageid:
		{
			required : org.r3.message.field_required			
		},
		
		refdate:
		{
			required : org.r3.message.field_required			
		}
		
	};

});

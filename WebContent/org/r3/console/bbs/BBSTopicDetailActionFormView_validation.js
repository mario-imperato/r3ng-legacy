
$.r3Utils.namespace("org.r3.console.bbs", window, function(aNamespace) 
{

	// Prodotto...
	aNamespace.topicdetailactionform_form_validationRules =
	{
			topicid :
			{
				required : false,
				maxlength : 15,
				identifier: true,
				texttransform: 'uppercase'
			},
			
			topictitle :
			{
				required : true,
				maxlength: 80,
				texttransform: 'uppercase'
			}
	};

	aNamespace.topicdetailactionform_form_validationMessages =
	{
			topicid :
			{
				required : org.r3.message.field_required,
				maxlength : org.r3.message.field_maxlength,
				identifier: org.r3.message.field_identifier
			},

			topictitle :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			}
			
	};

	
});


$.r3Utils.namespace("org.r3.jsportlet.outmail", window, function(aNamespace) 
{

	// Prodotto...
	aNamespace.outmailmessageactionform_form_validationRules =
		{
			actorgroup:
			{
			    required: function() {  
			    	return ($('#smsdetailactionform_mailopt_send2all').prop('checked') || !$.r3Utils.isFieldEmpty($('#outmailmessageactionform_msgto'))) ? false : true; 
			    }	
			},
			
			msgto :
			{
				required : false,
				maxlength: 255
			},

			msgcc :
			{
				required : false,
				maxlength: 255
			},

			msgbcc :
			{
				required : false,
				maxlength: 255
			},

			msgtitle :
			{
				required : true,
				maxlength : 255
			}

		};

		aNamespace.outmailmessageactionform_form_validationMessages =
		{
			actorgroup:
			{
			    required: org.r3.message.field_required	
			},
				
			msgto :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			msgcc :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			msgbcc :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			msgtitle :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			}			
		};

	
});

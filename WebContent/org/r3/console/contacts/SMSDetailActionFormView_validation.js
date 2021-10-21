
$.r3Utils.namespace("org.r3.console.contacts", window, function(aNamespace) 
{

	// Prodotto...
	aNamespace.smsdetailactionform_form_validationRules =
		{
			actorgroup:
			{
			    required: function() {  
			    	return ($('#smsdetailactionform_smsopts_send2all').prop('checked')) ? false : true; 
			    }	
			},
			
			smslogin :
			{
				required : true,
				maxlength: 15
			},

			smspasswd :
			{
				required : true,
				maxlength: 15
			},

			smssender :
			{
				required : true,
				maxlength : 11	
			},

			smstext :
			{
				required : true,
				maxlength : function() { return ($('#smsdetailactionform_smsopts_charlimit').prop('checked')) ? 160 : 512; }
			}

		};

		aNamespace.smsdetailactionform_form_validationMessages =
		{
			actorgroup:
			{
			    required: org.r3.message.field_required	
			},
				
			smslogin :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			smspasswd :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			smssender :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			},

			smstext :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength
			}			
		};

	
});

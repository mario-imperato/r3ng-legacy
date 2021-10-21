$.r3Utils.namespace("org.r3.jsportlet.mongocms", window, function(aNamespace)
{

	// Prodotto...
	aNamespace.carddetailactionform_form_validationRules =
	{
		postid :
		{
			required : false,
			maxlength : 25,
			identifier: true
		},

		title :
		{
			required : true,
			maxlength : 80
		},
		
		contentcategory:
		{
			required : true								
		},
		
		contentclass:
		{
			required : true				
		}		

	};

	aNamespace.carddetailactionform_form_validationMessages =
	{
		postid :
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength,
			identifier: org.r3.message.field_identifier
		},

		title :
		{
			required : org.r3.message.field_required,
			maxlength : org.r3.message.field_maxlength
		},

		contentcategory:
		{
			required : org.r3.message.field_required							
		},

		contentclass :
		{
			required : org.r3.message.field_required
		}		
	};

});

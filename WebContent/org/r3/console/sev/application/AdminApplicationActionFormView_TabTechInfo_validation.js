
$.r3Utils.namespace("org.r3.console.sev.application", window, function(aNamespace) 
{

  aNamespace.adminraceinfoapplicationactionform_form_validationRules = 
  {   		
			adminracegroup :
			{
				required : true
			},

			adminraceclass :
			{
				required : false
			},

			yachtbsf :
			{
				required : false,
				maxlength: 10,
				number: true
			},

			yachtgph :
			{
				required : false,
				maxlength: 10,
				number: true
			}
  };
  
  aNamespace.adminraceinfoapplicationactionform_form_validationMessages =
  {
		
			adminracegroup :
			{
				required : org.r3.message.field_required
			},

			adminraceclass :
			{
				required : org.r3.message.field_required
			},

			yachtbsf :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength,
				number: org.r3.message.field_number
			},

			yachtgph :
			{
				required : org.r3.message.field_required,
				maxlength: org.r3.message.field_maxlength,
				number: org.r3.message.field_number
			}

  };

});

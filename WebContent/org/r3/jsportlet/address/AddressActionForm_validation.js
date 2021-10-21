
$.r3Utils.namespace("org.r3.jsportlet.address", window, function(aNamespace) 
{
  aNamespace.addressform_form_validationRules = 
  {   		
		administrative_area_level_1_id :
		{
			required : true
		},			

		administrative_area_level_2_id :
		{
			required : true
		},			

		administrative_area_level_3_id :
		{
			required : true
		},			

  	    zipcode :
		{
			required : true,
			maxlength: 5
		},

  	    address :
		{
			required : true,
			maxlength: 40
		}	
  };
  
  aNamespace.addressform_form_validationMessages =
  {
		administrative_area_level_1_id :
		{
			required : org.r3.message.field_required
		},

		administrative_area_level_2_id :
		{
			required : org.r3.message.field_required
		},

		administrative_area_level_3_id :
		{
			required : org.r3.message.field_required
		},

		address :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		},
		
		zipcode :
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		}		

  };
  
});

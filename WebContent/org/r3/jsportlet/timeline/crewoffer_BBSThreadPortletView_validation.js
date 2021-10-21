$.r3Utils.namespace("org.r3.jsportlet.timeline", window, function(aNamespace)
{
	aNamespace.crewoffer_jsportlettimelineform_form_validationRules =
	{
		nodetitle:
		{
			required : true,
			maxlength : 80	
		},
		
		crewrole:
		{
			required : false
		},
		
		crewlevel:
		{
			required : false
		},

		ownername:
		{
			required : true,
			maxlength : 60	
		},
		
		crewname:
		{
			required : true,
			maxlength : 60	
		},

		owneremail:
		{
			required : true,
			email: true,
			maxlength : 60	
		},
		
		crewemail:
		{
			required : true,
			email: true,
			maxlength : 60	
		},

		ownerphone:
		{
			required : true,
			digits: true,
			maxlength : 15	
		},
			
		crewphone:
		{
			required : true,
			digits: true,
			maxlength : 15	
		},

		crewweight:
		{
			required : false,
			digits: true,
			maxlength : 6	
		},

		crewheight:
		{
			required : false,
			digits: true,
			maxlength : 6	
		},
		
		crewage:
		{
			required : false,
			digits: true,
			maxlength : 6	
		},

		crewinfo:
		{
			required : false,
			maxlength : 255	
		},									
			
		yachtinfo:
		{
			required : false,
			maxlength : 255	
		},
		
		yachtname:
		{
			required : true,
			maxlength : 30	
		},
		
		yachtmodel:
		{
			required : true,
			maxlength : 30	
		}
			
	};

	aNamespace.crewoffer_jsportlettimelineform_form_validationMessages =
	{
		nodetitle:
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		},
		
		crewrole:
		{
			required : org.r3.message.field_required
		},
		
		crewlevel:
		{
			required : org.r3.message.field_required
		},

		ownername:
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		},
		
		crewname:
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength	
		},

		ownermail:
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength,
			email: org.r3.message.field_email,		
		},
			
		crewemail:
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength,
			email: org.r3.message.field_email,		
		},

		ownerphone:
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength,
			digits: org.r3.message.field_digits		
		},

		crewphone:
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength,
			digits: org.r3.message.field_digits		
		},

		crewweight:
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength,
			digits: org.r3.message.field_digits
			
		},

		crewheight:
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength,
			digits: org.r3.message.field_digits
			
		},
		
		crewage:
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength,
			digits: org.r3.message.field_digits
				
		},

		crewinfo:
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		},								
		
		yachtinfo:
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		},
		
		yachtname:
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		},
		
		yachtmodel:
		{
			required : org.r3.message.field_required,
			maxlength: org.r3.message.field_maxlength
		}		
	};

});

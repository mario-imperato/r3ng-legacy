
$.r3Utils.namespace("org.r3.jsportlet.wbs", window, function(aNamespace) 
{

	// Prodotto...
	aNamespace.wbsnodeactionform_form_validationRules =
	{

			nodename :
			{
				required : true,
				maxlength : 40
			},

			assignedto :
			{
				required : true
			},
			
			startdate :
			{
				required : true
			},
			
			duration :
			{
				required : true,
				maxlength: 5,
				digits: true,
				min: 1,
				max: 365
			},

			completion :
			{
				required : true,
				maxlength: 5,
				number   : true,
				range: [0, 100]
			},
			
			completiondescr:
			{
				required : false,
				maxlength: 80
			},

			completionfrom:
			{
				required : true,
				maxlength: 5,
				digits   : true,
				min : 0
			},
			
			completionto:
			{
				required : true,
				maxlength: 5,
				digits   : true,
				greaterThan: '#wbsnodeactionform_completionfrom'
			},			
			
			nodesummary :
			{
				required : true,
				maxlength: 255
			},
			
			completioneffort :
			{
				required : false,
				maxlength: 5,
				digits: true
			},

			economicvalue :
			{
				required : false,
				maxlength: 8,
				number   : true,
				min: 0
			},

			economicvalue2 :
			{
				required : false,
				maxlength: 8,
				number   : true,
				min: 0
			},

			economicvalue3 :
			{
				required : false,
				maxlength: 8,
				number   : true,
				min: 0
			},

			stereotype:
			{
				required : true					
			}
		};

		aNamespace.wbsnodeactionform_form_validationMessages =
		{
				nodename :
				{
					required : org.r3.message.field_required,
					maxlength: org.r3.message.field_maxlength
				},

				assignedto :
				{
					required : org.r3.message.field_required				
				},
				
				startdate :
				{
					required : org.r3.message.field_required					
				},
				
				duration :
				{
					required : org.r3.message.field_required,
					maxlength: org.r3.message.field_maxlength,
					digits: org.r3.message.field_digits,
					min: org.r3.message.field_min,
					max: org.r3.message.field_max
				},

				completion :
				{
					required : org.r3.message.field_required,
					maxlength: org.r3.message.field_maxlength,
					number   : org.r3.message.field_number,
					range: org.r3.message.field_range
				},

				completiondescr:
				{
					required : org.r3.message.field_required,
					maxlength: org.r3.message.field_maxlength				
				},

				completionfrom:
				{
					required : org.r3.message.field_required,
					maxlength: org.r3.message.field_maxlength,
					digits   : org.r3.message.field_digits,
					min      : org.r3.message.field_min,
				},
				
				completionto:
				{
					required : org.r3.message.field_required,
					maxlength: org.r3.message.field_maxlength,
					digits   : org.r3.message.field_digits,				
					greaterThan: org.r3.message.field_greaterThan
				},
				
				nodesummary :
				{
					required : org.r3.message.field_required,
					maxlength: org.r3.message.field_maxlength
				},
				
				completioneffort :
				{
					required : org.r3.message.field_required,
					maxlength: org.r3.message.field_maxlength,
					digits: org.r3.message.field_digits
				},

				economicvalue :
				{
					required : org.r3.message.field_required,
					maxlength: org.r3.message.field_maxlength,
					number   : org.r3.message.field_number,
					min: org.r3.message.field_min
				},						

				economicvalue2 :
				{
					required : org.r3.message.field_required,
					maxlength: org.r3.message.field_maxlength,
					number   : org.r3.message.field_number,
					min: org.r3.message.field_min
				},						

				economicvalue3 :
				{
					required : org.r3.message.field_required,
					maxlength: org.r3.message.field_maxlength,
					number   : org.r3.message.field_number,
					min: org.r3.message.field_min
				},						

				stereotype:
				{
					required : org.r3.message.field_required
				}
		
		};

	
});

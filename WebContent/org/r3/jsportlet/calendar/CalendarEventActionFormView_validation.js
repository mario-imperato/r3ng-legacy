$.r3Utils.namespace("org.r3.jsportlet.calendar", window, function(aNamespace)
{
	aNamespace.calendarevent_form_validationRules =
	{
		title :
		{
			required : true,
			maxlength : 80	
		},

		startdate_date :
		{
			required : true,
			dpDate : true	
		},
		
		enddate_date :
		{
			required : true,
			dpDate : true,
			dpCompareDate : [ 'notBefore', '#calendarevent_form_startdate_date' ]
		},
		
		startdate_time:
		{
		    required: false,
		    timevalue: true
		},
		
		enddate_time:
		{
		    required: false,
		    timevalue: true,
		    gdatetime_range: [ '#calendarevent_form_startdate', '#calendarevent_form_enddate' ]
		}
		
	};

	aNamespace.calendarevent_form_validationMessages =
	{
			title :
			{
				required : org.r3.message.field_required,
				maxlength : org.r3.message.field_maxlength
			},

			startdate_date :
			{
				required : org.r3.message.field_required,
				dpDate : org.r3.message.field_dpDate	
			},

	        enddate_date :
	        {
		        required : org.r3.message.field_required,
		        dpDate : org.r3.message.field_dpDate,
		        dpCompareDate : org.r3.message.field_dpDateRange
	        },

			startdate_time:
			{
				required : org.r3.message.field_required,
				timevalue: org.r3.message.field_timevalue
			},

			enddate_time:
			{
				required : org.r3.message.field_required,
			    timevalue: org.r3.message.field_timevalue
			}	        
	
	};

});

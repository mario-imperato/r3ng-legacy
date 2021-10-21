$.r3Utils.namespace("org.r3.jsportlet.calendar");

org.r3.jsportlet.calendar.CalendarEventActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.calendarWidget = null;
	},

	close : function()
	{
		$("#calendarevent-dialog-form").modal('hide');
	},

	show : function(anExecuteSearchFunction)
	{
		$("#calendarevent-dialog-form").modal();
	},

	onNewEvent: function(calWidget, start, end, theView)
	{		
		this.calendarWidget = calWidget;
		$("#calendarevent-dialog-form").modal();
		
		var validator = $("#calendarevent_form").data('validator');
		
		validator.resetForm();
		$("#calendarevent_form .error").removeClass("error");				
		
		this._allDayInitialization(false);
		$('#calendarevent_form_calendarid').val('');
		
		$('#calendarevent_form_startdate_date').val(start.format("DD/MM/YYYY"));		
        // $('#calendarevent_form_enddate_date').val(end.subtract('days', 1).format("DD/MM/YYYY"));
		
		if (theView.name == 'month')
			 this._hoursDefaultInitialization();
		else this._hoursInitialization(start, end);        
        
        $('#calendarevent_action_delete').hide();

	},

	onUpdateEvent: function(calWidget, theEvent)
	{
        this.calendarWidget = calWidget;
		
		var validator = $("#calendarevent_form").data('validator');
		
		validator.resetForm();
		$("#calendarevent_form .error").removeClass("error");
		
		$("#calendarevent-dialog-form").modal();
		
		this._allDayInitialization(theEvent.allDay);
		
		$('#calendarevent_form_title').val(theEvent.title);
		$('#calendarevent_form_calendarid').val(theEvent.id);
		
		$('#calendarevent_form_startdate_date').val(theEvent.start.format("DD/MM/YYYY"));		
        // $('#calendarevent_form_enddate_date').val(theEvent.end.format("DD/MM/YYYY"));

        if (theEvent.start.hasTime())
        {
    		$('#calendarevent_form_startdate_time').val(theEvent.start.format("HH:mm"));		
            $('#calendarevent_form_enddate_time').val(theEvent.end.format("HH:mm"));        	
        }
        
        this.updatingEvent = theEvent;

        $('#calendarevent_action_delete').show();
	},
	
	_allDayInitialization: function(isAllDay)
	{
		$('#calendarevent_form_allday').prop('checked', isAllDay);
		
//      TODO		
		if (isAllDay)
		{
			$('#calendarevent_form .r3_timepicker_cnt').hide();		
		}
		else
		{
			$('#calendarevent_form .r3_timepicker_cnt').show();														
		}
	},

	_hoursInitialization: function(aStartMoment, anEndMoment)
	{
		$('#calendarevent_form_startdate_time').timepicker('setTime', aStartMoment.format("HH:mm"));
		$('#calendarevent_form_enddate_time').timepicker('setTime', anEndMoment.format("HH:mm"));
	},
	
	_hoursDefaultInitialization: function()
	{
		var now = moment();
		
		var hourOfDay = now.hour();
		var nextHourOfDay = hourOfDay + 1;
		if (hourOfDay == 24)
		{
			// qui potrei avere un problema. Non so se questo set e' corretto o meno.
			nextHourOfDay = 23;	
		}

		$('#calendarevent_form_startdate_time').timepicker('setTime', hourOfDay + ':00');
		$('#calendarevent_form_enddate_time').timepicker('setTime', nextHourOfDay + ':00');
	},
	
	open : function()
	{
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkInitializationQueue = [];

		networkInitializationQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/calendar/CalendarEventActionFormView.html'),
			dataType : "html"
		});
				
		org.r3.PageManager.multiAjax(networkInitializationQueue,
 		
		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			$(this.htmlContainerId).html(responseData['view']);
			
//			$('#calendarevent_form .r3_datepicker').datepicker({
//				format: "dd/mm/yyyy"
//			});
//			
//			$('#calendarevent_form .r3_timepicker').timepicker({ showMeridian: false });
			
			
			
			$('.r3_datepicker').datepicker(org.r3.message.default_datepickerOptions);
			$('.r3_timepicker').timepicker(org.r3.message.default_timepickerOptions);
			
//			$('#calendarevent_form_enddate').gdatetime({
//			    name: "enddate"	
//			});

			$('#calendarevent_form_allday').unbind().click(function(e)
			{
				var currentTarget = $(e.currentTarget);
						
				if (currentTarget.prop('checked'))
				{
					$('.r3_timepicker_cnt').hide();
					
//					$('#calendarevent_form_startdate').gdatetime('hidetime');
//					$('#calendarevent_form_enddate').gdatetime('hidetime');
				}
				else
				{
					$('.r3_timepicker_cnt').show();
					
//					$('#calendarevent_form_startdate').gdatetime('showtime');
//					$('#calendarevent_form_enddate').gdatetime('showtime');					
				}
			});
						
			var actionFormView = this;
			
			$('#calendarevent_action_save').unbind().click($.r3Utils.hitch(actionFormView, actionFormView.onSaveItem));
			$('#calendarevent_action_delete').unbind().click( $.r3Utils.hitch(actionFormView, actionFormView.onDeleteItem));
									
			$("#calendarevent_form").validate
            ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.jsportlet.calendar.calendarevent_form_validationRules,
		           messages: org.r3.jsportlet.calendar.calendarevent_form_validationMessages    
	        });
			
			$('#calendarevent_fieldset_message').formmessage({});				
					
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},

	dismissDialog : function()
	{
		$("#calendarevent-dialog-form").modal("hide");
	},

	onDeleteItem: function()
	{	
		var _self = this;
		var restUrl = null;
		var method = "DELETE";
				
	    var calendarid = $('#calendarevent_form_calendarid').val();
    	restUrl = org.r3.PageManager.getRESTUrl("DELETE_AgendaEntry", [ org.r3.Constants.site, calendarid ]);	
		
    	this.actionFormManager.deleteItem(
				method,
				restUrl,

				function(responseData) { 
						_self.dismissDialog();					
						_self.calendarWidget.fullCalendar('refetchEvents');							
		        }, 
				function(jqXHR, timeout, message) { $('#calendarevent_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
    	);
	},
	
	onSaveItem: function()
	{	
		var theForm = $('#calendarevent_form');
		if (!theForm.valid())
		 return;
		
		var _self = this;
		var restUrl = null;
		var method = "POST";
				
	    restUrl = org.r3.PageManager.getRESTUrl("POST_AgendaEntry", [ org.r3.Constants.site ]);
	    var calendarid = $('#calendarevent_form_calendarid').val();
	    if (calendarid && calendarid.length > 0)
	    {
	    	restUrl = org.r3.PageManager.getRESTUrl("PUT_AgendaEntry", [ org.r3.Constants.site, calendarid ]);	
	    	method = "PUT";
	    }
				
		this.actionFormManager.submitForm(
				method,
				restUrl,
				$("#calendarevent_form"),
				true,
				function(responseData) { 
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('calendarevent_fieldset_message');
					}		
					else 
					{
						_self.dismissDialog();
						
						if (method == 'POST')
						{
							var eventData = {
								id: responseData.id,
								title: responseData.title,
								start: responseData.start,
								end: responseData.end
							};
							
							_self.calendarWidget.fullCalendar('renderEvent', eventData, false);							
						}
						else 
						{
							_self.updatingEvent.title = responseData.title;
							_self.updatingEvent.start = $.fullCalendar.moment(responseData.start);
							_self.updatingEvent.end = $.fullCalendar.moment(responseData.end);
							$('#calendar_canvas').fullCalendar( 'updateEvent', _self.updatingEvent );
							// _self.calendarWidget.fullCalendar('rerenderEvents');														
						}

					}
		        }, 
				function(jqXHR, timeout, message) { $('#calendarevent_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);	
	}
	
	        	
});

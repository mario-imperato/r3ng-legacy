$.r3Utils.namespace("org.r3.jsportlet.calendar");


org.r3.jsportlet.calendar.CalendarActionFormView  = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, aCalendarEventHtmlActionFormContainerId, anActionFormManager, anAgendaOptions)
	{
		var _self = this;		
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		
		this.agendaOptions = $.extend({}, org.r3.message.default_calendar_options, anAgendaOptions);			
		
		this.calendarEventActionForm = new org.r3.jsportlet.calendar.CalendarEventActionFormView(aCalendarEventHtmlActionFormContainerId, anActionFormManager);
		this.calendarEventActionForm.open();

		this.calendarWidget = null;
	},

	close : function()
	{
		$('#calendar_canvas').fullCalendar( 'destroy' );
		this.hide();
	},

	refresh: function()
	{
	},
	
	open : function(anAgendaOptions)
	{		
		var _self = this;
		
		org.r3.PageManager.wait("org.r3.message.waiting");

		if (anAgendaOptions)
		    this.agendaOptions = $.extend(this.agendaOptions, anAgendaOptions);				
		
		var networkRequestsQueue = [];

		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/calendar/CalendarActionFormView.html.jsp'),
			dataType : "html"
		});
			
		org.r3.PageManager.multiAjax(networkRequestsQueue,
				
		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();		
			$(this.htmlContainerId).html(responseData['view']);	
			this.show();
			
			this.calendarWidget = $('#' + this.agendaOptions.calendarCanvasId);
			
			var calendarEventsUrl = org.r3.PageManager.getRESTUrl('GET_AgendaEntries_AsCalendarEvents', [ org.r3.Constants.site ]);
			// calendarEventsUrl = org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/sev/siteconfig/calendar/test.json');
			
			var calendarOptions = 
				$.extend(this.agendaOptions, 

						{


					
					// contentHeight: 600,
					
					dayRender: function(aDate, aCell)
					{
						// console.log(aDate, aCell);
						
						// Ipotesi di lavoro: inserire uno stile dipendente dalla data: es: fc-2015-11-12
						// aCell.addClass("fc-whatever");
					},
					
					viewRender: function(aView, anElement)
					{
						if (aView.name == 'agendaWeek')
						{
							// Cerco il pattern: fc-col0 --> fc-col6  
                            // Capisco il giorno in base fc-mon.... e risalgo alla data di quella colonna. 
							// assegno la classe per data.
							console.log('fc-view-agendaWeek', aView, anElement);
							
							var selectedItems = anElement.find('.fc-col0');
							if (selectedItems.length > 0)
							{
								for(var i = 0; i < selectedItems.length; i++)
							    {
									var runningDay = moment(aView.start);
								    
									var theItem = $(selectedItems[i]);
							        for(var j = 0; j < 7; j++)
							        {
							        	theItem.addClass('fc-' + runningDay.format('YYYY-MM-DD'));	
							            runningDay.add(1, 'd');
							            theItem = theItem.next();
							        }
							        
							    }
							}
						}
						
						if (aView.name == 'agendaDay')
						{
							// Cerco il pattern: fc-col0 e assegno la classe in base alla view startDate
							console.log('fc-view-agendaDay', aView, anElement);		
							
							var selectedItems = anElement.find('.fc-col0');
							if (selectedItems.length > 0)
							{
							    for(var i = 0; i < selectedItems.length; i++)
							    {
							        var theItem = $(selectedItems[i]);
							        theItem.addClass('fc-' + aView.start.format('YYYY-MM-DD'));
							    }
							}
						}												
					},
					
					select: function(start, end, jsEvent, view) {
//						var title = prompt('Event Title:');
//						var eventData;
//						if (title) {
//							eventData = {
//								title: title,
//								start: start,
//								end: end
//							};
//							$('#calendar_canvas').fullCalendar('renderEvent', eventData, true); // stick? = true
//						}
						
						_self.calendarEventActionForm.onNewEvent(_self.calendarWidget, start, end, view);
						
//						if (_self.agendaOptions.onNewEvent)
//						{
//							_self.agendaOptions.onNewEvent(_self.calendarWidget, start, end);	
//						}

						_self.calendarWidget.fullCalendar('unselect');
					},
					
					
					eventDrop: function(event, delta, revertFunc) 
					{
	                    console.debug(event, delta,  event.start.format(), event.start.hasTime()); // Per capire debbo usare il delta. se no nisba.
	                    
				        if (!confirm(org.r3.message.calendar_confirmmove)) {
				            revertFunc();
				        }
				        else 
				        {			        	
							_self.onMoveEvent(_self.calendarWidget, event, delta);	
				        }

				    },
					
				    eventResize: function(event, delta, revertFunc) 
				    {
				    	console.debug("Resize:: - " + event.title + " end is now " + event.end.format());

				        if (!confirm(org.r3.message.calendar_confirmresize)) {
				            revertFunc();
				        }
				        else
				        {
							_self.onResizeEvent(_self.calendarWidget, event, delta);	
				        }
				    },
				    
				    eventClick: function(calEvent, jsEvent, view) 
				    {						
						_self.calendarEventActionForm.onUpdateEvent(_self.calendarWidget, calEvent);					
				    },
				    
					events: {
						url: this.agendaOptions.urls.queryevents,
						error: function() {
							console.log("Widget Got Error");
						}
					},
									
					editable: this.agendaOptions.editable				    
				}
				
			);
				
			$('#calendar_canvas').fullCalendar(calendarOptions);									

		}),
		
		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
	
	},
	
	onMoveEvent: function(calWidget, anEvent, delta)
	{
		console.debug('CalendarActionForm::onMoveEvent id:' + anEvent.id + ' start:' + (anEvent.start && anEvent.start.format()) + ' end:' + (anEvent.end && anEvent.end.format()) + ' allDay? ' + anEvent.allDay);
		
		if (!anEvent.allDay)
		{
			if (!anEvent.end)
			{
			    console.error("Moving OUT of ALL DAY but end is not set");
			    anEvent.end = moment(anEvent.start).add(30, 'm');
			    calWidget.fullCalendar( 'updateEvent', anEvent );
			}
		}
		
		this._populateHiddenFormWithEventData(anEvent.id, anEvent.allDay, anEvent.start, anEvent.end, delta);

		var restUrl = org.r3.PageManager.getRESTUrl("PUT_Move_AgendaEntry", [ org.r3.Constants.site, anEvent.id ]);
		this.actionFormManager.submitForm("PUT", restUrl, $('#calendar_form'), false);
	},
	
	onResizeEvent: function(calWidget, anEvent, delta)
	{
		console.debug('CalendarActionForm::onResizeEvent id:'  + anEvent.id + ' start:' + (anEvent.start && anEvent.start.format()) + ' end:' + (anEvent.end && anEvent.end.format()) + ' allDay? ' + anEvent.allDay);
		this._populateHiddenFormWithEventData(anEvent.id, anEvent.allDay, anEvent.start, anEvent.end, delta);

		var restUrl = org.r3.PageManager.getRESTUrl("PUT_Resize_AgendaEntry", [ org.r3.Constants.site, anEvent.id ]);
		this.actionFormManager.submitForm("PUT", restUrl, $('#calendar_form'), false);
	},

	_populateHiddenFormWithEventData: function(id, allDayFlag, start, end, delta)
	{
        $('#calendar_form_calendarid').val(id);

		var s = null;
		var e = null;

		if (!allDayFlag)
		{
			s = start && start.format("DD/MM/YYYY HH:mm");
			e = end && end.format("DD/MM/YYYY HH:mm");			
		}						
		
		$('#calendar_form_allday').val(allDayFlag ? 'btrue': 'bfalse');
		if (s)
		{
			$('#calendar_form_startdate_date').val(s.substr(0, 10));
			$('#calendar_form_startdate_time').val(s.substr(11, 5));
		}
		else 
        {
			$('#calendar_form_startdate_date').val('');
			$('#calendar_form_startdate_time').val('');							
        }
		
		if (e)
		{
			$('#calendar_form_enddate_date').val(e.substr(0, 10));
			$('#calendar_form_enddate_time').val(e.substr(11, 5));
		}
		else 
        {
			$('#calendar_form_enddate_date').val('');
			$('#calendar_form_enddate_time').val('');							
        }
	}
	
//	_initializeFormFields: function(anApplicationDTOAdapter)
//	{					
//		$('#classifieritemform_clsitemid').prop('disabled', false);						
//	},
	
//	itemDetail: function(aClassifierItemDTOAdapter)
//	{
//		var networkRequestsQueue = [];
//
//		networkRequestsQueue.push(
//		{
//			id : "item",
//			type : "Get",
//			url : org.r3.PageManager.getRESTUrl('GET_SEV_CalendarDetail', [ aClassifierItemDTOAdapter.dataBean.calendarid ]),
//			dataType : "json"
//		});
//					
//		org.r3.PageManager.multiAjax(networkRequestsQueue,
//				
//		$.r3Utils.hitch(this, function(responseData)
//		{
//			var itemDataBean = responseData['item'];
//			if (itemDataBean != null)
//			{
//				aClassifierItemDTOAdapter = new org.r3.db.sailevent.calendar.CalendarDTOAdapter(itemDataBean);
//			}
//			
//			// $('#sevcalendar_form_classifieritemorder').val(aClassifierItemDTOAdapter.dataBean.classifieritemorder);			
//		})
//		
//		);
//		
//	}
			

});

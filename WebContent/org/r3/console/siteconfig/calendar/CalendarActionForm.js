$.r3Utils.namespace("org.r3.console.siteconfig.calendar");

org.r3.console.siteconfig.calendar.CalendarActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aItemDetailViewContainerId, aCalendarEventHtmlActionFormContainerId)
	{
		var _self = this;
		
		this.setPageManager(aPageManager);
				
		this.detailView = new org.r3.jsportlet.calendar.CalendarActionFormView(
				aItemDetailViewContainerId, 
				aCalendarEventHtmlActionFormContainerId,
				this,
				{
					calendarCanvasId: 'calendar_canvas',
					editable: true,
					urls: {
						queryevents: org.r3.PageManager.getRESTUrl('GET_AgendaEntries_AsCalendarEvents', [ org.r3.Constants.site ])
					}
					
//					onNewEvent: function(calWidget, start, end)
//					{
//						console.debug('CalendarActionForm::onNewEvent');
//						_self.calendarEventActionForm.onNewEvent(calWidget, start, end);
//					},
					
//					onMoveEvent: function(calWidget, id, start, end, delta)
//					{
//						console.debug('CalendarActionForm::onMoveEvent id:' + id + ' start:' + (start && start.format()) + ' end:' + (end && end.format()) + ' allDay? ' + !start.hasTime());
//						$('#calendar_form_calendarid').val(id);
//						
//						var s = start && start.format("DD/MM/YYYY HH:mm");
//						var e = end && end.format("DD/MM/YYYY HH:mm");
//						
//						$('#calendar_form_allday').val(!start.hasTime() ? 'btrue': 'bfalse');
//						if (s)
//						{
//							$('#calendar_form_startdate_date').val(s.substr(0, 10));
//							$('#calendar_form_startdate_time').val(s.substr(11, 5));
//						}
//						else 
//                        {
//							$('#calendar_form_startdate_date').val('');
//							$('#calendar_form_startdate_time').val('');							
//                        }
//						
//						if (e)
//						{
//							$('#calendar_form_enddate_date').val(e.substr(0, 10));
//							$('#calendar_form_enddate_time').val(e.substr(11, 5));
//						}
//						else 
//                        {
//							$('#calendar_form_enddate_date').val('');
//							$('#calendar_form_enddate_time').val('');							
//                        }
//
//						var restUrl = org.r3.PageManager.getRESTUrl("PUT_Move_SEV_calendar", [ id ]);
//						_self.submitForm("PUT", restUrl, $('#calendar_form'), false);
//					},
					
//					onResizeEvent: function(calWidget, id, start, end, delta)
//					{
//						console.debug('CalendarActionForm::onResizeEvent id:' + id + ' start:' + (start && start.format()) + ' end:' + (end && end.format()) + ' allDay? ' + !start.hasTime());
//					},
//					
//					onClickEvent: function(calWidget, event)
//					{
//						console.debug('CalendarActionForm::onClickEvent');
//					}
				});
		
//		this.listView = new org.r3.db.sailevent.calendar.CalendarQueryActionFormView(aItemsViewContainerId, this,
//				{
//					dataTableId : 'CalendarQueryActionFormView',
//					showTemplateOnOpen : false,
//					// htmlTemplateUrl : org.r3.Constants.applicationContext + '/org/r3/jsportlet/classifier/ClassifierItemActionFormView.html.jsp',
//					// layout : 'fullWidth',
//					gradeLevel : 'grade_level1',
//					iDisplayLength: -1,
//					legend : 'Elementi',
//					// dataTableSource : org.r3.PageManager.getRESTUrl('GET_CardFiles', [ aCardDataBean.dataBean.cardid ]),
//
//					// pannello con l'identificativo del gruppo
//					// onInitializationComplete : $.unepUtils.hitch(this,
//					// this.populateRiepilogo),
//					dataTableColumns : "calendarid,calendardescr,startdate,enddate",
//					// requiredLUTs : [ "GET_classifier_r3ea_crewrole" ],
//
//					onSelected : $.r3Utils.hitch(this, function(aClassifierItemDTOAdapter)
//					{
//						$('#calendar_deleteItem').prop('disabled', false);
//						this.detailView.itemDetail(aClassifierItemDTOAdapter);
//					}),
//
//					onDblClick : $.r3Utils.hitch(this, function(aClassifierItemDTOAdapter)
//					{
//						$('#calendar_deleteItem').prop('disabled', true);				
//					}),
//
//					buttons : [
//					{
//						id : 'calendar_deleteItem',
//						label : 'Elimina',
//						disabled : true,
//						onClick : $.r3Utils.hitch(this, this._onItemDelete)
//					} ],
//
//					onClearSelection : function()
//					{
//						$('#calendar_deleteItem').prop('disabled', true);
//					},
//
//					onInitializationComplete : $.r3Utils.hitch(this, function()
//					{
//						this.listView.show();
//					})
//				});		
	},

	close : function()
	{
		this.detailView.close();
//		this.listView.close();
	},

	hide : function()
	{
		this.detailView.hide();
//		this.listView.hide();
	},

	show : function()
	{
		this.detailView.show();
//		this.listView.show();
	},

	refresh : function()
	{
		this.detailView.refresh();
		
//		this.listView.refresh();
//		$('#calendar_deleteItem').prop('disabled', true);
	},

	open : function()
	{
//		var dataTableSource = org.r3.PageManager.getRESTUrl('GET_SEV_Calendar');
		this.detailView.open();
//		this.listView.open({
//				"dataTableSource": dataTableSource,			
//				"onInitializationCompleteArgs": arguments
//		});					
	},
	
	deleteItem: function(method, restUrl, onSuccess, onError)
	{
		var _self = this;
		if (org.r3.PageManager.confirmation("org.r3.message.calendar_confirmdelete"))
		{
			org.r3.PageManager.wait("org.r3.message.waiting");
			$.ajax(
			{
				"type" : method,
				"url" : restUrl,
				"dataType" : "json",
				"success" : function(responseData)
				{
					org.r3.PageManager.closeNotifier();
					_self.refresh();
					
					if (onSuccess)
						onSuccess(responseData);					
				},
				
				"error" : function(jqXHR, timeout, message)
				{
					org.r3.PageManager.closeNotifier();
					if (onError)
						onError(message);
				}
				
			});
		}				
	},
	
	submitForm: function(method, restUrl, theForm, doValidation, onSuccess, onError)
	{
		var _self = this;
		if (!doValidation || (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm")))
		{
			org.r3.PageManager.wait("org.r3.message.waiting");
			theForm.ajaxSubmit(
			{
				"type" : method,
				"url" : restUrl,
				"dataType" : "json",
				"success" : function(responseData)
				{
					org.r3.PageManager.closeNotifier();
					_self.refresh();
					
					if (onSuccess)
						onSuccess(responseData);					
				},
				
				"error" : function(jqXHR, timeout, message)
				{
					org.r3.PageManager.closeNotifier();
					if (onError)
						onError(message);
				}
				
			});
		}		
	}

//	_onItemDelete: function()
//	{
//		var _self = this;
//		
//		if (org.r3.PageManager.confirmation("org.r3.message.deleteconfirm"))
//		{           	
//    	    var selectedItem = this.listView.fnGetSelectedDataBean();
//    	    this.deleteItem(selectedItem,
//				function(responseData) { 
//					_self.refresh();
//		        }, 
//				function(jqXHR, timeout, message) { console.log("org.r3.console.siteconfig.calendar::" + message); }				    	    
//    	    );
//		}	    	    		
//	},
//	
//	deleteItem: function(aClassifierDTOAdapter, onSuccess, onError)
//	{
//		var _self = this;
//
//		var method = "DELETE";
//		var restUrl = null;
//		var site = aClassifierDTOAdapter.dataBean.site;
//		var calendarid = aClassifierDTOAdapter.dataBean.calendarid;
//		restUrl = org.r3.PageManager.getRESTUrl('DELETE_SEV_Calendar', [ calendarid ]);
//
//		org.r3.PageManager.wait("org.r3.message.waiting");
//		$.ajax(
//		{
//			"type" : method,
//			"url" : restUrl,
//			"dataType" : "json",
//			"success" : function(responseData)
//			{
//				org.r3.PageManager.closeNotifier();
//				if (onSuccess)
//					onSuccess(responseData);
//			},
//			"error" : function(jqXHR, timeout, message)
//			{
//				if (onError)
//					onError(message);
//			}
//		});
//	}
				
});


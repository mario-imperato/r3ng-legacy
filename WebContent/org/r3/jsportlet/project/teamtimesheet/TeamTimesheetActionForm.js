$.r3Utils.namespace("org.r3.jsportlet.project.teamtimesheet");

org.r3.jsportlet.project.teamtimesheet.TeamTimesheetActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);

		this.timesheetTeamDTOAdapter = null;
		this.timesheetMonth = null;
		
		this.listView = new org.r3.db.project.resourcetimesheetview.ResourceTimesheetViewQueryActionFormView
		(
				aDetailViewContainerId, 
				this,
				{
					showTemplateOnOpen: true,
					htmlTemplateUrl: org.r3.Constants.applicationContext + "/org/r3/jsportlet/project/teamtimesheet/TeamTimesheetActionFormView.html.jsp",
					
					dataTableId : 'ResourceTimesheetViewQueryActionFormView',					
					
					gradeLevel : 'grade_level6 grade_clickable',
					legend : org.r3.db.project.resourcetimesheetview.message.queryactionformview_legend,	
					iDisplayLength: -1,
					
					layout : 'fullWidth',
					sortable: true,
					// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
					dataTableColumns : "resourceid;sort,resourcedescr,ordeffort,exteffort,oncalleffort,queryformview-tools",
					requiredLUTs : [ 
                        "GET_classifier_sys_recstatus" ],
					
                    onToolsIconSelected: $.r3Utils.hitch(this, this.onToolSelected),
                    
                    onSelected : $.r3Utils.hitch(this, function(aResourceTimesheetViewDTOAdapter)
					{
						this.openDetail(aResourceTimesheetViewDTOAdapter);
					}),
					
					onClearSelection : function()
					{
					},
						              	
					actionBarOnTop: true,
//					buttons : [
//					{
//						id : 'teamresource_deleteItem',
//						label : 'Elimina',
//						disabled : true,
//						onClick : $.r3Utils.hitch(this, this._onItemDelete)
//					} ],
					
					onInitializationComplete: $.r3Utils.hitch(this, function() {
							
						var _self = this;						
						var now = moment();
												
						var kd = $('#teamtimesheetform_ordeffort');
						kd.knob({ 
							displayInput : false,
							step: 1,
							min: 0,
							max: 24,
							'format': $.r3Utils.hitch(this, function(v) { return this._formatKnobData(v, '#teamtimesheetform_ordeffort_klabel', false); })
						});
						
						var kd = $('#teamtimesheetform_exteffort');
						kd.knob({ 
							displayInput : false,
							step: 1,
							min: 0,
							max: 24,
							'format': $.r3Utils.hitch(this, function(v) { return this._formatKnobData(v, '#teamtimesheetform_exteffort_klabel', false); })
						});
						
						var kd = $('#teamtimesheetform_oncalleffort');
						kd.knob({ 
							displayInput : false,
							step: 1,
							min: 0,
							max: 24,
							'format': $.r3Utils.hitch(this, function(v) { return this._formatKnobData(v, '#teamtimesheetform_oncalleffort_klabel', false); })
						});
						
						var nowAsString = now.format('DD/MM/YYYYY');
						var dp = $('#teamtimesheetform_form .r3_datepicker');
						dp.datepicker({
							format: "dd/mm/yyyy",
							endDate: nowAsString // $.r3Utils.getToday()
						});
						
						dp.datepicker('update', nowAsString);
						
						dp.datepicker()
					    .on('changeDate', function(e) {
					        console.log('Changed Date...', e.date);
					        _self.updateUIOnTimesheetDay(moment(e.date));
					    })
					    .on('changeMonth', function(e) {
					        console.log('Changed Month...', e.date);
					        											
					    })
					    ;
						
						this.updateUIOnTimesheetDay(now);
						
						// dp.datepicker('update', new Date());
						
						$("#teamtimesheetform_form").validate
				        ({
				        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
				               rules: org.r3.jsportlet.project.teamtimesheet.teamtimesheet_form_validationRules,
					           messages: org.r3.jsportlet.project.teamtimesheet.teamtimesheet_form_validationMessages    
				        });
						
						var a = $('.teamwf_action');
						a.unbind().click($.r3Utils.hitch(this, this._onCompleteWorkflowActivity));	
						
						$('#teamtimesheetform_action_save').unbind().click($.r3Utils.hitch(this, this.onSaveItem));
						// $('#teamresourceform_action_save').prop('disabled', true);
						
						$('#teamtimesheetform_action_clear').unbind().click($.r3Utils.hitch(this, this._clearForm));						
						
						$('#teamtimesheet_fieldset_message').formmessage({});	

					})
				}

		);
		
	},

	_formatKnobData : function(v, aLabelId, halfHourFLag) 
	{
		var s = v + '';

		if (halfHourFLag) {

			switch (v) {
			case 0:
				s = '0';
				break;
			case 5:
				s = '0.5';
				break;
			default: {
				var c = s.charAt(s.length - 1);
				s = s.substring(0, s.length - 1);
				if (c == '5') {
					s = s + '.5';
				}
			}
			}
		}

		$(aLabelId).html(s);
		return s;
	},
	
	close : function()
	{
		// M20140201 - org.r3.PageManager.popBreadCrumb();		
		this.hide();
	},

	hide : function()
	{
		this.listView.hide();
	},

	show : function()
	{
		this.listView.show();
	},

	refresh: function()
	{
		this.listView.refresh();
	},
	
	refreshByDay: function(aMomentDate)
	{
		var qparams = [];
		qparams.push(
		{
			"name": "timesheetday", "value" : aMomentDate.format('YYYYMMDD')
		});
		
		this.listView.clearQueryParameters();
	    for(var i = 0; i < qparams.length; i++)
	    {
	        this.listView.addQueryParameter(qparams[i]);
	    }
	    
	    this.listView._applyFnFilter('');	       
	},
	
	_clearForm: function()
	{
		$('#teamtimesheetform_form').resetForm();
		
		$('#teamtimesheetform_ordeffort').val(0).trigger('change');
		$('#teamtimesheetform_exteffort').val(0).trigger('change');
		$('#teamtimesheetform_oncalleffort').val(0).trigger('change');
		
	},
	
	_updateWorkflowActions: function()
	{
		if (this.timesheetTeamDTOAdapter)
		{
			var t = this.timesheetTeamDTOAdapter.getOnCompleteOKTask_InReportingTask();
			if (t)
			{
				$('#teamwf_action_oncomplete_ok').show();								
				$('#teamwf_action_oncomplete_ok').html(org.r3.db.project.team.message.getOnCompleteOkActionMessageForTask(this.timesheetTeamDTOAdapter.dataBean.teamstatus));
			}
			else
			{
				$('#teamwf_action_oncomplete_ok').hide();	
			}

			var t = this.timesheetTeamDTOAdapter.getOnCompleteKOTask_InReportingTask();
			if (t)
			{
				$('#teamwf_action_oncomplete_ko').show();								
				$('#teamwf_action_oncomplete_ko').html(org.r3.db.project.team.message.getOnCompleteKoActionMessageForTask(this.timesheetTeamDTOAdapter.dataBean.teamstatus));
			}
			else
			{
				$('#teamwf_action_oncomplete_ko').hide();
			}
		}
		else
		{
			$('.teamwf_action').hide();
		}
			
	},
	
	_updateTimesheetActions: function()
	{
		if (this.timesheetTeamDTOAdapter && this.timesheetTeamDTOAdapter.isOpen4Reporting())
		{
			$('#teamtimesheetform_action_save').prop('disabled', false);
			$('#teamtimesheet_fieldset_message').formmessage('clear');														
		}
		else
		{
			$('#teamtimesheetform_action_save').prop('disabled', true);
			$('#teamtimesheet_fieldset_message').formmessage('setText', { text: org.r3.jsportlet.project.teamtimesheet.message.err_period_ot_open_for_reporting, category: 'error' });
		}		
	},
	
	_onCompleteWorkflowActivity: function(e)
	{
		var _self = this;
		var currentTarget = $(e.currentTarget);
		
		// Dovrei sempre essere in una situazione di valorizzazione in quanto altrimenti la funzione non dovrebbe essere attivata tramite il bottone.
		var t = this.timesheetTeamDTOAdapter.getOnCompleteOKTask();
		if (currentTarget.attr('id') == 'teamwf_action_oncomplete_ko')
			t = this.timesheetTeamDTOAdapter.getOnCompleteKOTask();
		
		console.log(t);
		
		var method = "put";
		var restUrl = org.r3.PageManager.getRESTUrl('PUT_TeamWorkflowOnComplete', [ this.timesheetTeamDTOAdapter.dataBean.teamid, t] );
					 
		org.r3.AjaxUtils.ajaxInvoke(method, restUrl, 
				function(responseData) 
				{ 
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('teamtimesheet_fieldset_message');
					}	
					else 
					{
						_self.timesheetTeamDTOAdapter.dataBean.teamstatus = t;
						_self._updateWorkflowActions();
						_self._updateTimesheetActions();
					}
		        }, 
				function(jqXHR, timeout, message) { $('#teamtimesheet_fieldset_message').formmessage('setText', { text: message, category: 'error' }); },
				"org.r3.message.saveconfirm", true);		
	},
	
	updateUIOnTimesheetDay: function(aMoment)
	{
		this.refreshByDay(aMoment);
		
		var aDayAsSysString = aMoment.format('YYYYMMDD');
		$('#teamtimesheetform_timesheetday').val(aDayAsSysString);
		$('#teamtimesheetform_timesheetday_descr').html(aMoment.format('DD/MM/YYYY'));
		
		
		this._clearForm();
		
		if (!this.timesheetMonth || this.timesheetMonth != aMoment.month())
		{
			this.timesheetMonth = aMoment.month();
			
			var selectWidget = $('#teamtimesheetform_resourceid');
			var selectOptions = selectWidget.prop('options');
			if (!selectOptions)
				console.error("Select Option is NULL for: ", selectWidget.attr('id'));
			selectOptions.length = 0;
					
			this.timesheetTeamDTOAdapter = null;
			$.ajax(
			{
				"type" : "GET",
				"url" : org.r3.PageManager.getRESTUrl('GET_Team_ByDate', [ aDayAsSysString ]),
				"dataType" : "json",
				"success" : $.r3Utils.hitch(this, function(responseData)
				{					
					if (responseData.iTotalRecords && responseData.aaData && responseData.aaData.length)
					{
						this.timesheetTeamDTOAdapter = new org.r3.db.project.team.TeamDTOAdapter(responseData.aaData[0]);
						$('#teamtimesheetform_teamid').val(this.timesheetTeamDTOAdapter.dataBean.teamid);
						var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_Team_Resources', [ this.timesheetTeamDTOAdapter.dataBean.teamid ]);
						org.r3.PageManager.lutManager.populateSelectField(
						{
							"lutUrl" : resolvedUrl,
							"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
							"selectWidget" : selectWidget,
							"fnRenderKey" : function(anItem)  { return anItem.resourceid; },
							"fnRenderText" : function(anItem)  { return anItem.resourcedescr; },
							"selectedValue": null // anActorDTOAdapter && anActorDTOAdapter.dataBean.profileid,
						});			
						
						this._updateTimesheetActions();				
					}
					else
					{
						
						$('#teamtimesheetform_action_save').prop('disabled', true);
						$('#teamtimesheet_fieldset_message').formmessage('setText', { text: org.r3.jsportlet.project.teamtimesheet.message.err_period_ot_open_for_reporting, category: 'error' });	
					}
					
					this._updateWorkflowActions();
				}),
				"error" : function(jqXHR, timeout, message)
				{
					console.error("Errore Loading: ", message);
					this._updateWorkflowActions();
				}
			});										
		}
	},
	
	open : function()
	{		
		var qparams = [];
		qparams.push(
		{
			"name": "timesheetday", "value" : $.r3Utils.getToday()
		});
		
		var dataTableSource = org.r3.PageManager.getRESTUrl('GET_Timesheets');
				
		this.listView.open({
			"dataTableSource": dataTableSource,
			"queryparams": qparams
		});
	},

	onSaveItem: function()
	{
		this.saveItem();
	},
	
	_checkForm: function(theForm)
	{
		if (theForm.valid())
		{
			var o = $('#teamtimesheetform_ordeffort').val();
			var e = $('#teamtimesheetform_exteffort').val();
			var c = $('#teamtimesheetform_oncalleffort').val();
			if ((!o || o == '0') && (!e || e == '0') && (!c || c == '0'))
			{
				$('#teamtimesheet_fieldset_message').formmessage('setText', { text: org.r3.jsportlet.project.teamtimesheet.message.err_effort_empty, category: 'error' });
				return false;
			}
			
			if (Number(o) + Number(e) + Number(c) > 24)
			{
				$('#teamtimesheet_fieldset_message').formmessage('setText', { text: org.r3.jsportlet.project.teamtimesheet.message.err_effort_overload, category: 'error' });
				return false;
			}
			
			$('#teamtimesheet_fieldset_message').formmessage('clear');
			return true;
		}
		
		return false;
	},
	
	saveItem: function()
	{	
		var _self = this;
		var restUrl = null;
		var method = "PUT";
		
		var theForm = $("#teamtimesheetform_form");
		if (!this._checkForm(theForm))
			return ;
		
		var tsday = $('#teamtimesheetform_timesheetday').val();
		var teamid = $('#teamresourceform_teamid').val();
		var resourceid = $('#teamtimesheetform_resourceid').val();
		
	    restUrl = org.r3.PageManager.getRESTUrl("PUT_ResourceTimesheet", [ resourceid, tsday ]);
		method = "PUT";			
						
		org.r3.AjaxUtils.submitForm(
				method,
				restUrl,
				theForm,
				function(responseData) 
				{ 
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('teamtimesheet_fieldset_message');						
					}		
					else 
					{
						_self.refresh();
						_self._clearForm();
						$('#teamtimesheet_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });											
					}
		        }, 
				function(jqXHR, timeout, message) { 
		        	$('#teamtimesheet_fieldset_message').formmessage('setText', { text: message, category: 'error' }); 
		        },
		        "org.r3.message.saveconfirm",
		        true
		);	
	},
	
	_onItemDelete: function(aTeamResourceViewDTOAdapter)
	{
		var _self = this;
		
		if (org.r3.PageManager.confirmation("org.r3.message.deleteconfirm"))
		{
			var method = "DELETE";

			var tsday = $('#teamtimesheetform_timesheetday').val();
			var resourceid = aTeamResourceViewDTOAdapter.dataBean.resourceid;
			var restUrl = org.r3.PageManager.getRESTUrl("DELETE_ResourceTimesheet", [ resourceid, tsday ]);

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
				},
				"error" : function(jqXHR, timeout, message)
				{
					org.r3.PageManager.closeNotifier();
				}
			});
		}
	},
	
	openDetail: function(aDTOAdapter)
	{
		$('#teamtimesheetform_resourceid').val(aDTOAdapter.dataBean.resourceid);
		$('#teamtimesheetform_ordeffort').val(aDTOAdapter.dataBean.ordeffort).trigger('change');
		$('#teamtimesheetform_exteffort').val(aDTOAdapter.dataBean.exteffort).trigger('change');
		$('#teamtimesheetform_oncalleffort').val(aDTOAdapter.dataBean.oncalleffort).trigger('change');
	},
	
	onToolSelected: function(aTeamResourceViewDTOAdapter, aToolId)
	{
		if (aToolId && aToolId == 'toolid-trash')
		{
			this._onItemDelete(aTeamResourceViewDTOAdapter);
		}
	}

			

});


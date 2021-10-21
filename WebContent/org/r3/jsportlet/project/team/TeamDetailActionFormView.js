$.r3Utils.namespace("org.r3.jsportlet.project.team");


org.r3.jsportlet.project.team.TeamDetailActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, openMode)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.openMode = openMode || 'default';
	},

	close : function()
	{
		this.hide();
	},

	refresh: function()
	{
		this.tabTeams.refresh();
	},
	
	open : function(aDataBeanInfo, anOpenOptionsHash)
	{
		var formMode = (aDataBeanInfo) ? 'detail' : 'create';

		if (this.openMode == 'default') org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/project/team/TeamDetailActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});

		if (formMode == 'detail')
		{
			networkRequestsQueue.push(
			{
				id : "content",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl('GET_Team_Detail', [ aDataBeanInfo.dataBean.teamid ]),
				dataType : "json"
			});	
				
		}

		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			if (this.openMode == 'default') org.r3.PageManager.closeNotifier();

			var teamDataBean = responseData['content'];
			if (teamDataBean)
			{
				teamDataBean = new org.r3.db.project.team.TeamDTOAdapter(teamDataBean);
			}
			
			$(this.htmlContainerId).html(tmpl(responseData['view'], { "formmode": formMode, "teamDtoAdapter": teamDataBean }));

			// ignore: [],
			$('#teamdetailactionform_form').validate(
			{				
				errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
				rules : org.r3.jsportlet.project.team.teamdetailactionform_form_validationRules,
				messages : org.r3.jsportlet.project.team.teamdetailactionform_form_validationMessages
			});

//			var resolvedUrl = it.posteitaliane.unep.PageManager.getRESTUrl('GET_classifier_sys_recstatus');			
//			var recStatus = (prodottoDataBean) ? prodottoDataBean.dataBean.recstatus : 'sys_recact';
//			it.posteitaliane.unep.PageManager.lutManager.populateRadioGroup(
//			{
//				"lutUrl" : resolvedUrl,
//				"groupContainer" : $('#prodottodetailactionform_form_recstatus_cnt'),
//				"groupId" : "prodottodetailactionform_form_recstatus_",
//				"groupName" : "recstatus",
//				"value" : recStatus
//			});

			$('#teamdetailactionform_fieldset_message').formmessage({});
			
			$('#teamdetailactionform_form_action_cancel').click(
					$.r3Utils.hitch(this.actionFormManager, this.actionFormManager.listaTeams));
													
			this._initializeFormFields(teamDataBean);
			
//			if (teamDataBean == null)
//			{
//				$('#teamdetailactionform_action_saveitem').click(
//						$.r3Utils.hitch(this, this._onCreateItem));
//				$('#teamdetailactionform_form_action_cancel').hide();
//				$('#teamdetailactionform_action_delete').hide();		
//			}
//			else
//			{				
				$('#teamdetailactionform_action_saveitem').click(
						$.r3Utils.hitch(this, this._onUpdateItem));
				$('#teamdetailactionform_form_action_cancel').show();						

				var a = $('#teamdetailactionform_action_delete');
				if (anOpenOptionsHash.actions == 'all')
				{
					a.unbind().click($.r3Utils.hitch(this, this._onDeleteItem));				
					a.show();	
				}
				else 
				{
					a.unbind().hide();
				}
				
				var a = $('.teamwf_action');
				if (anOpenOptionsHash.actions == 'all')
				{
					a.unbind().click(
							 $.r3Utils.hitch(this, this._onCompleteWorkflowActivity));	
					a.show();
				}
				else
				{
					a.unbind().hide();
				}
			
//			}
		
//			if (formMode == 'detail' && anOpenOptionsHash.traverseRelationship)
//			{	
			   this.tabTeams = new org.r3.jsportlet.project.team.TeamDetailActionFormView_TabResources('#teamDetailActionFormView_tab_resources', this.actionFormManager, teamDataBean);
//			}   
			 
			if (this.openMode == 'default')  this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
	_defaultValue2TeamDescriptionOnEmptyValue: function()
	{
		var descrField = $('#teamdetailactionform_teamdescr');
		var d = descrField.val();
		if (!d || !(d.trim().length))
		{			
			d = $("#teamdetailactionform_periodindex option:selected").text().toUpperCase();
			descrField.val(d);
		}		
	},
	
	_onCompleteWorkflowActivity: function(e)
	{
		var currentTarget = $(e.currentTarget);
		var wfStatus = currentTarget.attr('id').substring('teamwf_action_'.length)
		console.log(currentTarget.attr('id'), wfStatus);
		
		this.actionFormManager.completeWorkflowActivity(
			wfStatus, 
			function(responseData) 
			{ 
				if (org.r3.PageManager.isRestDTO(responseData))
				{
					var restDto = new org.r3.RestDTOAdapter(responseData);
					restDto.showMessage('teamdetailactionform_fieldset_message');
				}	
				else org.r3.PageManager.back();
	        }, 
			function(jqXHR, timeout, message) { $('#teamdetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); })
	},

	_onCreateItem: function()
	{
		this._defaultValue2TeamDescriptionOnEmptyValue();
		
		this.actionFormManager.createItem(
				function(responseData) { 
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('teamdetailactionform_fieldset_message');
					}	
		        }, 
				function(jqXHR, timeout, message) { $('#teamdetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},
	
	_onUpdateItem: function()
	{				
		this._defaultValue2TeamDescriptionOnEmptyValue();
		
		this.actionFormManager.updateItem(
				function(responseData) { 					
		        }, 
				function(jqXHR, timeout, message) { $('#teamdetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},

	_onDeleteItem: function()
	{
		this.actionFormManager.deleteItem(
				function(responseData) { 					
		        }, 
				function(jqXHR, timeout, message) { $('#teamdetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},

	_initializeFormFields: function(aTeamDTOAdapter)
	{
		var useridPickerValue = null;
		
		var resolvedUrl = org.r3.PageManager.getRESTUrl("LUT_CalendarMonthlyPeriod", [ '10', '-4' ] );
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : resolvedUrl,
			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#teamdetailactionform_periodindex'),
			"selectedValue": aTeamDTOAdapter && aTeamDTOAdapter.dataBean.periodindex && (aTeamDTOAdapter.dataBean.periodindex + ''),
			"useBusinessKey": false
		});	
		
		if (aTeamDTOAdapter)
		{
			$('#teamdetailactionform_teamid').html(aTeamDTOAdapter.dataBean.teamid);		
			$('#teamdetailactionform_teamdescr').val(aTeamDTOAdapter.dataBean.teamdescr);	
			
			$('#teamdetailactionform_periodindex').prop('disabled', true);
			$('#teamdetailactionform_teamstatus').val(eval('org.r3.db.project.team.message.' + aTeamDTOAdapter.dataBean.teamstatus));			
		}						
		else
		{			
		var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_Teams");
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : resolvedUrl,
			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#teamdetailactionform_templateteamid'),
			"selectedValue": null, // anActorDTOAdapter && anActorDTOAdapter.dataBean.profileid
			"useBusinessKey": true
		});		
		}
		

		
							
	}

});

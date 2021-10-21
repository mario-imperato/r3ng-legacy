$.r3Utils.namespace("org.r3.jsportlet.project.team");


org.r3.jsportlet.project.team.TeamCreateActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
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
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/project/team/TeamCreateActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});

		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

		
			$(this.htmlContainerId).html(tmpl(responseData['view'], { }));

			// ignore: [],
			$('#teamdetailactionform_form').validate(
			{				
				errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
				rules : org.r3.jsportlet.project.team.teamdetailactionform_form_validationRules,
				messages : org.r3.jsportlet.project.team.teamdetailactionform_form_validationMessages
			});

			$('#teamdetailactionform_fieldset_message').formmessage({});
			
			$('#teamdetailactionform_form_action_cancel').click(
					$.r3Utils.hitch(this.actionFormManager, this.actionFormManager.listaTeams));
													
			this._initializeFormFields();
			
			$('#teamdetailactionform_action_saveitem').click(
					$.r3Utils.hitch(this, this._onCreateItem));
			$('#teamdetailactionform_form_action_cancel').hide();
			$('#teamdetailactionform_action_delete').hide();		
		
            this.show();
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
	

	_initializeFormFields: function()
	{
		var useridPickerValue = null;
		
		var resolvedUrl = org.r3.PageManager.getRESTUrl("LUT_CalendarMonthlyPeriod", [ '10', '-4' ] );
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : resolvedUrl,
			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#teamdetailactionform_periodindex'),
			"selectedValue": null,
			"useBusinessKey": false
		});	
		
		
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

});

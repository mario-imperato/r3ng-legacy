$.r3Utils.namespace("org.r3.jsportlet.project.teamtimesheetreport");

org.r3.jsportlet.project.team.TeamTimesheetReportActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);		
	},

	close : function()
	{
		this.hide();
	},
	
	open : function()
	{
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/project/teamtimesheetreport/TeamTimesheetReportQueryFormActionFormView.html.jsp'),
			dataType : "html"
		});

		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			$(this.htmlContainerId).html(tmpl(responseData['view'], { }));

			var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_Resources" );
			org.r3.PageManager.lutManager.populateSelectField(
			{
				"lutUrl" : resolvedUrl,
				"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
				"selectWidget" : $('#teamtimesheetreportform_resourceid'),
				"selectedValue": null // anActorDTOAdapter && anActorDTOAdapter.dataBean.profileid,
			});
			
			var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_TeamMemberProfiles" );
			org.r3.PageManager.lutManager.populateSelectField(
			{
				"lutUrl" : resolvedUrl,
				"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
				"selectWidget" : $('#teamtimesheetreportform_profileid'),
				"selectedValue": null // anActorDTOAdapter && anActorDTOAdapter.dataBean.profileid,
			});
			
			var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_Teams" );
			org.r3.PageManager.lutManager.populateSelectField(
			{
				"lutUrl" : resolvedUrl,
				"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
				"selectWidget" : $('#teamtimesheetreportform_periodindexfrom'),
				"selectedValue": null, // anActorDTOAdapter && anActorDTOAdapter.dataBean.profileid,
				"fnRenderKey": function(item)  { return item.periodindex; }
			});
			
			var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_Teams" );
			org.r3.PageManager.lutManager.populateSelectField(
			{
				"lutUrl" : resolvedUrl,
				"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
				"selectWidget" : $('#teamtimesheetreportform_periodindexto'),
				"selectedValue": null, // anActorDTOAdapter && anActorDTOAdapter.dataBean.profileid,				
				"fnRenderKey": function(item)  { return item.periodindex; }
			});
			
			$('#teamtimesheetreportform_groupby').multiselect();
			
			// ignore: [],
			$("#teamtimesheetreportform_form").validate
	        ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.jsportlet.project.teamtimesheetreport.teamtimesheetreport_form_validationRules,
		           messages: org.r3.jsportlet.project.teamtimesheetreport.teamtimesheetreport_form_validationMessages    
	        });	

			$('#teamtimesheetreportform_fieldset_message').formmessage({});
			
			$('#teamtimesheetreportform_action_query').unbind().click($.r3Utils.hitch(this, this._onQuery));
			
			
			
			$('#teamtimesheetreportform_action_clear').unbind().click($.r3Utils.hitch(this, this._onClearForm));			
			
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
	_onQuery: function()
	{
		var qparams = [];
		
		var v = $('#teamtimesheetreportform_resourceid').val();
		if (v)
		{
			qparams.push(
			{
				"name": "resourceid", "value" : v, "text": $("#teamtimesheetreportform_resourceid option:selected").text()
			});
		}
		
		var v = $('#teamtimesheetreportform_profileid').val();
		if (v)
		{
			qparams.push(
			{
				"name": "profileid", "value" : v, "text": $("#teamtimesheetreportform_profileid option:selected").text()
			});
		}
		
		var v = $('#teamtimesheetreportform_periodindexfrom').val();
		if (v)
		{
			qparams.push(
			{
				"name": "periodindexfrom", "value" : v, "text": $("#teamtimesheetreportform_periodindexfrom option:selected").text()
			});
		}
		
		var v = $('#teamtimesheetreportform_periodindexto').val();
		if (v)
		{
			qparams.push(
			{
				"name": "periodindexto", "value" : v, "text": $("#teamtimesheetreportform_periodindexto option:selected").text()
			});
		}				
				
		var groupBy = $('#teamtimesheetreportform_groupby').val();
		if (groupBy)
		{
			qparams.push(
			{
				"name": "groupby", "value" : groupBy, 
				"text": groupBy.map(function(anItem, anIndex, anArray) { return $("#teamtimesheetreportform_groupby option[value = '" + anItem + "']").text(); })
				               .reduce(function(vacc, vcurrent) { return vacc + ', ' + vcurrent; }) 
			});
		}
		
		this.actionFormManager.executeSearch(groupBy, qparams);		
	},
	
	_onClearForm: function()
	{
		$('#teamtimesheetreportform_form').resetForm();
		$("#teamtimesheetreportform_groupby").multiselect("deselectAll", false).multiselect('updateButtonText');
	}
	
});

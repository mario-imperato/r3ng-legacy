$.r3Utils.namespace("org.r3.jsportlet.sev.application");


org.r3.jsportlet.sev.application.AttendanceSheetActionFormView  = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.activeItemKey = ""
		this.activeItemAttendanceFlagId = "";
		this.activeItemCrewFlagId = "";		
	},

	close : function()
	{
		this.hide();
	},

	refresh: function()
	{
	},
	
	open : function(anApplicationDTOAdapter, wizardActions, showOnLoad)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");
        console.log("Logged User Is: ", org.r3.PageManager.userInfo);
		var networkRequestsQueue = [];

		// Seleziono la scheda anagrafica dipendente dal tipo di azienda: Impresa, Professione, Utente
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/application/AttendanceSheetActionFormView.html.jsp'),
			dataType : "html"
		});

		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_attsheet'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
		    this.activeItemKey = ""
		    this.activeItemAttendanceFlagId = "";
	   	    this.activeItemCrewFlagId = "";		
		
			org.r3.PageManager.closeNotifier();
			
			var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_attsheet');
			var authorizLUT = org.r3.PageManager.lutManager.getLUT(resolvedUrl);

			var templateParams = { 		
			      activeItemKey: "",	      
				  widgets: []	
			};
			
			if (authorizLUT && authorizLUT.aaData && authorizLUT.aaData.length > 0)
			{		
   
				for ( var i = 0; i < authorizLUT.aaData.length; i++)
				{
					var item = authorizLUT.aaData[i];
					
					var attendanceYes = anApplicationDTOAdapter.getPropertyValueAsBoolean(item.dtokey + "_attendanceyes");	
					var crewYes = anApplicationDTOAdapter.getPropertyValueAsBoolean(item.dtokey + "_crewregular");				
			        var disabledField = "";
					
					console.info("giornata regata: ", item.classifieritemsattr, $.r3Utils.parseDate(item.classifieritemsattr, "yyyyMMdd hh:mm"), Date.today())
					var dayOfRegatta = $.r3Utils.parseDate(item.classifieritemsattr, "yyyyMMdd hh:mm")
					if ( $.r3Utils.isAfter(Date.today(), dayOfRegatta) || this.activeItemKey != "") {
					     disabledField = "disabled";
					} else {
					     this.activeItemKey = item.dtokey;
					     this.activeItemAttendanceFlagId = "prop_" + item.dtokey + "_attendanceyes";
		                 this.activeItemCrewFlagId = "prop_" + item.dtokey + "_crewregular";			                					     
					}
					
					console.info("giornata regata: ", item.classifieritemsattr, "is disabled: ", disabledField)
					
					templateParams.activeItemKey = this.activeItemKey;
					templateParams.widgets.push({
						id: item.dtokey,
						label: item.dtodescr,
						cardid: item.classifieritemsattr,
						attendanceyes: attendanceYes ? " checked " : "",
						crewregular: crewYes ? " checked " : "",
						disabled: disabledField
					});
				}	
			}
			
			var templatedHtml = tmpl(responseData['view'], templateParams);
			$(this.htmlContainerId).html(templatedHtml);		
						
			$("#attendancesheetform_form").validate
            ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.jsportlet.sev.application.attendancesheetform_form_validationRules,
		           messages: org.r3.jsportlet.sev.application.attendancesheetform_form_validationMessages    
	        });
			
			$('.attendancesheetform_authcard_link').unbind().click($.r3Utils.hitch(this, function(e) {
				var currentTarget = $(e.currentTarget);
				var currentTargetId = currentTarget.attr('id');
				var cardId = currentTargetId.substring('attendancesheetform_'.length);
				$('#attendancesheetform_authcard').cmsCard({ "card_tmpl": "cms_tpl_simple", "cardid": cardId});
			}));
			
			this._initializeFormFields(anApplicationDTOAdapter);
						
			$('#attendancesheetform_action_next').unbind();
		    $('#attendancesheetform_action_prev').unbind();
			if (wizardActions && wizardActions.indexOf('next') >= 0)
			{
 			      $('#attendancesheetform_action_next').show().click($.r3Utils.hitch(this, this.onNextClick));	
			}
			else  $('#attendancesheetform_action_next').hide();
			
			if (wizardActions && wizardActions.indexOf('prev') >= 0)
			{
 			      $('#attendancesheetform_action_prev').show().click($.r3Utils.hitch(this, this.onPrevClick));	
			}
			else  $('#attendancesheetform_action_prev').hide();		
			
			$('#attendancesheetform_fieldset_message').formmessage({});
			
			if (showOnLoad)
				this.activate();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
	_initializeFormFields: function(anApplicationDTOAdapter)
	{
//		org.r3.PageManager.lutManager.populateSelectField(
//		{
//			"lutUrl" : org.r3.PageManager.getRESTUrl('LUT_Country'),
//			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
//			"selectWidget" : $('#companyinfoform_countryid'),
//			"selectedValue": aCompanyDTOAdapter && aCompanyDTOAdapter.dataBean.countryid
//		});						
//								
		$('#attendancesheetform_applicationid'           ).html(anApplicationDTOAdapter.dataBean.applicationid); 
	
		$("#attendancesheetform_helmsmanpane .fieldValueCell input[type='text']").prop('disabled', true);
		$('#attendancesheetform_havehelmsman_btrue').unbind().click(function(e) {

			var currentTarget = $(e.currentTarget);
			if (currentTarget.prop('checked'))
			{
				$("#attendancesheetform_helmsmanpane .fieldValueCell input[type='text']").prop('disabled', false);					
			}
			else
			{
				$("#attendancesheetform_helmsmanpane .fieldValueCell input[type='text']").prop('disabled', true);
				$("#attendancesheetform_helmsmanpane .fieldValueCell input[type='text']").val("");
			}
			
		});
	},
	
	activate: function()
	{
		this.actionFormManager.showHelp("HLP_SEVATTSHEET");
		this.show();
	},
	
	onNextClick: function()
	{
	    if (this.activeItemKey != "") {
	            var chkBoxAttendance = $("#" + this.activeItemAttendanceFlagId)
	       		console.log($("#" + this.activeItemAttendanceFlagId), chkBoxAttendance.is(':checked'))
	       		var chkBoxCrewFlag = $("#" + this.activeItemCrewFlagId)
	       		console.log($("#" + this.activeItemCrewFlagId), chkBoxCrewFlag.is(':checked'))
	    }
		this.actionFormManager.updateAttendanceSheet("next");		
	},
		
	onPrevClick: function()
	{	
		this.actionFormManager.updateAttendanceSheet("prev");		
	}

});

$.r3Utils.namespace("org.r3.console.sev.application");

org.r3.console.sev.application.CrewVerificationActionsActionFormView = org.r3.ActionFormView.extend(
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
		console.info("Option to refresh!");
	},
	
	open : function()
	{
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/sev/application/CrewVerificationActionsActionFormView.html.jsp'),
			dataType : "html"
		});
		
		networkRequestsQueue.push(
		{
			id : "pkg_fiv_properties",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_FIV_SiteProperties'),
			dataType : "json"
		});
		
		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_SailEvent'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	
			
			$(this.htmlContainerId).html(responseData['view']);	

			var pkg_fiv_properties = responseData['pkg_fiv_properties'];
			if (pkg_fiv_properties)
			{
				pkg_fiv_properties = new org.r3.db.system.siteproperty.SitePropertyDTOTableAdapter(pkg_fiv_properties, 
						function(aRowDataBean) { return new org.r3.db.system.siteproperty.SitePropertyDTOAdapter(aRowDataBean); });					

				var property = pkg_fiv_properties.getPropertyByPropertyscopePropertykey("fiv", "fivclubid");
				if (property)
				{
				    $('#submitcrewcheckform_yachtclubcode').val(property.dataBean.propertyvalue);
				}
				
				var property = pkg_fiv_properties.getPropertyByPropertyscopePropertykey("fiv", "fivpasswd");
				if (property)
				{
				    $('#submitcrewcheckform_yachtclubpwd').val(property.dataBean.propertyvalue);
				    $('#submitcrewcheckform_confirm_yachtclubpwd').val(property.dataBean.propertyvalue);
				}				
			}
			
			$("#submitcrewcheckform_form").validate
            ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.console.sev.application.submitcrewcheckform_form_validationRules,
		           messages: org.r3.console.sev.application.submitcrewcheckform_form_validationMessages    
	        });
			
			$('#submitcrewcheckform_fieldset_message').formmessage({});			
			$('#submitcrewcheckform_action_submit').unbind().click($.r3Utils.hitch(this, this.onSubmitClick));
			$('#submitcrewcheckform_action_cancelsubmit').unbind().click($.r3Utils.hitch(this, this.onCancelSubmitClick));

			
			$('#submitcrewcheckform_action_newcheck').unbind().click(function(e) {
				$('#submitcrewcheckform_actionform').show(); $('#submitcrewcheckform_action_newcheck').hide();
			});
			
			$('#submitcrewcheckform_action_fleetreport').unbind().click($.r3Utils.hitch(this, this.onFleetReport));
			$('#submitcrewcheckform_action_athletesreport').unbind().click($.r3Utils.hitch(this, this.onAthletesReport));
			$('#submitcrewcheckform_action_attendancesheetreport').unbind().click($.r3Utils.hitch(this, this.onAttendanceSheetReport));
									
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
		
	},
	
	onFleetReport: function()
	{
		this.actionFormManager.viewFleetReport();
	},

	onAthletesReport: function()
	{
		this.actionFormManager.athletesReport();
	},
	
	onAttendanceSheetReport: function()
	{
		this.actionFormManager.attendanceSheetReport();
	},
	
	onSubmitClick: function(event)
	{
		var _self = this;
		var urlRequested =  'POST_SEV_ConsoleFleet_CrewCheck';
		
		this.actionFormManager.doProcessUserForm('post', urlRequested, $("#submitcrewcheckform_form"), 
				function(responseData) { 
					if (org.r3.PageManager.isRestDTO(responseData))
					{						
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('submitcrewcheckform_fieldset_message');						
					}
					else 
					{						
						$('#submitcrewcheckform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });
					}						
				}, 
				function(jqXHR, timeout, message) { $('#submitcrewcheckform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); });
		
		event.preventDefault();		
	},
	
	onCancelSubmitClick: function()
	{
		$('#submitcrewcheckform_actionform').hide();
		$('#submitcrewcheckform_action_newcheck').show();
	}
		
});

$.r3Utils.namespace("org.r3.console.sev.application");

org.r3.console.sev.application.PageManager = 
{
  	
	 init: function(applicationId)
	 { 
		 this.applicationActionForm = new org.r3.jsportlet.sev.application.ApplicationActionForm(this, '#JSPortlet_SEVApplicationActionForm', true);
		 this.adminApplicationActionForm = new org.r3.console.sev.application.AdminApplicationActionForm(
				 this, "#adminApplicationActionForm_Container", "#adminApplicationActionForm", "#adminApplicationActionForm_SideBar");
		 this.entryListActionForm = new org.r3.console.sev.application.SailApplicationViewQueryActionForm(this, "#entrylist-actionform-canvas", "#sailApplicationViewQueryActionForm", null, '#sailEventCrewVerificationActionsActionForm');
			 
		 this.appViewer = new org.r3.jsportlet.sev.appviewer.AppViewerActionForm(this, "#canvas_report_content");
		 this.crewReportViewer = new org.r3.jsportlet.sev.crewreportviewer.CrewReportViewerActionForm(this, "#canvas_report_content");
		 
		 org.r3.PageManager.pushHomeConsoleBreadCrumb();			
		 if (applicationId)
	     {
			 this.openAdminApplicationPanel(applicationId); 
		 }
		 else 
		 {
			 this.openQueryActionForm();
		 }
     },

	 _retrieveApplication: function(applicationId, onComplete)
	 {
		 org.r3.PageManager.wait("org.r3.message.waiting");
		 
		var _self = this;
		$.ajax(
		{
			"type" : "get",
			"url" : org.r3.PageManager.getRESTUrl('GET_SEV_Application_Detail', [ applicationId ] ),
			"dataType" : "json",
			"success" : function(responseData)
			{
				org.r3.PageManager.closeNotifier();
				if (org.r3.PageManager.isRestDTO(responseData))
				{
					var restDto = new org.r3.RestDTOAdapter(responseData);
					console.error("Whatta...");
					// restDto.showMessage('searchactionform_form_fieldset_message');
				}
				else 
				{
					var applicationDTOAdapter = new org.r3.db.sailevent.application.SailApplicationDTOAdapter(responseData);
					if (onComplete) 
						onComplete(applicationDTOAdapter);
				}
				
			},

			"error" : function(jqXHR, timeout, message)
			{
				console.error("...> error");
				org.r3.PageManager.closeNotifier();
			}
		});	 
	 },
	 
	 openQueryActionForm : function()
	 {		  
	 	 org.r3.PageManager.pushBreadCrumb(
		 {
			"title" : "Lista Iscritti",
			"actionForm" : this.entryListActionForm
		 });

		this.entryListActionForm.open();
	 },
	 
	 openAdminApplicationPanel : function(anApplicationId)
	 {			 
	 	 org.r3.PageManager.pushBreadCrumb(
		 {
			"title" : "Amministrazione Modulo Iscrizione",
			"actionForm" : this.adminApplicationActionForm
		 });

	 	this.adminApplicationActionForm.open(anApplicationId);
	 },

	 viewApplication: function(applicationId)
	 {
		 org.r3.PageManager.openFullScreenLayout(this.appViewer);
	     this.appViewer.open(applicationId);
	 },
	 
	 viewFleetReport: function()
	 {
		 org.r3.PageManager.openFullScreenLayout(this.crewReportViewer);
	     this.crewReportViewer.open();
	 },
	 
	 athletesReport: function()
	 {
		 var restUrl = org.r3.PageManager.getRESTUrl('GET_SEV_ConsoleAthletesReport');			 
		 window.location.href = restUrl;	
	 },
	 
	 attendanceSheetReport: function()
	 {
		 var restUrl = org.r3.PageManager.getRESTUrl('GET_SEV_ConsoleAttendanceSheetReport');			 
		 window.location.href = restUrl;	
	 },
	 
	 openApplicationPortlet : function(anApplicationDTOAdapter)
	 {
		 var _self = this;
		 
		 this._retrieveApplication(anApplicationDTOAdapter.dataBean.applicationid, function(retrievedaApplicationDTOAdapter) {
		 	 org.r3.PageManager.pushBreadCrumb(
		 			 {
		 				"title" : "Modulo Iscrizione",
		 				"actionForm" : _self.applicationActionForm
		 			 });

		 			 _self.applicationActionForm.open(retrievedaApplicationDTOAdapter);			 
		 });
		 
	 },

};


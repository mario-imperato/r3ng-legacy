$.r3Utils.namespace("org.r3.jsportlet.sev.crewreportviewer");

org.r3.jsportlet.sev.crewreportviewer.CrewReportViewerActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},
	
	open : function(applicationId)
	{
		var _self = this;
		
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/crewreportviewer/CrewReportViewerActionForm.html.jsp'),
			dataType : "html"
		});

		networkRequestsQueue.push(
		{
			id : "report_content",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_SEV_ConsoleCrewReport' ),
			dataType : "json"
		});
				
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_crewrole'));
    networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_crewstatus'));		
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_fivcardstatus'));
						
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	

			var crewReportTableAdapter = responseData["report_content"];
			if (crewReportTableAdapter)
			{
				crewReportTableAdapter = new org.r3.db.DTOTableAdapter(crewReportTableAdapter, 
	    				function(aRowDataBean) { return new org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewSummaryDTOAdapter(aRowDataBean); });	

			}

			var templatedHtml = tmpl(responseData['view'], { "crewReport": crewReportTableAdapter });
 		    $(this.htmlContainerId).html(templatedHtml);		

 		    $('#crewreportviewer_action_print').unbind().click(function(e) 
 		    {
 		    	window.print();	
 		    });

 		    $('#crewreportviewer_action_back').unbind().click(function(e) 
 		    {
 		    	_self.close();
 		        org.r3.PageManager.closeFullScreenLayout();	
 		    });
 		    
 		    $('#canvas_report_title').html("Rapporto Flotta");
 		     	       
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
		
	}
	
	
		
});

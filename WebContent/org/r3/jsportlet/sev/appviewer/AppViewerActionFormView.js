$.r3Utils.namespace("org.r3.jsportlet.sev.appviewer");

org.r3.jsportlet.sev.appviewer.AppViewerActionFormView = org.r3.ActionFormView.extend(
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
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/appviewer/AppViewerActionForm.html.jsp'),
			dataType : "html"
		});

		networkRequestsQueue.push(
		{
			id : "app_content",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_SEV_Application_Detail', [ applicationId ] ),
			dataType : "json"
		});

		networkRequestsQueue.push(
		{
			id : "app_crew",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_SEV_Application_Crew', [ applicationId ] ),
			dataType : "json"
		});

		networkRequestsQueue.push(
		{
			id : "app_docs",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_SEV_Application_Documents', [ applicationId ] ),
			dataType : "json"
		});
				
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_completion'));
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_boatgroup'));
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_boatgroup2'));
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_ranktype'));
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_apptype'));
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_sailmat'));
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_authoriz'));
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_crewrole'));
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_mooringloc'));
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_doctype'));
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_admincks'));
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_orcgranc'));
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_boatelse'));
	  networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_crewstatus'));
				
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	

			var applicationDTOAdapter = responseData["app_content"];
			if (applicationDTOAdapter)
			{
				applicationDTOAdapter = new org.r3.db.sailevent.application.SailApplicationDTOAdapter(applicationDTOAdapter);	
			}

			var appCrewDataTableAdapter = responseData["app_crew"];
			if (appCrewDataTableAdapter)
			{
				appCrewDataTableAdapter = new org.r3.db.DTOTableAdapter(appCrewDataTableAdapter, 
	    				function(aRowDataBean) { return new org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTOAdapter(aRowDataBean); });	
			}

			var appDocumentsDataTableAdapter = responseData["app_docs"];
			if (appDocumentsDataTableAdapter)
			{
				appDocumentsDataTableAdapter = new org.r3.db.DTOTableAdapter(appDocumentsDataTableAdapter, 
	    				function(aRowDataBean) { return new org.r3.db.sailevent.appdocument.SailApplicationDocumentDTOAdapter(aRowDataBean); });	
			}

			var templatedHtml = tmpl(responseData['view'], { "appDTO": applicationDTOAdapter, "crewDTO": appCrewDataTableAdapter, "docsDTO": appDocumentsDataTableAdapter });
 		    $(this.htmlContainerId).html(templatedHtml);		
			if (org.r3.SiteConstants.sailEventApplication && org.r3.SiteConstants.sailEventApplication.boatinfoform_otherinfo == 'bfalse')
			{
			     $('#appviewer_boatinfoform_otherinfo_framedpanel').hide();
			}

			if (org.r3.SiteConstants.sailEventApplication && org.r3.SiteConstants.sailEventApplication.boatinfoform_sailcloth == 'bfalse')
			{
			     $('#appviewer_boatinfoform_sailcloth_framedpanel').hide();
			}

			if (org.r3.SiteConstants.sailEventApplication && org.r3.SiteConstants.sailEventApplication.classinfoform_apptype == 'bfalse')
			{
			     $('#appviewer_classinfoform_apptype_framedpanel').hide();
			}
			
			if (org.r3.SiteConstants.sailEventApplication && org.r3.SiteConstants.sailEventApplication.classinfoform_grancrocieraorc == 'bfalse')
			{
			     $('#appviewer_classinfoform_grancrocieraorc_framedpanel').hide();
			}
			
			if (org.r3.SiteConstants.sailEventApplication && org.r3.SiteConstants.sailEventApplication.classinfoform_racegroupdecl == 'bfalse')
			{
			     $('#appviewer_classinfoform_racegroupdecl_checkboxgroup').hide();
			}

//			$('#appviewer_action_print').unbind().click(function(e) 
// 		    {
// 		    	window.print();	
// 		    });
//
// 		    $('#appviewer_action_back').unbind().click(function(e) 
// 		    {
// 		    	_self.close();
// 		        org.r3.PageManager.closeFullScreenLayout();	
// 		    });
 		    
 		    $('#canvas_report_title').html("Domanda di Iscrizione: " + applicationId);
 		    
 		   var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_authoriz');    
 	       var theLUT = org.r3.PageManager.lutManager.getLUT(resolvedUrl);
 	       if (theLUT.aaData && theLUT.iTotalRecords)
 	       {
 	             $.each(theLUT.aaData, function(index, item)
 	             {
 	            	 // console.info("Item: ", item.classifieritemsattr, $('#' + item.classifieritemsattr));
 	                 $('#appviewer_' + item.classifieritemsattr).cmsCard({ card_tmpl: "cms_tpl_simple", "cardid": item.classifieritemsattr});
 	             });
 	       }
 	       
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
		
	}
	
	
		
});

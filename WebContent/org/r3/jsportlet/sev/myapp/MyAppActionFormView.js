$.r3Utils.namespace("org.r3.jsportlet.sev.myapp");

org.r3.jsportlet.sev.myapp.MyAppActionFormView = org.r3.ActionFormView.extend(
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
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/myapp/MyAppActionForm.html.jsp'),
			dataType : "html"
		});

		if (!org.r3.PageManager.userInfo.isGuest())
		{
			var restUrl = org.r3.PageManager.getRESTUrl('GET_SEV_MyApplications');
			networkRequestsQueue.push(
			{
				id : "view_apps",
				type : "Get",
				url : restUrl,
				dataType : "json"
			});		    	
		}
		
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_completion'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	
		
			var applicationsDataTableAdapter = null;
			var emptyApplicationId = null;
			var numberOfDraftApplications = 0;
			var numberOfCommitApplications = 0;
			if (!org.r3.PageManager.userInfo.isGuest())
			{			
			   applicationsDataTableAdapter = responseData['view_apps'];
			   if (applicationsDataTableAdapter)
               {
				applicationsDataTableAdapter = new org.r3.db.DTOTableAdapter(applicationsDataTableAdapter, 
						function(aRowDataBean) { return new org.r3.db.sailevent.application.SailApplicationDTOAdapter(aRowDataBean); });
				
				var visitor = {
					
					processItem: function(anItem)
					{
						if (anItem.isDraft())
							numberOfDraftApplications++;
						else if (anItem.isEmpty())
							emptyApplicationId = anItem.dataBean.applicationid;
						else numberOfCommitApplications++;
							
						return true;						
					}
				};
				
				applicationsDataTableAdapter.visit(visitor);
               }				
			}
			
 		    var templatedHtml = tmpl(responseData['view'], { 
 		    	 "guest": org.r3.PageManager.userInfo.isGuest(), 
 		    	 "apps": applicationsDataTableAdapter,
 		         "numberOfDraftApplications": numberOfDraftApplications,
 		         "numberOfCommitApplications": numberOfCommitApplications,
 		         "emptyApplicationId": emptyApplicationId
 		    });
 		    
 		    $(this.htmlContainerId).html(templatedHtml);
			$('#myappactionform_action_newapp').unbind().click($.r3Utils.hitch(this.actionFormManager, this.actionFormManager.newApplication));
			$('.myappactionform_action_editapp').unbind().click($.r3Utils.hitch(this, this.onEditApplication));
						
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
		
	},
	
	onEditApplication: function(e)
	{
		var currentTarget = $(e.currentTarget);
		var currentTargetId = currentTarget.attr('id');
		console.info("Editing current: ", currentTargetId);
		
		this.actionFormManager.editApplication(currentTargetId);
	}
	
		
});

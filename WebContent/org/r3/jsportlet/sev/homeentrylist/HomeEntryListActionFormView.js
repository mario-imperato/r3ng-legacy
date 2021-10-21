$.r3Utils.namespace("org.r3.jsportlet.sev.homeentrylist");

org.r3.jsportlet.sev.homeentrylist.HomeEntryListActionFormView = org.r3.ActionFormView.extend(
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
		// console.info('SiteConstants:', org.r3.SiteConstants);
		
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		
		if (org.r3.SiteConstants && org.r3.SiteConstants.home && org.r3.SiteConstants.home.entrylist && org.r3.SiteConstants.home.entrylist.ui == 'wall')
		{
			networkRequestsQueue.push(
			{
				id : "view",
				type : "Get",
				url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/homeentrylist/HomeEntryListActionForm_BoatFreeWall.html.jsp'),
				dataType : "html"
			});			
		}
		else
		{
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/homeentrylist/HomeEntryListActionForm.html.jsp'),
			dataType : "html"
		});
		}
		
		var restUrl = org.r3.PageManager.getRESTUrl('GET_SEV_HomeEntryList');
		networkRequestsQueue.push(
		{
			id : "view_apps",
			type : "Get",
			url : restUrl,
			dataType : "json"
		});		    	
		
		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_completion'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	
		
			var applicationsDataTableAdapter = null;
		    applicationsDataTableAdapter = responseData['view_apps'];
		    if (applicationsDataTableAdapter)
            {
		  	   applicationsDataTableAdapter = new org.r3.db.DTOTableAdapter(applicationsDataTableAdapter, 
					function(aRowDataBean) { return new org.r3.db.sailevent.homeentrylist.SailHomeEntryListDTOAdapter(aRowDataBean); });				
            }				
			
 		    var templatedHtml = tmpl(responseData['view'], { 
 		    	 "userid": org.r3.PageManager.userInfo.dataBean.userid, 
 		    	 "apps": applicationsDataTableAdapter
 		    });
 		    
 		    $(this.htmlContainerId).html(templatedHtml);
			$('.homeentrylistactionform_action_editapp').unbind().click($.r3Utils.hitch(this, this.onEditApplication));
			$('#homeentrylistactionform_action_goto_entrylist').unbind().click($.r3Utils.hitch(this, this.onGotoEntryList));					
			
			var wall = new Freewall("#freewall");
			wall.reset({
				
				selector: '.brick',
				animate: true,
				fixSize: null,
				cellW: 50,
				cellH: 50,
				delay: 50,
				onResize: function() {
					wall.fitWidth();
				}
			});
			wall.fitWidth();
			
			$("a[rel='lightbox-homeentrylist']").slimbox();
			
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
	},
	
	onGotoEntryList: function()
	{
		org.r3.PageManager.gotoPage(org.r3.Constants.getStrutsActionContext() + "/org/r3/sev/entrylist.do");
	}
	
		
});

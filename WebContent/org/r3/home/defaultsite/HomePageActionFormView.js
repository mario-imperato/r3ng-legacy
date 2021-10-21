$.r3Utils.namespace("org.r3.home.defaultsite");

org.r3.home.defaultsite.HomePageActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},
	
	open : function(siteTypeFilter)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/home/defaultsite/HomePageActionForm.html.jsp'),
			dataType : "html"
		});

		if (siteTypeFilter)
		{
		networkRequestsQueue.push(
		{
			id : "events",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('LUT_Site_OfType', [ siteTypeFilter ]),
			dataType : "json"
		});		
		}
		else
		{
			networkRequestsQueue.push(
			{
				id : "events",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl('LUT_Site'),
				dataType : "json"
			});					
		}

		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_SailEvent'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	

			var events = responseData["events"];			
            var templatedHtml = tmpl(responseData['view'], events );
			$(this.htmlContainerId).html(templatedHtml);
			
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
	}
	
});

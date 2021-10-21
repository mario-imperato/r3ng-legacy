$.r3Utils.namespace("org.r3.jsportlet.rndphotosidebar");

org.r3.jsportlet.rndphotosidebar.RandomPhotoSideBarActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.defaultOptionsHash = { "collection": "shakeus", "numberOfIcons": 4 }
	},

	close : function()
	{
		this.hide();
	},
	
	open : function(configHash)
	{
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/rndphotosidebar/RandomPhotoSideBarActionForm.html.jsp'),
			dataType : "html"
		});

		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_SailEvent'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	

			var displayOptions = $.extend(this.defaultOptionsHash, configHash);
			displayOptions.startIcon = 1;
			
			var templatedHtml = tmpl(responseData['view'], displayOptions);
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

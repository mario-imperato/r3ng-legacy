$.r3Utils.namespace("org.r3.console.system.tutorials");

org.r3.console.system.tutorials.SimpleURLInvokationActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},

	clear : function()
	{
		
	},
	
	open : function(anHttpMethod, aUrlToInvoke)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/system/tutorials/SimpleURLInvokationActionForm.html'),
			dataType : "html"
		});

		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			$(this.htmlContainerId).html(responseData['view']); 		   						
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
	}
	
});

$.r3Utils.namespace("org.r3.jsportlet.cms");


org.r3.jsportlet.cms.CMSHTMLPageViewerActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},

	open : function(aDMSUrl)
	{
		var _self = this;
		
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/cms/CMSHTMLPageViewerActionFormView.html.jsp'),
			dataType : "html"
		});

		networkRequestsQueue.push(
		{
			id : "content",
			type : "Get",
			url : $.r3Utils.formatDMSUrl4ClientAccess(aDMSUrl),
			dataType : "html"
		});
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

   		    $(this.htmlContainerId).html(responseData['view']);		
  		    $('#cmsHTMLPageViewerActionForm_htmlcanvas').html(responseData['content']);
     		   
// 		    $('#appviewer_action_print').unbind().click(function(e) 
// 		    {
// 		    	window.print();	
// 		    });
//
// 		    $('#appviewer_action_back').unbind().click(function(e) 
// 		    {
// 		    	_self.actionFormManager.close();
// 		        org.r3.PageManager.closeFullScreenLayout();	
// 		    });
     		    
			
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	}
	
});

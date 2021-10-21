$.r3Utils.namespace("org.r3.jsportlet.sev.homenorlist");

org.r3.jsportlet.sev.homenorlist.HomeNORActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.documentListDivLocator = anHtmlActionFormContainerId + " .cms_card_canvas";
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
		
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/homenorlist/HomeNORActionForm.html.jsp'),
			dataType : "html"
		});
						
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	
		
 		    $(this.htmlContainerId).html(responseData['view']);	
 			$(this.documentListDivLocator).cmsCard({ 
 				card_tmpl: "cms_tpl_cardsetlistofdocuments", 
 				cardquery: "groupid=grp_nor", 
 			    onComplete: function()
 			    {			
 			    }
 		    });
 			
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
		
	}
		
		
});

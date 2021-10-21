$.r3Utils.namespace("org.r3.shkadmin.home");

org.r3.shkadmin.home.SHKAdminWelcomeActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);		
		this.configOptions = null;
	},

	close : function()
	{
		this.hide();
	},
	
	open : function(openParamsHash)
	{		
		this.configOptions = openParamsHash;
		
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/shkadmin/home/SHKAdminWelcomeActionFormView.html'),
			dataType : "html"
		});

		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_SailEvent'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	
						           
			$(this.htmlContainerId).html(responseData["view"]);

			var cardCanvas = $(this.htmlContainerId + " #shkAdminWelcomeCard");
			var dataCardId = openParamsHash.welcomeCardId;
			if (!dataCardId)
			{
				dataCardId = $(this.htmlContainerId).attr("data-cardid");	
			}
			
			cardCanvas.cmsCard({ site: org.r3.SiteConstants.sitedomain, card_tmpl: "cms_tpl_embeddedfragments", "cardid": dataCardId});
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
	}
});

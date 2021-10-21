$.r3Utils.namespace("org.r3.jsportlet.sev.homeiconmenu");

org.r3.jsportlet.sev.homeiconmenu.HomeIconMenuActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.documentListDivLocator = anHtmlActionFormContainerId + " .cms_cardDetail";
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
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.getStrutsActionContext() + '/org/r3/mvc_view.do?fviewid=HomeIconMenuActionForm'),
			dataType : "html"
		});
						
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	
		
 		    $(this.htmlContainerId).html(responseData['view']);	
 			 $("#iconic_menu_carousel_canvas").carouFredSel({
 				auto     : false,
 				align    : 'center',
 				width    : '100%',
 				
 				pagination : {
 					        container   : "#iconic_menu_carousel_pagination",
 						        keys        : true,
 						        easing      : "easeOutBounce",
 						        duration    : 3000
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

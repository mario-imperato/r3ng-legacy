$.r3Utils.namespace("org.r3.jsportlet.cookielaw");

org.r3.jsportlet.cookielaw.CookieLawActionFormView = org.r3.ActionFormView.extend(
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
		var _self = this;
		
		// console.info('SiteConstants:', org.r3.SiteConstants);
		
		// org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/cookielaw/CookieLawActionFormView.html.jsp'),
			dataType : "html"
		});
				
		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_Agenda', [ org.r3.Constants.site ]));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			// org.r3.PageManager.closeNotifier();			 	
		
 		    $(this.htmlContainerId).html(responseData['view']);		
 		    
 		    $('#cookieLawConsent_action_close').unbind().click(function(e) {
 		        console.info("Accepting CookieLaw Consent");
 		       $(_self.htmlContainerId).hide();
 		       _self.actionFormManager.provideConsent();
 		    });
 		    
 		    this.loadIubendaScript();		    		
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
		
	},
	
	loadIubendaScript: function()
	{
		 var s = document.createElement("script"), 
	     tag = document.getElementsByTagName("script")[0]; 
	     s.src = "//cdn.iubenda.com/iubenda.js"; 
	     tag.parentNode.insertBefore(s,tag);
	}
		
});

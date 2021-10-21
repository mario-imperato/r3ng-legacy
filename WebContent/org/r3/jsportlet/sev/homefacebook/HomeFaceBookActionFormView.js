$.r3Utils.namespace("org.r3.jsportlet.sev.homefacebook");

org.r3.jsportlet.sev.homefacebook.HomeFaceBookActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},
	
	open : function(aPortletWidth)
	{
		// console.info('SiteConstants:', org.r3.SiteConstants);
		
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/homefacebook/HomeFaceBookActionForm.html.jsp'),
			dataType : "html"
		});
						
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();		
			
			var templatedHtml = tmpl(responseData['view'], { "portletWidth": aPortletWidth}); 		   
			$(this.htmlContainerId).html(templatedHtml);	 			
			this.show();
			
			$('#facebook_test').unbind().click(function(e) {
				FB.XFBML.parse();
			});
			
			fbEnsureInit(function() {
				FB.XFBML.parse();
			});
			
			// FB.XFBML.parse();
			// $.getScript('http://connect.facebook.net/it_IT/sdk.js#xfbml=1&version=v2.0');
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
		
	}
		
		
});

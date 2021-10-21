$.r3Utils.namespace("org.r3.jsportlet.cookielaw");

org.r3.jsportlet.cookielaw.CookieLawActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.cookielaw.CookieLawActionFormView(aDetailViewContainerId, this);
	},

	close : function()
	{
		this.hide();
	},

	hide : function()
	{
		this.detailView.hide();
	},

	show : function()
	{
		this.detailView.show();
	},

	refresh : function()
	{
	},

	open : function()
	{
		this.detailView.open();
	},
	
	provideConsent: function()
	{
		var restUrl = org.r3.PageManager.getRESTUrl('PUT_User_Consent', [ 'CURRENT' ]);

		$.ajax(
		{
			"type" : "PUT",
			"url" : restUrl,
			"dataType" : "json",
			"success" : function()
			{
			},
			"error" : function(jqXHR, timeout, message)
			{
				console.error("Errore Sending Consent: ", jqXHR, timeout, message);
			}
		});		
	}
				
});


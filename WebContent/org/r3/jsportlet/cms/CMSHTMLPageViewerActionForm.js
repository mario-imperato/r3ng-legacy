$.r3Utils.namespace("org.r3.jsportlet.cms");

org.r3.jsportlet.cms.CMSHTMLPageViewerActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, instancePrintableFlag)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.cms.CMSHTMLPageViewerActionFormView(aDetailViewContainerId, this);		
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

	refresh: function()
	{
	},
	
	open : function(aDmsUrl)
	{
		this.detailView.open(aDmsUrl);		
	}

		
});


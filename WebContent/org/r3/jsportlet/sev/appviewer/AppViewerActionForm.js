$.r3Utils.namespace("org.r3.jsportlet.sev.appviewer");

org.r3.jsportlet.sev.appviewer.AppViewerActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.sev.appviewer.AppViewerActionFormView(aDetailViewContainerId, this);
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

	open : function(applicationId)
	{
		this.detailView.open(applicationId);
	}
				
});


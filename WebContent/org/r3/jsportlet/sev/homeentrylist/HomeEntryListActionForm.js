$.r3Utils.namespace("org.r3.jsportlet.sev.homeentrylist");

org.r3.jsportlet.sev.homeentrylist.HomeEntryListActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.sev.homeentrylist.HomeEntryListActionFormView(aDetailViewContainerId, this);
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
	
	editApplication: function(applicationId)
	{
		var targetUrl = org.r3.Constants.getStrutsActionContext() + '/org/r3/sev/application/editMyApplication.do?objid=' + applicationId;
		org.r3.PageManager.gotoPage(targetUrl);
	}
				
});


$.r3Utils.namespace("org.r3.shkadmin.siteconfig");

org.r3.shkadmin.siteconfig.SiteInfoActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aChildEntityListViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.shkadmin.siteconfig.SiteInfoActionFormView(aDetailViewContainerId, this);
	},

	close : function()
	{
		// M20140201 - org.r3.PageManager.popBreadCrumb();
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

	open : function()
	{
		this.detailView.open();			
	}
		

});


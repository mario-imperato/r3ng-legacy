$.r3Utils.namespace("org.r3.jsportlet.site.sitemember");

org.r3.jsportlet.site.sitemember.SiteMemberPortletActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aChildEntityListViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.site.sitemember.SiteMemberPortletActionFormView(aDetailViewContainerId, this);		
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
	},

	

});
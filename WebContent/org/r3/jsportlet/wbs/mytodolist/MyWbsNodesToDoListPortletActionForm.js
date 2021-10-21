$.r3Utils.namespace("org.r3.jsportlet.wbs.mytodolist");

org.r3.jsportlet.wbs.mytodolist.MyWbsNodesToDoListPortletActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.wbs.mytodolist.MyWbsNodesToDoListPortletActionFormView(aDetailViewContainerId, this);
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
		if (org.r3.PageManager.userInfo.isInRole(org.r3.Constants.site, 'workshop') && org.r3.PageManager.getSiteActorId())
		       this.detailView.open();
	}
				
});


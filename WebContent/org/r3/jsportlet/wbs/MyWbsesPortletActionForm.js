$.r3Utils.namespace("org.r3.jsportlet.wbs");

org.r3.jsportlet.wbs.MyWbsesPortletActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.wbs.MyWbsesPortletActionFormView(aDetailViewContainerId, this);
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
		if (org.r3.PageManager.userInfo.isInRole(org.r3.Constants.site, 'workshop'))
		       this.detailView.open();
	}
				
});


$.r3Utils.namespace("org.r3.jsportlet.wbs.dashboard");

org.r3.jsportlet.wbs.dashboard.WBSPortletDashBoardActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.wbs.dashboard.WBSPortletDashBoardActionFormView(aDetailViewContainerId, this);
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

	open : function(aWbsId_OR_aWbsDTOAdapter)
	{
		this.detailView.open(aWbsId_OR_aWbsDTOAdapter);
	}
					
});


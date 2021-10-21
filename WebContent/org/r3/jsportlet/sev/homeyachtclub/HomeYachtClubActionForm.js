$.r3Utils.namespace("org.r3.jsportlet.sev.homeyachtclub");

org.r3.jsportlet.sev.homeyachtclub.HomeYachtClubActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.sev.homeyachtclub.HomeYachtClubActionFormView(aDetailViewContainerId, this);
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
	}
				
});


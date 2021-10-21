$.r3Utils.namespace("org.r3.home.mastersite");

org.r3.home.mastersite.HomePageActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.home.mastersite.HomePageActionFormView(aDetailViewContainerId, this);
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

	open : function(siteTypeFilter)
	{
		this.detailView.open(siteTypeFilter);
	}
		
});


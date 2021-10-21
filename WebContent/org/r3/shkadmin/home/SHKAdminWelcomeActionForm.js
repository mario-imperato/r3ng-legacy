$.r3Utils.namespace("org.r3.shkadmin.home");

org.r3.shkadmin.home.SHKAdminWelcomeActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.shkadmin.home.SHKAdminWelcomeActionFormView(aDetailViewContainerId, this);
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

	open : function(anOpeningOptionsHash)
	{
		this.detailView.open(anOpeningOptionsHash);
	}		
});


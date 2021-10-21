$.r3Utils.namespace("org.r3.jsportlet.dialog");

org.r3.jsportlet.dialog.DialogConfirmationActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.dialog.DialogConfirmationActionFormView(aDetailViewContainerId, this);
	},

	close : function()
	{
		this.hide();
	},

	hide : function()
	{
		this.detailView.hide();
	},

	show : function(optionsHash)
	{
		this.detailView.show(optionsHash);
	},

	refresh : function()
	{
	},

	open : function()
	{
		this.detailView.open();
	}
			
});


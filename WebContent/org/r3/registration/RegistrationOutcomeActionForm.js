$.r3Utils.namespace("org.r3.registration");

org.r3.registration.RegistrationOutcomeActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.registration.RegistrationOutcomeActionFormView(aDetailViewContainerId, this);
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

	open : function(isSuccessFlag)
	{
		this.detailView.open(isSuccessFlag);
	}
	
		
});


$.r3Utils.namespace("org.r3.console.system.tutorials");

org.r3.console.system.tutorials.SimpleURLInvokationActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.console.system.tutorials.SimpleURLInvokationActionFormView(aDetailViewContainerId, this);
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

	refresh : function()
	{
	},

	open : function(theMethod, theUrlToInvoke)
	{
		console.log("SimpleURLInvokationActionForm::open", theMethod, theUrlToInvoke);
		this.detailView.open(theMethod, theUrlToInvoke);
		this.show();
	}
	
	
});


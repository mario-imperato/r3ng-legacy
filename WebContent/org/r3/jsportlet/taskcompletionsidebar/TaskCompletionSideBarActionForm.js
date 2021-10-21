$.r3Utils.namespace("org.r3.jsportlet.taskcompletionsidebar");

org.r3.jsportlet.taskcompletionsidebar.TaskCompletionSideBarActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, optionsHash)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.taskcompletionsidebar.TaskCompletionSideBarActionFormView(aDetailViewContainerId, this);			
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

	open : function(configHash)
	{
		this.detailView.open(configHash);
	}
	
});


$.r3Utils.namespace("org.r3.wbs.towfillout");

org.r3.wbs.towfillout.WBSDetailActionForm = org.r3.ActionFormManager.extend(
{
	init : function(aPageManager, aDetailViewContainerId, aChildEntityListViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.wbs.towfillout.WBSDetailActionFormView(aDetailViewContainerId, this);				
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

	open : function(aWbsId_OR_aWbsDTOAdapter)
	{
		this.detailView.open(aWbsId_OR_aWbsDTOAdapter);			
	}
			

});


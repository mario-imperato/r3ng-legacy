$.r3Utils.namespace("org.r3.wbs.wbsfillout");

org.r3.wbs.wbsfillout.NavigatorActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aChildEntityListViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.wbs.wbsfillout.NavigatorActionFormView(aDetailViewContainerId, this);
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

	open : function(pageInfo, cardInfo, aWbsId, aWbsNodeId)
	{
		this.detailView.open(pageInfo, cardInfo, aWbsId, aWbsNodeId);			
	},
	
    openWBSDetailActionFormPanel : function(aWbsId_OR_aWbsDTOAdapter)
	{		 		 		 
	    this.pageManager.openWBSDetailActionFormPanel(aWbsId_OR_aWbsDTOAdapter);
	},
	
	openWBSNodeDetailActionFormPanel : function(aWbsId, aWbsNodeId)
	{
		this.pageManager.openWBSNodeDetailActionFormPanel(aWbsId, aWbsNodeId);
	}
		

});


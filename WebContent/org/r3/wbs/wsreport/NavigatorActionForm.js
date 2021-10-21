$.r3Utils.namespace("org.r3.wbs.wsreport");

org.r3.wbs.wsreport.NavigatorActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aChildEntityListViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.wbs.wsreport.NavigatorActionFormView(aDetailViewContainerId, this);
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

	open : function(pageInfo, cardInfo)
	{
		this.detailView.open(pageInfo, cardInfo);			
	},
	
    openReportDetailActionFormPanel : function(aWbsId)
	{		 		 		 
	    this.pageManager.openReportDetailActionFormPanel(aWbsId);
	},
	
	openFullReportPanel: function()
	{
		this.pageManager.openFullReportPanel();
	}
		
});


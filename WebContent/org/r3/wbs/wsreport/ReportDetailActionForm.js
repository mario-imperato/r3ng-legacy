$.r3Utils.namespace("org.r3.wbs.wsreport");

org.r3.wbs.wsreport.ReportDetailActionForm = org.r3.ActionFormManager.extend(
{
	init : function(aPageManager, aDetailViewContainerId, isPrintable)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.wbs.wsreport.ReportDetailActionFormView(aDetailViewContainerId, this, isPrintable);		
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

	open : function(aWbsId)
	{
		this.detailView.open(aWbsId);			
	},
	
	openPrintableReportPanel: function(aWbsId)
	{
		this.pageManager.openPrintableReportPanel(aWbsId);
	}
			

});


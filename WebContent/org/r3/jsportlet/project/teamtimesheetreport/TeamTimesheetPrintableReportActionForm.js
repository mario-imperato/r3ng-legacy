$.r3Utils.namespace("org.r3.jsportlet.project.teamtimesheetreport");

org.r3.jsportlet.project.teamtimesheetreport.TeamTimesheetPrintableReportActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.project.teamtimesheetreport.TeamTimesheetPrintableReportActionFormView(aDetailViewContainerId, this);
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

	open : function(aGroupByClause, queryParams)
	{
		this.detailView.open(aGroupByClause, queryParams);
	}
				
});


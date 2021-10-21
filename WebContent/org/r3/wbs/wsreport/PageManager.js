$.r3Utils.namespace("org.r3.wbs.wsreport");

org.r3.wbs.wsreport.PageManager = 
{
	init : function(pageInfo, cardInfo)
	{
		org.r3.PageManager.googleAnalyticsSendPageView();
				
		this.navigator = new org.r3.wbs.wsreport.NavigatorActionForm(this, "#navigatorActionForm");	
		this.reportDetail = new org.r3.wbs.wsreport.ReportDetailActionForm(this, "#reportDetailActionForm");
		this.printableReportDetail = new org.r3.wbs.wsreport.ReportDetailActionForm(this, '#canvas_report_content', true);
		
		org.r3.PageManager.pushHomeBreadCrumb();
		this.openNavigator(pageInfo, cardInfo);
	},
		
	
	openNavigator : function(pageInfo, cardInfo) 
	{
		var _self = this;
		this.navigator.open(pageInfo, cardInfo);		
	},
	
    openReportDetailActionFormPanel : function(aWbsId)
	{		 		 		 	    
		org.r3.PageManager.pushBreadCrumb({
			"title" : "Report WBS",
			"actionForm" : this.reportDetail
		});	   	
		
		this.reportDetail.open(aWbsId);
	},
	
	openFullReportPanel: function()
	{
		org.r3.PageManager.pushBreadCrumb({
			"title" : "Report WBS",
			"actionForm" : null
		});	
		
		this.reportDetail.open();
	},
	
	openPrintableReportPanel: function(aWbsId)
	{
		org.r3.PageManager.openFullScreenLayout(this.printableReportDetail);
		this.printableReportDetail.open(aWbsId);	
	}

};


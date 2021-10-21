$.r3Utils.namespace("org.r3.wbs.towfillout");

org.r3.wbs.towfillout.PageManager = 
{
	init : function(pageInfo, cardInfo)
	{
		org.r3.PageManager.googleAnalyticsSendPageView();
				
		this.navigator = new org.r3.wbs.towfillout.NavigatorActionForm(this, "#navigatorActionForm");	
		this.wbsDetail = new org.r3.wbs.towfillout.WBSDetailActionForm(this, "#wbsDetailActionForm");
		this.wbsNodeDetail = new org.r3.wbs.towfillout.WBSNodeDetailActionForm(this, "#wbsNodeDetailActionForm", "#wbsNodeQueryActionForm");
		
		org.r3.PageManager.pushHomeBreadCrumb();
		
		var wbsIdParam = $.r3Utils.getQueryStringParamFromPageUrl("wbsid");
		console.log("wbsIdParam", wbsIdParam);
		
		var wbsNodeIdParam = $.r3Utils.getQueryStringParamFromPageUrl("wbsnodeid");
		console.log("wbsNodeIdParam", wbsNodeIdParam);
		
		this.openNavigator(pageInfo, cardInfo, wbsIdParam, wbsNodeIdParam);
	},
		
	
	openNavigator : function(pageInfo, cardInfo, aWbsId, aWbsNodeId) 
	{
		var _self = this;
		this.navigator.open(pageInfo, cardInfo, aWbsId, aWbsNodeId);		
	},
	
    openWBSDetailActionFormPanel : function(aWbsId_OR_aWbsDTOAdapter)
	{		 		 		 	    
		org.r3.PageManager.pushBreadCrumb({
			"title" : org.r3.wbs.towfillout.message.wbs_detail_breadcrumb,
			"actionForm" : this.wbsDetail
		});	   	
		
		this.wbsDetail.open(aWbsId_OR_aWbsDTOAdapter);
	},

	openWBSNodeDetailActionFormPanel : function(aWbsId, aWbsNodeId)
	{
		org.r3.PageManager.pushBreadCrumb({
			"title" : org.r3.wbs.towfillout.message.wbs_node_detail_breadcrumb,
			"actionForm" : this.wbsNodeDetail
		});	  
		
		this.wbsNodeDetail.open(aWbsId, aWbsNodeId);
	}			
};


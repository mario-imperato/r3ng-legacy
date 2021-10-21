$.r3Utils.namespace("org.r3.wbs.wbsfillout");

org.r3.wbs.wbsfillout.PageManager = 
{
	init : function(pageInfo, cardInfo)
	{
		org.r3.PageManager.googleAnalyticsSendPageView();
				
		this.navigator = new org.r3.wbs.wbsfillout.NavigatorActionForm(this, "#navigatorActionForm");	
		this.wbsDetail = new org.r3.wbs.wbsfillout.WBSDetailActionForm(this, "#wbsDetailActionForm");
		this.wbsNodeDetail = new org.r3.wbs.wbsfillout.WBSNodeDetailActionForm(this, "#wbsNodeDetailActionForm", "#wbsNodeDiscussionActionForm");
		
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
			"title" : org.r3.wbs.wbsfillout.message.wbs_detail_breadcrumb,
			"actionForm" : this.wbsDetail
		});	   	
		
		this.wbsDetail.open(aWbsId_OR_aWbsDTOAdapter);
	},

	openWBSNodeDetailActionFormPanel : function(aWbsId, aWbsNodeId)
	{
		org.r3.PageManager.pushBreadCrumb({
			"title" : org.r3.wbs.wbsfillout.message.wbs_node_detail_breadcrumb,
			"actionForm" : this.wbsNodeDetail
		});	  
		
		this.wbsNodeDetail.open(aWbsId, aWbsNodeId);
	}			
};


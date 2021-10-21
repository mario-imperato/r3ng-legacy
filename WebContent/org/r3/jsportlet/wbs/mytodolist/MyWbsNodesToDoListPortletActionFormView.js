$.r3Utils.namespace("org.r3.jsportlet.wbs.mytodolist");

org.r3.jsportlet.wbs.mytodolist.MyWbsNodesToDoListPortletActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},
	
	open : function()
	{
		var _self = this;
		
		// console.info('SiteConstants:', org.r3.SiteConstants);
		
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/wbs/mytodolist/MyWbsNodesToDoListPortletActionFormView.html.jsp'),
			dataType : "html"
		});
		
		networkRequestsQueue.push(
		{
			id : "wbs_nodes",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl("GET_ActorWbsNodes", [ org.r3.PageManager.getSiteActorId() ] ),
			dataType : "json"
		});					
				
		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_completion'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	
		
			var wbsesDataTableAdapter = null;
			wbsesDataTableAdapter = responseData['wbs_nodes'];
		    if (wbsesDataTableAdapter)
            {
		    	wbsesDataTableAdapter = new org.r3.db.DTOTableAdapter(wbsesDataTableAdapter, 
					function(aRowDataBean) { return new org.r3.db.wbs.wbsnode.WBSNodeDTOAdapter(aRowDataBean); });				
            }				
			
 		    var templatedHtml = tmpl(responseData['view'], { 
 		    	 "userid": org.r3.PageManager.userInfo.dataBean.userid, 
 		    	 "wbses": wbsesDataTableAdapter,
 		    	 "dictionary": org.r3.jsportlet.wbs.mytodolist.message
 		    });
 		    
 		    $(this.htmlContainerId).html(templatedHtml);
 		    
 		    $(this.htmlContainerId + ' div.wbsnode').unbind().click(function(e) {
 		    
 		    	var currentTarget = $(e.currentTarget);
 		    	var wbsnodeid = currentTarget.attr('id');

 		    	_self.onGotoWBSPage(currentTarget.attr('data-wbsid'), wbsnodeid);
 		    		
 		    	// $('#wbs_portlet_outline_' + wbsid).toggleClass('wbs_collapsed');
 		    });
 		    
		    $('#mywbsesportlet_goto_page').unbind().click($.r3Utils.hitch(this, function(e) { this.onGotoWBSPage(); }));	
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
		
	},
	
	onGotoWBSPage: function(aWbsId, aWbsNodeId)
	{
		var targetUrl = org.r3.Constants.getStrutsActionContext() + "/org/r3/wbs/wbsfillout.do?pageid=wbses";
		if (aWbsId)
			targetUrl += "&wbsid=" + aWbsId;
		
		if (aWbsNodeId)
			targetUrl += "&wbsnodeid=" + aWbsNodeId;
		
		org.r3.PageManager.gotoPage(targetUrl);
	}
	
		
});

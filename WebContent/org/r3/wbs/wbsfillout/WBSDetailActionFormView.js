$.r3Utils.namespace("org.r3.wbs.wbsfillout");


org.r3.wbs.wbsfillout.WBSDetailActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},

	open : function(aWbsId_OR_aWbsDTOAdapter)
	{
		var _self = this;
		
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];		

		var theWbsId = null;
		if (_.isString(aWbsId_OR_aWbsDTOAdapter))
		{
			theWbsId = aWbsId_OR_aWbsDTOAdapter;
			
			networkRequestsQueue.push(
			{
				id : "wbsdetail",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl("GET_WBSTree", [ aWbsId_OR_aWbsDTOAdapter ]),
				dataType : "json"
			});			
		}
		else theWbsId = aWbsId_OR_aWbsDTOAdapter.dataBean.wbsid;
		
		// WBS DTO Proviene da un DataTable e non contiene gli attori (manager, sponsor e coach..
//		networkRequestsQueue.push(
//		{
//			id : "wbsactors",
//			type : "Get",
//			url : org.r3.PageManager.getRESTUrl("GET_WBSActors", [ theWbsId ]),
//			dataType : "json"
//		});				

		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/wbs/wbsfillout/WBSDetailActionFormView.html.jsp'),
			dataType : "html"
		});
				
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			var wbsDTOAdapter = aWbsId_OR_aWbsDTOAdapter;
			if (_.isString(aWbsId_OR_aWbsDTOAdapter))
			{
				wbsDTOAdapter = new org.r3.db.wbs.wbs.WBSDTOAdapter(responseData["wbsdetail"]);				
			}
			
//			if (wbsDTOAdapter)
//			{
//			var wbsActors = responseData['wbsactors'];
//			if (wbsActors)
//				wbsActors = new org.r3.db.DTOTableAdapter(wbsActors, 
//						function(aRowDataBean) { return new org.r3.db.wbs.wbsactor.WBSActorDTOAdapter(aRowDataBean); });		
//					
//			wbsDTOAdapter.setWbsActors(wbsActors);
//			}
			
			 var templatedHtml = tmpl(responseData['view'], { 
 		    	 "wbs": wbsDTOAdapter
 		    });
 		    
 		    $(this.htmlContainerId).html(templatedHtml); 		    			
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	}

});

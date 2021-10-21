$.r3Utils.namespace("org.r3.wbs.wbsfillout");

org.r3.wbs.wbsfillout.WBSNodeDetailActionForm = org.r3.ActionFormManager.extend(
{
	init : function(aPageManager, aDetailViewContainerId, aDiscussionViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.wbs.wbsfillout.WBSNodeDetailActionFormView(aDetailViewContainerId, this);
		
		this.bbsThreadPortletView = new org.r3.jsportlet.bbs.BBSThreadPortletView(aDiscussionViewContainerId, this);
		this.bbsThreadPortletView_isOpen = false;
	},

	close : function()
	{
		this.detailView.close();
		this.bbsThreadPortletView.close(); 
	},

	hide : function()
	{
		this.detailView.hide();
		this.bbsThreadPortletView.close();
	},

	show : function()
	{
		this.detailView.show();
		// Tecnicamente dovrei introdurre il concetto di sapere se l'ho aperto o meno..
		if (this.bbsThreadPortletView_isOpen)
		     this.bbsThreadPortletView.show();
	},

	open : function(aWbsId, aWbsNodeId)
	{
		this.bbsThreadPortletView_isOpen = false;
		this.detailView.open(aWbsId, aWbsNodeId);			
	},

	openBBSThreadPortlet: function(aBBSTopicId, aBBSThreadId)
	{
		this.bbsThreadPortletView.open(aBBSTopicId, aBBSThreadId);
		this.bbsThreadPortletView_isOpen = true;
	},
	
	updateWBSNode: function(theForm, aWbsId, aWbsNodeId, onSuccessResponse, onErrorResponse)
	{
		this._saveWBSNode(theForm, aWbsId, aWbsNodeId, onSuccessResponse, onErrorResponse);
	},
	
	_saveWBSNode : function(theForm, aWbsId, aWbsNodeId, onSuccessResponse, onErrorResponse)
	{
		var _self = this;
				
		var restUrl = org.r3.PageManager.getRESTUrl('FILL_PUT_WBSNode', [ aWbsId, aWbsNodeId ]);
		var method = "put";
		
		org.r3.PageManager.wait("org.r3.message.waiting");
		theForm.ajaxSubmit(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"success" : function(responseData)
			{
				org.r3.PageManager.closeNotifier();
				if (onSuccessResponse)
					onSuccessResponse(responseData);
				
		    	var dtoAdapter = new org.r3.db.wbs.wbsnode.WBSNodeDTOAdapter(responseData);		    										
			},
			
			"error": function(jqXHR, timeout, message)
			{
				console.log(arguments);
				org.r3.PageManager.closeNotifier();
				if (onErrorResponse)
					onErrorResponse(jqXHR, timeout, message);
			}
		});
	}
			
});


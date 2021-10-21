$.r3Utils.namespace("org.r3.console.bbs");

org.r3.console.bbs.BBSThreadNodeDetailActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aChildEntityListViewContainerId, aDeleteGroupDialogConfirmationActionFormContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.console.bbs.BBSThreadNodeDetailActionFormView(aDetailViewContainerId, this);		
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

	refresh: function()
	{
	   this.listView.refresh();	
	},
	
	open : function(aTopicId, aThreadId, aParentThreadNodeId, aThreadNodeDTOAdapter)
	{
		this.setDataBeanInfo(aThreadNodeDTOAdapter);
		this.topicId = aTopicId;
		this.threadId = aThreadId;
		this.parentThreadId = aParentThreadNodeId;
		
		this.detailView.open(aTopicId, aThreadId, aParentThreadNodeId, aThreadNodeDTOAdapter);				
	},

	updateItem : function(onSuccessResponse, onFailResponse)
	{
		this._saveItem(true, onSuccessResponse, onFailResponse);
	},

	createItem : function(onSuccessResponse, onFailResponse)
	{
		this._saveItem(false, onSuccessResponse, onFailResponse);
	},

	_saveItem : function(isUpdate, onSuccessResponse, onErrorResponse)
	{
		var _self = this;
		
		var theForm = $('#threadnodedetailactionform_form');
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{
			var topicId = this.topicId;
			var threadId = this.threadId;

			var method = null;
			var restUrl = null;
			if (isUpdate)
			{
				var threadNodeId = this.dataBeanInfo.dataBean.threadnodeid;
				restUrl = org.r3.PageManager.getRESTUrl('PUT_BBSThreadNode', [ topicId, threadId, threadNodeId ]);
				method = "put";
			}
			else
			{
				restUrl = org.r3.PageManager.getRESTUrl('POST_BBSThreadNode', [ topicId, threadId ]);
				method = "post";
			}
			
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
					
					var threadNodeDataBean = new org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewDTOAdapter(responseData);
					org.r3.PageManager.back();
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
	},
		
	onDeleteThreadNode: function()
    {    
		if (!org.r3.PageManager.confirmation("org.r3.message.deleteconfirm"))
		{
			return;
		}
		
    	var _self = this;
		
		var method = "DELETE";
		var aTopicId = this.topicId;
		var aThreadId = this.dataBeanInfo.dataBean.threadid;
		var aPostId = this.dataBeanInfo.dataBean.threadnodeid;
		var restUrl = org.r3.PageManager.getRESTUrl('DELETE_BBSThreadNode', [ aTopicId, aThreadId, aPostId ]);

		org.r3.PageManager.wait("org.r3.message.waiting");
		$.ajax(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"success" : function()
			{
				org.r3.PageManager.closeNotifier();
				org.r3.PageManager.back();
			},
			"error" : function(jqXHR, timeout, message)
			{
				console.error("Errore Deleting Actor Group: ", message);
			}
		});		
    }
	
	
});


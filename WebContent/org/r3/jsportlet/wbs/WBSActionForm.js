$.r3Utils.namespace("org.r3.jsportlet.wbs");

org.r3.jsportlet.wbs.WBSActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aChildViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.wbs.WBSActionFormView(aDetailViewContainerId, this);
	},

	close : function()
	{
		this.detailView.close();
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

	open : function(aWBSDtoAdapter)
	{
	   this.setDataBeanInfo(aWBSDtoAdapter);
	   
       var _self = this;     
       this.detailView.open(aWBSDtoAdapter);		       
	},	

	createWBS : function(onSuccessResponse, onFailResponse)
	{
		this._saveWBS(false, onSuccessResponse, onFailResponse);
	},

	updateWBS : function(onSuccessResponse, onFailResponse)
	{
		this._saveWBS(true, onSuccessResponse, onFailResponse);
	},

	_saveWBS : function(isUpdate, onSuccessResponse, onErrorResponse)
	{
		var _self = this;
		
		var theForm = $('#wbsactionform_form');
		var method = "post";
		var restUrl = org.r3.PageManager.getRESTUrl('POST_WBS');
		if (isUpdate)
		{
			var idWBS = this.dataBeanInfo.dataBean.wbsid;
			restUrl = org.r3.PageManager.getRESTUrl('PUT_WBS', [ idWBS ]);
			method = "put";
		}
		
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{
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
					
					if (!isUpdate)
					   _self.pageManager.closeWBSPanel();
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
	
	createWBSNode : function(anActionContext, onSuccessResponse, onFailResponse)
	{
		this._saveWBSNode(false, anActionContext, onSuccessResponse, onFailResponse);
	},

	updateWBSNode : function(anActionContext, onSuccessResponse, onFailResponse)
	{
		this._saveWBSNode(true, anActionContext, onSuccessResponse, onFailResponse);
	},

	_saveWBSNode : function(isUpdate, anActionContext, onSuccessResponse, onErrorResponse)
	{
		var _self = this;
		
		var wbsid = this.dataBeanInfo.dataBean.wbsid;
		var theForm = $('#wbsnodeactionform_form');
		var method = "post";
		var restUrl = org.r3.PageManager.getRESTUrl('POST_WBSNode', [ wbsid, anActionContext.parentNodeId ] );
		if (isUpdate)
		{			
			restUrl = org.r3.PageManager.getRESTUrl('PUT_WBSNode', [ wbsid, anActionContext.nodeId ]);
			method = "put";
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
				
				// Il metodo mi può tornare una condizione di validazione applicativa che deve risultare bloccante rispetto all'aggiornamento del Miller.
				var isApplicationError = false;
				if (onSuccessResponse)
					isApplicationError = onSuccessResponse(responseData);
				
				if (!isApplicationError)
				{
		    	var dtoAdapter = new org.r3.db.wbs.wbsnode.WBSNodeDTOAdapter(responseData);
		    	
				if (!isUpdate)
				{
				    _self.detailView.addNodeToMiller(anActionContext, dtoAdapter);	
				}
				else
				    _self.detailView.refreshMillerView(anActionContext, dtoAdapter);						
				
				}
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


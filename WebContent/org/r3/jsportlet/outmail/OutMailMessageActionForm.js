$.r3Utils.namespace("org.r3.jsportlet.outmail");

org.r3.jsportlet.outmail.OutMailMessageActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, anUploadAttachmentContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.outmail.OutMailMessageActionFormView(aDetailViewContainerId, this);
		this.attachmentView = new org.r3.jsportlet.outmail.UploadFileActionFormView(anUploadAttachmentContainerId, this);
	},

	close : function()
	{
		// M20140201 - org.r3.PageManager.popBreadCrumb();
		this.hide();
	},

	hide : function()
	{
		this.detailView.hide();
		this.attachmentView.hide();
	},

	show : function()
	{
		this.detailView.show();
		this.attachmentView.show();
	},

	open: function()
	{
		org.r3.PageManager.wait("org.r3.message.waiting");
		 
		var _self = this;
		$.ajax(
		{
			"type" : "post",
			"url" : org.r3.PageManager.getRESTUrl('POST_OUTMAIL_CreateAttachmentGroup'),
			"dataType" : "json",
			"success" : function(responseData)
			{
				org.r3.PageManager.closeNotifier();
				if (org.r3.PageManager.isRestDTO(responseData))
				{
					var restDto = new org.r3.RestDTOAdapter(responseData);
					_self.detailView.open(restDto.correlationid);	
					_self.attachmentView.open(restDto.correlationid);
				}
				else 
				{
					console.error("POST_OUTMAIL_CreateAttachmentGroup...AttachmentGroupCreationError");
				}				
			},

			"error" : function(jqXHR, timeout, message)
			{
				console.error("...> error");
				org.r3.PageManager.closeNotifier();
			}
		});	 
	},

	createItem : function(onSuccessResponse, onFailResponse)
	{
		this._saveItem(onSuccessResponse, onFailResponse);
	},
	 
	_saveItem : function(onSuccessResponse, onErrorResponse)
	{
		var _self = this;
		
		var theForm = $('#outmailmessageactionform_form');
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{
			var method = "post";
			var restUrl = org.r3.PageManager.getRESTUrl('POST_OUTMAIL');			

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
					
					_self.pageManager.closeNewBulkMailPanel();
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
	
	listaContatti : function()
	{
		org.r3.PageManager.back();
	}
		

});


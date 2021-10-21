$.r3Utils.namespace("org.r3.console.contacts");

org.r3.console.contacts.SMSDetailActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aChildEntityListViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.console.contacts.SMSDetailActionFormView(aDetailViewContainerId, this);
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

	open : function(aDataBeanInfo)
	{
		this.setDataBeanInfo(aDataBeanInfo);
		this.detailView.open(aDataBeanInfo);			
	},

	createItem : function(onSuccessResponse, onFailResponse)
	{
		this._saveItem(onSuccessResponse, onFailResponse);
	},

	_saveItem : function(onSuccessResponse, onErrorResponse)
	{
		var _self = this;
		
		var theForm = $('#smsdetailactionform_form');
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{
			var method = "post";
			var restUrl = org.r3.PageManager.getRESTUrl('POST_SMS');			

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
					
					_self.pageManager.closeNewSMSPanel();
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

	checkSMSCredits: function(onSuccessResponse, onErrorResponse)
	{
		var _self = this;
		
		var method = "post";
		var restUrl = org.r3.PageManager.getRESTUrl('POST_GETSMSCredits');			
		var theForm = $('#smsdetailactionform_form');
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
			},
			
			"error": function(jqXHR, timeout, message)
			{
				console.log(arguments);
				org.r3.PageManager.closeNotifier();
				if (onErrorResponse)
					onErrorResponse(jqXHR, timeout, message);
			}
		});
	},
	
	listaContatti : function()
	{
		org.r3.PageManager.back();
	}
		

});


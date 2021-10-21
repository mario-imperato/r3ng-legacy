$.r3Utils.namespace("org.r3.jsportlet.fileupload");

org.r3.jsportlet.fileupload.FileImportDetailActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, uploadOptions)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.fileupload.FileImportDetailActionFormView(aDetailViewContainerId, this, uploadOptions);
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

	refresh : function()
	{
	},

	open : function(aFileImportDTOAdapter)
	{
		this.setDataBeanInfo(aFileImportDTOAdapter);
		this.detailView.open(aFileImportDTOAdapter);
	},
	
	closeFileUpload: function(onCloseActionForm)
	{
		var _self = this;

		onCloseActionForm();
	},
		
	deleteFileImport: function(aMethod, dictionaryUrl, onSuccess, onError)
	{
		var _self = this;
		
		org.r3.PageManager.wait("org.r3.message.waiting");

		var method = aMethod;
		var restUrl = org.r3.PageManager.getRESTUrl(dictionaryUrl, [ this.dataBeanInfo.dataBean.importid ] );
		$.ajax(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"success" : function(responseData)
			{
				org.r3.PageManager.closeNotifier();
				if (onSuccess)
					onSuccess(responseData);
				
				org.r3.PageManager.back();
			},
			"error" : function(jqXHR, timeout, message)
			{
				console.log(arguments);
				org.r3.PageManager.closeNotifier();
				if (onError)
				   onError(jqXHR, timeout, message);
			}
		});
	},
	
	processFileImport: function(theForm, dictionaryUrl, onSuccess, onError)
	{
		var _self = this;
		
		org.r3.PageManager.wait("org.r3.message.waiting");

		var method = 'put';
		var restUrl = org.r3.PageManager.getRESTUrl(dictionaryUrl, [ this.dataBeanInfo.dataBean.importid ] );
		theForm.ajaxSubmit(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"success" : function(responseData)
			{
				org.r3.PageManager.closeNotifier();
				if (onSuccess)
					onSuccess(responseData);
				
				org.r3.PageManager.back();
			},
			
			"error" : function(jqXHR, timeout, message)
			{
				org.r3.PageManager.closeNotifier();
				if (onError)
				   onError(jqXHR, timeout, message);
			}			
		});

	}
			
});


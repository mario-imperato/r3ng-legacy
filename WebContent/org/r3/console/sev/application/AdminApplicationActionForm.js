$.r3Utils.namespace("org.r3.console.sev.application");

org.r3.console.sev.application.AdminApplicationActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, anActionFormContainerId, adminActionFormViewId, aSidePortletContainerId)
	{
		this.setPageManager(aPageManager);
		
		this.actionFormContainer = $(anActionFormContainerId);
		this.randomPhotoSideBarActionForm = new org.r3.jsportlet.rndphotosidebar.RandomPhotoSideBarActionForm (this, aSidePortletContainerId);		 		
		this.adminActionFormView = new org.r3.console.sev.application.AdminApplicationActionFormView(adminActionFormViewId, this);
				
		this.applicationDTOAdapter = null;
	},

	close : function()
	{
		// M20140201 - org.r3.PageManager.popBreadCrumb();
		this.randomPhotoSideBarActionForm.close();
		this.adminActionFormView.close();
		
		this.hide();
	},

	hide : function()
	{		
		this.actionFormContainer.hide();
	},

	show : function()
	{
		this.actionFormContainer.show();
	},

	refresh : function()
	{
		this.adminActionFormView.refresh();
	},

	open : function(anApplicationId)
	{
		this.dataBeanInfo = { "applicationid": anApplicationId };
		
		this.randomPhotoSideBarActionForm.open();
		this.adminActionFormView.open(anApplicationId);
		this.actionFormContainer.show();
	},
	
	viewApplication: function()
	{
		this.pageManager.viewApplication(this.dataBeanInfo.applicationid);
	},
	
	editApplication: function()
	{
		this.hide();
		this.pageManager.openApplicationPortlet(this.applicationDTOAdapter);
	},
	
	deleteApplication: function(aMethod, dictionaryUrl, onSuccess, onError)
	{
		var _self = this;
		
		org.r3.PageManager.wait("org.r3.message.waiting");

		var method = aMethod;
		var restUrl = org.r3.PageManager.getRESTUrl(dictionaryUrl, [ this.dataBeanInfo.applicationid ] );
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
	
	doProcessApplicationInput: function(aMethod, dictionaryUrl, theForm, onSuccess, onError)
	{
		var _self = this;
		
		if (theForm.valid())
		{
			org.r3.PageManager.wait("org.r3.message.waiting");

			var method = aMethod;
			var restUrl = org.r3.PageManager.getRESTUrl(dictionaryUrl, [ this.dataBeanInfo.applicationid ] );
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
				},
				"error" : function(jqXHR, timeout, message)
				{
					console.log(arguments);
					org.r3.PageManager.closeNotifier();
					if (onError)
					   onError(jqXHR, timeout, message);
				}
			});
		}				
	}
		
});


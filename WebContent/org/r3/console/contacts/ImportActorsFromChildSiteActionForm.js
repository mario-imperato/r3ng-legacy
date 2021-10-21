$.r3Utils.namespace("org.r3.console.contacts");

org.r3.console.contacts.ImportActorsFromChildSiteActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aChildEntityListViewContainerId, aDeleteGroupDialogConfirmationActionFormContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.console.contacts.ImportActorsFromChildSiteActionFormView(aDetailViewContainerId, this);		
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
	},
	
	open : function()
	{
		this.detailView.open();				
	},

	doImport : function(onSuccessResponse, onFailResponse)
	{
		var _self = this;
		
		var theForm = $('#importactorgroupfromchildsiteactionform_form');
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{
			var method = "post";
			var restUrl = org.r3.PageManager.getRESTUrl('POST_ImportActorsFromChildSite');

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
					
					_self.close();
					 _self.pageManager.openActorQueryActionFormPanel();						
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
	}	
	
});


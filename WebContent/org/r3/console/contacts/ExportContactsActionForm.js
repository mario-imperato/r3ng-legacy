$.r3Utils.namespace("org.r3.console.contacts");

org.r3.console.contacts.ExportContactsActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aChildEntityListViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.console.contacts.ExportContactsActionFormView(aDetailViewContainerId, this);
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

	exportItem : function(onSuccessResponse, onErrorResponse)
	{
		var _self = this;
		
		var theForm = $('#exportcontactsactionform_form');
		if (theForm.valid())
		{
			var queryParams = theForm.serialize();

			var restUrl = org.r3.PageManager.getRESTUrl('GET_ActorsAsCSV');	
			restUrl = $.r3Utils.addQueryStringToUrl(restUrl, queryParams);
			window.location.href = restUrl;			
			
//			$.ajax(
//			{
//				"type" : "GET",
//				"url" : restUrl,
//				"accept" : "text/csv",
//				"success" : function()
//				{
//					
//				},
//				"error" : function(jqXHR, timeout, message)
//				{
//					console.error("Errore Deleting Actor Group: ", message);
//				}
//			});		
			
		}
	}		

});


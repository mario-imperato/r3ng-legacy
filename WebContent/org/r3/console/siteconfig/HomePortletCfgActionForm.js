$.r3Utils.namespace("org.r3.console.siteconfig");

org.r3.console.siteconfig.HomePortletCfgActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aChildEntityListViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.console.siteconfig.HomePortletCfgActionFormView(aDetailViewContainerId, this);
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

	saveForm : function(onSuccessResponse, onErrorResponse)
	{
		var _self = this;
		
		var theForm = $('#homeportletcfgactionform_form');
		var positionId = $('#homeportletcfgactionform_positionid').val();
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{
			var method = "put";
			var restUrl = org.r3.PageManager.getRESTUrl('PUT_Site_PortletConfig', [ 'home', positionId ] );

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
		}
	},
	
	openCardPicker: function(srcPickerWidget)
	{
        console.info("Opening The Picker", srcPickerWidget);
        this.hide();
        this.pageManager.openCardPicker(srcPickerWidget);		
	}
	
		

});


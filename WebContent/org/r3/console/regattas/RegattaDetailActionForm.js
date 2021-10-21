$.r3Utils.namespace("org.r3.console.regattas");

org.r3.console.regattas.RegattaDetailActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aChildEntityListViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.console.regattas.RegattaDetailActionFormView(aDetailViewContainerId, this);
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

	updateItem : function(onSuccessResponse, onFailResponse, onRestDTOResponse)
	{
		this._saveItem(true, onSuccessResponse, onFailResponse, onRestDTOResponse);
	},

	createItem : function(onSuccessResponse, onFailResponse, onRestDTOResponse)
	{
		this._saveItem(false, onSuccessResponse, onFailResponse, onRestDTOResponse);
	},

	_saveItem : function(isUpdate, onSuccessResponse, onErrorResponse, onRestDTOResponse)
	{
		var _self = this;
		
		var theForm = $('#regattadetailactionform_form');
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{
			var method = "post";
			var restUrl = org.r3.PageManager.getRESTUrl('POST_Site');
			if (isUpdate)
			{
				var regattaId = this.dataBeanInfo.dataBean.site;
				restUrl = org.r3.PageManager.getRESTUrl('PUT_Site', [ regattaId ]);
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
					
					if (org.r3.PageManager.isRestDTO(responseData) && onRestDTOResponse)
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						onRestDTOResponse(restDto);
					}
					else 
					{
						if (onSuccessResponse)
						     onSuccessResponse(responseData);	
					
						if (method == 'put')
						     _self.listaRegate();
						else _self.pageManager.closeNewSitePanel();
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
	},

	deleteItem : function(onSuccessResponse, onErrorResponse)
	{
		var _self = this;
		
		if (org.r3.PageManager.confirmation("org.r3.message.deleteconfirm"))
		{
			var method = "DELETE";
			var restUrl = null;
			var regattaId = this.dataBeanInfo.dataBean.site;
			restUrl = org.r3.PageManager.getRESTUrl('DELETE_Site', [ regattaId ]);

			org.r3.PageManager.wait("org.r3.message.waiting");
			$.ajax(
			{
				"type" : method,
				"url" : restUrl,
				"dataType" : "json",
				"success" : function(responseData)
				{
					org.r3.PageManager.closeNotifier();
					if (onSuccessResponse)
						onSuccessResponse(responseData);	

					_self.pageManager.closeNewSitePanel();
				},
				"error" : function(jqXHR, timeout, message)
				{
					org.r3.PageManager.closeNotifier();

					if (onErrorResponse)
						onErrorResponse(jqXHR, timeout, message);
				}
			});
		}
	},

	listaRegate : function()
	{
		org.r3.PageManager.back();
	}
		

});


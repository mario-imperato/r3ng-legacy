$.r3Utils.namespace("org.r3.console.siteconfig.site");

org.r3.console.siteconfig.site.SiteDetailActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aChildEntityListViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.console.siteconfig.site.SiteDetailActionFormView(aDetailViewContainerId, this);
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
		this.detailView.refresh();
	},
	
	open : function()
	{
		this.detailView.open();			
	},

	updateItem : function(onSuccessResponse, onErrorResponse, onRestDTOResponse)
	{
		var _self = this;
		var currentSite = org.r3.Constants.site;
		
		var theForm = $('#sitedetailactionform_form');
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{

			var restUrl = org.r3.PageManager.getRESTUrl('PUT_Site', [ currentSite ]);
			var method = "put";

			org.r3.PageManager.wait("org.r3.message.waiting");
			theForm.ajaxSubmit(
			{
				"type" : method,
				"url" : restUrl,
				"dataType" : "json",
				"success" : function(responseData)
				{
					org.r3.PageManager.closeNotifier();
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						if (onRestDTOResponse) onRestDTOResponse(restDto);
					}
					else 
					{
						if (onSuccessResponse)
						{
							onSuccessResponse(responseData);							
						}
					}					
				},
				
				"error" : function(jqXHR, timeout, message)
				{
					org.r3.PageManager.closeNotifier();
					if (onErrorResponse)  onErrorResponse(jqXHR, timeout, message);
				}
				
			});
		}
	},
	
	uploadFile: function(aCardId)
	{
	    this.hide();
	    this.pageManager.uploadSiteAssetFile(aCardId);
	},
	
	updateFileProperty: function(aCardId, aPropertyid, onSuccess)
	{
		var theForm = $('#sitefileactionform_form');
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{
			var method = "put";			
			var restUrl = org.r3.PageManager.getRESTUrl('PUT_CardProperty_File',  [ aCardId, aPropertyid ]);

			org.r3.PageManager.wait("org.r3.message.waiting");
			theForm.ajaxSubmit(
			{
				"type" : method,
				"url" : restUrl,
				"dataType" : "json",
				"success" : function(responseData)
				{
					org.r3.PageManager.closeNotifier();
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('sitefileactionform_fieldset_message');
					}
					else 
					{
						$('#sitefileactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });
                        if (onSuccess)
                        	onSuccess();
					}					
				},
				
				"error" : function(jqXHR, timeout, message)
				{
					org.r3.PageManager.closeNotifier();
					$('#sitefileactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
				}
				
			});
		}		
	},
	
//
//	submitProperty: function(formId, restUrl, method, onSuccess, onError)
//	{
//		var _self = this;
//		var theForm = $(formId);
//		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
//		{
//			org.r3.PageManager.wait("org.r3.message.waiting");
//			theForm.ajaxSubmit(
//			{
//				"type" : method,
//				"url" : restUrl,
//				"dataType" : "json",
//				"success" : function(responseData)
//				{
//					org.r3.PageManager.closeNotifier();
//					_self.detailView.refresh();
//					if (onSuccess)
//						onSuccess(responseData);					
//				},
//				
//				"error" : function(jqXHR, timeout, message)
//				{
//					org.r3.PageManager.closeNotifier();
//					if (onError)
//						onError(message);
//				}
//				
//			});
//		}		
//	},
//
	deleteProperty: function(aCardPropertyDTOAdapter)
	{
		var _self = this;

		var method = "DELETE";
		var restUrl = null;
		var site = aCardPropertyDTOAdapter.dataBean.site;
		var cardId = aCardPropertyDTOAdapter.dataBean.cardid;
		var propertyId = aCardPropertyDTOAdapter.dataBean.propertyid;
		restUrl = org.r3.PageManager.getRESTUrl('DELETE_CardProperty', [ cardId, propertyId ]);

		org.r3.PageManager.wait("org.r3.message.waiting");
		$.ajax(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"success" : function()
			{
				org.r3.PageManager.closeNotifier();
				_self.detailView.refresh();
			},
			"error" : function(jqXHR, timeout, message)
			{
				console.error("GruppoDetailActionForm: ", message);
			}
		});
	}

});


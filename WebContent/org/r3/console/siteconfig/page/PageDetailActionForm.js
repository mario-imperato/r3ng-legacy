$.r3Utils.namespace("org.r3.console.siteconfig.page");

org.r3.console.siteconfig.page.PageDetailActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aChildEntityListViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.console.siteconfig.page.PageDetailActionFormView(aDetailViewContainerId, this);
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
	
	open : function(aPageDTOAdapter)
	{
		console.log("PageDetailActionForm::open", aPageDTOAdapter);
		this.setDataBeanInfo(aPageDTOAdapter);
		this.detailView.open(aPageDTOAdapter);			
	},

	updateItem : function()
	{
		this._saveItem(true);
	},

	createItem : function()
	{
		this._saveItem(false);
	},

	_saveItem : function(isUpdate)
	{
		var _self = this;
		
		var theForm = $('#pagedetailactionform_form');
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{
			var method = "post";
			var restUrl = org.r3.PageManager.getRESTUrl('POST_Page');
			if (isUpdate)
			{
				var pageId = this.dataBeanInfo.dataBean.pageid;
				restUrl = org.r3.PageManager.getRESTUrl('PUT_Page', [ pageId ]);
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
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('pagedetailactionform_fieldset_message');
					}
					else 
					{
						if (isUpdate)
						{
							$('#pagedetailactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });							
						}
						else
							_self.closeNewPagePanel();
					}					
				},
				
				"error" : function(jqXHR, timeout, message)
				{
					org.r3.PageManager.closeNotifier();
					$('#pagedetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
				}
				
			});
		}
	},

	deleteItem : function()
	{
		var _self = this;
		
		if (org.r3.PageManager.confirmation("org.r3.message.deleteconfirm"))
		{
			var method = "DELETE";
			var restUrl = null;
			var pageid = this.dataBeanInfo.dataBean.pageid;
			restUrl = org.r3.PageManager.getRESTUrl('DELETE_Page', [ pageid ]);

			org.r3.PageManager.wait("org.r3.message.waiting");
			$.ajax(
			{
				"type" : method,
				"url" : restUrl,
				"dataType" : "json",
				"success" : function()
				{
					org.r3.PageManager.closeNotifier();
					org.r3.PageManager.back();
				},
				"error" : function(jqXHR, timeout, message)
				{
					// console.error("CardQueryActionForm: ", message);
					$('#pagedetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
				}
			});
		}
	},
	
	closeNewPagePanel: function()
	{
		this.pageManager.closeNewPagePanel();
	},
	
	listaPages : function()
	{
		org.r3.PageManager.back();
	},
		
	updatePageDescr4Language: function(aLanguageCode)
	{
		var theForm = $('#pagetextactionform_form');
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{
			var method = "put";
			var pageid = this.dataBeanInfo.dataBean.pageid;
			var restUrl = org.r3.PageManager.getRESTUrl('PUT_PageDescr_Detail',  [ pageid, aLanguageCode ]);

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
						restDto.showMessage('pagetextactionform_fieldset_message');
					}
					else 
					{
						$('#pagetextactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });							
					}					
				},
				
				"error" : function(jqXHR, timeout, message)
				{
					org.r3.PageManager.closeNotifier();
					$('#pagetextactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
				}
				
			});
		}		
	},
	
	retrievePageDescr: function(aLanguageCode, onComplete, onError)
	{
		var method = "GET";
		var restUrl = null;
		restUrl = org.r3.PageManager.getRESTUrl('GET_PageDescr_Detail', [ this.dataBeanInfo.dataBean.pageid, aLanguageCode ]),

		org.r3.PageManager.wait("org.r3.message.waiting");
		$.ajax(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"success" : function(responseData)
			{
				org.r3.PageManager.closeNotifier();
				
				var pageDescrDataBean =  null;
				if (responseData)
				{
					pageDescrDataBean = new org.r3.db.cms.pagedescr.PageDescrDTOAdapter(responseData);		
				}
				
				if (onComplete)
					onComplete(pageDescrDataBean);	
			},
			
			"error" : function(jqXHR, timeout, message)
			{
				console.error("org.r3.console.cms.cards.CardDetailActionForm: ", message);
				if (onError)
					onError(message);	
			}
		});

	}

});


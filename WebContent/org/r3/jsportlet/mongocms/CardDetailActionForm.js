$.r3Utils.namespace("org.r3.jsportlet.mongocms");

org.r3.jsportlet.mongocms.CardDetailActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aChildEntityListViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.mongocms.CardDetailActionFormView(aDetailViewContainerId, this);
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
	
	open : function(aCardDTOAdapter)
	{
		console.log("CardDetailActionForm::open", aCardDTOAdapter);
		this.setDataBeanInfo(aCardDTOAdapter);
		this.detailView.open(aCardDTOAdapter);			
	},

	_getContentClassDefinition: function(aCardDataBean)
	{
		var contentClass = aCardDataBean ? aCardDataBean.dataBean.contentclass : this.dataBeanInfo.dataBean.contentclass;
		var contentClassLUTResolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_contentclassdef');
		var lutItem = org.r3.PageManager.lutManager.getLUTItem(contentClassLUTResolvedUrl, contentClass);
		
		if (lutItem != null)
			lutItem = new org.r3.db.mongo.contentdefinitioncollection.ContentDefinitionDTOAdapter(lutItem);
		
		return lutItem;
	},

	_getPhotoGraphicContentDefinition: function(aCardDataBean)
	{
		var contentClassDef = this._getContentClassDefinition(aCardDataBean);
		
		var graphicContentDefinitionLUTResolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_graphcontentdef');
		var lutItem = org.r3.PageManager.lutManager.getLUTItem(graphicContentDefinitionLUTResolvedUrl, contentClassDef.dataBean.photographictype);
		return lutItem;
	},

//	updateItem : function()
//	{
//		this._saveItem(true);
//	},
//
//	createItem : function()
//	{
//		this._saveItem(false);
//	},
//
//	_saveItem : function(isUpdate)
//	{
//		var _self = this;
//		
//		var theForm = $('#carddetailactionform_form');
//		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
//		{
//			var method = "post";
//			var restUrl = org.r3.PageManager.getRESTUrl('POST_Card');
//			if (isUpdate)
//			{
//				var idCard = this.dataBeanInfo.dataBean.postid;
//				restUrl = org.r3.PageManager.getRESTUrl('PUT_PostGeneralInfo_Detail', [ this.dataBeanInfo.dataBean.site, org.r3.Constants.language, idCard ]);
//				method = "put";
//			}
//
//			org.r3.PageManager.wait("org.r3.message.waiting");
//			theForm.ajaxSubmit(
//			{
//				"type" : method,
//				"url" : restUrl,
//				"dataType" : "json",
//				"success" : function(responseData)
//				{
//					org.r3.PageManager.closeNotifier();
//					if (org.r3.PageManager.isRestDTO(responseData))
//					{
//						var restDto = new org.r3.RestDTOAdapter(responseData);
//						restDto.showMessage('carddetailactionform_fieldset_message');
//					}
//					else 
//					{
//						if (isUpdate)
//						{
//							$('#carddetailactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });							
//						}
//						else
//							_self.closeNewCardPanel();
//					}					
//				},
//				
//				"error" : function(jqXHR, timeout, message)
//				{
//					org.r3.PageManager.closeNotifier();
//					$('#carddetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
//				}
//				
//			});
//		}
//	},

	deleteItem : function()
	{
		var _self = this;
		
		if (org.r3.PageManager.confirmation("org.r3.message.deleteconfirm"))
		{
			var method = "DELETE";
			var restUrl = null;
			var cardId = this.dataBeanInfo.dataBean.postid;
			
			restUrl = org.r3.PageManager.getRESTUrl('DELETE_Post', [ this.dataBeanInfo.dataBean.site, org.r3.Constants.language, cardId ]);

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
					$('#carddetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
				}
			});
		}
	},
	
	closeCardPanel: function()
	{
		this.pageManager.closeCardPanel();
	},
	
	onNewCardCreated: function(postDTOAdapter)
	{
		this.pageManager.onNewCardCreated(postDTOAdapter);
	},
	
	listaCards : function()
	{
		org.r3.PageManager.back();
	},
	
	uploadFile: function(aCardDTOAdapter)
	{
	    this.hide();
	    this.pageManager.uploadFile(this.dataBeanInfo);
	},
	
//	updateCardDescr4Language: function(aLanguageCode)
//	{
//		var theForm = $('#cardtextactionform_form');
//		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
//		{
//			var method = "put";
//			var idCard = this.dataBeanInfo.dataBean.postid;
//			var restUrl = org.r3.PageManager.getRESTUrl('PUT_PostTextBody_Detail',  [ idCard, aLanguageCode ]);
//	
//			org.r3.PageManager.wait("org.r3.message.waiting");
//			theForm.ajaxSubmit(
//			{
//				"type" : method,
//				"url" : restUrl,
//				"dataType" : "json",
//				"success" : function(responseData)
//				{
//					org.r3.PageManager.closeNotifier();
//					if (org.r3.PageManager.isRestDTO(responseData))
//					{
//						var restDto = new org.r3.RestDTOAdapter(responseData);
//						restDto.showMessage('cardtextactionform_fieldset_message');
//					}
//					else 
//					{
//						$('#cardtextactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });							
//					}					
//				},
//				
//				"error" : function(jqXHR, timeout, message)
//				{
//					org.r3.PageManager.closeNotifier();
//					$('#cardtextactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
//				}
//				
//			});
//		}		
//	},
	
	retrieveCardDescr: function(aLanguageCode, onComplete, onError)
	{
		var method = "GET";
		var restUrl = null;
		restUrl = org.r3.PageManager.getRESTUrl('GET_CardDescr_Detail', [ this.dataBeanInfo.dataBean.cardid, aLanguageCode ]),

		org.r3.PageManager.wait("org.r3.message.waiting");
		$.ajax(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"success" : function(responseData)
			{
				org.r3.PageManager.closeNotifier();
				
				var cardDescrDataBean =  null;
				if (responseData)
				{
					cardDescrDataBean = new org.r3.db.cms.carddescr.CardDescrDTOAdapter(responseData);		
				}
				
				if (onComplete)
					onComplete(cardDescrDataBean);	
			},
			
			"error" : function(jqXHR, timeout, message)
			{
				console.error("org.r3.jsportlet.mongocms.CardDetailActionForm: ", message);
				if (onError)
					onError(message);	
			}
		});

	},

//	updateFileProperty: function(aPropertyid, onSuccess)
//	{
//		var theForm = $('#cardfileactionform_form');
//		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
//		{
//			var method = "put";
//			var idCard = this.dataBeanInfo.dataBean.cardid;
//			var restUrl = org.r3.PageManager.getRESTUrl('PUT_CardProperty_File',  [ idCard, aPropertyid ]);
//
//			org.r3.PageManager.wait("org.r3.message.waiting");
//			theForm.ajaxSubmit(
//			{
//				"type" : method,
//				"url" : restUrl,
//				"dataType" : "json",
//				"success" : function(responseData)
//				{
//					org.r3.PageManager.closeNotifier();
//					if (org.r3.PageManager.isRestDTO(responseData))
//					{
//						var restDto = new org.r3.RestDTOAdapter(responseData);
//						restDto.showMessage('cardfileactionform_fieldset_message');
//					}
//					else 
//					{
//						$('#cardfileactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });
//                        if (onSuccess)
//                        	onSuccess();
//					}					
//				},
//				
//				"error" : function(jqXHR, timeout, message)
//				{
//					org.r3.PageManager.closeNotifier();
//					$('#cardfileactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
//				}
//				
//			});
//		}		
//	},

//	updateLinkProperty: function(aPropertyId, onSuccess, onError)
//	{
//		var method = "put";
//		var idCard = this.dataBeanInfo.dataBean.cardid;
//		var restUrl = org.r3.PageManager.getRESTUrl('PUT_CardProperty_Link',  [ idCard, aPropertyId ]);
//
//		this.submitProperty('#cardlinkactionform_form', restUrl, method, onSuccess, onError);
//	},
	
//	addLinkProperty: function(onSuccess, onError)
//	{
//		var method = "post";
//		var idCard = this.dataBeanInfo.dataBean.cardid;
//		var restUrl = org.r3.PageManager.getRESTUrl('POST_CardProperty_Link',  [ idCard ]);
//
//		this.submitProperty('#cardlinkactionform_form', restUrl, method, onSuccess, onError);		
//	},
	
	submitProperty: function(formId, restUrl, method, onSuccess, onError)
	{
		var _self = this;
		var theForm = $(formId);
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{
			org.r3.PageManager.wait("org.r3.message.waiting");
			theForm.ajaxSubmit(
			{
				"type" : method,
				"url" : restUrl,
				"dataType" : "json",
				"success" : function(responseData)
				{
					org.r3.PageManager.closeNotifier();
					_self.detailView.refresh();
					if (onSuccess)
						onSuccess(responseData);					
				},
				
				"error" : function(jqXHR, timeout, message)
				{
					org.r3.PageManager.closeNotifier();
					if (onError)
						onError(message);
				}
				
			});
		}		
	}


});


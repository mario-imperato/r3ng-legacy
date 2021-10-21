$.r3Utils.namespace("org.r3.console.contacts");

org.r3.console.contacts.ActorDetailActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aDetailViewContainerId_tab_generale, aDetailViewContainerId_tab_siteresource)
	{
		this.setPageManager(aPageManager);
		
		this.htmlContainerId = aDetailViewContainerId;
		
		this.detailView = new org.r3.console.contacts.ActorDetailActionFormView(aDetailViewContainerId_tab_generale, this, 'tabs_mode');
		// this.siteResourceDetailView = new org.r3.jsportlet.project.siteresource.SiteResourceActionFormView(aDetailViewContainerId_tab_siteresource, this, 'tabs_mode');
	},

	close : function()
	{
		// M20140201 - org.r3.PageManager.popBreadCrumb();		
		this.hide();
	},

	hide : function()
	{
		$(this.htmlContainerId).hide();
	},

	show : function()
	{
		$(this.htmlContainerId).show();
	},

	open : function(aDataBeanInfo)
	{
		this.setDataBeanInfo(aDataBeanInfo);
		
		var navigatorMode = aDataBeanInfo ? 'detail' : 'create';
		var navigatorUrl = org.r3.Constants.applicationContext + '/org/r3/console/contacts/ActorDetailActionFormView_tab_navigator.html.jsp?mode=' + navigatorMode;
		
		$.ajax(
		{
			"type" : "GET",
			"url" : org.r3.PageManager.getVersionedUIURL(navigatorUrl),
			"dataType" : "html",
			"success" : $.r3Utils.hitch(this, function(responseData)
			{
				$(this.htmlContainerId).html(tmpl(responseData, {}));
				
				this.detailView.open(aDataBeanInfo);
//				if (aDataBeanInfo)
//				    this.siteResourceDetailView.open(aDataBeanInfo.dataBean.actorid);
				
				// $('#actorDetailActionFormView_tab_navigator').tabs();
				$(this.htmlContainerId).show();
				
			}),
			"error" : function(jqXHR, timeout, message)
			{
				console.error("Errore Loading: ", navigatorUrl);
			}
		});		

//		$(this.htmlContainerId).load(
//				org.r3.PageManager.getVersionedUIURL(navigatorUrl),
//				$.r3Utils.hitch(this, function(responseText, textStatus, jqXHR)
//		{
//			this.detailView.open(aDataBeanInfo);
//			if (aDataBeanInfo)
//			    this.siteResourceDetailView.open(aDataBeanInfo.dataBean.actorid);
//			
//			$('#actorDetailActionFormView_tab_navigator').tabs();
//			$(this.htmlContainerId).show();
//		}));
	},

	updateItem : function(onSuccessResponse, onFailResponse)
	{
		this._saveItem(true, onSuccessResponse, onFailResponse);
	},

	createItem : function(onSuccessResponse, onFailResponse)
	{
		this._saveItem(false, onSuccessResponse, onFailResponse);
	},

	_saveItem : function(isUpdate, onSuccessResponse, onErrorResponse)
	{
		var _self = this;
		
		var theForm = $('#actordetailactionform_form');
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{
			var method = "post";
			var restUrl = org.r3.PageManager.getRESTUrl('POST_Actor');
			if (isUpdate)
			{
				var actorId = this.dataBeanInfo.dataBean.actorid;
				restUrl = org.r3.PageManager.getRESTUrl('PUT_Actor', [ actorId ]);
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
					if (onSuccessResponse)
						onSuccessResponse(responseData);	
					
					if (!org.r3.PageManager.isRestDTO(responseData))
					{
					if (method == 'put')
		                  _self.listaContatti();
					else  _self.pageManager.closeNewActorPanel();					
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
			var actorId = this.dataBeanInfo.dataBean.actorid;
			restUrl = org.r3.PageManager.getRESTUrl('DELETE_Actor', [ actorId ]);

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

					_self.pageManager.closeNewActorPanel();
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

	listaContatti : function()
	{
		org.r3.PageManager.back();
	},
	
	openLogInUserPicker: function(srcPickerWidget)
	{
        console.info("Opening The Picker", srcPickerWidget);
        this.hide();
        this.pageManager.openLogInUserPicker(srcPickerWidget);		
	}
	
//	updateSiteResource: function(onSuccessResponse, onErrorResponse)
//	{
//		var _self = this;
//		
//		var theForm = $('#siteresourceform_form');
//		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
//		{
//			var method = "put";
//			var actorId = this.dataBeanInfo.dataBean.actorid;
//			var	restUrl = org.r3.PageManager.getRESTUrl('PUT_ActorResourceDetail', [ actorId ]);
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
//					if (onSuccessResponse)
//						onSuccessResponse(responseData);						
//				},
//				
//				"error": function(jqXHR, timeout, message)
//				{
//					console.log(arguments);
//					org.r3.PageManager.closeNotifier();
//					if (onErrorResponse)
//						onErrorResponse(jqXHR, timeout, message);
//				}
//			});
//		}
//	}
			

});


$.r3Utils.namespace("org.r3.jsportlet.project.resource");

org.r3.jsportlet.project.resource.ResourceDetailActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aDetailViewContainerId_tab_generale, aTeamListActionFormContainerId)
	{
		this.setPageManager(aPageManager);
		
		this.htmlContainerId = aDetailViewContainerId;
		
		this.detailView = new org.r3.jsportlet.project.resource.ResourceDetailActionFormView(aDetailViewContainerId_tab_generale, this, 'tabs_mode');	
		
		// L'idea è quella di caricare la form di creazione direttamente al posto del navigator... il parametro infatti è aDetailViewContainerId
		this.createView = new org.r3.jsportlet.project.resource.ResourceCreateActionFormView(aDetailViewContainerId, this, 'default');			
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

	refresh: function()
	{
		this.detailView.refresh();
	},
	
	open : function(aDataBeanInfo, anOpenOptionsHash)
	{
		if (!aDataBeanInfo)
		{
			this.createView.open();
			return ;		
		}
		
		// La modalità a dettaglio è a TABs onde per cui richiede il caricamento del navigator e al suo interno il caricamento del TAB Generale.
		this.setDataBeanInfo(aDataBeanInfo);
		
		var navigatorMode = aDataBeanInfo ? 'detail' : 'create';
		var navigatorUrl = org.r3.Constants.applicationContext + '/org/r3/jsportlet/project/resource/ResourceDetailActionFormView_tab_navigator.html.jsp?mode=' + navigatorMode + "&traverseRelationship=" + anOpenOptionsHash.traverseRelationship;
				
		$.ajax(
		{
			"type" : "GET",
			"url" : org.r3.PageManager.getVersionedUIURL(navigatorUrl),
			"dataType" : "html",
			"success" : $.r3Utils.hitch(this, function(responseData)
			{
				$(this.htmlContainerId).html(tmpl(responseData, {  }));
				
				this.detailView.open(aDataBeanInfo, anOpenOptionsHash);				
				
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
		
		var theForm = $('#resourcedetailactionform_form');
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{
			var method = "post";
			var restUrl = org.r3.PageManager.getRESTUrl('POST_Resource');
			if (isUpdate)
			{
				var resourceid = this.dataBeanInfo.dataBean.resourceid;
				restUrl = org.r3.PageManager.getRESTUrl('PUT_Resource', [ resourceid ]);
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
					
					if (method == 'put')
		                  _self.listaRisorse();
					else  _self.pageManager.closeNewResourcePanel();
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
			var resourceId = this.dataBeanInfo.dataBean.resourceid;
			restUrl = org.r3.PageManager.getRESTUrl('DELETE_Resource', [ resourceId ]);

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

					org.r3.PageManager.back();
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

	listaRisorse : function()
	{
		org.r3.PageManager.back();
	},
	
	openLogInUserPicker: function(srcPickerWidget)
	{
        console.info("Opening The Picker", srcPickerWidget);
        this.hide();
        this.pageManager.openLogInUserPicker(srcPickerWidget);		
	},

	submitForm: function(method, restUrl, theForm, onSuccess, onError)
	{
		var _self = this;
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
					_self.refresh();
					
					if (onSuccess)
						onSuccess(responseData);					
				},
				
				"error" : function(jqXHR, timeout, message)
				{
					org.r3.PageManager.closeNotifier();
					if (onError)
						onError(jqXHR, timeout, message);
				}
				
			});
		}		
	},
	
	searchBySSN: function(onSuccessResponse, onErrorResponse)
	{
		var theForm = $('#resourcedetailactionform_form');		
		var method = "GET";
		var aSSNValue = $('#resourcedetailactionform_ssn').val();			
		var restUrl = org.r3.PageManager.getRESTUrl('GET_ResourceBySSN', [ aSSNValue ]);

		$.ajax(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"success" : function(responseData)
			{
                 if (onSuccessResponse)
                	 onSuccessResponse(responseData);
			},
			"error" : function(jqXHR, timeout, message)
			{
				console.error("Errore Fetching Resource: ", message);
				if (onErrorResponse)
					onErrorResponse(jqXHR, timeout, message);
			}
		});	
		
	},
	
	openTeamDetail: function(aDTOAdapter)
	{
		this.hide();
	    this.pageManager.openTeamDetailPanel(aDTOAdapter, { "traverseRelationship": false,  "actions" : 'none' });	
	},
	
	deleteTeamFromResource: function( aResourceid, aTeamid, onSuccessResponse, onFailResponse)
	{
		var method = "delete";
		var restUrl = org.r3.PageManager.getRESTUrl('DELETE_TeamFromResource', [  aResourceid, aTeamid ] );				
		 
		org.r3.AjaxUtils.ajaxInvoke(method, restUrl, onSuccessResponse, onFailResponse, "org.r3.message.saveconfirm", true);
	}
			

});


$.r3Utils.namespace("org.r3.jsportlet.project.team");

org.r3.jsportlet.project.team.TeamDetailActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aDetailViewContainerId_tab_generale, aTeamListActionFormContainerId)
	{
		this.setPageManager(aPageManager);
		
		this.htmlContainerId = aDetailViewContainerId;
		
		this.detailView = new org.r3.jsportlet.project.team.TeamDetailActionFormView(aDetailViewContainerId_tab_generale, this, 'tabs_mode');
		
		// L'idea è quella di caricare la form di creazione direttamente al posto del navigator... il parametro infatti è aDetailViewContainerId
		this.createView = new org.r3.jsportlet.project.team.TeamCreateActionFormView(aDetailViewContainerId, this, 'default');		
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
				
		this.setDataBeanInfo(aDataBeanInfo);
		
		var navigatorMode = aDataBeanInfo ? 'detail' : 'create';
		var navigatorUrl = org.r3.Constants.applicationContext + '/org/r3/jsportlet/project/team/TeamDetailActionFormView_tab_navigator.html.jsp?mode=' + navigatorMode  + "&traverseRelationship=" + anOpenOptionsHash.traverseRelationship;
				
		$.ajax(
		{
			"type" : "GET",
			"url" : org.r3.PageManager.getVersionedUIURL(navigatorUrl),
			"dataType" : "html",
			"success" : $.r3Utils.hitch(this, function(responseData)
			{
				$(this.htmlContainerId).html(tmpl(responseData, { }));
				
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

	completeWorkflowActivity: function(nextTeamStatus, onSuccessResponse, onFailResponse)
	{
		var method = "put";
		var restUrl = org.r3.PageManager.getRESTUrl('PUT_TeamWorkflowOnComplete', [ this.dataBeanInfo.dataBean.teamid, nextTeamStatus] );
		
		// Debbo invalidare la LUT in quanto il cambio di stato mi deve forzare il ricaricamento della tendina dei teams con i loro stati.
		var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_Teams" );
		org.r3.PageManager.lutManager.invalidateLUT(resolvedUrl);
		 
		org.r3.AjaxUtils.ajaxInvoke(method, restUrl, onSuccessResponse, onFailResponse, "org.r3.message.saveconfirm", true);
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
		
		var theForm = $('#teamdetailactionform_form');
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{
			var method = "post";
			var restUrl = org.r3.PageManager.getRESTUrl('POST_Team');
			if (isUpdate)
			{
				var teamid = this.dataBeanInfo.dataBean.teamid;
				restUrl = org.r3.PageManager.getRESTUrl('PUT_Team', [ teamid ]);
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
		                  _self.listaTeams();
					else  _self.pageManager.closeNewTeamPanel();
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
			var teamid = this.dataBeanInfo.dataBean.teamid;
			restUrl = org.r3.PageManager.getRESTUrl('DELETE_Team', [ teamid ]);

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

	listaTeams : function()
	{
		org.r3.PageManager.back();
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
	
	openResourceDetail: function(aDTOAdapter)
	{
		this.hide();
	    this.pageManager.openResourceDetailPanel(aDTOAdapter, { "traverseRelationship": false, "actions" : 'none' });	
	},
	
	deleteResourceFromTeam: function(aTeamid, aResourceid, onSuccessResponse, onFailResponse)
	{
		var method = "delete";
		var restUrl = org.r3.PageManager.getRESTUrl('DELETE_ResourceFromTeam', [  aTeamid, aResourceid ] );				
		 
		org.r3.AjaxUtils.ajaxInvoke(method, restUrl, onSuccessResponse, onFailResponse, "org.r3.message.saveconfirm", true);
	}
			

});


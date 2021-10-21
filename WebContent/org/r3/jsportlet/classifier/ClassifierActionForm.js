$.r3Utils.namespace("org.r3.jsportlet.classifier");

org.r3.jsportlet.classifier.ClassifierActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aItemContainerId, aItemDetailViewContainerId, aItemsViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.classifier.ClassifierActionFormView(aDetailViewContainerId, this);
		
		// Salvo il Container esterno per poterlo nascondere e mostrare
		this.itemInfoContainerId = aItemContainerId;
		
		this.itemDetailView = new org.r3.jsportlet.classifier.ClassifierItemActionFormView(aItemDetailViewContainerId, this);
		
		this.itemListView = new org.r3.db.system.classifieritem.ClassifierItemQueryActionFormView(aItemsViewContainerId, this,
				{
					dataTableId : 'ClassifierItemQueryActionFormView',
					showTemplateOnOpen : false,
					// htmlTemplateUrl : org.r3.Constants.applicationContext + '/org/r3/jsportlet/classifier/ClassifierItemActionFormView.html.jsp',
					// layout : 'fullWidth',
					canvasType : 'list-group',
					gradeLevel : 'grade_level1',
					iDisplayLength: -1,
					legend : 'Elementi',
					// dataTableSource : org.r3.PageManager.getRESTUrl('GET_CardFiles', [ aCardDataBean.dataBean.cardid ]),

					// pannello con l'identificativo del gruppo
					// onInitializationComplete : $.unepUtils.hitch(this,
					// this.populateRiepilogo),
					dataTableColumns : "classifieritemorder,clsitemid,classifieritemdescr,numberofchildren",
					// requiredLUTs : [ "GET_classifier_r3ea_crewrole" ],

					onSelected : $.r3Utils.hitch(this, function(aClassifierItemDTOAdapter)
					{
						$('#classifieritem_deleteItem').prop('disabled', false);
						this.itemDetailView.classifierItemDetail(aClassifierItemDTOAdapter);
					}),

					onDblClick : $.r3Utils.hitch(this, function(aClassifierItemDTOAdapter)
					{
						$('#classifieritem_deleteItem').prop('disabled', true);				
					}),

					buttons : [
					{
						id : 'classifieritem_deleteItem',
						label : 'Elimina',
						disabled : true,
						onClick : $.r3Utils.hitch(this, this._onClassifierItemDelete)
					} ],

					onClearSelection : function()
					{
						$('#classifieritem_deleteItem').prop('disabled', true);
					},

					onInitializationComplete : $.r3Utils.hitch(this, function()
					{
						this.itemListView.show();
					})
				});		
	},

	close : function()
	{
		this.detailView.close();
		this.itemDetailView.close();
		this.itemListView.close();
		
		$(this.itemInfoContainerId).hide();
	},

	hide : function()
	{
		this.detailView.hide();
		this.itemDetailView.hide();
		this.itemListView.hide();
		
		$(this.itemInfoContainerId).hide();
	},

	show : function()
	{
		this.detailView.show();
		this.itemDetailView.show();
		this.itemListView.show();
		
		$(this.itemInfoContainerId).show();
	},

	refresh : function()
	{
		this.itemDetailView.refresh();
		
		this.itemListView.refresh();
		$('#classifieritem_deleteItem').prop('disabled', true);
	},

	open : function(aClsId)
	{
       var _self = this;
       
	   var method = "GET";
	   var restUrl = null;
	   restUrl = org.r3.PageManager.getRESTUrl('GET_classifierdetail', [ aClsId ]),

		org.r3.PageManager.wait("org.r3.message.waiting");
		$.ajax(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"success" : function(responseData)
			{
				org.r3.PageManager.closeNotifier();
				
				var classifierDataBean =  null;
				if (responseData)
				{
					classifierDataBean = new org.r3.db.system.classifier.ClassifierDTOAdapter(responseData);		
					_self.setDataBeanInfo(classifierDataBean);
					_self.detailView.open(classifierDataBean);
					_self.itemDetailView.open(classifierDataBean);
					
					var dataTableColumns = "classifieritemorder,clsitemid,classifieritemdescr,numberofchildren";		
					if (classifierDataBean.isLinear())
						dataTableColumns = "classifieritemorder,clsitemid,classifieritemdescr";
						
					var dataTableSource = org.r3.PageManager.getRESTUrl('GET_classifieritems', [ classifierDataBean.dataBean.clsid ]);
					
					_self.itemListView.open({
							"dataTableSource": dataTableSource,
							"dataTableColumns": dataTableColumns,
							"onInitializationCompleteArgs": arguments
					});					
				}
				else _self.detailView.open(classifierDataBean);				
				
				$(_self.itemInfoContainerId).show();
			},
			
			"error" : function(jqXHR, timeout, message)
			{
				console.error("org.r3.jsportlet.classifier.ClassifierActionForm: ", message);	
			}
		});		
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
						onError(message);
				}
				
			});
		}		
	},

	_onClassifierItemDelete: function()
	{
		var _self = this;
		
		if (org.r3.PageManager.confirmation("org.r3.message.deleteconfirm"))
		{           	
    	    var selectedItem = this.itemListView.fnGetSelectedDataBean();
    	    this.deleteClassifierItem(selectedItem,
				function(responseData) { 
					_self.refresh();
		        }, 
				function(jqXHR, timeout, message) { console.log("org.r3.jsportlet.classifier.ClassifierActionForm::" + message); }				    	    
    	    );
		}	    	    		
	},
	
	deleteClassifierItem: function(aClassifierDTOAdapter, onSuccess, onError)
	{
		var _self = this;

		var method = "DELETE";
		var restUrl = null;
		var site = aClassifierDTOAdapter.dataBean.site;
		var clsid = aClassifierDTOAdapter.dataBean.clsid;
		var clsitemid = aClassifierDTOAdapter.dataBean.clsitemid;
		restUrl = org.r3.PageManager.getRESTUrl('DELETE_classifieritems', [ clsid, clsitemid ]);

		org.r3.PageManager.wait("org.r3.message.waiting");
		$.ajax(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"success" : function(responseData)
			{
				org.r3.PageManager.closeNotifier();
				if (onSuccess)
					onSuccess(responseData);
			},
			"error" : function(jqXHR, timeout, message)
			{
				if (onError)
					onError(message);
			}
		});
	}
				
});


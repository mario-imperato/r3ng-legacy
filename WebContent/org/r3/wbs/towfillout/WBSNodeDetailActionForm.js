$.r3Utils.namespace("org.r3.wbs.towfillout");

org.r3.wbs.towfillout.WBSNodeDetailActionForm = org.r3.ActionFormManager.extend(
{
	init : function(aPageManager, aDetailViewContainerId, aChildEntityListViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.wbs.towfillout.WBSNodeDetailActionFormView(aDetailViewContainerId, this);		
		
		this.listView = new org.r3.db.project.resourcetimesheetview.ResourceTimesheetViewQueryActionFormView
		(
				aChildEntityListViewContainerId, 
				this,
				{
					dataTableId : 'ResourceTimesheetViewQueryActionFormView',
					gradeLevel : 'grade_level4 grade_clickable',
					legend : org.r3.db.project.resourcetimesheetview.message.queryactionformview_legend,	
					iDisplayLength: 25,
					layout : 'fullWidth',
					sortable: false,
					// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
					dataTableColumns : "resourcedescr,profiledescr,startperiod,endperiod,effort",
					requiredLUTs : [ 
                        "GET_classifier_sys_recstatus" ],
					
                    onDblClick : null,
                    onSelected :  $.r3Utils.hitch(this, function(aResourceTimesheetDTOAdapter)
					{
						$('#resurcetimesheet_action_delete').prop('disabled', false);
						this.detailView.itemDetail(aResourceTimesheetDTOAdapter);
					}),
                    
					onClearSelection : function()
					{
						$('#resurcetimesheet_action_delete').prop('disabled', true);
					},
					
					actionBarOnTop: true,
					buttons : [
					{
						id : 'resurcetimesheet_action_delete',
						label : 'Elimina',
						disabled : true,
						onClick : $.r3Utils.hitch(this, this._onDelete)
					}],
					
					searchInfo :
					{
		                widget: 'select',

		          		widgetInitialization: {
		          			url: org.r3.PageManager.getRESTUrl('GET_TeamMemberProfiles', [ org.r3.Constants.site ]),
		          			blankOptionText: org.r3.PageManager.getMessageFromDict("org.r3.wbs.towfillout.message.any")
		          		},
		          		
		          	    label: org.r3.wbs.towfillout.message.search_category,
		          	    validationRules: org.r3.wbs.towfillout.queryfilter_searchform_validationRules,
		          	    validationMessages: org.r3.wbs.towfillout.queryfilter_searchform_validationMessages,
		          	    autoStart: true
		          	},
		          	
				}
		);

	},

	close : function()
	{
		this.detailView.close(); 
		this.listView.close();
	},

	hide : function()
	{
		this.detailView.hide();
		this.listView.close();
	},

	show : function()
	{
		this.detailView.show();
		this.listView.show();
	},

	refresh : function()
	{
		this.detailView.refresh();
		
		this.listView.refresh();
		$('#resurcetimesheet_action_delete').prop('disabled', true);
	},
	
	open : function(aWbsId, aWbsNodeId)
	{
		this.detailView.open(aWbsId, aWbsNodeId);
		
		var dataTableSource = org.r3.PageManager.getRESTUrl('GET_WBSNode_ResourceTimesheet', [ aWbsId, aWbsNodeId ]);
		
		this.listView.open({
				"dataTableSource": dataTableSource
		});

	},
	
	_onDelete: function()
	{
		var _self = this;
		
		if (org.r3.PageManager.confirmation("org.r3.message.deleteconfirm"))
		{           	
    	    var selectedItem = this.listView.fnGetSelectedDataBean();
    	    this.deleteItem(selectedItem,
				function(responseData) { 
					_self.refresh();
		        }, 
				function(jqXHR, timeout, message) { console.log("org.r3.jsportlet.classifier.ClassifierActionForm::" + message); }				    	    
    	    );
		}	    	    		
	},
	
	deleteItem: function(aResourceTimesheetEntryDTOAdapter, onSuccess, onError)
	{
		var _self = this;

		var method = "DELETE";
		var restUrl = null;
		var site = aResourceTimesheetEntryDTOAdapter.dataBean.site;
		var tsambitid = aResourceTimesheetEntryDTOAdapter.dataBean.tsambitid;
		var tsactivityid = aResourceTimesheetEntryDTOAdapter.dataBean.tsactivityid;
		var tsentryid = aResourceTimesheetEntryDTOAdapter.dataBean.tsentryid;
		restUrl = org.r3.PageManager.getRESTUrl('DELETE_WBSNode_ResourceTimesheet', [ tsambitid, tsactivityid, tsentryid ]);

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
	},
	
	saveResourceTimesheetEntry : function(theForm, aWbsId, aWbsNodeId, aTsEntryId, onSuccessResponse, onErrorResponse)
	{
		var _self = this;
				
		var restUrl = org.r3.PageManager.getRESTUrl('POST_WBSNode_ResourceTimesheet', [ aWbsId, aWbsNodeId ]);
		var method = "post";
		if (aTsEntryId && aTsEntryId.length)
		{
			restUrl = org.r3.PageManager.getRESTUrl('PUT_WBSNode_ResourceTimesheet', [ aWbsId, aWbsNodeId, aTsEntryId ]);
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
				_self.refresh();
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
			
});


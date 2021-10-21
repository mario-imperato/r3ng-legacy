$.r3Utils.namespace("org.r3.console.bbs");

org.r3.console.bbs.BBSThreadDetailActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aChildEntityListViewContainerId, aDeleteGroupDialogConfirmationActionFormContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.console.bbs.BBSThreadDetailActionFormView(aDetailViewContainerId, this);
		
		// this.listView = new it.posteitaliane.unep.anagrafica.GruppoQueryActionFormView(anHtmlActionFormContainerId, this);
		// grade_clickable
		this.listView = new org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewQueryActionFormView
		(
				aChildEntityListViewContainerId, 
				this,
				{
					dataTableId : 'BBSThreadNodeQueryActionFormView',
					gradeLevel : 'grade_level4 grade_clickable',
					legend : org.r3.db.bbs.bbsthreadnodeview.message.queryactionformview_legend,	
					iDisplayLength: 25,
					layout : 'fullWidth',
					sortable: true,
					// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
					dataTableColumns : "multiselector,threadnodeid;sort,nodetitle,username,creationdate",
					requiredLUTs : [ 
                        "GET_classifier_sys_recstatus" ],
					
                    onDblClick : null,
                    onSelected :  $.r3Utils.hitch(this, this.threadNodeDetail), 
					onClearSelection : null,
					
					actionBarOnTop: true,
					buttons : [
					{
						id : 'console_threadnode_action_deletepost',
						label : org.r3.console.bbs.message.action_deleteselectedposts,
						disabled : true,
						onClick : $.r3Utils.hitch(this, function() { this.onDeleteThreadNodes(); })
					},
					
					{
						id : 'console_threadnode_action_addpost',
						label : org.r3.console.bbs.message.action_newpost,
						disabled : false,
						onClick : $.r3Utils.hitch(this, function() { this.onNewThreadNode(); })
					}],

					onInitializationComplete: function()
					{
						$('#BBSThreadNodeQueryActionFormView_all_threadnodeid').unbind().click(function(e)
						{
							var currentTarget = $(e.currentTarget);
							
							if (currentTarget.prop('checked'))
							{
								$('#console_threadnode_action_deletepost').prop('disabled', false);	
							    $("#BBSThreadNodeQueryActionFormView_tableform input[type='checkbox'][name='threadnodeid']").prop('checked', true);
							}
							else 
							{
								$('#console_threadnode_action_deletepost').prop('disabled', true);	
								$("#BBSThreadNodeQueryActionFormView_tableform input[type='checkbox'][name='threadnodeid']").prop('checked', false);
							}
						});
						
						$('#BBSThreadNodeQueryActionFormView').bind('page', function () {
							$('#BBSThreadNodeQueryActionFormView_all_threadnodeid').prop('checked', false);
							$('#console_threadnode_action_deletepost').prop('disabled', true);	
						});
						
						var matchExpr = "#BBSThreadNodeQueryActionFormView_tableform input[type='checkbox'][name='threadnodeid']";
						$(document).off('click', matchExpr).on('click', matchExpr, function(e) {
							$('#BBSThreadNodeQueryActionFormView_all_threadnodeid').prop('checked', false);
							
							var numberOfSelected = 0;
							$.each($("#BBSThreadNodeQueryActionFormView_tableform input[type='checkbox'][name='threadnodeid']"), function(index, item)
							{
								if ($(item).prop('checked'))
									numberOfSelected++;
							});

							if (numberOfSelected)
							{
								$('#console_threadnode_action_deletepost').prop('disabled', false);	
							}
							else
							{
								$('#console_threadnode_action_deletepost').prop('disabled', true);									
							}
							
							e.stopPropagation();
						});						
						
					}
				}
		);

	},

	close : function()
	{
		// M20140201 - org.r3.PageManager.popBreadCrumb();
		this.hide();
	},

	hide : function()
	{
		this.detailView.hide();
		this.listView.hide();
	},

	show : function()
	{
		this.detailView.show();
		this.listView.show();
	},

	refresh: function()
	{
	   this.listView.refresh();	
	},
	
	open : function(aTopicId, aThreadDTOAdapter)
	{
		this.setDataBeanInfo(aThreadDTOAdapter);
		this.topicId = aTopicId;
		
		this.detailView.open(aTopicId, aThreadDTOAdapter);		
		
		if (aThreadDTOAdapter)
		{
			var dataTableSource = org.r3.PageManager.getRESTUrl('GET_BBSThreadNodes_InThread', [ aTopicId, aThreadDTOAdapter.dataBean.threadid ]);
			
			this.listView.open({
					"dataTableSource": dataTableSource,
					"onInitializationCompleteArgs": arguments
			});
		}
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
		
		var theForm = $('#threaddetailactionform_form');
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{
			var method = null;
			var restUrl = null;
			if (isUpdate)
			{
				var topicId = this.dataBeanInfo.dataBean.topicid;
				var threadId = this.dataBeanInfo.dataBean.threadid;
				restUrl = org.r3.PageManager.getRESTUrl('PUT_BBSThread', [ topicId, threadId ]);
				method = "put";
			}
			else
			{
				var topicId = this.topicId;
				restUrl = org.r3.PageManager.getRESTUrl('POST_BBSThread', [ topicId ]);
				method = "post";
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
					var closeDetailPanel = true;
					if (onSuccessResponse)
						closeDetailPanel = onSuccessResponse(responseData);	
					
					if (closeDetailPanel)
					    org.r3.PageManager.back();
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
	
	onNewThreadNode: function()
	{
		this.hide();
		this.pageManager.openThreadNodePanel(this.dataBeanInfo.dataBean.topicid, this.dataBeanInfo.dataBean.threadid, null, null);
	},
	
    threadNodeDetail: function(aThreadNodeDTOAdapter)
    {
		this.hide();
		this.pageManager.openThreadNodePanel(this.dataBeanInfo.dataBean.topicid, this.dataBeanInfo.dataBean.threadid, null, aThreadNodeDTOAdapter);
    },
	
	onDeleteThread: function()
    {    
		if (!org.r3.PageManager.confirmation("org.r3.message.deleteconfirm"))
		{
			return;
		}
		
    	var _self = this;

		var method = "DELETE";
		var aTopicId = this.dataBeanInfo.dataBean.topicid;
		var aThreadId = this.dataBeanInfo.dataBean.threadid;
		var restUrl = org.r3.PageManager.getRESTUrl('DELETE_BBSThread', [ aTopicId, aThreadId ]);

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
				console.error("Errore Deleting Actor Group: ", message);
			}
		});		
    },
	
	onDeleteThreadNodes: function()
	{		
		var _self = this;						
		
		var theForm = $('#BBSThreadNodeQueryActionFormView_tableform');
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.deletemulticonfirm"))
		{
			var topicId =  this.dataBeanInfo.dataBean.topicid;
			var threadId = this.dataBeanInfo.dataBean.threadid;

			var restUrl = org.r3.PageManager.getRESTUrl('DELETE_Selected_BBSThreadNodes', [ topicId, threadId ]);
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
					_self.listView.refresh();

					$('#BBSThreadNodeQueryActionFormView_all_threadnodeid').prop('checked', false);
					$('#console_threadnode_action_deletepost').prop('disabled', true);					
				},
				
				"error": function(jqXHR, timeout, message)
				{
					console.error(message);
					org.r3.PageManager.closeNotifier();
				}
			});
		}
	}
	
});


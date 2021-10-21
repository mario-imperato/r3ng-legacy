$.r3Utils.namespace("org.r3.console.bbs");

org.r3.console.bbs.BBSTopicDetailActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aChildEntityListViewContainerId, aDeleteGroupDialogConfirmationActionFormContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.console.bbs.BBSTopicDetailActionFormView(aDetailViewContainerId, this);
		
		// this.listView = new it.posteitaliane.unep.anagrafica.GruppoQueryActionFormView(anHtmlActionFormContainerId, this);
		// grade_clickable
		this.listView = new org.r3.db.bbs.bbsthread.BBSThreadQueryActionFormView
		(
				aChildEntityListViewContainerId, 
				this,
				{
					dataTableId : 'BBSThreadQueryActionFormView',
					gradeLevel : 'grade_level3 grade_clickable',
					legend : org.r3.db.bbs.bbsthread.message.queryactionformview_legend,	
					iDisplayLength: 25,
					layout : 'fullWidth',
					sortable: true,
					// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
					dataTableColumns : "multiselector,threadid;sort,threadtitle;sort,numposts,lastposttimestamp,creationdate",
					requiredLUTs : [ 
                        "GET_classifier_sys_recstatus" ],
					
                    onDblClick : null,
                    onSelected :  $.r3Utils.hitch(this, this.threadDetail), 
					onClearSelection : null,
					
					actionBarOnTop: true,
					buttons : [
					{
						id : 'console_thread_action_deletethread',
						label : org.r3.console.bbs.message.action_deleteselectedthreads,
						disabled : true,
						onClick : $.r3Utils.hitch(this, function() { this.onDeleteThreads(); })
					},
					
					{
						id : 'console_thread_action_addthread',
						label : org.r3.console.bbs.message.action_newthread,
						disabled : false,
						onClick : $.r3Utils.hitch(this, function() { this.onNewThread(); })
					}],

					onInitializationComplete: function()
					{
						$('#BBSThreadQueryActionFormView_all_threadid').unbind().click(function(e)
						{
							var currentTarget = $(e.currentTarget);
							
							if (currentTarget.prop('checked'))
							{
								$('#console_thread_action_deletethread').prop('disabled', false);	
							    $("#BBSThreadQueryActionFormView_tableform input[type='checkbox'][name='threadid']").prop('checked', true);
							}
							else 
							{
								$('#console_thread_action_deletethread').prop('disabled', true);	
								$("#BBSThreadQueryActionFormView_tableform input[type='checkbox'][name='threadid']").prop('checked', false);
							}
						});
						
						$('#BBSThreadQueryActionFormView').bind('page', function () {
							$('#BBSThreadQueryActionFormView_all_threadid').prop('checked', false);
							$('#console_thread_action_deletethread').prop('disabled', true);	
						});
						
						var matchExpr = "#BBSThreadQueryActionFormView_tableform input[type='checkbox'][name='threadid']";
						$(document).off('click', matchExpr).on('click', matchExpr, function(e) {
							$('#BBSThreadQueryActionFormView_all_threadid').prop('checked', false);
							
							var numberOfSelected = 0;
							$.each($("#BBSThreadQueryActionFormView_tableform input[type='checkbox'][name='threadid']"), function(index, item)
							{
								if ($(item).prop('checked'))
									numberOfSelected++;
							});

							if (numberOfSelected)
							{
								$('#console_thread_action_deletethread').prop('disabled', false);	
							}
							else
							{
								$('#console_thread_action_deletethread').prop('disabled', true);									
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
	
	open : function(aTopicDTOAdapter)
	{
		this.setDataBeanInfo(aTopicDTOAdapter);
		this.detailView.open(aTopicDTOAdapter);		
		
		if (aTopicDTOAdapter)
		{
			var dataTableSource = org.r3.PageManager.getRESTUrl('GET_BBSThreads_InTopic', [ aTopicDTOAdapter.dataBean.topicid ]);
			
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
		
		var theForm = $('#topicdetailactionform_form');
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{
			var method = "post";
			var restUrl = org.r3.PageManager.getRESTUrl('POST_BBSTopics');
			if (isUpdate)
			{
				var topicId = this.dataBeanInfo.dataBean.topicid;
				restUrl = org.r3.PageManager.getRESTUrl('PUT_BBSTopic', [ topicId ]);
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
					
					var closeDetailPanel = true;
					if (onSuccessResponse)
						closeDetailPanel = onSuccessResponse(responseData);	
					
					if (closeDetailPanel)
					    _self.pageManager.closeBBSTopicPanel();
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
	
	onNewThread: function()
	{
		this.hide();
		this.pageManager.openThreadPanel(this.dataBeanInfo.dataBean.topicid, null);
	},
	
    threadDetail: function(aThreadDTOAdapter)
    {
		this.hide();
		this.pageManager.openThreadPanel(this.dataBeanInfo.dataBean.topicid, aThreadDTOAdapter);
    },
	
	onDeleteTopic: function()
    {    
		if (!org.r3.PageManager.confirmation("org.r3.message.deleteconfirm"))
		{
			return;
		}
		
    	var _self = this;

		var method = "DELETE";
		var aTopicId = this.dataBeanInfo.dataBean.topicid;
		var restUrl = org.r3.PageManager.getRESTUrl('DELETE_BBSTopics', [ aTopicId ]);

		org.r3.PageManager.wait("org.r3.message.waiting");
		$.ajax(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"success" : function()
			{
				org.r3.PageManager.closeNotifier();
				_self.pageManager.closeBBSTopicPanel();
			},
			"error" : function(jqXHR, timeout, message)
			{
				console.error("Errore Deleting Actor Group: ", message);
			}
		});		
    },
	
	onDeleteThreads: function()
	{		
		var _self = this;						
		
		var theForm = $('#BBSThreadQueryActionFormView_tableform');
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.deletemulticonfirm"))
		{
			var topicId = this.dataBeanInfo.dataBean.topicid;
			restUrl = org.r3.PageManager.getRESTUrl('PUT_Selected_BBSThreads', [ topicId ]);
			method = "put";

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
					
					$('#BBSThreadQueryActionFormView_all_threadid').prop('checked', false);
					$('#console_thread_action_deletethread').prop('disabled', true);
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


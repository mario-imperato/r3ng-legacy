$.r3Utils.namespace("org.r3.console.contacts");

org.r3.console.contacts.ActorGroupDetailActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aChildEntityListViewContainerId, aDeleteGroupDialogConfirmationActionFormContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.console.contacts.ActorGroupDetailActionFormView(aDetailViewContainerId, this);
		
		// this.listView = new it.posteitaliane.unep.anagrafica.GruppoQueryActionFormView(anHtmlActionFormContainerId, this);
		// grade_clickable
		this.listView = new org.r3.db.actor.actor.ActorQueryActionFormView
		(
				aChildEntityListViewContainerId, 
				this,
				{
					dataTableId : 'ActorGroupActorQueryActionFormView',
					gradeLevel : 'grade_level5 grade_clickable',
					legend : org.r3.console.contacts.message.actorgroupdetailactionform_listofactors,	
					iDisplayLength: 25,
					layout : 'fullWidth',
					sortable: true,
					// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
					dataTableColumns : "multiselector,actorid;sort,firstname,lastname;sort,address,email,cellphone",
					requiredLUTs : [ 
                        "GET_classifier_sys_recstatus" ],
					
                    onDblClick : null,
                    onSelected :  $.r3Utils.hitch(this, this.actorDetail), 
					onClearSelection : null,
					
					actionBarOnTop: true,
					buttons : [
					{
						id : 'console_actorgroup_action_deleteactor',
						label : org.r3.console.contacts.message.actorgroupdetailactionform_deleteactorsfromgroup,
						disabled : true,
						onClick : $.r3Utils.hitch(this, function() { this.onRemoveItemsFromGroup(); })
					},
					
					{
						id : 'console_actorgroup_action_addactor',
						label : org.r3.console.contacts.message.actorgroupdetailactionform_addactors2group,
						disabled : false,
						onClick : $.r3Utils.hitch(this, function() { this.onAddActors(); })
					}],

					onInitializationComplete: function()
					{
						$('#ActorGroupActorQueryActionFormView_all_actorid').unbind().click(function(e)
						{
							var currentTarget = $(e.currentTarget);
							
							if (currentTarget.prop('checked'))
							{
								$('#console_actorgroup_action_deleteactor').prop('disabled', false);	
							    $("#ActorGroupActorQueryActionFormView_tableform input[type='checkbox'][name='actorid']").prop('checked', true);
							}
							else 
							{
								$('#console_actorgroup_action_deleteactor').prop('disabled', true);	
								$("#ActorGroupActorQueryActionFormView_tableform input[type='checkbox'][name='actorid']").prop('checked', false);
							}
						});
						
						$('#ActorGroupActorQueryActionFormView').bind('page', function () {
							$('#ActorGroupActorQueryActionFormView_all_actorid').prop('checked', false);
							$('#console_actorgroup_action_deleteactor').prop('disabled', true);	
						});
						
						var matchExpr = "#ActorGroupActorQueryActionFormView_tableform input[type='checkbox'][name='actorid']";
						$(document).off('click', matchExpr).on('click', matchExpr, function(e) {
							$('#ActorGroupActorQueryActionFormView_all_actorid').prop('checked', false);
							
							var numberOfSelected = 0;
							$.each($("#ActorGroupActorQueryActionFormView_tableform input[type='checkbox'][name='actorid']"), function(index, item)
							{
								if ($(item).prop('checked'))
									numberOfSelected++;
							});

							if (numberOfSelected)
							{
								$('#console_actorgroup_action_deleteactor').prop('disabled', false);	
							}
							else
							{
								$('#console_actorgroup_action_deleteactor').prop('disabled', true);									
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
	
	open : function(aGroupId)
	{
		this.setDataBeanInfo(aGroupId);
		this.detailView.open(aGroupId);		
		
		if (aGroupId)
		{
			var dataTableSource = org.r3.PageManager.getRESTUrl('GET_Actors_InGroup', [ aGroupId ]);
			
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
		
		var theForm = $('#actorgroupdetailactionform_form');
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{
			var method = "post";
			var restUrl = org.r3.PageManager.getRESTUrl('POST_ActorGroup');
			if (isUpdate)
			{
				var groupId = this.dataBeanInfo;
				restUrl = org.r3.PageManager.getRESTUrl('PUT_ActorGroup', [ groupId ]);
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
					
					var actorGroupDataBean = new org.r3.db.actor.group.ActorGroupDTOAdapter(responseData);					

					if (onSuccessResponse)
						onSuccessResponse(actorGroupDataBean);	

					if (method == 'put')
					{						  
						 _self.pageManager.onActorGroupUpdate(actorGroupDataBean);
					}
					else  
					{
						_self.pageManager.onActorGroupCreate(actorGroupDataBean);		
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
	
	onAddActors: function()
	{
		this.hide();
		this.pageManager.addActorsToGroup(this.dataBeanInfo);
	},
	
	onRemoveGroup: function()
	{		
		this.pageManager.ask4Confirmation({
			onConfirmed: $.r3Utils.hitch(this, this.removeGroup)
		});					
	},
	
	removeGroup: function(removeActors)
	{
		this.pageManager.deleteActorGroup(this.dataBeanInfo, removeActors);
	},
	
	onRemoveItemsFromGroup: function()
	{
		var theForm = $('#ActorGroupActorQueryActionFormView_tableform');
		
		if (theForm.valid())
		{
			this.pageManager.ask4Confirmation({
				onConfirmed: $.r3Utils.hitch(this, this.removeItemsFromGroup)
			});	
		}		
	},
	
	removeItemsFromGroup: function(removeActors)
	{		
		var _self = this;						
		
		var theForm = $('#ActorGroupActorQueryActionFormView_tableform');
		if (theForm.valid()) /* && org.r3.PageManager.confirmation("org.r3.message.deletemulticonfirm") */
		{
			var groupId = this.dataBeanInfo;
			restUrl = org.r3.PageManager.getRESTUrl('PUT_RemoveContactsFromActorGroup', [ groupId, removeActors ]);
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
				},
				
				"error": function(jqXHR, timeout, message)
				{
					console.error(message);
					org.r3.PageManager.closeNotifier();
				}
			});
		}
	},
		
    actorDetail: function(aDTOAdapter)
    {
		this.hide();
		org.r3.console.contacts.PageManager.openActorDetailPanel(aDTOAdapter);
    }
	
});


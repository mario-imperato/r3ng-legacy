$.r3Utils.namespace("org.r3.console.contacts");

org.r3.console.contacts.ActorGroupAddActorsActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aChildEntityListViewContainerId)
	{
		this.setPageManager(aPageManager);

		// this.listView = new it.posteitaliane.unep.anagrafica.GruppoQueryActionFormView(anHtmlActionFormContainerId, this);
		// grade_clickable
		this.listView = new org.r3.db.actor.actor.ActorQueryActionFormView
		(
				aDetailViewContainerId, 
				this,
				{
					dataTableId : 'ActorGroupAddActorsQueryActionFormView',
					gradeLevel : 'grade_level4 grade_clickable',
					legend : org.r3.console.contacts.message.actorgroupdetailactionform_listofcandidateactors,	
					iDisplayLength: 25,
					layout : 'fullWidth',
					sortable: true,
					// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
					dataTableColumns : "multiselector,actorid;sort,firstname,lastname;sort,address,email,cellphone",
					requiredLUTs : [ 
                        "GET_classifier_sys_recstatus" ],
					
                    onDblClick : null,
                    onSelected :  null,
					onClearSelection : null,
					
					actionBarOnTop: true,
					buttons : [					
					{
						id : 'console_actorgroupaddactor_action_addactor',
						label : org.r3.console.contacts.message.actorgroupdetailactionform_addselectedactors2group,
						disabled : true,
						onClick : $.r3Utils.hitch(this, function() { this.addItemsToGroup(); })
					},
					
					{
						id : 'console_actorgroupaddactor_action_cancel',
						label : org.r3.message.action_cancel,
						disabled : false,
						onClick : $.r3Utils.hitch(this, function() { org.r3.PageManager.back(); })
					}					
					],

					onInitializationComplete: function()
					{
						$('#ActorGroupAddActorsQueryActionFormView_all_actorid').unbind().click(function(e)
								{
									var currentTarget = $(e.currentTarget);
									
									if (currentTarget.prop('checked'))
									{
										$('#console_actorgroupaddactor_action_addactor').prop('disabled', false);	
									    $("#ActorGroupAddActorsQueryActionFormView_tableform input[type='checkbox'][name='actorid']").prop('checked', true);
									}
									else 
									{
										$('#console_actorgroupaddactor_action_addactor').prop('disabled', true);	
										$("#ActorGroupAddActorsQueryActionFormView_tableform input[type='checkbox'][name='actorid']").prop('checked', false);
									}
								});
								
								$('#ActorGroupAddActorsQueryActionFormView').bind('page', function () {
									$('#ActorGroupAddActorsQueryActionFormView_all_actorid').prop('checked', false);
									$('#console_actorgroupaddactor_action_addactor').prop('disabled', true);	
								});
								
								var matchExpr = "#ActorGroupAddActorsQueryActionFormView_tableform input[type='checkbox'][name='actorid']";
								$(document).off('click', matchExpr).on('click', matchExpr, function(e) {
									$('#ActorGroupAddActorsQueryActionFormView_all_actorid').prop('checked', false);
									
									var numberOfSelected = 0;
									$.each($("#ActorGroupAddActorsQueryActionFormView_tableform input[type='checkbox'][name='actorid']"), function(index, item)
									{
										if ($(item).prop('checked'))
											numberOfSelected++;
									});

									if (numberOfSelected)
									{
										$('#console_actorgroupaddactor_action_addactor').prop('disabled', false);	
									}
									else
									{
										$('#console_actorgroupaddactor_action_addactor').prop('disabled', true);									
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
		this.listView.hide();
	},

	show : function()
	{
		this.listView.show();
	},

	open : function(aGroupId)
	{
		this.setDataBeanInfo(aGroupId);
		
		var dataTableSource = org.r3.PageManager.getRESTUrl('GET_Actors_NotInGroup', [ aGroupId ]);
		
		this.listView.open({
				"dataTableSource": dataTableSource,
				"onInitializationCompleteArgs": arguments
		});
	},
	
	onAddActors: function()
	{
		this.hide();
		this.pageManager.addActorsToGroup(this.dataBeanInfo);
	},
	
	addItemsToGroup: function()
	{
		
		var _self = this;
		
		var theForm = $('#ActorGroupAddActorsQueryActionFormView_tableform');
		if (theForm.valid())
		{
			var groupId = this.dataBeanInfo;
			restUrl = org.r3.PageManager.getRESTUrl('PUT_AddContactsIntoActorGroup', [ groupId ]);
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
	}
		

});


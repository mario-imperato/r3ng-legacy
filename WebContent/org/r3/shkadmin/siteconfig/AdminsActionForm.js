$.r3Utils.namespace("org.r3.shkadmin.siteconfig");

org.r3.shkadmin.siteconfig.AdminsActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aChildEntityListViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.shkadmin.siteconfig.AdminsActionFormView(aDetailViewContainerId, this);
		
		// this.listView = new it.posteitaliane.unep.anagrafica.GruppoQueryActionFormView(anHtmlActionFormContainerId, this);
		// grade_clickable
		this.listView = new org.r3.db.system.user.user.UserQueryActionFormView
		(
				aChildEntityListViewContainerId, 
				this,
				{
					dataTableId : 'UserQueryActionFormView',
					gradeLevel : 'grade_level5',
					legend : org.r3.shkadmin.siteconfig.message.adminsctionform_listofadmins,	
					iDisplayLength: 25,
					layout : 'fullWidth',
					sortable: true,
					// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
					dataTableColumns : "multiselector,firstname,lastname;sort,email",
					requiredLUTs : [ 
                        "GET_classifier_sys_recstatus" ],
					
                    onDblClick : null,
                    onSelected :  null, 
					onClearSelection : null,
					
					actionBarOnTop: true,
					buttons : [
					{
						id : 'shkadmin_admins_action_deleteuser',
						label : org.r3.shkadmin.siteconfig.message.admins_deleteusersfromadminsgroup,
						disabled : true,
						onClick : $.r3Utils.hitch(this, function() { this.onRemoveItemsFromAdminsGroup(); })
					}],

					onInitializationComplete: function()
					{
						$('#UserQueryActionFormView_all_userid').unbind().click(function(e)
						{
							var currentTarget = $(e.currentTarget);
							
							if (currentTarget.prop('checked'))
							{
								$('#shkadmin_admins_action_deleteuser').prop('disabled', false);	
							    $("#UserQueryActionFormView_tableform input[type='checkbox'][name='userid']").prop('checked', true);
							}
							else 
							{
								$('#shkadmin_admins_action_deleteuser').prop('disabled', true);	
								$("#UserQueryActionFormView_tableform input[type='checkbox'][name='userid']").prop('checked', false);
							}
						});
						
						$('#UserQueryActionFormView').bind('page', function () {
							$('#UserQueryActionFormView_all_userid').prop('checked', false);
							$('#shkadmin_admins_action_deleteuser').prop('disabled', true);	
						});
						
						var matchExpr = "#UserQueryActionFormView_tableform input[type='checkbox'][name='userid']";
						$(document).off('click', matchExpr).on('click', matchExpr, function(e) {
							$('#UserQueryActionFormView_all_userid').prop('checked', false);
							
							var numberOfSelected = 0;
							$.each($("#UserQueryActionFormView_tableform input[type='checkbox'][name='userid']"), function(index, item)
							{
								if ($(item).prop('checked'))
									numberOfSelected++;
							});

							if (numberOfSelected)
							{
								$('#shkadmin_admins_action_deleteuser').prop('disabled', false);	
							}
							else
							{
								$('#shkadmin_admins_action_deleteuser').prop('disabled', true);									
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
	
	open : function()
	{
		this.detailView.open();		
		
		var dataTableSource = org.r3.PageManager.getRESTUrl('GET_Users_InRole', [ 'shkadmin' ]);
		
		this.listView.open({
				"dataTableSource": dataTableSource,
				"onInitializationCompleteArgs": arguments
		});		
	},
		
	
	onRemoveItemsFromAdminsGroup: function()
	{		
		var _self = this;						
		
		var theForm = $('#UserQueryActionFormView_tableform');
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.deletemulticonfirm"))
		{
			restUrl = org.r3.PageManager.getRESTUrl('DELETE_Role_From_Users_4_Site', [ 'shkadmin' ]);
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


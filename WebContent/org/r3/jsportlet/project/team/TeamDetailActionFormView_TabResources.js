$.r3Utils.namespace("org.r3.jsportlet.project.team");


org.r3.jsportlet.project.team.TeamDetailActionFormView_TabResources = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, aTeamDTOAdapter)
	{
		var _self = this;
		
		this._super(anHtmlActionFormContainerId, anActionFormManager);

		// this.listView = new it.posteitaliane.unep.anagrafica.GruppoQueryActionFormView(anHtmlActionFormContainerId, this);
		// grade_clickable
		this.listView = new org.r3.db.project.teamresourceview.TeamResourceViewQueryActionFormView
		(
				anHtmlActionFormContainerId, 
				this.actionFormManager,
				{
					showTemplateOnOpen: false,
					htmlTemplateUrl: org.r3.Constants.applicationContext + "/org/r3/jsportlet/project/team/TeamDetailActionFormView_TabResources.html",
					
					dataTableId : 'TeamResourcesActionFormView',
					"dataTableSource": org.r3.PageManager.getRESTUrl('GET_Team_Resources', [ aTeamDTOAdapter.dataBean.teamid ]),
					
					gradeLevel : 'grade_level6 grade_clickable',
					legend : org.r3.db.project.teamresourceview.message.queryactionformview_legend,	
					iDisplayLength: 25,
					
					layout : 'fullWidth',
					sortable: true,
					// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
					dataTableColumns : "resourceid;sort,resourcedescr,profileid,price,queryformview-tools",
					requiredLUTs : [ 
                        "GET_classifier_sys_recstatus", "GET_TeamMemberProfiles" ],
					
                    onToolsIconSelected: $.r3Utils.hitch(this, this.onToolSelected),
                        
                    onSelected : $.r3Utils.hitch(this, function(aTeamResourceDTOAdapter)
					{
						// $('#teamresource_deleteItem').prop('disabled', false);
						// $('#teamresourceform_action_save').prop('disabled', false);
						this.openDetail(aTeamResourceDTOAdapter);
					}),

//					onDblClick : $.r3Utils.hitch(this, function(aTeamMemberDTOAdapter)
//					{
//						$('#teamresource_deleteItem').prop('disabled', true);	
//						$('#teamresourceform_action_save').prop('disabled', true);							
//					}),
					
//					onClearSelection : function()
//					{
//						$('#teamresource_deleteItem').prop('disabled', true);
//						// $('#teamresourceform_action_save').prop('disabled', true);
//					},
						              	
					actionBarOnTop: true,
//					buttons : [
//					{
//						id : 'teamresource_deleteItem',
//						label : 'Elimina',
//						disabled : true,
//						onClick : $.r3Utils.hitch(this, this._onItemDelete)
//					} ],
					
					onInitializationComplete: $.r3Utils.hitch(this, function() {

//				        $('#teamresourceform_resourceid').val(aResourceDTOAdapter.dataBean.resourceid);
						$('#teamresourceform_teamdescr').html(aTeamDTOAdapter.dataBean.teamdescr);
						$('#teamresourceform_teamid').val(aTeamDTOAdapter.dataBean.teamid);
						
						var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_TeamMemberProfiles" );
						org.r3.PageManager.lutManager.populateSelectField(
						{
							"lutUrl" : resolvedUrl,
							"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
							"selectWidget" : $('#teamresourceform_profileid'),
							"selectedValue": null // anActorDTOAdapter && anActorDTOAdapter.dataBean.profileid,
						});
												
						var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_Resources" );
						org.r3.PageManager.lutManager.populateSelectField(
						{
							"lutUrl" : resolvedUrl,
							"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
							"selectWidget" : $('#teamresourceform_resourceid'),
							"selectedValue": null // anActorDTOAdapter && anActorDTOAdapter.dataBean.profileid,
						});
						
						$("#teamresource_form").validate
				        ({
				        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
				               rules: org.r3.jsportlet.project.team.teamresource_form_validationRules,
					           messages: org.r3.jsportlet.project.team.teamresource_form_validationMessages    
				        });
						
						var b1 = $('#teamresourceform_action_save');
						var b2 = $('#teamresourceform_action_clear');
						if (aTeamDTOAdapter.canBeModified())
						{
							b1.show().unbind().click($.r3Utils.hitch(this, this.onSaveItem));							
							b2.show().unbind().click($.r3Utils.hitch(this, this._clearForm));																				
						}
						else
						{
							b1.unbind().hide();							
							b2.unbind().hide();																											
						}
						
						$('#teamresource_fieldset_message').formmessage({});	

					})
				}

		);
		
		this.listView.open();		
				
	},
			
	refresh: function()
	{
        $("#teamresource_form").resetForm();
        this.listView.refresh();
	},

	openDetail: function(aTeamResourceDTOAdapter)
	{
		
		$('#teamresourceform_resourceid').val(aTeamResourceDTOAdapter.dataBean.resourceid);
		
		$('#teamresourceform_resourcedescr').val(aTeamResourceDTOAdapter.dataBean.resourcedescr);
		$('#teamresourceform_profileid').val(aTeamResourceDTOAdapter.dataBean.profileid);
		
	},
		
//	_onAdd2Team: function(evt)
//	{
//		var s = "teamresourceform_action_add2team_teamlist_";
//		var t = $(evt.target);
//		var teamId = t.attr('id');
//		if (teamId && teamId.indexOf(s) == 0)
//		{
//		    teamId = teamId.substring(s.length);
//		    this.saveItem(teamId);
//		}
//	},
	
	_clearForm: function()
	{
		$('#teamresource_form').resetForm();		
	},
	
	onSaveItem: function()
	{
		this.saveItem();
	},
	
	saveItem: function()
	{	
		var _self = this;
		var restUrl = null;
		var method = "POST";
		
		var teamid = $('#teamresourceform_teamid').val();
		var resourceid = $('#teamresourceform_resourceid').val();
		
		if (false)
		{
		    restUrl = org.r3.PageManager.getRESTUrl("POST_AddResource2Team", [ resourceid, teamid ]);
 			method = "POST";			
		}
		else
		{
		    restUrl = org.r3.PageManager.getRESTUrl("PUT_UpdateResourceInTeam", [ resourceid, teamid ]);
 			method = "PUT";			
		}
						
		this.actionFormManager.submitForm(
				method,
				restUrl,
				$("#teamresource_form"),
				function(responseData) 
				{ 
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('teamresource_fieldset_message');
					}		
					else 
					{
						_self._clearForm();
						$('#teamresource_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });											
					}
		        }, 
				function(jqXHR, timeout, message) { 
		        	$('#teamresource_fieldset_message').formmessage('setText', { text: message, category: 'error' }); 
		        }				
		);	
	},
		
	onToolSelected: function(aTeamResourceViewDTOAdapter, aToolId)
	{
		if (aToolId && aToolId == 'toolid-detail')
		{
			this.actionFormManager.openResourceDetail(aTeamResourceViewDTOAdapter);
		}

		if (aToolId && aToolId == 'toolid-delete')
		{
			this.actionFormManager.deleteResourceFromTeam(aTeamResourceViewDTOAdapter.dataBean.teamid, aTeamResourceViewDTOAdapter.dataBean.resourceid);
		}
	}
	    
	    


	    					
});

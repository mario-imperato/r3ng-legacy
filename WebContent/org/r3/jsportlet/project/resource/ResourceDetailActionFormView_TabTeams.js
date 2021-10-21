$.r3Utils.namespace("org.r3.jsportlet.project.resource");


org.r3.jsportlet.project.resource.ResourceDetailActionFormView_TabTeams = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, aResourceDTOAdapter)
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
					htmlTemplateUrl: org.r3.Constants.applicationContext + "/org/r3/jsportlet/project/resource/ResourceDetailActionFormView_TabTeams.html",
					
					dataTableId : 'ResourceTeamsActionFormView',
					"dataTableSource": org.r3.PageManager.getRESTUrl('GET_Resource_Teams', [ aResourceDTOAdapter.dataBean.resourceid ]),
					
					gradeLevel : 'grade_level6 grade_clickable',
					legend : org.r3.db.project.teamresourceview.message.queryactionformview_legend,	
					iDisplayLength: 25,
					
					layout : 'fullWidth',
					sortable: true,
					// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
					dataTableColumns : "resourcedescr,teamdescr,profileid,price,queryformview-tools",
					requiredLUTs : [ 
                        "GET_classifier_sys_recstatus", "GET_TeamMemberProfiles" ],
					
                    onToolsIconSelected: $.r3Utils.hitch(this, this.onToolSelected),
                        
                    onSelected : $.r3Utils.hitch(this, function(aTeamResourceDTOAdapter)
					{
						// $('#resourceteam_deleteItem').prop('disabled', false);
                    	this._updateActionsOnTeamChange(aTeamResourceDTOAdapter.dataBean.teamid);
						this.openDetail(aTeamResourceDTOAdapter);
					}),

//					onDblClick : $.r3Utils.hitch(this, function(aTeamMemberDTOAdapter)
//					{
//						$('#resourceteam_deleteItem').prop('disabled', true);	
//					
//					}),
//					
//					onClearSelection : function()
//					{
//						$('#resourceteam_deleteItem').prop('disabled', true);
//
//					},
						              	
//					actionBarOnTop: true,
//					buttons : [
//					{
//						id : 'resourceteam_deleteItem',
//						label : 'Elimina',
//						disabled : true,
//						onClick : $.r3Utils.hitch(this, this._onItemDelete)
//					} ],
					
					onInitializationComplete: $.r3Utils.hitch(this, function() {

						$('#resourceteam_resourcedescr').html(aResourceDTOAdapter.dataBean.resourcedescr);
				        $('#resourceteamform_resourceid').val(aResourceDTOAdapter.dataBean.resourceid);
				        
						var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_TeamMemberProfiles");
						org.r3.PageManager.lutManager.populateSelectField(
						{
							"lutUrl" : resolvedUrl,
							"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
							"selectWidget" : $('#resourceteamform_profileid'),
							"selectedValue": null // anActorDTOAdapter && anActorDTOAdapter.dataBean.profileid,
						});
							
						var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_Teams" );
						org.r3.PageManager.lutManager.populateSelectField(
						{
							"lutUrl" : resolvedUrl,
							"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
							"selectWidget" : $('#resourceteamform_teamid'),
							"selectedValue": null, // anActorDTOAdapter && anActorDTOAdapter.dataBean.profileid,
							"useBusinessKey": true
						});
						
//						if (listOfTeams && listOfTeams.iTotalRecords && listOfTeams.aaData && listOfTeams.aaData.length)
//						{
//							var listOfTeamsDropDownWidget = $('#resourceteamform_action_add2team_teamlist');
//							$.each(listOfTeams.aaData, $.r3Utils.hitch(this, function(entryIndex, entry)
//							{
//								listOfTeamsDropDownWidget.append('<li><a id="resourceteamform_action_add2team_teamlist_' + entry.teamid + '">' +  entry.teamdescr + '</a></li>');					
//							}));
//							
//							$('#resourceteamform_action_add2team_teamlist').unbind().click($.r3Utils.hitch(this, this._onAdd2Team));
//						}
//						else
//						{
//							$('#resourceteamform_action_add2team_teamlist').unbind().hide();
//						}
						
						$("#resourceteam_form").validate
				        ({
				        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
				               rules: org.r3.jsportlet.project.resource.resourceteam_form_validationRules,
					           messages: org.r3.jsportlet.project.resource.resourceteam_form_validationMessages    
				        });
						
						$('#resourceteamform_teamid').unbind().change($.r3Utils.hitch(this, this.onChangeTeamIdSelection));
						
						var b = $('#resourceteamform_action_save');
						b.unbind().click($.r3Utils.hitch(this, this.onSaveItem));
						b.prop('disabled', true);
						
						b = $('#resourceteamform_action_clear');
						b.unbind().click($.r3Utils.hitch(this, this._clearForm));						
						
						$('#resourceteam_fieldset_message').formmessage({});	

					})
				}

		);
		
		this.listView.open();		
				
	},
			
	refresh: function()
	{
        $("#resourceteam_form").resetForm();
        this.listView.refresh();
	},

	openDetail: function(aTeamResourceDTOAdapter)
	{
		$('#resourceteamform_teamid').val(aTeamResourceDTOAdapter.dataBean.teamid);
		$('#resourceteamform_profileid').val(aTeamResourceDTOAdapter.dataBean.profileid);
		
	},
		
	_updateActionsOnTeamChange: function(aTeamId)
	{
		var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_Teams" );
		var foundItem = org.r3.PageManager.lutManager.getLUTItem(resolvedUrl, function(item) { if (item.businesskey == aTeamId) return true; return false; });
	    if (foundItem)
		{
			 console.log("Selected: ", foundItem);
			 var aTeamDTOAdapter = new org.r3.db.project.team.TeamDTOAdapter(foundItem); 
			 if (aTeamDTOAdapter.canBeModified())
			 {
				 $('#resourceteamform_action_save').prop('disabled', false);
			 }
			 else
			 {
				 $('#resourceteamform_action_save').prop('disabled', true);
			 }
		}
	},
	
	onChangeTeamIdSelection: function(e)
	{
		 var selectField = $(e.currentTarget);
		 this._updateActionsOnTeamChange(selectField.val());
	},
	
//	_onAdd2Team: function(evt)
//	{
//		var s = "resourceteamform_action_add2team_teamlist_";
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
		$('#resourceteam_form').resetForm();	
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
		
		var teamid = $('#resourceteamform_teamid').val();
		var resourceid = $('#resourceteamform_resourceid').val();
		
		if (false)
		{
		    restUrl = org.r3.PageManager.getRESTUrl("POST_AddResource2Team", [ resourceid, aTargetTeamId ]);
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
				$("#resourceteam_form"),
				function(responseData) 
				{ 
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('resourceteam_fieldset_message');
					}		
					else 
					{
						_self._clearForm();
						$('#resourceteam_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });											
					}
		        }, 
				function(jqXHR, timeout, message) { 
		        	$('#resourceteam_fieldset_message').formmessage('setText', { text: message, category: 'error' }); 
		        }				
		);	
	},
	
	onToolSelected: function(aTeamResourceViewDTOAdapter, aToolId)
	{
		console.log("Tool Selected: ", aToolId);
		if (aToolId && aToolId == 'toolid-detail')
		{
			this.actionFormManager.openTeamDetail(aTeamResourceViewDTOAdapter);
		}
		
		if (aToolId && aToolId == 'toolid-delete')
		{
			this.actionFormManager.deleteTeamFromResource(aTeamResourceViewDTOAdapter.dataBean.resourceid, aTeamResourceViewDTOAdapter.dataBean.teamid);
		}
	}
	    


	    					
});

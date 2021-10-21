$.r3Utils.namespace("org.r3.jsportlet.teammemberprofile");

org.r3.jsportlet.teammemberprofile.TeamMemberProfileActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aQueryContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.teammemberprofile.TeamMemberProfileActionFormView(aDetailViewContainerId, this);				
		
		this.listView = new org.r3.db.project.teammemberprofile.TeamMemberProfileQueryActionFormView(aQueryContainerId, this,
		{
					dataTableId : 'TeamMemberProfileQueryActionFormView',
					showTemplateOnOpen : true,
					// htmlTemplateUrl : org.r3.Constants.applicationContext + '/org/r3/jsportlet/classifier/ClassifierItemActionFormView.html.jsp',
					// layout : 'fullWidth',
					// canvasType : 'list-group',
					gradeLevel : 'grade_level1',
					iDisplayLength: -1,
					legend : 'Elementi',
					// dataTableSource : org.r3.PageManager.getRESTUrl('GET_CardFiles', [ aCardDataBean.dataBean.cardid ]),

					// pannello con l'identificativo del gruppo
					// onInitializationComplete : $.unepUtils.hitch(this,
					// this.populateRiepilogo),
					dataTableColumns : "profileid,skillprofile,skillambit",
					requiredLUTs : [ "GET_classifier_skillprofile", "GET_classifier_skillambit" ],

					onSelected : $.r3Utils.hitch(this, function(aTeamMemberDTOAdapter)
					{
						$('#teammember_deleteItem').prop('disabled', false);
						this.detailView.openDetail(aTeamMemberDTOAdapter);
					}),

					onDblClick : $.r3Utils.hitch(this, function(aTeamMemberDTOAdapter)
					{
						$('#teammember_deleteItem').prop('disabled', true);				
					}),

					buttons : [
					{
						id : 'teammember_deleteItem',
						label : 'Elimina',
						disabled : true,
						onClick : $.r3Utils.hitch(this, this._onItemDelete)
					} ],

					onClearSelection : function()
					{
						$('#teammember_deleteItem').prop('disabled', true);
					}
				});		
	},

	close : function()
	{
		this.detailView.close();
		this.listView.close();
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

	refresh : function()
	{
		this.detailView.refresh();
		
		this.listView.refresh();
		$('#teammember_deleteItem').prop('disabled', true);
	},

	open : function(aTeamId)
	{
		this.setDataBeanInfo(aTeamId);
        this.detailView.open();		
		
        var dataTableSource = org.r3.PageManager.getRESTUrl('GET_TeamMemberProfiles', [ aTeamId ]);			
		this.listView.open({
			"dataTableSource": dataTableSource
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

	_onItemDelete: function()
	{
		var _self = this;
		
		if (org.r3.PageManager.confirmation("org.r3.message.deleteconfirm"))
		{           	
    	    var selectedItem = this.listView.fnGetSelectedDataBean();
    	    this.deleteItem(selectedItem,
				function(responseData) { 
					_self.refresh();
		        }, 
				function(jqXHR, timeout, message) { console.log("org.r3.jsportlet.teammember.TeamMemberActionForm::" + message); }				    	    
    	    );
		}	    	    		
	},
	
	deleteItem: function(aTeamMemberDTOAdapter, onSuccess, onError)
	{
		var _self = this;

		var method = "DELETE";
		var restUrl = null;
		var site = aTeamMemberDTOAdapter.dataBean.site;
		var teamid = aTeamMemberDTOAdapter.dataBean.teamid;
		var profileid = aTeamMemberDTOAdapter.dataBean.profileid;
		restUrl = org.r3.PageManager.getRESTUrl('DELETE_TeamMemberProfile', [ profileid ]);

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


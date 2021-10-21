$.r3Utils.namespace("org.r3.jsportlet.teammemberprofile");


org.r3.jsportlet.teammemberprofile.TeamMemberProfileActionFormView  = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		var _self = this;		
		this._super(anHtmlActionFormContainerId, anActionFormManager);

	},

	close : function()
	{
		this.hide();
	},

	refresh: function()
	{
        $("#teammemberprofile_form").resetForm();
        $('#teammemberprofile_profileid').prop('disabled', false);
	},
	
	open : function(aTeamId)
	{
				
		org.r3.PageManager.wait("org.r3.message.waiting");
        console.log("Logged User Is: ", org.r3.PageManager.userInfo);
		var networkRequestsQueue = [];

		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/teammemberprofile/TeamMemberProfileActionFormView.html.jsp'),
			dataType : "html"
		});
			
		org.r3.PageManager.multiAjax(networkRequestsQueue,
				
		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();		
			$(this.htmlContainerId).html(responseData['view']);	
				
			$("#teammemberprofile_form").validate
	        ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.jsportlet.teammemberprofile.teammemberprofile_form_validationRules,
		           messages: org.r3.jsportlet.teammemberprofile.teammemberprofile_form_validationMessages    
	        });
			
			var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_classifier_skillambit" );
			org.r3.PageManager.lutManager.populateSelectField(
			{
				"lutUrl" : resolvedUrl,
				"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
				"selectWidget" : $('#teammemberprofile_skillambit')						
			});
			
			var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_classifier_skillprofile" );
			org.r3.PageManager.lutManager.populateSelectField(
			{
				"lutUrl" : resolvedUrl,
				"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
				"selectWidget" : $('#teammemberprofile_skillprofile')						
			});
			
			$('#teammemberprofileform_action_save').unbind().click($.r3Utils.hitch(this, this.onSaveItem));
			$('#teammemberprofileform_action_clear').unbind().click($.r3Utils.hitch(this, function(e) {
			        $('#teammemberprofile_form').resetForm();	
			        $('#teammemberprofile_profileid').val("");
			        $('#teammemberprofile_profileid').prop("disabled", false);			        
			}));
			
			$('#teammemberprofile_fieldset_message').formmessage({});	
			this.show();
		}),
		
		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
	
	},
	
	
	openDetail: function(aTeamMemberProfileDTOAdapter)
	{
		var networkRequestsQueue = [];

		networkRequestsQueue.push(
		{
			id : "item",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_TeamMemberProfile_Detail', [ aTeamMemberProfileDTOAdapter.dataBean.teamid,  aTeamMemberProfileDTOAdapter.dataBean.profileid ]),
			dataType : "json"
		});
		
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_skillambit'));
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_skillprofile'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,
				
		$.r3Utils.hitch(this, function(responseData)
		{
			var itemDataBean = responseData['item'];
			if (itemDataBean != null)
			{
				aTeamMemberProfileDTOAdapter = new org.r3.db.project.teammemberprofile.TeamMemberProfileDTOAdapter(itemDataBean);
			}

			$('#teammemberprofile_profileid').val(aTeamMemberProfileDTOAdapter.dataBean.profileid);
			$('#teammemberprofile_profileid').prop('disabled', true);
			
			
			$('#teammemberprofile_itemorder').val(99);
			$('#teammemberprofile_profiledescr').val("");
			$('#teammemberprofile_skillprofile').val(aTeamMemberProfileDTOAdapter.dataBean.skillprofile);
			$('#teammemberprofile_skillambit').val(aTeamMemberProfileDTOAdapter.dataBean.skillambit);		
			
		})
		
		);
		
	},
		
	onSaveItem: function()
	{	
		var _self = this;
		var restUrl = null;
		var method = "POST";
		
		var teamid = this.actionFormManager.dataBeanInfo;
		
		if ($('#teammemberprofile_profileid').prop("disabled"))
		{
 		    restUrl = org.r3.PageManager.getRESTUrl("PUT_TeamMemberProfile", [  $('#teammemberprofile_profileid').val() ]);
 			method = "PUT";
		}
		else
		{
			restUrl = org.r3.PageManager.getRESTUrl("POST_TeamMemberProfile");			
		}
		
		$('#teammemberprofile_profiledescr').val(this._getProfileDescription());
		
		this.actionFormManager.submitForm(
				method,
				restUrl,
				$("#teammemberprofile_form"),
				function(responseData) { 
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('teammemberprofile_fieldset_message');
					}		
					else $('#teammemberprofile_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });											
		        }, 
				function(jqXHR, timeout, message) { 
		        	$('#teammemberprofile_fieldset_message').formmessage('setText', { text: message, category: 'error' }); 
		        }				
		);	
	},
	
	_getProfileDescription: function()
	{
		var s = $("#teammemberprofile_skillprofile option:selected").text() + " " + $("#teammemberprofile_skillambit option:selected").text();
		return s;
	}
	


});

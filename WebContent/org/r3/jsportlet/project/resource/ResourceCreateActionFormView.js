$.r3Utils.namespace("org.r3.jsportlet.project.resource");


org.r3.jsportlet.project.resource.ResourceCreateActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, openMode)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.openMode = openMode || 'default';
	},

	close : function()
	{
		this.hide();
	},

	refresh: function()
	{
		this.tabTeams.refresh();
	},
	
	open : function()
	{
		

		if (this.openMode == 'default') org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/project/resource/ResourceCreateActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});

		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			if (this.openMode == 'default') org.r3.PageManager.closeNotifier();
						
			$(this.htmlContainerId).html(tmpl(responseData['view'], { }));

			// ignore: [],
			$('#resourcedetailactionform_form').validate(
			{				
				errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
				rules : org.r3.jsportlet.project.resource.resourcedetailactionform_form_validationRules,
				messages : org.r3.jsportlet.project.resource.resourcedetailactionform_form_validationMessages
			});


			$('#resourcedetailactionform_fieldset_message').formmessage({});
			
			$('#resourcedetailactionform_form_action_cancel').click(
					$.r3Utils.hitch(this.actionFormManager, this.actionFormManager.listaRisorse));
						
			this._initializeFormFields();
			
			$('#resourcedetailactionform_action_saveitem').unbind().click(
					$.r3Utils.hitch(this, this._onCreateItem));
			$('#resourcedetailactionform_form_action_cancel').hide();
			$('#resourcedetailactionform_action_delete').hide();	
			
			$('#resourcedetailactionform_ssn_action_search').unbind().click(
					$.r3Utils.hitch(this, this._onSearchSSN));		
			
			$('#resourcedetailactionform_ssn').unbind().change($.r3Utils.hitch(this, this._onChangeSSN));
					 
			if (this.openMode == 'default')  this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
	_onChangeSSN: function()
	{
		$('.resource-domain-data').prop('disabled', false);
		$('#resourcedetailactionform_resourceid').val("");
	},
	
	_onSSNMatch: function(resourceDataBean)
	{
		if (resourceDataBean)
		{
			$('#resourcedetailactionform_resourceid').val(resourceDataBean.dataBean.resourceid);
			$('#resourcedetailactionform_firstname').val(resourceDataBean.dataBean.firstname);
			$('#resourcedetailactionform_lastname').val(resourceDataBean.dataBean.lastname);
			$('#resourcedetailactionform_email').val(resourceDataBean.dataBean.email);
			$('#resourcedetailactionform_cellphone').val(resourceDataBean.dataBean.cellphone);
			$('#resourcedetailactionform_phone').val(resourceDataBean.dataBean.phone);
			$('#resourcedetailactionform_address').val(resourceDataBean.dataBean.address);
			$('#resourcedetailactionform_userid').html(resourceDataBean.dataBean.userid);						
			$('#resourcedetailactionform_town').val(resourceDataBean.dataBean.town);
			$('#resourcedetailactionform_zipcode').val(resourceDataBean.dataBean.zipcode);				
			$('.resource-domain-data').prop('disabled', true);
		}
		   
	},
	
	_onCreateItem: function()
	{	
		this.actionFormManager.createItem(
				function(responseData) { 
		        }, 
				function(jqXHR, timeout, message) { $('#resourcedetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},
		
	_onSearchSSN: function()
	{
		var _self = this;
		
		if ($('#resourcedetailactionform_ssn').valid())
		{
		this.actionFormManager.searchBySSN(
				function(responseData) 
				{ 
					 if (responseData && responseData.iTotalRecords && responseData.aaData && responseData.aaData.length)
					 {
						 var resourceDataBean = new org.r3.db.project.resource.ResourceDTOAdapter(responseData.aaData[0]);
						 _self._onSSNMatch(resourceDataBean);
					 }
		        }, 
				function(jqXHR, timeout, message) { $('#resourcedetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
		}
		
		return false;
	},
	
	_initializeFormFields: function()
	{
		var useridPickerValue = null;
		
		$('#resourcedetailactionform_resourceid').val("");
		
		var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_TeamMemberProfiles" );
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : resolvedUrl,
			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#resourcedetailactionform_profileid'),
			"selectedValue": null // anActorDTOAdapter && anActorDTOAdapter.dataBean.profileid,			
		});
		
		var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_Teams_In_team_building");
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : resolvedUrl,
			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#resourcedetailactionform_teamid'),
			"selectedValue": null, // anActorDTOAdapter && anActorDTOAdapter.dataBean.profileid
			"useBusinessKey": true
		});
				
							
	}

});

$.r3Utils.namespace("org.r3.jsportlet.project.resource");


org.r3.jsportlet.project.resource.ResourceDetailActionFormView = org.r3.ActionFormView.extend(
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
	
	open : function(aDataBeanInfo, anOpenOptionsHash)
	{
		var formMode = (aDataBeanInfo) ? 'detail' : 'create';

		if (this.openMode == 'default') org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/project/resource/ResourceDetailActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});

		if (formMode == 'detail')
		{
			networkRequestsQueue.push(
			{
				id : "content",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl('GET_Resource_Detail', [ aDataBeanInfo.dataBean.resourceid ]),
				dataType : "json"
			});					
		}

		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			if (this.openMode == 'default') org.r3.PageManager.closeNotifier();

			var resourceDataBean = responseData['content'];
			if (resourceDataBean)
			{
				resourceDataBean = new org.r3.db.project.resource.ResourceDTOAdapter(resourceDataBean);
			}
			
			$(this.htmlContainerId).html(tmpl(responseData['view'], { "formmode": formMode }));

			// ignore: [],
			$('#resourcedetailactionform_form').validate(
			{				
				errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
				rules : org.r3.jsportlet.project.resource.resourcedetailactionform_form_validationRules,
				messages : org.r3.jsportlet.project.resource.resourcedetailactionform_form_validationMessages
			});

//			var resolvedUrl = it.posteitaliane.unep.PageManager.getRESTUrl('GET_classifier_sys_recstatus');			
//			var recStatus = (prodottoDataBean) ? prodottoDataBean.dataBean.recstatus : 'sys_recact';
//			it.posteitaliane.unep.PageManager.lutManager.populateRadioGroup(
//			{
//				"lutUrl" : resolvedUrl,
//				"groupContainer" : $('#prodottodetailactionform_form_recstatus_cnt'),
//				"groupId" : "prodottodetailactionform_form_recstatus_",
//				"groupName" : "recstatus",
//				"value" : recStatus
//			});

			$('#resourcedetailactionform_fieldset_message').formmessage({});
			
			$('#resourcedetailactionform_form_action_cancel').click(
					$.r3Utils.hitch(this.actionFormManager, this.actionFormManager.listaRisorse));
			
			
			this._initializeFormFields(resourceDataBean);
			
			if (resourceDataBean == null)
			{
				
				$('#resourcedetailactionform_action_saveitem').unbind().click(
						$.r3Utils.hitch(this, this._onCreateItem));
				$('#resourcedetailactionform_form_action_cancel').hide();
				$('#resourcedetailactionform_action_delete').hide();	
				
				$('#resourcedetailactionform_ssn_action_search').unbind().click(
						$.r3Utils.hitch(this, this._onSearchSSN));		
				
				$('#resourcedetailactionform_ssn').unbind().change($.r3Utils.hitch(this, this._onChangeSSN));
			}
			else
			{				
				$('#resourcedetailactionform_action_saveitem').unbind().click(
						$.r3Utils.hitch(this, this._onUpdateItem));
				$('#resourcedetailactionform_form_action_cancel').show();						

				var a = $('#resourcedetailactionform_action_delete');
				if (anOpenOptionsHash.actions == 'all')
				{
					a.unbind().click($.r3Utils.hitch(this, this._onDeleteItem));				
					a.show();	
				}
				else 
				{
					a.unbind().hide();
				}
				
				$('#resourcedetailactionform_ssn').prop('disabled', true);	
				$('#resourcedetailactionform_ssn_action_search').unbind().prop('disabled', true);	
			}
		
			if (formMode == 'detail' && anOpenOptionsHash.traverseRelationship)
			{	
			   this.tabTeams = new org.r3.jsportlet.project.resource.ResourceDetailActionFormView_TabTeams('#resourceDetailActionFormView_tab_teams', this.actionFormManager, resourceDataBean);
			}   
			 
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
	
	_onUpdateItem: function()
	{
		this.actionFormManager.updateItem(
				function(responseData) { 					
		        }, 
				function(jqXHR, timeout, message) { $('#resourcedetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},

	_onDeleteItem: function()
	{	
		this.actionFormManager.deleteItem(
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
	
	_initializeFormFields: function(anActorDTOAdapter)
	{
		var useridPickerValue = null;
		
		if (anActorDTOAdapter)
		{
			$('#resourcedetailactionform_resourceid').val(anActorDTOAdapter.dataBean.resourceid);
			$('#resourcedetailactionform_firstname').val(anActorDTOAdapter.dataBean.firstname);
			$('#resourcedetailactionform_lastname').val(anActorDTOAdapter.dataBean.lastname);
			$('#resourcedetailactionform_email').val(anActorDTOAdapter.dataBean.email);
			$('#resourcedetailactionform_cellphone').val(anActorDTOAdapter.dataBean.cellphone);
			$('#resourcedetailactionform_phone').val(anActorDTOAdapter.dataBean.phone);
			$('#resourcedetailactionform_address').val(anActorDTOAdapter.dataBean.address);
			$('#resourcedetailactionform_userid').html(anActorDTOAdapter.dataBean.userid);						
			$('#resourcedetailactionform_town').val(anActorDTOAdapter.dataBean.town);
			$('#resourcedetailactionform_zipcode').val(anActorDTOAdapter.dataBean.zipcode);	
			$('#resourcedetailactionform_ssn').val(anActorDTOAdapter.dataBean.ssn);
			
			if (anActorDTOAdapter.dataBean.userid)
				useridPickerValue = { dtokey: anActorDTOAdapter.dataBean.userid, dtodescr: anActorDTOAdapter.dataBean.userid };
		}						
		else
		{	
			$('#resourcedetailactionform_resourceid').val("");
			
			var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_TeamMemberProfiles" );
			org.r3.PageManager.lutManager.populateSelectField(
			{
				"lutUrl" : resolvedUrl,
				"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
				"selectWidget" : $('#resourcedetailactionform_profileid'),
				"selectedValue": null // anActorDTOAdapter && anActorDTOAdapter.dataBean.profileid,			
			});
			
			var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_Teams");
			org.r3.PageManager.lutManager.populateSelectField(
			{
				"lutUrl" : resolvedUrl,
				"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
				"selectWidget" : $('#resourcedetailactionform_teamid'),
				"selectedValue": null, // anActorDTOAdapter && anActorDTOAdapter.dataBean.profileid
				"useBusinessKey": true
			});
		
		}
		
		$('#resourcedetailactionform_pickeruserid_cnt').picker(
		{
			multiple: false,
			fieldName: "userid",
			openPicker: $.r3Utils.hitch(this.actionFormManager, this.actionFormManager.openLogInUserPicker),
			fieldId: "resourcedetailactionform_picker_userid",
			pickerValue: useridPickerValue
		});
							
	}

});

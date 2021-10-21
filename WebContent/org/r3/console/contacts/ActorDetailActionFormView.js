$.r3Utils.namespace("org.r3.console.contacts");


org.r3.console.contacts.ActorDetailActionFormView = org.r3.ActionFormView.extend(
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

	open : function(aDataBeanInfo)
	{
		if (this.openMode == 'default') org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/contacts/ActorDetailActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});

		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/contacts/ActorDetailActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});
		
		if (aDataBeanInfo)
		{
			networkRequestsQueue.push(
			{
				id : "content",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl('GET_ActorDetail', [ aDataBeanInfo.dataBean.actorid ]),
				dataType : "json"
			});			
			
		}

		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			if (this.openMode == 'default') org.r3.PageManager.closeNotifier();

			var actorDataBean = responseData['content'];
			if (actorDataBean)
			{
				actorDataBean = new org.r3.db.actor.actor.ActorDTOAdapter(actorDataBean);
			}
			
			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));

			// ignore: [],
			$('#actordetailactionform_form').validate(
			{				
				errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
				rules : org.r3.console.contacts.actordetailactionform_form_validationRules,
				messages : org.r3.console.contacts.actordetailactionform_form_validationMessages
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

			$('#actordetailactionform_fieldset_message').formmessage({});
			
			$('#actordetailactionform_form_action_cancel').click(
					$.r3Utils.hitch(this.actionFormManager, this.actionFormManager.listaContatti));
			
			this._initializeFormFields(actorDataBean);
			
			if (actorDataBean == null)
			{
				$('#actordetailactionform_action_saveitem').click(
						$.r3Utils.hitch(this, this._onCreateItem));
				$('#actordetailactionform_form_action_cancel').hide();
				$('#actordetailactionform_action_delete').hide();		
			}
			else
			{				
				$('#actordetailactionform_action_saveitem').click(
						$.r3Utils.hitch(this, this._onUpdateItem));
				$('#actordetailactionform_form_action_cancel').show();						

				if (!actorDataBean.isLocked())
				{					
					$('#actordetailactionform_action_delete').unbind().click(
							$.r3Utils.hitch(this, this._onDeleteItem));				
					$('#actordetailactionform_action_delete').show();		
				}
				else
					$('#actordetailactionform_action_delete').hide();
					

			}
		
			if (this.openMode == 'default')  this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
	_onCreateItem: function()
	{
		this.actionFormManager.createItem(
				function(responseData) { 
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('actordetailactionform_fieldset_message');
					}
		        }, 
				function(jqXHR, timeout, message) { $('#actordetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},
	
	_onUpdateItem: function()
	{
		this.actionFormManager.updateItem(
				function(responseData) { 					
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('actordetailactionform_fieldset_message');
					}
		        }, 
				function(jqXHR, timeout, message) { $('#actordetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},

	_onDeleteItem: function()
	{
		this.actionFormManager.deleteItem(
				function(responseData) { 					
		        }, 
				function(jqXHR, timeout, message) { $('#actordetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},

	_initializeFormFields: function(anActorDTOAdapter)
	{
		var useridPickerValue = null;
		
		if (anActorDTOAdapter)
		{
			$('#actordetailactionform_actorid').html(anActorDTOAdapter.dataBean.actorid);
			$('#actordetailactionform_firstname').val(anActorDTOAdapter.dataBean.firstname);
			$('#actordetailactionform_lastname').val(anActorDTOAdapter.dataBean.lastname);
			$('#actordetailactionform_email').val(anActorDTOAdapter.dataBean.email);
			$('#actordetailactionform_cellphone').val(anActorDTOAdapter.dataBean.cellphone);
			$('#actordetailactionform_phone').val(anActorDTOAdapter.dataBean.phone);
			$('#actordetailactionform_address').val(anActorDTOAdapter.dataBean.address);
			$('#actordetailactionform_userid').html(anActorDTOAdapter.dataBean.userid);						
			$('#actordetailactionform_town').val(anActorDTOAdapter.dataBean.town);
			$('#actordetailactionform_zipcode').val(anActorDTOAdapter.dataBean.zipcode);			
			$('#actordetailactionform_sysgroups').html(anActorDTOAdapter.getSystemgroupsDescr());
			
//			if (anActorDTOAdapter.dataBean.userid)
//				useridPickerValue = { dtokey: anActorDTOAdapter.dataBean.userid, dtodescr: anActorDTOAdapter.dataBean.userid };
		}						
		
//		$('#actordetailactionform_pickeruserid_cnt').picker(
//		{
//			multiple: false,
//			fieldName: "userid",
//			openPicker: $.r3Utils.hitch(this.actionFormManager, this.actionFormManager.openLogInUserPicker),
//			fieldId: "actordetailactionform_picker_userid",
//			pickerValue: useridPickerValue
//		});
	
						
		$('#gruppi_ms').gmultiselect({ 
			 "fieldName": 'actorgroup',
			 "lutUrl" : org.r3.PageManager.getRESTUrl('GET_UserAndApp_ActorGroups'),
			 "selectedValue": anActorDTOAdapter && anActorDTOAdapter.getNONSystemgroupsAsCSV()
		});
	}

});

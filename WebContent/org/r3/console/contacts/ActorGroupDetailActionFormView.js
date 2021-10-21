$.r3Utils.namespace("org.r3.console.contacts");


org.r3.console.contacts.ActorGroupDetailActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},

	open : function(aGroupId)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/contacts/ActorGroupDetailActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});

		if (aGroupId)
		{
			networkRequestsQueue.push(
			{
				id : "content",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl('GET_ActorGroupDetail', [ aGroupId ]),
				dataType : "json"
			});
		}

		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			var actorGroupDataBean = responseData['content'];
			if (actorGroupDataBean)
			{
				actorGroupDataBean = new org.r3.db.actor.group.ActorGroupDTOAdapter(actorGroupDataBean);
			}

			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));

			$('#actorgroupdetailactionform_form').validate(
			{
				errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
				rules : org.r3.console.contacts.actorgroupdetailactionform_form_validationRules,
				messages : org.r3.console.contacts.actorgroupdetailactionform_form_validationMessages
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
			
			this._initializeFormFields(actorGroupDataBean);
			
			if (actorGroupDataBean == null)
			{
				$('#actorgroupdetailactionform_action_saveitem').click(
						$.r3Utils.hitch(this, this._onCreateItem));
				
				$('#actorgroupdetailactionform_oncreatefields').show();

				org.r3.PageManager.lutManager.populateSelectField(
				{
					"lutUrl" : org.r3.PageManager.getRESTUrl('GET_ActorGroups'),					
					"selectWidget" : $('#actorgroupdetailactionform_createfromgroup'),
					"keepTopNItems": 2
				});
				
				$('#actorgroupdetailactionform_action_delete').hide();
			}
			else
			{				
				$('#actorgroupdetailactionform_action_saveitem').unbind().click(
						$.r3Utils.hitch(this, this._onUpdateItem));

				if (actorGroupDataBean.isGroupprofile('deletable'))
				{
				    $('#actorgroupdetailactionform_action_delete').show();
				    $('#actorgroupdetailactionform_action_delete').unbind().click(
					    	$.r3Utils.hitch(this, this._onDeleteItem));												
				}
				else $('#actorgroupdetailactionform_action_delete').hide();

  				$('#actorgroupdetailactionform_oncreatefields').hide();												
			}
		
			$('#actorgroupdetailactionform_fieldset_message').formmessage({});
			this.show();
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
				function(anActorGroupDTOAdapter) { 
					if (anActorGroupDTOAdapter)
						if (anActorGroupDTOAdapter.isGroupprofile('deletable'))
						{
							$('#actorgroupdetailactionform_action_delete').show();
						}
						else
						{
							$('#actorgroupdetailactionform_action_delete').hide();	
						}
		        }, 
				function(jqXHR, timeout, message) { $('#actorgroupdetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},
	
	_onUpdateItem: function()
	{
		this.actionFormManager.updateItem(
				function(anActorGroupDTOAdapter) { 					
					if (anActorGroupDTOAdapter)
						if (anActorGroupDTOAdapter.isGroupprofile('deletable'))
						{
							$('#actorgroupdetailactionform_action_delete').show();
						}
						else
						{
							$('#actorgroupdetailactionform_action_delete').hide();	
						}
		        }, 
				function(jqXHR, timeout, message) { $('#actorgroupdetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},
	
	_onDeleteItem: function()
	{
		this.actionFormManager.onRemoveGroup();
	},
	
	_initializeFormFields: function(anActorGroupDTOAdapter)
	{
		if (anActorGroupDTOAdapter)
		{
			$('#actorgroupdetailactionform_groupid').html(anActorGroupDTOAdapter.dataBean.groupid + ' - ');
			$('#actorgroupdetailactionform_grouptitle').val(anActorGroupDTOAdapter.dataBean.grouptitle);
			
			var groupProfile = anActorGroupDTOAdapter.getGroupprofile();
			if (groupProfile && groupProfile.length > 0)
			{
				for(var i = 0; i < groupProfile.length; i++)
				{					
					$('#actorgroupdetailactionform_groupprofile_' + groupProfile[i]).prop('checked', true);	
				}								
			}						
		}
		else $("#actorgroupdetailactionform_form input[name='groupprofile']").prop('checked', false);
	}

});

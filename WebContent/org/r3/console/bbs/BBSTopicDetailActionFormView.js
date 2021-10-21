$.r3Utils.namespace("org.r3.console.bbs");


org.r3.console.bbs.BBSTopicDetailActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},

	open : function(aTopicDTOAdapter)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/bbs/BBSTopicDetailActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});

		if (aTopicDTOAdapter)
		{
			networkRequestsQueue.push(
			{
				id : "content",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl('GET_BBSTopicDetail', [ aTopicDTOAdapter.dataBean.topicid ]),
				dataType : "json"
			});
		}

		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			var topicDataBean = responseData['content'];
			if (topicDataBean)
			{
				topicDataBean = new org.r3.db.bbs.bbstopicview.BBSTopicViewDTOAdapter(topicDataBean);
			}

			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));

			$('#topicdetailactionform_form').validate(
			{
				errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
				rules : org.r3.console.bbs.topicdetailactionform_form_validationRules,
				messages : org.r3.console.bbs.topicdetailactionform_form_validationMessages
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
			
			this._initializeFormFields(topicDataBean);
			
			if (topicDataBean == null)
			{
				$('#topicdetailactionform_action_saveitem').click(
						$.r3Utils.hitch(this, this._onCreateItem));
				
				$('#topicdetailactionform_oncreatefields').show();			
				$('#topicdetailactionform_action_delete').hide();
			}
			else
			{				
				$('#topicdetailactionform_action_saveitem').unbind().click(
						$.r3Utils.hitch(this, this._onUpdateItem));

			    $('#topicdetailactionform_action_delete').show();
				$('#topicdetailactionform_action_delete').unbind().click(
					    	$.r3Utils.hitch(this, this._onDeleteItem));												
			}
		
			$('#topicdetailactionform_fieldset_message').formmessage({});
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
				function(responseData) { 
					
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('topicdetailactionform_fieldset_message');
						return false;
					}
					
					return true;
		        }, 
				function(jqXHR, timeout, message) { $('#topicdetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},
	
	_onUpdateItem: function()
	{
		this.actionFormManager.updateItem(
				function(responseData) { 					
		        }, 
				function(jqXHR, timeout, message) { $('#topicdetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},
	
	_onDeleteItem: function()
	{
		this.actionFormManager.onDeleteTopic();
	},
	
	_initializeFormFields: function(aTopicDTOAdapter)
	{
		if (aTopicDTOAdapter)
		{
			$('#topicdetailactionform_topicid_label').html(aTopicDTOAdapter.dataBean.topicid + ' - ');
			$('#topicdetailactionform_topictitle').val(aTopicDTOAdapter.dataBean.topictitle);

			$('#topicdetailactionform_moderatormode_' + aTopicDTOAdapter.dataBean.moderatormode).prop('checked', true);
			$('#topicdetailactionform_cardid').html(aTopicDTOAdapter.dataBean.cardid);

			$('#topicdetailactionform_topicid').val(aTopicDTOAdapter.dataBean.topicid);
			$('#topicdetailactionform_topicid').prop('disabled', true);
		}
		else 
		{
			$("#topicdetailactionform_moderatormode_moderated").prop('checked', true);
			$('#topicdetailactionform_topicid').prop('disabled', false);
		}
	}

});

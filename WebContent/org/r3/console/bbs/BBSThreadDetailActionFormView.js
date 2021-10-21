$.r3Utils.namespace("org.r3.console.bbs");


org.r3.console.bbs.BBSThreadDetailActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},

	open : function(aTopicId, aThreadDTOAdapter)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/bbs/BBSThreadDetailActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});

		if (aThreadDTOAdapter)
		{
			networkRequestsQueue.push(
			{
				id : "content",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl('GET_BBSThreadDetail', [ aTopicId, aThreadDTOAdapter.dataBean.threadid ]),
				dataType : "json"
			});
		}

		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			var threadDataBean = responseData['content'];
			if (threadDataBean)
			{
				threadDataBean = new org.r3.db.bbs.bbsthread.BBSThreadDTOAdapter(threadDataBean);
			}

			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));

			$('#threaddetailactionform_form').validate(
			{
				errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
				rules : org.r3.console.bbs.threaddetailactionform_form_validationRules,
				messages : org.r3.console.bbs.threaddetailactionform_form_validationMessages
			});
			
			this._initializeFormFields(threadDataBean);
			
			if (threadDataBean == null)
			{
				$('#threaddetailactionform_action_saveitem').click(
						$.r3Utils.hitch(this, this._onCreateItem));
				
				$('#threaddetailactionform_oncreatefields').show();			
				$('#threaddetailactionform_action_delete').hide();
			}
			else
			{				
				$('#threaddetailactionform_action_saveitem').unbind().click(
						$.r3Utils.hitch(this, this._onUpdateItem));

			    $('#threaddetailactionform_action_delete').show();
				$('#threaddetailactionform_action_delete').unbind().click(
					    	$.r3Utils.hitch(this, this._onDeleteItem));												
			}
		
			$('#threaddetailactionform_fieldset_message').formmessage({});
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
				function(responseData) 
				{ 					
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('threaddetailactionform_fieldset_message');
						return false;
					}
					
					return true;					
		        }, 
				function(jqXHR, timeout, message) { $('#threaddetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},
	
	_onUpdateItem: function()
	{
		this.actionFormManager.updateItem(
				function(responseData) { 					
		        }, 
				function(jqXHR, timeout, message) { $('#threaddetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},
	
	_onDeleteItem: function()
	{
		this.actionFormManager.onDeleteThread();
	},
	
	_initializeFormFields: function(aThreadDTOAdapter)
	{
		if (aThreadDTOAdapter)
		{
			$('#threaddetailactionform_threadid_label').html(aThreadDTOAdapter.dataBean.threadid + ' - ');
			$('#threaddetailactionform_threadtitle').val(aThreadDTOAdapter.dataBean.threadtitle);
			$('#threaddetailactionform_threadid').val(aThreadDTOAdapter.dataBean.threadid);
			$('#threaddetailactionform_threadid').prop('disabled', true);
		}
		else $('#threaddetailactionform_threadid').prop('disabled', false);
	}

});

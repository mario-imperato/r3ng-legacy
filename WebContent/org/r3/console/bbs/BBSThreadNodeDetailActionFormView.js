$.r3Utils.namespace("org.r3.console.bbs");


org.r3.console.bbs.BBSThreadNodeDetailActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		$('#threadnodedetailactionform_nodetext').ckeditor('destroy');
		this.hide();
	},

	open : function(aTopicId, aThreadId, aParentThreadNodeId, aThreadNodeDTOAdapter)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/bbs/BBSThreadNodeDetailActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});

		if (aThreadNodeDTOAdapter)
		{
			networkRequestsQueue.push(
			{
				id : "content",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl('GET_BBSThreadNodeDetail', [ aTopicId, aThreadId, aThreadNodeDTOAdapter.dataBean.threadnodeid ]),
				dataType : "json"
			});
		}

		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			var threadNodeDataBean = responseData['content'];
			if (threadNodeDataBean)
			{
				threadNodeDataBean = new org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewDTOAdapter(threadNodeDataBean);
			}

			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));

			$('#threadnodedetailactionform_form').validate(
			{
				errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
				rules : org.r3.console.bbs.threadnodedetailactionform_form_validationRules,
				messages : org.r3.console.bbs.threadnodedetailactionform_form_validationMessages
			});
			
			this._initializeFormFields(threadNodeDataBean);
			
			if (threadNodeDataBean == null)
			{
				$('#threadnodedetailactionform_action_saveitem').click(
						$.r3Utils.hitch(this, this._onCreateItem));
				
				$('#threadnodedetailactionform_oncreatefields').show();			
				$('#threadnodedetailactionform_action_delete').hide();
			}
			else
			{				
				$('#threadnodedetailactionform_action_saveitem').unbind().click(
						$.r3Utils.hitch(this, this._onUpdateItem));

			    $('#threadnodedetailactionform_action_delete').show();
				$('#threadnodedetailactionform_action_delete').unbind().click(
					    	$.r3Utils.hitch(this, this._onDeleteItem));												
			}
		
			$('#threadnodedetailactionform_fieldset_message').formmessage({});
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
		        }, 
				function(jqXHR, timeout, message) { $('#threadnodedetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},
	
	_onUpdateItem: function()
	{
		this.actionFormManager.updateItem(
				function(responseData) { 					
		        }, 
				function(jqXHR, timeout, message) { $('#threadnodedetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},
	
	_onDeleteItem: function()
	{
		this.actionFormManager.onDeleteThreadNode();
	},
	
	_initializeFormFields: function(aThreadNodeDTOAdapter)
	{
		$('#threadnodedetailactionform_nodetext').ckeditor( /* { customConfig: '/r3ng/resources/fckeditor_config/bbcode_config.js' } */ );
		
		if (aThreadNodeDTOAdapter)
		{
			$('#threadnodedetailactionform_threadnodeid_label').html(aThreadNodeDTOAdapter.dataBean.threadnodeid + ' - ');
			$('#threadnodedetailactionform_nodetitle').val(aThreadNodeDTOAdapter.dataBean.nodetitle);
			$('#threadnodedetailactionform_nodetext').val(aThreadNodeDTOAdapter.dataBean.nodetext);				
		}
	}

});

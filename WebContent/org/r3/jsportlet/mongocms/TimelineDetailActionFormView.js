$.r3Utils.namespace("org.r3.jsportlet.mongocms");


org.r3.jsportlet.mongocms.TimelineDetailActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},

	open : function(aTimelineDataBean)
	{
        var _self = this;
        
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/mongocms/TimelineDetailActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});
		
		if (aTimelineDataBean)
		{
		networkRequestsQueue.push(
		{
			id : "content",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_TimelineCollection_Detail', [ aTimelineDataBean.dataBean.site, org.r3.Constants.language, aTimelineDataBean.dataBean.timelineid ]),
			dataType : "json"
		});
		}
		
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_m_contentclass_category'));
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_contentclassdef'));		
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			var timelineDataBean = responseData['content'];
			if (timelineDataBean)
			{
				timelineDataBean = new org.r3.db.mongo.timelinecollection.TimelineCollectionDTOAdapter(timelineDataBean);
			}
			
			$(this.htmlContainerId).html(tmpl(responseData['view'], { timelineDTOAdapter : timelineDataBean }));

			// ignore: [],
			$('#timelinedetailactionform_form').validate(
			{				
				errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
				rules : org.r3.jsportlet.mongocms.timelinedetailactionform_validationRules,
				messages : org.r3.jsportlet.mongocms.timelinedetailactionform_validationMessages
			});

			
			$('#timelinedetailactionform_fieldset_message').formmessage({});								
			this._initializeFormFields(timelineDataBean);
								
			if (timelineDataBean)
			{				
				if (timelineDataBean.isDeletable())
				   $('#timelinedetailactionform_action_delete').show();
				else 
				   $('#timelinedetailactionform_action_delete').hide();
					
				$('#timelinedetailactionform_action_delete').click(
						$.r3Utils.hitch(this, this._onDeleteItem));
				
				$('#timelinedetailactionform_action_saveitem').click(
						$.r3Utils.hitch(this, this._onUpdateItem));
			}
			else 
			{
				$('#timelinedetailactionform_action_delete').hide();
				
				$('#timelinedetailactionform_action_saveitem').click(
						$.r3Utils.hitch(this, this._onCreateItem));				
			}

			$('#timelinedetailactionform_action_cancel').click(
					$.r3Utils.hitch(this.actionFormManager, this.actionFormManager.closeTimelinePanel));			
			
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
		var _self = this;						
		
		var theForm = $('#timelinedetailactionform_form');
		org.r3.AjaxUtils.submitForm(
				"POST", 
				org.r3.PageManager.getRESTUrl('POST_Timelines', [ org.r3.Constants.site, org.r3.Constants.language ]),  
				theForm, 
				function(responseData) { 
					// $('#timelinedetailactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' }); 
					var dto = new org.r3.db.mongo.timelinecollection.TimelineCollectionDTOAdapter(responseData);
					_self.actionFormManager.onNewTimelineCreated(dto);
				}, 
				function(jqXHR, timeout, message) { $('#timelinedetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); },
				"org.r3.message.saveconfirm",
		        true);		
	},
	
	_onUpdateItem: function()
	{
		var _self = this;						
		
		var theForm = $('#timelinedetailactionform_form');
		org.r3.AjaxUtils.submitForm(
				"PUT", 
				org.r3.PageManager.getRESTUrl('PUT_TimelineCollectionDetail', [ this.actionFormManager.dataBeanInfo.dataBean.site, org.r3.Constants.language, this.actionFormManager.dataBeanInfo.dataBean.timelineid ]),  
				theForm, 
				function(responseData) { $('#timelinedetailactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' }); }, 
				function(jqXHR, timeout, message) { $('#timelinedetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); },
				"org.r3.message.saveconfirm",
		        true);		
	},

	_onDeleteItem: function()
	{
		var _self = this;						
		
		var theForm = $('#timelinedetailactionform_form');
		org.r3.AjaxUtils.ajaxInvoke(
				"DELETE", 
				org.r3.PageManager.getRESTUrl('DELETE_TimelineCollectionDetail', [ this.actionFormManager.dataBeanInfo.dataBean.site, org.r3.Constants.language, this.actionFormManager.dataBeanInfo.dataBean.timelineid ]),  
				function(responseData) { _self.actionFormManager.closeTimelinePanel(); }, 
				function(jqXHR, timeout, message) { $('#timelinedetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); },
				"org.r3.message.saveconfirm",
		        true);		
	},
	
	_initializeFormFields: function(aTimelineDTOAdapter)
	{
		if (aTimelineDTOAdapter)
		{			
			$('#timelinedetailactionform_timelineid').val(aTimelineDTOAdapter.dataBean.timelineid);
			$('#timelinedetailactionform_title').val(aTimelineDTOAdapter.dataBean.title);
			$('#timelinedetailactionform_description').val(aTimelineDTOAdapter.dataBean.description);			
		}
	}


});

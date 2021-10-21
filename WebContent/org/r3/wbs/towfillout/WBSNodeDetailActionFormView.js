$.r3Utils.namespace("org.r3.wbs.towfillout");


$.r3Utils.namespace("org.r3.wbs.towfillout");


org.r3.wbs.towfillout.WBSNodeDetailActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		
		this.wbsId = null;
		this.wbsNodeId = null;		
	},

	close : function()
	{	
		this.hide();
	},

	refresh: function()
	{
        $("#wbsnodeactionform_form").resetForm();
        $('#wbsnodeactionform_form_tsentryid').val("");        
	},
	
	open : function(aWbsId, aWbsNodeId)
	{
		var _self = this;

		this.wbsId = aWbsId;
		this.wbsNodeId = aWbsNodeId;

		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];		

		networkRequestsQueue.push(
		{
			id : "wbsdetail",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl("GET_WBS", [ aWbsId ]),
			dataType : "json"
		});
		
		networkRequestsQueue.push(
		{
			id : "wbsnodedetail",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl("GET_WBSNode", [ aWbsId, aWbsNodeId ]),
			dataType : "json"
		});			
		
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/wbs/towfillout/WBSNodeDetailActionFormView.html.jsp'),
			dataType : "html"
		});
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			
 		    
			var wbsDTOAdapter = responseData['wbsdetail'];
			if (wbsDTOAdapter)
			{
				wbsDTOAdapter = new org.r3.db.wbs.wbs.WBSDTOAdapter(wbsDTOAdapter);					
			}
			
			var wbsNodeDTOAdapter = responseData['wbsnodedetail'];
			if (wbsNodeDTOAdapter)
				wbsNodeDTOAdapter = new org.r3.db.wbs.wbsnode.WBSNodeDTOAdapter(wbsNodeDTOAdapter);			
				
				$(this.htmlContainerId).html(tmpl(responseData['view'], {})); 
				

				$('#wbsnodeactionform_form .r3_datepicker').datepicker({
					format: "dd/mm/yyyy"
				});
		
				var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_Resources");
				org.r3.PageManager.lutManager.populateSelectField(
				{
					"lutUrl" : resolvedUrl,
					"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
					"selectWidget" : $('#wbsnodeactionform_form_resourceid')						
				});
						
				$('#wbsnodeactionform_fieldset_message').formmessage({});
				$('#wbsnodeactionform_action_saveitem').unbind().click($.r3Utils.hitch(this, this._onSaveItem));	
				$('#wbsnodeactionform_action_cancel').unbind().click($.r3Utils.hitch(this, this._onClearForm));	
				
				$('#wbsnodeactionform_form').validate(
				{
					ignore: [],
					errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
					
					rules : org.r3.wbs.towfillout.wbsnodeactionform_form_validationRules,
					messages : org.r3.wbs.towfillout.wbsnodeactionform_form_validationMessages
				});
		    		    
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
	_onClearForm: function()
	{
		$("#wbsnodeactionform_form").resetForm();
        $('#wbsnodeactionform_form_tsentryid').val("");
	},
	
	itemDetail: function(aResourceTimesheetAdapter)
	{
		$('#wbsnodeactionform_form_tsentryid').val(aResourceTimesheetAdapter.dataBean.tsentryid);
		$('#wbsnodeactionform_form_resourceid').val(aResourceTimesheetAdapter.dataBean.resourceid);
		$('#wbsnodeactionform_form_effort').val(aResourceTimesheetAdapter.dataBean.effort);
		$('#wbsnodeactionform_form_startperiod').val(aResourceTimesheetAdapter.getStartperiod());
		$('#wbsnodeactionform_form_endperiod').val(aResourceTimesheetAdapter.getEndperiod());
		
	},
	
	_onSaveItem: function()
	{
        var theForm = $('#wbsnodeactionform_form');
		
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{		
		this.actionFormManager.saveResourceTimesheetEntry(
				theForm,
				this.wbsId, 
				this.wbsNodeId,
				$('#wbsnodeactionform_form_tsentryid').val(),
				function(responseData) { 									
					$('#wbsnodeactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });										
		        }, 
				function(jqXHR, timeout, message) { $('#wbsnodeactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);	
		}	

	}

});

$.r3Utils.namespace("org.r3.wbs.wbsfillout");


$.r3Utils.namespace("org.r3.wbs.wbsfillout");


org.r3.wbs.wbsfillout.WBSNodeDetailActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		
		this.wbsId = null;
		this.wbsNodeId = null;
		
		this.hasCKEditor = false;
	},

	close : function()
	{
		$('#wbsnode_infoLine_page').infoLine('destroy');
		if (this.hasCKEditor) 
			$('#wbsnodeactionform_nodetext').ckeditor('destroy');
		
		this.hide();
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
			id : "wbsnodethread",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl("GET_WBSNode_BBS_Thread", [ aWbsId, aWbsNodeId ]),
			dataType : "json"
		});		
		
		networkRequestsQueue.push(
		{
			id : "view_readonly",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/wbs/wbsfillout/WBSNodeDetailActionFormView_readonly.html.jsp'),
			dataType : "html"
		});

		networkRequestsQueue.push(
		{
			id : "view_editable",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/wbs/wbsfillout/WBSNodeDetailActionFormView_editable.html.jsp'),
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
		    
			var wbsNodeThread = responseData['wbsnodethread'];
			if (wbsNodeThread)
				this.actionFormManager.openBBSThreadPortlet(wbsNodeThread.topicid, wbsNodeThread.threadid);
				
			this.hasCKEditor = false;
			if (wbsNodeDTOAdapter.isEditable() && wbsNodeDTOAdapter.isAssignee(org.r3.PageManager.actorUserProfileInfo))
			{
				$(this.htmlContainerId).html(tmpl(responseData['view_editable'], {})); 
				$('#wbsnodeactionform_nodetext').ckeditor();
				this.hasCKEditor = true;
				$('#wbsnodeactionform_completion_slider').bootstrapSlider({				      
				      value: 0,
				      min: wbsNodeDTOAdapter.getCompletionMinValue(),
				      max: wbsNodeDTOAdapter.getCompletionMaxValue(),
				      slide: function( event, ui ) {
				        $( "#wbsnodeactionform_completion_label" ).html(wbsNodeDTOAdapter.getCompletion(ui.value));
				        $( "#wbsnodeactionform_completion").val(ui.value);
				      }
				}).on('slide', function(e) {
				     $( "#wbsnodeactionform_completion_label" ).html(wbsNodeDTOAdapter.getCompletion(e.value));
				     $( "#wbsnodeactionform_completion").val(e.value);
				});
				
				$('#wbsnodeactionform_fieldset_message').formmessage({});
				$('#wbsnodeactionform_action_saveitem').click($.r3Utils.hitch(this, this._onUpdateItem));	
				
				$('#wbsnodeactionform_form').validate(
				{
					ignore: [],
					errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
					
					rules : org.r3.wbs.wbsfillout.wbsnodeactionform_form_validationRules,
					messages : org.r3.wbs.wbsfillout.wbsnodeactionform_form_validationMessages
				});
			}
			else
			{
				$(this.htmlContainerId).html(tmpl(responseData['view_readonly'], {})); 		    							
			}				

			var infoLine_items = [
			       
			       /* 
   			       { id: "infoline_wbsnodeid", label: org.r3.db.wbs.wbsnode.message.wbsnodeid, value: wbsNodeDTOAdapter.dataBean.wbsnodeid },
   			       { id: "infoline_nodetype", label: org.r3.db.wbs.wbsnode.message.nodetype, value: wbsNodeDTOAdapter.getNodetypeDescr() }	
   			       */
   			];
   			
   			if (wbsNodeDTOAdapter.isAction())
   			{			
   				infoLine_items.push(
   					 { id: "infoline_startdate", label: org.r3.db.wbs.wbsnode.message.startdate, value: wbsNodeDTOAdapter.getStartdate() },
   					 { id: "infoline_duration", label: org.r3.db.wbs.wbsnode.message.duration, value: wbsNodeDTOAdapter.dataBean.duration },
   					 { id: "infoline_enddate", label: org.r3.db.wbs.wbsnode.message.enddate, value: wbsNodeDTOAdapter.getEnddate() }   					 					
   				);
   				
   				if (wbsNodeDTOAdapter.isAssignee(org.r3.PageManager.actorUserProfileInfo))
   				{
   					infoLine_items.push(
   						 { newLine: true, id: "infoline_assignedto", label: org.r3.db.wbs.wbsnode.message.assignee, value: wbsNodeDTOAdapter.getAssignedToUserName() },
   					     { id: "infoline_completion", label: org.r3.db.wbs.wbsnode.message.completiondescr, value: wbsNodeDTOAdapter.getCompletionDescr() },
   		         	     { id: "infoline_completiondate", label: org.r3.db.wbs.wbsnode.message.completiondate, value: wbsNodeDTOAdapter.getCompletionDate() },
   		         	     { newLine: true, id: "infoline_economicvalue", label: org.r3.db.wbs.wbsnode.message.economicvalue, value: wbsNodeDTOAdapter.getEconomicvalue() },
   		         	     { id: "infoline_completioneffort", label: org.r3.db.wbs.wbsnode.message.completioneffort, value: wbsNodeDTOAdapter.getCompletioneffort() },
   		         	     { id: "infoline_completioneffortvalue", label: org.r3.db.wbs.wbsnode.message.completioneffortevalue, value: wbsNodeDTOAdapter.getCompletioneffortEValue() }
		         	     );  
   				}
   			}
			
   			if (true)
   			{
		    $('#wbsnode_infoLine_page').infoLine({
	           	  groupId: "wbsnodeinfo",
	           	  defaultOnEmptyValues: 'skip',
	  	          items: infoLine_items
	  	    });				
   			}
		    
			if (wbsNodeDTOAdapter.isEditable())
			{
				this._initializeFieldsEditableNode(wbsNodeDTOAdapter);
			}
			else
			{
				this._initializeFieldsReadOnlyNode(wbsNodeDTOAdapter);
			}				
		    
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
	_initializeFieldsEditableNode: function(aDtoAdapter)
	{
		$('#wbsnodeactionform_nodename').html(aDtoAdapter.getNodeLabel(true) /*dataBean.nodename*/);
		$('#wbsnodeactionform_nodesummary').html(aDtoAdapter.dataBean.nodesummary);
		$('#wbsnodeactionform_current_completioneffort').val(aDtoAdapter.dataBean.completioneffort || 0);
		
		$('#wbsnodeactionform_nodetext').val(aDtoAdapter.dataBean.nodetext);
		
		var l = aDtoAdapter.dataBean.completiondescr;
		
		if (aDtoAdapter.dataBean.completiondescr)
		    $('#wbsnodeactionform_completioncaption').html(aDtoAdapter.dataBean.completiondescr);
		
		$('#wbsnodeactionform_completion_label').html(aDtoAdapter.getCompletion());
		$( "#wbsnodeactionform_completion").val(aDtoAdapter.dataBean.completion || 0);
		$( "#wbsnodeactionform_completioneffort").val(aDtoAdapter.dataBean.completioneffort || 0);
		$( "#wbsnodeactionform_economicvalue").val(aDtoAdapter.dataBean.economicvalue || 0);
	},

	_initializeFieldsReadOnlyNode: function(aDtoAdapter)
	{
		$('#wbsnodeactionform_nodename').html(aDtoAdapter.getNodeLabel(true) /*dataBean.nodename*/);
		$('#wbsnodeactionform_nodesummary').html(aDtoAdapter.dataBean.nodesummary);
		
		$('#wbsnodeactionform_nodetext').html(aDtoAdapter.dataBean.nodetext);		
	},

	_onUpdateItem: function()
	{
        var theForm = $('#wbsnodeactionform_form');
		
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{
		if (!$('#wbsnodeactionform_nodetext').val())
		{
			org.r3.PageManager.alert("org.r3.wbs.wbsfillout.message.wbstextEmptyConfirmation");
			return ;			
		}
		
		this.actionFormManager.updateWBSNode(
				theForm,
				this.wbsId, 
				this.wbsNodeId,
				function(responseData) { 
					$('#wbsnodeactionform_action_saveitem').prop('disabled', true);										
					$('#wbsnodeactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });										
		        }, 
				function(jqXHR, timeout, message) { $('#wbsnodeactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);	
		}	

	}

});

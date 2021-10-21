$.r3Utils.namespace("org.r3.jsportlet.wbs");


org.r3.jsportlet.wbs.TabWBSNode_Detail_WBSActionFormView  = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, aWBSDtoAdapter)
	{
		var _self = this;		
		this._super(anHtmlActionFormContainerId, anActionFormManager);	
		$('#wbsnodeactionform_fieldset_message').formmessage({});
		
		$('#wbsnodeactionform_form .r3_datepicker').datepicker({
			format: "dd/mm/yyyy"
		});
		
		var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_LoginActorsInGroup", [ 'ACGWORKSHOP' ] );
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : resolvedUrl,
			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#wbsnodeactionform_assignedto'),
			"useBusinessKey": true
		});		
		
//		$('#wbsnodeactionform_assignedto').unbind().change(function(e) {
//			var currentTarget = $(e.currentTarget);
//			var assigneeId = currentTarget.val();
//			if (assigneeId && assigneeId.length > 0)
//			{				
//			var method = "GET";			
//			var restUrl = org.r3.PageManager.getRESTUrl('GET_ActorResourceDetail', [ assigneeId ]);
//			$.ajax({
//				"type" : method,
//				"url" : restUrl,
//				"dataType" : "json",
//				"success" : function(responseData)
//				{
//					$('#wbsnodeactionform_economicvalue3').val(responseData.cost || '0');
//				},
//				"error" : function(jqXHR, timeout, message)
//				{
//					console.error("Errore Deleting Actor Group: ", message);
//				}
//			});
//			}
//
//		});
		
		$('#wbsnodeactionform_nodetype').unbind().change(function(e) 
		{
			var currentTarget = $(e.currentTarget);
			var l = currentTarget.val();
			
			_self._setNodeType(l);
		});		
		
		$('#wbsnodeactionform_completiontype_percentage, #wbsnodeactionform_completiontype_int_pos_range').click(
		function(e)
		{
			var currentTarget = $(e.currentTarget);
			var currentTargetId = currentTarget.attr('id');
					
			if (currentTarget.prop('checked'))
			{
				// Sono sicuro di essere in modalità action. In caso contrario l'evento non dovrebbe accadere 
				// In quanto i radio sono disabilitati.
				_self._setCompletiontypeOnActionNodeType(currentTarget.val());
			}										
		});
		
		$('#wbsnodeactionform_form').validate(
		{
			ignore: [],
			errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
			rules : org.r3.jsportlet.wbs.wbsnodeactionform_form_validationRules,
			messages : org.r3.jsportlet.wbs.wbsnodeactionform_form_validationMessages
		});
		
		$('#wbsnodeactionform_action_saveitem').click($.r3Utils.hitch(this, this._onSaveItem));												
	},
	
    startNodeEditing: function(actionContext)
	{		
		this.actionContext = actionContext;
		switch(actionContext.action)
		{
		case 'none':
			this.hide();			
			break;
			
		case 'add':
			this.show();	
			$('#wbsnodeactionform_action_saveitem').prop('disabled', false);	
			this._startAddingNode();
			break;
			
		case 'update':
			this._initializeFields(actionContext.nodeObj);
			this.show();			
			$('#wbsnodeactionform_action_saveitem').prop('disabled', false);	
			break;			
		}
	},
	
	_startAddingNode: function()
	{
		this._resetForm();		
		this._setNodeType('node');				
	},

	_resetForm: function()
	{
		$('#wbsnodeactionform_nodetype').val('node');
		$('#wbsnodeactionform_stereotype').val('stynone');
		$('#wbsnodeactionform_nodename').val('');
		$('#wbsnodeactionform_assignedto').val('');
		$('#wbsnodeactionform_form_startdate').val('');
		$('#wbsnodeactionform_form_enddate').html('');
		$('#wbsnodeactionform_duration').val('0');
		$('#wbsnodeactionform_completiontype_percentage').prop('checked', true);
		$('#wbsnodeactionform_completiondescr').val('');
		$('#wbsnodeactionform_completion').html('0');
		$('#wbsnodeactionform_completionfrom').val('0');
		$('#wbsnodeactionform_completionto').val('0');
		$('#wbsnodeactionform_nodesummary').val('');
		$('#wbsnodeactionform_completioneffort').val('0');
		$('#wbsnodeactionform_economicvalue').val('0');
		$('#wbsnodeactionform_economicvalue2').val('0');
		$('#wbsnodeactionform_economicvalue3').val('0');		
	},
	
	_initializeFields: function(aNodeObj)
	{
		var aWBSNodeDTOAdapter = aNodeObj.node.nodeUserData;
		$('#wbsnodeactionform_nodetype').val(aWBSNodeDTOAdapter.dataBean.nodetype);		
		$('#wbsnodeactionform_stereotype').val(aWBSNodeDTOAdapter.dataBean.stereotype);
		$('#wbsnodeactionform_nodename').val(aWBSNodeDTOAdapter.dataBean.nodename);
		$('#wbsnodeactionform_assignedto').val(aWBSNodeDTOAdapter.dataBean.assignedto);
		$('#wbsnodeactionform_form_startdate').val(aWBSNodeDTOAdapter.getStartdate());
		$('#wbsnodeactionform_form_enddate').html(aWBSNodeDTOAdapter.getEnddate());
		$('#wbsnodeactionform_duration').val(aWBSNodeDTOAdapter.dataBean.duration  || '0');
		
		$('#wbsnodeactionform_completiontype_' + aWBSNodeDTOAdapter.dataBean.completiontype).prop('checked', true);
		$('#wbsnodeactionform_completiondescr').val(aWBSNodeDTOAdapter.dataBean.completiondescr);
		$('#wbsnodeactionform_completion').html(aWBSNodeDTOAdapter.dataBean.completion || '0');
		$('#wbsnodeactionform_completionfrom').val(aWBSNodeDTOAdapter.dataBean.completionfrom);
		$('#wbsnodeactionform_completionto').val(aWBSNodeDTOAdapter.dataBean.completionto);		

		$('#wbsnodeactionform_nodesummary').val(aWBSNodeDTOAdapter.dataBean.nodesummary);
		$('#wbsnodeactionform_completioneffort').val(aWBSNodeDTOAdapter.dataBean.completioneffort  || '0');
		$('#wbsnodeactionform_economicvalue').val(aWBSNodeDTOAdapter.dataBean.economicvalue  || '0');
		$('#wbsnodeactionform_economicvalue2').val(aWBSNodeDTOAdapter.dataBean.economicvalue2  || '0');
		$('#wbsnodeactionform_economicvalue3').val(aWBSNodeDTOAdapter.dataBean.economicvalue3  || '0');
		
		this._setNodeType(aWBSNodeDTOAdapter.dataBean.nodetype);
	},

	_setCompletiontypeOnActionNodeType: function(aCompletionType)
	{
		var perc = aCompletionType == 'percentage';
		// $('#wbsnodeactionform_completion').prop('disabled', !perc);
		$('#wbsnodeactionform_completionfrom').prop('disabled', perc);			    	
		$('#wbsnodeactionform_completionto').prop('disabled', perc);			    					
	},
	
	_setNodeType: function(aNodeType)
	{
		switch (aNodeType)
		{
		case 'action':
			$('#wbsnodeactionform_assignedto').prop('disabled', false);
			$('#wbsnodeactionform_form_startdate').prop('disabled', false);
			$('#wbsnodeactionform_duration').prop('disabled', false);
			$('#wbsnodeactionform_completiontype_percentage').prop('disabled', false);
			$('#wbsnodeactionform_completiontype_int_pos_range').prop('disabled', false);			
			$('#wbsnodeactionform_completiondescr').prop('disabled', false);
			
			var perc = $('#wbsnodeactionform_completiontype_percentage').prop('checked');
			this._setCompletiontypeOnActionNodeType((perc) ? 'percentage' : 'other');
			
			$('#wbsnodeactionform_completioneffort').prop('disabled', false);
			$('#wbsnodeactionform_economicvalue').prop('disabled', false);
			$('#wbsnodeactionform_economicvalue2').prop('disabled', false);
			$('#wbsnodeactionform_economicvalue3').prop('disabled', false);
			break;
		
		default:
			
			$('#wbsnodeactionform_assignedto').val('');
		    $('#wbsnodeactionform_form_startdate').val('');
		    $('#wbsnodeactionform_form_enddate').html('');
		    $('#wbsnodeactionform_duration').val('0');
		    
			$('#wbsnodeactionform_assignedto').prop('disabled', true);
		    $('#wbsnodeactionform_form_startdate').prop('disabled', true);
		    $('#wbsnodeactionform_duration').prop('disabled', true);

		    $('#wbsnodeactionform_completion').html('0');
            // $('#wbsnodeactionform_completion').prop('disabled', true);
		    
			$('#wbsnodeactionform_completiontype_percentage').prop('checked', true);
			$('#wbsnodeactionform_completiontype_percentage').prop('disabled', true);
			$('#wbsnodeactionform_completiontype_int_pos_range').prop('disabled', true);			
			
			$('#wbsnodeactionform_completionfrom').val('0');
			$('#wbsnodeactionform_completionfrom').prop('disabled', true);
			
			$('#wbsnodeactionform_completionto').val('0');
			$('#wbsnodeactionform_completionto').prop('disabled', true);
			
			$('#wbsnodeactionform_completiondescr').val('');
			$('#wbsnodeactionform_completiondescr').prop('disabled', true);						
			
		    $('#wbsnodeactionform_completioneffort').val('0');
			$('#wbsnodeactionform_completioneffort').prop('disabled', true);
			
		    $('#wbsnodeactionform_economicvalue').val('0');
			$('#wbsnodeactionform_economicvalue').prop('disabled', true);
			
			$('#wbsnodeactionform_economicvalue2').val('0');
			$('#wbsnodeactionform_economicvalue2').prop('disabled', true);	
			
			$('#wbsnodeactionform_economicvalue3').val('0');
			$('#wbsnodeactionform_economicvalue3').prop('disabled', true);	
			break;
		}
	},
	
	_onSaveItem: function()
	{
		var _self = this;
		
		var theForm = $('#wbsnodeactionform_form');
		
		if (theForm.valid() && org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{
		if (this.actionContext.action == 'add')
		{
			this.actionFormManager.createWBSNode(
					this.actionContext,
					function(responseData) {

						var isError = true;
						if (org.r3.PageManager.isRestDTO(responseData))
						{
							 var restDto = new org.r3.RestDTOAdapter(responseData);
							 restDto.showMessage('wbsnodeactionform_fieldset_message');								
						}
						else 
						{
							isError = false;
							$('#wbsnodeactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });	
							$('#wbsnodeactionform_form_enddate').html(responseData.enddate);
							_self.hide();
						}
						
						return isError;
			        }, 
					function(jqXHR, timeout, message) { $('#wbsnodeactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
			);			
		}
		else
		{
			if (this.actionContext.action == 'update')
			{
				this.actionFormManager.updateWBSNode(
						this.actionContext,
						function(responseData) { 
							
							if (org.r3.PageManager.isRestDTO(responseData))
							{
								 var restDto = new org.r3.RestDTOAdapter(responseData);
								 restDto.showMessage('wbsnodeactionform_fieldset_message');								
							}
							else 
							{
								$('#wbsnodeactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });	
								$('#wbsnodeactionform_form_enddate').html(responseData.enddate);
							}
				        }, 
						function(jqXHR, timeout, message) { $('#wbsnodeactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
				);			
			}			
		}
		}		
	}		
	
});

$.r3Utils.namespace("org.r3.console.tow");


org.r3.console.tow.TabWBSNode_Detail_WBSActionFormView  = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, aWBSDtoAdapter)
	{
		var _self = this;		
		this._super(anHtmlActionFormContainerId, anActionFormManager);	
		
		this.wbsId = aWBSDtoAdapter.dataBean.wbsid;
		
		$('#wbsnodeactionform_fieldset_message').formmessage({});
		
		$('#wbsnodeactionform_form .r3_datepicker').datepicker({
			format: "dd/mm/yyyy"
		});
				
		$('#wbsnodeactionform_nodetype').unbind().change(function(e) 
		{
			var currentTarget = $(e.currentTarget);
			var l = currentTarget.val();
			
			_self._setNodeType(l);
		});		
				
		$('#wbsnodeactionform_form').validate(
		{
			ignore: [],
			errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
			rules : org.r3.console.tow.wbsnodeactionform_form_validationRules,
			messages : org.r3.console.tow.wbsnodeactionform_form_validationMessages
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
		this._setNodeType('towgroup');				
	},

	_resetForm: function()
	{
		$('#wbsnodeactionform_nodetype').val('node');
		$('#wbsnodeactionform_nodename').val('');
		$('#wbsnodeactionform_form_startdate').val('');
		$('#wbsnodeactionform_form_enddate').val('');
		$('#wbsnodeactionform_nodesummary').val('');
		
		$('.teameffort').val("");
	},
	
	_initializeFields: function(aNodeObj)
	{
		var aWBSNodeDTOAdapter = aNodeObj.node.nodeUserData;
		$('#wbsnodeactionform_nodetype').val(aWBSNodeDTOAdapter.dataBean.nodetype);		
		$('#wbsnodeactionform_nodename').val(aWBSNodeDTOAdapter.dataBean.nodename);
		$('#wbsnodeactionform_form_startdate').val(aWBSNodeDTOAdapter.getStartdate());
		$('#wbsnodeactionform_form_enddate').val(aWBSNodeDTOAdapter.getEnddate());

		$('#wbsnodeactionform_nodesummary').val(aWBSNodeDTOAdapter.dataBean.nodesummary);
		
		this._setNodeType(aWBSNodeDTOAdapter.dataBean.nodetype);
		
		this._populateTeamMemberSection(aWBSNodeDTOAdapter.dataBean.wbsid, aWBSNodeDTOAdapter.dataBean.wbsnodeid);
	},
	
	_populateTeamMemberSection: function(aWbsId, aWbsNodeId)
	{
		$.ajax(
		{
			"type" : "GET",
			"url" : org.r3.PageManager.getRESTUrl('GET_WBSNode_TeamProfile', [ aWbsId, aWbsNodeId ]),
			"dataType" : "json",
			"success" : function(responseData)
			{
				if (responseData)
				{
					var wbsNodeTeamMemberProfileDTOTableAdapter  = new org.r3.db.DTOTableAdapter(responseData, 
							function(aRowDataBean) { return new org.r3.db.project.wbsnodeteammemberprofile.WBSNodeTeamMemberProfileDTOAdapter(aRowDataBean); });	
					
					var numItems = wbsNodeTeamMemberProfileDTOTableAdapter.getNumberOfItems();
					if (numItems > 0)
					{
				        for(var i = 0; i < numItems; i++)
				        {
				        	var item = wbsNodeTeamMemberProfileDTOTableAdapter.getItem(i);
				        	var fieldId = "#wbsnodeactionform_teameffort_" + item.dataBean.profileid;
				        	$(fieldId).val(item.dataBean.effort);
				        	
				        	if (i == 0)
				        	{
				        		$('#wbsnodeactionform_teameffortunit').val(item.dataBean.uniteffort);	
				        	}
				        }
					}
				}
			},
			"error" : function(jqXHR, timeout, message)
			{
				console.error("_populateTeamMemberSection - Errore Getting Current TeamMember Config: ", message);
			}
		});			
	},
	
	_setNodeType: function(aNodeType)
	{
		$('.teameffort').val("");
		
		switch (aNodeType)
		{
		case 'tow':
			$('#wbsnodeactionform_form_startdate').prop('disabled', false);
			$('#wbsnodeactionform_form_enddate').prop('disabled', false);
			break;
		
		default:
			
		    $('#wbsnodeactionform_form_startdate').val('');
		    $('#wbsnodeactionform_form_enddate').val('');
		    
		    $('#wbsnodeactionform_form_startdate').prop('disabled', true);
		    $('#wbsnodeactionform_form_enddate').prop('disabled', true);

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
							}
				        }, 
						function(jqXHR, timeout, message) { $('#wbsnodeactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
				);			
			}			
		}
		}		
	}		
	
});

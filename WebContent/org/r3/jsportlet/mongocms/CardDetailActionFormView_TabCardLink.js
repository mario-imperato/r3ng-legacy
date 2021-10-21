$.r3Utils.namespace("org.r3.jsportlet.mongocms");


org.r3.jsportlet.mongocms.CardDetailActionFormView_TabCardLink = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, aCardDataBean)
	{
		var _self = this;
		
		this._super(anHtmlActionFormContainerId, anActionFormManager);

		this.linkView = new org.r3.db.mongo.MongoLinkQueryActionFormView(anHtmlActionFormContainerId, this.actionFormManager,
		{
				dataTableId : 'MongoLinkQueryActionFormView',
				showTemplateOnOpen: false,
				htmlTemplateUrl: org.r3.Constants.applicationContext + "/org/r3/jsportlet/mongocms/CardDetailActionFormView_TabCardLink.html",
				// layout : 'fullWidth',
				gradeLevel : 'grade_level1',
				legend : org.r3.jsportlet.mongocms.message.postlinkactionform_form_legend,
				dataTableSource: org.r3.PageManager.getRESTUrl('GET_PostLinks', [  aCardDataBean.dataBean.site, org.r3.Constants.language, aCardDataBean.dataBean.postid ]),
				
				// pannello con l'identificativo del gruppo
				// onInitializationComplete : $.unepUtils.hitch(this,
				// this.populateRiepilogo),
				dataTableColumns : "linkid,name,href",
				requiredLUTs : [ "GET_classifier_sys_recstatus" ],

				onSelected : $.r3Utils.hitch(this, function(aCardPropertyDTOAdapter) { 
					$('#tablink_deleteItem').prop('disabled', false);
					this.propertyDetail(aCardPropertyDTOAdapter);
				}),
				
				onDblClick : null,

				buttons : [
				{
					id : 'tablink_deleteItem',
					label : org.r3.message.action_delete,
					disabled : true,
					onClick : $.r3Utils.hitch(this, this.propertyDelete)
				}
				],
				
				onClearSelection : function() { 
					$('#tablink_deleteItem').prop('disabled', true);
				},
				
				onInitializationComplete: $.r3Utils.hitch(this, function() {

					var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_PostFileImageAttachments", [ aCardDataBean.dataBean.site, org.r3.Constants.language, aCardDataBean.dataBean.postid ] );
					org.r3.PageManager.lutManager.populateSelectField(
					{
						"lutUrl" : resolvedUrl,
						"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
						"selectWidget" : $('#postlinkactionform_refattachmentid'),
						"fnRenderKey": function(itemDTO) { return itemDTO.fileid; },
						"fnRenderText": function(itemDTO) { return itemDTO.name; }
					});

					$('#postlinkactionform_form').validate
			        ({
			        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
			               rules: org.r3.jsportlet.mongocms.postlinkactionform_validationRules,
				           messages: org.r3.jsportlet.mongocms.postlinkactionform_validationMessages    
			        });
					
					
					$('#postlinkactionform_fieldset_message').formmessage({});

					$('#postlinkactionform_authoricon').attr('src', aCardDataBean.getAuthorImgUrl());
					$('#postlinkactionform_authorname').html(aCardDataBean.dataBean.authorname);								
					$('#postlinkactionform_refdate').html(aCardDataBean.getLastmodifiedAsElapsed() + ' - ' + aCardDataBean.getLastmodified());	
					$('#postlinkactionform_cardid_label').html('[' + aCardDataBean.dataBean.postid + ']');
					
					$('#postlinkactionform_action_additem').unbind().click($.r3Utils.hitch(_self, _self.addProperty));
					$('#postlinkactionform_action_updateitem').unbind().click($.r3Utils.hitch(_self, _self.updateProperty));
					$('#postlinkactionform_action_cancel_updateitem').unbind().click($.r3Utils.hitch(_self, _self.cancelUpdateProperty));
					$('#postlinkactionform_action_cancel').unbind().click(function(e) { org.r3.PageManager.back(); });			
									
					_self._setInsertMode();
				})
			});
			
			this.linkView.open();			
		},
			
	    propertyDetail: function(aCardPropertyAdapterDTO)
	    {
	    	$('#postlinkactionform_linkid').attr('value', aCardPropertyAdapterDTO.dataBean.linkid);
			this._setUpdateMode();

        	$('#postlinkactionform_name').val(aCardPropertyAdapterDTO.dataBean.name);        	
            $('#postlinkactionform_href').val(aCardPropertyAdapterDTO.dataBean.href);
            $('#postlinkactionform_refattachmentid').val(aCardPropertyAdapterDTO.dataBean.refattachmentid);			
	    },

	    refresh: function()
	    {
			var aCardDataBean = this.actionFormManager.dataBeanInfo;
			
	    	this.linkView.refresh();
	    	
			var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_PostFileImageAttachments", [ aCardDataBean.dataBean.site, org.r3.Constants.language, aCardDataBean.dataBean.postid ] );
			org.r3.PageManager.lutManager.invalidateLUT(resolvedUrl);
			
			org.r3.PageManager.lutManager.populateSelectField(
			{
				"lutUrl" : resolvedUrl,
				"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
				"selectWidget" : $('#postlinkactionform_refattachmentid'),
				"fnRenderKey": function(itemDTO) { return itemDTO.dataBean.linkid; },
				"fnRenderText": function(itemDTO) { return itemDTO.dataBean.text; }
			});
			
			this._setInsertMode();
	    },
	    
	    propertyDelete: function()
	    {    	
	    	var _self = this;
	    	
    	    var selectedItem = this.linkView.fnGetSelectedDataBean();
		        	    
	    	var cardId = this.actionFormManager.dataBeanInfo.dataBean.postid;
			var attachmentId = selectedItem.dataBean.linkid;
			
			org.r3.AjaxUtils.ajaxInvoke(
					'delete', 
					org.r3.PageManager.getRESTUrl('DELETE_PostLink', [ this.actionFormManager.dataBeanInfo.dataBean.site, org.r3.Constants.language, cardId, attachmentId ]),
					function(responseData)
					{
						_self.actionFormManager.refresh();
						$('#postlinkactionform_form').resetForm();
					},
					false,
					"org.r3.message.deleteconfirm",
					true
			);	
			   	    
	    },
	    
	    addProperty: function()
	    {    	
	    	var _self = this;
	    	
	    	var cardId = this.actionFormManager.dataBeanInfo.dataBean.postid;			
	    	org.r3.AjaxUtils.submitForm(
					'post', 
					org.r3.PageManager.getRESTUrl('POST_PostLink', [ this.actionFormManager.dataBeanInfo.dataBean.site, org.r3.Constants.language, cardId ]),
					$('#postlinkactionform_form'),
					function(responseData)
					{
						if (org.r3.PageManager.isRestDTO(responseData))
						{
							var restDto = new org.r3.RestDTOAdapter(responseData);
							restDto.showMessage('postlinkactionform_fieldset_message');
						}
						else 
						{
							$('#postlinkactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });
						}		
						
				    	_self.linkView.refresh();
				    	$('#postlinkactionform_form').resetForm();
					},
					$.r3Utils.hitch(this, function(message) 
					{		    	
						$('#postlinkactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
					}),
					"org.r3.message.saveconfirm",
					true
			);		    	    	    
	    },	    

	    updateProperty: function()
	    {    		    		    	
	    	var _self = this;
	    	
	    	var cardId = this.actionFormManager.dataBeanInfo.dataBean.postid;			
	    	org.r3.AjaxUtils.submitForm(
					'put', 
					org.r3.PageManager.getRESTUrl('PUT_PostLink', [ this.actionFormManager.dataBeanInfo.dataBean.site, org.r3.Constants.language, cardId,  $('#postlinkactionform_linkid').val() ]),
					$('#postlinkactionform_form'),
					function(responseData)
					{
						if (org.r3.PageManager.isRestDTO(responseData))
						{
							var restDto = new org.r3.RestDTOAdapter(responseData);
							restDto.showMessage('postlinkactionform_fieldset_message');
						}
						else 
						{
							$('#postlinkactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });
						}		
						
				    	_self.linkView.refresh();
				    	_self._setInsertMode();
					},
					$.r3Utils.hitch(this, function(message) 
					{		    	
						$('#postlinkactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
					}),
					"org.r3.message.saveconfirm",
					true
			);		    	    	    
	    },

	    cancelUpdateProperty: function()
	    {
	    	this._setInsertMode();
	    },
	    
	    _setInsertMode: function()
	    {
	    	$('#postlinkactionform_form_linkid').attr('value', "");
	    	$('#postlinkactionform_action_additem').show();
	    	$('#postlinkactionform_action_updateitem').hide();
	    	$('#postlinkactionform_action_cancel_updateitem').hide();
	    	
	    	$('#postlinkactionform_form').resetForm();
	    },
	    
	    _setUpdateMode: function()
	    {
	    	$('#postlinkactionform_action_additem').hide();
	    	$('#postlinkactionform_action_updateitem').show();
	    	$('#postlinkactionform_action_cancel_updateitem').show();
	    }
	    					
});

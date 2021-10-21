$.r3Utils.namespace("org.r3.jsportlet.cmsconsole");


org.r3.jsportlet.cmsconsole.CardDetailActionFormView_TabCardLink = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, aCardDataBean)
	{
		var _self = this;
		
		this._super(anHtmlActionFormContainerId, anActionFormManager);

		this.linkView = new org.r3.db.cms.cardproperty.CardPropertyQueryActionFormView(anHtmlActionFormContainerId, this.actionFormManager,
		{
				dataTableId : 'CardLinkQueryActionFormView',
				showTemplateOnOpen: false,
				htmlTemplateUrl: org.r3.Constants.applicationContext + "/org/r3/jsportlet/cmsconsole/CardDetailActionFormView_TabCardLink.html",
				// layout : 'fullWidth',
				gradeLevel : 'grade_level1',
				legend : org.r3.jsportlet.cmsconsole.message.cardlinkactionform_form_legend,
				dataTableSource: org.r3.PageManager.getRESTUrl('GET_CardPropertyLinks', [ aCardDataBean.dataBean.cardid ]),
				
				// pannello con l'identificativo del gruppo
				// onInitializationComplete : $.unepUtils.hitch(this,
				// this.populateRiepilogo),
				dataTableColumns : "propertyid,propertyname,propertyvalue,propertyrole",
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

					var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_CardImages", [ aCardDataBean.dataBean.cardid ] );
					org.r3.PageManager.lutManager.populateSelectField(
					{
						"lutUrl" : resolvedUrl,
						"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
						"selectWidget" : $('#cardlinkactionform_form_refpropertyid')						
					});

					$('#cardlinkactionform_form').validate
			        ({
			        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
			               rules: org.r3.jsportlet.cmsconsole.cardlinkactionform_form_validationRules,
				           messages: org.r3.jsportlet.cmsconsole.cardlinkactionform_form_validationMessages    
			        });
					
					$('#cardlinkactionform_form_cardid_label').html('[' + aCardDataBean.dataBean.cardid + ']');
					$('#cardlinkactionform_fieldset_message').formmessage({});
					
					$('#cardlinkactionform_action_additem').unbind().click($.r3Utils.hitch(_self, _self.addProperty));
					$('#cardlinkactionform_action_updateitem').unbind().click($.r3Utils.hitch(_self, _self.updateProperty));
					$('#cardlinkactionform_action_cancel_updateitem').unbind().click($.r3Utils.hitch(_self, _self.cancelUpdateProperty));
					$('#cardlinkactionform_action_cancel').unbind().click(function(e) { org.r3.PageManager.back(); });			
									
					_self._setInsertMode();
				})
			});
			
			this.linkView.open();			
		},
			
	    propertyDetail: function(aCardPropertyAdapterDTO)
	    {
	    	$('#cardlinkactionform_form_propertyid').attr('value', aCardPropertyAdapterDTO.dataBean.propertyid);
			this._setUpdateMode();

        	$('#cardlinkactionform_form_propertyname').val(aCardPropertyAdapterDTO.dataBean.propertyname);        	
            $('#cardlinkactionform_form_propertyvalue').val(aCardPropertyAdapterDTO.dataBean.propertyvalue);
            $('#cardlinkactionform_form_refpropertyid').val(aCardPropertyAdapterDTO.dataBean.refpropertyid);			
	    },

	    refresh: function()
	    {
			var aCardDataBean = this.actionFormManager.dataBeanInfo;
			
	    	this.linkView.refresh();
	    	
			var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_CardImages", [ aCardDataBean.dataBean.cardid ] );
			org.r3.PageManager.lutManager.invalidateLUT(resolvedUrl);
			
			org.r3.PageManager.lutManager.populateSelectField(
			{
				"lutUrl" : resolvedUrl,
				"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
				"selectWidget" : $('#cardlinkactionform_form_refpropertyid')						
			});
			
			this._setInsertMode();
	    },
	    
	    propertyDelete: function()
	    {    	
			if (org.r3.PageManager.confirmation("org.r3.message.deleteconfirm"))
			{
				this._setInsertMode();
				
	    	    var selectedItem = this.linkView.fnGetSelectedDataBean();
			    this.actionFormManager.deleteProperty(selectedItem /*, $.r3Utils.hitch(this, function(e) 
			    {		    	
			    	this.linkView.refresh();		    	
			    })*/);
			}	    	    
	    },

	    addProperty: function()
	    {    		    		    		    	
		    this.actionFormManager.addLinkProperty($.r3Utils.hitch(this, function(responseData) 
		    {		    	
				if (org.r3.PageManager.isRestDTO(responseData))
				{
					var restDto = new org.r3.RestDTOAdapter(responseData);
					restDto.showMessage('cardlinkactionform_fieldset_message');
				}
				else 
				{
					$('#cardlinkactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });
				}					

		    	// this.linkView.refresh();
		    	this._setInsertMode();
		    }),
		    
		    $.r3Utils.hitch(this, function(message) 
		    {		    	
				$('#cardlinkactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
		    }));	    	    
	    },

	    updateProperty: function()
	    {    		    		    	
		    this.actionFormManager.updateLinkProperty($('#cardlinkactionform_form_propertyid').val(), $.r3Utils.hitch(this, function(responseData) 
		    {		    	
				if (org.r3.PageManager.isRestDTO(responseData))
				{
					var restDto = new org.r3.RestDTOAdapter(responseData);
					restDto.showMessage('cardlinkactionform_fieldset_message');
				}
				else 
				{
					$('#cardlinkactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });
				}					
		    	
		    	this.linkView.refresh();
		    	this._setInsertMode();
		    }),
		    
		    $.r3Utils.hitch(this, function(message) 
		    {		    	
				$('#cardlinkactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
		    }));	    	    
	    },

	    cancelUpdateProperty: function()
	    {
	    	this._setInsertMode();
	    },
	    
	    _setInsertMode: function()
	    {
	    	$('#cardlinkactionform_form_propertyid').attr('value', "");
	    	$('#cardlinkactionform_action_additem').show();
	    	$('#cardlinkactionform_action_updateitem').hide();
	    	$('#cardlinkactionform_action_cancel_updateitem').hide();
	    	
	    	$('#cardlinkactionform_form').resetForm();
	    },
	    
	    _setUpdateMode: function()
	    {
	    	$('#cardlinkactionform_action_additem').hide();
	    	$('#cardlinkactionform_action_updateitem').show();
	    	$('#cardlinkactionform_action_cancel_updateitem').show();
	    }
	    					
});

$.r3Utils.namespace("org.r3.console.tow");


org.r3.console.tow.TabWBS_WBSActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, aWBSDtoAdapter)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		
		$('#wbsactionform_form').validate(
		{
			ignore: [],
			errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
			rules : org.r3.console.tow.wbsactionform_form_validationRules,
			messages : org.r3.console.tow.wbsactionform_form_validationMessages
		});
								
		$('#wbsactionform_wbstext').ckeditor();
		
		$('#wbsactionform_fieldset_message').formmessage({});
					
		this._initializeFormFields(aWBSDtoAdapter);
		
		if (aWBSDtoAdapter)
			 $('#wbsactionform_action_saveitem').click($.r3Utils.hitch(this, this._onUpdateItem));								
		else $('#wbsactionform_action_saveitem').click($.r3Utils.hitch(this, this._onCreateItem));								

	},
	
	_onCreateItem: function()
	{
		if (!$('#wbsactionform_wbstext').val())
		{
			org.r3.PageManager.alert("org.r3.jsportlet.wbs.message.wbstextEmptyConfirmation");
			return ;			
		}
		
		this.actionFormManager.createWBS(
				function(responseData) { 
					$('#wbsactionform_action_saveitem').prop('disabled', true);										
					$('#wbsactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });										
		        }, 
				function(jqXHR, timeout, message) { $('#wbsactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},

	_onUpdateItem: function()
	{
		if (!$('#wbsactionform_wbstext').val())
		{
			org.r3.PageManager.alert("org.r3.jsportlet.wbs.message.wbstextEmptyConfirmation");
			return ;			
		}
		
		this.actionFormManager.updateWBS(
				function(responseData) { 
					$('#wbsactionform_action_saveitem').prop('disabled', true);										
					$('#wbsactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });										
		        }, 
				function(jqXHR, timeout, message) { $('#wbsactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},
	
	_initializeFormFields: function(aWBSDtoAdapter)
	{
		if (aWBSDtoAdapter)
		{
		   $('#wbsactionform_wbstitle').val(aWBSDtoAdapter.dataBean.wbstitle);	
		   $('#wbsactionform_wbstext').val(aWBSDtoAdapter.dataBean.wbstext);
		   $('#wbsactionform_bbstopicid').html(aWBSDtoAdapter.dataBean.bbstopicid);		   
		}
		else
		{
		}
	}
	
	
		
});
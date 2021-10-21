$.r3Utils.namespace("org.r3.jsportlet.wbs");


org.r3.jsportlet.wbs.TabWBS_WBSActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, aWBSDtoAdapter)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		
		$('#wbsactionform_form').validate(
		{
			ignore: [],
			errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
			rules : org.r3.jsportlet.wbs.wbsactionform_form_validationRules,
			messages : org.r3.jsportlet.wbs.wbsactionform_form_validationMessages
		});
								
		$('#wbsactionform_wbstext').ckeditor();
		
		$('#wbsactionform_fieldset_message').formmessage({});
					
		this._initializeFormFields(aWBSDtoAdapter);
		
		var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_LoginActorsInGroup", [ 'ACGWSEXECS' ] );
		var wbsManager = aWBSDtoAdapter && aWBSDtoAdapter.getManager();
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : resolvedUrl,
			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#wbsactionform_wbsmanager'),
			"selectedValue": wbsManager && wbsManager.dataBean.actorid,
			"useBusinessKey": true
		});
		
		var wbsSponsor = aWBSDtoAdapter && aWBSDtoAdapter.getSponsor();
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : resolvedUrl,
			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#wbsactionform_wbssponsor'),
			"selectedValue": wbsSponsor && wbsSponsor.dataBean.actorid,
			"useBusinessKey": true
		});

		var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_LoginActorsInGroup", [ 'ACGWSCOACHES' ] );
		var wbsCoach = aWBSDtoAdapter && aWBSDtoAdapter.getCoach();
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : resolvedUrl,
			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#wbsactionform_wbscoach'),
			"selectedValue": wbsCoach && wbsCoach.dataBean.actorid,
			"useBusinessKey": true
		});

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
		   
		   var optionsSelected = aWBSDtoAdapter.getOptionsAsArray();
			if (optionsSelected)
			{
			    for(var i = 0; i < optionsSelected.length; i++)	
			    {
			    	$('#wbsactionform_options_' + optionsSelected[i]).prop('checked', true); 
			    }
			}			
		}
		else
		{
			$('#wbsactionform_options_' + 'notify').prop('checked', true); 
			$('#wbsactionform_options_' + 'discussion').prop('checked', true); 
		}
	}
	
	
		
});
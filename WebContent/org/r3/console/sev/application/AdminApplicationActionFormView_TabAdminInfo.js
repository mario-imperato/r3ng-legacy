$.r3Utils.namespace("org.r3.console.sev.application");

org.r3.console.sev.application.AdminApplicationActionFormView_TabAdminInfo = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, applicationDTOAdapter)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
						
			$("#adminapplicationactionform_form").validate
            ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.console.sev.application.adminapplicationform_form_validationRules,
		           messages: org.r3.console.sev.application.adminapplicationform_form_validationMessages    
	        });

			this._initializeFormFields(applicationDTOAdapter);
			
			$('#adminapplicationactionform_fieldset_message').formmessage({});
			
			$("#adminapp_cloneform_form").validate
            ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.console.sev.application.adminapp_cloneform_validationRules,
		           messages: org.r3.console.sev.application.adminapp_cloneform_validationMessages    
	        });
			
			$('#adminapp_cloneform_fieldset_message').formmessage({});			
			
			$('#adminapplicationactionform_action_clone').unbind().click($.r3Utils.hitch(this, this.onCloneApplicationClick));
			$('#adminapp_cloneform_action_cancelsubmit').unbind().click($.r3Utils.hitch(this, this.onCloneApplicationFormCancelActionClick));
			$('#adminapp_cloneform_action_submit').unbind().click($.r3Utils.hitch(this, this.onCloneApplicationFormSubmitActionClick));
						
			$('#adminapplicationactionform_action_view').unbind().click($.r3Utils.hitch(this, this.onViewApplicationClick));
			$('#adminapplicationactionform_action_edit').unbind().click($.r3Utils.hitch(this, this.onEditApplicationClick));
			$('#adminapplicationactionform_action_delete').unbind().click($.r3Utils.hitch(this, this.onDeleteApplicationClick));
			
			
			$('#adminapplicationactionform_action_saveadminchecks').unbind().click($.r3Utils.hitch(this, this.onSaveAdminChecksClick));
			
	},

	_initializeFormFields: function(anApplicationDTOAdapter)
	{
		var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_admincks');		
		org.r3.PageManager.lutManager.populateCheckBoxGroup(
		{
  	      	  "lutUrl": resolvedUrl,
  	      	  "groupContainer": $('#adminapplicationactionform_adminchecks_cnt'),
  	      	  "groupId":   "adminapplicationactionform_adminchecks",
  	      	  "groupName": "adminchecks",
  	      	  "value"    :  anApplicationDTOAdapter && anApplicationDTOAdapter.dataBean.adminchecks,
  	      	  "labelSize":  220
		});
		
		$('#adminapplicationactionform_completionstatus').val(anApplicationDTOAdapter && anApplicationDTOAdapter.dataBean.completionstatus);
		
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_verificat'),
			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#adminapplicationactionform_verificationstatus'),
			"selectedValue": anApplicationDTOAdapter && anApplicationDTOAdapter.dataBean.verificationstatus
		});

		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : org.r3.PageManager.getRESTUrl('LUT_SiblingSailEvent', [ 'cvfonline' ]),
			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#adminapp_cloneform_cloneeventid'),
			"selectedValue": null
		});
		
		if (anApplicationDTOAdapter)
		   $('#adminapplicationactionform_annotation').val(anApplicationDTOAdapter.dataBean.annotation);
		
	},
	
	onViewApplicationClick: function()
	{
		this.actionFormManager.viewApplication();
	},

	onEditApplicationClick: function()
	{
		this.actionFormManager.editApplication();
	},
	
	onCloneApplicationClick: function()
	{
	     $('#adminapp_cloneform_actionform').show();
	     $('#adminapplicationactionform_action_clone').hide();
	},
	
	onCloneApplicationFormSubmitActionClick: function(event)
	{
		var _self = this;
		var urlRequested =  'POST_SEV_ConsoleApplication_CloneApplication';
		
		this.actionFormManager.doProcessApplicationInput(
				'post', 
				urlRequested, 
				$("#adminapp_cloneform_form"), 
				function(responseData) { 
					if (org.r3.PageManager.isRestDTO(responseData))
					{						
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('adminapp_cloneform_fieldset_message');
					}
					else 
					{						
						$('#adminapp_cloneform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });
					}						
				}, 
				function(jqXHR, timeout, message) { $('#adminapp_cloneform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); });
		
		event.preventDefault();		
	},
	
	onCloneApplicationFormCancelActionClick: function()
	{
		$('#adminapp_cloneform_actionform').hide();
	     $('#adminapplicationactionform_action_clone').show();
	},
	
	onDeleteApplicationClick: function()
	{
		if (!org.r3.PageManager.confirmation("org.r3.message.deleteconfirm"))
			return ;
		
		this.actionFormManager.deleteApplication('delete', 'DELETE_SEV_Application', 
				function(responseData) { 
					if (org.r3.PageManager.isRestDTO(responseData))
					{						
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('adminapplicationactionform_fieldset_message');
					}
					else 
					{						
						$('#adminapplicationactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });
					}			
		        }, 
				function(jqXHR, timeout, message) { $('#adminapplicationactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); });
		
		event.preventDefault();		
	},
	
	onSaveAdminChecksClick : function(event)
	{
		this.actionFormManager.doProcessApplicationInput('put', 'PUT_SEV_Application_AdminChecksInfo', $('#adminapplicationactionform_form'), 
				function(responseData) { 
					if (org.r3.PageManager.isRestDTO(responseData))
					{						
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('adminapplicationactionform_fieldset_message');
					}
					else 
					{						
						$('#adminapplicationactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });
					}			
		        }, 
				function(jqXHR, timeout, message) { $('#adminapplicationactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); });
		
		event.preventDefault();
	}
	
		
});

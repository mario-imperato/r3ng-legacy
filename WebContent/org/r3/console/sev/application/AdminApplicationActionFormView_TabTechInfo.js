$.r3Utils.namespace("org.r3.console.sev.application");

org.r3.console.sev.application.AdminApplicationActionFormView_TabTechInfo = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, applicationDTOAdapter)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
						

			$("#adminraceinfoapplicationactionform_form").validate
            ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.console.sev.application.adminraceinfoapplicationactionform_form_validationRules,
		           messages: org.r3.console.sev.application.adminraceinfoapplicationactionform_form_validationMessages    
	        });

			this._initializeFormFields(applicationDTOAdapter);
			
			$('#adminraceinfoapplicationactionform_fieldset_message').formmessage({});
			
			$('#adminapplicationactionform_action_saveadminraceinfo').unbind().click($.r3Utils.hitch(this, this.onSaveAdminRaceInfoClick));
			
	},
	
	_initializeFormFields: function(anApplicationDTOAdapter)
	{
		$('#adminapplicationactionform_yachtbsf').val(anApplicationDTOAdapter && anApplicationDTOAdapter.dataBean.yachtbsf);
		$('#adminapplicationactionform_yachtgph').val(anApplicationDTOAdapter && anApplicationDTOAdapter.dataBean.yachtgph);
		
	
        $('#adminapplicationactionform_adminracegrooup_cascade select').cascadingSelect({
	      	   lutManager : org.r3.PageManager.lutManager,
	      	   ajaxUrlMode: 'restful',
	      	   withNullOption: true,
	      	   widgetConfig: [
	      	      { 'widgetId': 'adminapplicationactionform_adminracegroup', 
	      	    	'ajaxSource': org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_boatgroup'),
	      	    	'value': anApplicationDTOAdapter && (anApplicationDTOAdapter.dataBean.adminracegroup || anApplicationDTOAdapter.dataBean.racegroup)
	      	      },
	      	    	
	      	      { 'widgetId': 'adminapplicationactionform_adminraceclass' , 
	      	    	'ajaxSource': org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_racegroup_raceclass'), 
	      	    	'value': anApplicationDTOAdapter && (anApplicationDTOAdapter.dataBean.adminraceclass || anApplicationDTOAdapter.dataBean.raceclass)
	      	      }
	      	   ]
	    });

	},
		
	onSaveAdminRaceInfoClick: function(event)
	{
		this.actionFormManager.doProcessApplicationInput('put', 'PUT_SEV_Application_AdminRaceInfo', $('#adminraceinfoapplicationactionform_form'), 
				function(responseData) { 
					if (org.r3.PageManager.isRestDTO(responseData))
					{						
						var restDto = new org.r3.RestDTOAdapter(responseData);
						restDto.showMessage('adminraceinfoapplicationactionform_fieldset_message');
					}
					else 
					{						
						$('#adminraceinfoapplicationactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });
					}						
				}, 
				function(jqXHR, timeout, message) { $('#adminraceinfoapplicationactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); });
		
		event.preventDefault();		
	}
		
});

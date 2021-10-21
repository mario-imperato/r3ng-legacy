$.r3Utils.namespace("org.r3.console.sev.application");

org.r3.console.sev.application.AdminApplicationActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.tabAdminInfo = null;
		this.tabTechInfo = null;
		this.tabCrewInfo = null;
	},

	close : function()
	{
		$('#infoLine_page').infoLine('destroy');
		this.hide();
	},
	
	refresh: function()
	{
		console.info("Option to refresh!");
	},
	
	open : function(anApplicationId)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/sev/application/AdminApplicationActionFormView.html.jsp'),
			dataType : "html"
		});

		networkRequestsQueue.push(
		{
			id : "application_content",
			"type" : "get",
			"url" : org.r3.PageManager.getRESTUrl('GET_SEV_Application_Detail', [ anApplicationId ]),
			"dataType" : "json"
		});
		
		networkRequestsQueue.push(
		{
			id : "view_tabadmininfo",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/sev/application/AdminApplicationActionFormView_TabAdminInfo.html.jsp'),
			dataType : "html"
		});

		networkRequestsQueue.push(
		{
			id : "view_tabtechinfo",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/sev/application/AdminApplicationActionFormView_TabTechInfo.html.jsp'),
			dataType : "html"
		});

		networkRequestsQueue.push(
		{
			id : "pkg_fiv_properties",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_FIV_SiteProperties'),
			dataType : "json"
		});
		
//		networkRequestsQueue.push(
//		{
//			id : "view_tabcrewinfo",
//			type : "Get",
//			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/sev/application/AdminApplicationActionFormView_TabCrewInfo.html.jsp'),
//			dataType : "html"
//		});
		
		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_SailEvent'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	
			
			$(this.htmlContainerId).html(responseData['view']);												
			
			var applicationDTOAdapter = responseData['application_content'];
			if (applicationDTOAdapter)
			{
				applicationDTOAdapter = new org.r3.db.sailevent.application.SailApplicationDTOAdapter(applicationDTOAdapter);
				this.actionFormManager.applicationDTOAdapter = applicationDTOAdapter;
			}
			else this.actionFormManager.applicationDTOAdapter = null;
						
			$('#adminApplicationActionForm_tab_admininfo').html(responseData['view_tabadmininfo']);
			this.tabAdminInfo = new org.r3.console.sev.application.AdminApplicationActionFormView_TabAdminInfo('UNUSED', this.actionFormManager, applicationDTOAdapter);

			$('#adminApplicationActionForm_tab_techinfo').html(responseData['view_tabtechinfo']);			
			this.tabTechInfo  = new org.r3.console.sev.application.AdminApplicationActionFormView_TabTechInfo('UNUSED', this.actionFormManager, applicationDTOAdapter);

			// $('#adminApplicationActionForm_tab_crewinfo').html(responseData['view_tabcrewinfo']);			
			this.tabCrewInfo  = new org.r3.console.sev.application.AdminApplicationActionFormView_TabCrewInfo('UNUSED', this.actionFormManager, applicationDTOAdapter, responseData['pkg_fiv_properties']);

//			$("#adminapplicationactionform_form").validate
//            ({
//	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
//	               rules: org.r3.console.sev.application.adminapplicationform_form_validationRules,
//		           messages: org.r3.console.sev.application.adminapplicationform_form_validationMessages    
//	        });
//
//			$("#adminraceinfoapplicationactionform_form").validate
//            ({
//	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
//	               rules: org.r3.console.sev.application.adminraceinfoapplicationactionform_form_validationRules,
//		           messages: org.r3.console.sev.application.adminraceinfoapplicationactionform_form_validationMessages    
//	        });
//
//			this._initializeFormFields(applicationDTOAdapter);
//			
//			$('#adminapplicationactionform_fieldset_message').formmessage({});
//			$('#adminraceinfoapplicationactionform_fieldset_message').formmessage({});
//			
//			$('#adminapplicationactionform_action_view').unbind().click($.r3Utils.hitch(this, this.onViewApplicationClick));
//			$('#adminapplicationactionform_action_edit').unbind().click($.r3Utils.hitch(this, this.onEditApplicationClick));
//			$('#adminapplicationactionform_action_saveadminchecks').unbind().click($.r3Utils.hitch(this, this.onSaveAdminChecksClick));
//			$('#adminapplicationactionform_action_saveadminraceinfo').unbind().click($.r3Utils.hitch(this, this.onSaveAdminRaceInfoClick));
			
		    $('#infoLine_page').infoLine({
		             	  groupId: "sailapplication",
		    	          items: [
		    	         	     { id: "infoline_applicationid", label: "Id.", value: applicationDTOAdapter.dataBean.applicationid },
		    	         	     { id: "infoline_userid", label: "User Id.", value: applicationDTOAdapter.dataBean.userid },
		    	         	     { id: "infoline_nickname", label: "Nickname.", value: applicationDTOAdapter.dataBean.nickname || 'n.d.' },
		    	         	     { id: "infoline_createtimestamp", label: "Creata il", value: applicationDTOAdapter.getCreatetimestamp() || 'n.d.' },
		    	         	     { id: "infoline_committimestamp", label: "Chiusa il", value: applicationDTOAdapter.getCommittimestamp() || 'n.d.' },
		    	         	    
		    	         	     { id: "infoline_sailnumber", label: "No.Velico", value: applicationDTOAdapter.dataBean.sailnumber },
		    	         	     { id: "infoline_yachtname", label: "Barca", value: applicationDTOAdapter.dataBean.yachtname },
		    	         	     { id: "infoline_owner", label: "Armatore", value: applicationDTOAdapter.getOwnerlastname() },
		    	         	     { id: "infoline_owneremail", label: "Mail.", value: applicationDTOAdapter.getOwneremail() },
		    	         	     { id: "infoline_ownercell", label: "Tel.", value: applicationDTOAdapter.getOwnercellphone() }		    	         	     
		    	          ] 	
		    });
		    
//			var resolvedUrl = org.r3.PageManager.getRESTUrl('LUT_Country');
//			org.r3.PageManager.lutManager.populateRadioGroup(
//			{
//	  	      	  "lutUrl": resolvedUrl,
//	  	      	  "groupContainer": $('#changeuserpwdform_form_locale_cnt'),
//	  	      	  "groupId":   "changeuserpwdform_form_locale_",
//	  	      	  "groupName": "locale",
//	  	      	  "value"    :  null,
//	  	      	  "labelSize":  280
//			});
			
		    // $('#adminApplicationActionFormTabs').tabs();
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
		
	},
	
//	_initializeFormFields: function(anApplicationDTOAdapter)
//	{
//		var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_admincks');		
//		org.r3.PageManager.lutManager.populateCheckBoxGroup(
//		{
//  	      	  "lutUrl": resolvedUrl,
//  	      	  "groupContainer": $('#adminapplicationactionform_adminchecks_cnt'),
//  	      	  "groupId":   "adminapplicationactionform_adminchecks",
//  	      	  "groupName": "adminchecks",
//  	      	  "value"    :  anApplicationDTOAdapter && anApplicationDTOAdapter.dataBean.adminchecks,
//  	      	  "labelSize":  220
//		});
//		
////      Non la popolo direttamente in quanto debbo eliminare la possibilità della selezione empty..		
////		org.r3.PageManager.lutManager.populateSelectField(
////		{
////			"lutUrl" : org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_completion'),
////			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
////			"selectWidget" : $('#adminapplicationactionform_completionstatus'),
////			"selectedValue": anApplicationDTOAdapter && anApplicationDTOAdapter.dataBean.completionstatus
////		});
//
//		$('#adminapplicationactionform_completionstatus').val(anApplicationDTOAdapter && anApplicationDTOAdapter.dataBean.completionstatus);
//		$('#adminapplicationactionform_yachtbsf').val(anApplicationDTOAdapter && anApplicationDTOAdapter.dataBean.yachtbsf);
//		$('#adminapplicationactionform_yachtgph').val(anApplicationDTOAdapter && anApplicationDTOAdapter.dataBean.yachtgph);
//		
//		org.r3.PageManager.lutManager.populateSelectField(
//		{
//			"lutUrl" : org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_verificat'),
//			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
//			"selectWidget" : $('#adminapplicationactionform_verificationstatus'),
//			"selectedValue": anApplicationDTOAdapter && anApplicationDTOAdapter.dataBean.verificationstatus
//		});
//
//		if (anApplicationDTOAdapter)
//		   $('#adminapplicationactionform_annotation').val(anApplicationDTOAdapter.dataBean.annotation);
//		
//        $('#adminapplicationactionform_adminracegrooup_cascade select').cascadingSelect({
//	      	   lutManager : org.r3.PageManager.lutManager,
//	      	   ajaxUrlMode: 'restful',
//	      	   withNullOption: true,
//	      	   widgetConfig: [
//	      	      { 'widgetId': 'adminapplicationactionform_adminracegroup', 
//	      	    	'ajaxSource': org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_boatgroup'),
//	      	    	'value': anApplicationDTOAdapter && (anApplicationDTOAdapter.dataBean.adminracegroup || anApplicationDTOAdapter.dataBean.racegroup)
//	      	      },
//	      	    	
//	      	      { 'widgetId': 'adminapplicationactionform_adminraceclass' , 
//	      	    	'ajaxSource': org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_racegroup_raceclass'), 
//	      	    	'value': anApplicationDTOAdapter && (anApplicationDTOAdapter.dataBean.adminraceclass || anApplicationDTOAdapter.dataBean.raceclass)
//	      	      }
//	      	   ]
//	    });
//
//	},
//	
//	onViewApplicationClick: function()
//	{
//		this.actionFormManager.viewApplication();
//	},
//
//	onEditApplicationClick: function()
//	{
//		this.actionFormManager.editApplication();
//	},
//
//	onSaveAdminChecksClick : function(event)
//	{
//		this.actionFormManager.doSaveAdminInfo('PUT_SEV_Application_AdminChecksInfo', $('#adminapplicationactionform_form'), 
//				function(responseData) { 
//					if (org.r3.PageManager.isRestDTO(responseData))
//					{						
//						var restDto = new org.r3.RestDTOAdapter(responseData);
//						restDto.showMessage('adminapplicationactionform_fieldset_message');
//					}
//					else 
//					{						
//						$('#adminapplicationactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });
//					}			
//		        }, 
//				function(jqXHR, timeout, message) { $('#adminapplicationactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); });
//		
//		event.preventDefault();
//	},
//	
//	onSaveAdminRaceInfoClick: function(event)
//	{
//		this.actionFormManager.doSaveAdminInfo('PUT_SEV_Application_AdminRaceInfo', $('#adminraceinfoapplicationactionform_form'), 
//				function(responseData) { 
//					if (org.r3.PageManager.isRestDTO(responseData))
//					{						
//						var restDto = new org.r3.RestDTOAdapter(responseData);
//						restDto.showMessage('adminraceinfoapplicationactionform_fieldset_message');
//					}
//					else 
//					{						
//						$('#adminraceinfoapplicationactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });
//					}						
//				}, 
//				function(jqXHR, timeout, message) { $('#adminraceinfoapplicationactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); });
//		
//		event.preventDefault();		
//	}
		
});

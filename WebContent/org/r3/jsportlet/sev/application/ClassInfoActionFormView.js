$.r3Utils.namespace("org.r3.jsportlet.sev.application");


org.r3.jsportlet.sev.application.ClassInfoActionFormView  = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},

	refresh: function()
	{
	},
	
	open : function(anApplicationDTOAdapter, wizardActions, showOnLoad)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");
        console.log("Logged User Is: ", org.r3.PageManager.userInfo);
		var networkRequestsQueue = [];

		// Seleziono la scheda anagrafica dipendente dal tipo di azienda: Impresa, Professione, Utente
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/application/ClassInfoActionFormView.html.jsp'),
			dataType : "html"
		});

		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_locale'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();
			
			$(this.htmlContainerId).html(responseData['view']);		
			if (org.r3.SiteConstants.sailEventApplication && org.r3.SiteConstants.sailEventApplication.classinfoform_apptype == 'bfalse')
			{
			     $('#classinfoform_apptype_framedpanel').hide();
			}
			
			if (org.r3.SiteConstants.sailEventApplication && org.r3.SiteConstants.sailEventApplication.classinfoform_racegroupdecl == 'bfalse')
			{
			     $('#classinfoform_racegroupdecl_fieldrow').hide();
			}
			
			if (org.r3.SiteConstants.sailEventApplication && org.r3.SiteConstants.sailEventApplication.classinfoform_grancrocieraorc == 'btrue')
			{
			     $('#classinfoform_grancrocieraorc_framedpanel').show();
			}
			
			$("#classinfoform_form").validate
            ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.jsportlet.sev.application.classinfoform_form_validationRules,
		           messages: org.r3.jsportlet.sev.application.classinfoform_form_validationMessages    
	        });
			
			this._initializeFormFields(anApplicationDTOAdapter);
						
			$('#classinfoform_action_next').unbind();
		    $('#classinfoform_action_prev').unbind();
			if (wizardActions && wizardActions.indexOf('next') >= 0)
			{
 			      $('#classinfoform_action_next').show().click($.r3Utils.hitch(this, this.onNextClick));	
			}
			else  $('#classinfoform_action_next').hide();
			
			if (wizardActions && wizardActions.indexOf('prev') >= 0)
			{
 			      $('#classinfoform_action_prev').show().click($.r3Utils.hitch(this, this.onPrevClick));	
			}
			else  $('#classinfoform_action_prev').hide();		
			
			$('#classinfoform_fieldset_message').formmessage({});
			
			if (showOnLoad)
				this.activate();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
	_initializeFormFields: function(anApplicationDTOAdapter)
	{
//		org.r3.PageManager.lutManager.populateSelectField(
//		{
//			"lutUrl" : org.r3.PageManager.getRESTUrl('LUT_Country'),
//			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
//			"selectWidget" : $('#companyinfoform_countryid'),
//			"selectedValue": aCompanyDTOAdapter && aCompanyDTOAdapter.dataBean.countryid
//		});						
//								
		$('#classinfoform_applicationid'           ).html(anApplicationDTOAdapter.dataBean.applicationid); 
 	    $('#classinfoform_insuranceid').val(anApplicationDTOAdapter.getPropertyValue('insuranceid', null));
   		$('#classinfoform_insuranceinstitution').val(anApplicationDTOAdapter.getPropertyValue('insuranceinstitution', null));
   		$('#classinfoform_haveinsurance_btrue').prop('checked', anApplicationDTOAdapter.getPropertyValueAsBoolean('haveinsurance'));
   		$('#classinfoform_haveadvertising_btrue').prop('checked', anApplicationDTOAdapter.getPropertyValueAsBoolean('haveadvertising'));
   		   		
		var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_boatgroup');		
		org.r3.PageManager.lutManager.populateRadioGroup(
		{
  	      	  "lutUrl": resolvedUrl,
  	      	  "groupContainer": $('#classinfoform_racegroup_cnt'),
  	      	  "groupId":   "classinfoform_racegroup",
  	      	  "groupName": "racegroup",
  	      	  "value"    :  anApplicationDTOAdapter.dataBean.racegroup,
  	      	  "labelSize":  220
		});

		var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_boatgroup2');		
		org.r3.PageManager.lutManager.populateCheckBoxGroup(
		{
  	      	  "lutUrl": resolvedUrl,
  	      	  "groupContainer": $('#classinfoform_racegroupdecl_cnt'),
  	      	  "groupId":   "classinfoform_racegroupdecl",
  	      	  "groupName": "prop_racegroupdecl",
  	      	  "value"    :  anApplicationDTOAdapter.getPropertyValue('racegroupdecl', null),
  	      	  "labelSize":  500
		});
		
		var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_ranktype');		
		org.r3.PageManager.lutManager.populateCheckBoxGroup(
		{
  	      	  "lutUrl": resolvedUrl,
  	      	  "groupContainer": $('#classinfoform_ranktype_cnt'),
  	      	  "groupId":   "classinfoform_ranktype",
  	      	  "groupName": "prop_ranktype",
  	      	  "value"    :  anApplicationDTOAdapter.getPropertyValue('ranktype', null),
  	      	  "labelSize":  220
		});		
		
		var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_apptype');		
		org.r3.PageManager.lutManager.populateRadioGroup(
		{
  	      	  "lutUrl": resolvedUrl,
  	      	  "groupContainer": $('#classinfoform_apptype_cnt'),
  	      	  "groupId":   "classinfoform_apptype",
  	      	  "groupName": "apptype",
  	      	  "value"    :  anApplicationDTOAdapter.dataBean.apptype,
  	      	  "labelSize":  220
		});

		var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_orcgranc');		
		org.r3.PageManager.lutManager.populateCheckBoxGroup(
		{
  	      	  "lutUrl": resolvedUrl,
  	      	  "groupContainer": $('#classinfoform_grancrocieraorc_cnt'),
  	      	  "groupId":   "classinfoform_grancrocieraorc",
  	      	  "groupName": "prop_grancrocieraorc",
  	      	  "value"    :  anApplicationDTOAdapter.getPropertyValue('grancrocieraorc', null),
  	      	  "labelSize":  500
		});
				
		var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_ratings');		
		org.r3.PageManager.lutManager.populateCheckBoxGroup(
		{
  	      	  "lutUrl": resolvedUrl,
  	      	  "groupContainer": $('#classinfoform_rating_cnt'),
  	      	  "groupId":   "classinfoform_rating",
  	      	  "groupName": "prop_rating",
  	      	  "value"    :  anApplicationDTOAdapter.getPropertyValue('rating', null),
  	      	  "labelSize":  220
		});

		
	},
	
	onDocumentUpload: function()
	{
		this.hide();
		this.actionFormManager.openCrewInfoDocumentUpload();
	},
	
	activate: function()
	{
		this.actionFormManager.showHelp("HLP_SEVCLASSINFO");
		this.show();
	},
	
	onNextClick: function()
	{
		this.actionFormManager.updateClassInfo("next");		
	},
		
	onPrevClick: function()
	{	
		this.actionFormManager.updateClassInfo("prev");		
	}

});

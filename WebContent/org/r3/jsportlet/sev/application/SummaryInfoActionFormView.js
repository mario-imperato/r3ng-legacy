$.r3Utils.namespace("org.r3.jsportlet.sev.application");


org.r3.jsportlet.sev.application.SummaryInfoActionFormView  = org.r3.ActionFormView.extend(
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
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/application/SummaryInfoActionFormView.html.jsp'),
			dataType : "html"
		});

		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_authoriz'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();
			
			$(this.htmlContainerId).html(responseData['view']);		
						
//			$("#summaryinfoform_form").validate
//            ({
//	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
//	               rules: org.r3.jsportlet.sev.summaryinfoform_form_validationRules,
//		           messages: org.r3.jsportlet.sev.summaryinfoform_form_validationMessages    
//	        });
			
			this._initializeFormFields(anApplicationDTOAdapter);
						
			$('#summaryinfoform_action_next').unbind();
		    $('#summaryinfoform_action_prev').unbind();
			if (wizardActions && wizardActions.indexOf('next') >= 0)
			{
 			      $('#summaryinfoform_action_next').show().click($.r3Utils.hitch(this, this.onNextClick));	
			}
			else  $('#summaryinfoform_action_next').hide();
			
			if (wizardActions && wizardActions.indexOf('prev') >= 0)
			{
 			      $('#summaryinfoform_action_prev').show().click($.r3Utils.hitch(this, this.onPrevClick));	
			}
			else  $('#summaryinfoform_action_prev').hide();		
			
			$('#summaryinfoform_fieldset_message').formmessage({});
			
			var cardId = "INFO_REASUMMARYCOMMIT";
			
			
			$('#summaryinfoform_action_end').unbind().click($.r3Utils.hitch(this, this.onEnd));
			$('#summaryinfoform_action_view').unbind().click($.r3Utils.hitch(this, this.onViewApplication));					
			$('#summaryinfoform_action_commit').unbind().click($.r3Utils.hitch(this, this.onCommitApplication));
			
			// In questo caso iniziando con una domanda empty non refresho i dati in locale...
			if (anApplicationDTOAdapter.isDraft() || anApplicationDTOAdapter.isEmpty())
			{				
				cardId = "INFO_REASUMMARYDRAFT";	
				$('#summaryinfoform_action_commit').show();					
			}
			else $('#summaryinfoform_action_commit').hide();
			
			$('#summaryinfoform_card').cmsCard({ "card_tmpl": "cms_tpl_simple", "cardid": cardId});

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
		$('#summaryinfoform_applicationid'           ).html(anApplicationDTOAdapter.dataBean.applicationid); 	
	},
	
	activate: function()
	{
		this.actionFormManager.showHelp("HLP_SEVSUMMARYINFO");
		this.show();
	},
	
	onEnd: function(e)
	{
		this.actionFormManager.endWizard();	
	},
	
	onNextClick: function()
	{
		this.actionFormManager.updateSummaryInfo("next");		
	},
		
	onPrevClick: function()
	{	
		this.actionFormManager.updateSummaryInfo("prev");		
	},
	
	onViewApplication: function()
	{
		this.actionFormManager.viewApplication();
	},
	
	onCommitApplication: function()
	{
		if (org.r3.PageManager.confirmation("org.r3.jsportlet.sev.application.message.commitApplication"))
		{           	
		    this.actionFormManager.commitApplication($.r3Utils.hitch(this, this.onCommitApplicationResponse), this.onAjaxFailResponse);
		}
	},
	
	onCommitApplicationResponse: function(responseData)
	{
		if (org.r3.PageManager.isRestDTO(responseData))
		{						
			var restDto = new org.r3.RestDTOAdapter(responseData);
			restDto.showMessage('summaryinfoform_fieldset_message');
			
			if (restDto.isOk())
			{
				$('#summaryinfoform_action_commit').hide();	
				$('#summaryinfoform_action_prev').hide();
			}
		}
	},
	
	onAjaxFailResponse: function(jqXHR, timeout, message)
	{
		$('#summaryinfoform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
	}

});

$.r3Utils.namespace("org.r3.jsportlet.sev.application");


org.r3.jsportlet.sev.application.PayInfoActionFormView  = org.r3.ActionFormView.extend(
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
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/application/PayInfoActionFormView.html.jsp'),
			dataType : "html"
		});

		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_authoriz'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();
			
			$(this.htmlContainerId).html(responseData['view']);		
						
//			$("#payinfoform_form").validate
//            ({
//	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
//	               rules: org.r3.jsportlet.sev.payinfoform_form_validationRules,
//		           messages: org.r3.jsportlet.sev.payinfoform_form_validationMessages    
//	        });
			
			this._initializeFormFields(anApplicationDTOAdapter);
						
			$('#payinfoform_action_next').unbind();
		    $('#payinfoform_action_prev').unbind();
			if (wizardActions && wizardActions.indexOf('next') >= 0)
			{
 			      $('#payinfoform_action_next').show().click($.r3Utils.hitch(this, this.onNextClick));	
			}
			else  $('#payinfoform_action_next').hide();
			
			if (wizardActions && wizardActions.indexOf('prev') >= 0)
			{
 			      $('#payinfoform_action_prev').show().click($.r3Utils.hitch(this, this.onPrevClick));	
			}
			else  $('#payinfoform_action_prev').hide();		
			
			$('#payinfoform_fieldset_message').formmessage({});
			
			$('#payinfoform_card').cmsCard({ card_tmpl: "cms_tpl_simple", cardid: "INFO_REAPAYINFO"});
			
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
		$('#payinfoform_applicationid'           ).html(anApplicationDTOAdapter.dataBean.applicationid); 	
	},
	
	activate: function()
	{
		this.actionFormManager.showHelp("HLP_SEVPAYINFO");
		this.show();
	},
	
	onNextClick: function()
	{
		this.actionFormManager.updatePayInfo("next");		
	},
		
	onPrevClick: function()
	{	
		this.actionFormManager.updatePayInfo("prev");		
	}

});

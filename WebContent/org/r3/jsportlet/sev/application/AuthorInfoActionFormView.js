$.r3Utils.namespace("org.r3.jsportlet.sev.application");


org.r3.jsportlet.sev.application.AuthorInfoActionFormView  = org.r3.ActionFormView.extend(
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
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/application/AuthorInfoActionFormView.html.jsp'),
			dataType : "html"
		});

		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_authoriz'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();
			
			var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_authoriz');
			var authorizLUT = org.r3.PageManager.lutManager.getLUT(resolvedUrl);

			var templateParams = { 			      
				  widgets: []	
			};
			
			if (authorizLUT && authorizLUT.aaData && authorizLUT.aaData.length > 0)
			{
				for ( var i = 0; i < authorizLUT.aaData.length; i++)
				{
					var item = authorizLUT.aaData[i];
					
					var authorizTrueChecked = anApplicationDTOAdapter.getPropertyValueAsBoolean(item.dtokey);
					
					templateParams.widgets.push({
						id: item.dtokey,
						label: item.dtodescr,
						cardid: item.classifieritemsattr,
						btrue: authorizTrueChecked ? " checked " : "",
						bfalse: authorizTrueChecked ? "" : " checked "
					});
				}	
			}
			
			var templatedHtml = tmpl(responseData['view'], templateParams);
			$(this.htmlContainerId).html(templatedHtml);		
						
			$("#authorinfoform_form").validate
            ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.jsportlet.sev.application.authorinfoform_form_validationRules,
		           messages: org.r3.jsportlet.sev.application.authorinfoform_form_validationMessages    
	        });
			
			$('.authorinfoform_authcard_link').unbind().click($.r3Utils.hitch(this, function(e) {
				var currentTarget = $(e.currentTarget);
				var currentTargetId = currentTarget.attr('id');
				var cardId = currentTargetId.substring('authorinfoform_'.length);
				$('#authorinfoform_authcard').cmsCard({ "card_tmpl": "cms_tpl_simple", "cardid": cardId});
			}));
			
			this._initializeFormFields(anApplicationDTOAdapter);
						
			$('#authorinfoform_action_next').unbind();
		    $('#authorinfoform_action_prev').unbind();
			if (wizardActions && wizardActions.indexOf('next') >= 0)
			{
 			      $('#authorinfoform_action_next').show().click($.r3Utils.hitch(this, this.onNextClick));	
			}
			else  $('#authorinfoform_action_next').hide();
			
			if (wizardActions && wizardActions.indexOf('prev') >= 0)
			{
 			      $('#authorinfoform_action_prev').show().click($.r3Utils.hitch(this, this.onPrevClick));	
			}
			else  $('#authorinfoform_action_prev').hide();		
			
			$('#authorinfoform_fieldset_message').formmessage({});
			
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
		$('#authorinfoform_applicationid'           ).html(anApplicationDTOAdapter.dataBean.applicationid); 
	
		$("#authorinfoform_helmsmanpane .fieldValueCell input[type='text']").prop('disabled', true);
		$('#authorinfoform_havehelmsman_btrue').unbind().click(function(e) {

			var currentTarget = $(e.currentTarget);
			if (currentTarget.prop('checked'))
			{
				$("#authorinfoform_helmsmanpane .fieldValueCell input[type='text']").prop('disabled', false);					
			}
			else
			{
				$("#authorinfoform_helmsmanpane .fieldValueCell input[type='text']").prop('disabled', true);
				$("#authorinfoform_helmsmanpane .fieldValueCell input[type='text']").val("");
			}
			
		});
	},
	
	activate: function()
	{
		this.actionFormManager.showHelp("HLP_SEVAUTHORINFO");
		this.show();
	},
	
	onNextClick: function()
	{
		this.actionFormManager.updateAuthorInfo("next");		
	},
		
	onPrevClick: function()
	{	
		this.actionFormManager.updateAuthorInfo("prev");		
	}

});

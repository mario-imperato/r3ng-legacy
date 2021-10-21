$.r3Utils.namespace("org.r3.jsportlet.sev.application");


org.r3.jsportlet.sev.application.OwnerInfoActionFormView  = org.r3.ActionFormView.extend(
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
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/application/OwnerInfoActionFormView.html.jsp'),
			dataType : "html"
		});

		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_locale'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();
			
			$(this.htmlContainerId).html(responseData['view']);		
						
			$("#ownerinfoform_form").validate
            ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.jsportlet.sev.application.ownerinfoform_form_validationRules,
		           messages: org.r3.jsportlet.sev.application.ownerinfoform_form_validationMessages    
	        });
			
			this._initializeFormFields(anApplicationDTOAdapter);
						
			$('#ownerinfoform_action_next').unbind();
		    $('#ownerinfoform_action_prev').unbind();
			if (wizardActions && wizardActions.indexOf('next') >= 0)
			{
 			      $('#ownerinfoform_action_next').show().click($.r3Utils.hitch(this, this.onNextClick));	
			}
			else  $('#ownerinfoform_action_next').hide();
			
			if (wizardActions && wizardActions.indexOf('prev') >= 0)
			{
 			      $('#ownerinfoform_action_prev').show().click($.r3Utils.hitch(this, this.onPrevClick));	
			}
			else  $('#ownerinfoform_action_prev').hide();		
			
			$('#ownerinfoform_fieldset_message').formmessage({});
			
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
		$('#ownerinfoform_applicationid'           ).html(anApplicationDTOAdapter.dataBean.applicationid); 

		if (anApplicationDTOAdapter.dataBean.owner)
		{
			$('#ownerinfoform_ownerfirstname').val(anApplicationDTOAdapter.dataBean.owner.dataBean.firstname);
			$('#ownerinfoform_ownerlastname').val(anApplicationDTOAdapter.dataBean.owner.dataBean.lastname);
			$('#ownerinfoform_owneremail').val(anApplicationDTOAdapter.dataBean.owner.dataBean.email);
			$('#ownerinfoform_ownercellphone').val(anApplicationDTOAdapter.dataBean.owner.dataBean.cellphone);
			$('#ownerinfoform_ownerphone').val(anApplicationDTOAdapter.dataBean.owner.dataBean.phone);
			$('#ownerinfoform_owneraddress').val(anApplicationDTOAdapter.dataBean.owner.dataBean.address);
			$('#ownerinfoform_ownertown').val(anApplicationDTOAdapter.dataBean.owner.dataBean.town);
			$('#ownerinfoform_ownerzipcode').val(anApplicationDTOAdapter.dataBean.owner.dataBean.zipcode);
		}

		if (anApplicationDTOAdapter.getPropertyValueAsBoolean('havehelmsman'))
		{
			$('#ownerinfoform_havehelmsman_btrue').prop('checked', true);
			
			if (anApplicationDTOAdapter.dataBean.helmsman)
			{
				$('#ownerinfoform_helmsmanfirstname').val(anApplicationDTOAdapter.dataBean.helmsman.dataBean.firstname);
				$('#ownerinfoform_helmsmanlastname').val(anApplicationDTOAdapter.dataBean.helmsman.dataBean.lastname);
				$('#ownerinfoform_helmsmanemail').val(anApplicationDTOAdapter.dataBean.helmsman.dataBean.email);
				$('#ownerinfoform_helmsmancellphone').val(anApplicationDTOAdapter.dataBean.helmsman.dataBean.cellphone);
				$('#ownerinfoform_helmsmanphone').val(anApplicationDTOAdapter.dataBean.helmsman.dataBean.phone);
				$('#ownerinfoform_helmsmanaddress').val(anApplicationDTOAdapter.dataBean.helmsman.dataBean.address);
				$('#ownerinfoform_helmsmantown').val(anApplicationDTOAdapter.dataBean.helmsman.dataBean.town);
				$('#ownerinfoform_helmsmanzipcode').val(anApplicationDTOAdapter.dataBean.helmsman.dataBean.zipcode);				
			}
		}
		else
		{
			$("#ownerinfoform_helmsmanpane .form-group input[type='text']").prop('disabled', true);
		}
		
		$('#ownerinfoform_havehelmsman_btrue').unbind().click(function(e) {

			var currentTarget = $(e.currentTarget);
			if (currentTarget.prop('checked'))
			{
				$("#ownerinfoform_helmsmanpane .form-group input[type='text']").prop('disabled', false);					
			}
			else
			{
				$("#ownerinfoform_helmsmanpane .form-group input[type='text']").prop('disabled', true);
				$("#ownerinfoform_helmsmanpane .form-group input[type='text']").val("");
			}
			
		});
	},
	
	activate: function()
	{
		this.actionFormManager.showHelp("HLP_SEVOWNERINFO");
		this.show();
	},
	
	onNextClick: function()
	{
		this.actionFormManager.updateOwnerInfo("next");		
	},
		
	onPrevClick: function()
	{	
		this.actionFormManager.updateOwnerInfo("prev");		
	}

});

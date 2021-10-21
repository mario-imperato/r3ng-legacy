$.r3Utils.namespace("org.r3.jsportlet.sev.application");


org.r3.jsportlet.sev.application.BoatInfoActionFormView  = org.r3.ActionFormView.extend(
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
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/application/BoatInfoActionFormView.html.jsp'),
			dataType : "html"
		});

		// Lo carico subito in quanto mi serve inizialmente.
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_mooringloc'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();
			
			$(this.htmlContainerId).html(responseData['view']);		
			if (org.r3.SiteConstants.sailEventApplication && org.r3.SiteConstants.sailEventApplication.boatinfoform_otherinfo == 'bfalse')
			{
			     $('#boatinfoform_otherinfo_framedpanel').hide();
			}

			if (org.r3.SiteConstants.sailEventApplication && org.r3.SiteConstants.sailEventApplication.boatinfoform_sailcloth == 'bfalse')
			{
			     $('#boatinfoform_sailcloth_framedpanel').hide();
			}
			
			$("#boatinfoform_form").validate
            ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.jsportlet.sev.application.boatinfoform_form_validationRules,
		           messages: org.r3.jsportlet.sev.application.boatinfoform_form_validationMessages    
	        });
			
			this._initializeFormFields(anApplicationDTOAdapter);
						
			$('#boatinfoform_mooringloc').unbind().change($.r3Utils.hitch(this, function (e)
			{
				var currentTarget = $(e.currentTarget);
				var l = currentTarget.val();
				
				this._updateMooringlogValidatorFlag(l);
			}));
			
			$('#boatinfoform_action_next').unbind();
		    $('#boatinfoform_action_prev').unbind();
			if (wizardActions && wizardActions.indexOf('next') >= 0)
			{
 			      $('#boatinfoform_action_next').show().click($.r3Utils.hitch(this, this.onNextClick));	
			}
			else  $('#boatinfoform_action_next').hide();
			
			if (wizardActions && wizardActions.indexOf('prev') >= 0)
			{
 			      $('#boatinfoform_action_prev').show().click($.r3Utils.hitch(this, this.onPrevClick));	
			}
			else  $('#boatinfoform_action_prev').hide();		
			
			$('#boatinfoform_fieldset_message').formmessage({});
			
			if (showOnLoad)
				this.activate();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	

	_initializeFormFields : function(anApplicationDTOAdapter)
	{
		$('#boatinfoform_applicationid').html(anApplicationDTOAdapter.dataBean.applicationid);

		$('#boatinfoform_plate').val(anApplicationDTOAdapter.dataBean.plate);
		$('#boatinfoform_yachtname').val(anApplicationDTOAdapter.dataBean.yachtname);
		$('#boatinfoform_yachtclub').val(anApplicationDTOAdapter.dataBean.yachtclub);
		$('#boatinfoform_yachttype').val(anApplicationDTOAdapter.dataBean.yachttype);
		$('#boatinfoform_sailnumber').val(anApplicationDTOAdapter.dataBean.sailnumber);

		$('#boatinfoform_designer').val(anApplicationDTOAdapter.getPropertyValue('designer', null));
		$('#boatinfoform_yardship').val(anApplicationDTOAdapter.getPropertyValue('yardship', null));
		$('#boatinfoform_year').val(anApplicationDTOAdapter.getPropertyValue('year', null));
		$('#boatinfoform_harbour').val(anApplicationDTOAdapter.getPropertyValue('harbour', null));
		// $('#boatinfoform_mooringloc').val(anApplicationDTOAdapter.getPropertyValue('mooringloc'));
		$('#boatinfoform_mooringspec').val(anApplicationDTOAdapter.getPropertyValue('mooringspec', null));

		$('#boatinfoform_hullcolor').val(anApplicationDTOAdapter.getPropertyValue('hullcolor', null));
		$('#boatinfoform_loa').val(anApplicationDTOAdapter.getPropertyValue('loa', null));
		$('#boatinfoform_lwl').val(anApplicationDTOAdapter.getPropertyValue('lwl', null));
		$('#boatinfoform_draft').val(anApplicationDTOAdapter.getPropertyValue('draft', null));
		$('#boatinfoform_beam').val(anApplicationDTOAdapter.getPropertyValue('beam', null));

		$('#boatinfoform_carbonstruct').val(anApplicationDTOAdapter.getPropertyValue('carbonstruct', null));
		$('#boatinfoform_otherchanges').val(anApplicationDTOAdapter.getPropertyValue('otherchanges', null));

		$('#boatinfoform_sailmaterialelse').val(anApplicationDTOAdapter.getPropertyValue('sailmaterialelse', null));
		
		var mooringLocation = anApplicationDTOAdapter.dataBean.mooringloc; // .getPropertyValue('mooringloc', null);
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_mooringloc'),
			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#boatinfoform_mooringloc'),
			"selectedValue" : mooringLocation
		});

		this._updateMooringlogValidatorFlag(mooringLocation);
		
		var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_sailmat');
		org.r3.PageManager.lutManager.populateRadioGroup(
		{
			"lutUrl" : resolvedUrl,
			"groupContainer" : $('#boatinfoform_sailmaterial_cnt'),
			"groupId" : "boatinfoform_sailmaterial_",
			"groupName" : "prop_sailmaterial",
			"value" : anApplicationDTOAdapter.getPropertyValue('sailmaterial', null)
		});

		// M201509
		var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_boatelse');
		org.r3.PageManager.lutManager.populateTextBoxGroup(
		{
			"lutUrl" : resolvedUrl,
			"groupContainer" : $('#boatinfoform_otherfeatures_cnt'),
			"groupId" : "boatinfoform_",
			"groupName" : "prop_",
			"getValue" : $.r3Utils.hitch(anApplicationDTOAdapter, anApplicationDTOAdapter.getPropertyValue),
			"template"  : "<div class='form-group'><label class='col-sm-4 control-label' >{%=o.inputFieldTextLabel%}</label><div class='col-sm-8'><input type='text' class='form-control' name='{%=o.inputFieldTextName%}' id='{%=o.inputFieldTextId%}' maxlength='40' /></div></div>"
		});
		
		var checkContainer = $('#boatinfoform_crociera_cnt');
		if (checkContainer.length > 0)
		{
			resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_crociera');
			org.r3.PageManager.lutManager.populateCheckBoxGroup(
			{
				"lutUrl" : resolvedUrl,
				"groupContainer" : $('#boatinfoform_crociera_cnt'),
				"groupId" : "boatinfoform_crociera_",
				"groupName" : "prop_crociera",
				"value" : anApplicationDTOAdapter.getPropertyValue('crociera', null),
				"labelSize" : 380
			});
		}

	},
	
	_updateMooringlogValidatorFlag: function(mooringloc_value)
	{
		var field_value = 'N';
		var hasRequiredHint = $('#boatinfoform_mooringspec_label').hasClass('fieldRequired');
		
		if (mooringloc_value)
		{
			var aLUTItem = org.r3.PageManager.getLUTItem('GET_classifier_r3ea_mooringloc', mooringloc_value);
			if (aLUTItem && aLUTItem.classifieritemsattr && aLUTItem.classifieritemsattr == 'required')
				field_value = 'Y';
		}
		
		if ((field_value == 'Y' && !hasRequiredHint) || (field_value == 'N' && hasRequiredHint))
		{
			$('#boatinfoform_mooringspec_label').toggleClass('fieldRequired');
		}
		
		$('#boatinfoform_mooringspec_validatorflag').val(field_value);
	},
	
	activate: function()
	{
		this.actionFormManager.showHelp("HLP_SEVBOATINFO");
		this.show();
	},
	
	onNextClick: function()
	{
		this.actionFormManager.updateBoatInfo("next");		
	},
		
	onPrevClick: function()
	{	
		this.actionFormManager.updateBoatInfo("prev");		
	}

});

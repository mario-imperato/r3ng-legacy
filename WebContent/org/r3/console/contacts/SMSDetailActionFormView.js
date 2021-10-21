$.r3Utils.namespace("org.r3.console.contacts");


org.r3.console.contacts.SMSDetailActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},

	open : function()
	{
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/contacts/SMSDetailActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});		
		
		networkRequestsQueue.push(
		{
			id : "sms_properties",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_SMS_SiteProperties'),
			dataType : "json"
		});
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			var sms_properties = responseData["sms_properties"];
			if (sms_properties)
			{
				sms_properties = new org.r3.db.DTOTableAdapter(sms_properties, 
						function(aRowDataBean) { return new org.r3.db.system.siteproperty.SitePropertyDTOAdapter(aRowDataBean); });					
			}
			
			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));

			$('#smsdetailactionform_form').validate(
			{
				ignore: [],
				errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
				rules : org.r3.console.contacts.smsdetailactionform_form_validationRules,
				messages : org.r3.console.contacts.smsdetailactionform_form_validationMessages
			});

//			var resolvedUrl = it.posteitaliane.unep.PageManager.getRESTUrl('GET_classifier_sys_recstatus');			
//			var recStatus = (prodottoDataBean) ? prodottoDataBean.dataBean.recstatus : 'sys_recact';
//			it.posteitaliane.unep.PageManager.lutManager.populateRadioGroup(
//			{
//				"lutUrl" : resolvedUrl,
//				"groupContainer" : $('#prodottodetailactionform_form_recstatus_cnt'),
//				"groupId" : "prodottodetailactionform_form_recstatus_",
//				"groupName" : "recstatus",
//				"value" : recStatus
//			});

//			$('#smsdetailactionform_smstext').unbind().change(function(e) {
//				 var item = $(e.currentTarget);
//			     console.info("NumberOf Chars: ", item.val());	
//			});
			
			var textarea = document.getElementById("smsdetailactionform_smstext");
			textarea.onfocus = function() {
			    var initialValue = textarea.value;

			    function testForChange() {
			        if (textarea.value != initialValue) {
			            $('#smsdetailactionform_smstext_numchars').html(textarea.value.length);
			        }
			    }

			    textarea.onblur = function() {
			        window.clearInterval(timer);
			        testForChange();
			        textarea.onblur = null;
			    };

			    var timer = window.setInterval(function() {
			        testForChange();
			    }, 50);
			};
			
			$('#smsdetailactionform_smsopts_charlimit').unbind().click(function(e) {
				$('#smsdetailactionform_smstext').valid();
			});

			$('#smsdetailactionform_smsopts_send2all').unbind().click(function(e) {
				$('#smsdetailactionform_gruppi_actorgroup').valid();
				
				var element = $(e.currentTarget);
				if (element.prop('checked'))
					$('#smsdetailactionform_gruppi_actorgroup').multiselect("disable");
				else
					$('#smsdetailactionform_gruppi_actorgroup').multiselect("enable");	
			});
						
			
			$('#smsdetailactionform_fieldset_message').formmessage({});
						
			this._initializeFormFields(sms_properties);
			
			$('#smsdetailactionform_action_saveitem').unbind().click($.r3Utils.hitch(this, this._onCreateItem));				
			$('#smsdetailactionform_action_checksmscredits').unbind().click($.r3Utils.hitch(this, this._onCheckSMSCredits));				
			
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
	_onCreateItem: function()
	{
		this.actionFormManager.createItem(
				function(responseData) { 
					$('#smsdetailactionform_action_saveitem').prop('disabled', true);					
					var m = $.r3Utils.stringFormat(org.r3.console.contacts.message.numberoftargets, [responseData.numberoftargets]);
					$('#smsdetailactionform_fieldset_message').formmessage('setText', { text: m, category: 'info' });										
		        }, 
				function(jqXHR, timeout, message) { $('#smsdetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},
		
	_onCheckSMSCredits: function()
	{
		var _self = this;
		
		var smsLogin = $('#smsdetailactionform_smslogin');
		var smsPasswd = $('#smsdetailactionform_smspasswd');
		// var smsGroups = $('#smsdetailactionform_gruppi_ms_actorgroup');
		var smsGroups = $('#smsdetailactionform_gruppi_actorgroup');
		var isValid = smsLogin.valid() && smsPasswd.valid() && ($('#smsdetailactionform_smsopts_send2all').prop('checked') || smsGroups.valid()) ; 
		
		if (isValid)
		{			
		
		 this._startComputingSMSCredits();
		this.actionFormManager.checkSMSCredits(
				function(responseData) { 
					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);
						if (restDto.isOk())
						{
							  console.info("Comparazione Valori: ", restDto.counter1 > restDto.counter2);
						      _self._endComputingSMSCredits(restDto.counter1 || '0', restDto.counter2 || '0');							
						}
						else  
						{
							_self._endComputingSMSCredits();
							restDto.showMessage('smsdetailactionform_fieldset_message'); 
						}
					}
		        }, 
				function(jqXHR, timeout, message) { 
		        	_self._endComputingSMSCredits();
		        	$('#smsdetailactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
		}
	},

	_startComputingSMSCredits: function()
	{
		var viewPortWidget = $('#smsdetailactionform_numberofsmscredits');
		viewPortWidget.addClass('ajax-loader');
		viewPortWidget.html('');
		viewPortWidget.show();
		
		$('#smsdetailactionform_fieldset_message').formmessage('clear');
	},

	_endComputingSMSCredits: function(value1, value2)
	{
		var viewPortWidget = $('#smsdetailactionform_numberofsmscredits');
		viewPortWidget.removeClass('ajax-loader');
		
		switch (arguments.length)
		{
		case 0: 
			viewPortWidget.hide();
			break;
		case 1:
			viewPortWidget.html(value1);
			break;
		case 2:
			viewPortWidget.html(value1 + "/" + value2);
			break;
		}		
	},
	
	_initializeFormFields: function(smsPropertiesDataTableAdapter)
	{
		var propertyName = 'sms.smssender';
		var property = smsPropertiesDataTableAdapter.findItem(propertyName);				
		if (property)
		   $('#smsdetailactionform_smssender').val(property.dataBean.propertyvalue);
		
		propertyName = 'sms.smslogin'
		property = smsPropertiesDataTableAdapter.findItem(propertyName);		
		if (property)
		   $('#smsdetailactionform_smslogin').val(property.dataBean.propertyvalue);

		propertyName = 'sms.smspasswd'
		property = smsPropertiesDataTableAdapter.findItem(propertyName);		
		if (property)
		   $('#smsdetailactionform_smspasswd').val(property.dataBean.propertyvalue);

//		$('#smsdetailactionform_gruppi_ms').gmultiselect({ 
//			 "fieldName": 'actorgroup',
//			 "lutUrl" : org.r3.PageManager.getRESTUrl('GET_ActorGroups'),
//			 "selectedValue": null
//		});
		
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : org.r3.PageManager.getRESTUrl('GET_ActorGroups'),
			"selectWidget" : $('#smsdetailactionform_gruppi_actorgroup'),
			"onComplete": function() { $('#smsdetailactionform_gruppi_actorgroup').multiselect(); }
		});
		
		var checkContainer = $('#smsdetailactionform_smsopts_cnt');
		if (checkContainer.length > 0)
		{
			resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_smsoptions');
			org.r3.PageManager.lutManager.populateCheckBoxGroup(
			{
				"lutUrl" : resolvedUrl,
				"groupContainer" : $('#smsdetailactionform_smsopts_cnt'),
				"groupId" : "smsdetailactionform_smsopts_",
				"groupName" : "smsopts",
				"value" : null
			});
		}
	}

});

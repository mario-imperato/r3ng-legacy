$.r3Utils.namespace("org.r3.jsportlet.outmail");


org.r3.jsportlet.outmail.OutMailMessageActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},
	
	open : function(anAttachmentGroupId)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/outmail/OutMailMessageActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});		
		
		networkRequestsQueue.push(
		{
			id : "mail_properties",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_MAIL_SiteProperties'),
			dataType : "json"
		});

		networkRequestsQueue.push(
		{
			id : "outmail_card",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_Card_Detail', [ 'OUTMAIL' ]),
			dataType : "json"
		});

		networkRequestsQueue.push(
		{
			id : "outmail_card_descr",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_CardDescr_Detail', [ 'OUTMAIL', org.r3.Constants.language ]),
			dataType : "json"
		});
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			var mail_properties = responseData["mail_properties"];
			if (mail_properties)
			{
				mail_properties = new org.r3.db.system.siteproperty.SitePropertyDTOTableAdapter(mail_properties, 
						function(aRowDataBean) { return new org.r3.db.system.siteproperty.SitePropertyDTOAdapter(aRowDataBean); });					
			}
			
			var cardDescrDataBean = responseData['outmail_card_descr'];
			if (cardDescrDataBean)
			{
				cardDescrDataBean = new org.r3.db.cms.carddescr.CardDescrDTOAdapter(cardDescrDataBean);		
			}
			
			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));

			$('#outmailmessageactionform_form').validate(
			{
				ignore: [],
				errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
				rules : org.r3.jsportlet.outmail.outmailmessageactionform_form_validationRules,
				messages : org.r3.jsportlet.outmail.outmailmessageactionform_form_validationMessages
			});
			
			$('#outmailmessageactionform_smsopts_charlimit').unbind().click(function(e) {
				$('#outmailmessageactionform_smstext').valid();
			});

			$('#outmailmessageactionform_smsopts_send2all').unbind().click(function(e) {
				$('#outmailmessageactionform_gruppi_actorgroup').valid();
				
				var element = $(e.currentTarget);
				if (element.prop('checked'))
					$('#outmailmessageactionform_gruppi_actorgroup').multiselect("disable");
				else
					$('#outmailmessageactionform_gruppi_actorgroup').multiselect("enable");	
			});
						
			$('#outmailmessageactionform_msgtext').ckeditor();
			
			$('#outmailmessageactionform_fieldset_message').formmessage({});
						
			this._initializeFormFields(mail_properties, anAttachmentGroupId, cardDescrDataBean);
			
			$('#outmailmessageactionform_action_saveitem').click($.r3Utils.hitch(this, this._onCreateItem));								
			
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
		if (!$('#outmailmessageactionform_msgtext').val())
		{
			org.r3.PageManager.alert("org.r3.jsportlet.outmail.message.mailMessageEmptyConfirmation");
			return ;			
		}
		
		this.actionFormManager.createItem(
				function(responseData) { 
					$('#outmailmessageactionform_action_saveitem').prop('disabled', true);					
					var m = $.r3Utils.stringFormat(org.r3.console.contacts.message.numberoftargets, [responseData.numberoftargets]);
					$('#outmailmessageactionform_fieldset_message').formmessage('setText', { text: m, category: 'info' });										
		        }, 
				function(jqXHR, timeout, message) { $('#outmailmessageactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},

	
	_initializeFormFields: function(mailPropertiesDataTableAdapter, anAttachmentGroupId, aCardDTOAdapter)
	{
		var propertyName = 'mail_auth_account';
		var property = mailPropertiesDataTableAdapter.getPropertyByPropertyscopePropertykey("mail", propertyName);
		if (property)
		{
		   $('#outmailmessageactionform_msgfrom_label').html(property.dataBean.propertyvalue);
	       $('#outmailmessageactionform_msgfrom').val(property.dataBean.propertyvalue); 		
		}
				
		$('#outmailmessageactionform_attachmentgroupid').val(anAttachmentGroupId);
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : org.r3.PageManager.getRESTUrl('GET_ActorGroups'),
			"selectWidget" : $('#outmailmessageactionform_gruppi_actorgroup'),
			"onComplete": function() { $('#outmailmessageactionform_gruppi_actorgroup').multiselect(); }
		});
		
		if (aCardDTOAdapter)
		$('#outmailmessageactionform_msgtext').val(aCardDTOAdapter.dataBean.textbody);
		
	}

});

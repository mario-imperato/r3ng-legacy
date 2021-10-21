$.r3Utils.namespace("org.r3.console.contacts");


org.r3.console.contacts.ExportContactsActionFormView = org.r3.ActionFormView.extend(
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
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/contacts/ExportContactsActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});		
				
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();
			
			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));

			$('#exportcontactsactionform_form').validate(
			{
				errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
				rules : org.r3.console.contacts.exportcontactsactionform_form_validationRules,
				messages : org.r3.console.contacts.exportcontactsactionform_form_validationMessages
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
						
			$('#exportcontactsactionform_fieldset_message').formmessage({});
						
			this._initializeFormFields();
			
			$('#exportcontactsactionform_action_export').click($.r3Utils.hitch(this, this._onExportItem));				
			
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
	_onExportItem: function()
	{
		this.actionFormManager.exportItem(
				function(responseData) { 
					var m = $.r3Utils.stringFormat(org.r3.console.contacts.message.numberoftargets, [responseData.numberoftargets]);
					$('#exportcontactsactionform_fieldset_message').formmessage('setText', { text: m, category: 'info' });										
		        }, 
				function(jqXHR, timeout, message) { $('#exportcontactsactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},
			
	_initializeFormFields: function()
	{		
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : org.r3.PageManager.getRESTUrl('GET_ActorGroups'),
			"selectWidget" : $('#exportcontactsactionform_groupid'),
			"onComplete": function() { $('#exportcontactsactionform_groupid').multiselect(org.r3.message.getDefaultMultiSelectOptions()); }
		});		

		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : org.r3.PageManager.getRESTUrl('GET_classifier_actor_expformat'),
			"selectWidget" : $('#exportcontactsactionform_csvformat'),
			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText")			
		});		

		
	}

});

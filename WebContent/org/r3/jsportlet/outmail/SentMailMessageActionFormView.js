$.r3Utils.namespace("org.r3.jsportlet.outmail");


org.r3.jsportlet.outmail.SentMailMessageActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},
	
	open : function(aMailMessageDTOAdapter)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/outmail/SentMailMessageActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});		
		
		networkRequestsQueue.push(
		{
			id : "mail_recipients",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_OUTMAIL_Recipients', [ aMailMessageDTOAdapter.dataBean.messageid ]),
			dataType : "json"
		});
				
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();
			
			var mail_recipients = responseData["mail_recipients"];
			if (mail_recipients)
			{
				mail_recipients = new org.r3.db.DTOTableAdapter(mail_recipients, 
						function(aRowDataBean) { return new org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDTOAdapter(aRowDataBean); });					
			}
			
			$(this.htmlContainerId).html(tmpl(responseData['view'], { message: aMailMessageDTOAdapter, recipientList: mail_recipients }));
									
			$('#outmailmessageactionform_fieldset_message').formmessage({});
						
			this._initializeFormFields(aMailMessageDTOAdapter);
			
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	

	
	_initializeFormFields: function(aMailDtoAdapter)
	{
		$('#sentmailmessageactionform_msgfrom').html(aMailDtoAdapter.dataBean.msgfrom);
		
		if (aMailDtoAdapter.dataBean.msgcc)
		    $('#sentmailmessageactionform_msgcc').html(aMailDtoAdapter.dataBean.msgcc);
		else 
			$('#sentmailmessageactionform_formgroup_msgcc').hide();
		
		if (aMailDtoAdapter.dataBean.msgbcc)
			$('#sentmailmessageactionform_msgbcc').html(aMailDtoAdapter.dataBean.msgbcc);
		else 
			$('#sentmailmessageactionform_formgroup_msgbcc').hide();
		
        $('#sentmailmessageactionform_msgtitle').html(aMailDtoAdapter.dataBean.msgtitle);
	        
        $('#sentmailmessageactionform_msgtext').html(aMailDtoAdapter.getMsgtext());        
                
	}

});

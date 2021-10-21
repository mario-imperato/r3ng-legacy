$.r3Utils.namespace("org.r3.jsportlet.changeuserpwd");

org.r3.jsportlet.changeuserpwd.ChangeUserPasswordActionFormView = org.r3.ActionFormView.extend(
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
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/changeuserpwd/ChangeUserPasswordActionForm.html.jsp'),
			dataType : "html"
		});

		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_SailEvent'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	
			
			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));												

			$("#changeuserpwdform_form").validate
            ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.jsportlet.changeuserpwd.changeuserpwdform_form_validationRules,
		           messages: org.r3.jsportlet.changeuserpwd.changeuserpwdform_form_validationMessages    
	        });

			$('#changeuserpwdButton').unbind().click($.r3Utils.hitch(this, this.onChangeUserPasswordClick));
			$('#changeuserpwdform_fieldset_message').formmessage({});
			
//			var resolvedUrl = org.r3.PageManager.getRESTUrl('LUT_Country');
//			org.r3.PageManager.lutManager.populateRadioGroup(
//			{
//	  	      	  "lutUrl": resolvedUrl,
//	  	      	  "groupContainer": $('#changeuserpwdform_form_locale_cnt'),
//	  	      	  "groupId":   "changeuserpwdform_form_locale_",
//	  	      	  "groupName": "locale",
//	  	      	  "value"    :  null,
//	  	      	  "labelSize":  280
//			});
			
			// this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
		
	},
	
	onChangeUserPasswordClick : function(event)
	{
		console.log("I'm clicked2.... ", this, event);
		this.actionFormManager.doChangeUserPassword();
		event.preventDefault();
	}
		
});

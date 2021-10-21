$.r3Utils.namespace("org.r3.console.contacts");


org.r3.console.contacts.ImportActorsFromChildSiteActionFormView = org.r3.ActionFormView.extend(
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
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/contacts/ImportActorsFromChildSiteActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});

		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));

			$('#importactorgroupfromchildsiteactionform_form').validate(
			{
				errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
				rules : org.r3.console.contacts.importactorgroupfromchildsiteactionform_form_validationRules,
				messages : org.r3.console.contacts.importactorgroupfromchildsiteactionform_form_validationMessages
			});
			
			this._initializeFormFields();
			
			$('#importactorgroupfromchildsiteactionform_action_import').click(
						$.r3Utils.hitch(this, this._onImport));				
		
			$('#importactorgroupfromchildsiteactionform_fieldset_message').formmessage({});
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
	_onImport: function()
	{
		this.actionFormManager.doImport(
				function(responseData) { 
		        }, 
				function(jqXHR, timeout, message) { $('#importactorgroupfromchildsiteactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	},
		
	_initializeFormFields: function()
	{
		org.r3.PageManager.lutManager.populateSelectField(
		{
			"lutUrl" : org.r3.PageManager.getRESTUrl('GET_UserAndApp_ActorGroups'),					
			"selectWidget" : $('#importactorgroupfromchildsiteactionform_actorgroup'),
			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText")
		});	
		
        $('#importactorgroupfromchildsiteactionform_cascade select').cascadingSelect({
	      	   lutManager : org.r3.PageManager.lutManager,
	      	   ajaxUrlMode: 'restful',
	      	   withNullOption: true,
	      	   widgetConfig: [
	      	      { 'widgetId': 'importactorgroupfromchildsiteactionform_sourcesite', 
	      	    	'ajaxSource': org.r3.PageManager.getRESTUrl('LUT_Site_Children'),
	      	    	'value': null 
	      	      },
	      	    	
	      	      { 'widgetId': 'importactorgroupfromchildsiteactionform_sourcegroup' , 
	      	    	'ajaxSource': org.r3.PageManager.getRESTUrl('GET_ActorGroups_4Site', [ org.r3.Constants.language ]), 
	      	    	'value': null
	      	      }
	      	   ]
	    });
		
	}

});

$.r3Utils.namespace("org.r3.console.users");

org.r3.console.users.UserQueryAdvancedSearchActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.executeSearch = null;
	},

	close : function()
	{
		$("#dialog-form").modal("hide");
	},

	show : function(anExecuteSearchFunction)
	{
		$("#dialog-form").modal();
	   	this.executeSearch = anExecuteSearchFunction;
	},

	open : function()
	{
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkInitializationQueue = [];

		networkInitializationQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/users/UserQueryAdvancedSearchActionForm.html'),
			dataType : "html"
		});
				
		org.r3.PageManager.multiAjax(networkInitializationQueue,
 		
		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			$(this.htmlContainerId).html(responseData['view']);

			var actionFormView = this;
//			$("#dialog-form").dialog(
//			{
//				autoOpen : false,
//				height : 250,
//				width : 700,
//				modal : true,
//				buttons :
//				{
//					"Ricerca" : $.r3Utils.hitch(actionFormView, actionFormView.executeAdvancedSearch),
//					"Annulla" : $.r3Utils.hitch(actionFormView, actionFormView.dismissAdvancedSearchDialog)
//				},
//				close : function()
//				{
//				}
//			});
			
			$("#userquery_advancedsearchform_form").validate
            ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.console.users.advancedsearchform_form_validationRules,
		           messages: org.r3.console.users.advancedsearchform_form_validationMessages    
	        });
			
			$('#userquery_advancedsearchform_action_search')
			     .unbind()
			     .click($.r3Utils.hitch(actionFormView, actionFormView.executeAdvancedSearch));
			
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},

	dismissAdvancedSearchDialog : function()
	{
		$("#dialog-form").modal("hide");
	},

	executeAdvancedSearch : function()
	{
		var theForm = $('#userquery_advancedsearchform_form');
		if (!theForm.valid())
		 return;

		var qparams = [];
		qparams.push(
		{
			"name": "nickname", "value" : $('#userquery_advancedsearchform_form_nickname').val()
		});
		qparams.push(
		{
			"name": "userid", "value"  : $('#userquery_advancedsearchform_form_userid').val()
		});
		qparams.push(
		{
			"name": "firstname", "value" : $('#userquery_advancedsearchform_form_firstname').val()
		});
		qparams.push(
		{
			"name": "lastname", "value"  : $('#userquery_advancedsearchform_form_lastname').val()
		});
		qparams.push(
		{
			"name": "email", "value" : $('#userquery_advancedsearchform_form_email').val()
		});

		this.executeSearch(qparams);
		this.dismissAdvancedSearchDialog();
	}
	        	
});

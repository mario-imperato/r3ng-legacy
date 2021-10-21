$.r3Utils.namespace("org.r3.jsportlet.mongocms");

org.r3.jsportlet.mongocms.CardQueryAdvancedSearchActionFormView = org.r3.ActionFormView.extend(
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
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/mongocms/CardQueryAdvancedSearchActionForm.html'),
			dataType : "html"
		});
				
		org.r3.PageManager.multiAjax(networkInitializationQueue,
 		
		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			$(this.htmlContainerId).html(responseData['view']);

			var actionFormView = this;
			
			$("#userquery_advancedsearchform_form").validate
            ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.jsportlet.mongocms.advancedsearchform_form_validationRules,
		           messages: org.r3.jsportlet.mongocms.advancedsearchform_form_validationMessages    
	        });
			
			$('#cardquery_advancedsearchform_action_search')
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
		var theForm = $('#cardquery_advancedsearchform_form');
		if (!theForm.valid())
		 return;

		var qparams = [];

		qparams.push(
		{
			"name" : "postid", "value" : $('#cardquery_advancedsearchform_form_postid').val()
		});

		this.executeSearch(qparams);
		this.dismissAdvancedSearchDialog();
	}
	        	
});

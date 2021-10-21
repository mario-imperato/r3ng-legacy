$.r3Utils.namespace("org.r3.registration");

org.r3.registration.RegistrationOutcomeActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},
	
	open : function(isSuccessFlag)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/registration/RegistrationOutcomeActionForm.html.jsp'),
			dataType : "html"
		});

		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_SailEvent'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	

			$(this.htmlContainerId).html(responseData['view']);	
			
			var title = org.r3.registration.message.failed_activation_title;
			var cardId = 'REGACT_KO';
			if (isSuccessFlag)
			{
				title = org.r3.registration.message.success_activation_title;
				cardId = 'REGACT_OK';	
			}
							
			$('div.legend_title').html(title);
			$(this.htmlContainerId + " .panel_content").cmsCard({ card_tmpl: "cms_tpl_simple", "cardid": cardId});
			$('#registrationoutcome_action_end').unbind().click(function(e) { org.r3.PageManager.redirectToHomePage(); });
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
	}
	
	
});

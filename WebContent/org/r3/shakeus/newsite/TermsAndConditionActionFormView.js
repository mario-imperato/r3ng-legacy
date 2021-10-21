$.r3Utils.namespace("org.r3.shakeus.newsite");

org.r3.shakeus.newsite.TermsAndConditionActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.termsAndConditionsExtendedCardId = null;
	},

	close : function()
	{
		this.hide();
	},
	
	open : function(openParamsHash)
	{
		this.termsAndConditionsExtendedCardId = openParamsHash.termsAndConditionsExtendedCardId;
		
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/shakeus/newsite/TermsAndConditionActionFormView.html'),
			dataType : "html"
		});

		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_SailEvent'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	
						
            var templatedHtml = tmpl(responseData['view'], (openParamsHash != null) ? openParamsHash : {});
			$(this.htmlContainerId).html(templatedHtml);
															
			$('#termsandconditionsdisclaimerForm_accept_action').unbind().click($.r3Utils.hitch(this, this.onAcceptTermsAndConditionsClick));
			$('#termsandconditionsdisclaimerForm_deny_action').unbind().click($.r3Utils.hitch(this, this.onDenyTermsAndConditionsClick));
			$('#termsandconditionsdisclaimerForm_showfull_action').unbind().click($.r3Utils.hitch(this, this.onShofFullTermsAndConditions));
						
			$(this.htmlContainerId + " .termsAndConditionsDisclaimerSummary").cmsCard({ site: org.r3.SiteConstants.sitedomain, card_tmpl: "cms_tpl_embeddedfragments", "cardid": openParamsHash.termsAndConditionsBriefCardId});
			$('#termsandconditions_fieldset_message').formmessage({});
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
	},
	
	onShofFullTermsAndConditions: function(event)
	{
		event.preventDefault();
		$(this.htmlContainerId + " .termsAndConditionsDisclaimerSummary").cmsCard({ site: org.r3.SiteConstants.sitedomain, card_tmpl: "cms_tpl_embeddedfragments", "cardid": this.termsAndConditionsExtendedCardId });		
	},
	
	onAcceptTermsAndConditionsClick : function(event)
	{
		console.log("I'm onAcceptTermsAndConditionsClick.... ", this, event);
		event.preventDefault();
		
		var isCheckBoxSelected = $('#termsandconditionsdisclaimerForm_accept').prop('checked');
		if (!isCheckBoxSelected)
		{
			org.r3.PageManager.alert("org.r3.shakeus.newsite.message.explicitaknowledgerequired");
		}
		else
		{
			this.actionFormManager.onTermsAndConditionAccepted();
		}
	},
	
	onDenyTermsAndConditionsClick : function(event)
	{
		console.log("I'm onDenyTermsAndConditionsClick.... ", this, event);
		org.r3.PageManager.redirectToHomePage();
		event.preventDefault();
	}	
});

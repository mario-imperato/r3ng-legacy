$.r3Utils.namespace("org.r3.jsportlet.newslettersubscription");

org.r3.jsportlet.newslettersubscription.NewsletterSubscriptionActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.newslettersubscription.NewsletterSubscriptionActionFormView(aDetailViewContainerId, this);
		
		this.defaultOptions = { 
				"template": "NewsletterSubscriptionActionForm.html",
		};
		
		this.options = null;
	},

	close : function()
	{
		this.hide();
	},

	hide : function()
	{
		this.detailView.hide();
	},

	show : function()
	{
		this.detailView.show();
	},

	refresh : function()
	{
	},

	open : function(optionsHash)
	{
		if (optionsHash)
		   this.options = $.extend({}, this.defaultOptions, optionsHash);
		else
		   this.options = $.extend({}, this.defaultOptions);

		this.detailView.open(this.options);
	},
	
	doRegistration: function()
	{
		var _self = this;
		
		if ($('#newslettersubscription_form').valid())
		{
			org.r3.PageManager.wait("org.r3.message.waiting");

			var method = "post";
			var restUrl = org.r3.PageManager.getRESTUrl('POST_NewsLetter_Registration');
			$('#newslettersubscription_form').ajaxSubmit(
			{
				"type" : method,
				"url" : restUrl,
				"dataType" : "json",
				"success" : function(responseData)
				{
					org.r3.PageManager.closeNotifier();
					if (org.r3.PageManager.isRestDTO(responseData))
					{						
						var restDto = new org.r3.RestDTOAdapter(responseData);

						if (restDto.isFail())
	                    {
							$('#newslettersubscription_form_fieldset_message').formmessage('setText', { text: restDto.reason, category: 'error' });						
	                    }
						else
						{
							// Non faccio una distinzione in caso di Warning. 
							$(_self.detailView.htmlContainerId + " .panel_content").cmsCard({ card_tmpl: "cms_tpl_simple", cardid: "NEWSLETT_OK"});							
							$(_self.detailView.htmlContainerId + " .panel_action_bar").hide();
						}
						
					}							 																	
										
				},
				"error" : function(jqXHR, timeout, message)
				{
					console.log(arguments);
					org.r3.PageManager.closeNotifier();
					$('#newslettersubscription_form_fieldset_message').formmessage('setText', { text: message, category: 'error' });
				}
			});
		}				
	}
		
});


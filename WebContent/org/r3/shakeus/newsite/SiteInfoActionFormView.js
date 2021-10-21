$.r3Utils.namespace("org.r3.shakeus.newsite");

org.r3.shakeus.newsite.SiteInfoActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);		
		this.configOptions = null;
	},

	close : function()
	{
		this.hide();
	},
	
	open : function(openParamsHash)
	{		
		this.configOptions = openParamsHash;
		
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/shakeus/newsite/SiteInfoActionFormView.html'),
			dataType : "html"
		});

		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_SailEvent'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	
						
            var templatedHtml = tmpl(responseData['view'], 
            		(openParamsHash != null) ? 
            		{
            	       title: org.r3.PageManager.getMessageFromDict(openParamsHash.messagesNamespace + ".message.createNewProfile_siteInfoTitle"),
            	       subtitle: org.r3.PageManager.getMessageFromDict(openParamsHash.messagesNamespace + ".message.createNewProfile_siteInfoSubTitle"),
            	       sitecode: org.r3.PageManager.getMessageFromDict(openParamsHash.messagesNamespace + ".message.createNewProfile_sitecode"),
            	       sitedescr: org.r3.PageManager.getMessageFromDict(openParamsHash.messagesNamespace + ".message.createNewProfile_sitedescr"),
            	       sitetype: openParamsHash.sitetype
            		} : { });
            
			$(this.htmlContainerId).html(templatedHtml);
											
			$('#siteinfoform_form').validate(
			{				
				errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
				rules : org.r3.shakeus.newsite.siteinfoform_validationRules,
				messages : org.r3.shakeus.newsite.siteinfoform_validationMessages
			});
			
			$('#siteinfoform_confirm_action').unbind().click($.r3Utils.hitch(this, this.onConfirmClick));
			$('#siteinfoform_cancel_action').unbind().click($.r3Utils.hitch(this, this.onCancelClick));
						
			$(this.htmlContainerId + " .siteCodeDescriptionCard").cmsCard({ site: org.r3.SiteConstants.sitedomain, card_tmpl: "cms_tpl_embeddedfragments", "cardid": openParamsHash.siteCodeDescriptionCardId});
			$('#siteinfoform_fieldset_message').formmessage({});
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
	},
	
	
	onConfirmClick : function(event)
	{
		var _self = this;
		
		event.preventDefault();
		
		org.r3.AjaxUtils.submitForm(
				"post", 
				org.r3.PageManager.getRESTUrl('POST_ShakeUs_NewSite'), 
				$("#siteinfoform_form"), 
				function(responseData) { 

					if (org.r3.PageManager.isRestDTO(responseData))
					{
						var restDto = new org.r3.RestDTOAdapter(responseData);					
						restDto.showMessage('siteinfoform_fieldset_message', _self.configOptions.messagesNamespace);
					}
					else
					{
						var createdSite = new org.r3.db.system.site.SiteDTOAdapter(responseData);
						_self.actionFormManager.onSiteCreationRequestPosted(createdSite);
					}
				},
				function(jqXHR, timeout, message) { 
				
					console.error(message); 
					$('#siteinfoform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
					
				}, 
				"org.r3.message.saveconfirm", 
				true);		
		
	},
	
	onCancelClick : function(event)
	{
		org.r3.PageManager.redirectToHomePage();
		event.preventDefault();
	}	
});

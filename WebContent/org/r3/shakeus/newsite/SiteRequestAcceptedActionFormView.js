$.r3Utils.namespace("org.r3.shakeus.newsite");

org.r3.shakeus.newsite.SiteRequestAcceptedActionFormView = org.r3.ActionFormView.extend(
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
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/shakeus/newsite/SiteRequestAcceptedActionFormView.html'),
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
            	       title: org.r3.PageManager.getMessageFromDict(openParamsHash.messagesNamespace + ".message.createNewProfileTitle"),
            	       subtitle: org.r3.PageManager.getMessageFromDict(openParamsHash.messagesNamespace + ".message.createNewProfileSubTitle")
            	    } : { });
            
			$(this.htmlContainerId).html(templatedHtml);
	        
			$(this.htmlContainerId + ' .newSiteRequestAcceptedCard').cmsCard({ site: org.r3.SiteConstants.sitedomain, card_tmpl: "cms_tpl_embeddedfragments", "cardid":this.configOptions.siteCreatedCardId});	
						
			$('#newsiterequestaccepted_gotosite_action').unbind().click($.r3Utils.hitch(this, this.onGotoSiteClick));
						
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
	},
			
	onGotoSiteClick : function(event)
	{
		var createdSiteId = this.configOptions.siteCreated.dataBean.site;
		var homePage = org.r3.Constants.getStrutsActionContext(createdSiteId) + "/org/r3/home.do";
		org.r3.PageManager.gotoPage(homePage);
		event.preventDefault();
	}	
});

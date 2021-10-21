$.r3Utils.namespace("org.r3.console.siteconfig.site");


org.r3.console.siteconfig.site.SiteDetailActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.tabGenerale = null;
		this.tabCardFile = null;
		this.tabCardGraphics = null;
	},

	close : function()
	{
		this.hide();
	},

	refresh: function()
	{
		if (this.tabCardFile)
		   this.tabCardFile.refresh();
		
		if (this.tabGenerale)
		   this.tabGenerale.refresh();
		
		if (this.tabCardGraphics)
			   this.tabCardGraphics.refresh();		
		
	},
	
	open : function()
	{
		var currentSite = org.r3.Constants.site;
		
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];

		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/siteconfig/site/SiteDetailActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});

		networkRequestsQueue.push(
		{
			id : "content",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_SiteDetail', [ currentSite ]),
			dataType : "json"
		});

		networkRequestsQueue.push(
		{
			id : "content_sail_event",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_SailEventDetail', [ currentSite ]),
			dataType : "json"
		});
			
		networkRequestsQueue.push(
		{
			id : "view_tabgenerale",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/siteconfig/site/SiteDetailActionFormView_TabGenerale.html.jsp'),
			dataType : "html"
		});

		networkRequestsQueue.push(
		{
			id : "view_tabgraphics",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/siteconfig/site/SiteDetailActionFormView_TabCardGraphics.html.jsp'),
			dataType : "html"
		});
		
		
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_sys_recstatus'));
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_locale'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			var siteDataBean = responseData['content'];
			if (siteDataBean)
			{
				siteDataBean = new org.r3.db.system.site.SiteDTOAdapter(siteDataBean);								
			}

			var sailEventDataBean = responseData['content_sail_event'];
			if (sailEventDataBean)
			{
				sailEventDataBean = new org.r3.db.sailevent.event.SailEventDTOAdapter(sailEventDataBean);
			}
			
			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));			

			$('#siteDetailActionForm_tab_generale').html(tmpl(responseData['view_tabgenerale'], {}));			
			this.tabGenerale = new org.r3.console.siteconfig.site.SiteDetailActionFormView_TabGenerale('__UNUSED__', this.actionFormManager, siteDataBean, sailEventDataBean);

		    this.tabCardFile = new org.r3.console.siteconfig.site.SiteDetailActionFormView_TabCardFile('#siteDetailActionForm_tab_cardfile', this.actionFormManager, siteDataBean);
			
		    if (org.r3.SiteConstants.is10Gen())
			{
		    $('#siteDetailActionForm_tab_sitegraphics').html(tmpl(responseData['view_tabgraphics'], {}));					    			
		    this.graphicActionFormView = new org.r3.jsportlet.imageupload.ImageUploadActionFormView('#graphicsactionform_uploadimage_canvas', this);
		    this.tabCardGraphics = new org.r3.console.siteconfig.site.SiteDetailActionFormView_TabCardGraphics('__UNUSED__', this.actionFormManager, this.graphicActionFormView);
			}
		    
			// $('#siteDetailActionFormTabs').tabs();
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	}
	
	
});

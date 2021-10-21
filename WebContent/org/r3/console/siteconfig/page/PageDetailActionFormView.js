$.r3Utils.namespace("org.r3.console.siteconfig.page");


org.r3.console.siteconfig.page.PageDetailActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.tabGenerale = null;
		this.tabCardText = null;
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
	},
	
	open : function(aPageDTOAdapter)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");
        console.log("Logged User Is: ", org.r3.PageManager.userInfo);
		var networkRequestsQueue = [];

		if (aPageDTOAdapter)
		{
			networkRequestsQueue.push(
			{
				id : "view",
				type : "Get",
				url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/siteconfig/page/PageDetailActionFormView.html.jsp?mode=detail'),
				dataType : "html"
			});

			networkRequestsQueue.push(
			{
				id : "content",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl('GET_Page_Detail', [ aPageDTOAdapter.dataBean.pageid ]),
				dataType : "json"
			});

			networkRequestsQueue.push(
			{
				id : "view_tabpagetext",
				type : "Get",
				url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/siteconfig/page/PageDetailActionFormView_TabPageText.html'),
				dataType : "html"
			});
			
			networkRequestsQueue.push(
			{
				id : "content_descr",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl('GET_PageDescr_Detail', [ aPageDTOAdapter.dataBean.pageid, org.r3.Constants.language ]),
				dataType : "json"
			});

		}
		else
		{
			networkRequestsQueue.push(
			{
				id : "view",
				type : "Get",
				url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/siteconfig/page/PageDetailActionFormView.html.jsp?mode=create'),
				dataType : "html"
			});			
		}

		networkRequestsQueue.push(
		{
			id : "view_tabgenerale",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/siteconfig/page/PageDetailActionFormView_TabGenerale.html'),
			dataType : "html"
		});
				
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_sys_recstatus'));
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_locale'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			var pageDataBean = responseData['content'];
			if (pageDataBean)
			{
				pageDataBean = new org.r3.db.cms.page.PageDTOAdapter(pageDataBean);								
			}

			var pageDescrDataBean = responseData['content_descr'];
			if (pageDescrDataBean)
			{
				pageDescrDataBean = new org.r3.db.cms.pagedescr.PageDescrDTOAdapter(pageDescrDataBean);		
			}
			
			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));			

			$('#pageDetailActionForm_tab_generale').html(tmpl(responseData['view_tabgenerale'], {}));			
			this.tabGenerale = new org.r3.console.siteconfig.page.PageDetailActionFormView_TabGenerale('__UNUSED__', this.actionFormManager, pageDataBean);

			if (pageDataBean)
            {
			    $('#pageDetailActionForm_tab_pagetext').html(tmpl(responseData['view_tabpagetext'], {}));
			    this.tabPageText = new org.r3.console.siteconfig.page.PageDetailActionFormView_TabPageText('__UNUSED__', this.actionFormManager, pageDataBean, pageDescrDataBean);
            }
			
			// $('#pageDetailActionFormTabs').tabs();
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	}
	
	
});

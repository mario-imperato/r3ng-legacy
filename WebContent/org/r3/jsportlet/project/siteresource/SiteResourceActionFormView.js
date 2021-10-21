$.r3Utils.namespace("org.r3.jsportlet.project.siteresource");

org.r3.jsportlet.project.siteresource.SiteResourceActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, openMode)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.openMode = openMode || 'default';
	},

	close : function()
	{
		this.hide();
	},
	
	open : function(aResourceId)
	{
		if (this.openMode == 'default') org.r3.PageManager.wait("org.r3.message.waiting");
		
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/project/siteresource/SiteResourceActionForm.html.jsp'),
			dataType : "html"
		});
		
		networkRequestsQueue.push(
		{
			id : "content",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_ActorResourceDetail', [ aResourceId ]),
			dataType : "json"
		});
		
		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_SailEvent'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			if (this.openMode == 'default') org.r3.PageManager.closeNotifier();			 	
			
			var resourceDTOAdapter = responseData['content'];
			if (resourceDTOAdapter)
			{
				resourceDTOAdapter = new org.r3.db.project.siteresource.SiteResourceDTOAdapter(resourceDTOAdapter);
			}
						
			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));
			this._initializeFields(resourceDTOAdapter);
			
			$("#siteresourceform_form").validate
            ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.jsportlet.project.siteresource.siteresourceform_validationRules,
		           messages: org.r3.jsportlet.project.siteresource.siteresourceform_validationMessages    
	        });

			$('#siteresourceform_fieldset_message').formmessage({});
			$('#siteresourceform_action_save').unbind().click($.r3Utils.hitch(this, this._onSaveItem));
			
			if (this.openMode == 'default')  this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
	},
	
	_initializeFields: function(aResourceDTOAdapter)
	{
		if (aResourceDTOAdapter)
		{
		   $('#siteresourceform_evalueunit').val(aResourceDTOAdapter.dataBean.evalueunit);
		   $('#siteresourceform_cost').val(aResourceDTOAdapter.dataBean.cost);
		   $('#siteresourceform_price').val(aResourceDTOAdapter.dataBean.price);
		}
	},
	
	_onSaveItem: function()
	{
		this.actionFormManager.updateSiteResource(
				function(responseData) { 
					$('#siteresourceform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });
		        }, 
				function(jqXHR, timeout, message) { $('#siteresourceform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); }				
		);
	}
	
});

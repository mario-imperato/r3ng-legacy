$.r3Utils.namespace("org.r3.shkadmin.siteconfig");


org.r3.shkadmin.siteconfig.SiteInfoActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},

	open : function()
	{
        var _self = this;
        
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/shkadmin/siteconfig/SiteInfoActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});
		
		networkRequestsQueue.push(
		{
			id : "content",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_SiteCollection_Detail', [ org.r3.Constants.site ]),
			dataType : "json"
		});


		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			var siteDataBean = responseData['content'];
			if (siteDataBean)
			{
				siteDataBean = new org.r3.db.mongo.sitecollection.SiteCollectionDTOAdapter(siteDataBean);
			}
			
			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));

			// ignore: [],
			$('#siteinfoactionform_form').validate(
			{				
				errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
				rules : org.r3.shkadmin.siteconfig.siteinfoactionform_form_validationRules,
				messages : org.r3.shkadmin.siteconfig.siteinfoactionform_form_validationMessages
			});

			
			$('#siteinfoactionform_fieldset_message').formmessage({});								
			this._initializeFormFields(siteDataBean);
								
			$('#siteinfoactionform_action_saveitem').click(
				$.r3Utils.hitch(this, this._onUpdateItem));
					
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
		
	_onUpdateItem: function()
	{
		var _self = this;						
		
		var theForm = $('#siteinfoactionform_form');
		org.r3.AjaxUtils.submitForm(
				"PUT", 
				org.r3.PageManager.getRESTUrl('PUT_SiteCollection_Info', [ org.r3.Constants.site ]),  
				theForm, 
				function(responseData) { $('#siteinfoactionform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' }); }, 
				function(jqXHR, timeout, message) { $('#siteinfoactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); },
				"org.r3.message.saveconfirm",
		        true);		
	},

	
	_initializeFormFields: function(aSiteDTOAdapter)
	{
		if (aSiteDTOAdapter)
		{			
		    $('#siteinfoactionform_site').val(aSiteDTOAdapter.dataBean.site);
			$('#siteinfoactionform_site').prop('disabled', true);

			$('#siteinfoactionform_summary').val(aSiteDTOAdapter.dataBean.summary);
		}
	}


});

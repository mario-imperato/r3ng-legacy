$.r3Utils.namespace("org.r3.jsportlet.user");


org.r3.jsportlet.user.BusinessCardInfoActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},

	open : function(aUserCollectionDTOAdapter)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");
        console.log("Logged User Is: ", org.r3.PageManager.userInfo);
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/user/BusinessCardInfoActionFormView.html.jsp'),
			dataType : "html"
		});

		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));

			$('#businesscardinfoactionform_form').validate
            ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.jsportlet.user.businesscardinfoactionform_form_validationRules,
		           messages: org.r3.jsportlet.user.businesscardinfoactionform_form_validationMessages		           
	        });			
			
			$('#businesscardinfoactionform_action_saveitem').click($.r3Utils.hitch(this, this.doSaveBusinessCard));								
			$('#changepasswordactionform_fieldset_message').formmessage({});
			
			this._initializeFormFields(aUserCollectionDTOAdapter);
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
	_initializeFormFields: function(aUserCollectionDTOAdapter)
	{
		if (aUserCollectionDTOAdapter && aUserCollectionDTOAdapter.dataBean.businesscard)
		{
			$('#businesscardinfoactionform_personalstatement').val(aUserCollectionDTOAdapter.dataBean.businesscard.personalstatement);
			$('#businesscardinfoactionform_email').val(aUserCollectionDTOAdapter.dataBean.businesscard.email);
			$('#businesscardinfoactionform_cellphone').val(aUserCollectionDTOAdapter.dataBean.businesscard.cellphone);				
		}		
	},
	
	doSaveBusinessCard: function()
	{		
		var _self = this;						
		
		var theForm = $('#businesscardinfoactionform_form');
		org.r3.AjaxUtils.submitForm(
				"PUT", 
				org.r3.PageManager.getRESTUrl("PUT_UserCollection_BusinessCard", [ org.r3.PageManager.userInfo.dataBean.userid ]),  
				theForm, 
				function(responseData) {  					
					// Notifico l'actionFormManager che ho fatto qualcosa.
					if (_self.actionFormManager && _self.actionFormManager.onViewStatusChanged)
					{
						_self.actionFormManager.onViewStatusChanged();
					}
				}, 
				function(jqXHR, timeout, message) { console.error(message); },
				"org.r3.message.saveconfirm", 
		        true);						
	}

});
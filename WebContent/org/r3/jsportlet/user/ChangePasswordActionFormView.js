$.r3Utils.namespace("org.r3.jsportlet.user");


org.r3.jsportlet.user.ChangePasswordActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},

	open : function(aDataBeanInfo)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");
        console.log("Logged User Is: ", org.r3.PageManager.userInfo);
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/user/ChangePasswordActionForm.html'),
			dataType : "html"
		});

		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));

			$('#changepasswordactionform_form').validate
            ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.jsportlet.user.changepasswordactionform_form_validationRules,
		           messages: org.r3.jsportlet.user.changepasswordactionform_form_validationMessages		           
	        });			
			
			$('#changepasswordactionform_action_ok').click($.r3Utils.hitch(this.actionFormManager, this.actionFormManager.doChangePassword));								
			$('#changepasswordactionform_fieldset_message').formmessage({});
			
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	}

});
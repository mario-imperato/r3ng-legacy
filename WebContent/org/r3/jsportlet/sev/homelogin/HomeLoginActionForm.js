$.r3Utils.namespace("org.r3.jsportlet.sev.homelogin");

org.r3.jsportlet.sev.homelogin.HomeLoginActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, optionsHash)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.sev.homelogin.HomeLoginActionFormView(aDetailViewContainerId, this);
		
		if (optionsHash && optionsHash.onLoginRedirect)
		{
		    this.onLoginRedirect = 	optionsHash.onLoginRedirect;
		}
		else this.onLoginRedirect = org.r3.Constants.getStrutsActionContext() + "/org/r3/home.do";
			
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

	open : function()
	{
		this.detailView.open();
	},
	
	doLogin: function()
	{
		var _self = this;
		org.r3.AjaxUtils.doLogin(org.r3.PageManager.getRESTUrl('POST_User_Login', [ $('#loginform_form_nickname').val() ]), _self.onLoginRedirect);
		
//		if ($('#loginform_form').valid())
//		{
//			org.r3.PageManager.wait("org.r3.message.waiting");
//
//			var method = "post";
//			var restUrl = org.r3.PageManager.getRESTUrl('POST_User_Login', [ $('#loginform_form_nickname').val() ]);
//			$('#loginform_form').ajaxSubmit(
//			{
//				"type" : method,
//				"url" : restUrl,
//				"dataType" : "json",
//				"success" : function(responseData)
//				{
//					if (org.r3.PageManager.isRestDTO(responseData))
//					{
//						org.r3.PageManager.closeNotifier();
//						var restDto = new org.r3.RestDTOAdapter(responseData);
//
//						if (restDto.isFail())
//	                    {
//							$('#loginform_form_fieldset_message').formmessage('setText', { text: restDto.reason, category: 'error' });						
//	                    }						
//					}
//					else 
//					{						
//						org.r3.PageManager.gotoPage(_self.onLoginRedirect);
//					}
//										
//				},
//				"error" : function(jqXHR, timeout, message)
//				{
//					console.log(arguments);
//					org.r3.PageManager.closeNotifier();
//					$('#loginform_form_fieldset_message').formmessage('setText', { text: message, category: 'error' });
//				}
//			});
//		}				
	}
		
});


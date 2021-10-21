$.r3Utils.namespace("org.r3.jsportlet.site.please_login_or_register");

org.r3.jsportlet.site.please_login_or_register.PleaseLogInOrRegisterPortletActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		if (org.r3.PageManager.userInfo.isGuest())
		{
			this.onLoginRedirect = org.r3.Constants.getStrutsActionContext() + "/org/r3/home.do";
			this.detailView = new org.r3.jsportlet.site.please_login_or_register.PleaseLogInOrRegisterPortletActionFormView(aDetailViewContainerId, this);		
		}
	},

	close : function()
	{
		// M20140201 - org.r3.PageManager.popBreadCrumb();
		this.hide();
	},

	hide : function()
	{
		if (this.detailView)
			this.detailView.hide();
	},

	show : function()
	{
		if (this.detailView)
			this.detailView.show();
	},

	open : function()
	{
		if (this.detailView)
			this.detailView.open();			
	},

	doLogin: function()
	{
		var _self = this;
		org.r3.AjaxUtils.doLogin(org.r3.PageManager.getRESTUrl('POST_User_Login', [ $('#loginform_form_nickname').val() ]), _self.onLoginRedirect);
	}

});
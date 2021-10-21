$.r3Utils.namespace("org.r3.console.login");

org.r3.console.login.PageManager = 
{
  	
	 init: function()
	 {
//		 if (org.r3.PageManager.userInfo.isGuest())
//		 {
			this.loginActionForm = new org.r3.jsportlet.login.LoginActionForm(this, '#JSPortlet_LoginActionForm', { "onLoginRedirect": org.r3.Constants.getStrutsActionContext() + "/org/r3/console/home.do" });			 
			org.r3.PageManager.pushBreadCrumb(
			{
				"title" : "Log-In",
				"actionForm" : this.loginActionForm
			});
				
 		    this.loginActionForm.open();			 
//		 }
//		 else org.r3.PageManager.redirectToConsoleHomePage();
	 }	 
	
};


$.r3Utils.namespace("org.r3.user.resetuserpwd");

org.r3.user.resetuserpwd.PageManager = 
{
  	
	 init: function()
	 {
			org.r3.PageManager.googleAnalyticsSendPageView();
					 
		 if (org.r3.PageManager.userInfo.isGuest())
		 {
			 this.resetUserPasswordActionForm = new org.r3.jsportlet.resetuserpwd.ResetUserPasswordActionForm(this, '#JSPortlet_ResetUserPasswordActionForm');
			 this.openPanel();
		 }
	 },

     openPanel: function()
     {    	
    	 org.r3.PageManager.pushHomeBreadCrumb();			 
	 	 org.r3.PageManager.pushBreadCrumb(
		 {
			"title" : "Recupero Parola Chiave",
			"actionForm" : this.resetUserPasswordActionForm
		 });

		 $('#HLP_RESETPWD').cmsCard({ cardid: "HLP_RESETPWD"});		
		 this.resetUserPasswordActionForm.open();			 			     	
     }
	
};


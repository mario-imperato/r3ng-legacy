$.r3Utils.namespace("org.r3.user.myr3_profile1");

org.r3.user.myr3_profile1.PageManager = 
{
  	
	 init: function()
	 {
		org.r3.PageManager.googleAnalyticsSendPageView();
		this.userProfileActionForm = new org.r3.user.myr3_profile1.UserProfileActionForm(this, '#userprofileactionform');				 		 
		this.openPanel();
	 },

     openPanel: function()
     {    	
    	 org.r3.PageManager.pushHomeBreadCrumb();			 
	 	 org.r3.PageManager.pushBreadCrumb(
		 {
			"title" : "Gestione Profilo",
			"actionForm" : this.userProfileActionForm
		 });
	
	 	 this.userProfileActionForm.open();
	 			     	
     }
	
};


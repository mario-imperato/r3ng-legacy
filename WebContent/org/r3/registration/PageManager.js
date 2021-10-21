$.r3Utils.namespace("org.r3.registration");

org.r3.registration.PageManager = 
{
  	
	 init: function()
	 {
		org.r3.PageManager.googleAnalyticsSendPageView();
			
		 if (org.r3.PageManager.userInfo.isGuest())
		 {
			 this.registrationActionForm = new org.r3.jsportlet.registration.RegistrationActionForm(this, '#JSPortlet_RegistrationActionForm');
			 this.openRegistrationPanel();
		 }
	 },

     openRegistrationPanel: function()
     {    	
    	 org.r3.PageManager.pushHomeBreadCrumb();			 
	 	 org.r3.PageManager.pushBreadCrumb(
		 {
			"title" : org.r3.registration.message.registration_breadcrumb_caption,
			"actionForm" : this.registrationActionForm
		 });

		 $('#HLP_REGISTRATION').cmsCard({ cardid: "HLP_REGISTRATION"});		
		 this.registrationActionForm.open();			 			     	
     }
	
};


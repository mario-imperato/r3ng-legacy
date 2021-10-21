$.r3Utils.namespace("org.r3.registration");

org.r3.registration.ActivationPageManager = 
{
  	
	 init: function(isSuccessFlag)
	 {
		 this.randomPhotoSideBarActionForm = new org.r3.jsportlet.rndphotosidebar.RandomPhotoSideBarActionForm (this, '#JSPortlet_SideBar');
		 
		 this.registrationOutcomeActionForm = new org.r3.registration.RegistrationOutcomeActionForm(this, '#registrationOutcomeActionForm');
		 this.openPanel(isSuccessFlag);		 
	 },
	 
     openPanel: function(isSuccessFlag)
     {    	
    	 org.r3.PageManager.pushHomeBreadCrumb();		 
	 	 org.r3.PageManager.pushBreadCrumb(
		 {
			"title" : org.r3.registration.message.outcome_breadcrumb_caption,
			"actionForm" : this.registrationOutcomeActionForm
		 });
	
	 	 this.randomPhotoSideBarActionForm.open();
		 this.registrationOutcomeActionForm.open(isSuccessFlag);			 			     	
     }

	
};


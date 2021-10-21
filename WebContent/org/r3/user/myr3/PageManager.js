$.r3Utils.namespace("org.r3.user.myr3");

org.r3.user.myr3.PageManager = 
{
  	
	 init: function()
	 {
		org.r3.PageManager.googleAnalyticsSendPageView();
					 
		 this.randomPhotoSideBarActionForm = new org.r3.jsportlet.rndphotosidebar.RandomPhotoSideBarActionForm (this, '#JSPortlet_SideBar');
		 
		 this.changeUserPwdActionForm = new org.r3.jsportlet.changeuserpwd.ChangeUserPasswordActionForm(this, '#changeUserPasswordActionForm');
		 this.userPhotoActionForm = new org.r3.jsportlet.imageupload.UserPhotoActionForm(this, '#userPhotoActionForm');
		 
		 this.openPanel();
	 },

     openPanel: function()
     {    	
    	 org.r3.PageManager.pushHomeBreadCrumb();			 
	 	 org.r3.PageManager.pushBreadCrumb(
		 {
			"title" : "Recupero Parola Chiave",
			"actionForm" : this.changeUserPwdActionForm
		 });
	
	 	 this.randomPhotoSideBarActionForm.open();
	 	 this.userPhotoActionForm.open();
		 this.changeUserPwdActionForm.open();			 			     	
     }
	
};


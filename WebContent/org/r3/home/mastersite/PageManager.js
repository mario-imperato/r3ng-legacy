$.r3Utils.namespace("org.r3.home.mastersite");

org.r3.home.mastersite.PageManager = 
{
  	
	 init: function(siteTypeFilter)
	 {
		org.r3.PageManager.googleAnalyticsSendPageView();
			
		this.homePageActionForm = new org.r3.home.mastersite.HomePageActionForm(this, '#homePageActionForm');
		this.homePageActionForm.open(siteTypeFilter);
	 }	 
	
};


$.r3Utils.namespace("org.r3.home.defaultsite");

org.r3.home.defaultsite.PageManager = 
{
  	
	 init: function(siteTypeFilter)
	 {
		org.r3.PageManager.googleAnalyticsSendPageView();
			
		this.homePageActionForm = new org.r3.home.defaultsite.HomePageActionForm(this, '#homePageActionForm');
		this.homePageActionForm.open(siteTypeFilter);
	 }	 
	
};


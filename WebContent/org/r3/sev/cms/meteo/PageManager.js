$.r3Utils.namespace("org.r3.sev.cms.meteo");

org.r3.sev.cms.meteo.PageManager =
{

	init : function(pageInfo, cardInfo)
	{
		org.r3.PageManager.googleAnalyticsSendPageView();
				
		this.cmsPageActionForm = new org.r3.jsportlet.cms.CMSPage_CardDetailActionForm(this, '#cmsPageActionForm');		
		this.openCMSPage(pageInfo, cardInfo);
	},
	
	openCMSPage : function(pageInfo, cardInfo)
	{
		var _self = this;
		
		org.r3.PageManager.pushHomeBreadCrumb();
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : cardInfo.title,
			"actionForm" : null
		});

		this.cmsPageActionForm.open(pageInfo, cardInfo, { });		
	}
		
		
};

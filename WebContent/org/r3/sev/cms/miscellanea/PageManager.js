$.r3Utils.namespace("org.r3.sev.cms.miscellanea");

org.r3.sev.cms.miscellanea.PageManager =
{

	init : function(pageInfo, cardInfo)
	{
		org.r3.PageManager.googleAnalyticsSendPageView();
		
		this.cmsPageActionForm = new org.r3.jsportlet.cms.CMSPage_CardIndexDetailActionForm(this, '#cmsPageActionForm');		
		this.openCMSPage(pageInfo, cardInfo);
	},
	
	openCMSPage : function(pageInfo, cardInfo)
	{
		var _self = this;
		
		org.r3.PageManager.pushHomeBreadCrumb();
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Altre Notizie",
			"actionForm" : null
		});

		this.cmsPageActionForm.open(pageInfo, cardInfo, { "cardindexquery": "groupid=miscellanea", "downloadCanvas": false });		
	}
		
		
};

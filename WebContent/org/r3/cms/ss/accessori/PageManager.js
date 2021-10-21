$.r3Utils.namespace("org.r3.cms.ss.accessori");

org.r3.cms.ss.accessori.PageManager = 
{
	init : function(pageInfo, cardInfo)
	{
		org.r3.PageManager.googleAnalyticsSendPageView();
				
		this.cmsPageDecorator = new org.r3.jsportlet.cms.CMSPage_PageDecoratorActionFormView(this, '#NoDiv');
		this.cmsPageActionForm = new org.r3.jsportlet.cms.CMSPage_CardIndexDetailActionForm(this, '#cmsPageActionForm');		
		this.openCMSPage(pageInfo, cardInfo);
	},
		
	openCMSPage : function(pageInfo, cardInfo)
	{
			var _self = this;
			
			org.r3.PageManager.pushHomeBreadCrumb();
			org.r3.PageManager.pushBreadCrumb(
			 {
				"title" : "Accessori",
				"actionForm" : null
			 });

			this.cmsPageDecorator.open();				
			this.cmsPageActionForm.open(pageInfo, cardInfo, { 
				"cardindexquery": "groupid=accessori", "cardtemplate": "cms_tpl_cardview_type3", "downloadCanvas": false  
			});		
	 }
			
};


$.r3Utils.namespace("org.r3.cms.ss.derive");

org.r3.cms.ss.derive.PageManager = 
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
				"title" : "Derive e Monotipi",
				"actionForm" : null
			 });

			this.cmsPageDecorator.open();				
			this.cmsPageActionForm.open(pageInfo, cardInfo, { 
				"cardindexquery": "groupid=derive", "cardtemplate": "cms_tpl_cardview_type3", "downloadCanvas": false  
			});		
	 }
			
};


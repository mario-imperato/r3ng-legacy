$.r3Utils.namespace("org.r3.cms.ss.mainsails");

org.r3.cms.ss.mainsails.PageManager = 
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
				"title" : "Rande",
				"actionForm" : null
			 });

			this.cmsPageDecorator.open();				
			this.cmsPageActionForm.open(pageInfo, cardInfo, { 
				"cardindexquery": "groupid=mainsails", "cardtemplate": "cms_tpl_cardview_type3", "downloadCanvas": false  
			});		
	 }
			
};


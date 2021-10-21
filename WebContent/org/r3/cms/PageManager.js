$.r3Utils.namespace("org.r3.cms");

org.r3.cms.PageManager = 
{
  	
	 init: function(pageInfo, cardInfo)
	 {
 		org.r3.PageManager.googleAnalyticsSendPageView();
					 
 	     this.cmsPageDecorator = new org.r3.jsportlet.cms.CMSPage_PageDecoratorActionFormView(this, '#NoDiv');
         this.pageId = pageInfo.pageid;
         
		 $("#cardview_detail").cmsCard({ 
			card_tmpl: "cms_tpl_cardview_type1",
			pageid: this.pageId,
			cardid: cardInfo.cardid, 
		    onComplete: function()
		    {			
		       $("a[rel='lightbox-" + cardInfo.cardid + "']").slimbox();
		    }
		});		
		 		 
		 org.r3.PageManager.pushHomeBreadCrumb();
		 org.r3.PageManager.pushBreadCrumb(
		 {
			"title" : cardInfo.title,
			"actionForm" : null
		 });

 		 this.cmsPageDecorator.open();	

	 }	 
	
};


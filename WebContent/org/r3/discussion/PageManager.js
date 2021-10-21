$.r3Utils.namespace("org.r3.discussion");

org.r3.discussion.PageManager =
{

	init : function(pageInfo, cardInfo, topicInfo)
	{
		org.r3.PageManager.googleAnalyticsSendPageView();
				
		this.navigator = new org.r3.discussion.NavigatorActionForm(this, "#navigatorActionForm");
		this.bbsThreadPortletActionForm = new org.r3.jsportlet.timeline.BBSThreadPortletActionForm(this, "#threadActionForm");
		
		org.r3.PageManager.pushHomeBreadCrumb();
		this.openNavigator(pageInfo, cardInfo, topicInfo);
	},
	
	openNavigator : function(pageInfo, cardInfo, topicInfo) 
	{
		var _self = this;
		this.navigator.open(pageInfo, cardInfo, topicInfo);		
	},
		
	openThreadDetailActionFormPanel : function(aTopicDTOAdapter, aBBSThreadId)
	{		 		 		 	    
		org.r3.PageManager.pushBreadCrumb({
			"title" : aTopicDTOAdapter.dataBean.topictitle,
			"actionForm" : this.bbsThreadPortletActionForm
		});	   	
		
		this.bbsThreadPortletActionForm.open(aTopicDTOAdapter.dataBean.topicid, aBBSThreadId, {});
	},
	
	openTopicInfoActionFormPanel: function(aTopicDTOAdapter)
	{
	     console.log("Display Card: " + aTopicDTOAdapter.dataBean.cardid);

	     $("#topicCmsPageActionForm").cmsCard({ 
				card_tmpl: 'cms_tpl_simple', 
				cardid: aTopicDTOAdapter.dataBean.cardid, 
				onComplete: function(aCardDTOAdapter, numberOfItems)
			    {			
			       // console.info('CMSPage_CardIndexDetailActionFormView::onComplete', numberOfItems);
			       if (numberOfItems)
			       {
			    	   var listOfGalleryImages = aCardDTOAdapter.getListOfPropertiesByPropertyrole('cms_img_gallery');	
			    	   if (listOfGalleryImages && listOfGalleryImages.length)
			    	   {
			    		   _self.cardGalleryView = new org.r3.jsportlet.cms.CMSPage_GalleryView(
			    				   _self.documentListDivLocator + ' #' + aCardId + '_cms_gallery_canvas', 
			    				   aCardId,
			    				   listOfGalleryImages,
			    				   25
			    		   );		
			    		   
			    		   _self.cardGalleryView.open();
			    	   }
			       }	
			    }
		 });	     
	}
	
};

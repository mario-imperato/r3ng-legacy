$.r3Utils.namespace("org.r3.jsportlet.sev.homecard");

org.r3.jsportlet.sev.homecard.HomeCardActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.documentListDivLocator = anHtmlActionFormContainerId + " .cms_card_canvas";
	},

	close : function()
	{
		this.hide();
	},
	
	open : function(aCardId, aTemplateName)
	{
		// console.info('SiteConstants:', org.r3.SiteConstants);
		var _self = this;
		
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/homecard/HomeCardActionForm.html.jsp'),
			dataType : "html"
		});
						
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	
		
 		    $(this.htmlContainerId).html(responseData['view']);	
 			$(this.documentListDivLocator).cmsCard({ 
 				card_tmpl: aTemplateName, 
 				cardid: aCardId, 
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
 			
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
		
	}
		
		
});

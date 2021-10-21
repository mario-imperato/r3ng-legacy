$.r3Utils.namespace("org.r3.jsportlet.cms");

org.r3.jsportlet.cms.CMSPage_CardDetailActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.defaultOptions = { 
				"cardtemplate": "cms_tpl_cardview_type1",
				"cardIndexDivLocator": anHtmlActionFormContainerId + " .cms_cardIndex",
				"cardDetailDivLocator": anHtmlActionFormContainerId + " .cms_card_canvas",
				"downloadCanvas": true				
		};
		
		this.cmsCardOptions = null;		
		this.pageId = '__ND__::CMSPage_CardDetailActionFormView';
		
		this.cardGalleryView = null;
	},

	close : function()
	{
		this.hide();
	},

	open : function(pageInfo, cardInfo, options)
	{
		var _self = this;

		this.pageId = pageInfo.pageid,
		this.cmsCardOptions = $.extend({}, this.defaultOptions, options);
		
		if (this.cmsCardOptions.downloadCanvas)
		{	
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/cms/CMSPage_CardDetailActionFormView.html.jsp'),
			dataType : "html"
		});

		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_SailEvent'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			$(this.htmlContainerId).html(responseData['view']);	
			
			this._fetchCardDetail(this.pageId, cardInfo.cardid);
			
//			$("#cms_cardDetail").cmsCard({ 
//				card_tmpl: "cms_tpl_cardview_type1", 
//				cardid: cardInfo.cardid, 
//			    onComplete: function()
//			    {			
//			       $("a[rel='lightbox-" + cardInfo.cardid + "']").slimbox();
//			       _self.show();
//			    }
//		    });		

			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});	
		}
		else
		{
			this._fetchCardDetail(this.pageId, cardInfo.cardid);
			this.show();
		}
		 
	},
	
	_fetchCardDetail: function(aPageId, aCardId)
	{
		var _self = this;
		$(this.cmsCardOptions.cardDetailDivLocator).cmsCard({ 
			card_tmpl: _self.cmsCardOptions.cardtemplate, 
			cardid: aCardId, 
			pageid: aPageId,
		    onComplete: function(aCardDTOAdapter, numberOfItems)
		    {			
		       // console.info('CMSPage_CardIndexDetailActionFormView::onComplete', numberOfItems);
		       if (numberOfItems)
		       {
		    	   var listOfGalleryImages = aCardDTOAdapter.getListOfPropertiesByPropertyrole('cms_img_gallery');	
		    	   if (listOfGalleryImages && listOfGalleryImages.length)
		    	   {
		    		   _self.cardGalleryView = new org.r3.jsportlet.cms.CMSPage_GalleryView(
		    				   _self.cmsCardOptions.cardDetailDivLocator + ' #' + aCardId + '_cms_gallery_canvas', 
		    				   aCardId,
		    				   listOfGalleryImages,
		    				   25
		    		   );		
		    		   
		    		   _self.cardGalleryView.open();
		    	   }
		       }		       		     
		    }

//			onComplete: function()
//		    {			
//		       // console.info('CMSPage_CardDetailActionFormView::onComplete');
//		       $("a[rel='lightbox-" + aCardId + "']").slimbox();		     
//		    }
	   });				 
    }
	    
	
});

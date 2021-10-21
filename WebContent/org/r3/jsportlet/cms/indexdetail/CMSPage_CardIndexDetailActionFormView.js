$.r3Utils.namespace("org.r3.jsportlet.cms.indexdetail");

org.r3.jsportlet.cms.indexdetail.CMSPage_CardIndexDetailActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.defaultOptions = { 
				"cardtemplate": "cms_tpl_cardview_type3",
				"cardIndexDivLocator": anHtmlActionFormContainerId + " .cms_cardIndex",
				"cardDetailDivLocator": anHtmlActionFormContainerId + " .cms_cardDetail",
				"downloadCanvas": true				
		};
		
		this.cmsCardOptions = null;
		this.pageId = '__ND__::CMSPage_CardIndexDetailActionFormView';
		this.cardGalleryView = null;
	},

	close : function()
	{
		this.hide();
	},

	open : function(aPageDTOAdapter, cardInfo, options)
	{
		var _self = this;
		
		this.pageId = aPageDTOAdapter.dataBean.pageid;
		this.cmsCardOptions = $.extend({}, this.defaultOptions, options);
		
		if (this.cmsCardOptions.downloadCanvas)
		{			
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/cms/indexdetail/CMSPage_CardIndexDetailActionFormView.html.jsp'),
			dataType : "html"
		});

		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_SailEvent'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			var templatedCanvas = tmpl(responseData['view'], { 
 		    	 "pageDTOAdapter": aPageDTOAdapter 
 		    });
			$(this.htmlContainerId).html(templatedCanvas);		
			this._fetchCardIndex(aPageDTOAdapter, cardInfo, _self.cmsCardOptions);
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
		   // Non debbo eseguire il download della canvas di default. La canvas e' gia' sul posto.	
		   this._fetchCardIndex(aPageDTOAdapter, cardInfo, _self.cmsCardOptions);
		   this.show();			
		}
		
	},
	
	_fetchCardIndex: function(aPageDTOAdapter, cardInfo, options)
	{
		var _self = this;
		$(this.cmsCardOptions.cardIndexDivLocator).cmsCard(
		{
			card_tmpl : "cms_tpl_cardgroup_index",
			cardquery : _self.cmsCardOptions.cardindexquery,			
			pageid: aPageDTOAdapter.dataBean.pageid,
			onComplete : function(responseInfo, numberOfItems)
			{
				$(_self.cmsCardOptions.cardIndexDivLocator + ' .cmsCard_link2carddetail').unbind().click($.r3Utils.hitch(_self, _self._onCMSCardLink2CardDetail));
				var card2Fetch = null;
				if (cardInfo && cardInfo.cardid)
				{
					card2Fetch = cardInfo.cardid;
				}
				else if (numberOfItems)
				{
					if (numberOfItems == 1 && responseInfo.dataBean)
					{
						card2Fetch = responseInfo.dataBean.cardid;
					}
					else
					{
						card2Fetch = responseInfo.getItem(0).dataBean.cardid;
					}
				}

				if (card2Fetch)
					_self._fetchCardDetail(aPageDTOAdapter.dataBean.pageid, card2Fetch);
				
			}
		});
		
	},
	
	_fetchCardDetail: function(aPageId, aCardId)
	{
		var _self = this;
		$(this.cmsCardOptions.cardDetailDivLocator).cmsCard({ 
			card_tmpl: _self.cmsCardOptions.cardtemplate, 
			pageid: aPageId,
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
		    				   _self.cmsCardOptions.cardDetailDivLocator + ' #' + aCardId + '_cms_gallery_canvas', 
		    				   aCardId,
		    				   listOfGalleryImages,
		    				   25
		    		   );		
		    		   
		    		   _self.cardGalleryView.open();
		    	   }
		       }		       		     
		    }
	   });				 
    },
	 
	_onCMSCardLink2CardDetail: function(e)
	{
		org.r3.PageManager.googleAnalyticsSendPageView();
		
		var theItem = $(e.currentTarget);
		var cardId  = theItem.attr('data-cardid');
		
		this._fetchCardDetail(this.pageId, cardId);
	}
    
	
});

$.r3Utils.namespace("org.r3.cms.articles");

org.r3.cms.articles.PageManager = 
{
	init : function(pageInfo, cardInfo)
	{
		org.r3.PageManager.googleAnalyticsSendPageView();
		
	    this.cmsPageDecorator = new org.r3.jsportlet.cms.CMSPage_PageDecoratorActionFormView(this, '#NoDiv');
		
	    this.cmsPageActionForm = new org.r3.jsportlet.cms.CMSPage_CardPagedIndexActionForm(this, '#cmsPagedIndexActionForm', '#cmsPagedIndexActionForm_cardIndexCanvas');
		this.pagedIndexOpen = false;
		
		this.newsletterSubscriptionActionForm = new org.r3.jsportlet.newslettersubscription.NewsletterSubscriptionActionForm (this, '#newsletterSubscriptionActionForm');
		
		this.cmsPageDetailActionForm = new org.r3.jsportlet.cms.CMSPage_CardDetailActionForm(this, '#cmsPageDetailActionForm');	
		this.openCMSPage(pageInfo, cardInfo);
	},
		
	openCMSPage : function(pageInfo, cardInfo)
	{
			var _self = this;
			
			org.r3.PageManager.pushHomeBreadCrumb();
			this.cmsPageDecorator.open();	
			
			if (cardInfo && cardInfo.cardid)
			{
				org.r3.PageManager.pushBreadCrumb(
				{
					"title" : "Articoli",
					"actionForm" : {
					   show: function()
	   	       	 	   {
						   if (_self.pagedIndexOpen)
						   {
							   _self.cmsPageActionForm.show();
						   }
						   else
						   {
								// 
							   _self.pagedIndexOpen = true;
					
							   _self.openCMSCardIndex(pageInfo, cardInfo);							   
						   }
	   	       	 	   },
	   	       	 	   
	   	       	 	   close: function()
	   	       	 	   {
						   if (_self.pagedIndexOpen)
						   {
							   _self.cmsPageActionForm.close();
							   _self.pagedIndexOpen = false;
						   }
						   else
						   {
							   
						   }
	   	       	 	   }
					}
				});

				 org.r3.PageManager.pushBreadCrumb(
				 {
					"title" : "Dettaglio Scheda",
					"actionForm" : this.cmsPageDetailActionForm
				 });

				 this.cmsPageDetailActionForm.open(pageInfo, cardInfo, { });					
			}
			else
			{
				org.r3.PageManager.pushBreadCrumb(
				{
					"title" : "Articoli",
					"actionForm" : this.cmsPageActionForm
				});

				this.openCMSCardIndex(pageInfo, cardInfo);							   
			}
			
	 },
	 
	 openCMSCardIndex: function(pageInfo, cardInfo)
	 {
		   this.newsletterSubscriptionActionForm.open();
		   
		   this.cmsPageActionForm.open(pageInfo, cardInfo, { 
				"cardindexquery": "groupid=articles", 
				"cardindextemplate": "cms_tpl_cardgroup_iconicindex",
				iDisplayStart: 0,
				iDisplayLength: 10,
				fetchmode: 'partial'				
		   });						

		   $('#cms_newsletterCardIndex').cmsCard(
			{
				pageid: pageInfo.pageid,
				card_tmpl : "cms_tpl_cardsetlistofdocuments",
				cardquery : "categoryid=newsletter",
				fetchmode: "full",
				onComplete : function(responseInfo, totalNumberOfItems)
				{			
				}
			});			 
	 },
	 
	 openCMSCardDetailByPageIdCardId: function(aPageId, aCardId)
	 {
		 console.info("Should Open... ", aCardId);
		 var _self = this;
		
		 org.r3.PageManager.pushBreadCrumb(
		 {
			"title" : "Dettaglio Scheda",
			"actionForm" : this.cmsPageDetailActionForm
		 });

		 this.cmsPageDetailActionForm.open({ pageid: aPageId} , { cardid: aCardId }, { });			
	 }
		
//	 init: function(pageInfo, cardInfo)
//	 {		 		 		 
//		 var _self = this;
//		 
//		 org.r3.PageManager.pushHomeBreadCrumb();
//		 
//			
//		 
//		 $("#cms_cardIndex").cmsCard({ 
//				card_tmpl: "cms_tpl_cardgroup_index", 
//				cardquery: "groupid=sailschool", 
//			    onComplete: function(responseInfo, numberOfItems)
//			    {   	
//			    	$('.cmsCard_link2carddetail').unbind().click($.r3Utils.hitch(_self, _self._onCMSCardLink2CardDetail));
//			    	
//			    	var card2Fetch = null;
//			    	if (cardInfo.cardid)
//			    	{
//			    		card2Fetch = cardInfo.cardid;		    		
//			    	}
//			    	else 
//			    	if (numberOfItems)
//			    	{
//			    		if (numberOfItems == 1 && responseInfo.dataBean)
//			    		{
//			    			card2Fetch = responseInfo.dataBean.cardid;
//			    		}
//			    		else
//			    		{
//			    			card2Fetch = responseInfo.getItem(0).dataBean.cardid;
//			   			}
//			    	}
//			    	
//			    	if (card2Fetch)
//			    	    _self._fetchCardDetail(card2Fetch);
//			    }
//		});		
//		 
//
//	 },
//		
//	 _fetchCardDetail: function(aCardId)
//	 {
//		$("#cms_cardDetail").cmsCard({ 
//			card_tmpl: "cms_tpl_cardview_type3", 
//			cardid: aCardId, 
//		    onComplete: function()
//		    {			
//		       $("a[rel='lightbox-" + aCardId + "']").slimbox();		     
//		    }
//	   });				 
//	 },
//	 
//		_onCMSCardLink2CardDetail: function(e)
//		{
//			var theItem = $(e.currentTarget);
//			var cardId  = theItem.attr('data-cardid');
//			this._fetchCardDetail(cardId);
//		}	 
	
};


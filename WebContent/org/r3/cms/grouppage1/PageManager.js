$.r3Utils.namespace("org.r3.cms.grouppage1");

org.r3.cms.grouppage1.PageManager = 
{
	init : function(pageInfo, cardInfo)
	{
		org.r3.PageManager.googleAnalyticsSendPageView();
				
		this.cmsPageDecorator = new org.r3.jsportlet.cms.CMSPage_PageDecoratorActionFormView(this, '#NoDiv');
		this.cmsPageActionForm = new org.r3.jsportlet.cms.indexdetail.CMSPage_CardIndexDetailActionForm(this, '#cmsPageActionForm');		
		this.open(pageInfo, cardInfo);
	},
		
	open: function(pageInfo, cardInfo)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");
		
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "content",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_Page_Detail', [ pageInfo.pageid ]),
			dataType : "json"
		});
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,
				
		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			var aPageDTOAdapter = responseData['content'];
			if (aPageDTOAdapter)
			{
				aPageDTOAdapter = new org.r3.db.cms.page.PageDTOAdapter(aPageDTOAdapter);								
			}
			
			this.openCMSPage(aPageDTOAdapter, cardInfo);
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
		
	},
	
	openCMSPage : function(aPageDTOAdapter, cardInfo)
	{
			var _self = this;
			
			org.r3.PageManager.pushHomeBreadCrumb();
			org.r3.PageManager.pushBreadCrumb(
			 {
				"title" : aPageDTOAdapter.dataBean.pagetitle,
				"actionForm" : null
			 });

			this.cmsPageDecorator.open();							
			
			var viewOptions = aPageDTOAdapter.getViewOptionsJSObject();			
			this.cmsPageActionForm.open(aPageDTOAdapter, cardInfo, viewOptions);		
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


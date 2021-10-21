$.r3Utils.namespace("org.r3.cms.school");

org.r3.cms.school.PageManager = 
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
				"title" : "Scuola Vela",
				"actionForm" : null
			 });

			this.cmsPageDecorator.open();				
			this.cmsPageActionForm.open(pageInfo, cardInfo, { 
				"cardindexquery": "groupid=sailschool", "cardtemplate": "cms_tpl_cardview_type3", "downloadCanvas": false  
			});		
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


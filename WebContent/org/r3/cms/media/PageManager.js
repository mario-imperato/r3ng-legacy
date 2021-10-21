$.r3Utils.namespace("org.r3.cms.media");

org.r3.cms.media.PageManager = 
{
	init : function(pageInfo, cardInfo)
	{
		org.r3.PageManager.googleAnalyticsSendPageView();
		
	    this.cmsPageDecorator = new org.r3.jsportlet.cms.CMSPage_PageDecoratorActionFormView(this, '#NoDiv');
		
	    this.cmsPageActionForm = new org.r3.jsportlet.cms.CMSPage_CardPagedIndexActionForm(this, '#cmsPagedIndexActionForm', '#cmsPagedIndexActionForm_cardIndexCanvas');
		this.pagedIndexOpen = false;
				
		this.cmsPageDetailActionForm = new org.r3.jsportlet.cms.CMSPage_CardDetailActionForm(this, '#cmsPageDetailActionForm');
		
		this.openPageIndex(pageInfo, cardInfo);	
		

	},

	openPageIndex: function(pageInfo, cardInfo)
	{
		var _self = this;
		
		var resolvedUrl = org.r3.PageManager.getRESTUrl("LUT_CMS_MediaPage" );
		var page2Open = null;
    	org.r3.PageManager.lutManager.getLUT(resolvedUrl, function(theLUT)
    	{
    		if (theLUT.aaData && theLUT.aaData.length > 0)
    		{
    			page2Open = theLUT.aaData[0];
    			var templatedHtml = tmpl('cms_tpl_page_index', theLUT);
    			$('#cms_pageIndex').html(templatedHtml);
    		}
    		
    		if (pageInfo.pagetype && pageInfo.pagetype == 'group' && page2Open)
    		{
    			_self.openCMSPage(
    					{ pageid : page2Open.pageid, pagetype : page2Open.pagetype }, 
    					{ cardid : null, title : null });	
    		}
    		else _self.openCMSPage(pageInfo, cardInfo);
    	});
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
					"title" : "Media",
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
					"title" : "Media",
					"actionForm" : this.cmsPageActionForm
				});

				this.openCMSCardIndex(pageInfo, cardInfo);							   
			}
			
	 },
	 
	 openCMSCardIndex: function(pageInfo, cardInfo)
	 {
		   
		   this.cmsPageActionForm.open(pageInfo, cardInfo, { 
				"cardindexquery": "groupid=media&pageid=" + pageInfo.pageid, 
				"cardindextemplate": "cms_tpl_cardgroup_iconicindex",
				iDisplayStart: 0,
				iDisplayLength: 10,
				fetchmode: 'partial'				
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
		
	
};


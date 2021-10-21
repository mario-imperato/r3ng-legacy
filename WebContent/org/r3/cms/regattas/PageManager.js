$.r3Utils.namespace("org.r3.cms.regattas");

org.r3.cms.regattas.PageManager = 
{
	init : function(pageInfo, cardInfo)
	{
		org.r3.PageManager.googleAnalyticsSendPageView();
				
		this.cmsPageDecorator = new org.r3.jsportlet.cms.CMSPage_PageDecoratorActionFormView(this, '#NoDiv');
			
		this.cmsPageActionForm = new org.r3.jsportlet.cms.CMSPage_CardPagedIndexActionForm(this, '#cmsPagedIndexActionForm', '#cmsPagedIndexActionForm_cardIndexCanvas');
		this.pagedIndexOpen = false;
						
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
					"title" : "Regate",
					"actionForm" : {
					   show: function()
	   	       	 	   {
						   if (_self.pagedIndexOpen)
						   {
							   _self.cmsPageActionForm.show();
						   }
						   else
						   {
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
					"title" : "Scheda Regata",
					"actionForm" : this.cmsPageDetailActionForm
				 });

				 this.cmsPageDetailActionForm.open(pageInfo, cardInfo, { });					
			}
			else
			{
				org.r3.PageManager.pushBreadCrumb(
				{
					"title" : "Regate",
					"actionForm" : this.cmsPageActionForm
				});

				this.openCMSCardIndex(pageInfo, cardInfo);							   
			}
			
	 },
	 
	 openCMSCardIndex: function(pageInfo, cardInfo)
	 {		   
		   this.cmsPageActionForm.open(pageInfo, cardInfo, { 
				"cardindexquery": "groupid=sailevent", 
				"cardindextemplate": "cms_tpl_cardgroup_iconicindex",
				iDisplayStart: 0,
				iDisplayLength: 10,
				fetchmode: 'partial'				
		   });						

		   $('#cms_cardRegattasCalendar').cmsCard(
			{
				pageid: pageInfo.pageid,
				card_tmpl : "cms_tpl_cardview_type3",
				cardid : "REGATTACALENDAR",
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
			"title" : "Scheda Regata",
			"actionForm" : this.cmsPageDetailActionForm
		 });

		 this.cmsPageDetailActionForm.open({ pageid: aPageId} , { cardid: aCardId }, { });			
	 }
		
	
};


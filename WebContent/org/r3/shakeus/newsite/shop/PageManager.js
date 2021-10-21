$.r3Utils.namespace("org.r3.shakeus.newsite.shop");

org.r3.shakeus.newsite.shop.PageManager = 
{
 
	 init: function()
	 {		    
		var _self = this;
		 
		org.r3.PageManager.googleAnalyticsSendPageView();	
		this.photoSideBar = new org.r3.jsportlet.rndphotosidebar.RandomPhotoSideBarActionForm (this, '#JSPortlet_RandomPhotoSideBar');
		this.photoSideBar.open();
		
		this.siteInfoActionForm = new org.r3.shakeus.newsite.SiteInfoActionForm (this, '#newsite_siteinfo_actionform');
		this.siteRequestAcceptedActionForm = new org.r3.shakeus.newsite.SiteRequestAcceptedActionForm (this, '#newsite_siterequestaccepted_actionform');
		
		this.termsAndConditionActionForm = new org.r3.shakeus.newsite.TermsAndConditionActionForm (this, '#newsite_termsandconditions_actionform');
		this.termsAndConditionActionForm.open({ 
			title: org.r3.shakeus.newsite.shop.message.createNewProfileTitle,
			subtitle : org.r3.shakeus.newsite.shop.message.createNewProfileSubTitle,
			termsAndConditionsBriefCardId: "TCBNEWSHOP",	
			termsAndConditionsExtendedCardId: "TCENEWSHOP"
		});		
	 },
	 
	 onTermsAndConditionAccepted: function()
	 {
		 this.siteInfoActionForm.open({
			 title: org.r3.shakeus.newsite.shop.message.createNewProfile_siteInfoTitle,
			 subtitle : org.r3.shakeus.newsite.shop.message.createNewProfile_siteInfoSubTitle,
			 siteCodeDescriptionCardId: "SITEINFONEWSHOP",
			 siteCreatedCardId: "SITEINFONEWSHOPOK",
			 sitecode:  org.r3.shakeus.newsite.shop.message.createNewProfile_sitecode,
			 sitedescr : org.r3.shakeus.newsite.shop.message.createNewProfile_sitedescr,
			 sitetype: "shkshop",			 
			 messagesNamespace: "org.r3.shakeus.newsite.shop"
		 });
	 },
	 
	 onSiteCreationRequestPosted: function(aSiteDTOAdapter)
	 {
		 console.log("Shop Created");
		 this.siteRequestAcceptedActionForm.open({
			 siteCreated: aSiteDTOAdapter,			 
			 siteCreatedCardId: "SITEINFONEWSHOPOK",
			 messagesNamespace: "org.r3.shakeus.newsite.shop"
		 });		 					
	 }
 
	 	
};


$.r3Utils.namespace("org.r3.shakeus.newsite.neighborhood");

org.r3.shakeus.newsite.neighborhood.PageManager = 
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
			title: org.r3.shakeus.newsite.neighborhood.message.createNewProfileTitle,
			subtitle : org.r3.shakeus.newsite.neighborhood.message.createNewProfileSubTitle,
			termsAndConditionsBriefCardId: "TCBNEWNEIGHB",	
			termsAndConditionsExtendedCardId: "TCENEWNEIGHB"
		});		
	 },
	 
	 onTermsAndConditionAccepted: function()
	 {
		 this.siteInfoActionForm.open({
			 title: org.r3.shakeus.newsite.neighborhood.message.createNewProfile_siteInfoTitle,
			 subtitle : org.r3.shakeus.newsite.neighborhood.message.createNewProfile_siteInfoSubTitle,
			 siteCodeDescriptionCardId: "SITEINFONEWNEIGHB",
			 siteCreatedCardId: "SITEINFONEWNEIGHBOK",
			 sitecode:  org.r3.shakeus.newsite.neighborhood.message.createNewProfile_sitecode,
			 sitedescr : org.r3.shakeus.newsite.neighborhood.message.createNewProfile_sitedescr,
			 sitetype: "shkneighb",			 
			 messagesNamespace: "org.r3.shakeus.newsite.neighborhood"
		 });
	 },
	 
	 onSiteCreationRequestPosted: function(aSiteDTOAdapter)
	 {
		 console.log("Neighborhood Created");
		 this.siteRequestAcceptedActionForm.open({
			 siteCreated: aSiteDTOAdapter,			 
			 siteCreatedCardId: "SITEINFONEWNEIGHBOK",
			 messagesNamespace: "org.r3.shakeus.newsite.neighborhood"
		 });
		 
         // $(_self.htmlContainerId).cmsCard({ site: org.r3.SiteConstants.sitedomain, card_tmpl: "cms_tpl_simple", "cardid": _self.configOptions.siteCreatedCardId});						
	 }
	 	
};


$.r3Utils.namespace("org.r3.home.shakeusneighb");

org.r3.home.shakeusneighb.PageManager = 
{
 
	 init: function(aPostId)
	 {		    
		var _self = this;
		 
		org.r3.PageManager.googleAnalyticsSendPageView();	
	    this.mongoTimelineTunerActionForm = new org.r3.jsportlet.mongotimeline.tuner.TimelineTunerActionForm (this, '#jsportlet_mongo_timelinetuner');	    	    
	    this.mongoTimelineActionForm = new org.r3.jsportlet.mongotimeline.TimelineActionForm (this, '#jsportlet_mongo_timeline');	    
	    this.mongoPostActionForm = new org.r3.jsportlet.mongotimeline.PostActionForm (this, '#jsportlet_mongo_timeline');

	    // aPostId = '58451c21e97e4311a82f8e9b';
	    if (aPostId)
	    	 this.openPostActionForm(aPostId);
	    else this.mongoTimelineTunerActionForm.open(this.mongoTimelineActionForm);
	    
	    // this.timelineTunerActionForm = new org.r3.jsportlet.shakeus_timeline.TimelineTunerActionForm (this, '#jsportlet_shk_timelinetuner');
	    // this.timelineActionForm = new org.r3.jsportlet.shakeus_timeline.TimelineActionForm (this, '#jsportlet_shk_timeline');
	    this.siteMembersActionForm = new org.r3.jsportlet.site.sitemember.SiteMemberPortletActionForm(this, '#JSPortlet_SiteMembers');	
	    
	    var pleaseLoginCanvas = "#JSPortlet_PleaseLogInOrRegister";	    
	    this.pleaseLogInOrRegisterActionForm = new org.r3.jsportlet.site.please_login_or_register.PleaseLogInOrRegisterPortletActionForm(this, pleaseLoginCanvas);	
	    this.photoSideBar = new org.r3.jsportlet.rndphotosidebar.RandomPhotoSideBarActionForm (this, '#JSPortlet_RandomPhotoSideBar');
	    
		// this.timelineTunerActionForm.open(org.r3.db.mongo.postcollection.TimelineConfig);	
		this.pleaseLogInOrRegisterActionForm.open();
		this.siteMembersActionForm.open();
		this.photoSideBar.open();
				
		$('.timeline-action').unbind().click(function(e) 
		{
			// _self.mongoTimelineActionForm.close();
			var dataTimelineId = $(e.currentTarget).attr('data-timelineid');
			switch(dataTimelineId)
			{
			case 'tuner':
				_self.mongoTimelineTunerActionForm.open(_self.mongoTimelineActionForm);
				break;
			case 'news':
				var timelineParams = {
					timelineURL: org.r3.PageManager.getRESTUrl("GET_TimelineOfPosts", [ org.r3.Constants.site, org.r3.Constants.language ]) + "&status=published&groups=news"
				};
				
				_self.mongoTimelineTunerActionForm.close();
				_self.mongoTimelineActionForm.open(null, timelineParams);					
				break;				
			}
		});	
		
//		$('.timelineaction').unbind().click(function(e) 
//		{
//			var currentTarget = $(e.currentTarget);
//			var dataTimelineId = currentTarget.attr('data-timelineid');
//			if (dataTimelineId)
//			{
//				_self.activateTimeline(dataTimelineId);
//				_self.timelineTunerActionForm.close();
//			}
//		});		
	 },
	 
	 activateMongoTimeline: function(aSetOfTimelineOpeningParams)
	 {		
		this.mongoTimelineActionForm.open(this.mongoTimelineTunerActionForm, aSetOfTimelineOpeningParams);
	 },
	 
	 openPostActionForm: function(aPostId)
	 {
		 this.mongoPostActionForm.open(aPostId);
	 }
	 
//	 activateTimeline: function(aTimelineId)
//	 {		
//		console.log("Activate Timeline" + aTimelineId);
//		this.timelineActionForm.open(aTimelineId, new org.r3.db.mongo.sitecollection.SiteCollectionConfigDTOAdapter(org.r3.db.mongo.postcollection.TimelineConfig));
//	 }
	
};


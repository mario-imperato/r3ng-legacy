$.r3Utils.namespace("org.r3.home.shkshop");

org.r3.home.shkshop.PageManager = 
{
 
	 init: function(aPostId)
	 {		    
		org.r3.PageManager.googleAnalyticsSendPageView();	
		this.execute();

	    this.mongoTimelineTunerActionForm = new org.r3.jsportlet.mongotimeline.tuner.TimelineTunerActionForm (this, '#jsportlet_mongo_timelinetuner');	    	    
	    this.mongoTimelineActionForm = new org.r3.jsportlet.mongotimeline.TimelineActionForm (this, '#jsportlet_mongo_timeline');	    
	    this.mongoPostActionForm = new org.r3.jsportlet.mongotimeline.PostActionForm (this, '#jsportlet_mongo_timeline');

	    // aPostId = '58451c21e97e4311a82f8e9b';
	    if (aPostId)
	    	 this.openPostActionForm(aPostId);
	    else this.mongoTimelineTunerActionForm.open(this.mongoTimelineActionForm);
	    
	    this.siteMembersActionForm = new org.r3.jsportlet.site.sitemember.SiteMemberPortletActionForm(this, '#JSPortlet_SiteMembers');	
	    
	    var pleaseLoginCanvas = "#JSPortlet_PleaseLogInOrRegister";	    
	    this.pleaseLogInOrRegisterActionForm = new org.r3.jsportlet.site.please_login_or_register.PleaseLogInOrRegisterPortletActionForm(this, pleaseLoginCanvas);	
	    
		// this.timelineTunerActionForm.open(org.r3.db.mongo.postcollection.TimelineConfig);	
		this.pleaseLogInOrRegisterActionForm.open();
		this.siteMembersActionForm.open();
				
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
		
	 },
	 
	 activateMongoTimeline: function(aSetOfTimelineOpeningParams)
	 {		
		this.mongoTimelineActionForm.open(this.mongoTimelineTunerActionForm, aSetOfTimelineOpeningParams);
	 },
	 
	 openPostActionForm: function(aPostId)
	 {
		 this.mongoPostActionForm.open(aPostId);
	 },
	 
	 execute: function()
	 {
		 var colour = [
						"rgb(142, 68, 173)",
						"rgb(243, 156, 18)",
						"rgb(211, 84, 0)",
						"rgb(0, 106, 63)",
						"rgb(41, 128, 185)",
						"rgb(192, 57, 43)",
						"rgb(135, 0, 0)",
						"rgb(39, 174, 96)"
					];

//					$(".brick").each(function() {
//						this.style.backgroundColor =  colour[colour.length * Math.random() << 0];
//					});

						var wall = new Freewall("#freewall");
						wall.reset({
							
							selector: '.brick',
							animate: true,
							fixSize: null,
							cellW: 100,
							cellH: 100,
							delay: 50,
							onResize: function() {
								wall.fitWidth();
							}
						});
						wall.fitWidth();
						var temp = '<div class="brick {size}" style="background-color: {color}"><div class="cover"></div></div>';
						var size = "size33 size32 size31 size23 size22 size21 size13 size12 size11".split(" ");
						$(".add-more").click(function() {
							var html = "";
							for (var i = 0; i < 1; ++i) {
								html += temp.replace('{size}', size[size.length * Math.random() << 0])
											.replace('{color}', colour[colour.length * Math.random() << 0]);
							}
							wall.appendBlock(html);
						});
					
	 }
	
};


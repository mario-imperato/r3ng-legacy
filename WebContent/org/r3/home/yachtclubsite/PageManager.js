$.r3Utils.namespace("org.r3.home.yachtclubsite");

org.r3.home.yachtclubsite.PageManager = 
{
  	
	 init: function()
	 {		    
		org.r3.PageManager.googleAnalyticsSendPageView();
		
		// alert(org.r3.home.yachtclubsite.message.initializationerror);
		
		if (org.r3.Constants.isI18NTranslationRequired())
		{
			$.i18n.loadNamespace("org.r3.home.yachtclubsite", function () {
				var start = $.r3Utils.logElapsedTime();
				$("body").i18n();	
				$.r3Utils.logElapsedTime(start);
			});			
		}
		
		 this.newsletterSubscriptionActionForm = new org.r3.jsportlet.newslettersubscription.NewsletterSubscriptionActionForm (this, '#JSPortlet_NewsLetterActionForm');
		 this.newsletterSubscriptionActionForm.open({ template: "Home_NewsletterSubscriptionActionForm.html" });
		 
		    this.pageId = '__HOME__';
			$("#homecarouselview").cmsCard({ 
				card_tmpl: "cms_tpl_homecarouselview", 
				cardquery: "groupid=c_homecarousel", 
				pageid: this.pageId,
			    onComplete: function()
			    {
					$("#homecarouselview_canvas").carouFredSel({
					    responsive  : true,
					    scroll      : {
					        fx          : "crossfade"
					    },
					    items       : {
					        visible     : 1,
					        height      : "25%",
					        width: 1690
					    }
					});    	
			    }
			});			

			$("#sponsorcarouselview").cmsCard({ 
				card_tmpl: "cms_tpl_sponsorsview", 
				cardquery: "groupid=sponsorcarousel",
				pageid: this.pageId,
			    onComplete: function()
			    {
					$("#sponsorcarouselview_canvas").carouFredSel({					    
			    		width   : "100%",
			    		scroll  : 2		    		    
					});    	
			    }
			});			

			$("#friendcarouselview").cmsCard({ 
				card_tmpl: "cms_tpl_friendsview", 
				cardquery: "groupid=friendcarousel",
				pageid: this.pageId
			});						

//			$("#homenewsletter").cmsCard({ 
//				card_tmpl: "cms_tpl_homenewsletter", 
//				cardquery: "groupid=homebriefnews&orderby=refdate desc", 
//				iDisplayStart: 0,
//				iDisplayLength: 3,
//				fetchmode: 'partial',
//				pageid: this.pageId,
//			    onComplete: function()
//			    {					 	
//			    }
//			});			

//			$("#homebriefnews").cmsCard({ 
//				card_tmpl: "cms_tpl_homebriefnews", 
//				cardquery: "groupid=homebriefnews&orderby=refdate desc", 
//				iDisplayStart: 0,
//				iDisplayLength: 3,
//				fetchmode: 'partial',
//				pageid: this.pageId,
//			    onComplete: function()
//			    {					 	
//			    }
//			});			

			$("#JSPortlet_HomeChannelsActionForm").cmsCard({ 
				card_tmpl: "cms_tpl_channelportlet", 
				cardquery: "channelid=CHN09&channelfilter=none",
				pageid: this.pageId,
			    onComplete: function(responseData, numberOfCards)
			    {
			    	if (numberOfCards)
			    	   $("#JSPortlet_HomeChannelsActionForm").show();
			    }
			});	
			
			$("#homearticles").cmsCard({ 
				card_tmpl: "cms_tpl_homearticles", 
				cardquery: "groupid=homearticles&orderby=refdate desc", 
				iDisplayStart: 0,
				iDisplayLength: 10,
				fetchmode: 'partial',
				pageid: this.pageId,
			    onComplete: function()
			    {					 	
			    }
			});			

			$("#homesailevent").cmsCard({ 
				card_tmpl: "cms_tpl_homesailevent", 
				cardquery: "groupid=homesailevent&orderby=refdate desc", 
				iDisplayStart: 0,
				iDisplayLength: 10,
				fetchmode: 'partial',
				pageid: this.pageId,
			    onComplete: function()
			    {					 	
			    }
			});			

			// Initialize Social Plugins.
			// $.getScript('http://connect.facebook.net/it_IT/sdk.js#xfbml=1&version=v2.0');
			$.getScript('http://platform.twitter.com/widgets.js');
			
//			$("#homesidebarsailevent").cmsCard({ 
//				card_tmpl: "cms_tpl_homesailevent", 
//				cardquery: "groupid=homesailevent&orderby=refdate desc", 
//				iDisplayStart: 0,
//				iDisplayLength: 3,
//				fetchmode: 'partial',
//				pageid: this.pageId,
//			    onComplete: function()
//			    {					 	
//			    }
//			});			

	 }	 
	
};


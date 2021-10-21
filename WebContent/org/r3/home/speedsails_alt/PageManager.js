$.r3Utils.namespace("org.r3.home.speedsails");

org.r3.home.speedsails.PageManager = 
{
  	
	 init: function()
	 {		    
		org.r3.PageManager.googleAnalyticsSendPageView();
					 
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
			
			$('#home_splash').cmsCard({ 
				card_tmpl: "cms_tpl_simple", 
				cardid: "HOME_SPLASH", 
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

	 }	 
	
};


$.r3Utils.namespace("org.r3.jsportlet.cms");

org.r3.jsportlet.cms.CMSPage_PageDecoratorActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.pageId = '__ND__::CMSPage_PageDecoratorActionFormView';
	},

	close : function()
	{
		this.hide();
	},

	open : function(pageInfo, cardInfo, options)
	{
		var _self = this;

		if (pageInfo)
		   this.pageId = pageInfo.pageid;
		 
		 $("#iconic_menu_carousel_canvas").carouFredSel({
			auto     : false,
			align    : 'center',
			width    : '100%',
			
			pagination : {
				        container   : "#iconic_menu_carousel_pagination",
					        keys        : true,
					        easing      : "easeOutBounce",
					        duration    : 3000
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
		 
	}
	    
	
});

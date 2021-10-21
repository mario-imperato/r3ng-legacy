$.r3Utils.namespace("org.r3.sev.cms.tracker");

org.r3.sev.cms.tracker.CMSPageActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.pageId = 'tracker';
	},

	close : function()
	{
		this.hide();
	},
	
	open : function()
	{
		var _self = this;
		
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/sev/cms/tracker/CMSPageActionForm.html'),
			dataType : "html"
		});

		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_SailEvent'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 				
			$(this.htmlContainerId).html(responseData['view']);			
			
			$("#tack_tracker_info").cmsCard({ 
				card_tmpl: "cms_tpl_simple", 
				cardid: "thtracker",
				pageid: this.pageId,
			    onComplete: function()
			    {			    	    	
			    }
			});
			
			$("#cmsCardGroup").cmsCard({ 
				card_tmpl: "cms_tpl_trackerview", 
				cardquery: "groupid=t_tracker",
				pageid: this.pageId,
			    onComplete: function()
			    {
			    	$('.cmsCard_link2fullscreen').unbind().click($.r3Utils.hitch(_self, _self._onCMSCardLink2FullScreen));    	
			    }
			});
						
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
	},
	
	_onCMSCardLink2FullScreen: function(e)
	{
		var theItem = $(e.currentTarget);
		var theUrl  = theItem.attr('data-dmsurl');
		
		this.actionFormManager.openCMSLink2fullscreenViewer(theUrl);
	}
	
});

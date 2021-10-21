$.r3Utils.namespace("org.r3.sev.cms.tracker");

org.r3.sev.cms.tracker.PageManager =
{

	init : function()
	{
		org.r3.PageManager.googleAnalyticsSendPageView();
				
		this.randomPhotoSideBarActionForm = new org.r3.jsportlet.rndphotosidebar.RandomPhotoSideBarActionForm (this, '#JSPortlet_SideBar');
		this.cmsPageActionForm = new org.r3.sev.cms.tracker.CMSPageActionForm(this, '#cmsPageActionForm');
		this.cmsHTMLPageViewerActionForm = new org.r3.jsportlet.cms.CMSHTMLPageViewerActionForm(this, '#canvas_report_content');
		this.openCMSPage()
	},

	openCMSPage : function()
	{
		org.r3.PageManager.pushHomeBreadCrumb();
		org.r3.PageManager.pushBreadCrumb(
		{
			"title" : "Pagina Tack Tracker",
			"actionForm" : this.cmsPageActionForm
		});

	 	this.randomPhotoSideBarActionForm.open({ "collection": "tacktracker", "numberOfIcons": 4 });		
		this.cmsPageActionForm.open();
	},
	
	openCMSLink2fullscreenViewer: function(aDmsUrl)
	{		
		$('#canvas_report_title').html("Repporto Tracker");
		org.r3.PageManager.openFullScreenLayout(this.cmsHTMLPageViewerActionForm);
		this.cmsHTMLPageViewerActionForm.open(aDmsUrl);		
	}
	
};

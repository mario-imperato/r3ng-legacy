$.r3Utils.namespace("org.r3.sev.cms.tracker");

org.r3.sev.cms.tracker.CMSPageActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.sev.cms.tracker.CMSPageActionFormView(aDetailViewContainerId, this);
	},

	close : function()
	{
		this.hide();
	},

	hide : function()
	{
		this.detailView.hide();
	},

	show : function()
	{
		this.detailView.show();
	},

	refresh : function()
	{
	},

	open : function()
	{
		this.detailView.open();
	},
	
	openCMSLink2fullscreenViewer: function(theUrl)
	{
		this.pageManager.openCMSLink2fullscreenViewer(theUrl);
	}
			
});


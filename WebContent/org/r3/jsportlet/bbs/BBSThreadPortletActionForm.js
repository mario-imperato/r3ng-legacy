$.r3Utils.namespace("org.r3.jsportlet.bbs");

org.r3.jsportlet.bbs.BBSThreadPortletActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.bbs.BBSThreadPortletView(aDetailViewContainerId, this);
	},

	close : function()
	{
		// M20140201 - org.r3.PageManager.popBreadCrumb();
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

	open : function(aTopicId, aThreadId, anOptionsHash)
	{				
		this.detailView.open(aTopicId, aThreadId);			
	}	
	
});


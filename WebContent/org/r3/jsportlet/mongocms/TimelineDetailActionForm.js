$.r3Utils.namespace("org.r3.jsportlet.mongocms");

org.r3.jsportlet.mongocms.TimelineDetailActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aChildEntityListViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.mongocms.TimelineDetailActionFormView(aDetailViewContainerId, this);
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

	open : function(aTimelineDataBean)
	{
		this.setDataBeanInfo(aTimelineDataBean);
		this.detailView.open(aTimelineDataBean);			
	},
	
	onNewTimelineCreated : function(timelineDataBean)
    {  	    
	     this.pageManager.onNewTimelineCreated(timelineDataBean);
    },
    
    closeTimelinePanel : function()
    {  	    
	     this.pageManager.closeTimelinePanel();
    }
		

});


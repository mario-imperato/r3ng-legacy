$.r3Utils.namespace("org.r3.discussion");

org.r3.discussion.NavigatorActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aChildEntityListViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.discussion.NavigatorActionFormView(aDetailViewContainerId, this);
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

	open : function(pageInfo, cardInfo, topicInfo, anOptionsHash)
	{
		var defaults =
		{
			newThread : false
		};
		
		var options = $.extend({}, defaults, anOptionsHash);
		
		this.detailView.open(pageInfo, cardInfo, topicInfo, options);			
	},
	
    openThreadDetailActionFormPanel : function(aTopicId, aThreadId)
	{		 		 		 
	    this.pageManager.openThreadDetailActionFormPanel(aTopicId, aThreadId);
	},
	
	openTopicInfoActionFormPanel: function(aTopicDTOAdapter)
	{
		this.pageManager.openTopicInfoActionFormPanel(aTopicDTOAdapter);
	}
	
	
});


$.r3Utils.namespace("org.r3.jsportlet.mongotimeline");

org.r3.jsportlet.mongotimeline.TimelineActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aTimeLineViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.timelineView = new org.r3.jsportlet.mongotimeline.TimelineActionFormView(aTimeLineViewContainerId, this);
	},

	close : function()
	{

		this.timelineView.close();
	},

	hide : function()
	{
		this.timelineView.hide();
	},

	show : function()
	{

		this.timelineView.show();
	},

	refresh : function()
	{
		
	},

	open : function(aTimelineEventListener, aSetOfTimelineParams)
	{		
	   // le LUT potrebbero essere giaà caricate. Inserire un check in questo senso. 
	   var networkRequestsQueue = [];		
	   networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_graphcontentdef'));
	   networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_contentclassdef'));	
	   
	   org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
		   this.timelineView.open(aTimelineEventListener, aSetOfTimelineParams);	
 		 }),

		function(d)
		{
			console.error("controller did not load");
		});   	
	},
	
	newPost: function(aContentDefinitionId, aTimelineId)
	{
		this.timelineView.newPost(aContentDefinitionId, aTimelineId);
	}
	
});


$.r3Utils.namespace("org.r3.jsportlet.mongotimeline");

org.r3.jsportlet.mongotimeline.PostActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aPostViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.postView = new org.r3.jsportlet.mongotimeline.PostActionFormView(aPostViewContainerId, this);
	},

	close : function()
	{

		this.postView.close();
	},

	hide : function()
	{
		this.postView.hide();
	},

	show : function()
	{

		this.postView.show();
	},

	refresh : function()
	{
		
	},

	open : function(aPostId)
	{		
	   // le LUT potrebbero essere giaà caricate. Inserire un check in questo senso. 
	   var networkRequestsQueue = [];		
	   networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_graphcontentdef'));
	   networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_contentclassdef'));	
	   
	   org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
		   this.postView.open(aPostId);	
 		 }),

		function(d)
		{
			console.error("controller did not load");
		});   	
	}
	
});


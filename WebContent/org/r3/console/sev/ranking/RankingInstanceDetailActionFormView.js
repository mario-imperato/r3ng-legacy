$.r3Utils.namespace("org.r3.console.sev.ranking");


org.r3.console.sev.ranking.RankingInstanceDetailActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},

	open : function(aRankInstanceDTOAdapter)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : $.r3Utils.formatDMSUrl4ClientAccess(aRankInstanceDTOAdapter.dataBean.racefiledmsurl),
			dataType : "html"
		});

		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			$(this.htmlContainerId).html(responseData['view']);
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	}
	
});

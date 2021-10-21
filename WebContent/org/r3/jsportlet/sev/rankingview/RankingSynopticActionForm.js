$.r3Utils.namespace("org.r3.jsportlet.sev.rankingview");

org.r3.jsportlet.sev.rankingview.RankingSynopticActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, instancePrintableFlag)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.sev.rankingview.RankingSynopticActionFormView(aDetailViewContainerId, this);
		
		this.instancePrintable = instancePrintableFlag;
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

	refresh: function()
	{
	},
	
	open : function()
	{		
		// Param was aRankInstanceDTOAdapter
		this.detailView.open();		
	},
	
	openRankingInstanceViewer: function(aRankInstanceId, onError)
	{
		var _self = this;
		
		var method = "GET";
		var restUrl = null;
		restUrl = org.r3.PageManager.getRESTUrl('GET_Ranking_Instance_Detail', [ 'RankId', aRankInstanceId ]),

		org.r3.PageManager.wait("org.r3.message.waiting");
		$.ajax(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"success" : function(responseData)
			{
				org.r3.PageManager.closeNotifier();
				
				var rankingInstanceDataBean =  null;
				if (responseData)
				{
					rankingInstanceDataBean = new org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewDTOAdapter(responseData);		
				}
				
				// In questo caso se la child viene aperta in fullScreen allora non debbo nascondere il padre in quanto al rientro dal fullscreen questi rimarrebbe nascosto.
				if (!_self.instancePrintable || rankingInstanceDataBean.isRankType('rank_filedet'))
				        _self.hide();
				
				_self.pageManager.openRankingInstanceViewer(rankingInstanceDataBean);		
			},
			
			"error" : function(jqXHR, timeout, message)
			{
				org.r3.PageManager.closeNotifier();
				console.error("org.r3.jsportlet.sev.rankingview.RankingSynopticActionForm: ", message);
				if (onError)
					onError(jqXHR, timeout, message);	
			}
		});

	}
		
});


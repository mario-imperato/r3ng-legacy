$.r3Utils.namespace("org.r3.console.sev.ranking");

org.r3.console.sev.ranking.RankingInstanceDetailActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.console.sev.ranking.RankingInstanceDetailActionFormView(aDetailViewContainerId, this);
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
	
	open : function(aRankInstanceDTOAdapter)
	{
		this.setDataBeanInfo(aRankInstanceDTOAdapter);
		this.detailView.open(aRankInstanceDTOAdapter);		
	}

		
});


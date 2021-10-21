$.r3Utils.namespace("org.r3.jsportlet.sev.rankingview");

org.r3.jsportlet.sev.rankingview.RankingInstanceViewerCyFileActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, instancePrintableFlag)
	{
		this.setPageManager(aPageManager);

 	    this.detailView = new org.r3.jsportlet.sev.rankingview.RankingInstanceViewerCyFileActionFormView(aDetailViewContainerId, this);
		this.printableDetailView = new org.r3.jsportlet.sev.rankingview.RankingInstanceViewerCyFilePrintableActionFormView(aDetailViewContainerId, this);

		this.instancePrintableFlag = instancePrintableFlag;
		this.actualView = null;
	},

	close : function()
	{
		// if (!this.instancePrintable)
		//    org.r3.PageManager.popBreadCrumb();
		
		this.hide();
	},

	hide : function()
	{
		this.actualView.hide();
	},

	show : function()
	{
		this.actualView.show();
	},

	refresh: function()
	{
	},
	
	open : function(aRankInstanceDTOAdapter)
	{
		this.setDataBeanInfo(aRankInstanceDTOAdapter);
		
		this.actualView = this.detailView;
		if (this.instancePrintableFlag)
			this.actualView = this.printableDetailView;
		
		this.actualView.open(aRankInstanceDTOAdapter, this.instancePrintable);		
	}

		
});


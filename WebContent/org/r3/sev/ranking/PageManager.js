$.r3Utils.namespace("org.r3.sev.ranking");

org.r3.sev.ranking.PageManager = 
{
  	
	 init: function()
	 { 
		org.r3.PageManager.googleAnalyticsSendPageView();
					 
		 this.rankingSynopticActionForm = new org.r3.jsportlet.sev.rankingview.RankingSynopticActionForm(this, "#rankingSynopticActionForm", true );

		 this.rankingInstanceViewerActionForm = new org.r3.jsportlet.sev.rankingview.RankingInstanceViewerActionForm(this, '#rankingInstanceViewerActionForm', '#rankingInstanceViewerActionForm_Entries', false);
		 this.rankingInstanceViewerCyFileActionForm = new org.r3.jsportlet.sev.rankingview.RankingInstanceViewerCyFileActionForm(this, '#canvas_report_content', true);
		 
		 this.openSynopticPanel();
	 },
	 
	
		openSynopticPanel: function()
		{
			org.r3.PageManager.pushHomeBreadCrumb();			 
			org.r3.PageManager.pushBreadCrumb(
			{
				"title" : "Quadro Sinottico Classifiche",
				"actionForm" : this.rankingSynopticActionForm
			});

			this.rankingSynopticActionForm.open();		
		},
		
		openRankingInstanceViewer: function(aRankingInstanceViewDTOAdapter)
		{			
			if (aRankingInstanceViewDTOAdapter.isRankType('rank_filedet'))
			{
				org.r3.PageManager.pushBreadCrumb(
				{
					"title" : "Dettaglio Classifica",
					"actionForm" : this.rankingInstanceViewerActionForm
				});
				
				this.rankingInstanceViewerActionForm.open(aRankingInstanceViewDTOAdapter);					
			}
			else
			{
				org.r3.PageManager.openFullScreenLayout(this.rankingInstanceViewerCyFileActionForm);
				this.rankingInstanceViewerCyFileActionForm.open(aRankingInstanceViewDTOAdapter);						
			}			
		},
		
		openPrintableRankingInstanceViewer: function(aRankingInstanceViewDTOAdapter)
		{
			org.r3.PageManager.openFullScreenLayout(this.rankingInstanceViewerCyFileActionForm);
			this.rankingInstanceViewerCyFileActionForm.open(aRankingInstanceViewDTOAdapter);	
		}

};


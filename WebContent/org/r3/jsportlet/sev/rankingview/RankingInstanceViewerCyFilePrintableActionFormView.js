$.r3Utils.namespace("org.r3.jsportlet.sev.rankingview");

org.r3.jsportlet.sev.rankingview.RankingInstanceViewerCyFilePrintableActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		$('#infoLine_rankinginstanceviewer').infoLine('destroy');
		this.hide();
	},

	open : function(aRankInstanceDTOAdapter)
	{
		var _self = this;
		
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/rankingview/RankingInstanceViewerCyFilePrintableActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});

		networkRequestsQueue.push(
		{
			id : "content",
			type : "Get",
			url : $.r3Utils.formatDMSUrl4ClientAccess(aRankInstanceDTOAdapter.dataBean.racefiledmsurl),
			dataType : "html"
		});
				
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_boatgroup'));
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_raceclass'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

    		var templatedHtml = tmpl(responseData['view'], { "aRankInstanceDTOAdapter": aRankInstanceDTOAdapter });
     		$(this.htmlContainerId).html(templatedHtml);		
     		$('#rankinginstancevieweractionform_htmlcanvas').html(responseData['content']);
     		   
// 		    $('#appviewer_action_print').unbind().click(function(e) 
// 		    {
// 		    	window.print();	
// 		    });
//
// 		    $('#appviewer_action_back').unbind().click(function(e) 
// 		    {
// 		    	_self.actionFormManager.close();
// 		        org.r3.PageManager.closeFullScreenLayout();	
// 		    });
 		    
 		   if (aRankInstanceDTOAdapter.isOverallInstance())
 		        $('#canvas_report_title').html("Classifica Generale: " + aRankInstanceDTOAdapter.dataBean.ranktitle);
 		   else
 			    $('#canvas_report_title').html("Classifica: " + aRankInstanceDTOAdapter.dataBean.ranktitle);
			
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	}
	
});

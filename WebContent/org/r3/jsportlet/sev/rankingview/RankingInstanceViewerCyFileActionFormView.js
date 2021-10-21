$.r3Utils.namespace("org.r3.jsportlet.sev.rankingview");


org.r3.jsportlet.sev.rankingview.RankingInstanceViewerCyFileActionFormView = org.r3.ActionFormView.extend(
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

	open : function(aRankInstanceDTOAdapter, printable)
	{
		var _self = this;
		
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/rankingview/RankingInstanceViewerCyFileActionFormView.html.jsp?mode=detail'),
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

			$(this.htmlContainerId).html(responseData['view']);
			$('#rankinginstancevieweractionform_htmlcanvas').html(responseData['content']);
			
  		    var infoLineItems = [];
			
  		    if (aRankInstanceDTOAdapter.isOverallInstance())
  		    {
  		    	infoLineItems.push({ id: "infoline_title",      label: "Classifica Generale", value: aRankInstanceDTOAdapter.dataBean.ranktitle });
  		    	infoLineItems.push({ id: "infoline_racegroup",  label: "Raggrupp.", value: aRankInstanceDTOAdapter.getRacegroup() || 'n.d.' });
  		    	infoLineItems.push({ id: "infoline_raceclass",  label: "Classe", value: aRankInstanceDTOAdapter.getRaceclass()  || 'n.d.' });
  		    }
  		    else
  		    {
  		    	infoLineItems.push({ id: "infoline_title",      label: "Classifica", value: aRankInstanceDTOAdapter.dataBean.ranktitle });
  		    	infoLineItems.push({ id: "infoline_racegroup",  label: "Raggrupp.", value: aRankInstanceDTOAdapter.getRacegroup() || 'n.d.' });
  		    	infoLineItems.push({ id: "infoline_raceclass",  label: "Classe", value: aRankInstanceDTOAdapter.getRaceclass()  || 'n.d.' });
  		    	
  		    	infoLineItems.push({ id: "infoline_racenumber", label: "N.Prova", value: aRankInstanceDTOAdapter.dataBean.racenumber });
  		    	infoLineItems.push({ id: "infoline_racedate",   label: "Data", value: aRankInstanceDTOAdapter.getRacedate() });
  		    	infoLineItems.push({ id: "infoline_racetime",   label: "Ora", value: aRankInstanceDTOAdapter.getRacetime() });
  		    	infoLineItems.push({ id: "infoline_racedistance",   label: "Distanza", value: aRankInstanceDTOAdapter.dataBean.racedistance });
  		    	infoLineItems.push({ id: "infoline_racerating", label: "Rating", value: aRankInstanceDTOAdapter.dataBean.racerating });
  		    }
  		    
  		    infoLineItems.push({ id: "infoline_instanceid", label: "Id.", value: aRankInstanceDTOAdapter.dataBean.instanceid });
  		    
		    $('#infoLine_rankinginstanceviewer').infoLine({
           	  groupId: "ranking_instance",
  	          items: infoLineItems  	         	     
            });
			
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	}
	
});

$.r3Utils.namespace("org.r3.jsportlet.sev.rankingview");


org.r3.jsportlet.sev.rankingview.RankingSynopticActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},

	open : function()
	{
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/rankingview/RankingSynopticActionFormView.html.jsp?mode=detail'),
			dataType : "html"
		});

		networkRequestsQueue.push(
		{
			id : "content",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_RankingSynoptic'),
			dataType : "json"
		});
		
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_sinott'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			
			
			var synopticData = responseData['content'];
			if (synopticData)
			{
				// Ottengo una lista di classifiche ordinate in maniera opportuna e con una sottolista di risultati o istanze.
				synopticData = new org.r3.db.DTOTableAdapter(synopticData, function(aRowDataBean) { return new org.r3.db.sailevent.rankingview.RankingViewSynopticDTOAdapter(aRowDataBean); });
                
                var synopticReport = [];
                var ranktitle = null;
                var rankinggroup = null;
                var synopticReportNode = null;
                for(var h = 0; h < synopticData.getNumberOfItems(); h++)
                {
                	var theItem = synopticData.getItem(h);
                	
                	// Schiaccio in orizzontale le istanze passando da +righe a +colonne.
                	var theItemData = theItem.getSynopticItemData(this._getMaxNumberOfRaces());
                	
                	// Aggrego classifiche di uguale racgroup insieme.
                	if (rankinggroup == null || theItem.dataBean.rankinggroup != rankinggroup)
                	{
                		if (synopticReportNode)                    	
                			synopticReport.push(synopticReportNode);

                		// title contiene il titolo della classifica o raggruppamento
                		// items invece contiene le singole classifiche schiacciate. Ogni item prevede un attributo raceclass e 0 o piu' instances.. 
                		synopticReportNode = {
                			title: theItem.dataBean.rankinggroup, // theItem.dataBean.ranktitle,
                		    items: []
                		};
                	}
                	
                	synopticReportNode.items.push(theItemData);
                	rankinggroup = theItem.dataBean.rankinggroup;	                        	        
                }

        		if (synopticReportNode)                    	
        			synopticReport.push(synopticReportNode);
                
			}
			
			var templatedHtml = tmpl(responseData['view'], { "numOfRaces": this._getMaxNumberOfRaces(), "rankData": synopticReport });
			$(this.htmlContainerId).html(templatedHtml);
				
			$(this.htmlContainerId + ' table').dataTable({
				"responsive" : true,
				"bPaginate" : false,
				"bLengthChange" : false,
				"sDom" : 't',
				"bSort" : false,
				"bInfo" : false,	
			});
					
			$('#rankingsynopticactionform_fieldset_message').formmessage({});
			
			var matchExpr = '.synoptic_link';
			$(document).off('click', matchExpr).on('click', matchExpr, $.r3Utils.hitch(this, this.onRankingSelected));			
			
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
	onRankingSelected: function(e)
	{
		var currentTargetId = $(e.currentTarget).attr('id');
		
		this.actionFormManager.openRankingInstanceViewer(currentTargetId,
				function(jqXHR, timeout, message) { 
			$('#rankingsynopticactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); });
	},
	
	_getMaxNumberOfRaces: function()
	{
		if (org.r3.SiteConstants.sailEventRanking && org.r3.SiteConstants.sailEventRanking.maxraces)
		{
		   return parseInt(org.r3.SiteConstants.sailEventRanking.maxraces);
		}
		
		return 10;
	}
	
});

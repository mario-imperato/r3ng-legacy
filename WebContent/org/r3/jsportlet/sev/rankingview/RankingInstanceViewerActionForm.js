$.r3Utils.namespace("org.r3.jsportlet.sev.rankingview");

org.r3.jsportlet.sev.rankingview.RankingInstanceViewerActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aChildEntityListViewContainerId, consoleContextFlag)
	{
		this.setPageManager(aPageManager);
		this.detailView = new org.r3.jsportlet.sev.rankingview.RankingInstanceViewerActionFormView(aDetailViewContainerId, this);
		this.listView = new org.r3.db.sailevent.rankinginstancedetailview.RankingInstanceDetailViewQueryActionFormView
		(
				aChildEntityListViewContainerId, 
				this,
				{
					dataTableId : 'RankingInstanceDetailViewQueryActionFormView',
					gradeLevel : 'grade_level5 grade_clickable',
					legend : 'Dettaglio Classifica',	
					iDisplayLength: 50,
					layout : 'fullWidth',
					sortable: true,
					// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
					dataTableColumns : "pos;sort,sailnumber,yachtname,owner,arrivaldate,realtime;sort,drealtime,correctedtime;sort,annotation,perctempen,score",
					requiredLUTs : [ 
                        "GET_classifier_sys_recstatus" ],
					
                    onDblClick : null,
                    onSelected :  null, // $.r3Utils.hitch(this, this.onEntrySelected),
					onClearSelection : null,
					
					actionBarOnTop: true,
					buttons : [
					{
						id : 'ranking_action_showcyfile',
						label : 'Visualizza File CyberAltura',
						disabled : false,
						onClick : $.r3Utils.hitch(this, this.onShowCyFile)
					},

					{
						id : 'ranking_action_hidecyfile',
						label : 'Nascondi File CyberAltura',
						disabled : false,
						onClick : $.r3Utils.hitch(this, this.onHideCyFile)
					},

					{
						id : 'ranking_action_printcyfile',
						label : 'Versione Stampabile',
						disabled : false,
						onClick : $.r3Utils.hitch(this, this.onPrintCyFile)
					}										
                    ],

					onInitializationComplete: function()
					{

						if (consoleContextFlag)
						{
							$('#ranking_action_showcyfile').show();
							$('#ranking_action_hidecyfile').hide();	
							$('#ranking_action_printcyfile').hide();
						}
						else
						{
							$('#ranking_action_showcyfile').hide();
							$('#ranking_action_hidecyfile').hide();	
							$('#ranking_action_printcyfile').show();							
						}
					}
				}
		);

		this.consoleContext = consoleContextFlag;
	},

	close : function()
	{
		// if (!this.instancePrintable)
		//    org.r3.PageManager.popBreadCrumb();
		
		this.hide();
	},

	hide : function()
	{
		this.detailView.hide();
		this.listView.hide();
	},

	show : function()
	{
		this.detailView.show();
		this.listView.show();
	},

	refresh: function()
	{
	},
	
	open : function(aRankInstanceDTOAdapter)
	{
		this.setDataBeanInfo(aRankInstanceDTOAdapter);
		this.detailView.open(aRankInstanceDTOAdapter, this.consoleContext);	
		
		var dataTableSource = org.r3.PageManager.getRESTUrl('GET_Ranking_Instance_Entries', 
				[ aRankInstanceDTOAdapter.dataBean.rankid, aRankInstanceDTOAdapter.dataBean.instanceid ]);
		
		// var dataTableColumns = "pos;sort,sailnumber,yachtname,yachtrating,owner,club,model,division,racegroup,arrivaldate,realtime;sort,drealtime,correctedtime;sort,annotation,score";		
		var dataTableColumns = "pos;sort,boatinfo,yachtrating,division,racegroup,arrivaldate,realtime;sort,drealtime,correctedtime;sort,annotation,perctempen,score";		

		if (aRankInstanceDTOAdapter.isOverallInstance())
		{
		   dataTableColumns = "pos;sort,sailnumber,yachtname,owner,club,model,division,racegroup";
		   if (aRankInstanceDTOAdapter.dataBean.racenumber > 0)
		   {
			  for(var i = 1; i <= aRankInstanceDTOAdapter.dataBean.racenumber; i++)
			  {
				  dataTableColumns += ",scoreoverall" + i;  
			  }
		   }
		   dataTableColumns += ",score";
		}
		
		// Sostituisco il pattern. E' piu' semplice considerando che ho 4 combinazioni in totale e la costruzione sarebbe
		// meno leggibile.
		if (aRankInstanceDTOAdapter.isRankRateOrg('rank_orc'))
		{
			dataTableColumns = dataTableColumns.replace('yachtrating', 'yachtgph');	
		}
		else
			dataTableColumns = dataTableColumns.replace('yachtrating', 'yachtbsf');	
					
		this.listView.open({
				"dataTableSource": dataTableSource,
				"dataTableColumns" : dataTableColumns,		

				"onInitializationCompleteArgs": arguments
		});
	},

	onEntrySelected: function(aRankInstanceDTOAdapter)
	{
		var qparams = [];
		qparams.push(
		{
			"name": "rankentryid", "value" : aRankInstanceDTOAdapter.dataBean.rankentryid + ''
		});
		
//		var o1 = {};
//		for(var vx in o1)
//		{
//			if (o1.hasOwnProperty(vx)) 
//	   	       console.log("Empty Loop: ", vx);
//			else
//			   console.log("Dunno: ");
//		}
//		
//		var o = qparams[0];
//		for(pname in o)
//    	{
//	   	   	   if (o[pname] && o[pname].length > 0)
//	   	   	   {
//	   	   	       console.log("Param: " + o[pname]);
//	   	   	       // console.log("Pname: ", pname, param[pname], this.queryParams[pname]);
//	   	   	   }
//    	}
		
		this.listView._executeAdvancedSearch(qparams);
	},
	
	onShowCyFile: function()
	{
		this.detailView.showCyFile();
		$('#ranking_action_showcyfile').hide();
		$('#ranking_action_hidecyfile').show();
	},
	
	onHideCyFile: function()
	{
		this.detailView.hideCyFile();
		$('#ranking_action_showcyfile').show();
		$('#ranking_action_hidecyfile').hide();
	},

	onPrintCyFile: function()
	{
		this.pageManager.openPrintableRankingInstanceViewer(this.dataBeanInfo);
	}
	
});


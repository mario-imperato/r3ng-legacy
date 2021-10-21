$.r3Utils.namespace("org.r3.jsportlet.wbs.dashboard");

org.r3.jsportlet.wbs.dashboard.WBSPortletDashBoardActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, optionHash)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		
		this.defaultOptions = {
		
			"isPrinted": false
			
		};
		
		this.options = $.extend({}, this.defaultOptions, optionHash);
	},

	close : function()
	{
		this.hide();
	},
	
	open : function(aWbsId_OR_aWbsDTOAdapter)
	{		
		// org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/wbs/dashboard/WBSPortletDashBoardActionForm.html.jsp'),
			dataType : "html"
		});
		
		if (_.isString(aWbsId_OR_aWbsDTOAdapter))
		{
			networkRequestsQueue.push(
			{
				id : "wbsdetail",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl("GET_WBSTree", [ aWbsId_OR_aWbsDTOAdapter ]),
				dataType : "json"
			});
		}				
				
		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_r3ea_completion'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			// org.r3.PageManager.closeNotifier();			 	
		
			var wbsDTOAdapter = aWbsId_OR_aWbsDTOAdapter;
			if (_.isString(aWbsId_OR_aWbsDTOAdapter))
			{
				wbsDTOAdapter = new org.r3.db.wbs.wbs.WBSDTOAdapter(responseData["wbsdetail"]);				
			}
			
			$(this.htmlContainerId).html(responseData['view']);
			
			var wbsROI = wbsDTOAdapter.getROI();
			if (wbsROI)			  
			      $(this.htmlContainerId + ' .wbsroi_canvas').html('ROI: ' + wbsDTOAdapter.getROI());
			
			this.renderGantt(this.htmlContainerId + ' .wbs_dashboard .gantt', wbsDTOAdapter);
			
			var wbsStatInfo = wbsDTOAdapter.collectWbsStatInfo();
			this.renderFlotChart1(this.htmlContainerId + ' .wbs_dashboard .qplot_cnt .qplot_wbspie1', wbsDTOAdapter, wbsStatInfo);
			this.renderFlotChart2(this.htmlContainerId + ' .wbs_dashboard .qplot_cnt .qplot_wbspie2', wbsDTOAdapter, wbsStatInfo);
			// this.renderPie1Chart(this.htmlContainerId + ' .wbs_dashboard .qplot_cnt .qplot_wbspie1', wbsDTOAdapter, wbsStatInfo);
			// this.renderPie2Chart(this.htmlContainerId + ' .wbs_dashboard .qplot_cnt .qplot_wbspie2', wbsDTOAdapter, wbsStatInfo);

			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
		
	},
	
	renderGantt: function(divContainer, aWbsDTOAdapter)
	{		
		var theWbsNodes = aWbsDTOAdapter.getListOfWbsNodes();  
		if (theWbsNodes) 
		{ 
			var ganttSource = [];
		    for(var j = 0; j < theWbsNodes.length; j++)
		    {
		       var aNode = theWbsNodes[j];
		       var s = aNode.getGanttSource();
		       
		       if (s)
		          ganttSource.push(s);
		    }
		    
		    $(divContainer).gantt({				
				scale: "days",
	            minScale: "days",
	            maxScale: "months",
	            navigate: "scroll",
	            source: ganttSource
	        });
		}		
               	
	},
	
	renderFlotChart1: function(divContainer, aWbsDTOAdapter, v)
	{
		if (v.numberOfActions > 0)
		{
			var pieData = [
			     { label: org.r3.jsportlet.wbs.dashboard.message.numberOfCompleted, data: v.numberOfCompleted },
				 { label: org.r3.jsportlet.wbs.dashboard.message.numberOfStarted,  data: v.numberOfStarted },
				 { label: org.r3.jsportlet.wbs.dashboard.message.numberOfNotStarted, data: v.numberOfNotStarted }
			];

			var seriesColors =  [ 
			      "#34B501", "#FFC300", "#999999", "#B50501", 
			      "#4bb2c5", "#c5b47f", "#EAA228", "#579575", "#839557", "#958c12",
			      "#953579", "#4b5de4", "#d8b83f", "#ff5800", "#0085cc"
			];

			var idQPlotCanvas = 'qplot_wbspie1_' + aWbsDTOAdapter.dataBean.wbsid;
			if (this.options.isPrinted)
				idQPlotCanvas = idQPlotCanvas + '_printed';
			
			var placeHolder = $(divContainer);
			placeHolder.attr('id', idQPlotCanvas);
			
			placeHolder.unbind();
			$.plot(placeHolder, pieData, {
				series: {
					pie: { 
						show: true,
						radius: 1,
						label: {
							show: true,
							radius: 3/4,
							formatter: 	function(label, slice) {
						      return "<div style='font-size:small;text-align:center;padding:2px;color:" + '#ffffff' + ";'>" + Math.round(slice.percent) + "%</div>";
					    },
							background: {
								opacity: 0.8
							}
						}
					}
				},
				legend: {
					show: true,
					container: '.qplot_wbspie1_legend'
				},
				
				colors: seriesColors
		    });			
		}
		
		var canvas = $('#' + idQPlotCanvas + ' .flot-base'); //  .document.getElementById("mycanvas");
		var img    = canvas[0].toDataURL("image/png");
		
		$('#' + idQPlotCanvas + ' canvas').remove(); //  .document.getElementById("mycanvas");			
		$('#' + idQPlotCanvas).append('<img src="'+img+'"/>');

	},
	
	renderFlotChart2: function(divContainer, aWbsDTOAdapter, v)
	{
		if (v.numberOfActions > 0)
		{
			var pieData = [
			     { label: org.r3.jsportlet.wbs.dashboard.message.numberOfOnTimeCompleted, data: v.numberOfCompleted - v.numberOfLateCompleted },
				 { label: org.r3.jsportlet.wbs.dashboard.message.numberOfLateCompleted, data:  v.numberOfLateCompleted },
				 { label: org.r3.jsportlet.wbs.dashboard.message.numberOfOnTimeIncomplete, data: v.numberOfStarted + v.numberOfNotStarted - v.numberOfLateIncomplete },
				 { label: org.r3.jsportlet.wbs.dashboard.message.numberOfLateIncomplete, data: v.numberOfLateIncomplete }
			];

			var seriesColors =  [ 
   			      "#34B501", "#4040FF", "#FFC300", "#B50501", 
   			      "#4bb2c5", "#c5b47f", "#EAA228", "#579575", "#839557", "#958c12",
   			      "#953579", "#4b5de4", "#d8b83f", "#ff5800", "#0085cc"
   			];
			
			var idQPlotCanvas = 'qplot_wbspie2_' + aWbsDTOAdapter.dataBean.wbsid;
			if (this.options.isPrinted)
				idQPlotCanvas = idQPlotCanvas + '_printed';
			
			var placeHolder = $(divContainer);
			placeHolder.attr('id', idQPlotCanvas);
			
			placeHolder.unbind();
			$.plot(placeHolder, pieData, {
				series: {
					pie: { 
						show: true,
						radius: 1,
						label: {
							show: true,
							radius: 3/4,
							formatter: 	function(label, slice) {
						      return "<div style='font-size:small;text-align:center;padding:2px;color:" + '#ffffff' + ";'>" + Math.round(slice.percent) + "%</div>";
					    },
							background: {
								opacity: 0.8
							}
						}
					}
				},
				legend: {
					show: true,
					container: '.qplot_wbspie2_legend'
				},
				
				colors: seriesColors
		    });		
			
			var canvas = $('#' + idQPlotCanvas + ' .flot-base'); //  .document.getElementById("mycanvas");
			var img    = canvas[0].toDataURL("image/png");
			
			$('#' + idQPlotCanvas + ' canvas').remove(); //  .document.getElementById("mycanvas");			
			$('#' + idQPlotCanvas).append('<img src="'+img+'"/>');
			
			
			
		}		
	},
	
	renderPie2Chart: function(divContainer, aWbsDTOAdapter, v)
	{
		if (v.numberOfActions > 0)
		{
			var pieData = [
			     [org.r3.jsportlet.wbs.dashboard.message.numberOfOnTimeCompleted, v.numberOfCompleted - v.numberOfLateCompleted],
				 [org.r3.jsportlet.wbs.dashboard.message.numberOfLateCompleted,  v.numberOfLateCompleted],
				 [org.r3.jsportlet.wbs.dashboard.message.numberOfOnTimeIncomplete, v.numberOfStarted + v.numberOfNotStarted - v.numberOfLateIncomplete],
				 [org.r3.jsportlet.wbs.dashboard.message.numberOfLateIncomplete, v.numberOfLateIncomplete]
			];

			var seriesColors =  [ 
   			      "#34B501", "#4040FF", "#FFC300", "#B50501", 
   			      "#4bb2c5", "#c5b47f", "#EAA228", "#579575", "#839557", "#958c12",
   			      "#953579", "#4b5de4", "#d8b83f", "#ff5800", "#0085cc"
   			];
			
			var idQPlotCanvas = 'qplot_wbspie2_' + aWbsDTOAdapter.dataBean.wbsid;
			if (this.options.isPrinted)
				idQPlotCanvas = idQPlotCanvas + '_printed';
			
			$(divContainer).attr('id', idQPlotCanvas);
			
		    var plot1 = $.jqplot(idQPlotCanvas, [ pieData ], {
		        gridPadding: {top:0, bottom:38, left:0, right:0},
		        seriesDefaults:{
		            renderer:$.jqplot.PieRenderer, 
		            trendline:{ show:false }, 
		            rendererOptions: { padding: 8, showDataLabels: true, dataLabelFormatString: "%#.1f%%" }
		        },
		        legend:{
		            show:true, 
		            placement: 'outside', 		            
		            location:'e'		           
		        },
		        gridPadding: { top: 0, right: 0, bottom: 0, left: 0 },
		        "seriesColors" : seriesColors
		    });			
		}
	},
	
	renderPie1Chart: function(divContainer, aWbsDTOAdapter, v)
	{
		if (v.numberOfActions > 0)
		{
			var pieData = [
			     [org.r3.jsportlet.wbs.dashboard.message.numberOfCompleted, v.numberOfCompleted],
				 [org.r3.jsportlet.wbs.dashboard.message.numberOfStarted,  v.numberOfStarted],
				 [org.r3.jsportlet.wbs.dashboard.message.numberOfNotStarted, v.numberOfNotStarted]
			];

			var seriesColors =  [ 
			      "#34B501", "#FFC300", "#999999", "#B50501", 
			      "#4bb2c5", "#c5b47f", "#EAA228", "#579575", "#839557", "#958c12",
			      "#953579", "#4b5de4", "#d8b83f", "#ff5800", "#0085cc"
			];

			var idQPlotCanvas = 'qplot_wbspie1_' + aWbsDTOAdapter.dataBean.wbsid;
			if (this.options.isPrinted)
				idQPlotCanvas = idQPlotCanvas + '_printed';
			
			$(divContainer).attr('id', idQPlotCanvas);
		    var plot1 = $.jqplot(idQPlotCanvas, [ pieData ], {
		        gridPadding: {top:0, bottom:38, left:0, right:0},
		        seriesDefaults:{
		            renderer:$.jqplot.PieRenderer, 
		            trendline:{ show:false }, 
		            rendererOptions: { padding: 8, showDataLabels: true, dataLabelFormatString: "%#.1f%%" }
		        },
		        legend:{
		            show:true, 
		            placement: 'outside', 
		            location:'e'
		        },
		        gridPadding: { top: 0, right: 0, bottom: 0, left: 0 },
		        "seriesColors" : seriesColors
		    });			
		}
	}

		
});

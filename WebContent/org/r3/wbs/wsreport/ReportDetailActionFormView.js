$.r3Utils.namespace("org.r3.wbs.wsreport");


org.r3.wbs.wsreport.ReportDetailActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, isPrintedFlag)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		
		this.dashboardView = null;		
		
		this.isPrinted = isPrintedFlag;
		this.wbsId = null;
	},

	close : function()
	{
		this.hide();
	},

	open : function(aWbsId)
	{
		var _self = this;
		this.wbsId = aWbsId;
		
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];		

		if (aWbsId)
		{
		networkRequestsQueue.push(
		{
			id : "wbsdetail",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl("GET_WBSTree", [ aWbsId ]),
			dataType : "json"
		});	
		
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/wbs/wsreport/ReportDetailActionFormView_WBS.html.jsp'),
			dataType : "html"
		});		
		}
		else
		{
			networkRequestsQueue.push(
			{
				id : "wbses",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl("GET_WBSes_WithNodes"),
				dataType : "json"
			});		

			networkRequestsQueue.push(
			{
				id : "view",
				type : "Get",
				url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/wbs/wsreport/ReportDetailActionFormView_FULL.html.jsp'),
				dataType : "html"
			});				
		}
		

				
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();
		    
			var wbsDTOAdapter = null;   // Viene utilizzata successivamente per la dash board
			var templatedHtml = null;
			if (aWbsId)
			{
				wbsDTOAdapter = new org.r3.db.wbs.wbs.WBSDTOAdapter(responseData["wbsdetail"]);				
				templatedHtml = tmpl(responseData['view'], { 
 					 "isPrinted": this.isPrinted,
	 		    	 "wbs": wbsDTOAdapter
	 		    });
			}
			else
			{
				var wbsesDataTableAdapter = responseData['wbses'];
		    	wbsesDataTableAdapter = new org.r3.db.DTOTableAdapter(wbsesDataTableAdapter, 
					function(aRowDataBean) { return new org.r3.db.wbs.wbs.WBSDTOAdapter(aRowDataBean); });	
		    	
		    	templatedHtml = tmpl(responseData['view'], {
		    		 "isPrinted": this.isPrinted,
	 		    	 "wbses": wbsesDataTableAdapter
	 		    });
			}			
 		    
 		    $(this.htmlContainerId).html(templatedHtml); 	
 		    
 		    if (this.isPrinted)
 		    {
	 		    $('#reportdetailactionform_action_print').unbind().click(function(e) 
			    {
			    	window.print();	
			    });
	
	 		    $('#reportdetailactionform_action_back').unbind().click(function(e) 
	 		    {
	 		    	_self.actionFormManager.close();
	 		        org.r3.PageManager.closeFullScreenLayout();	
	 		    });	 
 		    }
 		    else
 		    {
 	 		    $('#reportdetailactionform_action_printable').unbind().click($.r3Utils.hitch(this, this.openPrintableReportPanel));  	 		    
 		    }
 		    
 		   if (aWbsId && wbsDTOAdapter.isExecutiveOrCoach())
			{
 			    var dashBoardContainerId = '#wbs_' + aWbsId + '_dashboard';
 			    if (this.isPrinted)
 			    	dashBoardContainerId += "_printed";
 			   			    
 			    this.dashboardView = new org.r3.jsportlet.wbs.dashboard.WBSPortletDashBoardActionFormView(
 			    		dashBoardContainerId, this.actionFormManager,
 			    		{ "isPrinted" : this.isPrinted });
 			    
 			    this.dashboardView.open(wbsDTOAdapter);
			}
			else
			{
//				 for(var i = 0; i < wbsesDataTableAdapter.getNumberOfItems(); i++)
//				 {
//				    var theWbs = wbsesDataTableAdapter.getItem(i);
//				    var ganttDiv = '#wbs_' + theWbs.dataBean.wbsid + '_gantt';
//	 			    if (this.isPrinted)
//	 				   ganttDiv += "_printed";
//	 			  
//	 			    this.renderGantt(ganttDiv);
//				 }
			}		
 		   
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
	openPrintableReportPanel: function()
	{
		this.actionFormManager.openPrintableReportPanel(this.wbsId);
	}

});

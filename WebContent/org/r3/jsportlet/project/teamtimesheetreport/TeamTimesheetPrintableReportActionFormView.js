$.r3Utils.namespace("org.r3.jsportlet.project.teamtimesheetreport");

org.r3.jsportlet.project.teamtimesheetreport.TeamTimesheetPrintableReportActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},
	
	open : function(aGroupByClause, queryParams)
	{
		var _self = this;
		
		var reportTemplate = "TeamTimesheetPrintableReportActionFormView.html.jsp";
		
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/project/teamtimesheetreport/' + reportTemplate),
			dataType : "html"
		});
		
		var dataTableSource = org.r3.PageManager.getRESTUrl('GET_Timesheets');
		if (queryParams && queryParams.length)
		{
			dataTableSource = $.r3Utils.addQueryStringToUrl(dataTableSource, $.param(queryParams));	
		}
		
		networkRequestsQueue.push(
		{
			id : "content",
			type : "Get",
			url : dataTableSource,
			dataType : "json"
		});
								
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	

			var adapter = new org.r3.db.DTOTableAdapter(responseData['content'], function(aRowDataBean) { return new org.r3.db.project.resourcetimesheetview.ResourceTimesheetViewDTOAdapter(aRowDataBean); });   
		      			
			var columns = 'caldate,profileid,resourcedescr,ordeffort,exteffort,oncalleffort';
			if (aGroupByClause)
			{
			    if ($.isArray(aGroupByClause))
			   	{
			    	aGroupByClause = aGroupByClause.reduce(function (theAccumulator, anItem) { return theAccumulator + ',' + anItem; });
			   	}
			    
			    columns = aGroupByClause + ',ordeffort,exteffort,oncalleffort';
			}
			
			var columnDefs = org.r3.db.project.resourcetimesheetview.ResourceTimesheetViewQueryActionFormView_ColumnDefinitions(
 		    		'PrintableReportId', columns);
			
			var templatedHtml = tmpl(responseData['view'], { "dtoTableAdapter": adapter, "queryParams": queryParams, "columnDefinitions": columnDefs, "columns": columns });
 		    $(this.htmlContainerId).html(templatedHtml);		
	
 		    
 		   
//			$('#appviewer_action_print').unbind().click(function(e) 
// 		    {
// 		    	window.print();	
// 		    });
//
// 		    $('#appviewer_action_back').unbind().click(function(e) 
// 		    {
// 		    	_self.close();
// 		        org.r3.PageManager.closeFullScreenLayout();	
// 		    });
 		    
 		    $('#canvas_report_title').html("Report Consuntivazione"); 		     		   	       
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
		
	},
	
	_getTableColumnDefinition: function(aGroupByClause)
	{
		var tableColumnDefinition = [];
				
		if (aGroupByClause)
		{
			if (aGroupByClause.length)
			{
				aGroupByClause = aGroupByClause.reduce(function(accumulator, item) { return accumulator + ', ' + item; });
			}			
		}
		
		var fieldName = 'resourceid';
		var pushItem = true;
		if (aGroupByClause && aGroupByClause.indexOf(fieldName) < 0)
			pushItem = false;
				
		tableColumnDefinition.push({
		
			name: fieldName,
			
			value: function(aDTOAdapter) 
			{
			     return aDTOAdapter.dataBean.resourceid;	
			}
		
		});
		
		
	}

		
});

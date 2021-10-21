$.r3Utils.namespace("org.r3.jsportlet.project.teamtimesheetreport");

org.r3.jsportlet.project.teamtimesheetreport.TeamTimesheetReportActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aQueryFormViewContainerId, aDataTableViewContainerId)
	{
		this.setPageManager(aPageManager);
		
		this.lastExecutedQuery = null;
		this.lastExecutedReportType = null;
		
		this.searchFormView = new org.r3.jsportlet.project.team.TeamTimesheetReportActionFormView(aQueryFormViewContainerId, this);
		
		this.listView = new org.r3.db.project.resourcetimesheetview.ResourceTimesheetViewQueryActionFormView
		(
				aDataTableViewContainerId, 
				this,
				{
					showTemplateOnOpen: true,
					htmlTemplateUrl: org.r3.Constants.applicationContext + "/org/r3/jsportlet/project/teamtimesheetreport/TeamTimesheetReportDatatableActionFormView.html.jsp",
					
					dataTableId : 'ResourceTimesheetReportViewQueryActionFormView',					
					
					gradeLevel : 'grade_level6 grade_clickable',
					legend : org.r3.db.project.resourcetimesheetview.message.queryactionformview_legend,	
					iDisplayLength: -1,
					
					layout : 'fullWidth',
					sortable: true,
					// onInitializationComplete : $.unepUtils.hitch(this, this.populateRiepilogo),
					// dataTableColumns : "caleveday,profileid,resourcedescr,ordeffort,exteffort,oncalleffort",
					requiredLUTs : [ 
                        "GET_classifier_sys_recstatus", "LUT_DefaultCalendarMonthlyPeriod", "LUT_DefaultCalendarYearlyPeriod", "LUT_DefaultCalendarQuarterlyPeriod" ],
					                    					
					actionBarOnTop: true,
					buttons : [
					{
						id : 'resourcetimesheetreport_printableversion',
						label : 'Versione Stampabile',
						disabled : true,
						onClick : $.r3Utils.hitch(this, this._onPrintableVersion)
					} ],
					
					onServerData: function(items, data)
	              	{
	              		if (data && data.iTotalRecords)
	              			 $('#resourcetimesheetreport_printableversion').prop('disabled', false);
	              		else $('#resourcetimesheetreport_printableversion').prop('disabled', true);
	              	},
    	              	
					onInitializationComplete: $.r3Utils.hitch(this, function() {
							
						
																	
						
															
					})
				}

		);
		
	},

		
	close : function()
	{
		// M20140201 - org.r3.PageManager.popBreadCrumb();		
		this.hide();
	},

	hide : function()
	{
		this.searchFormView.hide();
	},

	show : function()
	{
		this.searchFormView.show();
	},

	refresh: function()
	{
		this.searchFormView.refresh();
	},
		
	open : function()
	{
		this.searchFormView.open();
	},
	
	executeSearch: function(groupBy, queryParams)
	{
		this.lastExecutedGroupBy = groupBy;
		this.lastExecutedQuery = queryParams;
		
		var dataTableSource = org.r3.PageManager.getRESTUrl('GET_Timesheets');
		
		this.listView.open({
			"dataTableSource": dataTableSource,
			"dataTableColumns" : this._computeDataTableColumns(groupBy),
			"queryparams": queryParams
		});
	},
	
	_onPrintableVersion: function()
	{
		this.pageManager.openTeamTimesheetReportPrintableActionFormPanel(this.lastExecutedGroupBy, this.lastExecutedQuery);			
	},
	
	_computeDataTableColumns: function(aGroupByClauseArray)
	{
		if (aGroupByClauseArray && aGroupByClauseArray.length)
		{
			var s = aGroupByClauseArray.reduce(function(vacc, vcurrent) { return vacc + ',' + vcurrent; });
			return s + ',ordeffort,exteffort,oncalleffort';
		}

	    return "caldate,profileid,resourcedescr,ordeffort,exteffort,oncalleffort";
	}
			

});


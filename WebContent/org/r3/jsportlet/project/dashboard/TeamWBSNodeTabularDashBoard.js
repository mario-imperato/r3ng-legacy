$.r3Utils.namespace("org.r3.jsportlet.project.dashboard");

org.r3.jsportlet.project.dashboard.TeamWBSNodeTabularDashBoardModel = Class.extend({

	init : function(aWbsId) 
	{
		this.wbsId = aWbsId;
	
		this.columns = [];
		this.rows = [];
	},
	
	_setup: function(teamProfileDTOTableAdapter, nodesDTOTableAdapter, resourceTSDTOTableAdapter)
	{
		if (!teamProfileDTOTableAdapter || teamProfileDTOTableAdapter.getNumberOfItems() == 0)
			return ;
		
		if (!nodesDTOTableAdapter || nodesDTOTableAdapter.getNumberOfItems() == 0)
			return ;
		
		for(var i = 0; i < teamProfileDTOTableAdapter.getNumberOfItems(); i++)
		{
			var item = teamProfileDTOTableAdapter.getItem(i);
			
		    this.rows.push({
		    	
		    	"rowId"   : item.dataBean.profileid,
		    	"rowInfo" : item,
		    	"previsionalEffort": 0,
		    	"actualEffort": 0,
		    	"cellInfo": []
		        
		    });			    		    
		}
		
		for(var i = 0; i < nodesDTOTableAdapter.getNumberOfItems(); i++)
		{
			var item = nodesDTOTableAdapter.getItem(i);
			
			var colIndex = this._findColumnById(item.dataBean.wbsnodeid);
			if (colIndex < 0)
				colIndex = this._addColumn(item.dataBean.wbsnodeid, item.dataBean.nodename);
			
			var rowIndex = this._findRowById(item.dataBean.profileid);
			
			// Dovrei sempre trovarlo. Pero' potrei avere qualche anomalia di cancellazione in giro...
			if (rowIndex >= 0)
			{				
			   this.rows[rowIndex].cellInfo[colIndex].previsionalEffort += item.dataBean.effort;	
			   this.rows[rowIndex].previsionalEffort += item.dataBean.effort;
			   this.columns[colIndex].previsionalEffort += item.dataBean.effort;
			}			
		}

		for(var i = 0; i < resourceTSDTOTableAdapter.getNumberOfItems(); i++)
		{
			var item = resourceTSDTOTableAdapter.getItem(i);
			
			var colIndex = this._findColumnById(item.dataBean.tsactivityid);
			
			// La mancanza della colonna o viene trascurata oppure non si dovrebbe applicare
			if (colIndex < 0)
				colIndex = this._addColumn(item.dataBean.tsactivityid, item.dataBean.tsactivityid);
			
			var rowIndex = this._findRowById(item.dataBean.profileid);
			
			// Dovrei sempre trovarlo. Pero' potrei avere qualche anomalia di cancellazione in giro...
			if (rowIndex >= 0)
			{				
			   this.rows[rowIndex].cellInfo[colIndex].actualEffort += item.dataBean.effort;	
			   this.rows[rowIndex].actualEffort += item.dataBean.effort;
			   this.columns[colIndex].actualEffort += item.dataBean.effort;
			}			
		}
	},
	
	_findRowById: function(aProfileId)
	{
		for(var j = 0; j < this.rows.length; j++)
		{
			if (this.rows[j].rowId == aProfileId)
			{
			     return j;	
			}
		}
		
		return -1;
	},
	
	_findColumnById: function(aWbsNodeId)
	{
		for(var j = 0; j < this.columns.length; j++)
		{
			if (this.columns[j].colId == aWbsNodeId)
			{
			     return j;	
			}
		}
		
		return -1;
	},
	
	_addColumn: function(aWbsNodeId, aWbsNodeName)
	{
		this.columns.push({ "colId": aWbsNodeId, "colInfo": aWbsNodeName, "previsionalEffort": 0, "actualEffort": 0 });
		
		for(var j = 0; j < this.rows.length; j++)
		{
			this.rows[j].cellInfo.push({ "previsionalEffort" : 0, "actualEffort": 0 });
		}
		
		return this.columns.length - 1;
	}

});

org.r3.jsportlet.project.dashboard.TeamWBSNodeTabularDashBoardActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		
		
		this.teamWBSNodeTabularDashBoardModel = new org.r3.jsportlet.project.dashboard.TeamWBSNodeTabularDashBoardModel();
		
	},

	close : function()
	{
		this.hide();
	},
			
	open : function(aWbsId, aTeamId)
	{
	
		var networkRequestsQueue = [];
		
		networkRequestsQueue.push(
		{
			id : "teamprofile",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_TeamMemberProfiles'),
			dataType : "json"
		});

		networkRequestsQueue.push(
		{
			id : "wbsteamprofile",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_WBS_TeamProfile', [ aWbsId ]),
			dataType : "json"
		});
			
		networkRequestsQueue.push(
		{
			id : "wbsresourcets",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_WBS_ResourceTimesheet_CumulatedEffort', [ aWbsId ]),
			dataType : "json"
		});
		
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/project/dashboard/TeamWBSNodeTabularDashBoard.html.jsp'),
			dataType : "html"
		});
		
		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_SailEvent'));
				
		org.r3.PageManager.multiAjax(networkRequestsQueue, $.r3Utils.hitch(this, function(responseData)
		{
					
				var teamProfileDTOTableAdapter = responseData['teamprofile'];
				if (teamProfileDTOTableAdapter)
				{
					teamProfileDTOTableAdapter = new org.r3.db.DTOTableAdapter(teamProfileDTOTableAdapter, 
							function(aRowDataBean) { return new org.r3.db.project.teammemberprofile.TeamMemberProfileDTOAdapter(aRowDataBean); });	
										
				}
								
				var wbsteamprofileDTOTableAdapter = responseData['wbsteamprofile'];
				if (wbsteamprofileDTOTableAdapter)
				{
					wbsteamprofileDTOTableAdapter = new org.r3.db.DTOTableAdapter(wbsteamprofileDTOTableAdapter, 
							function(aRowDataBean) { return new org.r3.db.project.wbsnodeteammemberprofileview.WBSNodeTeamMemberProfileViewDTOAdapter(aRowDataBean); });	
					
				}
				
				var wbsresourcetsDTOTableAdapter = responseData['wbsresourcets'];
				if (wbsresourcetsDTOTableAdapter)
				{
					wbsresourcetsDTOTableAdapter = new org.r3.db.DTOTableAdapter(wbsresourcetsDTOTableAdapter, 
							function(aRowDataBean) { return new org.r3.db.project.resourcetimesheet.ResourceTimesheetDTOAdapter(aRowDataBean); }, true);	
					
				}
				
				this.teamWBSNodeTabularDashBoardModel._setup(teamProfileDTOTableAdapter, wbsteamprofileDTOTableAdapter, wbsresourcetsDTOTableAdapter);
				$(this.htmlContainerId).html(tmpl(responseData['view'], { model: this.teamWBSNodeTabularDashBoardModel }));
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
	}
			
});


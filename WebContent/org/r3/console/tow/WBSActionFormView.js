$.r3Utils.namespace("org.r3.console.tow");


org.r3.console.tow.WBSActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
	},

	close : function()
	{
		this.hide();
	},
	
	open : function(aWBSDtoAdapter)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];
		if (aWBSDtoAdapter)
		{
			networkRequestsQueue.push(
			{
				id : "view",
				type : "Get",
				url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/tow/WBSActionFormView.html.jsp?mode=detail'),
				dataType : "html"
			});					

			networkRequestsQueue.push(
			{
				id : "view_tabwbsnode_miller",
				type : "Get",
				url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/tow/TabWBSNode_Miller_WBSActionFormView.html.jsp'),
				dataType : "html"
			});			

			networkRequestsQueue.push(
			{
				id : "view_tabwbsnode_detail",
				type : "Get",
				url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/tow/TabWBSNode_Detail_WBSActionFormView.html.jsp'),
				dataType : "html"
			});	
			
			networkRequestsQueue.push(
			{
				id : "teammembersprofile",
				type : "Get",
				url : org.r3.PageManager.getRESTUrl('GET_TeamMemberProfiles'),
				dataType : "json"
			});	
			
			// WBS DTO Proviene da un DataTable e non contiene gli attori (manager, sponsor e coach..
//			networkRequestsQueue.push(
//			{
//				id : "wbsactors",
//				type : "Get",
//				url : org.r3.PageManager.getRESTUrl("GET_WBSActors", [ aWBSDtoAdapter.dataBean.wbsid ]),
//				dataType : "json"
//			});	
		
		}
		else
		{
			networkRequestsQueue.push(
			{
				id : "view",
				type : "Get",
				url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/tow/WBSActionFormView.html.jsp?mode=create'),
				dataType : "html"
			});					
		}

		networkRequestsQueue.push(
		{
			id : "view_tabwbs",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/tow/TabWBS_WBSActionFormView.html.jsp'),
			dataType : "html"
		});

		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_skillambit'));
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_skillprofile'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();


//			if (aWBSDtoAdapter)
//			{
//			var wbsActors = responseData['wbsactors'];
//			if (wbsActors)
//				wbsActors = new org.r3.db.DTOTableAdapter(wbsActors, 
//						function(aRowDataBean) { return new org.r3.db.wbs.wbsactor.WBSActorDTOAdapter(aRowDataBean); });		
//					
//			aWBSDtoAdapter.setWbsActors(wbsActors);
//			}
			
			var teamprofile = responseData["teammembersprofile"];
			if (teamprofile)
			{
				teamprofile = new org.r3.db.DTOTableAdapter(teamprofile, 
						function(aRowDataBean) { return new org.r3.db.project.teammemberprofile.TeamMemberProfileDTOAdapter(aRowDataBean); });					
			}
			
			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));
			
			$('#wbsActionForm_tab_generale').html(tmpl(responseData['view_tabwbs'], {}));			
			this.tabWBS = new org.r3.console.tow.TabWBS_WBSActionFormView('__UNUSED__', this.actionFormManager, aWBSDtoAdapter);

			if (aWBSDtoAdapter)
			{
				$('#wbsActionForm_tab_nodes_miller').html(tmpl(responseData['view_tabwbsnode_miller'], {}));			
				$('#wbsActionForm_tab_nodes_detail').html(tmpl(responseData['view_tabwbsnode_detail'], { "teamprofile": teamprofile }));							
				
				this.tabWBSNode_miller = new org.r3.console.tow.TabWBSNode_Miller_WBSActionFormView('__UNUSED__', this.actionFormManager, aWBSDtoAdapter);
				this.tabWBSNode_detail = new org.r3.console.tow.TabWBSNode_Detail_WBSActionFormView('#wbsActionForm_tab_nodes_detail', this.actionFormManager, aWBSDtoAdapter);				
			}
			
			// $('#wbsActionFormTabs').tabs();
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
	startNodeEditing: function(actionContext)
	{
		this.tabWBSNode_detail.startNodeEditing(actionContext);
	},
	
	addNodeToMiller: function(actionContext, aNode)
	{
		this.tabWBSNode_miller.addNode(actionContext.sortableContainerId, actionContext.parentNodeId, aNode);
	},
	
	refreshMillerView: function(actionContext, aNode)
	{
		this.tabWBSNode_miller.refreshMillerView(actionContext.sortableContainerId, aNode);
	}

});

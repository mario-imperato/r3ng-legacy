$.r3Utils.namespace("org.r3.console.tow");


org.r3.console.tow.TabWBSNode_Miller_WBSActionFormView  = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, aWBSDtoAdapter)
	{
		var _self = this;		
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		
		this.wbsId = aWBSDtoAdapter.dataBean.wbsid;
		
		this.actionContext = {
				action: 'none'	
		};
		
		this.itemIdCounter = 100;
		this.selectedItem = null;
		this.selectedGroup = null;

		$('#wbsnodeform_fieldset_message').formmessage({ text: org.r3.jsportlet.wbs.message.wbsmillertip, category: 'info' });
		
		$('#wbs_miller').gmiller({
							
			rootNodeId: aWBSDtoAdapter.dataBean.wbsid,
			rootNodeName:  aWBSDtoAdapter.dataBean.wbstitle,
			nodeMove: true,
			 
			 onFetch: $.r3Utils.hitch(this, this._fetchNodeChildren),			
			 onSelect: $.r3Utils.hitch(this, this._nodeSelected),
			 onClearActiveContainer: $.r3Utils.hitch(this, this._stopNodeEditing),
			 
			 onSort: $.r3Utils.hitch(this, this._onSort),

			 onMove: $.r3Utils.hitch(this, this._onMove),

			 renderHtml4NewNode: $.r3Utils.hitch(this, this._renderNode),
			 
			buttons: [{					
				id: "action_showwbs",
				caption: org.r3.jsportlet.wbs.message.wbsnodemanager_milleraction_outline,
				showOn: 'first',
				enabled: 'always',
				onClick: $.r3Utils.hitch(this, this._onWBSOutlineDisplay)
				
			},
			
			{					
				id: "action_add",
				caption: org.r3.jsportlet.wbs.message.wbsnodemanager_milleraction_add,
				enabled: 'onRefNode',
				showOn: 'all',
				onClick: $.r3Utils.hitch(this, this._onAddNode)
			},
			
			{					
				id: "action_delete",
				caption: org.r3.jsportlet.wbs.message.wbsnodemanager_milleraction_delete,
				showOn: 'all',
				enabled: 'onSelection',
				onClick: $.r3Utils.hitch(this, this._onDeleteNode)
				
			}]
		
		});		
		
		$('#action_updatewbsnumbering').unbind().click($.r3Utils.hitch(this, this._onWBSOutlineUpdate));
		
		
	},

	dummy_fetchNodeChildren: function (aParentNodeId, treeLevel, onSuccess)
	{
		 var fetchedDataArray = [];
		 for(var i = 0; i < 7; i++)
		 {						 
		     var n = { "dtokey": "Key_" + treeLevel + "_" + _self.itemIdCounter, "dtodescr": "Descr_" + treeLevel + "_" + _self.itemIdCounter };
		     _self.itemIdCounter++;
		     fetchedDataArray.push(n);
		 }
         onSuccess(fetchedDataArray, fetchedDataArray.length);		 
	 },

	 _nodeSelected: function(aSortableContainerId, aParentNodeId, aNodeId, aNodePosition, aNodeObj)
	 {
	     console.log("ONSELECT - sid: " + aSortableContainerId + " parent: " + aParentNodeId + " node: " + aNodeId + " position: " + aNodePosition);	 					 

 		 this.actionContext.action = 'update';
		 this.actionContext.sortableContainerId = aSortableContainerId;
		 this.actionContext.parentNodeId = aParentNodeId;
		 this.actionContext.nodeId = aNodeId;
		 this.actionContext.nodePosition = aNodePosition;
		 this.actionContext.nodeObj = aNodeObj;
		 
		 this.actionFormManager.detailView.startNodeEditing(this.actionContext);
	 },

	 _stopNodeEditing: function()
	 {
		 this.actionContext.action = 'none';
		 this.actionFormManager.detailView.startNodeEditing(this.actionContext);
	 },
	 
	 _renderNode: function(nodeData)
	 {
		var nodeClass = nodeData.getCustomCSSClassName();
		if (nodeClass)
			nodeClass = "class='" + nodeClass + "'";
		
		var summary = nodeData.dataBean.nodesummary;
		if (summary && summary.length > 30)
			summary = summary.substring(0, 27) + '...';
		
		var h = $(            			
        		"<li id='" + nodeData.getNodeId() + "' " + nodeClass + ">" 
        		   +"<div><b>" + nodeData.dataBean.nodename + "</b><br />" + summary + "</div>"
        		   +"</li>"			        		            						
		);
		
		return h;
	 },

	_onAddNode : function(aSortableContainerId, aParentNodeId, aSelectedNodeId) {
		console.log("Clicked...." + aSortableContainerId + " on " + aSelectedNodeId + " within " + aParentNodeId);

		this.actionContext.action = 'add';
		this.actionContext.sortableContainerId = aSortableContainerId;
		this.actionContext.parentNodeId = aParentNodeId;
		this.actionFormManager.detailView.startNodeEditing(this.actionContext);
		return false;
	},

	addNode: function(aSortableContainerId, aParentNodeId, nodeInfo)
	{
		$('#wbs_miller').gmiller('add', aSortableContainerId, aParentNodeId, nodeInfo);		
	},
	
	refreshMillerView: function(aSortableContainerId, aNode)
	{
	    $('#wbs_miller').gmiller('refresh', aSortableContainerId, aNode);		
	    this._hideWBSOutline();
	},
	
	_onWBSOutlineUpdate: function()
	{
        var _self = this;
		
        org.r3.PageManager.wait("org.r3.message.waiting");
        
		var method = "PUT";
		var restUrl = null;
		restUrl = org.r3.PageManager.getRESTUrl('PUT_WBSNodes_OutlineNumbering', [ this.wbsId ]);

		$.ajax(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"success" : function(responseData)
			{
				org.r3.PageManager.closeNotifier();
				
				var dtoAdapter = new org.r3.db.wbs.wbs.WBSDTOAdapter(responseData);
				var renderedOutline = tmpl("tpl_wbsoutline", { "wbs": dtoAdapter });	
                $('.wbs_outline').html(renderedOutline);
                
                _self._showWBSOutline();
                location.href = '#wbs_outline_anchor';
			},
			"error" : function(jqXHR, timeout, message)
			{
				org.r3.PageManager.closeNotifier();
				$('#wbsnodeform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
			}
		});
	},
	
	_onWBSOutlineDisplay: function(aSortableContainerId, aParentNodeId, aSelectedNodeId)
	{		
		var _self = this;
		
		var method = "GET";
		var restUrl = null;
		restUrl = org.r3.PageManager.getRESTUrl('GET_WBSTree', [ this.wbsId ]);	
		
		$.ajax(
		{
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"success" : function(responseData)
			{
				var dtoAdapter = new org.r3.db.wbs.wbs.WBSDTOAdapter(responseData);
				var renderedOutline = tmpl("tpl_wbsoutline", { "wbs": dtoAdapter });	
                $('.wbs_outline').html(renderedOutline);
                
                _self._showWBSOutline();
                location.href = '#wbs_outline_anchor';
                
            	var teamDashBoard = new org.r3.jsportlet.project.dashboard.TeamWBSNodeTabularDashBoardActionFormView("#wbs_teamprofile", this.actionFormManager);
        		teamDashBoard.open(_self.wbsId, org.r3.Constants.site);
			},
			"error" : function(jqXHR, timeout, message)
			{
				$('#wbsnodeform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
			}
		});
				
	},
	
	_showWBSOutline: function()
	{
        var wbsObject = $('.wbs');
        if (wbsObject.hasClass('wbs_collapsed'))
        	wbsObject.toggleClass('wbs_collapsed');	
        
        if ($('.wbs .wbs_outline .invalid').length)
        {
        	$('#wbsoutline_actonbar').show();
            $('#action_updatewbsnumbering').prop('disabled', false);        	
        }
        else 
        {
        	$('#wbsoutline_actonbar').hide();
        	$('#action_updatewbsnumbering').prop('disabled', true);
        }
	},

	_hideWBSOutline: function()
	{
        var wbsObject = $('.wbs');
        if (!wbsObject.hasClass('wbs_collapsed'))
        	wbsObject.toggleClass('wbs_collapsed');	
	},

	_onDeleteNode : function(aSortableContainerId, aParentNodeId, aSelectedNodeId) 
	{		
		console.log("Clicked...." + aSortableContainerId + " on " + aSelectedNodeId + " within " + aParentNodeId);
		
		if (org.r3.PageManager.confirmation("org.r3.message.deleteconfirm"))
		{
			this._hideWBSOutline();
			
			this.actionContext.action = 'none';
			this.actionFormManager.detailView.startNodeEditing(this.actionContext);
			
			var restUrl = org.r3.PageManager.getRESTUrl('DELETE_WBSNode', [ this.wbsId, aSelectedNodeId ]);
			$.ajax(
			{
				"type" : "DELETE",
				"url" : restUrl,
				"dataType" : "json",
				"success" : function(responseData)
				{
					$('#wbs_miller').gmiller('remove', aSortableContainerId, aParentNodeId, aSelectedNodeId);			    	 
				},
				"error" : function(jqXHR, timeout, message)
				{
					$('#wbsnodeform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
				}
			});		
		}
		
		return false;
	},
	
	_fetchNodeChildren: function (aParentNodeId, treeLevel, onSuccess)
	{
		var restUrl = org.r3.PageManager.getRESTUrl('GET_WBSNodeChildren', [ this.wbsId, aParentNodeId ]);
		$.ajax(
		{
			"type" : "GET",
			"url" : restUrl,
			"dataType" : "json",
			"success" : function(responseData)
			{
			    var fetchedDataArray = [];
			    for(var i = 0; i < responseData.iTotalRecords; i++)
			    {
			    	var dtoAdapter = new org.r3.db.wbs.wbsnode.WBSNodeDTOAdapter(responseData.aaData[i]);
			    	fetchedDataArray.push(dtoAdapter);
			    }
			    
				onSuccess(fetchedDataArray, fetchedDataArray.length);		 
			},
			"error" : function(jqXHR, timeout, message)
			{
				$('#wbsnodeform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
			}
		});		
	 },

	 _onMove: function(aDroppableContainerId, aSortableContainerId, aParentNodeId, aNodeId, aNewPosition, aNewPreviousSiblingNodeId)
     {
	     console.log("ONMOVE - did: " + aDroppableContainerId + " sid: " + aSortableContainerId + " parent: " + aParentNodeId + " node: " + aNodeId + " position: " + aNewPosition + " prevSiblingId: " + aNewPreviousSiblingNodeId);	 
		 this._onSort(aSortableContainerId, aParentNodeId, aNodeId, aNewPosition, aNewPreviousSiblingNodeId);
	 },
	 
	 _onSort: function(aSortableContainerId, aParentNodeId, aNodeId, aNewPosition, aNewPreviousSiblingNodeId)
	 {
	    console.log("ONSORT - sid: " + aSortableContainerId + " parent: " + aParentNodeId + " node: " + aNodeId + " position: " + aNewPosition + " prevSiblingId: " + aNewPreviousSiblingNodeId);	 
	    var restUrl = org.r3.PageManager.getRESTUrl('SORT_WBSNode', [ this.wbsId, aParentNodeId, aNodeId, aNewPosition, aNewPreviousSiblingNodeId ]);
	    
	    this._hideWBSOutline();
	    
		$.ajax(
		{
			"type" : "PUT",
			"url" : restUrl,
			"dataType" : "json",
			"success" : function(responseData)
			{
				$('#wbsnodeform_fieldset_message').formmessage('setText', { text: org.r3.message.success, category: 'info' });		    	 
			},
			"error" : function(jqXHR, timeout, message)
			{
				$('#wbsnodeform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
			}
		});	
			
	 }

	
		
});

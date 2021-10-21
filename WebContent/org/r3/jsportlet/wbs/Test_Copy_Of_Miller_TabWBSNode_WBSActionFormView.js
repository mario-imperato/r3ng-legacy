$.r3Utils.namespace("org.r3.jsportlet.wbs");


org.r3.jsportlet.wbs.TabWBSNode_WBSActionFormView  = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, aWBSDtoAdapter)
	{
		var _self = this;		
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.itemIdCounter = 100;
		this.selectedItem = null;
		this.selectedGroup = null;

		$('#wbsnodeform_fieldset_message').formmessage({ text: org.r3.jsportlet.wbs.message.wbsmillertip, category: 'info' });
		
			$('#wbs_miller').gmiller({
								
				rootNodeId: aWBSDtoAdapter.dataBean.wbsid,
				rootNodeName:  aWBSDtoAdapter.dataBean.wbstitle,
				nodeMove: true,
				 
				 onFetch: function (aParentNodeId, treeLevel, onSuccess)
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
			
				 onSelect: function(aSortableContainerId, aParentNodeId, aNodeId, aNodePosition)
				 {
				     console.log("ONSELECT - sid: " + aSortableContainerId + " parent: " + aParentNodeId + " node: " + aNodeId + " position: " + aNodePosition);	 					 
				 },
				 
				 onSort: function(aSortableContainerId, aParentNodeId, aNodeId, aNewPosition, aNewPreviousSiblingNodeId)
				 {
				     console.log("ONSORT - sid: " + aSortableContainerId + " parent: " + aParentNodeId + " node: " + aNodeId + " position: " + aNewPosition + " prevSiblingId: " + aNewPreviousSiblingNodeId);	 
				 },

				 onMove: function(aDroppableContainerId, aSortableContainerId, aParentNodeId, aNodeId, aNewPosition, aNewPreviousSiblingNodeId)
				 {
				     console.log("ONSORT - did: " + aDroppableContainerId + " sid: " + aSortableContainerId + " parent: " + aParentNodeId + " node: " + aNodeId + " position: " + aNewPosition + " prevSiblingId: " + aNewPreviousSiblingNodeId);	 
				 },

				 renderHtml4NewNode: function(nodeData)
				 {
					var h = $(            			
    		        		"<li id='" + nodeData.dtokey + "' class='wbs_stereotype'>" 
    		        		   +"<span ></span>"  
    		        		   +"<div>" + nodeData.dtodescr + "</div>"
    		        		   +"</li>"			        		            						
					);
					
					return h;
				 },
				 
				buttons: [{					
					id: "action_add",
					caption: "Add",
					enabled: 'onRefNode',
					showOn: 'all',
					onClick: $.r3Utils.hitch(this, function(aSortableContainerId, aParentNodeId, aSelectedNodeId) {
						
						console.log("Clicked...." + aSortableContainerId + " on " + aSelectedNodeId + " within " + aParentNodeId);
						var n = { "dtokey": "Key_" + 'NEW' + "_" + _self.itemIdCounter, "dtodescr": "Descr_" + 'NEW' + "_" + _self.itemIdCounter };
					    this.itemIdCounter++;
						$('#wbs_miller').gmiller('add', aSortableContainerId, aParentNodeId, n);
						return false;
					
					})
				},
				
				{					
					id: "action_delete",
					caption: "Delete",
					showOn: 'all',
					enabled: 'onSelection',
					onClick: function(aSortableContainerId, aParentNodeId, aSelectedNodeId) {
						console.log("Clicked...." + aSortableContainerId + " on " + aSelectedNodeId + " within " + aParentNodeId);
						$('#wbs_miller').gmiller('remove', aSortableContainerId, aParentNodeId, aSelectedNodeId);
						return false;
					}
				}
				
				]
			
			});
			
		
	},
	
	fetchNodeChildren: function (aParentNodeId, treeLevel, onSuccess)
	 {
		 var fetchedDataArray = [];
		 for(var i = 0; i < 7; i++)
		 {						 
		     var n = { "dtokey": "Key_" + treeLevel + "_" + _self.itemIdCounter, "dtodescr": "Descr_" + treeLevel + "_" + _self.itemIdCounter };
		     _self.itemIdCounter++;
		     fetchedDataArray.push(n);
		 }
        onSuccess(fetchedDataArray, fetchedDataArray.length);		 
	 }
	
		
});

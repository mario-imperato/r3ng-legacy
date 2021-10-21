/*
 * gmiller.js: v.1.0 
 */

$.r3Utils.namespace("org.r3.widget.miller");

org.r3.widget.miller.message = 
{
	"nodeCaption"   : "Node",
	"noMoreLevels"  : "You have reached the maximum depth configured",
	"moveNotAllowed": "Operation not allowed: a node cannot be made child of a child or dropped in invalid context" 
};

org.r3.widget.miller.TreeNode = Class.extend(
{
	init : function(aNodeId, aNodeText, aNodeUserData)
	{
		this.nodeId = aNodeId;
		this.nodeText = aNodeText;
		this.nodeUserData = aNodeUserData;
		     
		this.hasBeenFetched = false;
		this.children = [];
	},

	addChild: function(aNode, atPosition)
	{
		if (!atPosition || atPosition < 0 || atPosition >= this.children.length)
		     this.children.push(aNode);		
		else this.children.splice(atPosition, 0, aNode);
	},
	
	getNumberOfChildren: function()
	{
		return this.children.length;
	},
	
	removeChild: function(aNodeId)
	{
		var ndxOfItem = this.indexOfById(aNodeId);
		if (ndxOfItem >= 0)
		{
			this.children.splice(ndxOfItem, 1);
			return true;
		}
		
		return false;
	},
	
	moveChild: function(aNodeId, toPosition)
	{
		var ndxOfItem = this.indexOfById(aNodeId);
		if (ndxOfItem >= 0 && toPosition != ndxOfItem)
		{
			this.children.splice(toPosition, 0, this.children.splice(ndxOfItem, 1)[0]);
			return true;
		}	 	
		
		return false;
	},
	
	indexOfById: function(aNodeId)
	{
		var ndx = -1;
        var visitor = {
        		
        	visit: function(aNode, parentNode, indexOfNode)
        	{
        		if (aNode.nodeId == aNodeId)
        		{
        			ndx = indexOfNode;
        			return false;            			
        		}
        		
        		return true;
        	}        		
        };
        
        this.visit(visitor, null, 0, false);
        return ndx;
	},
	
	findNode: function(aNodeId)
	{
		console.log("I'm Looking for node: " + aNodeId);
		var theNodeInfo = null;
        var visitor = {
        		
        	visit: function(aNode, parentNode, indexOfNode)
        	{
        		if (aNode.nodeId == aNodeId)
        		{
        			console.log("Visitor Visit Result: [" + indexOfNode + "] " + aNode.nodeId + " under parent: " + ((parentNode) ? parentNode.nodeId : " ND "));
        			theNodeInfo = {
        				"node":	aNode,
        				"parent": parentNode,
        				"pos": indexOfNode
        			};
        			return false;	
        		}
        		        		
        		return true;
        	}        		
        };
        
        this.visit(visitor, null, 0, true);
		console.log("Returning node: " + theNodeInfo.node);
        return theNodeInfo;
	},
	
	visit: function(aVisitor, parentNode, positionOfNode, recurseFlag)
	{
		// console.log("Node Visit: [" + positionOfNode + "] " + this.nodeId + " Recurse? " + recurseFlag);
		// console.log("Visitor Visit: [" + positionOfNode + "] " + this.nodeId);
		if (!aVisitor.visit(this, parentNode, positionOfNode))
			return false;
		
		// console.log("Visiting children on " + this.nodeId + " - (" + this.getNumberOfChildren() + ")");
		for(var i = 0; i < this.getNumberOfChildren(); i++)
		{			
			if (recurseFlag)
			{
			     if (!this.children[i].visit(aVisitor, this, i, recurseFlag))
			    	 return false;				
			}
			else   
			{
				// console.log("Visitor Visit: [" + i + "] " + this.children[i].nodeId);
				if (!aVisitor.visit(this.children[i], this, i))
					return false;
			}				
		}
		
		return true;
	}
});


(function($)
{
	$.widget('r3.gmiller',
	{

		options :
		{},

		defaults :
		{
			numberOfColumns: 3,
			maxNumberOfLevels: 5,
			rootNodeId: 'MILLER_ID',
			rootNodeName: 'MILLER_NAME',
			nodeMove: true
		},
		
		_create : function()
		{
			var widgetOptions =  this.options = $.extend({}, this.defaults, this.options);
			
			this._rootNode = new org.r3.widget.miller.TreeNode(widgetOptions.rootNodeId, widgetOptions.rootNodeName, {});
			this._treeConfig = [];
			this._uiInfo = [];
			this._sequenceCounter = 200;
			
			this._dragStep = 'none';
			this._dragTarget = null;
			
			var widgetId = this.element.attr('id');
			this._adjustOptions(widgetOptions);
			
			for(var i = 0; i < widgetOptions.maxNumberOfLevels; i++)
			{
				var treeConfigItem = null;
				if (widgetOptions.treeConfig && widgetOptions.treeConfig.length)
				{
					if (widgetOptions.treeConfig.length > i)
						 treeConfigItem = widgetOptions.treeConfig[i];
					else treeConfigItem = widgetOptions.treeConfig[widgetOptions.treeConfig.length - 1];
				}
				else 
				{
					treeConfigItem = {};
				}
						
				if (i == 0)
					treeConfigItem.refNodeId = this._rootNode.nodeId;
				
			    this._treeConfig.push(treeConfigItem);
			}

			this._uiSlidingWindowOffset = 0;
			for(var i = 0; i < widgetOptions.numberOfColumns; i++)
			{								
			    var columnConfig = 
			    {
			    	containerId: this._getContainerIdByIndex(widgetId, i),
			    	containerObj: null,
			    	selectedItem: null,	
			    	buttons: []
			    };
			    
			    this._uiInfo.push(columnConfig);
			}

			this._initializeCanvas(widgetId, widgetOptions);			
			this._bindEvents(widgetId);
			this._populateCanvas(0);
		},
		
		_adjustOptions: function(cfgHash)
		{
			if (cfgHash.numberOfColumns > cfgHash.maxNumberOfLevels)
			{
				cfgHash.numberOfColumns = cfgHash.maxNumberOfLevels;
			}		    	
		},
		
		add: function(sortableContainerId, aParentNodeId, anItem)
		{
			console.log("An Item in add is: ", anItem);
			
			var newNode = new org.r3.widget.miller.TreeNode(anItem.getNodeId(), anItem.getNodeLabel(), anItem);
        	var sortableContainerIndex = this._getContainerIndexById(sortableContainerId);
        	
        	var refTreeNode = this._getReferenceTreeNode(sortableContainerIndex);        	
        	refTreeNode.addChild(newNode);
              	
        	var htmlItem = this.options.renderHtml4NewNode(anItem);                    	
        	var cnt = this._getContainerObjByIndex(sortableContainerIndex);
        	cnt.append(htmlItem);
		},
		
		remove: function(sortableContainerId, aParentNodeId, anItemId)
		{
			console.log("An Item in add is: ", anItemId);
			
        	var sortableContainerIndex = this._getContainerIndexById(sortableContainerId);
        	
        	var refTreeNode = this._getReferenceTreeNode(sortableContainerIndex);        	
        	refTreeNode.removeChild(anItemId);

        	var treeNodeConfigIndex = sortableContainerIndex + this._uiSlidingWindowOffset + 1; 
			this._clearConfigTreeNodeReferenceTreeNode(treeNodeConfigIndex);
			
        	this._populateCanvas(sortableContainerIndex);
		},
		
		refresh: function(sortableContainerId, aNode)
		{						
			var treeNode = this._rootNode.findNode(aNode.getNodeId());
			if (treeNode)
			{
			   treeNode.node.nodeText = 	aNode.getNodeLabel();
			   treeNode.node.nodeUserData = aNode;
			}
        	var sortableContainerIndex = this._getContainerIndexById(sortableContainerId);        				
        	this._populateCanvas(sortableContainerIndex);
		},
		
		destroy : function()
		{
			this._canvasDiv.remove();
			$.Widget.prototype.destroy.apply(this, arguments);
		},

	    _bindEvents : function(widgetId) 
	    {
			var ulSelector = "#" + widgetId + " .gmiller_column ul";
			var liSelector = ulSelector + " li";
	
			var sortableConfig = {
							change : $.r3Utils.hitch(this, this._onSortableChange),
							over : $.r3Utils.hitch(this, this._onSortableOver),
							out : $.r3Utils.hitch(this, this._onSortableOut),
							stop : $.r3Utils.hitch(this, this._onSortableStop),
							receive : $.r3Utils.hitch(this, this._onSortableReceive),
							beforeStop : $.r3Utils.hitch(this, this._onSortableBeforeStop),
							start : $.r3Utils.hitch(this, this._onSortableStart)				
			};

			if (this.options.nodeMove)	
				sortableConfig.connectWith = ulSelector;
			
			this.element.find("ul").sortable(sortableConfig);
	
			$(document).off('click', liSelector).on("click", liSelector, $.r3Utils.hitch(this, function(e) 
			{	
				var currentTarget = $(e.currentTarget);
				var containerNodeId = currentTarget.parent().attr('id');
				var sortableContainerIndex = this._getContainerIndexById(containerNodeId);				
				var currentTreeNodeConfigIndex = this._getConfigTreeNodeIndexBySortableContainerIndex(sortableContainerIndex);

				// La variabile riporta l'id del container da notificare alla callback utente. 
				// In linea di principio i due valori coincidono sempre a meno che non venga attivato lo scorrimento laterale 
				// in quanto le finestre della ui sono cambiate. Utilizzo una variabile dedicata per non avere effetti collaterali.
				var selectedContainerIndex = sortableContainerIndex;
				
				// Mantengo i valori in quanto se succede uno sliding allora meglio averli tenuti da parte.
				var selectedNodeId = currentTarget.attr('id');
				var selectedNodePosition = currentTarget.index();
				var parentNodeId = this._treeConfig[currentTreeNodeConfigIndex].refNodeId;
													
				if (currentTreeNodeConfigIndex == (this._treeConfig.length - 1))
				{
					console.error("Terminati i livelli di selezione");
					this._updateSelectionHint(currentTarget);
					this._enableDisableButtons_onSelection(sortableContainerIndex, true);					
					alert(org.r3.widget.miller.message.noMoreLevels);
				}
				else
				{
					var firstSortableContainer2Populate = sortableContainerIndex + 1;
					if (sortableContainerIndex == (this._uiInfo.length - 1))
					{
						this._shiftRightSortableContainerView();
						firstSortableContainer2Populate = 0;
						selectedContainerIndex--;
						containerNodeId = this._getContainerIdByIndex(this.element.attr('id'), selectedContainerIndex);
						$( "#" + widgetId + " .gmiller_backseparator > div").show();
					}
					else 
					{
						// Se mi tocca shiftare allora non ha senso fare l'highlight.
						this._updateSelectionHint(currentTarget);
						this._enableDisableButtons_onSelection(sortableContainerIndex, true);
					}
								
					var treeNodeConfigIndex = currentTreeNodeConfigIndex + 1; // this._getConfigTreeNodeIndexBySortableContainerIndex(sortableContainerIndex + 1);
					this._clearConfigTreeNodeReferenceTreeNode(treeNodeConfigIndex);
									
					var treeNodeConfig = this._treeConfig[treeNodeConfigIndex]; // getConfigTreeNodeBySortableContainerIndex(sortableContainerIndex + 1);
					treeNodeConfig.refNodeId = currentTarget.attr('id');
					
					this._populateCanvas(firstSortableContainer2Populate);				
				}
				
				this._markContainerAsActiveByContainerId(containerNodeId);
				
				if (this.options.onSelect)
				{
				    this.options.onSelect(
				    		this._getContainerIdByIndex(this.element.attr('id'), selectedContainerIndex), 
				    		parentNodeId, 
				    		selectedNodeId, 
				    		selectedNodePosition,
				    		this._rootNode.findNode(selectedNodeId)	
				    );				    
				}
				
	        }));
			
			var backButtonSelector = "#" + widgetId + " .gmiller_backseparator > div";
			$(document).off('click', backButtonSelector).on("click", backButtonSelector, $.r3Utils.hitch(this, function(e) 
			{
				var sortableContainerIndex = -1;
				var aContainer = $('.gmiller_container.active')
				if (aContainer)
			    {
					sortableContainerIndex = this._getContainerIndexById(aContainer.attr('id'));

					if (sortableContainerIndex < (this._uiInfo.length - 1))
					{
					    sortableContainerIndex++;
					    var containerNodeId = this._getContainerIdByIndex(this.element.attr('id'), sortableContainerIndex);
					    this._markContainerAsActiveByContainerId(containerNodeId);
					}
					else
					{
						aContainer = $(aContainer[0]).removeClass('active');
						if (this.options.onClearActiveContainer)
						{
						    this.options.onClearActiveContainer();
						}
					}
			    }
				
				
				this._shiftLeftSortableContainerView();  
				if (this._uiSlidingWindowOffset == 0)
					$(backButtonSelector).hide();
				
				this._populateCanvas(0);												
			}));
			
			if (this.options.buttons)
			{
				for(var k = 0; k < this._uiInfo.length; k++)
	            {	
					for(var j = 0; j < this.options.buttons.length; j++)
		            {
						if (this.options.buttons[j].showOn == 'all' || (this.options.buttons[j].showOn == 'first' && k == 0))
						{
						var buttonId = this._getRenderedButtonId(this.element.attr('id'), this.options.buttons[j].id ,k);
						var buttonObj = $('#' + buttonId).button();
						buttonObj.click($.r3Utils.hitch(this, this._onClickActionBarButton));
						if (this.options.buttons[j].enabled != 'always')
		            		buttonObj.hide(); // buttonObj.prop('disabled', true);
						
						var buttonConfig = { "enabled": this.options.buttons[j].enabled, "id": buttonId, "buttonObj": buttonObj, onClick: this.options.buttons[j].onClick };
						this._uiInfo[k].buttons.push(buttonConfig);						
						}
					}
	            }
			}

		},
        
		_onClickActionBarButton: function(e)
		{
			e.preventDefault();
			
			var currentTarget = $(e.currentTarget);
			var buttonId = currentTarget.attr('id');
			
			var sortableContainerIndex = this._getSortableContainerIndexByButtonId(buttonId);
			var bc = this._getButtonConfigByButtonId(this._uiInfo[sortableContainerIndex].buttons, buttonId);
			
			if (bc.onClick)
			{
				var sortableContainerId = this._getContainerIdByIndex(this.element.attr("id"), sortableContainerIndex);
				var treeConfig = this._getConfigTreeNodeBySortableContainerIndex(sortableContainerIndex);
				var selectedNodeId = null;
				
				var selectdNodeQuery = $('#' + sortableContainerId + " li.selected");
				if (selectdNodeQuery.length > 0)
				{
					selectedNodeId = $(selectdNodeQuery[0]).attr("id");
				}

				bc.onClick(sortableContainerId, treeConfig.refNodeId, selectedNodeId);		
				
				this._markContainerAsActiveByContainerId(sortableContainerId);
			}
			
		},
		
		_markContainerAsActiveByContainerId: function(aSortableContainerId)
		{
			$('.gmiller_container').removeClass('active');
			if (aSortableContainerId)
		        $('#' + aSortableContainerId).addClass('active');			    
		},
		
		_initializeCanvas: function(widgetId, cfgHash)
		{
			var html = "";
			
			var divWidth = Math.floor(12/ cfgHash.numberOfColumns);
			for (var i = 0; i < cfgHash.numberOfColumns; i++)
			{
				html += "<div class='col-md-" + divWidth + "'>";
								
				if (i > 0)
				{
					html += "<div class='gmiller_separator' >";
					html += "<div class='gmiller_separator_symbol' ></div>";
					html += "</div>";
				}
				else
				{
					html += "<div class='gmiller_separator gmiller_backseparator' >";
					//html+= "<div class='_GATt' title='Torna alla pagina Amministrazione'><div class='ACTION-back TARGET- _GAy _GAGa'><span class='_GAxHb'></span></div></div>";
					html+= "<div style='display: none'><span></span></div>";
					html += "</div>";					
				}
				
				html += "<div class='gmiller_column' >";		
				
				html += "<div class='gmiller_column_header clearfix'>"; 

				html += "<div class='gmiller_actionbar_caption gmiller_actionbar_caption_" + i + "'>";
				html += "<span class='nodelabel'>" + org.r3.widget.miller.message.nodeCaption + "</span>";
				html += "<span class='nodeid'></span>";
				html += "<span class='nodetext'></span>";
				html += "</div>";

				if (cfgHash.buttons)
				{
					html += "<div class='gmiller_buttonbar'>";
					for(var j = 0; j < cfgHash.buttons.length; j++)
		            {
						if (cfgHash.buttons[j].showOn == 'all' || (cfgHash.buttons[j].showOn == 'first' && i == 0))
						{
			            	html += "<button class='btn btn-default' id='" + this._getRenderedButtonId(widgetId, cfgHash.buttons[j].id, i) + "'  >" + cfgHash.buttons[j].caption + "</button>"; 			            								
						}
		            }
					html += "</div>";
				}
				html += "</div>"; 
				
				html += "<ul class='gmiller_container' id='" + this._getContainerIdByIndex(widgetId, i) + "'></ul>";				
				html += "</div>";
				
				html += "</div>";
			}
			
			this.element.addClass('gmiller');			
			this.element.html(html);	
			for (var i = 0; i < cfgHash.numberOfColumns; i++)
			{
			    this._uiInfo[i].nodeIdCaption = $(this._getNodeIdCaptionSelector(widgetId, i));
			    this._uiInfo[i].nodeTextCaption = $(this._getNodeLabelCaptionSelector(widgetId, i));
			}
		},
		
		_clearConfigTreeNodeReferenceTreeNode: function(startingIndex)
		{
			for(var i = startingIndex; i < this._treeConfig.length; i++)
			{
				this._treeConfig[i].refNodeId = null;
				this._treeConfig[i].refNode = null;
			}
		},
		
		_getRenderedButtonId: function(aWidgetId, buttonOptionId, sortableContainerIndex)
		{
			return aWidgetId + "_" + buttonOptionId + "_" + sortableContainerIndex;
		},
		
		_getSortableContainerIndexByButtonId: function(buttonId)
		{
			var sortableContainerIndex = -1;
			
			if (buttonId)
			{
				var ndx = buttonId.lastIndexOf("_");	
				if (ndx >= 0)
				{
				   sortableContainerIndex = parseInt(buttonId.substring(ndx + 1));				   
				}
			}
			
			return sortableContainerIndex;
		},
		
		_getButtonConfigByButtonId: function(sortableContainerButtonsArray, buttonId)
		{
			for (var i = 0; i < sortableContainerButtonsArray.length; i++) 
			{
				if (sortableContainerButtonsArray[i].id == buttonId) 
				{
					return sortableContainerButtonsArray[i];
				}
			}

			return null;
		},
		
		_getNodeIdCaptionSelector: function(aWidgetId, sortableContainerIndex)
		{
			return "#" + aWidgetId + " .gmiller_actionbar_caption_" + sortableContainerIndex + " .nodeid";
		},
		
		_getNodeLabelCaptionSelector: function(aWidgetId, sortableContainerIndex)
		{
			return "#" + aWidgetId + " .gmiller_actionbar_caption_" + sortableContainerIndex + " .nodetext";
		},
		
		_getReferenceTreeNode: function(sortableContainerIndex)
		{
			var configTreeNode = this._getConfigTreeNodeBySortableContainerIndex(sortableContainerIndex);						
			var refTreeNode = configTreeNode.refNode;
			if (!refTreeNode)
			{
				var nodeId = configTreeNode.refNodeId;
				if (nodeId)
				{				
				   var nInfo = this._rootNode.findNode(nodeId);
				   refTreeNode = (nInfo) ? nInfo.node : null;
				   configTreeNode.refNode = refTreeNode;
				}
			}	
			
			return refTreeNode;
		},
		
		_shiftRightSortableContainerView: function()
		{
			this._uiSlidingWindowOffset ++;
		},
		
		_shiftLeftSortableContainerView: function()
		{
			if (this._uiSlidingWindowOffset > 0)
				this._uiSlidingWindowOffset --;
		},
		
		_getConfigTreeNodeIndexBySortableContainerIndex: function(sortableContainerIndex)
		{
			// var refPathIndex = this._uiInfo[sortableContainerIndex].refPathIndex;
			var refPathIndex = this._uiSlidingWindowOffset + sortableContainerIndex;
			return refPathIndex;
		},
		
		_getConfigTreeNodeBySortableContainerIndex: function(sortableContainerIndex)
		{
			// var refPathIndex = this._uiInfo[sortableContainerIndex].refPathIndex;
			var refPathIndex = this._uiSlidingWindowOffset + sortableContainerIndex;
			return this._treeConfig[refPathIndex];
		},
		        	
		_enableDisableButtons_onSettingRefTreeNode: function(aSortableContainerIndex, refTreeNodeFlag)
		{
			for(var i = 0; i < this._uiInfo[aSortableContainerIndex].buttons.length; i++)
			{
			   var b = this._uiInfo[aSortableContainerIndex].buttons[i].buttonObj;
			   switch(this._uiInfo[aSortableContainerIndex].buttons[i].enabled)
			   {
			   case 'onRefNode':
				   if (refTreeNodeFlag)
					     b.show(); // b.prop('disabled', false);
				   else  b.hide(); // b.prop('disabled', true);
				   break;			   
			   }
			}
		},

		_enableDisableButtons_onSelection: function(aSortableContainerIndex, selectionFlag)
		{
			for(var i = 0; i < this._uiInfo[aSortableContainerIndex].buttons.length; i++)
			{
			   var b = this._uiInfo[aSortableContainerIndex].buttons[i].buttonObj;
			   switch(this._uiInfo[aSortableContainerIndex].buttons[i].enabled)
			   {			  
			   case 'onSelection':
				   if (selectionFlag)
					     b.show(); // b.prop('disabled', false);
				   else  b.hide(); // b.prop('disabled', true);
				   break;
			   }
			}
		},
		
		_setSortableContainerCaption: function(aSortableContainerIndex, aNodeId, aNodeText)
		{
			this._uiInfo[aSortableContainerIndex].nodeIdCaption.html(aNodeId);
			this._uiInfo[aSortableContainerIndex].nodeTextCaption.html(aNodeText);
		},
		
		_populateCanvas: function(startingIndex)
		{
			if (startingIndex > (this._uiInfo.length - 1))
				return;
			
			var cnt = this._getContainerObjByIndex(startingIndex);
			cnt.empty();
			
			var configTreeNodeIndex = this._getConfigTreeNodeIndexBySortableContainerIndex(startingIndex);			
			var configTreeNode = this._treeConfig[configTreeNodeIndex];
			var refTreeNode = this._getReferenceTreeNode(startingIndex);
			if (!refTreeNode)
			{
				console.log("gmiller::_populateCanvas Node not specified on Index: " + startingIndex);
				this._enableDisableButtons_onSettingRefTreeNode(startingIndex, false);
				this._enableDisableButtons_onSelection(startingIndex, false);
				this._setSortableContainerCaption(startingIndex, "", "");
				this._populateCanvas(startingIndex + 1);
				return ;
			}			

			this._enableDisableButtons_onSettingRefTreeNode(startingIndex, true);
			this._setSortableContainerCaption(startingIndex, refTreeNode.nodeId, refTreeNode.nodeText);

			var selectedNodeId = null;
			if (configTreeNodeIndex < (this._treeConfig.length - 1))
			{
				var nextConfigTreeNode = this._treeConfig[configTreeNodeIndex + 1];
				if (nextConfigTreeNode.refNodeId)
				{
					selectedNodeId = nextConfigTreeNode.refNodeId;
				}
			}
			
			var _self = this;
			if (refTreeNode.hasBeenFetched)
			{
				 var foundSelectedHtmlNode = null;
				 for(var i = 0; i < refTreeNode.getNumberOfChildren(); i++)
                 {
                 	var newNode = refTreeNode.children[i];                 	                 	                    	
                 	var htmlItem = _self.options.renderHtml4NewNode(newNode.nodeUserData);                    	
					cnt.append(htmlItem);
         			
         			if (selectedNodeId && selectedNodeId == newNode.nodeId)
         			{
         				foundSelectedHtmlNode = htmlItem;
         			}
                 }
				 
				 if (foundSelectedHtmlNode)
				 {
					  _self._updateSelectionHint(foundSelectedHtmlNode);	
					  _self._enableDisableButtons_onSelection(startingIndex, true);
				 }
				 else _self._enableDisableButtons_onSelection(startingIndex, false);
				
				 _self._populateCanvas(startingIndex + 1);				                 
			}
			else
			{
                this.options.onFetch(refTreeNode.nodeId, configTreeNodeIndex, function(jsonDataArray, iTotalRecords)
               	{
					refTreeNode.hasBeenFetched = true;
					
					var foundSelectedHtmlNode = null;
					if (iTotalRecords > 0)
					{
	                    for(var i = 0; i < iTotalRecords; i++)
	                    {
	                    	var newNode = new org.r3.widget.miller.TreeNode(jsonDataArray[i].getNodeId(), jsonDataArray[i].getNodeLabel(), jsonDataArray[i]);
	                    	refTreeNode.addChild(newNode);
	                    	                    	
	                    	var htmlItem = _self.options.renderHtml4NewNode(newNode.nodeUserData);                    	
							cnt.append(htmlItem);
	            			
	            			if (selectedNodeId && selectedNodeId == newNode.nodeId)
	            			{
	            				foundSelectedHtmlNode = htmlItem;
	            				_self._enableDisableButtons_onSelection(startingIndex, true);
	            			}
	            			else _self._enableDisableButtons_onSelection(startingIndex, false);
	                    }
					}
					
					if (foundSelectedHtmlNode)
					{
						_self._updateSelectionHint(foundSelectedHtmlNode);					
					}
					
					_self._populateCanvas(startingIndex + 1);				                	
               	});                			
			}
		},
		
        _getContainerObjByIndex: function(anIndex)
        {
        	if (!this._uiInfo[anIndex].containerObj)
        	{
        		this._uiInfo[anIndex].containerObj = this.element.find('#' + this._getContainerIdByIndex(this.element.attr('id'), anIndex));
        	}
        	
			return this._uiInfo[anIndex].containerObj;
        },
        
        _getContainerIdByIndex: function(aWidgetId, anIndex)
        {
			return aWidgetId + "_gmiller_container_" + anIndex;
        },

        _getContainerIndexById: function(aContainerId)
        {
        	for(var i = 0; i < this._uiInfo.length; i++)
        	{
        		if (this._uiInfo[i].containerId == aContainerId)
        			return i;
        	}
        	
			return -1;
        },
        
        _isContainerLinked2Node: function(aContainerId)
        {
        	var ndx = this._getContainerIndexById(aContainerId);
            if (ndx >= 0)
            {
            	var c = this._getConfigTreeNodeBySortableContainerIndex(ndx);
            	if (c && c.refNodeId)
            		return true;
            }
            
            return false;            	
        },
        
        _onSortableChange: function( event, ui ) 
		{
			console.log("gmiller::_onSortableChange ", event, ui);			
		},

        _onSortableStart: function( event, ui ) 
		{
			console.log("gmiller::_onSortableStart ", event, ui);
			this._dragStep = 'start';
			this._dragTarget = event.target;
		},

		_onSortableCreate: function( event, ui ) 
		{
			console.log("gmiller::_onSortableCreate ", event, ui);					
		},

		_onSortableOver: function (event, ui ) 
		{
        	console.log("gmiller::_onSortableOver ", event.target, ui.item, ui.sender);		
        },
        
        _onSortableOut: function (event, ui  ) 
        {
        	console.log("gmiller::_onSortableOut ", event.target, ui.item, ui.sender);	
        },
        
        _onSortableStop: function (event, ui  ) 
        {	
        	if (this._dragStep == 'receiving')
        	{
        		var dt = $(this._dragTarget);
        		var st = $(event.target);
        		console.log("gmiller::_onSortableStop RECEIVING FROM " + st.attr('id') + " --> " + dt.attr('id') + " Of item at index " + ui.item.index() + " With value ", ui.item);
                if (!this._moveCanBeApplied(dt, st, ui.item))
                {
                	console.log("gmiller::_onSortableStop RECEIVING FROM But Is Not ALlowed");
                	st.sortable('cancel');
                	alert(org.r3.widget.miller.message.moveNotAllowed);
                }
                else 
                {                	
                	this._applyMove(dt, st, ui.item, ui.item.index());
                }
        	}
        	else
        	{
          		var st = $(event.target);
        		console.log("gmiller::_onSortableStop SORTING ",  st, ui.item);
          		this._applySort(st, ui.item, ui.item.index());
        	}
        	
        	this._dragStep = 'none';
        	this._dragTarget = null;
        },
        
        _applySort: function(sourceContainer, anItem, anItemPosition)
        {
    		var stId = this._getContainerIndexById(sourceContainer.attr("id"));
    		var refTreeNode = this._getReferenceTreeNode(stId);
    		if (refTreeNode)
    		{
    			refTreeNode.moveChild(anItem.attr("id"), anItemPosition);
    		}
    		
    		if (!anItem.hasClass("selected"))
    		{
        		this._updateSelectionHint(anItem);   
    		}
    		
    		if (this.options.onSort)
    		{
    			this.options.onSort(
    					sourceContainer.attr('id'), 
    					refTreeNode.nodeId, 
    					anItem.attr("id"), 
    					anItemPosition, 
    					(anItemPosition == 0) ? null : refTreeNode.children[anItemPosition - 1].nodeId);
    		}
        },
        
        _applyMove: function(dropContainer, sourceContainer, anItem, anItemPosition)
        {
        	var ndxd = this._getContainerIndexById(dropContainer.attr('id'));
        	var ndxs = this._getContainerIndexById(sourceContainer.attr('id'));
        	var updateUiFromIndex = (ndxd < ndxs) ? ndxd : ndxs;
         
        	var itemId = anItem.attr("id");
        	var dropContainerReferenceTreeNode = this._getReferenceTreeNode(ndxd);
        	var sourceContainerReferenceTreeNode = this._getReferenceTreeNode(ndxs);
        	var targetTreeNodeInfo =  sourceContainerReferenceTreeNode.findNode(itemId);
        	targetTreeNodeInfo.parent.removeChild(itemId);
        	dropContainerReferenceTreeNode.addChild(targetTreeNodeInfo.node, anItemPosition);
        	
        	var dropContainerTreeConfigIndex = ndxd + this._uiSlidingWindowOffset;
        	if ((dropContainerTreeConfigIndex + 1) < this._treeConfig.length)
        	{
        	     this._clearConfigTreeNodeReferenceTreeNode(dropContainerTreeConfigIndex + 1);	
        	     this._treeConfig[dropContainerTreeConfigIndex + 1].refNodeId = itemId;
        	}
        	
        	this._populateCanvas(updateUiFromIndex);
        	if (this.options.onMove)
    		{
    			this.options.onMove(
    					dropContainer.attr('id'), 
    					sourceContainer.attr('id'), 
    					dropContainerReferenceTreeNode.nodeId, 
    					anItem.attr("id"), 
    					anItemPosition, 
    					(anItemPosition == 0) ? null : dropContainerReferenceTreeNode.children[anItemPosition - 1].nodeId);
    		}
        	
//        	// Nel caso in cui sto spostando un elemento selezionato il container perde la selezione.
//        	// In realtà debbo ridisegnare tutto...
//        	if (anItem.hasClass('selected'))
//        	{
//        	    this._enableDisableButtons_onSelection(aSortableContainerIndex, false);	
//        	}
//        	
//        	this._updateSelectionHint(anItem);
        },
        
        _moveCanBeApplied: function(dropContainer, sourceContainer, anItem)
        {        	
        	console.log("Source Container length: ", sourceContainer.find("li").length);
        	
        	if (!this._isContainerLinked2Node(dropContainer.attr('id')))
        	    return false;
        	
        	if (!this._isNodePromotion(dropContainer.attr('id'), sourceContainer.attr('id')))
        	{
        		
        		// Elemento selezionato oppure sourcecontainer che rimane vuoto. Questa condizione 
        		// pero' viene bloccata dal fatto che il target container non è inizializzato... In caso contrario vorrebbe dire che
        		// se il sourcecontainer rimane vuoto l'elemento e' stato anche selezionato
            	if (!(sourceContainer.find("li").length) || anItem.hasClass('selected'))
        		    return false;        	    	
        	}
        	        	
        	return true;
        },
        
        _updateSelectionHint: function(anItem)
        {
        	anItem.siblings().removeClass('selected');
        	anItem.addClass('selected');
        },
        
        _isNodePromotion: function(dropContainerId, sourceContainerId)
        {
        	var ndxd = this._getContainerIndexById(dropContainerId);
        	var ndxs = this._getContainerIndexById(sourceContainerId);
        	
        	return ndxd < ndxs;
        },
        
        _onSortableReceive: function (event, ui  ) 
        {
        	console.log("gmiller::_onSortableReceive ", event.target, ui.item, ui.sender);	
        	this._dragStep = 'receiving';
        	this._dragTarget = event.target;
        },
        
        _onSortableBeforeStop: function (event, ui) 
        {        	
        	console.log("gmiller::_onSortableBeforeStop ",  event.target, ui.item, ui.sender);
        }
        
	});

})(jQuery);

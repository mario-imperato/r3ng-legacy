(function($)
{
	$.widget('r3.gmenubar',
	{

		options :
		{},

		_create : function()
		{
			this._itemsMap =
			{};

			this._canvasDiv = $('<div></div>').addClass('canvas');

			var renderedHtml = "";
			if (this.options.mainaction)
			{
				renderedHtml = this._renderMainAction(this.options.mainaction);
			}

			if (this.options.sections && this.options.sections.length)
			{
				for(var i = 0; i < this.options.sections.length; i++)
				{
					renderedHtml = renderedHtml + this._renderSection( this.options.sections[i]);				
				}
			}

			this._canvasDiv.html(renderedHtml);
			
			this.element.addClass('gmenubar');
			this.element.html(this._canvasDiv);
			
			this._bindEvents(this.options);
		},

		addItems2Section: function(aSectionId, anItemsArray)
		{
			if (!anItemsArray || !anItemsArray.length)
				return;
			
			var sect = this._findItem(aSectionId);
			if (!sect)
			{
				console.error("gmenubar NO SECTION FOUND");		
				return ;
			}
			else
			{
				
			    var renderedHtml = this._generateHtml4SectionItems(anItemsArray);
			    $('#' + sect.id).append(renderedHtml);

				for ( var j = 0; j < anItemsArray.length; j++)
				{
					var item = anItemsArray[j];
					
					if (!sect.items)
						sect.items = [];
					
					sect.items.push(item);
					
					if (item.onClick)
						this._bindItemEvent(item);
				}
			}
		},
		
		updateItemTitle: function(anItemId, anItemTitle)
		{
			$('#' + anItemId + " span a").html(anItemTitle);
		},
		
		find: function(anItemId)
		{
			var theItem = this._findItem(anItemId);
			return theItem;
		},
		
		select: function(anItemId)
		{
			$('#' + this.element.attr('id') + ' .canvasItem').removeClass('selected');
		    this._deselectAll();
		    
			var theItem = this._findItem(anItemId);
			if (theItem)
			{
			    theItem.selected = true;
			    $("#" + this.element.attr("id") + " .canvasItem div[id='" + theItem.id + "']").parent().addClass('selected');
			}									
		},
		
		remove: function(anItemId)
		{			
		    $('#' + anItemId).parent().remove();
		    this._removeItem(anItemId);
		},
		
		destroy : function()
		{
			this._canvasDiv.remove();
			$.Widget.prototype.destroy.apply(this, arguments);
		},
		
		_renderMainAction: function(cfgHash)
		{
			var html = "<div class='canvas-section'>" + "<div class='main-action'>" + "<button id='"+ cfgHash.id +"' class='btn btn-primary start' type='button' >" +
			  "<span>" + cfgHash.title + "</span>" +
			  "</button>" +
			  "</div>" +
			  "</div>";
			
			return html;
		},
		
		_renderSection: function(cfgHash)
		{			
			var renderHtml = "";
			 
			renderHtml = "<div class='canvas-section' id='" + cfgHash.id + "'>";
			renderHtml = renderHtml +  this._generateHtml4SectionItems(cfgHash.items);			
			renderHtml += "</div>";
			
			if (cfgHash.bottom_border)
				renderHtml += "<hr />";	

			return renderHtml;
		},
		
		_generateHtml4SectionItems: function(items2Add)
		{
			var theHtml = "";
			
			if (items2Add && items2Add.length)
		    {	
								
				for(var j = 0; j < items2Add.length; j++)
				{
					var itemClassName = "";
					if (items2Add[j].selected)
						itemClassName = "selected";
					
					if (items2Add[j].customCSSClassName)
						itemClassName = itemClassName + " " + items2Add[j].customCSSClassName;
					theHtml += "<div class='canvasItem " + itemClassName + " cf'><div class='item' id=" + items2Add[j].id + "><span><a href='javascript:void(0)'>" + items2Add[j].title + "</a></span></div>";
				    
				    if (items2Add[j].deletable)
				    {
				    	theHtml += "<div class='item-action' id='item_action_" + items2Add[j].id + "'>&nbsp;</div>";
				    }
				    
				    theHtml += "</div>";
				}
		    }
			
			return theHtml;

		},
		
		_bindEvents : function(anHash)
		{
			if (this.options.mainaction && this.options.mainaction.onClick)
			{
				this._bindMainActionEvent(this.options.mainaction);
			}

			if (this.options.sections && this.options.sections.length)
			{
				for ( var i = 0; i < this.options.sections.length; i++)
				{
					var curSection = this.options.sections[i];
					if (curSection.items && curSection.items.length)
					{
						for ( var j = 0; j < curSection.items.length; j++)
						{
							var item = curSection.items[j];
							if (item.onClick)
								this._bindItemEvent(item);
						}
					}
				}
			}

		},
		
		_bindMainActionEvent: function(cfgItem)
		{
			var _self = this;
			$('#' + cfgItem.id).unbind(".gmenubar").bind('click.gmenubar', function(e) { _self._onMainActionClick(cfgItem.id); });
		},
		
		_bindItemEvent: function(cfgItem)
		{
			var _self = this;
			$('#' + cfgItem.id).unbind(".gmenubar").bind('click.gmenubar', function(e) { _self._onItemClick(cfgItem.id); });
			
			if (cfgItem.deletable)
			{
				console.info("Action: ", $('#item_action_' + cfgItem.id));
				$('#item_action_' + cfgItem.id).unbind(".gmenubar").bind('click.gmenubar', function(e) { _self._onDeleteItemClick(cfgItem.id); });					
			}
		},
		
		_onMainActionClick: function(aMainActionId)
		{
			console.info("_onMainActionClick " + aMainActionId);
			var eventItem = this._findItem(aMainActionId);
			
			if (eventItem.onClick)
				eventItem.onClick(eventItem);
		},
		
		_onItemClick: function(anItemId)
		{
			console.info("_onItemClick " + anItemId);
			var eventItem = this._findItem(anItemId);
			
			if (eventItem.onClick)
				eventItem.onClick(eventItem);

		},

		_onDeleteItemClick: function(anItemId)
		{
			console.info("r3_gmenubar _onItemClick " + anItemId);
			var eventItem = this._findItem(anItemId);
			
			if (eventItem.onClick)
				eventItem.onClick(eventItem, 'delete');
		},
		
		_deselectAll: function()
		{
			var visitor = {
					
					processMainAction: function(aMainAction)
					{
						aMainAction.selected = false;
						return true;
					},
					
					processItem: function(anItem)
					{
						anItem.selected = false;
						return true;
					},

					processSection: function(anItem)
					{
						return true;
					}

			};
				
				this._visit(visitor);			
		},

		_removeItem: function(anItemId)
		{
			var foundItem = null;
			var foundItemNdx = -1;
			var section = null;
			
			var visitor = {
					
				processMainAction: function(aMainAction)
				{
					if (aMainAction.id == anItemId)
					{
						foundItem = aMainAction;
						return false;
					}
					
					return true;
				},
				
				processItem: function(anItem, ndxOfItem)
				{
					if (anItem.id == anItemId)
					{
						foundItem = anItem;
						foundItemNdx = ndxOfItem;
						return false;
					}
					
					return true;
				},
				
				processSection: function(anItem)
				{
					section = anItem;
					return true;
				}				
			};
			
			this._visit(visitor);
			if (foundItem)
			{
			    if (section && section.items.length)
			    {
			    	var res = section.items.splice(foundItemNdx, foundItemNdx + 1);
			    	console.info("gmenubar::removing element from items at " + foundItemNdx, section.items, res);
			    }
			}
			return foundItem;
		},

		_findItem: function(anItemId)
		{
			var foundItem = null;			
			var visitor = {
					
				processMainAction: function(aMainAction)
				{
					if (aMainAction.id == anItemId)
					{
						foundItem = aMainAction;
						return false;
					}
					
					return true;
				},

				processSection: function(anItem)
				{
					if (anItem.id == anItemId)
					{
						foundItem = anItem;
						return false;
					}
					
					return true;
				},				

				processItem: function(anItem)
				{
					if (anItem.id == anItemId)
					{
						foundItem = anItem;
						return false;
					}
					
					return true;
				}				
			};
			
			this._visit(visitor);
			return foundItem;
		},
		
		_visit: function(aVisitor)
		{
			var keepOn = true;
			
			if (this.options.mainaction)
			{
				keepOn = aVisitor.processMainAction(this.options.mainaction);
				if (!keepOn)
				   return keepOn;
			}

			if (this.options.sections && this.options.sections.length)
			{
				for ( var i = 0; i < this.options.sections.length; i++)
				{
					var curSection = this.options.sections[i];
					
					keepOn = aVisitor.processSection(curSection);
					if (!keepOn)
						   return keepOn;	
					
					if (curSection.items && curSection.items.length)
					{
						for ( var j = 0; j < curSection.items.length; j++)
						{
							var item = curSection.items[j];
							keepOn = aVisitor.processItem(item, j);
							if (!keepOn)
							   return keepOn;							
						}
					}
				}
			}
			
			return true;			
		}
		
	});

})(jQuery);

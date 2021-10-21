(function($)
{
	$.widget('r3.gsidebar',
	{

		options :
		{},

		_create : function()
		{
			this._itemsMap =
			{};

			this._canvasDiv = $('<section></section>').addClass('sidebar');
			if (this.options.csshoverenabled)
				this._canvasDiv.addClass('csshoverenabled');
			
			var renderedHtml = "<ul class='sidebar-menu' id='gsidebar-menu'>";			

			if (this.options.sections && this.options.sections.length)
			{
				for(var i = 0; i < this.options.sections.length; i++)
				{
					if (this.options.sections[i].grouped)
					      renderedHtml = renderedHtml + this._renderGroupedSection( this.options.sections[i]);		
					else  renderedHtml = renderedHtml + this._renderLinearSection( this.options.sections[i]);
				}
			}

			renderedHtml = renderedHtml + "</ul>";
			
			this._canvasDiv.html(renderedHtml);
			
			// this.element.addClass('gsidebar');
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
				console.error("gsidebar NO SECTION FOUND");		
				return ;
			}
			else
			{
				
			    var renderedHtml = this._generateHtml4NestedSectionItems(anItemsArray);
			    $('#' + sect.id + " ul").append(renderedHtml);

				for ( var j = 0; j < anItemsArray.length; j++)
				{
					var item = anItemsArray[j];
					
					if (!sect.items)
						sect.items = [];
					
					sect.items.push(item);
					
					if (item.onClick)
						this._bindItemEvent(item);
				}
				
				 $('#' + sect.id).removeClass('empty');
			}
		},
		
		updateItemTitle: function(anItemId, anItemTitle)
		{
			$('#' + anItemId + " span").html(anItemTitle);
		},
		
		find: function(anItemId)
		{
			var theItem = this._findItem(anItemId);
			return theItem;
		},
		
		select: function(anItemId)
		{
			$('#' + this.element.attr('id') + ' li').removeClass('active');
		    this._deselectAll();
		    
			var theItem = this._findItem(anItemId);
			if (theItem)
			{
			    theItem.selected = true;
			    $("#" + this.element.attr("id") + " li[id='" + theItem.id + "']").addClass('active');
			}									
		},
		
		remove: function(anItemId)
		{			
		    $('#' + anItemId).remove();
		    this._removeItem(anItemId);
		},
		
		destroy : function()
		{
			this._canvasDiv.remove();
			$.Widget.prototype.destroy.apply(this, arguments);
		},
				
		_renderLinearSection: function(cfgHash)
		{
			var html = "";
			
			if (cfgHash.items && cfgHash.items.length)
			{
			   for(var j = 0; j < cfgHash.items.length; j++)
			   {
				  var item =  cfgHash.items[j];
					html = html + "<li style='overflow: hidden;' id='"+ item.id +"'>" +
					   "<a href='javascript:void(0)'>";
					
					var theIcon = '';
					if (item.icon)
					{
					    theIcon = 'fa-' + item.icon;					
					}
					
					html = html + 
					   "<i class='fa " + theIcon + "'></i>";	
					
					html = html + 
					  "<span>" + item.title + "</span>";
					
					html = html + 
					  "</a>" +
					  "</li>";					
			   }
			}
			  			
			return html;
		},
		
		_renderGroupedSection: function(cfgHash)
		{			
			var renderHtml = "";
			 
			renderHtml = renderHtml + 
			"<li id='"+ cfgHash.id +"'";
			
			var sectionStyle = 'treeview';
			if (!cfgHash.items || !cfgHash.items.length)
			{
				sectionStyle = sectionStyle + " empty";
			}
			
			renderHtml = renderHtml + " class='" + sectionStyle + "' ";
			
			renderHtml = renderHtml + ">";			
			renderHtml = renderHtml + "<a href='javascript:void(0)'>";
			
			var theIcon = '';
			if (cfgHash.icon)
			{
			    theIcon = 'fa-' + cfgHash.icon;					
			}
			
			renderHtml = renderHtml + 
			   "<i class='fa " + theIcon + " '></i>";							
			
			renderHtml = renderHtml + 
			  "<span >" + cfgHash.title + "</span>";
			
			renderHtml = renderHtml + 
			  "<i class='fa fa-angle-left pull-right'></i>";
						
			
			renderHtml = renderHtml + "</a>";
			
			renderHtml = renderHtml + "<ul class='treeview-menu'>";
			renderHtml = renderHtml +  this._generateHtml4NestedSectionItems(cfgHash.items);			
			renderHtml = renderHtml + "</ul>";
			
			renderHtml = renderHtml + "</li>";					                	

			return renderHtml;
		},
		
		_generateHtml4NestedSectionItems: function(items2Add)
		{
			var theHtml = "";
			
			if (items2Add && items2Add.length)
		    {	
								
				for(var j = 0; j < items2Add.length; j++)
				{
					theHtml += "<li style='overflow: hidden;' id='"+ items2Add[j].id +"'><a href='javascript:void(0)'><i class='fa fa-chevron-right  '></i><span>" + items2Add[j].title + "</span></a></li>";
				}
		    }
			
			return theHtml;

		},
						      
		_bindEvents : function(anHash)
		{
			 
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
		      
		_bindItemEvent: function(cfgItem)
		{
			var _self = this;
			$('#' + cfgItem.id).unbind(".gsidebar").bind('click.gsidebar', function(e) { _self._onItemClick(cfgItem.id); });			
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
			console.info("r3_gsidebar _onItemClick " + anItemId);
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
			    	console.info("gsidebar::removing element from items at " + foundItemNdx, section.items, res);
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

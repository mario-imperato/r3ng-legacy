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

			this._canvasDiv = $('<div></div>').addClass('gsidebar-nav');
			if (this.options.csshoverenabled)
				this._canvasDiv.addClass('csshoverenabled');
			
			var renderedHtml = "<ul class='sidebar-nav nav-pills nav-stacked' id='gsidebar-menu'>";			

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
			$('#' + anItemId + " span.menuitem-title").html(anItemTitle);
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
					html = html + "<li id='"+ item.id +"'>" +
					   "<a href='javascript:void(0)'>";
					
					var theIcon = '';
					if (item.icon)
					{
					    theIcon = 'fa-' + item.icon;					
					}
					
					html = html + 
					   "<span class='fa-stack fa-lg pull-left'><i class='fa " + theIcon + " fa-stack-1x '></i></span>";	
					
					html = html + 
					  "<span class='menuitem-title'>" + item.title + "</span>";
					
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
			
			var sectionStyle = 'section';
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
			   "<span class='fa-stack fa-lg pull-left'><i class='fa " + theIcon + " fa-stack-1x '></i></span>";							
			
			renderHtml = renderHtml + 
			  "<span class='menuitem-title'>" + cfgHash.title + "</span>";
			
			renderHtml = renderHtml + "</a>";
			
			renderHtml = renderHtml + "<ul class='nav-pills nav-stacked' style='list-style-type:none; display: none'>";
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
					theHtml += "<li id='"+ items2Add[j].id +"'><a href='javascript:void(0)'><span class='fa-stack fa-lg pull-left'><i class='fa fa-chevron-right fa-stack-1x '></i></span><span class='menuitem-title'>" + items2Add[j].title + "</span></a></li>";
				}
		    }
			
			return theHtml;

		},
						      
		_bindEvents : function(anHash)
		{
			// L'apertura e la chiusura puo' essere regolata mediante foglio di stile oppure mediante eventi js. In questo caso
			// viene gestita la dismissione della sidebar all'onclick. Questo però provoca una sequenza molto rapida di hover-out e hover-in che tendono a
			// riaprire il pannello. La logica qui vuole gestire la situazione seguente:
			// Quando si verifica un hover-out con la sidebar chiusa (presumibilmente per l'onclick allora il successivo hover-in viene confrontato
			// per timestamp e nel caso questo risulti troppo vicino allora la sidebar non viene riaperta in modo da non generare un fastidioso rimbalzetto.
            if (!this.options.csshoverenabled)
            {
            	var _self = this;
            	var hout_timestamp = 0;
            	this._canvasDiv.unbind(".gsidebar").bind('mouseenter.gsidebar', function(e) {
            		
            		if (hout_timestamp)
            		{
            		    console.log("Hover-in", e.timeStamp, e.timeStamp - hout_timestamp);                 		
                		if ((e.timeStamp - hout_timestamp) < 300)
                			return;
            		}
            		else console.log("Hover-in", e.timeStamp);
            		            		
            		_self._canvasDiv.addClass('open');
            		
            	}).bind('mouseleave.gsidebar', 
            	
            	function(e)
            	{
            		if (_self._canvasDiv.hasClass('open'))
            		{
            			_self._canvasDiv.removeClass('open');
            			hout_timestamp = 0;
          		        console.log("Hover-out", e.timeStamp);          			
            		}
            		else  
            		{
            			console.error("Hover-out", e.timeStamp);  
            			hout_timestamp = e.timeStamp;
            		}
            	});	
            }
			 
			if (this.options.sections && this.options.sections.length)
			{
				for ( var i = 0; i < this.options.sections.length; i++)
				{
					var curSection = this.options.sections[i];
					if (curSection.grouped)
					{
						this._bindOpenSubMenu(curSection);
					}
					
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

		_bindOpenSubMenu: function (anItem) 
		{			
			$('#' + anItem.id + " a").unbind(".gsidebar").bind('click.gsidebar', function(e) 
			{ 
			  var checkElement = $(this).next();
              if ((checkElement.is('ul'))) 
              {
            	  if (!checkElement.is(':visible'))            		  
            	  {
      				// $('#gsidebar-menu ul:visible').slideUp('normal');
    				checkElement.slideDown();            		  
                  }
            	  else checkElement.slideUp();
	 
            	  return false;
              }			  
			});
			
        },

		      
		_bindItemEvent: function(cfgItem)
		{
			var _self = this;
			$('#' + cfgItem.id).unbind(".gsidebar").bind('click.gsidebar', function(e) { _self._canvasDiv.removeClass('open'); _self._onItemClick(cfgItem.id); });			
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

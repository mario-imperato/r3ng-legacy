(function($)
{
	$.widget('r3.gmultiselect',
	{

		options :
		{},

		_create : function()
		{
			this._itemsMap =
			{};

			this._canvasDiv = $('<div></div>');

			var renderedHtml = this._renderHtml(this.options);

			this._canvasDiv.html(renderedHtml);	
			this.element.addClass('gmultiselect');
			
			this.element.html(this._canvasDiv);			
			this._initializeMultiSelectWidget(this.options.lutUrl, this.options.selectedValue);
			this._bindEvents(this.options);
		
		
		},
		
		destroy : function()
		{
			this._canvasDiv.remove();
			$.Widget.prototype.destroy.apply(this, arguments);
		},
		
		clear: function()
		{
		    this._deselectAll();	
		},
		
		disabled: function(aDisabledFlag)
		{
			if (arguments.length == 0)
				return this.disabledFlag;
			
			this.disabledFlag = aDisabledFlag;
			if (aDisabledFlag)
			{
				this._deselectAll();
			}

			this._getButton('add').prop('disabled', aDisabledFlag);
			this._getButton('add_all').prop('disabled', aDisabledFlag);
			this._getButton('remove').prop('disabled', aDisabledFlag);
			this._getButton('remove_all').prop('disabled', aDisabledFlag);

			this._getAvailableSelect().prop('disabled', aDisabledFlag);
			this._getSelectedSelect().prop('disabled', aDisabledFlag);

		},
		
		_renderHtml: function(cfgHash)
		{
			var buttonBarWidth = '';
			if (cfgHash.buttonBarWidth)
			{
				buttonBarWidth = "width: " + cfgHash.buttonBarWidth;	
			}
			
			var idPrefix = this.element.attr('id');
            var html = "<input type='hidden' name='" + cfgHash.fieldName + "' id='" + idPrefix + "_" + cfgHash.fieldName + "' />";

            html = html + "<div class='form-inline'>";
            html = html + 
              // "<div class='col-sm-5'>" + 
              "<select multiple='multiple' class='form-control' name='available_" + cfgHash.fieldName + "' size='7' id='" + idPrefix + "_available_" + cfgHash.fieldName + "' ></select>" +
              ""; // "</div>";

            html = html + 
               // "<div class='col-sm-2'>" +

               "<div class='actions'>" + 
               "<div>" + 
                   "<button id='" + idPrefix + "_action_add_all'    class='btn btn-default'><span class='glyphicon glyphicon-fast-forward' aria-hidden='true'></span></button>" + 
                   "<button id='" + idPrefix + "_action_add'        class='btn btn-default'><span class='glyphicon glyphicon-forward' aria-hidden='true'></span></button>" +
                   "<button id='" + idPrefix + "_action_remove'     class='btn btn-default'><span class='glyphicon glyphicon-backward' aria-hidden='true'></span></button>" +
                   "<button id='" + idPrefix + "_action_remove_all' class='btn btn-default'><span class='glyphicon glyphicon-fast-backward' aria-hidden='true'></span></button>" + 
               "</div>" + 
               "</div>";
            
            html = html + 
                // "<div class='col-sm-5'>" +
                "<select multiple='multiple' class='form-control' name='selected_" + cfgHash.fieldName + "' size='7' id='" + idPrefix + "_selected_" + cfgHash.fieldName + "'></select>" + 
                ""; // "</div>";
            
            html = html + "</div>";
			return html;
		},
		
		_bindEvents: function(anHash)
		{
			this._getButton('add').unbind().click($.r3Utils.hitch(this, this._onAddClick));

			this._getButton('add_all').unbind().click($.r3Utils.hitch(this, this._onAddAllClick));

			this._getButton('remove').unbind().click($.r3Utils.hitch(this, this._onRemoveClick));

			this._getButton('remove_all').unbind().click($.r3Utils.hitch(this, this._onRemoveAllClick));		
			
			this._getAvailableSelect().unbind().dblclick($.r3Utils.hitch(this, function(e) {
				this._select($(e.currentTarget).val());
			}));
			
			this._getSelectedSelect().unbind().dblclick($.r3Utils.hitch(this, function(e) {				
				this._deselect($(e.currentTarget).val());
			}));
			
		},
		
		_initializeMultiSelectWidget: function(lutUrl, selectedValue)
		{		
			$.ajax(
			{
				"type" : 'GET',
				"url" : lutUrl,
				"dataType" : "json",
				"success" : $.r3Utils.hitch(this, function(theLUT) 
				{
					var theModel = [];
					
					var selectedValueArray = selectedValue && selectedValue.length > 0 && selectedValue.split(',');
					if (theLUT.aaData && theLUT.aaData.length > 0)
					{					
					$.each(theLUT.aaData, function(index, item)
					{
						var selected = false;
						if (selectedValueArray && selectedValueArray.length > 0 && selectedValueArray.indexOf(item.dtokey) >= 0)
						{
							selected = true;
						}
						
						theModel.push({ "dtokey":  item.dtokey, "dtodescr": item.dtodescr, "selected": selected });
					});
					}

					this.multiSelectWidgetModel = theModel;
					this._updateUI(theModel);										
				}),
				"error" : function(jqXHR, timeout, message)
				{
					console.error("gmultiselect: ", message);
				}
			});			
		},
		
		_updateUI: function(theModel)
	    {
			var available_select = this._getAvailableSelect();
			var selected_select = this._getSelectedSelect();

			var available_select_options = available_select.prop('options');
			var selected_select_options = selected_select.prop('options');
			
			available_select_options.length = 0;
			selected_select_options.length = 0;

			for(var i = 0; i < theModel.length; i++)
			{
	            var opt = new Option(theModel[i].dtodescr, theModel[i].dtokey, false, false);
	     		if (theModel[i].selected)
	    		{
	     			selected_select_options[selected_select_options.length] = opt;	
	    		}
	    		else 
	    			available_select_options[available_select_options.length] = opt;			
			}
			
			this._getField().val(this._getSelectedItemsAsCSV());
	    },
	    
		_getSelectedItems: function()
	    {
			var opts = this._getSelectedSelect().prop('options');
			if (!opts || opts.length == 0)
				return null;
			
			var returningItems = [];
			for(var i = 0; i < opts.length; i++)
			{
			    returningItems.push(opts[i].value);	
			}
			
			return returningItems;
	    },

		_getSelectedItemsAsCSV: function()
	    {
			var opts = this._getSelectedSelect().prop('options');
			if (!opts || opts.length == 0)
				return '';
			
			var returningItems = '';
			for(var i = 0; i < opts.length; i++)
			{
				if (i > 0)
					returningItems = returningItems + ',';
				
			    returningItems = returningItems + opts[i].value;	
			}
			
			return returningItems;
	    },

	    _selectAll: function()
		{
			for(var i = 0; i < this.multiSelectWidgetModel.length; i++)
			{
				var selected = true;
				this.multiSelectWidgetModel[i].selected = selected;
			}
			
			this._updateUI(this.multiSelectWidgetModel);		
		},

		_select: function(currentSelection)
		{
			if (currentSelection)
			{
				for(var i = 0; i < this.multiSelectWidgetModel.length; i++)
				{
					var selected = true;
					if (currentSelection.indexOf(this.multiSelectWidgetModel[i].dtokey) >= 0)
					        this.multiSelectWidgetModel[i].selected = selected;
				}			
			}
			
			this._updateUI(this.multiSelectWidgetModel);
		},

		_deselectAll: function()
		{
			for(var i = 0; i < this.multiSelectWidgetModel.length; i++)
			{
				var selected = false;
				this.multiSelectWidgetModel[i].selected = selected;

				this._updateUI(this.multiSelectWidgetModel);		
			}
			
		},

		_deselect: function(currentSelection)
		{
			if (currentSelection)
			{
				for(var i = 0; i < this.multiSelectWidgetModel.length; i++)
				{
					var selected = false;
					if (currentSelection.indexOf(this.multiSelectWidgetModel[i].dtokey) >= 0)
					        this.multiSelectWidgetModel[i].selected = selected;
				}
				
				this._updateUI(this.multiSelectWidgetModel);
			}				
		},

		_getField: function()
		{
			var idPrefix = this.element.attr('id');
		    var bt = $('#' + idPrefix + "_" + this.options.fieldName);
		    return bt;
		},

		_getButton: function(buttonName)
		{
			var idPrefix = this.element.attr('id');
		    var bt = $('#' + idPrefix + '_action_' + buttonName);
		    return bt;
		},

		_getAvailableSelect: function()
		{
			var idPrefix = this.element.attr('id');
		    var bt = $('#' + idPrefix + "_available_" + this.options.fieldName);
		    return bt;
		},

		_getSelectedSelect: function()
		{
			var idPrefix = this.element.attr('id');
		    var bt = $('#' + idPrefix + "_selected_" + this.options.fieldName);
		    return bt;
		},

		_onAddClick: function(e)
		{
			console.info("onAddClick");
			this._select(this._getAvailableSelect().val());
	  		  
			e.preventDefault();
		},
		
		_onAddAllClick: function(e)
		{
			console.info("onAddAllClick");
			this._selectAll();
			
			e.preventDefault();
		},

		_onRemoveClick: function(e)
		{
			console.info("onRemoveClick");
	  		this._deselect(this._getSelectedSelect().val());

			e.preventDefault();
		},
		
		_onRemoveAllClick: function(e)
		{
			console.info("onRemoveAllClick");			
	  		this._deselectAll();

			e.preventDefault();
		}

	});

})(jQuery);

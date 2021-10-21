(function($)
{
	$.widget('r3.picker',
	{
		options : {},

		_create : function()
		{						
			this.options = $.extend({multiple: true,fieldHeight:131,fieldWidth:'100%',fieldSize:5,disabled:false}, this.options);
            var widgetHtml = this._buildHtml(this.options);                        
            this._picker = $(widgetHtml);
            
            this.element.html(this._picker);
			this._bindEvents(this.options);
			this.setVal(this.options.pickerValue);
		},

		addVal: function(pickerValue)
		{
		     if (this._isMultiSelection())
		     {
		         this._addMultiSelectionValue(pickerValue);     	 
		     }
		     else
		     {
		    	 this._setSingleSelectionValue(pickerValue);
		     }
		},

		_addMultiSelectionValue:  function(pickerValue)
		{
			var valueField = this._getValueField();
            var currentVal = valueField.val();
            if (currentVal && currentVal.indexOf(pickerValue.dtokey)>=0)
            {
            	console.info("Widget(Picker) - Item Already Present!");
            	return ;
            }
            
			var displayField = this._getDisplayField();
			var displayFieldOptions = displayField.prop('options');			
			
			if (pickerValue)
			{											
				var opt = new Option(pickerValue.dtodescr, pickerValue.dtokey, false, false);
				displayFieldOptions[displayFieldOptions.length] = opt;
				this._computeMultiSelectionValue();
			}
		},

		setVal: function(pickerValue)
		{
		     if (this._isMultiSelection())
		     {
		         this._setMultiSelectionValue(pickerValue);     	 
		     }
		     else
		     {
		    	 this._setSingleSelectionValue(pickerValue);
		     }
		},
		
		_setMultiSelectionValue:  function(pickerValue)
		{
			var valueField = this._getValueField();
			
			var displayField = this._getDisplayField();
			var displayFieldOptions = displayField.prop('options');
			displayFieldOptions.length = 0;
			
			if (pickerValue && pickerValue.iTotalRecords && pickerValue.aaData.length)
			{											
				for(var i = 0; i < pickerValue.aaData.length; i++)
				{
					var opt = new Option(pickerValue.aaData[i].dtodescr, pickerValue.aaData[i].dtokey, false, false);
					displayFieldOptions[displayFieldOptions.length] = opt;
				}
				
				this._computeMultiSelectionValue();
			}
			else
			{
			    valueField.val(null);
			}
		},
		
		_computeMultiSelectionValue: function()
		{
			var v = "";
			var displayFieldOptions = this._getDisplayField().prop('options');
						
			for(var j = 0; j < displayFieldOptions.length; j++)
			{
				if (j > 0)
					v = v + ";";
				
				v = v + displayFieldOptions[j].value;				
			}
			
			this._getValueField().val(v);
		},
		
		_setSingleSelectionValue: function(pickerValue)
		{
		    var dtokey = null; 
		    var dtodescr = null;
		    
		    if (pickerValue)
		    {
		    	dtokey = pickerValue.dtokey;
		    	dtodescr = pickerValue.dtodescr;
	        }
		     
 	        this._getValueField().val(dtokey);
	        this._getDisplayField().val(dtodescr);
		},
		
		_isMultiSelection: function()
		{
		     return this.options.multiple;	
		},
		
		_buildHtml: function(anHash)
		{
			var html = "<div>";
			
			html +=
				"<input type='hidden' name='" + anHash.fieldName + "' id='" + anHash.fieldId + "' />";
			
			if (anHash.multiple)
			{				
				html +=
					"<div class='form-inline'><div class='form-group' style='margin-left: 0px'>" +
					"<select name='" + anHash.fieldName + "_display' size='" + anHash.fieldSize + 
					      "' id='" + anHash.fieldId + "_display' style='height: " + anHash.fieldHeight + "px'></select></div>";
					      
				html +=
					"<div class='picker_actions' style='height: " + anHash.fieldHeight + "px'>" + 
					    
					      "<button id='" + anHash.fieldId + "_action_set'    class='btn btn-default' ><span class='glyphicon glyphicon-plus' aria-hidden='true'></span></button>" +
					      "<button id='" + anHash.fieldId + "_action_clear'  class='btn btn-default' ><span class='glyphicon glyphicon-minus' aria-hidden='true'></span></button>" +
		             "</div>" +
		             "</div></div>";				
			}
			else
			{
				html +=
					"<div class='form-group row'>" +
					"<div class='col-md-9 col-sm-10' style='padding-right: 0'>" +
					"<input type='text' class='form-control ' style='display: inline-block; width: " + anHash.fieldWidth + "' name='" + anHash.fieldName + "_display' id='" + anHash.fieldId + "_display' readonly='readonly'  />" + 
					"</div>";
				
				html +=
					"<div class='col-md-3 col-sm-2' style='padding: 0'>" +
					"<button id='" + anHash.fieldId + "_action_set'   class='btn btn-default' style='margin-left: 5px' ><span class='glyphicon glyphicon-plus' aria-hidden='true'></span></button>" +
					"<button id='" + anHash.fieldId + "_action_clear' class='btn btn-default' style='margin-left: 5px' ><span class='glyphicon glyphicon-minus' aria-hidden='true'></span></button>" +
					"</div></div>";
								
//				html +=
//					"<div class='form-inline'>" +
//					"<input type='text' class='form-control ' style='display: inline-block; width: " + anHash.fieldWidth + "' name='" + anHash.fieldName + "_display' id='" + anHash.fieldId + "_display' readonly='readonly'  />";
//				
//				html +=
//					"<div class='form-group' style='display: inline-block'>" +
//					"<button id='" + anHash.fieldId + "_action_set'   class='btn btn-default' style='margin-left: 5px' ><span class='glyphicon glyphicon-plus' aria-hidden='true'></span></button>" +
//					"<button id='" + anHash.fieldId + "_action_clear' class='btn btn-default' style='margin-left: 5px' ><span class='glyphicon glyphicon-minus' aria-hidden='true'></span></button>" +
//			        "</div></div>";		
				
			}
			
			html += "</div>";			
			return html;
		},
		
		_getValueField: function()
		{
			var f = null;
			f = $('#' + this.options.fieldId);
			
		    return f;
		},

		_getDisplayField: function()
		{
			var f = $('#' + this.options.fieldId + '_display');			
		    return f;
		},

		_getSetButton: function()
		{
		    var bt = $('#' + this.options.fieldId + '_action_set');
		    console.info("Bt...", bt);
		    return bt;
		},
		
		_getClearButton: function()
		{
		    return $('#' + this.options.fieldId + '_action_clear');	
		},
		
		_bindEvents: function(anHash)
		{					
			var b = this._getSetButton();			
			b.unbind().click($.r3Utils.hitch(this, this._openPicker));
		    b.prop("disabled", (typeof anHash.disabled === "undefined") ? false : anHash.disabled);
		    
		    var b = this._getClearButton();			
			b.unbind().click($.r3Utils.hitch(this, this._clearSelection));
		    b.prop("disabled", (typeof anHash.disabled === "undefined") ? false : anHash.disabled);
		    
//			this._getSetButton().button({
//			      icons: {
//			          primary: "ui-icon-plusthick"
//			      },
//			      text: false,
//			      disabled: ((typeof anHash.disabled === "undefined") ? false : anHash.disabled)
//			}).click($.r3Utils.hitch(this, this._openPicker));
//						
//			this._getClearButton().button({
//			      icons: {
//			          primary: "ui-icon-minusthick"
//			      },
//			      text: false,
//			      disabled: ((typeof anHash.disabled === "undefined") ? false : anHash.disabled)
//			}).click($.r3Utils.hitch(this, this._clearSelection));						
		},
		
		_openPicker: function(event)
		{
			console.info("Open Picker Called");
			if (this.options.openPicker)
				this.options.openPicker(this);
			
			event.preventDefault();
		},
		
		_clearSelection: function(event)
		{
			console.info("Clear Selection Called");
			if (this._isMultiSelection())
			{
			    this._clearMultiSelectionValue(event);	
			}
			else this.setVal();
				
			event.preventDefault();
		},
						
		_clearMultiSelectionValue: function(event)
		{
			var displayField = this._getDisplayField();
			var selectedIndex = displayField.prop('selectedIndex');
			
			if (selectedIndex < 0)
				console.info("Select an item please");
			else
			{
				displayField.find('option:selected').remove();
			}		
			
			this._computeMultiSelectionValue();
		},
		
		destroy : function()
		{
			this._widgetContainer.remove();
			$.Widget.prototype.destroy.apply(this, arguments);
		}

	});

})(jQuery);

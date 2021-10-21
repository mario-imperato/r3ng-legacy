(function($)
{
	$.widget('r3.wizardnavigator',
	{
		options : {},

		_create : function()
		{
			this._wizardNavigator = $('<div></div>').addClass('wizardNavigator');
            this._initializeWizard(this.options);                        
            
            this.element.html(this._wizardNavigator);
			this._bindEvents(this.options);
		},

		getSelected: function()
		{
			var selectedItem = this._getSelectedItem(this.options);
			return selectedItem;
		},
				
		find: function(aStepId)
		{
			var foundItem = this._findItemById(this.options, aStepId);
			return foundItem;
		},
		
		next: function()
		{
			var selectedItem = this._getSelectedItem(this.options);
			var nextItem = this._getNextItem(this.options);
			
			this._clearSelectionHint(this.options, selectedItem);
			this._selectItem(this.options, nextItem);
			
		    return nextItem;	
		},
		
		prev: function()
		{
			var selectedItem = this._getSelectedItem(this.options);
			var prevItem = this._getPrevItem(this.options);
			
			this._clearSelectionHint(this.options, selectedItem);
			this._selectItem(this.options, prevItem);
			
		    return prevItem;	
		},
		
		_clearSelectionHint: function(anHash, selectedItem)
		{
			if (selectedItem)
			{
			   	var removeCSSClassName = anHash.stepSelectedCSSClass;
			   	if (!removeCSSClassName)
			   		removeCSSClassName =  'wizardSelectedStep';
			   	
			   	var addCSSClassName = anHash.stepCSSClass;
			   	if (!addCSSClassName)
			   		addCSSClassName =  'wizardStep';
			   	
			   	$('#' + selectedItem.id).removeClass(removeCSSClassName).addClass(addCSSClassName);
			   	
			   	selectedItem.selected = false;
			   	if (selectedItem.active && selectedItem.onClick)
			    {
			   		this._bindEvent(selectedItem);		        	
			   		$('#' + selectedItem.id).addClass('wizardActiveStep');
			    }			   	
			}			
		},

        _selectItem: function(anHash, selectedItem)
        {
			if (selectedItem)
			{
		   	var addCSSClassName = this.options.stepSelectedCSSClass;
		   	if (!addCSSClassName)
		   		addCSSClassName =  'wizardSelectedStep';
		   	
		   	var removeCSSClassName = this.options.stepCSSClass;
		   	if (!removeCSSClassName)
		   		removeCSSClassName =  'wizardStep';
		   	
		   	$('#' + selectedItem.id).removeClass(removeCSSClassName).addClass(addCSSClassName);
		   	$('#' + selectedItem.id).removeClass('wizardActiveStep');
		   	
		    this._unbindEvent(selectedItem);
		    
		   	selectedItem.selected = true;		   			   	
		   	this._setWizardTitle(selectedItem);
			}        	
        },
		
        _setWizardTitle: function(anItem)
        {
        	var widgetId = this.element.attr("id");
        	$('#' + widgetId + " .wizardNavigatorTitle").html(anItem.title);
        	$('#' + widgetId + " .wizardNavigatorStepNumber").html(anItem.stepNumber);        	
            if (anItem.legend)
            {
            	$('#' + widgetId + " .wizardNavigatorLegend").html(anItem.legend);
            }
            else
            {
            	$('#' + widgetId + " .wizardNavigatorLegend").html("");
            }
        },
        
		_getSelectedItem: function(anHash)
		{
			for(var i = 0; i < anHash.steps.length; i++)
			{
			    var stepItem = anHash.steps[i];
		        if (stepItem.selected)
		        {
		        	return stepItem;		        	
		        }				
			}
			
			return null;
		},

		_findItemById: function(anHash, aStepId)
		{
			for(var i = 0; i < anHash.steps.length; i++)
			{
			    var stepItem = anHash.steps[i];
		        if (stepItem.id == aStepId)
		        {
		        	return stepItem;		        	
		        }				
			}
			
			return null;			
		},
		
		_getNextItem: function(anHash)
		{
			var selectedFound = false;
			for(var i = 0; i < anHash.steps.length; i++)
			{
			    var stepItem = anHash.steps[i];
		        if (stepItem.selected)
		        {
		        	selectedFound = true;		        	
		        }				
		        else
		        {
		            if (selectedFound)
		            	return stepItem;
		        }
			}
			
			return null;
		},

		_getPrevItem: function(anHash)
		{
			var prevItem = null;
			for(var i = 0; i < anHash.steps.length; i++)
			{
			    var stepItem = anHash.steps[i];
		        if (stepItem.selected)
		        {
		        	return prevItem;		        	
		        }
		        
		        prevItem = stepItem;
			}
			
			return null;
		},

		_bindEvents: function(anHash)
		{
			for(var i = 0; i < anHash.steps.length; i++)
			{
			    var stepItem = anHash.steps[i];
		        if (!stepItem.selected && stepItem.active && stepItem.onClick)
		        {
		        	this._bindEvent(stepItem);		        	
		        }
				
			}	
		},
		
		_bindEvent: function(aStepInfo)
		{
			var _self = this;
			$('#' + aStepInfo.id).unbind(".wizardnavigator").bind('click.wizardnavigator', function(e) { _self._onActiveClick(aStepInfo.id); });
		},

		_unbindEvent: function(aStepInfo)
		{
			var _self = this;
			$('#' + aStepInfo.id).unbind(".wizardnavigator");
		},

		_onActiveClick: function(aStepId)
		{
		    var selectedItem = this._getSelectedItem(this.options);		    
		    this._clearSelectionHint(this.options, selectedItem);
		    
		    var newSelectedItem = this._findItemById(this.options, aStepId);
		    this._selectItem(this.options, newSelectedItem);
		    
		    selectedItem.onClick(selectedItem, false);
		    newSelectedItem.onClick(newSelectedItem, true);
		},

		_initializeWizard: function(anHash)
		{
			var wizardHtml = "";
			
			wizardHtml += 
"<div style='clear: both'> </div>" +
"<ul class='wizardNavigatorSteps hidden-sm hidden-xs'>" +
"  <li><div class='wizardStepStart'>&nbsp;</div></li>";

			for(var i = 0; i < anHash.steps.length; i++)
			{
			    var stepItem = anHash.steps[i];
			    stepItem.stepNumber = i + 1;
			    
			    if (stepItem.selected)
			    {
			        wizardHtml = this._buildHtmlTitle(stepItem) + wizardHtml;
			        wizardHtml +=  this._buildHtmlSelectedStep(stepItem, anHash.stepSelectedCSSClass);
			    }
			    else if (stepItem.active && stepItem.onClick)
			    {
			    	wizardHtml +=  this._buildHtmlActiveStep(stepItem, anHash.stepCSSClass);
			    }
			    else wizardHtml +=  this._buildHtmlStep(stepItem, anHash.stepCSSClass);
			}
			
			wizardHtml += 
"<li><div class='wizardStepEnd'>&nbsp;</div></li></ul>";
			
			this._wizardNavigator.html(wizardHtml);
		},
		
		_buildHtmlTitle: function(aStepInfo)
		{
		    var generatedHtml = "";
		    
		    generatedHtml = 		    
"<div class='wizardNavigatorStepNumber'>" + aStepInfo.stepNumber + "</div>" + 
"<div class='wizardNavigatorTitle'>" + aStepInfo.title;
		    
            if (aStepInfo.legend)
            {
            	generatedHtml += "<br /><span class='wizardNavigatorLegend'>" +  aStepInfo.legend + "</span>";
            }
            
        	generatedHtml += "</div>";
        	return generatedHtml;
		},
		
		_buildHtmlSelectedStep: function(aStepInfo, aStepClass)
		{
		    var generatedHtml = "";
		    
		    var sClass = 'wizardSelectedStep';
		    if (aStepClass)
		    	sClass = aStepClass;
		    
		    generatedHtml =
"<li><div id='" + aStepInfo.id + "' class='" + sClass + "'><br />" + aStepInfo.briefTitle + "</div></li>";
		    
        	return generatedHtml;
		},

		_buildHtmlActiveStep: function(aStepInfo, aStepClass)
		{
		    var generatedHtml = "";
		    
		    var sClass = 'wizardStep';
		    if (aStepClass)
		    	sClass = aStepClass;

		    generatedHtml =
"<li><div id='" + aStepInfo.id + "' class='" + sClass + " wizardActiveStep'><br />" + aStepInfo.briefTitle + "</div></li>";
		    
        	return generatedHtml;
		},
		
		_buildHtmlStep: function(aStepInfo, aStepClass)
		{
		    var generatedHtml = "";
		    
		    var sClass = 'wizardStep';
		    if (aStepClass)
		    	sClass = aStepClass;
		    
		    generatedHtml =
"<li><div id='" + aStepInfo.id + "' class='" + sClass + "'><br />" + aStepInfo.briefTitle + "</div></li>";
		    
        	return generatedHtml;
		},
		
		destroy : function()
		{
			this._wizardNavigator.remove();
			$.Widget.prototype.destroy.apply(this, arguments);
		}

	});

})(jQuery);

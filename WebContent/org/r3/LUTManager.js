$.r3Utils.namespace("org.r3");

org.r3.LUTManager = Class.extend(
{
	init : function()
	{
		this.lutMAP =
		{};
	},

	isLUTLoaded : function(aUrl)
	{
		return this.lutMAP[aUrl];
	},

	invalidateLUT : function(aUrl)
	{
		this.lutMAP[aUrl] = null;
	},

	// Funzione di convenienza...
	getLUTNetworkRequest : function(aContext, aRequiredLUT, paramsArray)
	{
		var networkRequest =
		{
			"id" : "requiredLUT_" + aRequiredLUT,
			"context" : aContext,
			"requester" : function(onSuccess, onError)
			{
				var resolvedUrl = org.r3.PageManager.getRESTUrl(aRequiredLUT, paramsArray);
				org.r3.PageManager.lutManager.getLUT(resolvedUrl, onSuccess);
			}
		};

		return networkRequest;
	},

	addLUT: function(aUrl, jsonData)
	{
		var theLUT = jsonData;
		this.lutMAP[aUrl] = theLUT;
	},
	
	getLUT : function(aUrl, onComplete)
	{
		if (this.lutMAP[aUrl])
		{
			var theLUT = this.lutMAP[aUrl];
			if (onComplete)
				onComplete(theLUT);
			return theLUT;
		}

		$.getJSON(aUrl, $.r3Utils.hitch(this, function(jsonData)
		{
			var theLUT = jsonData;
			this.lutMAP[aUrl] = theLUT;
			if (onComplete)
				onComplete(theLUT);
		})).error(function(jqXHR, timeout, message)
		{
			console.error(aUrl, jqXHR, timeout, message);
		});

		return false;
	},

	getLUTItem : function(aUrl, anItemComparable, onComplete)
	{
		if (this.isLUTLoaded(aUrl))
		{
			var theLUT = this.lutMAP[aUrl];
			var theLUTItem = this._findItem(theLUT, anItemComparable);

			if (onComplete)
				onComplete(theLUTItem);

			return theLUTItem;
		}
		else
		{
			this.getLUT(aUrl, $.r3Utils.hitch(this, function(theLUT)
			{
				var theLUTItem = this._findItem(theLUT, anItemComparable);
				if (onComplete)
					onComplete(theLUTItem);
			}));
		}

		return false;
	},

	_findItem : function(theLUT, anItemComparable)
	{
		for ( var i = 0; i < theLUT.aaData.length; i++)
		{
			var item = theLUT.aaData[i];

			if (_.isString(anItemComparable) || _.isNumber(anItemComparable))
			{
				if (item.dtokey == anItemComparable)
				{
					return item;
				}
			}
			else if ($.isFunction(anItemComparable))
			{
				if (anItemComparable(item))
					return item;
			}
		}

		return false;
	},

	populateCheckBoxGroup : function(argsHash)
	{
		if (!argsHash.groupContainer || !argsHash.groupContainer.length)
			console.error("LUTManager::populateCheckBoxGroup::", argsHash.groupContainer);

		var container = argsHash.groupContainer;
		this.getLUT(argsHash.lutUrl, $.r3Utils.hitch(this, function(theLUT)
		{
			var me = this;
			if (theLUT.aaData && theLUT.iTotalRecords)
			{			
			$.each(theLUT.aaData, function(index, item)
			{
				var ddescr = (argsHash.fnRenderText) ? argsHash.fnRenderText(item) : item.dtodescr;
				var htmlFragment = me._createCheckBoxItem(argsHash.groupName, argsHash.groupId + item.dtokey.toLowerCase(), item.dtokey,
						ddescr, argsHash.value && argsHash.value.indexOf(item.dtokey) >= 0, argsHash.labelSize);
				container.append(htmlFragment);
			});
			}
			
			if (argsHash.onComplete)
				argsHash.onComplete(theLUT);
		}));
	},
	
	_createCheckBoxItem : function(aCheckName, aCheckId, aCheckValue, aCheckText, isChecked, aLabelSize)
	{
		if (aLabelSize)
			aLabelSize = 'width: ' + aLabelSize + 'px;';
		else aLabelSize = "";

		var selectionIndicator = (isChecked) ? ' checked ' : '';
        
		var htmlFragment = "<label class='checkbox-inline' style='" + aLabelSize + " '><input name='" + aCheckName + "' id='" + aCheckId + "' type='checkbox' value='" + aCheckValue + "' " 
		 + selectionIndicator + " />" + aCheckText + "</label>";
		return htmlFragment;
	},

	populateRadioGroup : function(argsHash)
	{
		if (!argsHash.groupContainer || !argsHash.groupContainer.length)
			console.error("LUTManager::populateRadioGroup::", argsHash.groupContainer);

		var container = argsHash.groupContainer;
		this.getLUT(argsHash.lutUrl, $.r3Utils.hitch(this, function(theLUT)
		{
			var me = this;
			if (theLUT.aaData && theLUT.iTotalRecords)
			{
			$.each(theLUT.aaData, function(index, item)
			{
				var ddescr = (argsHash.fnRenderText) ? argsHash.fnRenderText(item) : item.dtodescr;
				
				var htmlFragment = me._createRadioItem(argsHash.groupName, argsHash.groupId + item.dtokey.toLowerCase(), item.dtokey, ddescr,
						argsHash.value && item.dtokey == argsHash.value, argsHash.labelSize);
				container.append(htmlFragment);
			});
			}
			
			if (argsHash.onComplete)
				argsHash.onComplete(theLUT);
		}));
	},

	_createRadioItem : function(aRadioName, aRadioId, aRadioValue, aRadioText, isSelected, aLabelSize)
	{
		if (aLabelSize)
			aLabelSize = 'width: ' + aLabelSize + 'px;';
		else aLabelSize = "";
		
		var selectionIndicator = (isSelected) ? ' checked ' : '';
		var htmlFragment = "<label class='radio-inline' style='" + aLabelSize + " '><input name='" + aRadioName + "' id='" + aRadioId + "' type='radio' value='" + aRadioValue + "' "
				+ selectionIndicator + "  />" + aRadioText + "</label>";
		return htmlFragment;
	},

	populateInputFieldAsCSV : function(argsHash)
	{
		if (!argsHash.selectWidget || !argsHash.selectWidget.length)
			console.error("LUTManager::populateInputFieldAsCSV::", argsHash.selectWidget);

		this.getLUT(argsHash.lutUrl, $.r3Utils.hitch(this, function(aLUT)
		{
			var csvValue = "";
			if (aLUT.aaData && aLUT.iTotalRecords)
			{
			$.each(aLUT.aaData, function(index, item)
			{
				if (index > 0)
					csvValue += ",";

				csvValue += item.dtokey;
			});
			}
			
			// Provo a vedere se riesco a gestire piu' select
			// contemporaneamente..
			if (argsHash.selectWidget.length > 1)
			{
				$(argsHash.selectWidget[0]).val(csvValue);
			}
			else
				$(argsHash.selectWidget).val(csvValue);

			if (argsHash.onComplete)
				argsHash.onComplete(theLUT);
		}));
	},

	// argsHash: lutUrl, selectWidget, selectedValue, onComplete,
	// blankOptionText
	populateSelectField : function(argsHash)
	{
		if (!argsHash.selectWidget || !argsHash.selectWidget.length)
			console.error("LUTManager::populateSelectField::", argsHash.selectWidget);

		this.getLUT(argsHash.lutUrl, $.r3Utils.hitch(this, function(theLUT)
		{
			// Provo a vedere se riesco a gestire piu' select
			// contemporaneamente..
			if (argsHash.selectWidget.length > 1)
			{
				for ( var i = 0; i < argsHash.selectWidget.length; i++)
				{
					this._populateSelect(theLUT, $(argsHash.selectWidget[i]), argsHash.blankOptionText, argsHash.selectedValue, argsHash.keepTopNItems, argsHash.useBusinessKey, argsHash.fnRenderKey, argsHash.fnRenderText, argsHash.clientFilter);
				}
			}
			else
				this._populateSelect(theLUT, argsHash.selectWidget, argsHash.blankOptionText, argsHash.selectedValue, argsHash.keepTopNItems, argsHash.useBusinessKey, argsHash.fnRenderKey, argsHash.fnRenderText, argsHash.clientFilter);

			if (argsHash.onComplete)
				argsHash.onComplete(theLUT);
		}));
	},

	_populateSelect : function(aLUT, selectWidget, nullOption, selectedValue, keepTopNItems, useBusinessKey, fnRenderKey, fnRenderText, clientFilterFunction)
	{
		console.log("_populateSelect::", selectWidget);

		var selectOptions = selectWidget.prop('options');
		if (!selectOptions)
			console.error("Select Option is NULL for: ", selectWidget.attr('id'), selectedValue);
		selectOptions.length = keepTopNItems || 0;

		if (nullOption)
		{
			selectOptions[selectOptions.length] = new Option(nullOption, '');
		}

		 /* La condizione era su iTotalRecords */
		if (aLUT.aaData && aLUT.aaData.length)
		{
		var itemSelected = false;
		$.each(aLUT.aaData, function(index, item)
		{
			if (!clientFilterFunction  || clientFilterFunction(item))
			{
				var dkey = item.dtokey;
				if (useBusinessKey && item.businesskey) 
					dkey = item.businesskey;
				else if (fnRenderKey) 
					dkey =  fnRenderKey(item);
				
				var ddescr = (fnRenderText) ? fnRenderText(item) : item.dtodescr;
				
				if (index == 0)
					firstItemKey = dkey;

				itemSelected = false;
				if (selectedValue && $.isArray(selectedValue))
				{
					if ($.inArray(dkey, selectedValue) >= 0)
						itemSelected = true;
				}
				else if (selectedValue && _.isString(selectedValue))
				{
					if (selectedValue && dkey == selectedValue && !itemSelected)
					{
						itemSelected = true;
					}
				}

				selectOptions[selectOptions.length] = new Option(ddescr, dkey, itemSelected, itemSelected);				
			}			
		});		
		}

	},
	
	// M201509
	populateTextBoxGroup : function(argsHash)
	{
		if (!argsHash.groupContainer || !argsHash.groupContainer.length)
			console.error("LUTManager::populateTextBoxGroup::", argsHash.groupContainer);

		var container = argsHash.groupContainer;
		this.getLUT(argsHash.lutUrl, $.r3Utils.hitch(this, function(theLUT)
		{
			var me = this;
			if (theLUT.aaData && theLUT.iTotalRecords)
			{
			$.each(theLUT.aaData, function(index, item)
			{
				var ddescr = (argsHash.fnRenderText) ? argsHash.fnRenderText(item) : item.dtodescr;
				
				var htmlFragment = me._createTextBoxItem(argsHash.groupId + item.dtokey.toLowerCase(), argsHash.groupName + item.dtokey.toLowerCase(), ddescr, argsHash.template);
				container.append(htmlFragment);
			
				if (argsHash.getValue)
				{
				    $('#' + argsHash.groupId + item.dtokey.toLowerCase()).val(argsHash.getValue(item.dtokey.toLowerCase(), null));	
				}
			});					
			}
			
			if (argsHash.onComplete)
				argsHash.onComplete(theLUT);
		}));
	},

	_createTextBoxItem : function(aTextBoxId, aTextBoxName, aLabelText, aTemplate)
	{
		var templatedObject = {
			
				inputFieldTextLabel: aLabelText,
				inputFieldTextName:  aTextBoxName,
				inputFieldTextId: aTextBoxId
				
		};

		var htmlFragment = tmpl(aTemplate, templatedObject);      		
		return htmlFragment;
	}


});

(function($)
{
	$.fn.cascadingSelect = function(/* Hash */anOptionHash)
	{
		var defaults =
		{
			withNullOption : false,
			groupId : 'cascadingSelect',
			widgetConfig : [],
			lutManager : null,
			ajaxUrlMode : 'x-www-form-urlencoded'
		};
		var options = $.extend(
		{}, defaults, anOptionHash);

		if (this.length > 0)
		{
			if (_cascadingSelect_getWidgetDataOfItem($(this[0])))
			{
				_cascadingSelect_unbindOnChange($(this[0]));
				console.info("Unbinding Change On Cascading Select", $(this[0]), _cascadingSelect_getWidgetDataOfItem($(this[0])));
			}

			var cascadingInfo =
			{
				eventsBound : false,
				lutManager : options.lutManager,
				selectInfo : []
			};
			for ( var i = 0; i < this.length; i++)
			{
				var item = $(this[i]);
				var itemId = item.attr('id');
				if (!itemId)
				{
					itemId = options.groupId + '_' + i;
					item.attr('id', itemId);
				}

				var widgetConfig = _cascadingSelect_getWidgetConfig(itemId, options);

				var itemInfo =
				{
					'widgetId' : itemId,
					'ajaxSource' : widgetConfig.ajaxSource,
					'ajaxUrlMode' : widgetConfig.ajaxUrlMode,
					'value' : widgetConfig.value,
					'withNullOption' : options.withNullOption,
					'onChange' : widgetConfig.onChange,
					'onChangePropagate': options.onChangePropagate					
				};

				cascadingInfo.selectInfo[i] = itemInfo;

				item.data('cascadingSelect',
				{
					widgetIndex : i,
					'cascadingInfo' : cascadingInfo
				});

				item.prop('options').length = 0;
			}

			_cascadingSelect_populateSelect($(this[0]));
		}

		function _cascadingSelect_populateSelect(currentSelect)
		{
			var cascadingSelectInfo = _cascadingSelect_getCascadingSelectInfoOfItem(currentSelect);
			var ajaxEndPoint = _cascadingSelect_getAjaxSource(currentSelect);

			var selectOptions = currentSelect.prop('options');
			if (cascadingSelectInfo.withNullOption)
			{
				selectOptions[selectOptions.length] = new Option('', '');
			}

			var currentSelectValue = cascadingSelectInfo.value;

			var aLutManager = _cascadingSelect_getWidgetDataOfItem(currentSelect).cascadingInfo.lutManager;
			var onLutSuccess = function(jsonData)
			{
				var firstItemKey = null;
				var itemSelectedKey = null;
				var itemSelected = false;
				$.each(jsonData.aaData, function(index, item)
				{
					if (index == 0)
						firstItemKey = item.dtokey;

					if (currentSelectValue && item.dtokey == currentSelectValue)
					{
						itemSelected = true;
						itemSelectedKey = item.dtokey;
					}
					else
						itemSelected = false;

					selectOptions[selectOptions.length] = new Option(item.dtodescr, item.dtokey, itemSelected, itemSelected);
				});

				if (!cascadingSelectInfo.withNullOption && !itemSelectedKey)
					itemSelectedKey = firstItemKey;

				var doBindOnChange = !_cascadingSelect_getWidgetDataOfItem(currentSelect).cascadingInfo.eventsBound;

				// Indipendentemente dal fatto che sia stato valorizzato, se non
				// è presente nella lista è equivalente che sia null..
				// Nel caso in cui sia selezionata la opzione vuota (il che
				// significa che vi era la null option e non era stato
				// selezionato
				// nulla di corretto, allora i select a valle debbono rimanere
				// vuoti.
				if (!itemSelectedKey)
				{
					cascadingSelectInfo.value = null;
				}
				else
				{
					cascadingSelectInfo.value = itemSelectedKey;
					var nextItem = _cascadingSelect_getCascadingSelectInfoOfNextItem(currentSelect);
					if (nextItem)
					{
						_cascadingSelect_populateSelect($('#' + nextItem.widgetId));
						doBindOnChange = false;
					}
				}

				if (doBindOnChange)
					_cascadingSelect_bindOnChange(currentSelect);
			};

			if (aLutManager == null)
				$.getJSON(ajaxEndPoint, onLutSuccess);
			else
			{
				aLutManager.getLUT(ajaxEndPoint, onLutSuccess);
			}
		}

		function _cascadingSelect_unbindOnChange(item)
		{
			var widgetData = item.data('cascadingSelect');
			var cascadingInfo = widgetData.cascadingInfo;

			$.each(cascadingInfo.selectInfo, function(index, item)
			{
				$('#' + item.widgetId).unbind('change.cascadingSelect');
			});
		}

		function _cascadingSelect_bindOnChange(item)
		{
			var widgetData = item.data('cascadingSelect');
			var cascadingInfo = widgetData.cascadingInfo;

			$.each(cascadingInfo.selectInfo, function(index, item)
			{
				$('#' + item.widgetId).bind('change.cascadingSelect', function(e)
				{
					var item = $(this);
					var widgetData = item.data('cascadingSelect');
					var cascadingInfo = widgetData.cascadingInfo;
					cascadingInfo.selectInfo[widgetData.widgetIndex].value = item.val();
					if (cascadingInfo.selectInfo[widgetData.widgetIndex].onChange)
						cascadingInfo.selectInfo[widgetData.widgetIndex].onChange(item.val());
					
					for ( var i = widgetData.widgetIndex + 1; i < cascadingInfo.selectInfo.length; i++)
					{
						cascadingInfo.selectInfo[i].value = null;
						$('#' + cascadingInfo.selectInfo[i].widgetId).prop('options').length = 0;
						if (cascadingInfo.selectInfo[i].onChange && cascadingInfo.selectInfo[i].onChangePropagate)
							cascadingInfo.selectInfo[i].onChange();
						
					}

					if (item.val() && item.val().length > 0 && widgetData.widgetIndex < (widgetData.cascadingInfo.selectInfo.length - 1))
					{
						_cascadingSelect_populateSelect($('#' + cascadingInfo.selectInfo[widgetData.widgetIndex + 1].widgetId));
					}

				});

			});

			cascadingInfo.eventsBound = true;
		}

		function _cascadingSelect_getIndexOfItem(item)
		{
			var widgetData = item.data('cascadingSelect');
			return widgetData.widgetIndex;
		}

		function _cascadingSelect_getCascadingSelectInfoOfNextItem(item)
		{
			var widgetData = item.data('cascadingSelect');
			if (widgetData.widgetIndex < (widgetData.cascadingInfo.selectInfo.length - 1))
				return widgetData.cascadingInfo.selectInfo[widgetData.widgetIndex + 1];

			return null;
		}

		function _cascadingSelect_getWidgetDataOfItem(item)
		{
			var widgetData = item.data('cascadingSelect');
			return widgetData;
		}

		function _cascadingSelect_getCascadingSelectInfoOfItem(item)
		{
			var widgetData = item.data('cascadingSelect');
			return widgetData.cascadingInfo.selectInfo[widgetData.widgetIndex];
		}

		function _cascadingSelect_getAjaxSource(item)
		{
			var widgetData = item.data('cascadingSelect');
			var cascadingSelectInfo = _cascadingSelect_getCascadingSelectInfoOfItem(item);

			var ajaxSourceUrl = cascadingSelectInfo.ajaxSource;
			// console.info("cascadingSelectInfo.ajaxUrlMode",
			// cascadingSelectInfo.ajaxUrlMode);
			for ( var i = 0; i < widgetData.widgetIndex; i++)
			{
				var theSelect = $('#' + widgetData.cascadingInfo.selectInfo[i].widgetId);
				if (cascadingSelectInfo.ajaxUrlMode == 'restful')
					ajaxSourceUrl = _cascadingSelect_restUrlEncode(ajaxSourceUrl, i, theSelect.val());
				else
					ajaxSourceUrl = _cascadingSelect_formUrlEncode(ajaxSourceUrl, i, theSelect.attr('name'), theSelect.val());
			}

			// Salvo il riferimento all'ultimo REST invocato. Mi serve caso mai
			// qualcuno debba attaccare un listener onChange ad un item e ha la possibilità di accedere
			// all'ultima lut invocata...
			cascadingSelectInfo.resolvedAjaxSource = ajaxSourceUrl;
			return ajaxSourceUrl;
		}

		function _cascadingSelect_formUrlEncode(anAjaxSource, fieldIndex, fieldName, fieldValue)
		{
			if (fieldIndex == 0)
				anAjaxSource = anAjaxSource + "?";
			else
				anAjaxSource = anAjaxSource + "&";

			anAjaxSource = anAjaxSource + (fieldName || 'NONE') + "=" + fieldValue;
			return anAjaxSource;
		}

		function _cascadingSelect_restUrlEncode(anAjaxSource, fieldIndex, fieldValue)
		{
			anAjaxSource = $.r3Utils.stringFormat(anAjaxSource, fieldIndex, fieldValue);
			return anAjaxSource;
		}

		function _cascadingSelect_getWidgetConfig(widgetId, anOptionHash)
		{
			for ( var i = 0; i < anOptionHash.widgetConfig.length; i++)
			{
				if (anOptionHash.widgetConfig[i].widgetId == widgetId)
				{
					return $.extend(
					{},
					{
						'ajaxSource' : anOptionHash.ajaxSource,
						'ajaxUrlMode' : anOptionHash.ajaxUrlMode
					}, anOptionHash.widgetConfig[i]);
				}
			}

			console.error("CascadingSelect::_cascadingSelect_getWidgetConfig - Could not find widgetId");
			
			return	{
				'ajaxSource' : anOptionHash.ajaxSource,
				'ajaxUrlMode' : 'x-www-form- urlencoded',
				'value' : null
			};
		}

		return this;
	};

})(jQuery);

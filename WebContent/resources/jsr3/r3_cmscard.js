(function($)
{
	$.fn.cmsCard = function(/* Hash */anOptionHash)
	{
		var defaults =
		{
			card_tmpl: 'cms_tpl_simple', fetchmode: 'full',
			url_bycardid: 'GET_CardView_Detail_Info', 
			url_bycardquery: 'GET_CardView_Query_Info',
			adapterFactory: function(aRowDataBean)
			{
				return new org.r3.db.cms.cardview.CardViewDTOAdapter(aRowDataBean);
			}
		};
		
		var cmscard_options = $.extend({}, defaults, anOptionHash);

		if (!cmscard_options.site)
		{
		   cmscard_options.site =  org.r3.Constants.site;
		}
		
		cmscard_options.language = org.r3.Constants.language;
		
		if (this.length > 0)
		{
			var listOfDivInfo = [];
			var mapOfDivInfo = {};
			for ( var i = 0; i < this.length; i++)
			{
				var item = $(this[i]);
				var itemId = item.attr('id');
				var tpl = cmscard_options.card_tmpl || item.attr('card_tmpl');
				
				var divInfo = {
					canvasObj: item,
					canvasId: itemId,
					cardTemplate: tpl
				};
				
				listOfDivInfo.push(divInfo);
				mapOfDivInfo[itemId] = divInfo;
			}								
			
			var restUrl = null;
			if (cmscard_options.cardid)
			{
                restUrl = org.r3.PageManager.getRESTUrl(cmscard_options.url_bycardid, [ cmscard_options.site, cmscard_options.language, cmscard_options.cardid, cmscard_options.fetchmode ] );			     				
			}
			else
			{
				if (cmscard_options.cardquery)				
				{
					var actualQuery = cmscard_options.cardquery;
					if (cmscard_options.iDisplayLength && cmscard_options.iDisplayLength > 0)
					{
						actualQuery = actualQuery + "&iDisplayStart=" + (cmscard_options.iDisplayStart || '0') + "&iDisplayLength=" + cmscard_options.iDisplayLength;
					}
					else 
						actualQuery = actualQuery + "&iDisplayStart=0&iDisplayLength=-1";
					
                    restUrl = org.r3.PageManager.getRESTUrl(cmscard_options.url_bycardquery, [ cmscard_options.site, cmscard_options.language, cmscard_options.fetchmode, actualQuery ] );					
				}
				else
				{
					// Non ho un cardid. Non ho un cardquery. La condizione piu' probabile e' che l'invocazione avviene via URL su un cardid
					// che non esiste e che mi viene di fatto eliminato. Gestisco la situazione con un cardId dummy. In realtà non dovrei proprio
					// arrivare a questa condizione.
					console.error("CardQuery has not been set.... Why?");
					cmscard_options.cardid = '__NO_CARD__';
					restUrl = org.r3.PageManager.getRESTUrl(cmscard_options.url_bycardid, [ cmscard_options.site, cmscard_options.language, cmscard_options.cardid, cmscard_options.fetchmode ] );					
				}
			}
			
			_cmsCard_retrieveCardData(restUrl, mapOfDivInfo, listOfDivInfo, cmscard_options);
		}

		function _cmsCard_retrieveCardData(anAjaxSource, mapOfDivs, listOfDivs, pluginOptions)
		{
			var networkRequestsQueue = [];
			networkRequestsQueue.push(
			{
				id : "card_data",
				type : "Get",
				url : anAjaxSource,
				dataType : "json"
			});

			// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_SailEvent'));
			
			org.r3.PageManager.multiAjax(networkRequestsQueue,

			$.r3Utils.hitch(this, function(responseData)
			{
				_cmsCard_processCardData(mapOfDivs, listOfDivs, responseData["card_data"], pluginOptions);				
			}),

			// Error.
			function(d)
			{
				console.error("...> error");
			});
			
//			$.ajax(
//			{
//				"type" : "get",
//				"url" : org.r3.PageManager.getRESTUrl(anAjaxSource, [ aSite, aLanguage, aCardid ] ),
//				"dataType" : "json",
//				"success" : function(responseData)
//				{
//					_cmsCard_processCardData(mapOfDivs, listOfDivs, responseData);
//				},
//
//				"error" : function(jqXHR, timeout, message)
//				{
//					console.error("...> error");
//				}
//			});	 
		}
		
		function _cmsCard_applyTemplates(cardInfo, listOfDivs, pluginOptions)
		{
			for(var i = 0; i < listOfDivs.length; i++)
			{
				var renderedCard = tmpl(listOfDivs[i].cardTemplate, { "object": cardInfo, "options": _cmsCard_getRenderingOptions(pluginOptions, {}) });	
				var canvas = listOfDivs[i].canvasObj; // $('#' + listOfDivs[i].canvasId);
				
				// console.info("Rendering:", canvas, renderedCard);
				canvas.html(renderedCard);
				// console.info("Rendered");
				canvas.show();
			}						
		}

		function _cmsCard_retrieveExecutableHtmlFragments(listOfPropertyDTOAdapter, onComplete)
		{
			var networkRequestsQueue = [];
			
			for(var j = 0; j < listOfPropertyDTOAdapter.length; j++)
			{
				networkRequestsQueue.push(
				{
					id : listOfPropertyDTOAdapter[j].dataBean.propertyid,
					type : "Get",
					url : listOfPropertyDTOAdapter[j].getDocumenturl(),
					dataType : "html"
				});				
			}

			// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_SailEvent'));
			
			org.r3.PageManager.multiAjax(networkRequestsQueue,

			$.r3Utils.hitch(this, function(responseData)
			{
				// console.log("Should invoke onComplete");
				for(var j = 0; j < listOfPropertyDTOAdapter.length; j++)
				{
					 listOfPropertyDTOAdapter[j].dataBean.propertyvalue = responseData[listOfPropertyDTOAdapter[j].dataBean.propertyid];
				}
				
				if (onComplete)
					onComplete();
			}),

			// Error.
			function(d)
			{
				console.error("...> error");
			});			
		}

		function _cmsCard_getRenderingOptions(pluginOptions, moreInfo)
		{
			var renderingOptions = $.extend({}, pluginOptions, moreInfo);
//			if (renderingOptions.paginationHelper && !(typeof moreInfo.totalrecords === "undefined"))
//			{
//				renderingOptions.paginationHelper.initialize(pluginOptions.iDisplayStart, pluginOptions.iDisplayLength, moreInfo.totalrecords);
//			}
			
			// console.log("PassedOptions:", renderingOptions);
		    return renderingOptions; 	
		}
		
		function _cmsCard_processCardData(mapOfDivs, listOfDivs, responseData, pluginOptions)
		{			
			if (responseData && !(typeof responseData.aaData === "undefined"))
			{
				// console.log("responseData.aaData: " + responseData.aaData + "/" + (responseData.aaData != "undefined"));
				
				if (responseData.aaData && responseData.aaData.length > 0 && responseData.iTotalRecords)
				{
				var adapter = new org.r3.db.DTOTableAdapter(responseData, function(aRowDataBean) { return cmscard_options.adapterFactory(aRowDataBean); });   
			      
			    // E' stato richiesta una lista di card	da ficcare in una lista di divs. Necessario fare il match.
				if (listOfDivs.length > 1)
				{
					
				}
				else
				{
					var renderedCard = tmpl(listOfDivs[0].cardTemplate, { "object": adapter, "options": _cmsCard_getRenderingOptions(pluginOptions, { "totalrecords": responseData.iTotalRecords }) });	
					var canvas = listOfDivs[0].canvasObj; // $('#' + listOfDivs[0].canvasId);
					canvas.html(renderedCard);
					canvas.show();										
				}
				
				if (pluginOptions && pluginOptions.onComplete)
					pluginOptions.onComplete(adapter, responseData.iTotalRecords);
                }
				else
				{
					// console.info("$.fn.cmsCard - No Item Returned");
					if (pluginOptions && pluginOptions.onComplete)
						pluginOptions.onComplete(null, 0);
				}
								
			}
			else
			{				
			    // E' stato richiesta una singola card.				
				if (responseData)
				{
					var cardInfo = cmscard_options.adapterFactory(responseData);	
					if (cardInfo.hasExecutableHtmlFragments())
					{
						_cmsCard_retrieveExecutableHtmlFragments(cardInfo.dataBean.listof_executablehtmlfragments, function() {
							_cmsCard_applyTemplates(cardInfo, listOfDivs, pluginOptions);
						    if (pluginOptions && pluginOptions.onComplete)
						    	pluginOptions.onComplete(cardInfo, 1);	
						});
					}
					else
					{
						_cmsCard_applyTemplates(cardInfo, listOfDivs, pluginOptions);
						if (pluginOptions && pluginOptions.onComplete)
					    	pluginOptions.onComplete(cardInfo, 1);
					}
				}	
				else
				{
					var cardInfo = { cardid: pluginOptions.cardid };	
					for(var i = 0; i < listOfDivs.length; i++)
					{
						var renderedCard = tmpl("cms_tpl_notfound", { "object": cardInfo, "options": _cmsCard_getRenderingOptions(pluginOptions, {}) });	
						var canvas = listOfDivs[i].canvasObj; // $('#' + listOfDivs[i].canvasId);
						canvas.html(renderedCard);
						canvas.show();
					}	
					
					if (pluginOptions && pluginOptions.onComplete)
						pluginOptions.onComplete(null, 0);
				}
			}
		}
				
		return this;
	};

})(jQuery);

$.r3Utils.namespace("org.r3.jsportlet.mapexplore");

org.r3.jsportlet.mapexplore.MapExplorerActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.dummyGeoInfo = 
		{
	   "results" : [
	      {
	         "address_components" : [
	            {
	               "long_name" : "30",
	               "short_name" : "30",
	               "types" : [ "street_number" ]
	            },
	            {
	               "long_name" : "Via Roma",
	               "short_name" : "Via Roma",
	               "types" : [ "route" ]
	            },
	            {
	               "long_name" : "Terracina",
	               "short_name" : "Terracina",
	               "types" : [ "locality", "political" ]
	            },
	            {
	               "long_name" : "Terracina",
	               "short_name" : "Terracina",
	               "types" : [ "administrative_area_level_3", "political" ]
	            },
	            {
	               "long_name" : "Provincia di Latina",
	               "short_name" : "LT",
	               "types" : [ "administrative_area_level_2", "political" ]
	            },
	            {
	               "long_name" : "Lazio",
	               "short_name" : "Lazio",
	               "types" : [ "administrative_area_level_1", "political" ]
	            },
	            {
	               "long_name" : "Italia",
	               "short_name" : "IT",
	               "types" : [ "country", "political" ]
	            },
	            {
	               "long_name" : "04019",
	               "short_name" : "04019",
	               "types" : [ "postal_code" ]
	            }
	         ],
	         "formatted_address" : "Via Roma, 30, 04019 Terracina LT, Italia",
	         "geometry" : {
	            "location" : {
	               "lat" : 41.2896711,
	               "lng" : 13.2502455
	            },
	            "location_type" : "ROOFTOP",
	            "viewport" : {
	               "northeast" : {
	                  "lat" : 41.2910200802915,
	                  "lng" : 13.2515944802915
	               },
	               "southwest" : {
	                  "lat" : 41.2883221197085,
	                  "lng" : 13.2488965197085
	               }
	            }
	         },
	         "place_id" : "ChIJNwYq6mkjJRMR80SzzRlDGi4",
	         "types" : [ "street_address" ]
	      }
	   ],
	   "status" : "OK"
	};			
		
		this.shakeUsMarkers = 
		{
			"shkneighb": L.AwesomeMarkers.icon({ icon: 'users', markerColor: 'red' }),
			"shkshop": L.AwesomeMarkers.icon({ icon: 'shopping-cart', markerColor: 'orange' })
		}
	},

	close : function()
	{
		this.hide();
	},
	
	open : function(aConfigHash)
	{
		var _self = this;
		
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/mapexplore/MapExplorerActionForm.html.jsp'),
			dataType : "html"
		});

		networkRequestsQueue.push(
		{
			id : "content",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_MapExplorerNeighborhoods', [ '10' ]),
			dataType : "json"
		});		
						
		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_SailEvent'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	
			
			var siteCollectionDataTableAdapter = responseData['content'];
			if (siteCollectionDataTableAdapter)
			{
				siteCollectionDataTableAdapter = new org.r3.db.DTOTableAdapter(siteCollectionDataTableAdapter, 
						function(aRowDataBean) { return new org.r3.db.mongo.sitecollection.SiteCollectionDTOAdapter(aRowDataBean); });	
			}
			
			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));	
			
			$('#mapexplorerform_fieldsetmessage').formmessage({});
			
			this.initializeMap(siteCollectionDataTableAdapter);			
			this.map.invalidateSize();
			
			$('#mapexplorerform_queryneighborhoods').unbind().click($.r3Utils.hitch(this, this.searchNeighborhoods));
			
			$('#mapexplorerform_limit2favsites').unbind().click(function(e) {
				var currentTarget = $(e.currentTarget);
				if (currentTarget.prop('checked'))
				{
					 $('#mapexplorerform_sitetype').prop('disabled', true);
					 $('#mapexplorerform_sitetype').val('');
				}
				else $('#mapexplorerform_sitetype').prop('disabled', false);
			});
			
			$('#mapexplorerform_address select').cascadingSelect(
			{
				lutManager : org.r3.PageManager.lutManager,
				withNullOption : true,
				ajaxUrlMode : 'restful',
				widgetConfig : [
				{
					'widgetId' : 'mapexplorerform_area_level_1_id',
					'ajaxSource' : org.r3.PageManager.getRESTUrl('GET_classifier_ita_regione'),
					'value' : null
				},
				{
					'widgetId' : 'mapexplorerform_area_level_2_id',
					'ajaxSource' : org.r3.PageManager.getRESTUrl('GET_classifier_ita_regione_provincia'),
					'value' : null
				},
				{
					'widgetId' : 'mapexplorerform_area_level_3_id',
					'ajaxSource' : org.r3.PageManager.getRESTUrl('GET_classifier_ita_regione_provincia_localita'),
					'value' : null
				}]
			});		
			
			$('#mapexplorerform_fieldsetmessage').formmessage({});
			
			// this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
		
	},
	
	initializeMap: function(aSiteCollectionDataTableAdapter)
	{		
		var geoLoc = org.r3.PageManager.clientGeoLocation;		
		this.map = L.map('mapexplorer-leafletmap').setView(geoLoc, 13);
        
		L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
		    attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
		}).addTo(this.map);

		this._createNeighborhoodsMarkers(aSiteCollectionDataTableAdapter);
		
//		var m = L.marker(geoLoc);
//		m.site = 'cvfonline'; // org.r3.Constants.site;
//		
//		m.addTo(this.map)
//		    .bindPopup('A pretty CSS3 popup.<br> Easily customizable.')
//		    .openPopup()
		;
		
		this.sidebar = L.control.sidebar('mapexplorer-sidebar').addTo(this.map);					
		this.map.on('click', $.r3Utils.hitch(this, this.onMapClicked));		
	},

	_createNeighborhoodsMarkers: function(aSiteCollectionDataTableAdapter)
	{
		var queryOk = false;
		 
		if (aSiteCollectionDataTableAdapter)
	    {
			var numItems = aSiteCollectionDataTableAdapter.getNumberOfItems();
			if (numItems > 0)
			{
				var markers = [];
				var firstMarkerCoords = null;
		        for(var i = 0; i < numItems; i++)
		        {
		        	var item = aSiteCollectionDataTableAdapter.getItem(i);
		        	var address = item.getAddressDTOAdapter();
		        	var coords = address && address.getLocationAsCoordsArray();
		        	if (coords)
		        	{
		        		var m = L.marker(coords, {icon: this.shakeUsMarkers[item.dataBean.sitetype] });
		        		m.site = item.dataBean.site; // org.r3.Constants.site;		        				        		
		        		m.on('click', $.r3Utils.hitch(this, this.onSelectNeighborhood));
		        		markers.push(m);
		        		
		        		// Memorizzo la posizione del primo risultato.
		        		if (!firstMarkerCoords)
		        			firstMarkerCoords = coords;
		        	}
		        }
		        
		        if (markers.length)
		        {
		        	this.sitesMarkers = L.layerGroup(markers);
		        	this.sitesMarkers.addTo(this.map); 	
		        	
		        	// Sposto la mappa
		        	this.map.setView(firstMarkerCoords, 13);
		        	
		        	queryOk = true;
		       	}
			}
		}
		
		if (queryOk)
		{
			$('#mapexplorerform_fieldsetmessage').formmessage('clear');
		}
		else
		{
			$('#mapexplorerform_fieldsetmessage').formmessage('setText', { text: "Nessun risultato trovato", category: 'error' });	
		}

	},
	
	onMapClicked: function(e)
	{
		this.sidebar.close();
	},
	
//	onSelectNeighborhood_OLD: function(e)
//	{
//		var _self = this;
//		
//		var restUrl = org.r3.PageManager.getRESTUrl('GET_SiteDetail', [ e.target.site ]);
//		$.ajax(
//		{
//			"type" : "get",
//			"url" : restUrl,
//			"dataType" : "json",
//			"success" : function(responseData)
//			{
//				var siteDTOAdapter = new org.r3.db.system.site.SiteDTOAdapter(responseData);
//				_self.sidebar.open('mapexplorer-neib');
//				console.log("Neib Id:", e.target.site);
//				$('#mapexplorer-tab-neib').removeClass('disabled');
//				$('#mapexplorer-tab-neib-news').removeClass('disabled');
//				
//				$('#mapexplorer-neib .sidebar-header .title').html(siteDTOAdapter.dataBean.sitedescr);
//				
//				$('#mapexplorer-neib-news .sidebar-pane-body').cmsCard({ 
//					card_tmpl: "cms_tpl_listofcards", 
//					cardquery: "channelid=CHN09",
//					pageid: "DUMM",
//					site: e.target.site,
//				    onComplete: function()
//				    {
//				    }
//				});
//								
//				if (siteDTOAdapter.dataBean.cardid)
//				{
//				$('#mapexplorer-neib .sidebar-pane-body').cmsCard({ 
//					card_tmpl: "cms_tpl_shakeusmapexplorer", 
//					cardid: siteDTOAdapter.dataBean.cardid,
//					pageid: "DUMM",
//					site: e.target.site,
//				    onComplete: function()
//				    {
//				    	$('#shakeus_mapexplorer_enter').unbind().click(function(e) { 
//				    		org.r3.PageManager.gotoPage(org.r3.Constants.getStrutsActionContext(siteDTOAdapter.dataBean.site) + "/org/r3/home.do") });
//				    }
//				});				
//				}
//			},
//			"error" : function(jqXHR, timeout, message)
//			{
//				console.error("Errore Deleting Actor Group: ", message);
//			}
//		});	
//						
//	},

	onSelectNeighborhood: function(e)
	{
		var _self = this;
		
		var restUrl = org.r3.PageManager.getRESTUrl('GET_SiteCollection_Detail', [ e.target.site ]);
		$.ajax(
		{
			"type" : "get",
			"url" : restUrl,
			"dataType" : "json",
			"success" : function(responseData)
			{
				siteCollectionDTOAdapter = new org.r3.db.mongo.sitecollection.SiteCollectionDTOAdapter(responseData);
				
				_self.sidebar.open('mapexplorer-neib');
				$('#mapexplorer-tab-neib').removeClass('disabled');
				$('#mapexplorer-tab-neib-news').removeClass('disabled');
				$('#mapexplorer-neib-news .sidebar-pane-body').cmsCard(
				{
					pageid: null,
					site: siteCollectionDTOAdapter.dataBean.site,
					card_tmpl : "cms_tpl_shakeusmapexplorer_news",
					cardquery : "status=published&includecomments=bfalse&groups=news&iDisplayLength=10&iDisplayStart=0&iSortingCols=1&iSortCol_0=0&sColumns=postid&sSortDir_0=DESC",
					fetchmode: "full",
					adapterFactory: function(aRowDataBean)
					{
						return new org.r3.db.mongo.postcollection.PostCollectionDTOAdapter(aRowDataBean);
					},
					url_bycardquery: 'CMSCardPlugin_GETPosts',
					onComplete : function(responseInfo, totalNumberOfItems)
					{			
					}
			    });	
				   
				$('#mapexplorer-neib .sidebar-header .title').html(siteCollectionDTOAdapter.dataBean.description || "Not Provided");
												
				$('#mapexplorer-neib .sidebar-pane-body').html(tmpl("cms_tpl_shakeusmapexplorer", { "siteCollectionDTOAdapter" : siteCollectionDTOAdapter }));
				$('#shakeus_mapexplorer_enter').unbind().click(function(e) { 
		    		org.r3.PageManager.gotoPage(org.r3.Constants.getStrutsActionContext(siteCollectionDTOAdapter.dataBean.site) + "/org/r3/home.do") });
					
			},
			"error" : function(jqXHR, timeout, message)
			{
				console.error("Errore Deleting Actor Group: ", message);
			}
		});	
						
	},

	searchNeighborhoods: function()
	{
		var _self = this;
		
		_self.sitesMarkers.clearLayers(); 
		
		org.r3.AjaxUtils.submitForm(
				"get", 
				org.r3.PageManager.getRESTUrl('GET_SiteCollections'),  
				$('#mapexplorerform_form'), 
				function(responseData) 
				{ 
					var siteCollectionDataTableAdapter = null;
					if (responseData)
					{
						siteCollectionDataTableAdapter = new org.r3.db.DTOTableAdapter(responseData, 
								function(aRowDataBean) { return new org.r3.db.mongo.sitecollection.SiteCollectionDTOAdapter(aRowDataBean); });	
						
						var numItems = siteCollectionDataTableAdapter.getNumberOfItems();
						if (numItems > 0)
							_self.sidebar.close();
						
						_self._createNeighborhoodsMarkers(siteCollectionDataTableAdapter);
					}					 
				}, 
				function(jqXHR, timeout, message) { $('#mapexplorerform_fieldsetmessage').formmessage('setText', { text: message, category: 'error' }); },
				null,
		        false);	
	}
			
});

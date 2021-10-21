$.r3Utils.namespace("org.r3.jsportlet.address");

org.r3.jsportlet.address.AddressActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.addressMarkerIcon = L.AwesomeMarkers.icon({ icon: 'user', markerColor: 'green' })
		this.dummyGeoInfo2 = 
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
	},

	close : function()
	{
		this.hide();
	},
	
	open : function(anAddressDTOAdapter, isTabbedLayoutFlag)
	{
		var _self = this;
		
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/address/AddressActionForm.html.jsp'),
			dataType : "html"
		});

		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_SailEvent'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	
			
			$(this.htmlContainerId).html(tmpl(responseData['view'], { isTabbedLayout: isTabbedLayoutFlag }));												

			$("#addressform_form").validate
            ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.jsportlet.address.addressform_form_validationRules,
		           messages: org.r3.jsportlet.address.addressform_form_validationMessages    
	        });

			$('#addressform_action_save').unbind().click($.r3Utils.hitch(this, this.onAddressFormSave));
			$('#addressform_fieldset_message').formmessage({});
			
			$( "#addressform_address" ).unbind().blur(function (e) {
				if ($("#addressform_form").valid()) {
					
					/*
					_self.geoInfoData2FormFields(_self.dummyGeoInfo);					
					return ;
                    */
					
					org.r3.GoogleMapsUtils.geoCodeAddress(
						$("#addressform_address" ).val(),
						null,
						$('#addressform_zipcode').val(),
						$("#addressform_administrative_area_level_1_id option:selected").text(),
						$("#addressform_administrative_area_level_2_id option:selected").text().substring(0, 2),
						$("#addressform_administrative_area_level_3_id option:selected").text(),						
						"Italia",
						$.r3Utils.hitch(_self, _self.onGeoCodeAddress)
					);

					
				}
			});
			
			$('#addressform_form select').cascadingSelect(
			{
				lutManager : org.r3.PageManager.lutManager,
				withNullOption : true,
				ajaxUrlMode : 'restful',
				widgetConfig : [
				{
					'widgetId' : 'addressform_administrative_area_level_1_id',
					'ajaxSource' : org.r3.PageManager.getRESTUrl('GET_classifier_ita_regione'),
					'value' : anAddressDTOAdapter && anAddressDTOAdapter.getAdministrative_area_level_1_id()
				},
				{
					'widgetId' : 'addressform_administrative_area_level_2_id',
					'ajaxSource' : org.r3.PageManager.getRESTUrl('GET_classifier_ita_regione_provincia'),
					'value' : anAddressDTOAdapter && anAddressDTOAdapter.getAdministrative_area_level_2_id()
				},
				{
					'widgetId' : 'addressform_administrative_area_level_3_id',
					'ajaxSource' : org.r3.PageManager.getRESTUrl('GET_classifier_ita_regione_provincia_localita'),
					'value' : anAddressDTOAdapter && anAddressDTOAdapter.getAdministrative_area_level_3_id(),
					'onChange': function(itemVal)
					{
						var widgetData = $('#addressform_administrative_area_level_3_id').data('cascadingSelect');
						var selectInfo = widgetData.cascadingInfo.selectInfo[widgetData.widgetIndex];
						
						if (selectInfo.resolvedAjaxSource)
						{					
							var theLUTItem = org.r3.PageManager.getLUTItem(selectInfo.resolvedAjaxSource, itemVal);
							if (theLUTItem)
								$('#addressform_zipcode').val(theLUTItem.classifieritemsattr);
							
							$('#addressform_address').focus();
						}	
					}
				}]
			});		
			
			this.initializeFormFields(anAddressDTOAdapter);
			this.initializeMap(anAddressDTOAdapter && anAddressDTOAdapter.getLocationAsCoordsArray());
			// this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
		
	},
	
	initializeMap: function(anAddressLocation)
	{		
		var geoLoc = org.r3.PageManager.clientGeoLocation;
		if (anAddressLocation)
			geoLoc = anAddressLocation;
		
		this.map = L.map('addressform_leafletmap').setView(geoLoc, 13);
        
		L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
		    attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
		}).addTo(this.map);

		if (anAddressLocation)
		{
			this.marker = L.marker(anAddressLocation, {icon: this.addressMarkerIcon });
			this.marker.addTo(this.map);
		}
		else this.marker = null;
		
//		    .bindPopup('A pretty CSS3 popup.<br> Easily customizable.')
//		    .openPopup()

	},
	
	initializeFormFields : function(anAddressDTOAdapter)
	{
		if (!anAddressDTOAdapter)
			return ;
		
		$('#addressform_street_number'              ).val(anAddressDTOAdapter.dataBean.snumber);
		$('#addressform_locality'                   ).val(anAddressDTOAdapter.dataBean.locality);
		$('#addressform_route'                      ).val(anAddressDTOAdapter.dataBean.route); 
		$('#addressform_administrative_area_level_3').val(anAddressDTOAdapter.getSerializedAdminarea_l3());
		$('#addressform_administrative_area_level_2').val(anAddressDTOAdapter.getSerializedAdminarea_l2());
		$('#addressform_administrative_area_level_1').val(anAddressDTOAdapter.getSerializedAdminarea_l1());
		$('#addressform_country'                    ).val(anAddressDTOAdapter.getSerializedCountry()); 
		$('#addressform_postal_code'                ).val(anAddressDTOAdapter.dataBean.postcode);
		$('#addressform_zipcode'                    ).val(anAddressDTOAdapter.dataBean.postcode);
		
		$('#addressform_location'                   ).val(anAddressDTOAdapter.getSerializedLocation());
		$('#addressform_northeast'                  ).val(anAddressDTOAdapter.getSerializedNortheast());
		$('#addressform_southwest'                  ).val(anAddressDTOAdapter.getSerializedSouthwest());
		$('#addressform_place_id'                   ).val(anAddressDTOAdapter.dataBean.gmapplaceid);
		$('#addressform_formatted_address'          ).val(anAddressDTOAdapter.dataBean.formatted);		
		$('#addressform_address'                    ).val(anAddressDTOAdapter.getRouteStreetNumber());	
	},
	
	onAddressFormSave : function(event)
	{
		var _self = this;
		
		if (_self.actionFormManager && _self.actionFormManager.onAddressFormSave)
		{
			_self.actionFormManager.onAddressFormSave();
		}
		
		event.preventDefault();		
	},

	onGeoCodeAddress : function(geoInfo)
	{
		console.log("org.r3.GoogleMapsUtils::geoCodeAddress", geoInfo);
		var ndx = org.r3.GoogleMapsUtils.getGeoCodeStreetAddressResultIndex(geoInfo);
		if (ndx != -1)
		{								  
			var c = org.r3.GoogleMapsUtils.getGeoCodeAddressComponent(geoInfo, ndx, 'street_number');
			var w = $('#addressform_street_number'          ); 
			if (c)  
			   	 w.val(c.long_name);
			else w.val(null);
			
			c = org.r3.GoogleMapsUtils.getGeoCodeAddressComponent(geoInfo, ndx, 'locality');								
			w = $('#addressform_locality'                   ); 
			if (c)  
			   	 w.val(c.long_name);
			else w.val(null);
			
			c = org.r3.GoogleMapsUtils.getGeoCodeAddressComponent(geoInfo, ndx, 'route');
			w = $('#addressform_route'                      ); 
			if (c)  
			   	 w.val(c.long_name);
			else w.val(null);
											
			c = org.r3.GoogleMapsUtils.getGeoCodeAddressComponent(geoInfo, ndx, 'administrative_area_level_3');
			w = $('#addressform_administrative_area_level_3'); 
			if (c)
			{
				if (c.long_name != c.short_name)
					 w.val(c.short_name + '#' + c.long_name);
				else w.val(c.long_name);											
			}
			else w.val(null);
			
			c = org.r3.GoogleMapsUtils.getGeoCodeAddressComponent(geoInfo, ndx, 'administrative_area_level_2');
			w = $('#addressform_administrative_area_level_2'); 
			if (c)
			{
				if (c.long_name != c.short_name)
					 w.val(c.short_name + '#' + c.long_name);
				else w.val(c.long_name);											
			}
			else w.val(null);
			
			c = org.r3.GoogleMapsUtils.getGeoCodeAddressComponent(geoInfo, ndx, 'administrative_area_level_1');							
			w = $('#addressform_administrative_area_level_1'); 
			if (c)
			{
				if (c.long_name != c.short_name)
					 w.val(c.short_name + '#' + c.long_name);
				else w.val(c.long_name);											
			}
			else w.val(null);
			
			c = org.r3.GoogleMapsUtils.getGeoCodeAddressComponent(geoInfo, ndx, 'country');
			w = $('#addressform_country'                    ); 
			if (c)
			{
				if (c.long_name != c.short_name)
					 w.val(c.short_name + '#' + c.long_name);
				else w.val(c.long_name);											
			}
			else w.val(null);
											
			c = org.r3.GoogleMapsUtils.getGeoCodeAddressComponent(geoInfo, ndx, 'postal_code');
			w = $('#addressform_postal_code'                ); 
			if (c)  
			   	 w.val(c.long_name);
			else w.val(null);
			
			c = org.r3.GoogleMapsUtils.getGeoCodeAddressComponent(geoInfo, ndx, 'location');
			w = $('#addressform_location'          );
			if (c)  
			{
				w.val(c.lat + '#' + c.lng);

  			    var aLatLng = new L.LatLng(c.lat, c.lng);
				this.map.setView(aLatLng, 13);				 
				if (this.marker)
				{
				     this.marker.setLatLng(aLatLng); 
				}
				else
				{
					 this.marker = L.marker(aLatLng, {icon: this.addressMarkerIcon });
					 this.marker.addTo(this.map);
				}	
			}
			else w.val(null);
			
			c = org.r3.GoogleMapsUtils.getGeoCodeAddressComponent(geoInfo, ndx, 'northeast');
			w = $('#addressform_northeast'         );
			if (c)  
				w.val(c.lat + '#' + c.lng);
			else w.val(null);
			
			c = org.r3.GoogleMapsUtils.getGeoCodeAddressComponent(geoInfo, ndx, 'southwest');
			w = $('#addressform_southwest'         );
			if (c)  
				w.val(c.lat + '#' + c.lng);
			else w.val(null);
			
			c = org.r3.GoogleMapsUtils.getGeoCodeAddressComponent(geoInfo, ndx, 'place_id');
			w = $('#addressform_place_id'          );
			if (c)  
			   	 w.val(c);
			else w.val(null);
			
			c = org.r3.GoogleMapsUtils.getGeoCodeAddressComponent(geoInfo, ndx, 'formatted_address');								
			w = $('#addressform_formatted_address' );
			if (c)  
			   	 w.val(c);
			else w.val(null);
		}
	}
			
});

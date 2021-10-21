$.r3Utils.namespace("org.r3");

org.r3.GoogleMapsUtils =
{
	init : function()
	{	
	},

	geoCodeAddress: function(
			anAddress, aStreetNumber, aZipCode, aTown, aCounty, aDistrict, aCountry, 
			onSuccess,
			onNotFound,
			onQuotaExceeded,
			onError,
			googleAPIKey)
	{
		var searchAddress = "";
		var numberOfInfos = 0;
		
		var pattern = 0;
     	if (anAddress)     pattern += 1;
     	if (aStreetNumber) pattern += 2;
     	if (aZipCode)      pattern += 4;
     	if (aTown)         pattern += 8;
     	if (aCounty)       pattern += 16;
     	if (aDistrict)     pattern += 32;
     	if (aCountry)      pattern += 64;

     	switch(pattern & (1 + 2))
     	{
     	case 1:
     		searchAddress = anAddress;
     		break;
     	case 3:
     		searchAddress = anAddress + ", " + aStreetNumber;
     		break;
     	default:
     		console.error("GoogleMapsUtils::geoCodeAddress - InvalidArgs", arguments);
     	}
     	
     	switch(pattern & (4 + 8 + 16))
     	{
     	case 8:
     		searchAddress = searchAddress + ", " + aTown;
     		break;

     	case 12:
     		searchAddress = searchAddress + ", " + aZipCode + " " + aTown;
     		break;

     	case 8 + 16:
     		searchAddress = searchAddress + ", " + aTown + " " + aCounty;
     		break;

     	case 12 + 16:
     		searchAddress = searchAddress + ", " + aZipCode + " " + aTown + " " + aCounty;
     		break;

     	default:
     		console.error("GoogleMapsUtils::geoCodeAddress - InvalidArgs", arguments);
     	}
     	
     	switch(pattern & (32))
     	{
     	case 32:
     		searchAddress = searchAddress + ", " + aDistrict;
     		break;
     	}     	
     	
     	switch(pattern & (64))
     	{
     	case 64:
     		searchAddress = searchAddress + ", " + aCountry;
     		break;
     	}     	
     			
     	var qs = encodeURI(searchAddress);
		var method = "get";
		var restUrl = "https://maps.googleapis.com/maps/api/geocode/json?address=" + qs;
		
		if (!onSuccess)
		{
			// Non invoco l'API se non so cosa farci...
			console.error("GoogleMapsUtils::geoCodeAddress - OnSuccess Not Specified For: " + searchAddress);
			return ;
		}
		
		$.ajax({
			"type" : method,
			"url" : restUrl,
			"dataType" : "json",
			"success" : function(responseData)
			{
				console.log(responseData)
				switch(responseData.status)
				{
				case 'OK':
					if (onSuccess)
						 onSuccess(responseData);
					else console.log("GoogleMapsUtils::geoCodeAddress - OK", responseData);					
					break;
				case 'ZERO_RESULTS':
					if (onNotFound)
						 onNotFound(responseData);
					else console.log("GoogleMapsUtils::geoCodeAddress - ZERO_RESULTS", responseData);					
					break;
				case 'OVER_QUERY_LIMIT':
					if (onQuotaExceeded)
						 onQuotaExceeded(responseData);
					else console.log("GoogleMapsUtils::geoCodeAddress - OVER_QUERY_LIMIT", responseData);
					break;
				case 'REQUEST_DENIED':
					if (onError)
						 onError(responseData.status, responseData);	
					else console.log("GoogleMapsUtils::geoCodeAddress - REQUEST_DENIED", responseData);
					break;
				case 'INVALID_REQUEST':
					if (onError)
						 onError(responseData.status, responseData);
					else console.log("GoogleMapsUtils::geoCodeAddress - INVALID_REQUEST", responseData);					
					break;
				case 'UNKNOWN_ERROR':
					if (onError)
  						 onError(responseData.status, responseData);					
					else console.log("GoogleMapsUtils::geoCodeAddress - UNKNOWN_ERROR", responseData);
					break;
				}
			},
			"error":  function(jqXHR, timeout, message)
			{
				if (onError)
					 onError('AJAX_ERROR', message);					
				else console.error(message);
			}
		});
	},
	
	getGeoCodeStreetAddressResultIndex: function(geoCodeJSON)
	{
		if (!geoCodeJSON || geoCodeJSON.status != 'OK')
			return null;
		
		for(var i = 0; i < geoCodeJSON.results.length; i++)
		{
			if (geoCodeJSON.results[i].types.indexOf('street_address') >= 0 || geoCodeJSON.results[i].types.indexOf('route') >= 0)
			{
				return i;
			}
		}
		
		return -1;
	},
	
	getGeoCodeAddressComponent: function(geoCodeJSON, resultIndex, componentName)
	{
		if (!geoCodeJSON || geoCodeJSON.status != 'OK')
			return null;
		
		if (!resultIndex)
			resultIndex = 0;
		
		if (geoCodeJSON.results.length <= resultIndex)
			return  null;
		
		var result = geoCodeJSON.results[resultIndex];
		switch(componentName)
		{
		case 'street_number':
		case 'route':
		case 'locality':
		case 'administrative_area_level_3':
		case 'administrative_area_level_2':
		case 'administrative_area_level_1':
		case 'country':
		case 'postal_code':
			if (result.address_components && result.address_components.length > 0)
		    {
			for(var i = 0; i < result.address_components.length; i++)
			{
				var t = result.address_components[i].types;
				if (t.indexOf(componentName) >= 0)
					return result.address_components[i];
			}			
		    }
			break;
		case 'formatted_address' : 
			return result.formatted_address;
			break;
		case 'location':
			if (result.geometry)
				return result.geometry.location;
			break;
		case 'northeast':
			if (result.geometry && result.geometry.viewport)
				return result.geometry.viewport.northeast;
			break;
		case 'southwest':
			if (result.geometry && result.geometry.viewport)
				return result.geometry.viewport.southwest;
			break;
		case 'place_id':
			return result.place_id;
			break;
			
		}
	},
	
	/*
	  "{ "error": { "errors": [ 
       { "domain": "usageLimits", 
            "reason": "dailyLimitExceededUnreg", 
            "message": "Daily Limit for Unauthenticated Use Exceeded. Continued use requires signup.", 
            "extendedHelp": "https://code.google.com/apis/console" } ], 
            "code": 403, 
            "message": "Daily Limit for Unauthenticated Use Exceeded. Continued use requires signup." } } "
	 */
	googleGeoCodeLocation: function(onSuccess, onError)
	{
		var method = "POST";
		var restUrl = "https://www.googleapis.com/geolocation/v1/geolocate?key=AIzaSyA8t_rKmjzImtLh3OKyn31hOZgra2B9r2s";
		
		$.ajax({
			"type" : method,
			"url" : restUrl,
			"data" : JSON.stringify({}),
			"dataType" : "json",
			"contentType": "application/json",
			"success" : function(responseData)
			{
				console.info("googleGeoCodeLocation");
				console.info(responseData);
				
				if (onSuccess)
		    		   onSuccess(responseData.location.lat, responseData.location.lng, responseData.accuracy);				
			},
			
			"error":  function(jqXHR, timeout, message)
			{
				console.info("googleGeoCodeLocation");
				console.error(message);
				if (onError)
					onError(2, "[POSITION_UNAVAILABLE] Geo Location NOT Available " + message);
			}		
		});
		
	},
	
	geoCodeLocation: function(onSuccess, onError)
	{
		// Non è cosi' preciso.... Mi manda al labaro...
		// return this.googleGeoCodeLocation(onSuccess, onError);
		
		//
		// Per il momento evito di utilizzare l'invocazione geoLocation in quanto andrebbe spiegata per l'aspetto dei permissions.
		// Il default sta nel org.r3.PageManager....
//		if (onSuccess)
//			onSuccess(41.890112,12.4920743,18);
		
		// Commentato per effettuare i test sul comportamento chrome in merito all'SSL.
		// return ;
		
		if ("geolocation" in navigator) 
		{
			var geoOptions = {
			      timeout: 10 * 1000
		    };
			
	        navigator.geolocation.getCurrentPosition(function(location) 
	        {
	    	   if (onSuccess)
	    		   onSuccess(location.coords.latitude, location.coords.longitude, location.coords.accuracy);
	        },
	        function(error)
	        {	    	    
	    	    var msg = "UNKNOWN";
	    	    switch(error.code)
	    	    {
	    	    case 1: 
	    	    	msg = "PERMISSION_DENIED";
	    	    	break;
	    	    case 2: 
	    	    	msg = "POSITION_UNAVAILABLE";
	    	    	break;
	    	    case 3: 
	    	    	msg = "TIMEOUT";
	    	    	break;
	    	    default: 
	    	    	msg = error.code + '';
	    	    }
	    	    
	    	    console.error(error.code, "[" + msg + "] " + error.message);
	    	    if (onError) 
					onError(error.code, "[" + msg + "] " + error.message);	    	    
	        },
	        geoOptions);	    
		} 
		else 
		{
			console.error("[POSITION_UNAVAILABLE] Geo Location NOT Available");
			if (onError) 
				onError(2, "[POSITION_UNAVAILABLE] Geo Location NOT Available");
		}
	}
					
};

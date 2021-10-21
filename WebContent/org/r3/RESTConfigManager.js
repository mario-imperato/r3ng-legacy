$.r3Utils.namespace("org.r3");

org.r3.RESTConfigManager = Class.extend(
{	  
	  
	init : function(anAppContext, aRestPrefix, aRestConfigFile)
	{
		this.appContext = anAppContext;
		this.restContext = aRestPrefix;
		this.restConfigFile = aRestConfigFile;
		this.restConfigHash = {
		};
	},
    
	networkInitialization : function(onSuccess, onError)
	{
		var configFileUrl = this.appContext + this.restConfigFile;

		$.getJSON(
				org.r3.PageManager.getRandomParameterizedURL(configFileUrl),
				$.r3Utils.hitch(this, function(jsonData)
				{
					this.restConfigHash = jsonData;
					onSuccess();
				}))
				.error(function(jqXHR, timeout, message)
		        {
			        console.error("That's an error...");
			        onError(jqXHR, timeout, message);
        			// dunno.. Se prendo un errore qui non configuro nulla.. Bisogna far
		         	// venire fuori un messaggio..
		        });
	},
    

	getRESTUrl : function(aUrlName, params)
	{
		var restUrl = this.restConfigHash[aUrlName];
		if (restUrl == null)
		{
			console.error("RestConfigManager::getRESTUrl", aUrlName);
			return null;
		}

		// La configurazione è valida per l'ambiente reale. I servizi mockup vengono acceduti con questo workaround.
		if (this._isMockupRESTUrl(restUrl))
		{
	       restUrl = this._getMockupRESTUrl(restUrl);		
		}
		else if (this._isAbspathRESTUrl(restUrl))
		{
			restUrl = this._getAbspathRESTUrl(restUrl);
		}
		else
		{
		   restUrl = this._getStdRESTUrl(restUrl);	
		}
		
		if (params)
		{
			restUrl = $.r3Utils.stringFormat(restUrl, params);
		}

		return restUrl;
	},
	
	_getMockupRESTUrl: function(aRestUrl)
	{
		var restUrl = this.appContext + "/rest_staticmockup" + aRestUrl.substring('mockup:'.length);
		return restUrl;
	},
	
	_isMockupRESTUrl: function(aRestUrl)
	{
		return (aRestUrl.indexOf('mockup:') >= 0);
	},
	
	_isAbspathRESTUrl: function(aRestUrl)
	{
		return (aRestUrl.indexOf('abspath:') >= 0);
	},
	
	_getAbspathRESTUrl: function(aRestUrl)
	{
		var restUrl = org.r3.Constants.restServicesContext + aRestUrl.substring('abspath:'.length);
		return restUrl;
	},
	
	_getStdRESTUrl: function(aRestUrl)
	{
		var restUrl = this.restContext + aRestUrl;
		return restUrl;
	}
		
});


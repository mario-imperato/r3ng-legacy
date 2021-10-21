
(function($) {

 $.r3Utils = 
 {
    namespace: function(obj, global, callback) 
    {
        if (!_(obj).isString()) return [];
        var namespace = _(obj.split(".")).reduce(function(namespace, fragment) {
          if (namespace[fragment] === undefined) namespace[fragment] = {}; 
          return namespace[fragment];
        }, global || window);
        if (callback) return callback(namespace);
        return namespace;
    },
    
    ie: function()
    {
    	// My IE11
    	// "Navigator is:  Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; HPNTDF; .NET4.0C; InfoPath.3; .NET4.0E; rv:11.0) like Gecko";    	    	
    	return r3_IE || navigator.userAgent.indexOf('Trident') >= 0;    	
    },
    
    getCookie: function(c_name)
    {
        var i,x,y,ARRcookies=document.cookie.split(";");

        for (i=0;i<ARRcookies.length;i++)
        {
            x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
            y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
            x=x.replace(/^\s+|\s+$/g,"");
            if (x==c_name)
            {
                return unescape(y);
            }
         }
        
        return null;
    },
    
    logElapsedTime: function(start)
    {
    	if (start)
    	{
        	var end = new Date().getTime();
        	var time = end - start;
        	console.error('logElapsedTime::Execution time: ' + time);	    		
    	}

    	start = new Date().getTime();    		
    	return start;
    },
    
    hitch: function(o, f)
    {
    	if (!o || !f || (typeof f == "undefined"))
    	   console.error("r3_utils::hitch is: ", o, f);

	    return function() { return f.apply(o, arguments); };
    },
    
    stringFormat: function(str /* , ... */)    
    {
    	if (!str || str == "undefined") return str;
	   	    
	   	switch(arguments.length)
	   	{
	   		case 1: 
	   		  break;
	   		case 2:
	   		  str = this._stringFormatFromArrayOfParameters(str, arguments[1]);
	   		  break;
	   		case 3:
	   		  if (_.isNumber(arguments[1]))
	   		  {
	   		      str = this._stringFormatFromIndexedParameter(str, arguments[1], arguments[2]);
	   		  }
	   		  else if (_.isString(arguments[1]))	   		  
	   		      str = this._stringFormatFromNamedParameter(str, arguments[1], arguments[2]);
	   		 
	   		  break;
	    }

      return str;	    	                                                
    },

    stringContains: function(s1, s2)
    {
        if (s1 != null && s2 != null)
        {	
        	if (s1.indexOf(s2) >= 0)
        	    return true;
        }
        
        return false;
    },

    stringDistance: function(s1, s2)
    {
        if (s1 != null && s2 != null)
        {	
        	if (s1 == s2)
        		return 0;
        
        	if (s1.indexOf(s2) >= 0)
        	    return 1;
        
            if (s2.indexOf(s1) >= 0)
        	    return 1;        
        }
        
        return -1;
    },
    
    _stringFormatFromArrayOfParameters: function(str, params)
    {
	    if (params != null && params.constructor.toString().indexOf("Array") > 0) 
	    {
	    	 // console.log("BOF Utils.js::_stringFormatFromArrayOfParameters", str);
		     for (var i=0; i < params.length; i++) 
		     {
			       str = str.replace("{" + i + "}" ,params[i]);
		     }
		     
		     var j = params.length;
		     var k = 0;
		     
		     var placeHolder = "{" + j + "}";
		     var shiftedPlaceHolder = "{" + k + "}";
		     while ( j < 9 )
		     {
		    	  if (str.indexOf(placeHolder) >= 0)
		    	  {
		    		  str = str.replace(placeHolder ,shiftedPlaceHolder);  
		    	  }
		    	  
		    	  j++; k++;		    	  
			      placeHolder = "{" + j + "}";
				  shiftedPlaceHolder = "{" + k + "}";		    	  
		     }
		     
		     // console.log("EOF Utils.js::_stringFormatFromArrayOfParameters", str);
	    }	
	      
	    return str;
    },

    _stringFormatFromIndexedParameter: function(str, paramIndex, paramValue)
    {
    	if (paramIndex >= 0)
    	{
    		 str = str.replace("{" + paramIndex + "}" ,paramValue);
    	}
    		      
	    return str;
    },

    _stringFormatFromNamedParameter: function(str, paramName, paramValue)
    {
    		 str = str.replace("{" + paramName + "}" ,paramValue);    		      
	       return str;
    },
    
    addParameterToUrl: function(aUrl, fieldName, fieldValue)
    {
  	     var retUrl = aUrl;
  	     if (aUrl.indexOf('?') >= 0)
  	          retUrl += "&";
  	     else retUrl += "?"; 
  	 
  	     return retUrl + fieldName + '=' + fieldValue;  	
    },
    
    addQueryStringToUrl: function(aUrl, aQueryString)
    {
  	     var retUrl = aUrl;
  	     if (aUrl.indexOf('?') >= 0)
  	          retUrl += "&";
  	     else retUrl += "?"; 
  	 
  	     return retUrl + aQueryString;  	
    },
    
    getQueryStringParamFromPageUrl: function(paramName)
    {
    	var regExpResult=(new RegExp('[?&]'+encodeURIComponent(paramName)+'=([^&]*)')).exec(location.search);    	
    	if(regExpResult)
    	   return decodeURIComponent(regExpResult[1]);
    },
    
    stripParameterFromUrl: function(aUrl, aParamName)
    {  
    	 if (!aUrl)
    	    return aUrl;
    	    
    	 var paramPosition = aUrl.indexOf(aParamName + "=");
    	 if (paramPosition < 0)
    	    return aUrl;
     
       var arrayOfItems = aUrl.split(/&|\?/);
       console.log("ArrayOfItems: ", arrayOfItems);
       
       var retUrl = null;
       if (arrayOfItems && arrayOfItems.length > 0)
       {
       retUrl = arrayOfItems[0];
       var numberOfParams = 0;
       for(var i = 1; i < arrayOfItems.length; i++)
       {     	   
       	   if (arrayOfItems[i].indexOf(aParamName + "=") == 0)
       	      continue;
       	      
       	   if (numberOfParams == 0)
       	         retUrl += '?';
       	   else  retUrl += '&'; 
       	   
       	   retUrl += arrayOfItems[i];
       	   numberOfParams++;
       }
       }
       else
       {
       	   console.error("it.unep.PageManager::_stripParameterToUrl - Failed on ", aUrl, aParamName);
       }		
     
       return retUrl;
    },
    
    adjustDateFormat: function(aStringDate, aInFormat, anOutFormat)
    {
		 var theDate = this.parseDate(aStringDate, aInFormat);
		 if (theDate)
	     {
			 var d = (theDate.getDate() < 10)        ?  '0' + theDate.getDate() : theDate.getDate();
			 var m = ((theDate.getMonth() + 1) < 10) ? ('0' + (theDate.getMonth() + 1)): (theDate.getMonth() + 1);
			 
			 return d + '/' + m + '/' + theDate.getFullYear();
		 }
		 
		 return null;
    },
    
    parseDate: function(aStringDate, aFormat)
    {            
    	  if (!aFormat)
    	     aFormat = "dd/MM/yyyy";
    	         	  
      	return Date.parseExact(aStringDate, aFormat);
    },
    
    getToday: function()
    {
        var aDate = Date.today();
        var m = ('0' + (aDate.getMonth() + 1)).slice(-2);
        var d = ('0' + aDate.getDate()).slice(-2);
        
        return d + '/' + m + '/' + aDate.getFullYear();
    },

    getTodayAsyyyyMMdd: function()
    {
        var aDate = Date.today();
        var m = ('0' + (aDate.getMonth() + 1)).slice(-2);
        var d = ('0' + aDate.getDate()).slice(-2);

        return '' + aDate.getFullYear() + m + d;
    },
    
    getDateAsR3TimestampStringFormat: function(aDate, useShortFormat)
    {
        var m  = ('0' + (aDate.getMonth() + 1)).slice(-2);
        var d  = ('0' + aDate.getDate()).slice(-2);
        var hh = ('0' + aDate.getHours()).slice(-2);
        var mm = ('0' + aDate.getMinutes()).slice(-2);
        var ss = ('0' + aDate.getSeconds()).slice(-2);
        
        if (useShortFormat)
           return '' + d + '/' + m + '/' + aDate.getFullYear();
        
        return '' + d + '/' + m + '/' + aDate.getFullYear() + ' ' + hh + ':' + mm + ':' + ss;
    },
    
    isAfter: function(aFirstDate, aSecondDate)
    {            
      	return aFirstDate.compareTo(aSecondDate) > 0;
    },
    
    isBefore: function(aFirstDate, aSecondDate)
    {            
      	return aFirstDate.compareTo(aSecondDate) < 0;
    },
    
    layoutClassicErrorPlacement: function(error, element) 
    {
    	var parentCell = element.parents("div.validation-error-anchor:first");
    	if (parentCell)
    		  parentCell = parentCell.parents("div:first");
    	else  parentCell = element.parents("div:first");            	 
		    
        error[parentCell.length ? 'appendTo' : 'insertAfter'](parentCell.length ? parentCell : element);
	},
	
	onEnter: function(elementId, functionContext, processFuntion, unbindFlag)
	{
		var el = $(elementId);
		if (unbindFlag)
		    el.unbind();
		
		el.bind("keypress", function(event)
		{
			if (event.keyCode == 13)
			{
				event.preventDefault();
				processFuntion.apply(functionContext, arguments);
				return false;
			}
		});
	},
	
	padString: function(value, padCharacter, maxLength)
	{
		var pattern = "";
		for(var i = 0; i < maxLength; i++)
			pattern += padCharacter;
		
		var newValue = (pattern + value).slice(-maxLength);		
		return newValue;
	},
	
	formatDataDataBeanField : function(aSystemDateDataBeanField)
	{
		if (aSystemDateDataBeanField)
		{
			return $.r3Utils.adjustDateFormat(aSystemDateDataBeanField, 'yyyy-MM-dd', 'dd/MM/yyyy');
		}

		return null;
	},

	formatDataDataBeanFieldAsYearMonth: function(aSystemDateDataBeanField)
	{
		if (aSystemDateDataBeanField)
		{
			var d = $.r3Utils.adjustDateFormat(aSystemDateDataBeanField, 'yyyy-MM-dd', 'dd/MM/yyyy');
			return d.slice(3);
		}

		return null;
	},
	
	formatLUTDataBeanField : function(lutName, aCodedDataBeanField)
	{
		if (aCodedDataBeanField)
		{
			var descr = org.r3.PageManager.getLUTItemDescription(lutName, aCodedDataBeanField);
			return descr;
		}
		
		return null;
	},
	
	formatTimestampDataBeanField : function(aSystemTimestampDataBeanField, useShortFormat)
	{
		if (aSystemTimestampDataBeanField)
		{
			var aDate = new Date(aSystemTimestampDataBeanField);
			return this.getDateAsR3TimestampStringFormat(aDate, useShortFormat); // aDate.toLocaleString();
		}
		   
		return  null;
	},
	
	formatTimestampDataBeanFieldAsTime: function(aSystemTimestampDataBeanField)
	{
		if (aSystemTimestampDataBeanField)
		{
			var aDate = new Date(aSystemTimestampDataBeanField);
			var s = this.getDateAsR3TimestampStringFormat(aDate, false); 
			return s.substring(11);
		}
		   
		return  null;		
	},
	
	formatSecondsToElapsedTime: function(secs)
	{
	    if (secs == 0)
	    	return "00:00:00";
	    
	    if (secs)
	    {
	    	var res = '';
	    	
	    	var h = Math.floor(secs / 3600);
	    	if (h < 10)
	    	   res = '0' + h;
	    	else 
	    	   res = '' + h;
	    	
	    	secs = secs % 3600;
	    	var m = Math.floor(secs / 60);
	    	if (m < 10)
	    	   res += (':0' + m);
	    	else 
	    	   res += (':' + m);
	    	
	    	secs = secs % 60;
	    	if (secs < 10)
	    	   res += (':0' + secs);
	    	else 
	    	   res += (':' + secs);
	    	
	    	return res;
	    }
	    
	    return null;
	},
	
	formatTimeDifferenceFromNow: function (aDateValue) 
	{
	    var msPerMinute = 60 * 1000;
	    var msPerHour = msPerMinute * 60;
	    var msPerDay = msPerHour * 24;
	    var msPerMonth = msPerDay * 30;
	    var msPerYear = msPerDay * 365;

	    var elapsed = (new Date()) - aDateValue;

	    var c = 0;
	    if (elapsed < msPerMinute) 
	    {
	    	c = Math.round(elapsed/1000);
	    	if (c == 0)
	    		return  org.r3.message.no_second_ago;  
	    	else if (c == 1)	    		
	    		return  org.r3.message.a_second_ago;  
	    	
	        return  c + ' ' + org.r3.message.seconds_ago;   
	    } 
	    else if (elapsed < msPerHour) 
	    {
	    	c = Math.round(elapsed/msPerMinute);
	    	
	    	if (c == 1)	    		
		    		return  org.r3.message.a_minute_ago;  
	    	 
	        return c + ' ' + org.r3.message.minutes_ago;   
	    } 
	    else if (elapsed < msPerDay ) 
	    {
	    	c = Math.round(elapsed/msPerHour );
	    	
	    	if (c == 1)	    		
	    		return  org.r3.message.an_hour_ago;  
	    	
	        return c + ' ' + org.r3.message.hours_ago;   
	    } 
	    else if (elapsed < msPerMonth) 
	    {
	    	c = Math.round(elapsed/msPerDay);
	    	
	    	if (c == 1)	    		
	    		return  org.r3.message.a_day_ago;  
	    	
	        return org.r3.message.approximately + ' ' + c + ' ' + org.r3.message.days_ago;   
	    } 
	    else if (elapsed < msPerYear) 
	    {
	    	c = Math.round(elapsed/msPerMonth);
	    	
	    	if (c == 1)	    		
	    		return  org.r3.message.a_month_ago; 
	    	
	        return org.r3.message.approximately + ' ' + c + ' ' + org.r3.message.months_ago;   
	    } 
	    else 
	    {
	    	c = Math.round(elapsed/msPerYear );
	    	
	    	if (c == 1)	    		
	    		return  org.r3.message.an_year_ago;
	    	
	        return org.r3.message.approximately + ' ' + c + ' ' + org.r3.message.years_ago;   
	    }
	},
	
	formatDateAsBadge: function(aTimeValue)
	{
	     var d = (aTimeValue) ? new Date(aTimeValue) : new Date();
	     var m = org.r3.message.get3LettersMonthNames(d.getMonth());
	     return '<i>' + ('0' + d.getDate()).slice(-2) + '</i> <span class="text-uppercase">' + m + '</span>';	     	
	},
	
	formatDMSUrl4ClientAccess: function(aDMSUrl, saveAsModifier)
	{
		if (aDMSUrl)
		{
			
		// Gestione MongoUrls...
		if (aDMSUrl.indexOf("mfs:///") >= 0)
		{
		     aDMSUrl = aDMSUrl.slice("mfs://".length);	
 			 clientUrl = org.r3.Constants.getMongoDMSServiceContext() + aDMSUrl;
			 if (saveAsModifier)
			    clientUrl = org.r3.Constants.getMongoDMSServiceContext() + saveAsModifier + "/" + aDMSUrl;			
			 
			 return clientUrl;
		}
		
		if (aDMSUrl.indexOf("DMS_FILE:///") >= 0)
		{
		    aDMSUrl = aDMSUrl.slice("DMS_FILE:///".length);	
		
			var clientUrl = null;
			if (aDMSUrl.indexOf("PUB") >= 0)
			{
				clientUrl = org.r3.Constants.getDMSPublicMountPoint() + aDMSUrl.substring(3);
			}
			else
			{
				clientUrl = org.r3.Constants.getDMSServicesContext() + "/document/" + aDMSUrl;
				if (saveAsModifier)
					clientUrl = org.r3.Constants.getDMSServicesContext() + "/document" + saveAsModifier + "/" + aDMSUrl;				
			}
			
			return clientUrl;	    			
		}
		}
		
		return aDMSUrl;
	},
	
	formatMoneyDataBeanField: function(aMoneyValue)
	{
		if (aMoneyValue)
		{
	        return aMoneyValue;		
		}
		
		return "0.00&euro;";
	},

	formatBooleanAsCheckboxIcon: function(aBooleanValue, padding)
	{
		var checkName = "/resources/img/icons/checkbox_off.png";
		if (aBooleanValue)
			checkName = "/resources/img/icons/checkbox_on.png";
		
		if (!padding)
			padding = '0';
		
		var imageRef = "<img style='padding: " + padding + "px' src=\"" + org.r3.Constants.applicationContext + checkName + "\" />";
		return imageRef;
	},

	formatSemaphore: function(aSemaphoreColor)
    {
		//  top3 pull-left
		var s = '<i class="fa fa-circle text-' + aSemaphoreColor + '" style="margin: 5px 5px 0 0"></i>';
		return s;
	},
	
	deprecatedFormatSemaphore: function(aSemaphoreValue)
	{
		var semaphoreName = "/resources/img/icons/unknown_semaphore.png";
		switch(aSemaphoreValue)
		{
		case 'ajaxload': 
			semaphoreName = "/resources/img/icons/datatable_ajaxload_dot.gif";
            break;            
		
		case 'red': 
			semaphoreName = "/resources/img/icons/datatable_red_dot.png";
            break;            
		case 'green': 
			semaphoreName = "/resources/img/icons/datatable_green_dot.png";
            break;
		case 'orange': 
			semaphoreName = "/resources/img/icons/datatable_orange_dot.png";
            break;
		case 'yellow': 
			semaphoreName = "/resources/img/icons/datatable_yellow_dot.png";
            break;
		case 'gray': 
			semaphoreName = "/resources/img/icons/datatable_gray_dot.png";
            break;
		case 'redo': 
			semaphoreName = "/resources/img/icons/redo-icon.png";
            break;

		default:  
        	semaphoreName = "/resources/img/icons/datatable_gray_dot.png";
		}
				
		var imageRef = "<img src=\"" + org.r3.Constants.applicationContext + semaphoreName + "\" />";
		return imageRef;
	},

	format4HtmlConsumption: function (s)
	{
	    if (s)
	    {
	        return s;	
	    }	
	    
	    return '';
	},
	
	getURLPageQueryParam: function(aParamName)
	{
	   var paramValue = null;
	   var qs = this.getURLQueryString(aParamName);
	   if (!qs)
		   return paramValue;
	   
	   var ndxStart = qs.indexOf(aParamName + "=");
	   if (ndxStart >= 0)
	   {
		   var ndxEnd = qs.indexOf("&", ndxStart);
		   if (ndxEnd >= 0)
			   paramValue = qs.substring(ndxStart + 1 + aParamName.length, ndxEnd);
		   else 
			   paramValue = qs.substring(ndxStart + 1 + aParamName.length); 	       
	   }
	   
	   return paramValue;
	},
	
	getURLQueryString: function()
	{
	   var documentUrl = document.URL;
	   if (!documentUrl)
	      documentUrl = window.location.href;
	 
	   var ndx = documentUrl.indexOf('?');
	   if (ndx >= 0)
	   {
	      return documentUrl.substring(ndx + 1);
	   }
	                
	   return null;
	},
	
	// Funczioni di supporto per i bottoni hoverin e out.
	jquery_ui_hoverIn: function(e)
	{
		var element = $(e.currentTarget);
		element.addClass("ui-state-hover");
	},
	
	jquery_ui_hoverOut: function(e)
	{
		var element = $(e.currentTarget);
		element.removeClass("ui-state-hover");		
	},
	
    isFieldEmpty: function(jQueryObject)
    {
    	var s = jQueryObject.val();
    	var isEmpty = !jQueryObject || !s || s.length == 0 || s.trim().length == 0;
    	return isEmpty;
    },
    
    getArrayAsJSONObject: function(anArray)
    {
        var res = {};

        $.map(anArray, function(n, i){
        	res[n['name']] = n['value'];
        });

        return res;
    }
		
 };

 $.codecUtils = 
 {
		// Funzioni di convenienza per quanto riguarda la gestione dei codici
		// raccomandata		
		computeCheckDigit : function(value)
		{
			if (!value || value.length < 11)
				return -1;

			var sumOdd = 0;
			var sumEven = 0;
			for ( var i = 0; i < 11; i++)
			{
				if (i % 2)
				{
					sumOdd += parseInt(value.charAt(i));
				}
				else
				{
					sumEven += parseInt(value.charAt(i));
				}
			}

			var totale = 0;
			var sumTotalAsString = "" + (sumEven + sumOdd * 11);
			for ( var i = 0; i < sumTotalAsString.length; i++)
			{
				totale += parseInt(sumTotalAsString.charAt(i));
			}

			var digit = totale % 10;
			return digit;
		},
		
		checkCheckDigit: function(aCodiceRaccomandata)
		{
			var digit = this.computeCheckDigit(aCodiceRaccomandata);
			if (digit != -1 && aCodiceRaccomandata.length == 12)
			{
				return digit == parseInt(aCodiceRaccomandata.charAt(11));				
			}
			
			return false;
		},
		
	    shiftCodiceRaccomandata: function(aCodiceRaccomandata, shiftValue)
	    {
	    	// console.info(aCodiceRaccomandata.length);
	    	
	    	if (!aCodiceRaccomandata || aCodiceRaccomandata.length != 12)
	    	{
	    		return null;
	    	}

	    	var s = "9" + aCodiceRaccomandata.substring(0, 11);
	    	var l = parseInt(s) + shiftValue;
	    	
	    	var nuovoCodice = '' + l; 
	    	if (nuovoCodice.length > 11)
	    		nuovoCodice = nuovoCodice.substring(nuovoCodice.length - 11);
	    	
	    	var checkDigit = this.computeCheckDigit(nuovoCodice);
	    	return nuovoCodice + checkDigit;
	    },
	    
	    getCodiceARCadFromCodiceRaccomandata: function(aCodiceRaccomandata)
	    {    	
	    	var nuovoCodice = this.shiftCodiceRaccomandata(aCodiceRaccomandata, 10000000);
	    	return nuovoCodice;
	    }
		 
 };
 
})(jQuery);

(function($) 
{
  $.fn.ifNot = function(create) 
  {
    if (this.length === 0) 
    {
      this.end();
      return this.pushStack(create.call(this), "ifNot", "");
    }
    return this;
  };
  
})(jQuery);

// Definizione di una funzione finta console per IE
if (window.console == null)
{
	  window.console = 
	  {
  	  log: function(aMessage)
 	    {
		  },
		  
		  info: function(aMessage)
		  {
		  },
		  
		  error: function(aMessage)
		  {
		  }		    	  		  	  
		};
}

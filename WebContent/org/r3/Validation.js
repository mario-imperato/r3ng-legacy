(function($)
{
	$.validator.setDefaults({
	    highlight: function(element) {
	        $(element).closest('.form-group').addClass('has-error');
	    },
	    unhighlight: function(element) {
	        $(element).closest('.form-group').removeClass('has-error');
	    },
	    errorElement: 'span',
	    errorClass: 'help-block',
	    errorPlacement: function(error, element) {
	        if(element.parent('.input-group').length) {
	            error.insertAfter(element.parent());
	        } else {
	            error.insertAfter(element);
	        }
	    }
	});
	
	/* Normalise the comparison parameters to an array.
	   @param  params  (array or object or string) the original parameters
	   @return  (array) the normalised parameters */
	function validator_normaliseParams(params) 
	{
		if (typeof params == 'string') {
			params = params.split(' ');
		}
		else if (!$.isArray(params)) {
			var opts = [];
			for (var name in params) {
				opts[0] = name;
				opts[1] = params[name];
			}
			params = opts;
		}
		return params;
	}
	
	// $.metadata.setType("attr", "validate");
	$.validator.addMethod("failRule", function(value, element, params)
	{						
		return false;
	}, $.validator.format("Fallira' sempre!"));

	$.validator.addMethod('timevalue', function(value, element)
	{
		return this.optional(element) || value.match(/([0-9]{2}):([0-9]{2})/);
	});

	$.validator.addMethod('timevalue_withsecs', function(value, element)
	{
		return value.match(/([0-9]{2}):([0-9]{2}):([0-9]{2})/);
	});

	// Date and datepicker validation methods.
	
	/* Determine the comparison date.
	   @param  element  (element) the current datepicker element
	   @param  source   (string or Date or jQuery or element) the source of the other date
	   @param  noOther  (boolean) true to not get the date from another field
	   @return  (Moment) the moment for comparison */
	function validator_dp_extractOtherDateAsMoment(element, source, noOther) 
	{
		if (source.constructor == Date) {
			return moment(source);
		}
		
		if (typeof source == 'string')
		{
			if (source == 'today')
				return moment();
			else
			{
			    var m = moment(source,  org.r3.message.default_momentDateFormat);
			    if (m.isValid())
			    	return m;
			    
			    var s = $(source);
			    if (s.length && s.length == 1)
			    	m = moment(s.val(),  org.r3.message.default_momentDateFormat);
			    
			    if (m.isValid())
			    	return m;			    
			}
		}

		return null;
	}
	
	$.validator.addMethod('dpDate', function(value, element, params)
	{
		var s = moment(value, org.r3.message.default_momentDateFormat);
		
		return this.optional(element) || s.isValid();
	}, $.validator.format(org.r3.message.field_dpDate));

	var dpDate_compareOperators = {equal: 'eq', same: 'eq', notEqual: 'ne', notSame: 'ne',
			lessThan: 'lt', before: 'lt', greaterThan: 'gt', after: 'gt',
			notLessThan: 'ge', notBefore: 'ge', notGreaterThan: 'le', notAfter: 'le'};
	
	$.validator.addMethod('dpCompareDate', function(value, element, params) 
	{
		if (this.optional(element)) {
			return true;
		}
	
		params = validator_normaliseParams(params);
		var thisDate = moment(value, org.r3.message.default_momentDateFormat);
		var thatDate = validator_dp_extractOtherDateAsMoment(element, params[1]);
		if (!thisDate || !thatDate) {
			return true;
		}
		
		lastElement = element;
		var result = true;
		switch (dpDate_compareOperators[params[0]] || params[0]) {
			case 'eq': result = (thisDate.diff(thatDate) == 0); break;
			case 'ne': result = (thisDate.diff(thatDate) != 0); break;
			case 'lt': result = (thisDate.diff(thatDate) < 0); break;
			case 'gt': result = (thisDate.diff(thatDate) > 0); break;
			case 'le': result = (thisDate.diff(thatDate) <= 0); break;
			case 'ge': result = (thisDate.diff(thatDate) >= 0); break;
			default:   result = true;
		}
		return result;
	}, $.validator.format(org.r3.message.field_dpDateCompare));

//	$.validator.addMethod("dpCompareDateOnChange", function(value, element, params)
//	{	
//		var inst = $.datepicker._getInst(element);
//		var thisDate = $(element).datepicker('getDate');
//		var thatDate = $('#' + $(element).prop('id') + '_orig').val();
//		
//		// var thatDate = $.datepicker.parseDate($.datepicker._get(inst, 'dateFormat'),
//		// source, $.datepicker._getFormatConfig(inst));
//						
//		console.log("Element Id", thisDate, thatDate);
//				
//		return $.validator.methods.dpCompareDate.call(this, value, element, params);				
//	}, $.validator.format("Il codice indicato non rappresenta un codice valido!"));
//
//	$.validator.addMethod("dpArrayCompareDate", function(value, element, params)
//	{	
//		if (!params || !$.isArray(params))
//			return ;
//		
//		var clonedParams = params.slice(0);
//		var numberOfComparisons = Math.floor((clonedParams.length - 1) / 2) + 1;
//		console.info("NumberOfComparisons: ", numberOfComparisons);
//		for(var i = 0; i < numberOfComparisons; i++)
//		{
//			console.info("ClonedParams: ", i, clonedParams);
//			
//			if (typeof clonedParams[1] == 'string' && clonedParams[1] != 'today')
//			{
//			     if (clonedParams[1].indexOf('#') == 0)
//			     {
//			    	 var theDateField = $(clonedParams[1])
//			    	 if (!theDateField.datepicker('getDate'))
//			    	 {
//			    	      theDate = theDateField.attr('value');
//			    	      if (theDate)
//			    	    	  clonedParams[1] = theDate;
//			    	 }
//			     }
//			}
//				
//			if (!$.validator.methods.dpCompareDate.call(this, value, element, clonedParams))
//				return false;
//			
//			clonedParams.shift();
//			clonedParams.shift();
//		}
//		
//		return true;						
//	}, $.validator.format("Il codice indicato non rappresenta un codice valido!"));
//
//	$.validator.addMethod("dpCompareDateMonthsMaxRange", function(value, element, params)
//	{		
//		if (this.optional(element)) {
//			return true;
//		}
//
//		var thisDate = $(element).datepicker('getDate');
//		var thatDate = $(params[1]).datepicker('getDate');
//		
//		if (!thatDate)
//		{
//			console.info("The start date is unset: ");
//			return true;	
//		}		
//		
//		var shiftedThatDate = new Date(thatDate.getTime());
//		shiftedThatDate.add({ months: 3 });
//		console.info("The StartInterval Element Date: ",     thatDate.toString());
//        console.info("The Element Date: ",   thisDate.toString());        
//        console.info("The Interval Element Date: ", shiftedThatDate.toString());
//        
////				var d1 = Date.today()
////			    .set({ day: 15, hour: 16, minute: 30 })
////			    .add({ days: 90 })
//	    		
//		var newParams = [ 'notAfter', shiftedThatDate ];
//		return $.validator.methods.dpCompareDate.call(this, value, element, newParams);
//
//	}, $.validator.format("The interval is too big for processing!"));

			
	$.validator.addMethod('gdatetime_range', function(value, element, params)
	{
		var startDate = $(params[0]).gdatetime('getDateTime');
		var endDate = $(params[1]).gdatetime('getDateTime');
				
		// Un modo per fare uno XOR in JS.
		if (!startDate != !endDate)
		{
			return false;	
		}
		
		var s = moment(startDate, "DD/MM/YYYY HH:mm");
		var e = moment(endDate, "DD/MM/YYYY HH:mm");
		var d = e.diff(s, 'minutes');
		
		return d >= 0;
	}, $.validator.format("L'intervallo Temporale non e' corretto!"));

	
	$.validator.addMethod('identifier', function(value, element, params)
	{
		return this.optional(element) || value.match(/^[a-zA-Z][a-zA-Z0-9]*$/);
	});

	$.validator.addMethod('letters', function(value)
	{
		return value.match(/^[- a-zA-Z]+$/);
	});

	$.validator.addMethod('noSpecialCharacters', function(value)
	{
		return value.match(/^[- a-zA-Z0-9]+$/);
	});

	$.validator.addMethod('lettersNumbersPunctuation', function(value)
	{
		return value.match(/^[- a-zA-Z0-9\\.]+$/);
	});

	$.validator.addMethod('sailnumber', function(value)
	{
		return value.match(/^[a-zA-Z]{3}\d+$/);
	});

	$.validator.addMethod("emptyOrEqualTo", function(value, element, params)
	{		
		var otherItemValue = $(params).val();		
		return this.optional(element) || !otherItemValue || value == otherItemValue;
	}, $.validator.format("Il valore indicato non e' corretto!"));
	
	$.validator.addMethod("codeLowEnd", function(value, element, params)
	{
		var pattern = "";
		for(var i = 0; i < params[1]; i++)
			pattern += params[2];
		
		var newValue = (pattern + value).slice(-params[1]);
		var otherItemValue = (pattern + $(params[0]).val()).slice(-params[1]);
		
		console.info("Validator:codeInterval: " + newValue + "/" + otherItemValue + "/" + params[0] + "/" + params[1]);
		return this.optional(element) || !$(params[0]).val() || newValue < otherItemValue;
	}, $.validator.format("Please enter a valid code for the low end of the interval!"));

	$.validator.addMethod("lessOrEqualThan", function(value, element, params)
	{		
		var theIntValue = parseInt(value);
		var otherFieldValue = ($.isArray(params)) ? $(params[0]).val() : $(params).val();
		var otherItemValue = parseInt(otherFieldValue);
		
		return this.optional(element) || !otherFieldValue || theIntValue <= otherItemValue;
	}, $.validator.format("Il valore indicato non rappresenta un intervallo valido!"));

	$.validator.addMethod("greaterOrEqualThan", function(value, element, params)
	{		
		var theIntValue = parseInt(value);
		var otherFieldValue = ($.isArray(params)) ? $(params[0]).val() : $(params).val();
		var otherItemValue = parseInt(otherFieldValue);
		
		return this.optional(element) || !otherFieldValue || theIntValue >= otherItemValue;
	}, $.validator.format("Il valore indicato non rappresenta un intervallo valido!"));

	$.validator.addMethod("greaterThan", function(value, element, params)
	{		
		var theIntValue = parseInt(value);
		var otherFieldValue = ($.isArray(params)) ? $(params[0]).val() : $(params).val();
		var otherItemValue = parseInt(otherFieldValue);
		
		return this.optional(element) || !otherFieldValue || theIntValue > otherItemValue;
	}, $.validator.format("Il valore indicato non rappresenta un intervallo valido!"));

	$.validator.addMethod("isCAD4", function(value, element, params)
	{				
		var otherItem = $(params[0]);
		var otherItemValue = otherItem.val();
		var codiceCAD = $.codecUtils.getCodiceARCadFromCodiceRaccomandata(otherItemValue);
		
		return this.optional(element) || !otherItem.val() || value == codiceCAD;
	}, $.validator.format("Il valore indicato non rappresenta un codice CAD valido!"));

	$.validator.addMethod("isCAN4", function(value, element, params)
	{				
		var otherItem = $(params[0]);
		var otherItemValue = otherItem.val();
		var codiceCAN = $.codecUtils.getCodiceARCadFromCodiceRaccomandata(otherItemValue);
		
		return this.optional(element) || !otherItem.val() || value == codiceCAN;
	}, $.validator.format("Il valore indicato non rappresenta un codice CAN valido!"));

	$.validator.addMethod("formatPad", function(value, element, params)
	{
		var pattern = "";
		for(var i = 0; i < params[0]; i++)
			pattern += params[1];
		
		var newValue = (pattern + value).slice(-params[0]);
		console.info("Validator:codeInterval:", element); 
		$(element).val(newValue);
		
		return true;
	}, $.validator.format("Please the padding has not properly specified!"));

	$.validator.addMethod("texttransform", function(value, element, params)
	{
		var validated = false;		
						
        if (params && _.isString(params))
        {
        	var newValue = value;
            switch(params)
            {
            case 'uppercase':
            	newValue = value.toUpperCase();
            	validated = true;
            	break;
            case 'lowercase':
            	newValue = value.toLowerCase();
            	validated = true;
            	break;            
            }
            
            $(element).val(newValue);
        }
        
		return validated;
	}, $.validator.format("The Casing option has not been properly specified"));

	$.validator.addMethod("invalidCSSClass", function(value, element, params)
	{
		var validated = false;		
						
        if (params && _.isString(params))
        {
        	// console.log("Validator.invalidCSSClass", $(element).hasClass(params));
        	if (!$(element).hasClass(params))
        		validated = true;        	
        }
        
		return validated;
	}, $.validator.format("The Field has a style invalid"));

	// $('input[name$="_codiceraccomandata"][type="text"][name!="' + aNotificaId + '_codiceraccomandata' + '"]');
	$.validator.addMethod("noDuplicates", function(value, element, params)
	{
		var currentValue = $(element).val();
		if (currentValue && currentValue.length > 0)
		{
		var listOfCodici = $(params[0]); 		
        for(var i = 0; i < listOfCodici.length; i++)
        {
            var item = $(listOfCodici[i]);
            if (currentValue == item.val())
            	return false;            
        }
		}
		
		return true;
	}, $.validator.format("Sono presenti elementi duplicati nella lista!"));

	$.validator.addMethod("codiceraccomandata", function(value, element, params)
	{		
		if (value && $.trim(value).length > 0)
		   return $.codecUtils.checkCheckDigit(value);
		
		return true;
		
	}, $.validator.format("Il codice indicato non rappresenta un codice valido!"));


})(jQuery);

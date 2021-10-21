(function($)
{
	$.widget('r3.gdatetime',
	{

		options :
		{},

		_create : function()
		{
			this._itemsMap =
			{};

			this._canvasDiv = $('<div></div>');			
			this._canvasDiv.addClass('input-group').addClass('validation-error-anchor').addClass("bootstrap-timepicker");    
			
			var renderedHtml = this._renderHtml(this.options);

			this._canvasDiv.html(renderedHtml);	
			this.element.addClass('gdatetime');
			
			this.element.html(this._canvasDiv);		
			
			var idPrefix = this.element.attr('id');			
			$('#'+ this._getDateFieldId(idPrefix)).datepicker({
				  format: "dd/mm/yyyy"
			});
			
			$('#'+ this._getTimeFieldId(idPrefix)).timepicker({
				showMeridian: false
			});

		},
		
		destroy : function()
		{
			this._canvasDiv.remove();
			$.Widget.prototype.destroy.apply(this, arguments);
		},
		
		clear: function()
		{
		},
		
		getDateTime: function()
		{
			var idPrefix = this.element.attr('id');
			var s = $('#' + this._getDateFieldId(idPrefix)).val();
			var s1 = '00:00';
			
			if (s && s.length > 0)
			{
				if (this._isTimeFieldVisible(idPrefix))
			       s1 = $('#' + this._getTimeFieldId(idPrefix)).val();				
			}
			else return null;
			
			return s + ' ' + s1;
		},
		
		_isTimeFieldVisible: function(idPrefix)
		{
			return $('#' + this._getTimeFieldId(idPrefix)).is(":visible");	
		},
		
		showtime: function()
		{
			var idPrefix = this.element.attr('id');
			$('#' + this._getTimeFieldId(idPrefix)).show();
			$('#' + this._getTimeFieldId(idPrefix)).next().show();
			// $('#' + this._getTimePickerTriggerButtonId(idPrefix)).show();
		},
		
		hidetime: function()
		{
			var idPrefix = this.element.attr('id');
			$('#' + this._getTimeFieldId(idPrefix)).hide();
			// $('#' + this._getTimePickerTriggerButtonId(idPrefix)).hide();
			$('#' + this._getTimeFieldId(idPrefix)).next().hide();
		},
		
		_getDateFieldId: function(idPrefix)
		{
		    return idPrefix + '_date'; 	
		},
		
		_getTimeFieldId: function(idPrefix)
		{
		    return idPrefix + '_time'; 	
		},
		
//		_getTimePickerTriggerButtonId: function(idPrefix)
//		{
//			return 'timepicker-trigger-' + idPrefix + '-time';
//		},
		
		_renderHtml: function(cfgHash)
		{
			var idPrefix = this.element.attr('id');					       
			
			var htmlDate = 
			   "<input type='text' class='input-sm form-control r3_datepicker' name='" + cfgHash.name + "_date' id='" + this._getDateFieldId(idPrefix) + "'  />" + 
		       "<span class='input-group-addon'><i class='glyphicon glyphicon-calendar'></i></span>";
			
			var htmlTime =
		       "<input  type='text' class='input-sm form-control r3_timepicker' name='" + cfgHash.name + "_time' id='" + this._getTimeFieldId(idPrefix) + "'>" +
		       "<span class='input-group-addon timepicker-addon'><i class='glyphicon glyphicon-time'></i></span>";		
		       			
			return htmlDate + htmlTime;
		}		
		
	});

})(jQuery);

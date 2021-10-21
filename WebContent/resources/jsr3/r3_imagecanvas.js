(function($)
{
	$.widget('r3.imagecanvas',
	{

		options :
		{},

		defaults :
		{
			width: "100%",
			height: "200px"
		},
		
		_create : function()
		{
			var widgetOptions =  this.options = $.extend({}, this.defaults, this.options);
			
			this._canvasDiv = $('<div></div>').addClass('imagecanvas');
			this._canvasDiv.width(widgetOptions.width).height(widgetOptions.height);		
						
			this._inputFile = $(widgetOptions.inputFileWidgetId);
			this._temporaryImage = new Image();		
			
			var widgetId = this.element.attr('id');
			this.element.html(this._canvasDiv);
			this.bindEvents();
		},
				
		destroy : function()
		{
			this._canvasDiv.remove();
			$.Widget.prototype.destroy.apply(this, arguments);
		},
		
		bindEvents: function()
		{
			this._inputFile.on("change", $.r3Utils.hitch(this, this._onInputFileChange));
			this._temporaryImage.onload = $.r3Utils.hitch(this, this._onImageLoad);			
		},
		
		_onInputFileChange: function(event)
		{
			var _self = this;
			
			this._canvasDiv.backgroundDraggable('disable');
				
			var t = $(event.currentTarget);
			var file = $(t)[0].files[0];						
		    
			if (file) 
		    {
				this.reader  = new FileReader();
				this.reader.onloadend = $.r3Utils.hitch(this, this._onFileRead);
				this.reader.readAsDataURL(file);
		    } 
		    else 
		    {
		    	this.reader = null;
		    }					
		},
		
		_onFileRead: function(event)
		{	        
	        this._temporaryImage.src = this.reader.result;
		},
		
		_onImageLoad: function()
		{
			var _self = this;
			
			console.log("Img width: " + this._temporaryImage.width + " height: " + this._temporaryImage.height);
			console.log("Canvas Width: " + _self._canvasDiv.width() + " height: " + _self._canvasDiv.height());
			
			this._canvasDiv.css("background", 'url(' + this._temporaryImage.src + ') no-repeat');
	    	
			var axis = 'both';
			if (this._temporaryImage.width < _self._canvasDiv.width())
				  axis = 'y';
			
			if (this._temporaryImage.height < _self._canvasDiv.height())
			{
				if (axis == 'both')
				{
					axis = 'x';
				}	
				else axis = false;
			}
			
			if (axis)
			{
			this._canvasDiv.backgroundDraggable({
				
			  axis : (axis == 'both') ? false : axis,
    		  done: function() 
    		  {
    		    backgroundPosition = _self._canvasDiv.css('background-position');
    		    console.log(backgroundPosition);
    		    
    		    var bkgInfo = backgroundPosition.split(/px\s*/);
    		    var offsetX = -parseInt(bkgInfo[0]);
    		    var offsetY = -parseInt(bkgInfo[1]);
    		    
    		    _self._cropImage(_self._temporaryImage, offsetX, offsetY, _self._canvasDiv.width(), _self._canvasDiv.height());  
    		  }
    		});			
			}
			
		},
		
		_cropImage: function(anImage, offsetX, offsetY, canvasWidth, canvasHeight)
		{
		   var crop_canvas = document.createElement('canvas');
	       crop_canvas.width = canvasWidth;
	       crop_canvas.height = canvasHeight;
	    
	       var minWidth = (anImage.width - offsetX);
	       if (minWidth > canvasWidth)
	    	   minWidth = canvasWidth;
	       
	       var minHeight = (anImage.height - offsetY);
	       if (minHeight > canvasHeight)
	    	   minHeight = canvasHeight;
	       
	       crop_canvas.getContext('2d').drawImage(anImage, offsetX, offsetY, minWidth, minHeight, 0, 0, canvasWidth, canvasHeight);
	       window.open(crop_canvas.toDataURL("image/png"));		
		}
        
	});

})(jQuery);

$.r3Utils.namespace("org.r3.jsportlet.imageupload");

// img_selector: selettore del tag immagine target
// inputfile_selector: selettore oggetto input file utilizzato
// overlay_selector : selettore dell'overlay per feedback lavorazione
// selectiontrigger_selector: selettore dell'eventuale trigger apposto in overlay
// modaldialog_selector : selettore pannello modale per il crop
// aspect_ratio
// max_size
// upload_url
// current_image_url
// extra_info
org.r3.jsportlet.imageupload.ImageUploader = Class.extend(
{
	init : function(anOptionsHash)
	{
		this.defaultConfigOptions = { overlay_selector: '_NOT_SET_OVERLAY_', selectiontrigger_selector: '_NOT_SET_SELECTIONTRIGGER_' };		
		this.configOptions = null;

		if (anOptionsHash)
		     this.configOptions = $.extend({}, this.defaultConfigOptions, anOptionsHash);
		else this.configOptions = this.defaultConfigOptions;
	},

	_displayImage: function(imgData)
	{
		if ($.isFunction(this.configOptions.img_selector))
		  this.configOptions.img_selector(imgData);
		else
		  $(this.configOptions.img_selector)[0].src = imgData;	
	},
	
	setup : function()
	{
		var _self = this;
		
		if (this.configOptions.current_image_url)
		{
			var u = $.r3Utils.formatDMSUrl4ClientAccess(this.configOptions.current_image_url);
			loadImage(u, function (img) {
				_self._displayImage(img.src);
	        });
		}
			
		$(this.configOptions.inputfile_selector).on('change', $.r3Utils.hitch(this, this.onFileSelected));
		$(this.configOptions.overlay_selector).hide();

		$(document)
	      .on('dragover', function (e) {
	            e.preventDefault();
	            e = e.originalEvent;
	            e.dataTransfer.dropEffect = 'copy';
	      })
	      .on('drop', $.r3Utils.hitch(this, this.onFileSelected));
		    
	    $(this.configOptions.selectiontrigger_selector).unbind().click(function(e) { 
		   	$(_self.configOptions.inputfile_selector).trigger('click'); 
		});					
	},
	
	onFileSelected: function(e)
	{
        e.preventDefault();
        e = e.originalEvent;
        var target = e.dataTransfer || e.target,
            file = target && target.files && target.files[0]
            ;
        
        if (!file) {
            return;
        }
        
        this.processFile(file);        
    },

    processFile: function(aFile)
    {
    	$(this.configOptions.inputfile_selector).val("");
    	
    	var _self = this;
        var options = {
                canvas: true
        };
    	
    	$(this.configOptions.modaldialog_selector).loadImage1({ 
    		file: aFile, 
    		
    		aspectRatio: this.configOptions.aspect_ratio,
    		maxSize: this.configOptions.max_size,
    		    		
    		processImage : function(img_or_canvas, exifData) 
    		{ 
				_self._displayImage(img_or_canvas.toDataURL(aFile.type));
    			img_or_canvas.toBlob(
	            	     function (blob) {
	            	    	 console.log(blob);
	            	    	 
	            	    	 var fd = new FormData();
	            	    	 fd.append('file', blob, aFile.name);
	            	    	 if (exifData)
	            	    	 {
	            	    		 for (var prop in exifData) {
	            	                if (exifData.hasOwnProperty(prop)) {
	            	                	fd.append('exif_' + prop, exifData[prop]);	            	                    
	            	                }
	            	            }		 
	            	    	 }
	            	    	 
	            	    	 if (img_or_canvas.height)	            	    		 
	            	    	     fd.append("height", img_or_canvas.height);
	            	    	 
	            	    	 if (img_or_canvas.width)	            	    		 
	            	    	     fd.append("width", img_or_canvas.width);
	            	    	 
	            	    	 if (_self.configOptions.extra_info && _self.configOptions.extra_info.length)
	            	    	 {
	            	    		 for(var k = 0; k <  _self.configOptions.extra_info.length; k++)
	            	    		      fd.append(_self.configOptions.extra_info[k].name, _self.configOptions.extra_info[k].value);
	            	    	 }
	            	    	 
	            	    	 var restUrl = _self.configOptions.upload_url;
	            	    	 
	            	    	 $(_self.configOptions.overlay_selector).show();
	            	    	 org.r3.AjaxUtils.submitFormData("PUT", restUrl, fd, function(e) {
	            	    		  console.log("Success"); 
	            	    		  $(_self.configOptions.overlay_selector).hide(); 
	            	    		  if (_self.configOptions.onSubmission)
	            	    			  _self.configOptions.onSubmission('photo');
	            	    		  
	            	         }, null, false, true);
	            	     },
	            	     aFile.type
            	 );    			
    		} 
    	});
    	
    }
			
});

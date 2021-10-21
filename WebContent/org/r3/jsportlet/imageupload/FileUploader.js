$.r3Utils.namespace("org.r3.jsportlet.imageupload");

// 
// inputfile_selector: selettore oggetto input file utilizzato
// onUploadCallback  : 
// onUploadedCallback: 
// onUploadErrorCallback
// modaldialog_selector : selettore pannello modale per il crop della immagine.
// aspect_ratio
// max_size
// upload_url
// extra_info
// accept : attributo per fornire un help utente e limitare la selezione dei file.
// 
org.r3.jsportlet.imageupload.FileUploader = Class.extend(
{
	init : function(anOptionsHash)
	{
		this.defaultConfigOptions = { upload_method : "POST" };		
		this.configOptions = null;

		if (anOptionsHash)
		     this.configOptions = $.extend({}, this.defaultConfigOptions, anOptionsHash);
		else this.configOptions = this.defaultConfigOptions;
		
		$(this.configOptions.inputfile_selector).on('change', $.r3Utils.hitch(this, this.onFileSelected));
	},

	open: function(anOptionsHash)
	{
		this.configOptions = $.extend({}, this.configOptions, anOptionsHash);
		
		// Provo a selezionarlo dinamicamente.
		if (this.configOptions.accept)
		{
			$(this.configOptions.inputfile_selector).attr("accept", this.configOptions.accept);
		}
		
		$(this.configOptions.inputfile_selector).trigger('click');
	},
	
	_getFileExtension: function(fName)
	{
		if (!fName || fName.indexOf('.') < 0)
			return null;
		
		var ext = fName.match(/\.([^\.]+)$/)[1];
		return ext;
	},
	
	
	isFileAccepted: function(fName, fType)
	{
		console.log("FileName: " + fName + "/" + fType);
		if (!this.configOptions.accept || !this.configOptions.accept.length)
			return true;
		
		var fext = this._getFileExtension(fName);
		if (fext)
			fext = '.' + fext;
		
		var accepts = this.configOptions.accept.split(',');
		for(var i = 0; i < accepts.length; i++)
		{
			var a = accepts[i].trim();
			
			if (a == fType || (fext && a == fext))
				return true;
			
			if (a == 'audio/*' && fType.indexOf('audio/') == 0)
				return true;
			
			if (a == 'video/*' && fType.indexOf('video/') == 0)
				return true;
			
			if (a == 'image/*' && fType.indexOf('image/') == 0)
				return true;				
		}
		
		return false;
	},
	
	isFileImage: function(fType)
	{
		if (fType && fType.indexOf('image/') == 0)
		{
			return true;
		}
		
		return false;
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
        
        if (this.isFileAccepted(file.name, file.type))
             this.processFile(file);
        
    },

    uploadNonImageFile: function(aFile)
    {
    	var _self = this;
    	var fd = new FormData();
    	fd.append('file', aFile, aFile.name);
    	 
    	if (_self.configOptions.extra_info && _self.configOptions.extra_info.length)
    	{
    		 for(var k = 0; k <  _self.configOptions.extra_info.length; k++)
    		      fd.append(_self.configOptions.extra_info[k].name, _self.configOptions.extra_info[k].value);
    	}
    	 
    	var restUrl = _self.configOptions.upload_url;
    	org.r3.AjaxUtils.submitFormData(this.configOptions.upload_method, restUrl, fd, 
    		function(responseData) 
    		{
   		  		console.log("Success"); 
   		  		if (_self.configOptions.onUploadedCallback)
   		  		{
   		  			_self.configOptions.onUploadedCallback(responseData);
   		  		}
    		}, 
    		null, 
    		false, true);
    },
    
    uploadImageFile: function(aFile)
    {
    	var _self = this;
    	var exifInfo = null;
    	
    	loadImage.parseMetaData(aFile, function (data) {
        	
        	var anOptionHash = { 
        			canvas: true,
        			aspectRatio: _self.configOptions.aspect_ratio,
        			maxWidth: _self.configOptions.max_size[0],
        			maxHeight: _self.configOptions.max_size[1]
        	};
        	
            if (data.exif) {
            	anOptionHash.orientation = data.exif.get('Orientation');
                exifInfo = data.exif;
            }

            loadImage(
                aFile, 
                function(img_or_canvas) 
                {
                	if (_self.configOptions.onUploadCallback)
                	{
                		_self.configOptions.onUploadCallback(img_or_canvas.toDataURL(aFile.type));
                	}
                	
                	img_or_canvas.toBlob(
                		$.r3Utils.hitch(_self, function(aBlob) { 
                			this.uploadImageBLOB(aBlob, aFile.name, img_or_canvas.width, img_or_canvas.height, exifInfo && exifInfo.getAll()); 
                		}),
                		aFile.type
                	);
                }, 
                anOptionHash);
        });
    },
    
    uploadImageBLOB: function(aBlob, aFileName, aWidth, anHeight, exifData)
    {
    	var _self = this;
    	
    	var fd = new FormData();
	    fd.append('file', aBlob, aFileName);
	    if (exifData)
	    {
	        for (var prop in exifData) {
	            if (exifData.hasOwnProperty(prop)) {
	                	fd.append('exif_' + prop, exifData[prop]);	            	                    
	            }
	        }		 
	    }
	    	 
	    if (anHeight)	            	    		 
	    	 fd.append("height", anHeight);
	    	 
	    if (aWidth)	            	    		 
	    	 fd.append("width", aWidth);
	    	 
	    if (this.configOptions.extra_info && this.configOptions.extra_info.length)
	    {
	    	 for(var k = 0; k <  this.configOptions.extra_info.length; k++)
	    	     fd.append(this.configOptions.extra_info[k].name, this.configOptions.extra_info[k].value);
	    }
	    	 
	    var restUrl = this.configOptions.upload_url;
	    	 
	    org.r3.AjaxUtils.submitFormData(this.configOptions.upload_method, restUrl, fd, function(responseData) 
	    {
	    	if (_self.configOptions.onUploadedCallback)
	    	{
	    		_self.configOptions.onUploadedCallback(responseData);
	    	}
	    		  
	    }, null, false, true);	       
    },
    
    processFile: function(aFile)
    {
    	$(this.configOptions.inputfile_selector).val("");
    	
    	var _self = this;
        var options = {
                canvas: true
        };
    	
        if (!this.isFileImage(aFile.type))
        {
        	this.uploadNonImageFile(aFile);
        	return ;
        }
        
        if (org.r3.PageManager.isSmallOrTabletDevice())
        {
        	this.uploadImageFile(aFile);
        	return ;        	
        }

        
    	$(this.configOptions.modaldialog_selector).loadImage1({ 
    		file: aFile, 
    		
    		aspectRatio: this.configOptions.aspect_ratio,
    		maxSize: this.configOptions.max_size,
    		    		
    		processImage : function(img_or_canvas, exifData) 
    		{ 
            	if (_self.configOptions.onUploadCallback)
            	{
            		_self.configOptions.onUploadCallback(img_or_canvas.toDataURL(aFile.type));
            	}

            	img_or_canvas.toBlob(
                		$.r3Utils.hitch(_self, function(aBlob) { 
                			this.uploadImageBLOB(aBlob, aFile.name, img_or_canvas.width, img_or_canvas.height, exifData); 
                		}),
                		aFile.type
                );
            	
//    			img_or_canvas.toBlob(
//	            	     function (blob) {
//	            	    	 console.log(blob);
//	            	    	 
//	            	    	 var fd = new FormData();
//	            	    	 fd.append('file', blob, aFile.name);
//	            	    	 if (exifData)
//	            	    	 {
//	            	    		 for (var prop in exifData) {
//	            	                if (exifData.hasOwnProperty(prop)) {
//	            	                	fd.append('exif_' + prop, exifData[prop]);	            	                    
//	            	                }
//	            	            }		 
//	            	    	 }
//	            	    	 
//	            	    	 if (img_or_canvas.height)	            	    		 
//	            	    	     fd.append("height", img_or_canvas.height);
//	            	    	 
//	            	    	 if (img_or_canvas.width)	            	    		 
//	            	    	     fd.append("width", img_or_canvas.width);
//	            	    	 
//	            	    	 if (_self.configOptions.extra_info && _self.configOptions.extra_info.length)
//	            	    	 {
//	            	    		 for(var k = 0; k <  _self.configOptions.extra_info.length; k++)
//	            	    		      fd.append(_self.configOptions.extra_info[k].name, _self.configOptions.extra_info[k].value);
//	            	    	 }
//	            	    	 
//	            	    	 var restUrl = _self.configOptions.upload_url;
//	            	    	 
//	            	    	 $(_self.configOptions.overlay_selector).show();
//	            	    	 org.r3.AjaxUtils.submitFormData("PUT", restUrl, fd, function(e) {
//	            	    		  console.log("Success"); 
//	            	    		  $(_self.configOptions.overlay_selector).hide(); 
//	            	    		  if (_self.configOptions.onSubmission)
//	            	    			  _self.configOptions.onSubmission('photo');
//	            	    		  
//	            	         }, null, false, true);
//	            	     },
//	            	     aFile.type
//            	 );    			
    		} 
    	});
    	
    }
			
});

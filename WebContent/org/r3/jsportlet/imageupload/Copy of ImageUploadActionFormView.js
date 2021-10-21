$.r3Utils.namespace("org.r3.jsportlet.imageupload");

org.r3.jsportlet.imageupload.ImageUploadActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		
		// Non vengono indicati parametri di default per forzare il chiamante ad impostarli correttamente
		//
		// "extraInfo" : [ { "name": "cms_attachtype" , "value" : "userphoto" }], "aspectratio": 1, "maxsize": [300, 300],
		// "templateFile" : "UserPhotoActionFormView.html.jsp",
		// "uploadurl" : org.r3.PageManager.getRESTUrl('PUT_UserCollection_Photo', [ org.r3.PageManager.userInfo.dataBean.userid ])		 
		// "imageCanvasIdHash": '#avatar-canvas'
		//
		this.defaultConfigOptions = {};		
		this.configOptions = null;
		
		this.imageUploader = null;
	},

	close : function()
	{
		this.hide();
	},
	
	open : function(aConfigHash)
	{
		var _self = this;
		
		if (aConfigHash)
		     this.configOptions = $.extend({}, this.defaultConfigOptions, aConfigHash);
		else this.configOptions = this.defaultConfigOptions;
		
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/imageupload/' + this.configOptions.templateFile),
			dataType : "html"
		});

		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_SailEvent'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	
			
			$(this.htmlContainerId).html(tmpl(responseData['view'], { viewConfigOptions: _self.configOptions }));												

			this.imageUploader = org.r3.jsportlet.imageupload.ImageUploader(
			{
				img_selector: this.configOptions.imageCanvasIdHash + ' .photoimage',
				inputfile_selector: this.configOptions.inputFileTriggerSelector,
				overlay_selector : this.configOptions.imageCanvasIdHash + ' .overlay',
				selectiontrigger_selector: this.configOptions.imageCanvasIdHash + ' .photoselectiontrigger',
				modaldialog_selector : '#photo_dialog',
				aspect_ratio: this.configOptions.aspectRatio,
				max_size: this.configOptions.maxSize,
				upload_url: this.configOptions.uploadUrl,
				current_image_url: this.configOptions.currentImageUrl,
				extra_info: this.configOptions.extraInfo	
			});
			
			this.imageUploader.setup();
			
			if (this.configOptions.currentImageUrl)
			{
				var u = $.r3Utils.formatDMSUrl4ClientAccess(this.configOptions.currentImageUrl);
				loadImage(u, function (img) {					
					$(_self.configOptions.imageCanvasIdHash + ' .photoimage')[0].src = img.src;
                });
			}
			
			// $('#startdemo').click($.r3Utils.hitch(this, function(e) {this.demo();}));
			$(this.configOptions.inputFileTriggerSelector).on('change', $.r3Utils.hitch(this, this.onFileSelected));
			$(this.configOptions.imageCanvasIdHash + ' .overlay').hide();
		    $(document)
	        .on('dragover', function (e) {
	            e.preventDefault();
	            e = e.originalEvent;
	            e.dataTransfer.dropEffect = 'copy';
	        })
	        .on('drop', $.r3Utils.hitch(this, this.onFileSelected));
		    
		    $(this.configOptions.imageCanvasIdHash + ' .photoselectiontrigger').unbind().click(function(e) { 
		    	$(_self.configOptions.inputFileTriggerSelector).trigger('click'); 
		    } );
			
			// this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
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
    	$(this.configOptions.inputFileTriggerSelector).val("");
    	
    	var _self = this;
        var options = {
                canvas: true
        };
    	
    	$('#photo_dialog').loadImage1({ 
    		file: aFile, 
    		
    		aspectRatio: this.configOptions.aspectRatio,
    		maxSize: this.configOptions.maxSize,
    		    		
    		processImage : function(img_or_canvas, exifData) 
    		{ 
    			$(_self.configOptions.imageCanvasIdHash + ' .photoimage')[0].src = img_or_canvas.toDataURL(aFile.type);
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
	            	    	 
	            	    	 if (_self.configOptions.extraInfo && _self.configOptions.extraInfo.length)
	            	    	 {
	            	    		 for(var k = 0; k <  _self.configOptions.extraInfo.length; k++)
	            	    		      fd.append(_self.configOptions.extraInfo[k].name, _self.configOptions.extraInfo[k].value);
	            	    	 }
	            	    	 
	            	    	 var restUrl = _self.configOptions.uploadUrl;
	            	    	 
	            	    	 $(_self.configOptions.imageCanvasIdHash + ' .overlay').show();
	            	    	 org.r3.AjaxUtils.submitFormData("PUT", restUrl, fd, function(e) {
	            	    		  console.log("Success"); 
	            	    		  $(_self.configOptions.imageCanvasIdHash + ' .overlay').hide(); 
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

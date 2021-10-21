$.r3Utils.namespace("org.r3.jsportlet.fileupload");

org.r3.jsportlet.fileupload.UploadFileActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.uploadedFiles = [];

		this.configOptions = {};		
	},

	_getRestUrl: function()
	{
		var  aRestUrl = this.configOptions.uploadfile_resturl;
		if (r3_IE)
			aRestUrl =	this.configOptions.uploadfile_resturl_ie;
		
		return aRestUrl;
	},
	
	_getAcceptedType: function()
	{		
		var acceptedType = null;
		if (this.configOptions.fileTypes && this.configOptions.fileTypes.length > 0)
		{
			if (this.configOptions.fileTypes.length == 1)					
				acceptedType = this.configOptions.fileTypes[0];
			else
			{
				acceptedType = '';
			    for(var i = 0; i < this.configOptions.fileTypes.length; i++)
			    {
			        if (i > 0)
			        	acceptedType += '|';
			        
			        acceptedType = acceptedType + this.configOptions.fileTypes[i]; 
			    }				    				    
			}
		}		
		
		return acceptedType;
	},
	
	_hasBack: function()
	{
	    return 	this.configOptions.onCloseUploadFileActionForm;
	},

	_getOnCloseUploadFileActionForm: function()
	{
	    return 	this.configOptions.onCloseUploadFileActionForm;
	},

	close : function()
	{
		this.hide();
	},

	isPendingUpload: function()
	{
	    if (this.uploadedFiles && this.uploadedFiles.length)
	    {
	       	for(var i = 0; i < this.uploadedFiles.length; i++)
	       		if (this.uploadedFiles[i].pending)
	       			return true;
	    }
		
	    return false;
	},
	
	_clearFilenamesQueue: function()
	{
		this.uploadedFiles.length = 0;
	},
	
	_findEnqueuedFilename: function(aFileName)
	{
	    if (this.uploadedFiles && this.uploadedFiles.length && aFileName)
	    {
	       	for(var i = 0; i < this.uploadedFiles.length; i++)
	       		if (aFileName == this.uploadedFiles[i].fname)
	       			return i;
	    }
	    
	    return -1;
	},

	_enqueueFilename4Uploading: function(aFileName)
	{
		if (aFileName)
		{
			console.info("Trying to Enqueue: " + aFileName);
			this.uploadedFiles.push({ fname: aFileName, pending: true });	
		}
   		
	},

	_markEnqueuedFileAsCompleted: function(aFileName)
	{
		if (aFileName)
		{
			console.info("Trying to Mark File as Completed: " + aFileName);
			var fileNdx = this._findEnqueuedFilename(aFileName);
			if (fileNdx >= 0)
			{
				console.info("Mark: " + aFileName);
				this.uploadedFiles[fileNdx].pending = false;	
			}
		}
	},
	
	_dequeueFilenameFromUploading: function(aFileName)
	{
		if (aFileName)
		{
			console.info("Trying to Dequeue: " + aFileName);
			var fileNdx = this._findEnqueuedFilename(aFileName);
			if (fileNdx >= 0)
			{
				console.info("Dequeuing: " + aFileName);
				this.uploadedFiles.splice(fileNdx, 1);	
			}
		}
   		
	},
	
	open : function(options)
	{
		var _self = this;
		
		if (options)
			this.configOptions = $.extend(this.configOptions, options);
		
		org.r3.PageManager.wait("org.r3.message.waiting");

		this._clearFilenamesQueue();
		
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/fileupload/UploadFileActionForm.html'),
			dataType : "html"
		});
	 	  
		if (this.configOptions.formfragment)
		{
			networkRequestsQueue.push(
			{
				id : "formfragment_extension_view",
				type : "Get",
				url : org.r3.PageManager.getVersionedUIURL(this.configOptions.formfragment),
				dataType : "html"
			});		    	
		}
					
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			var this_actionFormView = this;
			
			org.r3.PageManager.closeNotifier();

			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));
					
			var fview = responseData['formfragment_extension_view'];
			if (fview)
			{
			    $('#formfragment_fields').html(tmpl(fview, {}));	
			}
			
			if (_self.configOptions.formFragmentInit)
			{
				this.configOptions.formFragmentInit();  	
			}	
			
			if (this._hasBack())
			{
				$('#jsportletfileuploadform_action_back').button().unbind().click($.r3Utils.hitch(this, function(e) {
					this.hide();
					this.actionFormManager.closeFileUpload(this._getOnCloseUploadFileActionForm());
				}));				
			}
			else $('#jsportletfileuploadform_action_back').hide();
			
			var aRestUrl = 	this._getRestUrl();
			var acceptedType = this._getAcceptedType();

			var rexp = new RegExp(".+\\.(" + acceptedType + ")$", "i"); /* /.+\.png$/i, */
			
			// Mantenere sequentialUploads = true in quanto la logica server side sequenziale.
			$('#jsportletfileuploadform_form').fileupload(
			{
				"acceptFileTypes" : rexp
				,"url" : aRestUrl
				,"dataType": 'json'
                , "sequentialUploads" : true

				// "contentType": "multipart/form-data; charset=utf-8; boundary=-----------------------------98642416130088",
				,"formAcceptCharset": "utf-8"
				,"submit" : function(e, data)
				{
					console.info("Submitting: ", e, data, data.files[0].name);
					if (!$("#jsportletfileuploadform_form").valid())
						return false;
										
					return true;
				}
				,"failed" : function(e, data)
				{
					console.info("Failing: ", e, data);
					if (data.files && data.files.valid)
					{
						console.info("Should Dequeue: ", data.files.valid, data.files[0].name);
						this_actionFormView._dequeueFilenameFromUploading(data.files[0].name);	
					}
							
					return true;
				}
				,"completed" : function(e, data)
				{
					console.info("Done: ", e, data);
					
					if (data.result && data.result.files && data.result.files[0].error)
					{
						console.info("Done: is Error? " + data.result.files[0].error);
						this_actionFormView._dequeueFilenameFromUploading(data.files[0].name);
					}
					else this_actionFormView._markEnqueuedFileAsCompleted(data.files[0].name);					
					return true;
				}
				
			});

//			$('#uploadfileactionform_form')
//			.bind('fileuploadadd', function (e, data) 
//			{
//				console.info("Add: ", e, data);
//				if (this_actionFormView._findEnqueuedFilename(data.files[0].name) >= 0)
//				{
//					data.files[0].error = 'duplicated_file';
//					return true;	
//				}
//				
//				this_actionFormView._enqueueFilename4Uploading(data.files[0].name);		
//				return true;			
//			});

			this.show();
		}),
		
		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	}

});

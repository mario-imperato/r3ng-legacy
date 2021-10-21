$.r3Utils.namespace("org.r3.console.siteconfig.site");

org.r3.console.siteconfig.site.UploadFileActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.uploadedFiles = [];
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
	
	open : function(aCardId)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");

		this._clearFilenamesQueue();
		
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/console/siteconfig/site/UploadFileActionForm.html'),
			dataType : "html"
		});
	 	  
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			var this_actionFormView = this;
			
			org.r3.PageManager.closeNotifier();

			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));

			org.r3.PageManager.lutManager.populateSelectField(
			{
				"lutUrl" : org.r3.PageManager.getRESTUrl('LUT_CMS_Attachtype_site'),
				"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
				"selectWidget" : $('#uploadfileactionform_form_cms_attachtype')
			});

			$("#uploadfileactionform_form").validate(
			{
				meta : "validate"
			});

			var aRestUrl = 	org.r3.PageManager.getRESTUrl('POST_Card_File', [ aCardId ]);
			if (r3_IE)
				aRestUrl =	org.r3.PageManager.getRESTUrl('POST_Card_File_IE', [ aCardId ]);

			var fileTypes = org.r3.message.getDefaultAcceptedCMSFileTypes();
			
			var acceptedType = 'png';
			if (fileTypes && fileTypes.length > 0)
			{
				if (fileTypes.length == 1)					
				    acceptedType = fileTypes[0];
				else
				{
					acceptedType = '';
				    for(var i = 0; i < fileTypes.length; i++)
				    {
				        if (i > 0)
				        	acceptedType += '|';
				        
				        acceptedType = acceptedType + fileTypes[i]; 
				    }				    				    
				}
			}			

			var rexp = new RegExp(".+\\.(" + acceptedType + ")$", "i"); /* /.+\.png$/i, */
			
			// Mantenere sequentialUploads = true in quanto la logica server side sequenziale.
			$('#uploadfileactionform_form').fileupload(
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
					if (!$("#uploadfileactionform_form").valid())
						return false;
										
					return true;
				}
				,"failed" : function(e, data)
				{
					console.info("Failing: ", e, data);
					console.info("Should Dequeue: ", data.files.valid, data.files[0].name);
					if (data.files.valid)
					   this_actionFormView._dequeueFilenameFromUploading(data.files[0].name);		
					return true;
				}
				,"completed" : function(e, data)
				{
					console.info("Done: ", e, data);
					console.info("Done: is Error? " + data.result.files[0].error);
					if (data.result.files[0].error)
					{
						 this_actionFormView._dequeueFilenameFromUploading(data.files[0].name);
					}
					else this_actionFormView._markEnqueuedFileAsCompleted(data.files[0].name);					
					return true;
				}
				
			});

			$('#uploadfileactionform_form_action_releasesession')
		    .button().unbind().click($.r3Utils.hitch(org.r3.PageManager, org.r3.PageManager.back));
			
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

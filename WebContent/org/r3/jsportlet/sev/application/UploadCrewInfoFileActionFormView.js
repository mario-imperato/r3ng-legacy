$.r3Utils.namespace("org.r3.jsportlet.sev.application");

org.r3.jsportlet.sev.application.UploadCrewInfoFileActionFormView = org.r3.ActionFormView.extend(
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
	
	open : function(anApplicationDTOAdapter, crewId, crewCardNumber, crewName)
	{
		org.r3.PageManager.wait("org.r3.message.waiting");

		this._clearFilenamesQueue();
		
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/sev/application/UploadCrewInfoFileActionFormView.html'),
			dataType : "html"
		});
	 	  
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			var this_actionFormView = this;
			
			org.r3.PageManager.closeNotifier();

			$(this.htmlContainerId).html(responseData['view']);

			// "blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),			
//			org.r3.PageManager.lutManager.populateSelectField(
//			{
//				"lutUrl" : org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_doctype'),
//				"selectWidget" : $('#crewinfodocuploadform_documenttype')
//			});

			$("#crewinfodocuploadform_form").validate					
            ({
	        	   errorPlacement: $.r3Utils.layoutClassicErrorPlacement,
	               rules: org.r3.jsportlet.sev.application.crewinfodocuploadform_form_validationRules,
		           messages: org.r3.jsportlet.sev.application.crewinfodocuploadform_form_validationMessages    
	        });
					
			$('#crewinfodocuploadform_action_back').button().unbind().click($.r3Utils.hitch(this, function(e) {
				this.hide();
				this.actionFormManager.closeCrewInfoDocumentUpload();
				
				e.preventDefault();		
			}));
			
			$('#crewinfodocuploadform_crewmemberid').val(crewId);
			$('#crewinfodocuploadform_crewname').html(crewName);
			$('#crewinfodocuploadform_crewcardnumber').html(crewCardNumber);
			
			var aRestUrl = 	org.r3.PageManager.getRESTUrl('POST_SEV_Application_File', [ anApplicationDTOAdapter.dataBean.applicationid ]);
			if (r3_IE)
				aRestUrl =	org.r3.PageManager.getRESTUrl('POST_SEV_Application_File_IE', [ anApplicationDTOAdapter.dataBean.applicationid ]);

			var fileTypes = [ 'png', 'jpg', 'jpeg', 'pdf', 'html' ];
			
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
			$('#crewinfodocuploadform_form').fileupload(
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
					if (!$("#crewinfodocuploadform_form").valid())
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

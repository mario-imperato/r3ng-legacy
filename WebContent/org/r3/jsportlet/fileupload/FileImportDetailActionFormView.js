$.r3Utils.namespace("org.r3.jsportlet.fileupload");

org.r3.jsportlet.fileupload.FileImportDetailActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, options)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.configOptions = options;		
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
		
	open : function(aFileImportDTOAdpater, options)
	{
		var _self = this;
		
		if (options)
			this.configOptions = $.extend(this.configOptions, options);
		
		org.r3.PageManager.wait("org.r3.message.waiting");
		
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/fileupload/FileImportDetailActionFormView.html.jsp'),
			dataType : "html"
		});
	 	  
		networkRequestsQueue.push(
		{
			id : "importdata",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl('GET_FileImportData', [ aFileImportDTOAdpater.dataBean.importid ]),
			dataType : "json"
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
		
		networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'GET_classifier_fileimport_actor'));
				
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{			
			org.r3.PageManager.closeNotifier();

			var templatedHtml = tmpl(responseData['view'], 
					{ 
				        fileImportDTOAdapter : aFileImportDTOAdpater,
				        fileImportData : responseData['importdata']      
				    } );
			
			$(this.htmlContainerId).html(templatedHtml);
					
			var fview = responseData['formfragment_extension_view'];
			if (fview)
			{
				console.log("Adding Extension Fields to: ", $('#formfragment_fields'));
			    $('#jsportletfileimportform_extension_fields').html(tmpl(fview, {}));	
			}
			
			if (this.configOptions.formFragmentInit)
			{
				this.configOptions.formFragmentInit();  	
			}
			
			if (aFileImportDTOAdpater.dataBean.numberofcolumns > 0)
			{
				var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_classifier_fileimport_actor");
			    for(var i = 1; i <= aFileImportDTOAdpater.dataBean.numberofcolumns; i++)
			    {					
			    	var selectWidget = $('#jsportletfileimportform_fileimport_match4col' + i);
			    	if (selectWidget && selectWidget.length > 0)
			    	{			    		
						org.r3.PageManager.lutManager.populateSelectField(
						{
							"lutUrl" : resolvedUrl,						
							"selectWidget" : selectWidget						
						});  	
			    	}
			   	}
			}
			
			$('#jsportletfileimportform_fieldset_message').formmessage({});
			
			$('#jsportletfileimportform_action_cancel').unbind().click(function(e) { org.r3.PageManager.back(); });
			$('#jsportletfileimportform_action_delete').unbind().click($.r3Utils.hitch(this, this.onDeleteFileImportClick));
			$('#jsportletfileimportform_action_saveitem').unbind().click($.r3Utils.hitch(this, this.onSaveFileImportClick));
			
			this.show();
		}),
		
		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
	onDeleteFileImportClick: function(event)
	{
		if (!org.r3.PageManager.confirmation("org.r3.message.deleteconfirm"))
			return ;
		
		this.actionFormManager.deleteFileImport('delete', 'DELETE_FileImport', 
				function(responseData) { 			
		        }, 
				function(jqXHR, timeout, message) { $('#jsportletfileimportform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); });
		
		event.preventDefault();		
	},
	
	onSaveFileImportClick: function(event)
	{				
		event.preventDefault();
		
		if (!this.checkColumnMappings())
		{
			$('#jsportletfileimportform_fieldset_message').formmessage('setText', { text: org.r3.jsportlet.fileupload.message.checkcolumnmappingsfailed, category: 'error' });
			return ;
		}
		
		if (!org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
			return ;

		$('#jsportletfileimportform_action_saveitem').prop('disabled', true);
		var theForm = $('#jsportletfileimportform_form');
		
		var processUrl = 'PUT_ProcessFileImport';
		if (this.configOptions.processURL)
			processUrl = this.configOptions.processURL;
		
		this.actionFormManager.processFileImport(theForm, processUrl, 
			function(responseData) 
  	        {
			          
		    }, 
			function(jqXHR, timeout, message) { $('#jsportletfileimportform_fieldset_message').formmessage('setText', { text: message, category: 'error' }); });						
	},
	
	checkColumnMappings: function()
	{
		var rc = false;
		
		var colMatch = $("select[name='columnmatch']");
		if (colMatch && colMatch.length > 0)
		{
			var numberOfNones = 0;
			var numberOfDups = 0;
			var mappings = "";
		    for(var i = 0; i < colMatch.length; i++)
		    {
		        var selValue = $(colMatch[i]).val();		        
		        if (selValue == 'fimp_none')
		        	numberOfNones ++;
		        else
		        {
		        	if (mappings.indexOf(selValue) >= 0)
		        	{
		        	    numberOfDups ++;	
		        	}
		        	else
		        	{
		        	    mappings = mappings + ", " + selValue;	
		        	}
		        }
		    }
		    
		    if (numberOfNones < colMatch.length && numberOfDups == 0)
		    	rc = true;
		}
		
		return rc;
	}

});

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

			this.imageUploader = new org.r3.jsportlet.imageupload.ImageUploader(
			{
				img_selector: this.configOptions.imageCanvasIdHash + ' .loadimage_canvas_img',
				inputfile_selector: this.configOptions.inputFileTriggerSelector,
				overlay_selector : this.configOptions.imageCanvasIdHash + ' .overlay',
				selectiontrigger_selector: this.configOptions.imageCanvasIdHash + ' .loadimage_canvas_selectiontrigger',
				modaldialog_selector : '#photo_dialog',
				aspect_ratio: this.configOptions.aspectRatio,
				max_size: this.configOptions.maxSize,
				upload_url: this.configOptions.uploadUrl,
				current_image_url: this.configOptions.currentImageUrl,
				extra_info: this.configOptions.extraInfo	
			});
			
			this.imageUploader.setup();			
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
		
	}
	
});

$.r3Utils.namespace("org.r3.console.siteconfig.site");


org.r3.console.siteconfig.site.SiteDetailActionFormView_TabCardGraphics = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager, aLoadGraphicView)
	{
		var _self = this;
		this._super(anHtmlActionFormContainerId, anActionFormManager);	
		
		this.loadGraphicActionFormView = aLoadGraphicView;
		this._populateSelectField(
		{			
			"blankOptionText" : org.r3.PageManager.getMessageFromDict("org.r3.message.defaultBlankOptionText"),
			"selectWidget" : $('#graphicsactionform_cms_attachtype')
		});

		$('#graphicsactionform_cms_attachtype').unbind().change(function(e) 
		{
			var currentTarget = $(e.currentTarget);
			var l = currentTarget.val();
					
		    _self.processGraphic(l);
		});
	},
	
	refresh: function()
	{		
	},
	
	processGraphic: function(aGraphicType)
	{
		var _self = this;
		var currentSite = org.r3.Constants.site;
		
		org.r3.AjaxUtils.ajaxInvoke(
				'get', 
				org.r3.PageManager.getRESTUrl('GET_SiteCollection_Detail', [ currentSite ]),
				function(responseData)
				{
					var siteCollectionDTOAdapter = null;
					
					if (responseData)
					{
					   siteCollectionDTOAdapter = new org.r3.db.mongo.sitecollection.SiteCollectionDTOAdapter(responseData);	
					   var mongoImage = siteCollectionDTOAdapter.getGraphicByRole('image', aGraphicType);
					   console.log(mongoImage);
					   
					   _self.loadGraphicActionFormView.open(_self._getGraphicsUploadFor(aGraphicType, mongoImage));
//					   {
//							 "extraInfo" : [ { "name": "cms_attachtype" , "value" : "userphoto" }], "aspectRatio": 1, "maxSize": [300, 300],
//							 "templateFile" : "UserPhotoActionFormView.html.jsp",
//							 "uploadUrl" : org.r3.PageManager.getRESTUrl('PUT_SiteCollection_Graphic', [ org.r3.Constants.site ]),
//							 "currentImageUrl" : mongoImage && mongoImage.getUrl(),
//							 "imageCanvasIdHash": '#cmsattachment_userphoto_canvas',
//							 "inputFileTriggerSelector" : '#cmsattachment_userphoto_input_file'
//						});					   
					}
				}
		);		
	},
	
	_getGraphicsUploadFor: function(aGraphicType, mongoImage)
	{
		var cfg = org.r3.db.mongo.sitecollection.SiteCollectionGraphicsConfig;
		if (cfg && cfg.length)
		{
			for(var i = 0; i < cfg.length; i++)
			{
				if (cfg[i].name == aGraphicType)
				{
					var actualValue = {
					     "cssClassName" : "css_" + aGraphicType,
						 "extraInfo" : cfg[i].extraInfo, 
						 "aspectRatio": cfg[i].aspectRatio, 
						 "maxSize": cfg[i].maxSize,
						 "templateFile" : cfg[i].templateFile,
						 "uploadUrl" : org.r3.PageManager.getRESTUrl(cfg[i].uploadUrl, [ org.r3.Constants.site ]),
						 "currentImageUrl" : cfg[i].currentImageUrl,
						 "imageCanvasIdHash": cfg[i].imageCanvasIdHash,
						 "inputFileTriggerSelector" : cfg[i].inputFileTriggerSelector
					};
				
					var u = mongoImage && mongoImage.getUrl();
					if (u)
					{
						actualValue.currentImageUrl = mongoImage && mongoImage.getUrl();
					}
					return actualValue;
				}
			}
		}
		
		return null;
	},
	
	_populateSelectField: function(aConfigOpts)
	{
		var selectOptions = aConfigOpts.selectWidget.prop('options');
		selectOptions.length = 0;
		
		if (aConfigOpts.blankOptionText)
		   selectOptions[selectOptions.length] = new Option(aConfigOpts.blankOptionText, '');
		
		var cfg = org.r3.db.mongo.sitecollection.SiteCollectionGraphicsConfig;
		if (cfg && cfg.length)
		{
			for(var i = 0; i < cfg.length; i++)
			{
				selectOptions[selectOptions.length] = new Option(cfg[i].description, cfg[i].name);
			}
		}
		
	}
			
});

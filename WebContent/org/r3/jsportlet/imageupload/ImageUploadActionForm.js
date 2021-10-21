$.r3Utils.namespace("org.r3.jsportlet.imageupload");

org.r3.jsportlet.imageupload.ImageUploadActionForm = org.r3.ActionFormManager.extend(
{

	init : function(aPageManager, aDetailViewContainerId, aGraphicCanvasSelector)
	{
		this.setPageManager(aPageManager);
		this.actionFormTopCanvasId = aDetailViewContainerId;
		this.detailView = new org.r3.jsportlet.imageupload.ImageUploadActionFormView(aGraphicCanvasSelector, this);
	},

	close : function()
	{
		this.hide();
	},

	hide : function()
	{
		$(this.actionFormTopCanvasId).hide();
	},

	show : function()
	{
		$(this.actionFormTopCanvasId).show();
	},

	refresh : function()
	{
	},
	
	open: function(aGraphicType, aMongoImage)
	{
		var _self = this;
		var currentSite = org.r3.Constants.site;
		
		this.detailView.open(this._getGraphicsUploadFor(aGraphicType, aMongoImage));
		
		// Debbo aprirla manualmente in quanto se no non va...
		this.show();
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
	}

		
});


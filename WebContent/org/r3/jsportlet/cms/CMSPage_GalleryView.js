$.r3Utils.namespace("org.r3.jsportlet.cms");

org.r3.jsportlet.cms.CMSPage_GalleryView = Class.extend(
{

	init : function(aGalleryCanvasLocator, aCardId, aListOfGalleryImageProperties, aPageSize)
	{
		this.galleryCanvasLocator = aGalleryCanvasLocator;
		this.cardId = aCardId;
		this.listOfGalleryImageProperties = aListOfGalleryImageProperties;
		this.pageSize = aPageSize;
		this.cardGalleryPaginatorHelper = new org.r3.jsportlet.cms.CMSPage_PaginationHelper(aGalleryCanvasLocator + ' .cms_pagination_container');		
	},		
		
    open: function()
    {
  		this._renderData(0, this._computeDisplayLength(0, this.pageSize, this.listOfGalleryImageProperties.length));   
    },
    
    _renderData: function(iDisplayStart, iDisplayLength)
    {
    	var templatedGallery = tmpl('cms_tpl_cardview_gallery', { "listOfGalleryImages": this.listOfGalleryImageProperties, "cardid": this.cardId, "iDisplayStart": iDisplayStart, "iDisplayLength": iDisplayLength });
		$(this.galleryCanvasLocator + ' .cms_gallery').html(templatedGallery);	 
		
		this.cardGalleryPaginatorHelper.render(						
				iDisplayStart, (iDisplayLength > 0) ? iDisplayLength : 0, this.listOfGalleryImageProperties.length, this.pageSize, 
				$.r3Utils.hitch(this, this._onPreviousPage), $.r3Utils.hitch(this, this._onNextPage));	
		
		$(this.galleryCanvasLocator).show();
		
		var wall = new Freewall(this.galleryCanvasLocator + " .freewall-gallery");
		wall.reset({
			
			selector: '.brick',
			animate: true,
			fixSize: null,
			cellW: 50,
			cellH: 50,
			delay: 50,
			onResize: function() {
				wall.fitWidth();
			}
		});
		wall.fitWidth();
		
		$("a[rel='lightbox-" + this.cardId + "']").slimbox();
    },
    
    _computeDisplayLength: function(startRecord, pageSize, totalNumberOfItems)
    {
    	var length = pageSize;
    	if ((startRecord + pageSize) > totalNumberOfItems)
    		length = totalNumberOfItems - startRecord;
    	
    	return length;
    },
    
	_onNextPage: function(startRecord)
	{
		console.log("Next Page: " + startRecord);
		this._renderData(startRecord,  this._computeDisplayLength(startRecord, this.pageSize, this.listOfGalleryImageProperties.length));		
	},
	
	_onPreviousPage: function(startRecord)
	{
		console.log("Prev Page: " + startRecord);		
		this._renderData(startRecord,  this._computeDisplayLength(startRecord, this.pageSize, this.listOfGalleryImageProperties.length));		
	}
	
});


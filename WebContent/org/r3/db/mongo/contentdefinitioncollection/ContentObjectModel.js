//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.mongo.contentdefinitioncollection");

org.r3.db.mongo.contentdefinitioncollection.ContentObjectModel = Class.extend(
{
	 init: function(aContentDefinitionDTOAdapter)
	 {  
		 this.contentDefinitionDTOAdapter = aContentDefinitionDTOAdapter;
		 this.objectCanvas;
		 this.photo = null;
	 },
	 
	 setObjectCanvas: function(aJQueryObject)
	 {
		 this.objectCanvas =  aJQueryObject;
	 },
	 
	 _getContentDefinitionId: function()
	 {
		 return this.contentDefinitionDTOAdapter && this.contentDefinitionDTOAdapter.dataBean.dtokey;
	 },
	 
	 setContentDefinitionDTOAdapter: function(aContentDefinitionDTOAdapter)
	 {
		 this.contentDefinitionDTOAdapter = aContentDefinitionDTOAdapter;
	 },
	 
	 setPhoto: function(aMongoImageIcon)
	 {
		 this.photo = aMongoImageIcon;		 
	 },
	 
	 setAuhtorInfo: function(contentDefinitionId, anAuthorInfo)
	 {
		$('#' + contentDefinitionId + '_author').val(anAuthorInfo.author);
		$('#' + contentDefinitionId + '_authorname').val(anAuthorInfo.authorname);
		$('#' + contentDefinitionId + '_authortype').val(anAuthorInfo.authortype);				 
	 },
	 
	 acquireGeoLocationInfo: function()
	 {
		 var geoLocRequired = this.contentDefinitionDTOAdapter.isGeoLocationRequired();
		 if (this.contentDefinitionDTOAdapter.shouldGeoLocationBeAcquired())
		 {
			 org.r3.GoogleMapsUtils.geoCodeLocation(
					 $.r3Utils.hitch(this, this._setupCoordinates),
					 (geoLocRequired) ? 
					     $.r3Utils.hitch(this, this._geoLocationBlocked) : $.r3Utils.hitch(this, this._geoLocationBlocked)
			 )
		 }
		 
//		 switch(this.contentDefinitionDTOAdapter.getGeolocationOptions())
//		 {
//		 case 'required':
//			 
//			 break;				 
//		 }
	 },
	 
	 _setupCoordinates: function(lat, long, accuracy)
	 {
		 var cid = this._getContentDefinitionId();
		 $('#' + cid + '_geolat').val(lat);
		 $('#' + cid + '_geolong').val(long);
		 $('#' + cid + '_geoacc').val(accuracy);
		 
		 if (this.objectCanvas)
		 {
		 var postHeaderMessage = this.objectCanvas.find('.infomessage');
		 postHeaderMessage.html("GEO OK: " + lat + ' - ' + long);		 
		 var marker = this.objectCanvas.find('.box-tools i.fa-map-marker');
		 marker.toggleClass('text-success');
		 
		 // postHeaderMessage.show();		
		 }
	 },
	 
	 _geoLocationBlocked: function(aCode, aMessage)
	 {
		 if (this.objectCanvas)
		 {
			 var postHeaderMessage = this.objectCanvas.find('.infomessage');
			 postHeaderMessage.html("GEO Fail: " + aCode + ' - ' + aMessage);
			 var marker = this.objectCanvas.find('.box-tools i.fa-map-marker');
			 marker.toggleClass('text-danger');
			 
			 // postHeaderMessage.show();
		 }
	 },
	 
	 resetCommonForm: function()
	 {
		 // Reset Common Forms..
		 var cid = this._getContentDefinitionId();
		 
		 $('#' + cid + '_geolat').val(null);
		 $('#' + cid + '_geolong').val(null);
		 $('#' + cid + '_geoacc').val(null);		 
	 },
	 
	 onPositionToolClick: function()
	 {
		 if (this.objectCanvas)
		 {
			 var postHeaderMessage = this.objectCanvas.find('.infomessage');
			 postHeaderMessage.show();
		 }
	 }
       
});


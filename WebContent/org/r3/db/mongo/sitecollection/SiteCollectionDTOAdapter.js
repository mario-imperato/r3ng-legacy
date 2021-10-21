//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.mongo.sitecollection");

org.r3.db.mongo.sitecollection.SiteCollectionDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	   this._super(new org.r3.db.mongo.sitecollection.SiteCollectionDTO(aDataBean));       
	 },
	 
	 getAddressDTOAdapter: function()
	 {
		if (!this.dataBean.address)
			return null;
		
		return new org.r3.db.mongo.AddressDTOAdapter(this.dataBean.address);
	 },
	 
	 getGraphicByRole: function(aMajorRole, aMinorRole)
	 {
		if (!this.dataBean.graphics)
			return null;
		
		for(var i = 0; i < this.dataBean.graphics.length; i++)
		{
			var mimage = new org.r3.db.mongo.MongoImageIconDTOAdapter(this.dataBean.graphics[i]);
			
			if (mimage.isOfRole(aMinorRole))
			{
				if (aMajorRole == 'image' && mimage.hasImage())
					return mimage.getImage();
				
				if (aMajorRole == 'icon' && mimage.hasIcon())
					return mimage.getIcon();
				
			}
				
		}
		
		return null;
	 }
	 
       
});

org.r3.db.mongo.sitecollection.SiteCollectionGraphicsConfig = 
[{
   	 "name" : "userphoto", 
   	 "description" : "Foto Profilo Utente",
	 "extraInfo" : [ { "name": "cms_attachtype" , "value" : "userphoto" }], 
	 "aspectRatio": 1, 
	 "maxSize": [300, 300],
	 "templateFile" : "ImageUploadActionFormView.html.jsp",
	 "uploadUrl" : "PUT_SiteCollection_Graphic",
	 "imageCanvasIdHash": '#loadimage_canvas',
	 "currentImageUrl" : "/r3ng/resources/sites/default/img/userphoto.jpg",
	 "inputFileTriggerSelector" : '#loadimage_input_file'
},

{
 	 "name" : "shksitephoto", 
 	 "description" : "Immagine Rettangolare Sito",
	 "extraInfo" : [ { "name": "cms_attachtype" , "value" : "shksitephoto" }], 
	 "aspectRatio": 2.85, 
	 "maxSize": [800, 280],
	 "templateFile" : "ImageUploadActionFormView.html.jsp",
	 "uploadUrl" : "PUT_SiteCollection_Graphic",
	 "imageCanvasIdHash": '#loadimage_canvas',
	 "currentImageUrl" : "/r3ng/resources/sites/default/img/shksitephoto.jpg",
	 "inputFileTriggerSelector" : '#loadimage_input_file'
},

{
  	 "name" : "sitesquared", 
  	 "description" : "Immagine Quadrata Sito",
	 "extraInfo" : [ { "name": "cms_attachtype" , "value" : "sitesquared" }], 
	 "aspectRatio": 1, 
	 "maxSize": [300, 300],
	 "templateFile" : "ImageUploadActionFormView.html.jsp",
	 "uploadUrl" : "PUT_SiteCollection_Graphic",
	 "imageCanvasIdHash": '#loadimage_canvas',
	 "currentImageUrl" : "/r3ng/resources/sites/default/img/sitesquared.png",
	 "inputFileTriggerSelector" : '#loadimage_input_file'
}];



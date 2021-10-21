//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.mongo.timelinecollection");

org.r3.db.mongo.timelinecollection.TimelineCollectionDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	   this._super(new org.r3.db.mongo.timelinecollection.TimelineCollectionDTO(aDataBean));       
	 },
	 
	 getLastmodified: function()
	 {
		 return $.r3Utils.formatTimestampDataBeanField(this.dataBean.lastmodified);
	 },
	 
	 hasAllowedcontent: function(aContentDefinitionId)
	 {
		 if (this.dataBean && this.dataBean.allowedcontent && this.dataBean.allowedcontent.length)
		 {
			 for(var i = 0; i < this.dataBean.allowedcontent.length; i++)
			 {
				 if (this.dataBean.allowedcontent[i] == aContentDefinitionId)
					 return true;
			 }
		 }
		 
		 return false;
	 },
	 
	 isDeletable: function()
	 {
		 var systemFlag = this.dataBean && this.dataBean.timelinetype && this.dataBean.timelinetype == 'system';
		 return !systemFlag;
	 }
       
});





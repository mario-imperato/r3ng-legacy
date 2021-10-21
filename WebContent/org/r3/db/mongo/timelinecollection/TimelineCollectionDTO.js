//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.mongo.timelinecollection");

org.r3.db.mongo.timelinecollection.TimelineCollectionDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
       this.dtrowclass   = "grade_timelinecollection";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
       this.timelineid = aDataBean.timelineid || null;
       this.site = aDataBean.site || null;
       this.title = aDataBean.title || null;
       this.description = aDataBean.description || null;
       this.timelinetype = aDataBean.timelinetype || null;
       this.creationdate = aDataBean.creationdate || null;
       this.lastmodified = aDataBean.lastmodified || null;
       this.allowedcontent = aDataBean.allowedcontent || null;
	 }
       
});


//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.mongo.sitecollection");

org.r3.db.mongo.sitecollection.SiteCollectionDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
       this.dtrowclass   = "grade_sitecollection";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
       this.site = aDataBean.site || null;
       this.domain = aDataBean.domain || null;
       this.sitetype = aDataBean.sitetype || null;
       this.sitestatus = aDataBean.sitestatus || null;
       this.description = aDataBean.description || null;
       this.summary = aDataBean.summary || null;
       this.primarygeo = aDataBean.primarygeo || null;
       this.lastmodified = aDataBean.lastmodified || null;
       this.sections = aDataBean.sections || null;
       this.friends = aDataBean.friends || null;
       this.graphics = aDataBean.graphics || null;
       this.address = aDataBean.address || null;
	 }
       
});

 org.r3.db.mongo.sitecollection.FriendsDTO = Class.extend(
 {
     init: function(aDataBean)
	 {
        this.site = aDataBean.site || null;
        this.sitetype = aDataBean.sitetype || null;
        this.sitedescription = aDataBean.sitedescription || null;
	 }	   
 });   
  

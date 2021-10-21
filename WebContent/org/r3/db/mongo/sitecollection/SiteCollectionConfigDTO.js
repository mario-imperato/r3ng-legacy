//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.mongo.sitecollection");

org.r3.db.mongo.sitecollection.SiteCollectionConfigDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
       this.dtrowclass   = "grade_sitecollection";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
       this.timelines = aDataBean.timelines;
       // Non lo porto appresso in quanto viene valorizzato nell'Adapter che crea un array di Adapters.
       // this.contentclasses = aDataBean.contentclasses;
	 }
});

org.r3.db.mongo.sitecollection.ContentClassConfigDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
       this.dtrowclass   = "grade_sitecollection";
       this.dtokey       = aDataBean.name || null;
       this.dtodescr     = aDataBean.name || null;
       
       this.name = aDataBean.name;
       this.primary = aDataBean.primary || false;
       this.childContentclass = aDataBean.childContentclass;
       this.canvasskin = aDataBean.canvasskin;       
       this.actions = aDataBean.actions; 
	 }
});






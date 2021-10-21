//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.mongo.contentdefinitioncollection");

org.r3.db.mongo.contentdefinitioncollection.ContentDefinitionDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
         this.dtrowclass   = "grade_lutcollection";
         this.dtokey       = aDataBean.dtokey;
         this.dtodescr     = aDataBean.dtodescr
         this.photographictype =  aDataBean.photographictype;
         this.mongocms = aDataBean.mongocms;
         this.timeline = aDataBean.timeline;
         this.modelclass = aDataBean.modelclass;
         this.formvalidation = aDataBean.formvalidation;
         this.geolocation = aDataBean.geolocation;
	 }
       
});


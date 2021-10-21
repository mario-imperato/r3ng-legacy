//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.mongo.postcollection");

org.r3.db.mongo.postcollection.PostCollectionDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
       this.dtrowclass   = "grade_postcollection";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
       this.postid = aDataBean.postid || null;
       this.status = aDataBean.status || null;
       this.groups = aDataBean.groups || null;
       this.site = aDataBean.site || null;
       this.domain = aDataBean.domain || null;
       this.timeline = aDataBean.timeline || null;
       this.author = aDataBean.author || null;
       this.authorname = aDataBean.authorname || null;
       this.authortype = aDataBean.authortype || null;
       this.userid = aDataBean.userid || null;
       this.refdate = aDataBean.refdate || null;
       this.lastmodified = aDataBean.lastmodified || null;
       this.title = aDataBean.title || null;
       this.geolocation = aDataBean.geolocation || null;
       this.textbody = aDataBean.textbody || null;
       this.photo = aDataBean.photo || null;
       this.attachments = aDataBean.attachments || null;
       this.links = aDataBean.links || null;
       this.gallery = aDataBean.gallery || null;
       this.calendars = aDataBean.calendars || null;
       this.contentcategory = aDataBean.contentcategory || null;
       this.contentclass = aDataBean.contentclass || null;
       this.content = aDataBean.content || null;
       this.comments = aDataBean.comments || null;
	 }
       
});

 org.r3.db.mongo.postcollection.TextbodyDTO = Class.extend(
 {
     init: function(aDataBean)
	 {
        this.language = aDataBean.language || null;
        this.title = aDataBean.title || null;
        this.summary = aDataBean.summary || null;
        this.body = aDataBean.body || null;
	 }	   
 });   
  
 org.r3.db.mongo.postcollection.CommentsDTO = Class.extend(
 {
     init: function(aDataBean)
	 {
        this.commentid = aDataBean.commentid || null;
        this.author = aDataBean.author || null;
        this.authorname = aDataBean.authorname || null;
        this.authortype = aDataBean.authortype || null;
        this.userid = aDataBean.userid || null;
        this.shakeevent = aDataBean.shakeevent || null;
        this.shakedate = aDataBean.shakedate || null;
        this.lastmodified = aDataBean.lastmodified || null;
        this.title = aDataBean.title || null;
        this.geolocation = aDataBean.geolocation || null;
        this.contentcategory = aDataBean.contentcategory || null;
        this.contentclass = aDataBean.contentclass || null;
        this.content = aDataBean.content || null;
	 }	   
 });   
  

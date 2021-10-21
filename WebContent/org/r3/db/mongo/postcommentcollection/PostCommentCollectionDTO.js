//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.mongo.postcommentcollection");

org.r3.db.mongo.postcommentcollection.PostCommentCollectionDTO = Class.extend(
{
	 init: function(aDataBean)
	 {  
       this.dtrowclass   = "grade_postcommentcollection";
       this.dtokey       = aDataBean.dtokey   || null;
       this.dtodescr     = aDataBean.dtodescr || null;
       
       this.commentid = aDataBean.commentid || null;
       this.site = aDataBean.site || null;
       this.domain = aDataBean.domain || null;
       this.timeline = aDataBean.timeline || null;
       this.postid = aDataBean.postid || null;
       this.author = aDataBean.author || null;
       this.authorname = aDataBean.authorname || null;
       this.authortype = aDataBean.authortype || null;
       this.userid = aDataBean.userid || null;
       this.shakeevent = aDataBean.shakeevent || null;
       this.shakedate = aDataBean.shakedate || null;
       this.lastmodified = aDataBean.lastmodified || null;       
       this.title = aDataBean.title || null;
       this.geolocation = aDataBean.geolocation || null;
       this.geolocation = aDataBean.geolocation || null;
       this.contentcategory = aDataBean.contentcategory || null;
       this.contentclass = aDataBean.contentclass || null;
       this.content = aDataBean.content || null;
	 }
       
});


//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.mongo.postcommentcollection");

org.r3.db.mongo.postcommentcollection.PostCommentCollectionDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	   this._super(new org.r3.db.mongo.postcommentcollection.PostCommentCollectionDTO(aDataBean));       
	 },
	 
	 setTimelinePostid: function(aTimeline, aPostid)
	 {
		 this.dataBean.timeline = aTimeline;
		 this.dataBean.postid = aPostid;
	 },
	 
	 isShaked: function()
	 {
		 return this.dataBean.shakeevent; 
	 },
	 
	 getCreationdate: function()
	 {
		return $.r3Utils.formatTimestampDataBeanField(this.dataBean.lastmodified);
	 },
	 
	 getCreationDateAsBadge: function()
	 {
		 return $.r3Utils.formatDateAsBadge(this.dataBean.lastmodified);		 	 
	 },
	 
	 getCreationdateAsElapsed: function()
	 {   
		 return $.r3Utils.formatTimeDifferenceFromNow(this.dataBean.lastmodified);
	 },
	 
	 getAuthorImgUrl: function()
	 {
		 if (this.dataBean.author)
		 {
			 if (this.dataBean.authortype && this.dataBean.authortype == 'user')
			     return org.r3.PageManager.getRESTUrl("GET_UserCollection_Photo", [ this.dataBean.author, 'icon' ]);
			 else return org.r3.PageManager.getRESTUrl("GET_SiteCollection_Graphic", [ this.dataBean.author, 'sitesquared', 'icon' ]);
		 }
		 
		 return null;
	 },
	 
	 getAuthorname: function()
	 {		 		 
		 return this.dataBean.authorname;
	 },
	 
	 isUserOwnerOfContent: function(aUserDTOAdapter, aUserCollectionDTOAdapter)
	 {
		 console.log('PostCommentCollectionDTOAdapter - User is Owner of Content');
		 
//		 return this.dataBean.author && 
//		       (this.dataBean.author == aUserCollectionDTOAdapter.dataBean.userid || 
//		        aUserDTOAdapter.isInRole(this.dataBean.author, '__any__'));
		 
		 // 03/10/2016 12:04:40: sostituito con aUserDTOAdapter.isInRole(this.dataBean.author, '__any__')         
		 return this.dataBean.author && 
		 (
		    (this.dataBean.authortype == 'user' && this.dataBean.author == aUserCollectionDTOAdapter.dataBean.userid) ||
		    (
		       this.dataBean.authortype != 'user' && 
		       (aUserDTOAdapter.hasRole4Site(this.dataBean.author, org.r3.db.system.user.user.role_shkadmin) || aUserDTOAdapter.hasRole4Site(this.dataBean.author, org.r3.db.system.user.user.role_shkowner))
		    )
		 );

		 
	 } 
       
});





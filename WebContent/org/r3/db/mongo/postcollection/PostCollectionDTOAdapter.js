//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.mongo.postcollection");

org.r3.db.mongo.postcollection.PostCollectionDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	   this._super(new org.r3.db.mongo.postcollection.PostCollectionDTO(aDataBean));       
	 },
	 
	 isPublished: function()
	 {
		 return this.dataBean.status && this.dataBean.status == 'published';		 
	 },

	 isPublished: function()
	 {
		 return this.dataBean.status && this.dataBean.status == 'published';		 
	 },
	 
	 setPublished: function()
	 {
		 this.dataBean.status = 'published';
	 },
	 
	 isDraft: function()
	 {
		 return this.dataBean.status && this.dataBean.status == 'draft';		 
	 },

	 setDraft: function()
	 {
		 this.dataBean.status = 'draft';
	 },

	 getLastmodified: function()
	 {
		 return $.r3Utils.formatTimestampDataBeanField(this.dataBean.lastmodified);
	 },
	 
	 getLastmodifiedAsElapsed: function()
	 {
		 return $.r3Utils.formatTimeDifferenceFromNow(this.dataBean.lastmodified);
	 }, 
	 
	 getTitleLink: function()
	 {
		 var u = org.r3.Constants.getStrutsActionContext(this.dataBean.site) + '/org/r3/home.do';
		 u = u + '?postid=' + this.dataBean.postid;
		 return u;
	 },
	 
	 getTitle: function()
	 {
		 var l = org.r3.Constants.language;
		 var tb = this.getTextBody4Language(l);
		 if (tb != null)
			 return tb.dataBean.title;
		 
		 return this.dataBean.title;
	 },

	 getSummary: function()
	 {
		 var l = org.r3.Constants.language;
		 var tb = this.getTextBody4Language(l);
		 if (tb != null)
			 return tb.dataBean.summary;
		 
		 return '-';
	 },

	 getPhotoUrl: function()
	 {
		 var p = this.getPhoto();
		 if (p != null)
			 return p.getImage().getUrl();
		 
		 return null;
	 },
	 
	 getPhoto: function()
	 {
		 if (this.dataBean.photo)
		 {
			 var image = new org.r3.db.mongo.MongoImageIconDTOAdapter(this.dataBean.photo);		 
			 return image;
		 }
		 
		 return null;
	 },
	 
	 getTextBody4Language: function(aLanguageCode)
	 {
		 if (!aLanguageCode)
			 aLanguageCode = org.r3.Constants.language;
		 
		 var t = this.dataBean.textbody;
		 if (t && t.length)
		 {
			 for(var i = 0; i < t.length; i++)
			 {
				 if (t[i].language == aLanguageCode)
					 return new org.r3.db.mongo.postcollection.PostCollectionTextBodyDTOAdapter(t[i]);
			 }
		 }
		 
		 return null;
	 },
	 
	 hasComments: function()
	 {
		 return this.dataBean.comments && this.dataBean.comments.length > 0;
	 },
	 
	 addComment: function(aTimelineCommentCollectionDTOAdapter)
	 {
		 if (!this.dataBean.comments)
			 this.dataBean.comments = [];
		 
		 this.dataBean.comments.push(aTimelineCommentCollectionDTOAdapter.dataBean);
	 },
		
	 _findIndexOfCommentByCommentid: function(aCommentid)
	 {
		 if (!this.hasComments())
			 return -1;
	
		 for(var i = 0; i < this.dataBean.comments.length; i++)
		 {
			var c = this.dataBean.comments[i];
			if (c.commentid == aCommentid)
			{
				return i;
			}			
		 }
		 
		 return -1;
	 },
	 
	 updateComment: function(aTimelineCommentCollectionDTOAdapter, upsertFlag)
	 {
		 var ndx = this._findIndexOfCommentByCommentid(aTimelineCommentCollectionDTOAdapter.dataBean.commentid);
		 if (ndx == -1 && upsertFlag)
		 {
			if (upsertFlag)
			{
				this.addComment(aTimelineCommentCollectionDTOAdapter);
			    return true;
			}
			
			return false;	 			 
		 }
			 
		 this.dataBean.comments[ndx] = aTimelineCommentCollectionDTOAdapter.dataBean;
		 return true;
	 },
	 
	 addOrUpdateComment: function(aTimelineCommentCollectionDTOAdapter)
	 {
		 return this.updateComment(aTimelineCommentCollectionDTOAdapter, true);
	 },
		 
	 removeComment: function(aCommentId)
	 {
	 	 var ndx = this._findIndexOfCommentByCommentid(aCommentId);
		 if (ndx != -1)
		 {
			 this.dataBean.comments.splice(ndx, 1);
		 }
	 },
		
	 getComment: function(aCommentId)
	 {
		 var ndx = this._findIndexOfCommentByCommentid(aCommentId);
		 if (ndx != -1)
		 {
			 var t = new org.r3.db.mongo.postcommentcollection.PostCommentCollectionDTOAdapter(this.dataBean.comments[ndx]);
			 t.dataBean.postid = this.dataBean.postid;
			 t.dataBean.timeline = this.dataBean.timeline;
			 return t;
		 }
		 
		 return null;
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
		 return this.getLastmodifiedAsElapsed();
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
	 
	 isGeoLocated: function()
	 {		 		 
		 return this.dataBean.geolocation;
	 },
	 
	 getGeoLocationAsString: function()
	 {
		 var s = "";
		 if (this.dataBean.geolocation)
		 {
			 s = "GEO: " + this.dataBean.geolocation.coordinates[0] + ' - ' + this.dataBean.geolocation.coordinates[1];		 			 
		 }
		
		 return s;
	 },
	 
	 isUserOwnerOfContent: function(aUserDTOAdapter, aUserCollectionDTOAdapter)
	 {
		 console.log('TimelineCollectionDTOAdapter - User is Owner of Content');
		 
		 // 03/10/2016 12:04:40: sostituito con aUserDTOAdapter.isInRole(this.dataBean.author, '__any__')         
		 return this.dataBean.author && 
		 (
		    (this.dataBean.authortype == 'user' && this.dataBean.author == aUserCollectionDTOAdapter.dataBean.userid) ||
		    (
		       this.dataBean.authortype != 'user' && 
		       (aUserDTOAdapter.hasRole4Site(this.dataBean.author, org.r3.db.system.user.user.role_shkadmin) || aUserDTOAdapter.hasRole4Site(this.dataBean.author, org.r3.db.system.user.user.role_shkowner))
		    )
		 );
	 },
	 
	 getGroupsAsArray: function()
	 {
		 return this.dataBean && this.dataBean.groups;
	 }
       
});

org.r3.db.mongo.postcollection.PostCollectionTextBodyDTO = Class.extend(
{
  init: function(aDataBean)
  {  
       this.dtrowclass   = "grade_timelinecollection";
       this.language = aDataBean.language || null;
       this.title = aDataBean.title || null;
       this.summary = aDataBean.summary || null;
       this.body = aDataBean.body || null;
  }
});

org.r3.db.mongo.postcollection.PostCollectionTextBodyDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	   this._super(new org.r3.db.mongo.postcollection.PostCollectionTextBodyDTO(aDataBean));       
	 }
});

org.r3.db.mongo.postcollection.TimelineConfig = 
{
	 contentclasses : 
     [
        { name : 'shkmessage', primary : true, canvasskin : 'post-blue',		          
          actions : [
        	{ "id": 'edit',      "text": 'Modifica', "actionType": "edit",      "dataAction" : "edit-primary",     "visibility": "isOwner" },
	        { "id": 'delete',    "text": 'Elimina',  "actionType": "delete",    "dataAction" : "delete-post",      "visibility": "isOwner" },
	        { "id": 'new-post',  "text": 'Nuovo',    "actionType": "new-post",  "dataAction" : "UNUSED",           "visibility": "isFollower || isMerchant || isNeighbowner", "roles": "user,merchant,neighbowner" },
	        { "id": 'new-child', "text": 'Commenta', "actionType": "new-child", "dataAction" : "new-child:tweet",  "visibility": "isFollower || isMerchant || isNeighbowner", "roles": "user,merchant,neighbowner" }  
          ]
        },
        { name : 'crewask',    primary : true, canvasskin : 'post-default',
          actions : [
			{ "id": 'edit',   	 "text": 'Modifica', "actionType": "edit",      "dataAction" : "edit-primary",     "visibility": "isOwner" },
	        { "id": 'delete', 	 "text": 'Elimina',  "actionType": "delete",    "dataAction" : "delete-post",      "visibility": "isOwner" },
	        { "id": 'new-post',  "text": 'Nuovo', 	 "actionType": "new-post",  "dataAction" : "UNUSED",           "visibility": "always", "roles": "user" },
	        { "id": 'new-child', "text": 'Commenta', "actionType": "new-child", "dataAction" : "new-child:tweet",  "visibility": "always", "roles": "user" }				        
		  ]			        	
        },
        { name : 'crewoffer',  primary : true, canvasskin : 'post-default',
          actions : [
			{ "id": 'edit',      "text": 'Modifica', "actionType": "edit",      "dataAction" : "edit-primary",     "visibility": "isOwner" },
			{ "id": 'delete',    "text": 'Elimina',  "actionType": "delete",    "dataAction" : "delete-post",      "visibility": "isOwner" },
			{ "id": 'new-post',  "text": 'Nuovo',    "actionType": "new-post",  "dataAction" : "UNUSED",           "visibility": "always", "roles": "user" },
			{ "id": 'new-child', "text": 'Commenta', "actionType": "new-child", "dataAction" : "new-child:tweet",  "visibility": "always", "roles": "user" }						
		  ]				        	
        },
        { name : 'tweet',      primary : false,
          actions : [
			{ "id": 'edit',    "text": 'Modifica', "actionType": "edit",          "dataAction" : "edit-child",          "visibility": "!isShaked && isOwner" },
			{ "id": 'delete',  "text": 'Elimina',  "actionType": "delete",        "dataAction" : "delete-child",        "visibility": "!isShaked && isOwner" }
		  ]				        	
        },
        { name : 'shcask',    primary : true, canvasskin : 'post-default',
          actions : [
			{ "id": 'edit',   	 "text": 'Modifica', "actionType": "edit",      "dataAction" : "edit-primary",     "visibility": "isOwner" },
	        { "id": 'delete', 	 "text": 'Elimina',  "actionType": "delete",    "dataAction" : "delete-post",      "visibility": "isOwner" },
	        { "id": 'new-post',  "text": 'Nuovo', 	 "actionType": "new-post",  "dataAction" : "UNUSED",           "visibility": "always", "roles": "user" },
	        { "id": 'new-child', "text": 'Commenta', "actionType": "new-child", "dataAction" : "new-child:tweet",  "visibility": "always", "roles": "user,merchant" },
	        { "id": 'new-child1',"text": 'Offerta',  "actionType": "new-child", "dataAction" : "new-child1:shcaskoffer",  "visibility": "isMerchant && !isOwner", "roles": "merchant" }
		  ]			        	
        },
        { name : 'shcoffer',  primary : true, canvasskin : 'post-default',
          actions : [
			{ "id": 'edit',      "text": 'Modifica', "actionType": "edit",      "dataAction" : "edit-primary",     "visibility": "isOwner" },
			{ "id": 'delete',    "text": 'Elimina',  "actionType": "delete",    "dataAction" : "delete-post",      "visibility": "isOwner" },
			{ "id": 'new-post',  "text": 'Nuovo',    "actionType": "new-post",  "dataAction" : "UNUSED",           "visibility": "isMerchant", "roles": "merchant" },
			{ "id": 'new-child', "text": 'Commenta', "actionType": "new-child", "dataAction" : "new-child:tweet",  "visibility": "always", "roles": "user,postOwner" },
			{ "id": 'new-child1',"text": 'Prenota',  "actionType": "new-child", "dataAction" : "new-child1:shcofferbook",  "visibility": "!isPostOwner", "roles": "user" }
		  ]				        	
        },			        
        { name : 'shcofferbook',      primary : false,
          actions : [
			{ "id": 'edit',    "text": 'Modifica', "actionType": "edit",          "dataAction" : "edit-child",          "visibility": "!isShaked && isOwner" },
			{ "id": 'delete',  "text": 'Elimina',  "actionType": "delete",        "dataAction" : "delete-child",        "visibility": "!isShaked && isOwner" },
			{ "id": 'shakeit', "text": 'Prenota', "actionType": "shake",          "dataAction" : "shakeit",             "visibility": "!isShaked && isOwner" },
			{ "id": 'unshakeit', "text": 'Annulla Prenotazione', "actionType": "shake", "dataAction" : "unshakeit",     "visibility": "isShaked && isOwner"  }
		  ]				        	
        },
        { name : 'shcaskoffer',      primary : false,
          actions : [
			{ "id": 'edit',    "text": 'Modifica', "actionType": "edit",          "dataAction" : "edit-child",          "visibility": "!isShaked && isOwner" },
			{ "id": 'delete',  "text": 'Elimina',  "actionType": "delete",        "dataAction" : "delete-child",        "visibility": "!isShaked && isOwner" },
			{ "id": 'shakeit', "text": 'Prenota', "actionType": "shake",          "dataAction" : "shakeit",             "visibility": "!isShaked && isPostOwner && !isOwner" },
			{ "id": 'unshakeit', "text": 'Annulla Prenotazione', "actionType": "shake", "dataAction" : "unshakeit",     "visibility": "isShaked && isPostOwner && !isOwner"  }
		  ]				        	
        },
        { name : 'shknews',  primary : true, canvasskin : 'post-default', 
	          actions : [
				{ "id": 'edit',      "text": 'Modifica', "actionType": "edit",      "dataAction" : "edit-primary",     "visibility": "isOwner" },
				{ "id": 'delete',    "text": 'Elimina',  "actionType": "delete",    "dataAction" : "delete-post",      "visibility": "isOwner" },
				{ "id": 'new-post',  "text": 'Nuovo',    "actionType": "new-post",  "dataAction" : "UNUSED",           "visibility": "isNeighbowner", "roles": "neighbowner" },
				{ "id": 'new-child', "text": 'Commenta', "actionType": "new-child", "dataAction" : "new-child:tweet",  "visibility": "always", "roles": "user" }
			  ]				        	
	     },

	     { name : 'shkstruct',  primary : true, canvasskin : 'post-default', 
	          actions : [
				{ "id": 'edit',      "text": 'Modifica', "actionType": "edit",      "dataAction" : "edit-primary",     "visibility": "isOwner" },
				{ "id": 'delete',    "text": 'Elimina',  "actionType": "delete",    "dataAction" : "delete-post",      "visibility": "isOwner" },
				{ "id": 'new-post',  "text": 'Nuovo',    "actionType": "new-post",  "dataAction" : "UNUSED",           "visibility": "isNeighbowner", "roles": "neighbowner" },
				{ "id": 'new-child', "text": 'Commenta', "actionType": "new-child", "dataAction" : "new-child:tweet",  "visibility": "always", "roles": "user" }
			  ]				        	
	     }		     
	 ],
	 
	 timelines : 
	 [
         { _id: "messages", name: "Conversazioni", pillskin : 'pill-blue', postcontentclass: 'shkmessage', childcontentclass: 'tweet' },
         { _id: "crew", name: "Imbarchi", pillskin : 'pill-orange', 
           timelines : [
      	   	    { _id: "crewask",   name: "Cerco", postcontentclass: 'crewask', childcontentclass: 'tweet' },
      	   	    { _id: "crewoffer", name: "Offro", postcontentclass: 'crewoffer', childcontentclass: 'tweet' }
      	   ]
         },
         { _id: "showcase", name: "Vetrina", pillskin : 'pill-blue', 
           timelines : [
    	   	    { _id: "shcask",   name: "Cerco", postcontentclass: 'shcask' },
    	   	    { _id: "shcoffer", name: "Offro", postcontentclass: 'shcoffer' }
    	   ]
         },
         
         /* Le timelines direct vengono messe per ultime in quanto in caso contrario non vengono selezionate. */
         { _id: "news", name: "Notizie", pillskin : 'pill-blue', postcontentclass: 'shknews', childcontentclass: 'tweet', direct: true },
         { _id: "structs", name: "Strutture", pillskin : 'pill-blue', postcontentclass: 'shkstruct', childcontentclass: 'tweet', direct: true }
	 ]
};



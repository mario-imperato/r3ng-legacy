//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.mongo.contentdefinitioncollection.tweet");

org.r3.db.mongo.contentdefinitioncollection.tweet.Tweet_Model = org.r3.db.mongo.contentdefinitioncollection.ContentObjectModel.extend(
{
	 init: function(aContentDefinitionDTOAdapter)
	 {  
		 this._super(aContentDefinitionDTOAdapter);
	 },
	 	 
	 getForm: function()
	 {
		 return $('#tweet_form');
	 },
	 
	 setupForm: function(eventHandler)
	 {
		 $('#tweet_form').validate(
	   	 {				
	   		errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
	   		rules : org.r3.db.mongo.contentdefinitioncollection.tweet.tweet_validation_rules,
	   		messages : org.r3.db.mongo.contentdefinitioncollection.tweet.tweet_validation_messages
	   	 }); 
		
		 $('#tweet_edit_wrapper .content_fieldsetmessage').formmessage({});

		 if (eventHandler)
			 $('#tweet_form button').unbind().click(eventHandler);			 
	 },
	 	
	 resetForm: function()
	 {									
		$('#tweet_form')[0].reset();
		this.resetCommonForm();
		
		$('#tweet_parentpostid').val(null);
		$('#tweet_postid').val(null); 
		$('#tweet_title').val(null);
		$('#tweet_content').val(null);	    
		$('#tweet_image').empty();
		$('#tweet_photo').val(null);
        
		this.pendingFiles = null; 
	 },
	 
	 displayPhoto : function(blob_or_canvas)
	 {
		 var img = document.createElement('img');
		 img.src = blob_or_canvas;
		 
		 img = $(img);
		 img.css("width", "100%");
		 $('#tweet_postimage').html(img);		 
	 },
	 
	 initializeForm: function(initializationContext)
	 {		
		var aPostDTOAdapter = initializationContext.targetnode_or_id;
		var aTimelineId = initializationContext.timelineid;
		var anAuthorInfo = initializationContext.authorinfo;
		 
		if (initializationContext.objectcanvas)
		{
			this.setObjectCanvas(initializationContext.objectcanvas);
		}
		
		if (aPostDTOAdapter)
		{
			// Faccio l'override dell'autore.... Magari solo se è null
			if (!anAuthorInfo)
			{	
			  anAuthorInfo = {					
				author : aPostDTOAdapter.dataBean.author,
				authorname : aPostDTOAdapter.dataBean.authorname,
				authortype : aPostDTOAdapter.dataBean.authortype								
			};
			}
			
			if (_.isString(aPostDTOAdapter))
			{
				$('#tweet_timeline').val(aTimelineId);
				$('#tweet_parentpostid').val(aPostDTOAdapter);
			}
			else
			{												
				$('#tweet_timeline').val(aPostDTOAdapter.dataBean.timeline);
				$('#tweet_parentpostid').val(aPostDTOAdapter.dataBean.postid);
				$('#tweet_postid').val(aPostDTOAdapter.dataBean.commentid);
				
				var contentInfo = aPostDTOAdapter.dataBean.content;
				if (!contentInfo)
					contentInfo = {};
				
				$("#tweet_tweet").val(contentInfo.tweet);		
												
				this.pendingFiles = [];
				
//				var u = aPostDTOAdapter.getPhotoUrl();
//				if (u)
//				{
//					this.displayPhoto($.r3Utils.formatDMSUrl4ClientAccess(u));
//					this.pendingFiles.push(aPostDTOAdapter.getPhoto());									
//				}	
			}
		}		
		else 
		{
			this.acquireGeoLocationInfo();
			$('#tweet_timeline').val(aTimelineId);

		}
			
		this.setAuhtorInfo("tweet", anAuthorInfo);		
	 },
	 
	 setAuhtorInfo: function(contentDefinitionId, anAuthorInfo)
	 {
		$('#' + contentDefinitionId + '_author').val(anAuthorInfo.author);
		$('#' + contentDefinitionId + '_authorname').val(anAuthorInfo.authorname);
		$('#' + contentDefinitionId + '_authortype').val(anAuthorInfo.authortype);				 
	 },
	 
	 serializeContent: function()
	 {
		 var frm = this.getForm();
		 var serializedArray = frm.serializeArray();
		 
		 serializedArray = serializedArray.filter(function(anItem) 
		 {             
			 return !(org.r3.db.mongo.contentdefinitioncollection.formSerializationFieldExclusionList)[anItem.name] 
             		&& anItem.value;
         });
         		 	     
	     var formAsJsonObject = $.r3Utils.getArrayAsJSONObject(serializedArray);

	     if (this.pendingFiles && this.pendingFiles.length)
	     {
	    	 var photo = {};
	    	 for(var j = 0; j < this.pendingFiles.length; j++)
	    	 {
	    		 var p = 
	    		 {
	    			"width": this.pendingFiles[j].width,
	    			"height": this.pendingFiles[j].height,
	    			"role" : this.pendingFiles[j].majorrole || this.pendingFiles[j].role,
	    			"url" : this.pendingFiles[j].url
	    		 };
	    		 
	    		 photo[this.pendingFiles[j].majorrole || this.pendingFiles[j].role] = p;
	    	 }
	    	 
	    	 formAsJsonObject["photo"] = photo;
	   	 }
	     
		 var data = JSON.stringify(formAsJsonObject);		 		 		 	    
		 $('#tweet_content').val(data);		 		 	    
     $('#tweet_title').val('Tweet');		     		 	       		
	 },
	 
	 showMessage: function(m)
	 {
		 $('#tweet_edit_wrapper .content_fieldsetmessage').formmessage('setText', m);	 
	 }
	 
});


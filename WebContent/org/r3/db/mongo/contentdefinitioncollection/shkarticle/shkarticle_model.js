//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.mongo.contentdefinitioncollection.shkarticle");

org.r3.db.mongo.contentdefinitioncollection.shkarticle.Shkarticle_Model = org.r3.db.mongo.contentdefinitioncollection.ContentObjectModel.extend(
{
	 init: function(aContentDefinitionDTOAdapter)
	 {  
		 this._super(aContentDefinitionDTOAdapter);
	 },

	 	 
	 getForm: function()
	 {
		 return $('#shkarticle_form');
	 },
	 
	 setupForm: function(eventHandler)
	 {
		 $('#shkarticle_form').validate(
	   	 {				
	   		errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
	   		rules : org.r3.db.mongo.contentdefinitioncollection.shkarticle.shkarticle_validation_rules,
	   		messages : org.r3.db.mongo.contentdefinitioncollection.shkarticle.shkarticle_validation_messages
	   	 }); 
		
		 $('#shkarticle_edit_wrapper .content_fieldsetmessage').formmessage({});

		 if (eventHandler)
			 $('#shkarticle_form button').unbind().click(eventHandler);			 
	 },
	 	
	 resetForm: function()
	 {									
		$('#shkarticle_form')[0].reset();
		this.resetCommonForm();
						
		$('#shkarticle_parentpostid').val(null);
		$('#shkarticle_postid').val(null); 
		$('#shkarticle_title').val(null);
		$('#shkarticle_content').val(null);	    
		$('#shkarticle_image').empty();
        $('#shkarticle_photo').val(null);
        
		this.pendingFiles = null; 
	 },
	 
	 displayPhoto : function(blob_or_canvas)
	 {
		 var img = document.createElement('img');
		 img.src = blob_or_canvas;
		 
		 img = $(img);
		 img.css("width", "100%");
		 $('#shkarticle_postimage').html(img);		 
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
				$('#shkarticle_timeline').val(aTimelineId);
				$('#shkarticle_parentpostid').val(aPostDTOAdapter);
			}
			else
			{				
				$('#shkarticle_timeline').val(aPostDTOAdapter.dataBean.timeline);
				$('#shkarticle_parentpostid').val(aPostDTOAdapter.dataBean.parentpostid);
				$('#shkarticle_postid').val(aPostDTOAdapter.dataBean.postid);
				
				var contentInfo = aPostDTOAdapter.dataBean.content;
				if (!contentInfo)
					contentInfo = {};
				
				$("#shkarticle_message").val(contentInfo.message);		
															
				this.photo = null;
				
				var u = aPostDTOAdapter.getPhotoUrl();
				if (u)
				{
					this.displayPhoto($.r3Utils.formatDMSUrl4ClientAccess(u));
					// Premdo il dato raw
					this.setPhoto(aPostDTOAdapter.dataBean.photo);									
				
				}	
			}
		}		
		else 
		{
			this.acquireGeoLocationInfo();
			$('#shkarticle_timeline').val(aTimelineId);

		}
			
		this.setAuhtorInfo("shkarticle", anAuthorInfo);		
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
		 var data = JSON.stringify(formAsJsonObject);		 		 		 	    
		 $('#shkarticle_content').val(data);		
		 
	     if (this.photo)
	     {
	    	 $('#shkarticle_photo').val(JSON.stringify(this.photo));
	   	 }
	     else 
	    	 $('#shkarticle_photo').val();
	      		 	    
         $('#shkarticle_title').val($('#shkarticle_message').val());		     		 	       	
	 },
	 
	 showMessage: function(m)
	 {
		 $('#shkarticle_edit_wrapper .content_fieldsetmessage').formmessage('setText', m);	 
	 }
	 
});

	 
	 

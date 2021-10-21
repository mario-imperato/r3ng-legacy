//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.mongo.contentdefinitioncollection.shkmessage");

org.r3.db.mongo.contentdefinitioncollection.shkmessage.Shkmessage_Model = org.r3.db.mongo.contentdefinitioncollection.ContentObjectModel.extend(
{
	 init: function(aContentDefinitionDTOAdapter)
	 {  
		 this._super(aContentDefinitionDTOAdapter);
	 },

	 	 
	 getForm: function()
	 {
		 return $('#shkmessage_form');
	 },
	 
	 setupForm: function(eventHandler)
	 {
		 $('#shkmessage_form').validate(
	   	 {				
	   		errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
	   		rules : org.r3.db.mongo.contentdefinitioncollection.shkmessage.shkmessage_validation_rules,
	   		messages : org.r3.db.mongo.contentdefinitioncollection.shkmessage.shkmessage_validation_messages
	   	 }); 
		
		 $('#shkmessage_edit_wrapper .content_fieldsetmessage').formmessage({});

		 if (eventHandler)
			 $('#shkmessage_form button').unbind().click(eventHandler);			 
	 },
	 	
	 resetForm: function()
	 {									
		$('#shkmessage_form')[0].reset();
		this.resetCommonForm();
						
		$('#shkmessage_parentpostid').val(null);
		$('#shkmessage_postid').val(null); 
		$('#shkmessage_title').val(null);
		$('#shkmessage_content').val(null);	    
		$('#shkmessage_image').empty();
        $('#shkmessage_photo').val(null);
        
		this.pendingFiles = null; 
	 },
	 
	 displayPhoto : function(blob_or_canvas)
	 {
		 var img = document.createElement('img');
		 img.src = blob_or_canvas;
		 
		 img = $(img);
		 img.css("width", "100%");
		 $('#shkmessage_postimage').html(img);		 
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
				$('#shkmessage_timeline').val(aTimelineId);
				$('#shkmessage_parentpostid').val(aPostDTOAdapter);
			}
			else
			{				
				$('#shkmessage_timeline').val(aPostDTOAdapter.dataBean.timeline);
				$('#shkmessage_parentpostid').val(aPostDTOAdapter.dataBean.parentpostid);
				$('#shkmessage_postid').val(aPostDTOAdapter.dataBean.postid);
				
				var contentInfo = aPostDTOAdapter.dataBean.content;
				if (!contentInfo)
					contentInfo = {};
				
				$("#shkmessage_message").val(contentInfo.message);		
															
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
			$('#shkmessage_timeline').val(aTimelineId);
		}
			
		this.setAuhtorInfo("shkmessage", anAuthorInfo);		
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
		 $('#shkmessage_content').val(data);	
		 
	     if (this.photo)
	     {
	    	 $('#shkmessage_photo').val(JSON.stringify(this.photo));
	   	 }
	     else 
	    	 $('#shkmessage_photo').val();
	     	 		 	    
         $('#shkmessage_title').val($('#shkmessage_message').val());		     		 	       	
	 },
	 
	 showMessage: function(m)
	 {
		 $('#shkmessage_edit_wrapper .content_fieldsetmessage').formmessage('setText', m);	 
	 }
	 
});

	 
	 

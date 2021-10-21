//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.mongo.contentdefinitioncollection.shkstruct");

org.r3.db.mongo.contentdefinitioncollection.shkstruct.Shkstruct_Model = org.r3.db.mongo.contentdefinitioncollection.ContentObjectModel.extend(
{
	 init: function(aContentDefinitionDTOAdapter)
	 {  
		 this._super(aContentDefinitionDTOAdapter);
	 },

	 	 
	 getForm: function()
	 {
		 return $('#shkstruct_form');
	 },
	 
	 setupForm: function(eventHandler)
	 {
		 $('#shkstruct_form').validate(
	   	 {				
	   		errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
	   		rules : org.r3.db.mongo.contentdefinitioncollection.shkstruct.shkstruct_validation_rules,
	   		messages : org.r3.db.mongo.contentdefinitioncollection.shkstruct.shkstruct_validation_messages
	   	 }); 
		
		 $('#shkstruct_edit_wrapper .content_fieldsetmessage').formmessage({});

		 if (eventHandler)
			 $('#shkstruct_form button').unbind().click(eventHandler);			 
	 },
	 	
	 resetForm: function()
	 {									
		$('#shkstruct_form')[0].reset();
		this.resetCommonForm();
						
		$('#shkstruct_parentpostid').val(null);
		$('#shkstruct_postid').val(null); 
		$('#shkstruct_title').val(null);
		$('#shkstruct_content').val(null);	    
		$('#shkstruct_image').empty();
        $('#shkstruct_photo').val(null);
        
		this.pendingFiles = null; 
	 },
	 
	 displayPhoto : function(blob_or_canvas)
	 {
		 var img = document.createElement('img');
		 img.src = blob_or_canvas;
		 
		 img = $(img);
		 img.css("width", "100%");
		 $('#shkstruct_postimage').html(img);		 
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
				$('#shkstruct_timeline').val(aTimelineId);
				$('#shkstruct_parentpostid').val(aPostDTOAdapter);
			}
			else
			{				
				$('#shkstruct_timeline').val(aPostDTOAdapter.dataBean.timeline);
				$('#shkstruct_parentpostid').val(aPostDTOAdapter.dataBean.parentpostid);
				$('#shkstruct_postid').val(aPostDTOAdapter.dataBean.postid);
				
				var contentInfo = aPostDTOAdapter.dataBean.content;
				if (!contentInfo)
					contentInfo = {};

				$("#shkstruct_message").val(contentInfo.message);		
															
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
			$('#shkstruct_timeline').val(aTimelineId);

		}
			
		this.setAuhtorInfo("shkstruct", anAuthorInfo);		
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
		 $('#shkstruct_content').val(data);	
		 
	     if (this.photo)
	     {
	    	 $('#shkstruct_photo').val(JSON.stringify(this.photo));
	   	 }
	     else 
	    	 $('#shkstruct_photo').val();
	     	 		 	    
         $('#shkstruct_title').val($('#shkstruct_message').val());		     		 	       	
	 },
	 
	 showMessage: function(m)
	 {
		 $('#shkstruct_edit_wrapper .content_fieldsetmessage').formmessage('setText', m);	 
	 }
	 
});

	 
	 

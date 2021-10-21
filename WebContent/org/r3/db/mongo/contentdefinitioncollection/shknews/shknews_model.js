//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.mongo.contentdefinitioncollection.shknews");

org.r3.db.mongo.contentdefinitioncollection.shknews.Shknews_Model = org.r3.db.mongo.contentdefinitioncollection.ContentObjectModel.extend(
{
	 init: function(aContentDefinitionDTOAdapter)
	 {  
		 this._super(aContentDefinitionDTOAdapter);
	 },

	 	 
	 getForm: function()
	 {
		 return $('#shknews_form');
	 },
	 
	 setupForm: function(eventHandler)
	 {
		 $('#shknews_form').validate(
	   	 {				
	   		errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
	   		rules : org.r3.db.mongo.contentdefinitioncollection.shknews.shknews_validation_rules,
	   		messages : org.r3.db.mongo.contentdefinitioncollection.shknews.shknews_validation_messages
	   	 }); 
		
		 $('#shknews_edit_wrapper .content_fieldsetmessage').formmessage({});

		 if (eventHandler)
			 $('#shknews_form button').unbind().click(eventHandler);			 
	 },
	 	
	 resetForm: function()
	 {									
		$('#shknews_form')[0].reset();
		this.resetCommonForm();
						
		$('#shknews_parentpostid').val(null);
		$('#shknews_postid').val(null); 
		$('#shknews_title').val(null);
		$('#shknews_content').val(null);	    
		$('#shknews_image').empty();
        $('#shknews_photo').val(null);
        
		this.pendingFiles = null; 
	 },
	 
	 displayPhoto : function(blob_or_canvas)
	 {
		 var img = document.createElement('img');
		 img.src = blob_or_canvas;
		 
		 img = $(img);
		 img.css("width", "100%");
		 $('#shknews_postimage').html(img);		 
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
				$('#shknews_timeline').val(aTimelineId);
				$('#shknews_parentpostid').val(aPostDTOAdapter);
			}
			else
			{				
				$('#shknews_timeline').val(aPostDTOAdapter.dataBean.timeline);
				$('#shknews_parentpostid').val(aPostDTOAdapter.dataBean.parentpostid);
				$('#shknews_postid').val(aPostDTOAdapter.dataBean.postid);
				
				var contentInfo = aPostDTOAdapter.dataBean.content;
				if (!contentInfo)
					contentInfo = {};
				
				$("#shknews_message").val(contentInfo.message);		
															
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
			$('#shknews_timeline').val(aTimelineId);

		}
			
		this.setAuhtorInfo("shknews", anAuthorInfo);		
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
		 $('#shknews_content').val(data);		
		 
	     if (this.photo)
	     {
	    	 $('#shknews_photo').val(JSON.stringify(this.photo));
	   	 }
	     else 
	    	 $('#shknews_photo').val();
	      		 	    
         $('#shknews_title').val($('#shknews_message').val());		     		 	       	
	 },
	 
	 showMessage: function(m)
	 {
		 $('#shknews_edit_wrapper .content_fieldsetmessage').formmessage('setText', m);	 
	 }
	 
});

	 
	 

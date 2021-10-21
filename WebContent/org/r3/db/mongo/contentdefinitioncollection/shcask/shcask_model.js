//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.mongo.contentdefinitioncollection.shcask");

org.r3.db.mongo.contentdefinitioncollection.shcask.Shcask_Model = org.r3.db.mongo.contentdefinitioncollection.ContentObjectModel.extend(
{
	 init: function(aContentDefinitionDTOAdapter)
	 {  
		 this._super(aContentDefinitionDTOAdapter);
	 },

	 	 
	 getForm: function()
	 {
		 return $('#shcask_form');
	 },
	 
	 setupForm: function(eventHandler)
	 {
		 $('#shcask_form').validate(
	   	 {				
	   		errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
	   		rules : org.r3.db.mongo.contentdefinitioncollection.shcask.shcask_validation_rules,
	   		messages : org.r3.db.mongo.contentdefinitioncollection.shcask.shcask_validation_messages
	   	 }); 
		
		 $('#shcask_edit_wrapper .content_fieldsetmessage').formmessage({});

		 if (eventHandler)
			 $('#shcask_form button').unbind().click(eventHandler);			 
	 },
	 	
	 resetForm: function()
	 {									
		$('#shcask_form')[0].reset();
		this.resetCommonForm();
				
		$('#shcask_parentpostid').val(null);
		$('#shcask_postid').val(null); 
		$('#shcask_title').val(null);
		$('#shcask_content').val(null);	    
		$('#shcask_image').empty();
        $('#shcask_photo').val(null);
        
		this.pendingFiles = null; 
	 },
	 
	 displayPhoto : function(blob_or_canvas)
	 {
		 var img = document.createElement('img');
		 img.src = blob_or_canvas;
		 
		 img = $(img);
		 img.css("width", "100%");
		 $('#shcask_postimage').html(img);		 
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
				$('#shcask_timeline').val(aTimelineId);
				$('#shcask_parentpostid').val(aPostDTOAdapter);
			}
			else
			{				
				$('#shcask_timeline').val(aPostDTOAdapter.dataBean.timeline);
				$('#shcask_parentpostid').val(aPostDTOAdapter.dataBean.parentpostid);
				$('#shcask_postid').val(aPostDTOAdapter.dataBean.postid);
				
				var contentInfo = aPostDTOAdapter.dataBean.content;
				if (!contentInfo)
					contentInfo = {};

				$("#shcask_what").val(contentInfo.what);
				$("#shcask_description").val(contentInfo.description);
				$("#shcask_unitprice").val(contentInfo.unitprice);							
								
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
			$('#shcask_timeline').val(aTimelineId);

		}
			
		this.setAuhtorInfo("shcask", anAuthorInfo);		
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
		 $('#shcask_content').val(data);	
		 
	     if (this.photo)
	     {
	    	 $('#shcask_photo').val(JSON.stringify(this.photo));
	   	 }
	     else 
	    	 $('#shcask_photo').val();	     	     
	 		 	    
         $('#shcask_title').val($('#shcask_what').val());		     		 	       		
	 },
	 
	 showMessage: function(m)
	 {
		 $('#shcask_edit_wrapper .content_fieldsetmessage').formmessage('setText', m);	 
	 }
	 
});


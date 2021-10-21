//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.mongo.contentdefinitioncollection.shcoffer");

org.r3.db.mongo.contentdefinitioncollection.shcoffer.Shcoffer_Model = org.r3.db.mongo.contentdefinitioncollection.ContentObjectModel.extend(
{
	 init: function(aContentDefinitionDTOAdapter)
	 {  
		 this._super(aContentDefinitionDTOAdapter);
	 },

	 	 
	 getForm: function()
	 {
		 return $('#shcoffer_form');
	 },
	 
	 setupForm: function(eventHandler)
	 {
		 $('#shcoffer_form').validate(
	   	 {				
	   		errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
	   		rules : org.r3.db.mongo.contentdefinitioncollection.shcoffer.shcoffer_validation_rules,
	   		messages : org.r3.db.mongo.contentdefinitioncollection.shcoffer.shcoffer_validation_messages
	   	 }); 
		
		 $('#shcoffer_edit_wrapper .content_fieldsetmessage').formmessage({});

		 if (eventHandler)
			 $('#shcoffer_form button').unbind().click(eventHandler);			 
	 },
	 	
	 resetForm: function()
	 {									
		$('#shcoffer_form')[0].reset();
		this.resetCommonForm();
		
		$('#shcoffer_parentpostid').val(null);
		$('#shcoffer_postid').val(null); 
		$('#shcoffer_title').val(null);
		$('#shcoffer_content').val(null);	    
		$('#shcoffer_image').empty();
        $('#shcoffer_photo').val(null);
        
		this.pendingFiles = null; 
	 },
	 
	 displayPhoto : function(blob_or_canvas)
	 {
		 var img = document.createElement('img');
		 img.src = blob_or_canvas;
		 
		 img = $(img);
		 img.css("width", "100%");
		 $('#shcoffer_postimage').html(img);		 
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
				$('#shcoffer_timeline').val(aTimelineId);
				$('#shcoffer_parentpostid').val(aPostDTOAdapter);
			}
			else
			{				
				$('#shcoffer_timeline').val(aPostDTOAdapter.dataBean.timeline);
				$('#shcoffer_parentpostid').val(aPostDTOAdapter.dataBean.parentpostid);
				$('#shcoffer_postid').val(aPostDTOAdapter.dataBean.postid);
				
				var contentInfo = aPostDTOAdapter.dataBean.content;
				if (!contentInfo)
					contentInfo = {};
				
				$("#shcoffer_what").val(contentInfo.what);
				$("#shcoffer_description").val(contentInfo.description);
				$("#shcoffer_unitprice").val(contentInfo.unitprice);
				$("#shcoffer_availability").val(contentInfo.availability);							
								
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
			$('#shcoffer_timeline').val(aTimelineId);

		}
			
		this.setAuhtorInfo("shcoffer", anAuthorInfo);		
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
		 $('#shcoffer_content').val(data);		 		 	    

	     if (this.photo)
	     {
	    	 $('#shcoffer_photo').val(JSON.stringify(this.photo));
	   	 }
	     else 
	    	 $('#shcoffer_photo').val();	  
	     	    	     
         $('#shcoffer_title').val($('#shcoffer_what').val());		     		 	       	
	 },
	 
	 showMessage: function(m)
	 {
		 $('#shcoffer_edit_wrapper .content_fieldsetmessage').formmessage('setText', m);	 
	 }
	 
});


	 
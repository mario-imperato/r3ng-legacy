//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.mongo.contentdefinitioncollection.shcofferbook");

org.r3.db.mongo.contentdefinitioncollection.shcofferbook.Shcofferbook_Model = org.r3.db.mongo.contentdefinitioncollection.ContentObjectModel.extend(
{
	 init: function(aContentDefinitionDTOAdapter)
	 {  
		 this._super(aContentDefinitionDTOAdapter);
	 },

	 	 
	 getForm: function()
	 {
		 return $('#shcofferbook_form');
	 },
	 
	 setupForm: function(eventHandler)
	 {
		 $('#shcofferbook_form').validate(
	   	 {				
	   		errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
	   		rules : org.r3.db.mongo.contentdefinitioncollection.shcofferbook.shcofferbook_validation_rules,
	   		messages : org.r3.db.mongo.contentdefinitioncollection.shcofferbook.shcofferbook_validation_messages
	   	 }); 
		
		 $('#shcofferbook_edit_wrapper .content_fieldsetmessage').formmessage({});

		 if (eventHandler)
			 $('#shcofferbook_form button').unbind().click(eventHandler);			 
	 },
	 	
	 resetForm: function()
	 {									
		$('#shcofferbook_form')[0].reset();
		this.resetCommonForm();
		
		$('#shcofferbook_parentpostid').val(null);
		$('#shcofferbook_postid').val(null); 
		$('#shcofferbook_title').val(null);
		$('#shcofferbook_content').val(null);	    
		$('#shcofferbook_image').empty();
		$('#shcofferbook_photo').val(null);
        
		this.pendingFiles = null; 
	 },
	 
	 displayPhoto : function(blob_or_canvas)
	 {
		 var img = document.createElement('img');
		 img.src = blob_or_canvas;
		 
		 img = $(img);
		 img.css("width", "100%");
		 $('#shcofferbook_postimage').html(img);		 
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
				$('#shcofferbook_timeline').val(aTimelineId);
				$('#shcofferbook_parentpostid').val(aPostDTOAdapter);
			}
			else
			{											
				$('#shcofferbook_timeline').val(aPostDTOAdapter.dataBean.timeline);
				$('#shcofferbook_parentpostid').val(aPostDTOAdapter.dataBean.postid);
				$('#shcofferbook_postid').val(aPostDTOAdapter.dataBean.commentid);
				
				var contentInfo = aPostDTOAdapter.dataBean.content;
				if (!contentInfo)
					contentInfo = {};
				
				$("#shcofferbook_message").val(contentInfo.message);		
												
				this.photo = null;
				
			}
		}		
		else 
		{
			this.acquireGeoLocationInfo();
			$('#shcofferbook_timeline').val(aTimelineId);

		}
			
		this.setAuhtorInfo("shcofferbook", anAuthorInfo);		
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
		 $('#shcofferbook_content').val(data);		 		 	    
		 
		 $('#shcofferbook_title').val('Tweet');		     		 	       		
	 },
	 
	 showMessage: function(m)
	 {
		 $('#shcofferbook_edit_wrapper .content_fieldsetmessage').formmessage('setText', m);	 
	 }
	 
});


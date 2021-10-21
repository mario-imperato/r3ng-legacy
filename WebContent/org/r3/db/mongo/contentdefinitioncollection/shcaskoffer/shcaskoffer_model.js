//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.mongo.contentdefinitioncollection.shcaskoffer");

org.r3.db.mongo.contentdefinitioncollection.shcaskoffer.Shcaskoffer_Model = org.r3.db.mongo.contentdefinitioncollection.ContentObjectModel.extend(
{
	 init: function(aContentDefinitionDTOAdapter)
	 {  
		 this._super(aContentDefinitionDTOAdapter);
	 },

	 	 
	 getForm: function()
	 {
		 return $('#shcaskoffer_form');
	 },
	 
	 setupForm: function(eventHandler)
	 {
		 $('#shcaskoffer_form').validate(
	   	 {				
	   		errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
	   		rules : org.r3.db.mongo.contentdefinitioncollection.shcaskoffer.shcaskoffer_validation_rules,
	   		messages : org.r3.db.mongo.contentdefinitioncollection.shcaskoffer.shcaskoffer_validation_messages
	   	 }); 
		
		 $('#shcaskoffer_edit_wrapper .content_fieldsetmessage').formmessage({});

		 if (eventHandler)
			 $('#shcaskoffer_form button').unbind().click(eventHandler);			 
	 },
	 	
	 resetForm: function()
	 {									
		$('#shcaskoffer_form')[0].reset();
		this.resetCommonForm();
				
		$('#shcaskoffer_parentpostid').val(null);
		$('#shcaskoffer_postid').val(null); 
		$('#shcaskoffer_title').val(null);
		$('#shcaskoffer_content').val(null);	    
		$('#shcaskoffer_image').empty();
		$('#shcaskoffer_photo').val(null);
        
		this.pendingFiles = null; 
	 },
	 
	 displayPhoto : function(blob_or_canvas)
	 {
		 var img = document.createElement('img');
		 img.src = blob_or_canvas;
		 
		 img = $(img);
		 img.css("width", "100%");
		 $('#shcaskoffer_postimage').html(img);		 
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
				$('#shcaskoffer_timeline').val(aTimelineId);
				$('#shcaskoffer_parentpostid').val(aPostDTOAdapter);
			}
			else
			{																				
				$('#shcaskoffer_timeline').val(aPostDTOAdapter.dataBean.timeline);
				$('#shcaskoffer_parentpostid').val(aPostDTOAdapter.dataBean.postid);
				$('#shcaskoffer_postid').val(aPostDTOAdapter.dataBean.commentid);
				
				var contentInfo = aPostDTOAdapter.dataBean.content;
				if (!contentInfo)
					contentInfo = {};

				$("#shcaskoffer_shcaskoffer").val(contentInfo.shcaskoffer);		
												
				this.photo = null;				
			}
		}		
		else 
		{
			this.acquireGeoLocationInfo();
			$('#shcaskoffer_timeline').val(aTimelineId);

		}
			
		this.setAuhtorInfo("shcaskoffer", anAuthorInfo);		
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
		 $('#shcaskoffer_content').val(data);		 		 	    
		 
		 $('#shcaskoffer_title').val('Tweet');		     		 	       		
	 },
	 
	 showMessage: function(m)
	 {
		 $('#shcaskoffer_edit_wrapper .content_fieldsetmessage').formmessage('setText', m);	 
	 }
	 
});


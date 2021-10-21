//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.mongo.contentdefinitioncollection.crewask");

org.r3.db.mongo.contentdefinitioncollection.crewask.Crewask_Model = org.r3.db.mongo.contentdefinitioncollection.ContentObjectModel.extend(
{
	 init: function(aContentDefinitionDTOAdapter)
	 {  
		 this._super(aContentDefinitionDTOAdapter);
	 },
	 	 
	 getForm: function()
	 {
		 return $('#crewask_form');
	 },
	 
	 setupForm: function(eventHandler)
	 {
		 $('#crewask_form').validate(
	   	 {				
	   		errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
	   		rules : org.r3.db.mongo.contentdefinitioncollection.crewask.crewask_validation_rules,
	   		messages : org.r3.db.mongo.contentdefinitioncollection.crewask.crewask_validation_messages
	   	 }); 
		
		 $('#crewask_edit_wrapper .content_fieldsetmessage').formmessage({});

		 if (eventHandler)
			 $('#crewask_form button').unbind().click(eventHandler);			 
	 },
	 
	 resetForm: function()
	 {											
		$('#crewask_form')[0].reset();
		this.resetCommonForm();
		
		$('#crewask_parentpostid').val(null);
		$('#crewask_postid').val(null); 
		$('#crewask_title').val(null);
		$('#crewask_content').val(null);	    
		
        $('#crewask_photo').val(null);
        $('#crewask_image')[0].src = '/r3ng/resources/sites/default/default_avatar_male.jpg';
		this.pendingFiles = null; 
	 },
	 
	 displayPhoto : function(blob_or_canvas)
	 {
		 $('#crewask_image')[0].src = blob_or_canvas;
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
				$('#crewask_timeline').val(aTimelineId);
				$('#crewask_parentpostid').val(aPostDTOAdapter);
			}
			else
			{				
				$('#crewask_timeline').val(aPostDTOAdapter.dataBean.timeline);
				$('#crewask_parentpostid').val(aPostDTOAdapter.dataBean.parentpostid);
				$('#crewask_postid').val(aPostDTOAdapter.dataBean.postid);
				
				var contentInfo = aPostDTOAdapter.dataBean.content;
				if (!contentInfo)
					contentInfo = {};
				
				$("#crewask_crewrole").val(contentInfo.crewrole);
				$("#crewask_crewlevel").val(contentInfo.crewlevel);
				$("#crewask_crewname").val(contentInfo.crewname);
				$("#crewask_crewemail").val(contentInfo.crewemail);
				$("#crewask_crewphone").val(contentInfo.crewphone);
				$("#crewask_crewweight").val(contentInfo.crewweight);
				$("#crewask_crewheight").val(contentInfo.crewheight);
				$("#crewask_crewage").val(contentInfo.crewage);
				$("#crewask_crewinfo").val(contentInfo.crewinfo);		
				
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
			$('#crewask_timeline').val(aTimelineId);

		}
			
		this.setAuhtorInfo("crewask", anAuthorInfo);		
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
         		 
		 var crewRoleVal = $('#crewask_crewrole').val();
		 var crewRoleText = '';
		 if (crewRoleVal && crewRoleVal.length > 0)
		 {
		     crewRoleText = $("#crewask_crewrole option[value='" + crewRoleVal + "']").text();
		     serializedArray.push({ "name": "crewroletext", "value": crewRoleText  });		     			 
		 }
		 
	     var crewLevelVal = $('#crewask_crewlevel').val();
	     var crewLevelText = '';
	     if (crewLevelVal && crewLevelVal.length > 0)
		 {
		     crewLevelText = $("#crewask_crewlevel option[value='" + crewLevelVal + "']").text();	     
		     serializedArray.push({ "name": "crewleveltext", "value": crewLevelText });
		 }
	     		 
	     var formAsJsonObject = $.r3Utils.getArrayAsJSONObject(serializedArray);
    	 var data = JSON.stringify(formAsJsonObject);		 
		 $('#crewask_content').val(data);

	     if (this.photo)
	     {
	    	 $('#crewask_photo').val(JSON.stringify(this.photo));
	   	 }
	     else 
	    	 $('#crewask_photo').val();
		 		 	    
	     if (crewRoleVal && crewRoleVal.length > 0)
	          $('#crewask_title').val(crewRoleText + ' ' + crewLevelText);
	     else $('#crewask_title').val($('#crewask_crewname').val());	    	
	 },
	 
	 showMessage: function(m)
	 {
		 $('#crewask_edit_wrapper .content_fieldsetmessage').formmessage('setText', m);	 
	 }
	 
	 
});

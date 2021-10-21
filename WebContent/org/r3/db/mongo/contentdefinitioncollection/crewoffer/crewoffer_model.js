//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.mongo.contentdefinitioncollection.crewoffer");

org.r3.db.mongo.contentdefinitioncollection.crewoffer.Crewoffer_Model = org.r3.db.mongo.contentdefinitioncollection.ContentObjectModel.extend(
{
	 init: function(aContentDefinitionDTOAdapter)
	 {  
		 this._super(aContentDefinitionDTOAdapter);
	 },
	 	 
	 getForm: function()
	 {
		 return $('#crewoffer_form');
	 },
	 
	 setupForm: function(eventHandler)
	 {
		 $('#crewoffer_form').validate(
	   	 {				
	   		errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
	   		rules : org.r3.db.mongo.contentdefinitioncollection.crewoffer.crewoffer_validation_rules,
	   		messages : org.r3.db.mongo.contentdefinitioncollection.crewoffer.crewoffer_validation_messages
	   	 }); 
		
		 $('#crewoffer_edit_wrapper .content_fieldsetmessage').formmessage({});

		 if (eventHandler)
			 $('#crewoffer_form button').unbind().click(eventHandler);			 
	 },
	 
	 resetForm: function()
	 {									
		$('#crewoffer_form')[0].reset();
		this.resetCommonForm();
		
		$('#crewoffer_parentpostid').val(null);
		$('#crewoffer_postid').val(null); 
		$('#crewoffer_title').val(null);
		$('#crewoffer_content').val(null);	    
		
        $('#crewoffer_photo').val(null);
        $('#crewoffer_image')[0].src = '/r3ng/resources/sites/default/default_avatar_male.jpg';
		this.pendingFiles = null; 				
	 },
	 
	 displayPhoto : function(blob_or_canvas)
	 {
		 $('#crewoffer_image')[0].src = blob_or_canvas;
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
				$('#crewoffer_timeline').val(aTimelineId);
				$('#crewoffer_parentpostid').val(aPostDTOAdapter);
			}
			else
			{				
				$('#crewoffer_timeline').val(aPostDTOAdapter.dataBean.timeline);
				$('#crewoffer_parentpostid').val(aPostDTOAdapter.dataBean.parentpostid);
				$('#crewoffer_postid').val(aPostDTOAdapter.dataBean.postid);
				
				var contentInfo = aPostDTOAdapter.dataBean.content;
				if (!contentInfo)
					contentInfo = {};

				if (contentInfo.crewrole && contentInfo.crewrole.length > 0)
				{
				    var listOfRoles = contentInfo.crewrole.split(',');
				    if (listOfRoles && listOfRoles.length)
				    {
				        for(var j = 0; j < listOfRoles.length; j++)
				        {
				        	$('#crewoffer_crewrole_' + listOfRoles[j]).prop('checked', true);
				        }
				    }
				}			
				
				$("#crewoffer_crewlevel").val(contentInfo.crewlevel);
				$("#crewoffer_ownername").val(contentInfo.ownername);
				$("#crewoffer_owneremail").val(contentInfo.owneremail);
				$("#crewoffer_ownerphone").val(contentInfo.ownerphone);
				$("#crewoffer_yachtname").val(contentInfo.yachtname);
				$("#crewoffer_yachtmodel").val(contentInfo.yachtmodel);
				$("#crewoffer_yachtinfo").val(contentInfo.yachtinfo);
								
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
			$('#crewoffer_timeline').val(aTimelineId);

		}
			
		this.setAuhtorInfo("crewoffer", anAuthorInfo);		
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
         		 
		 var crewRoleVal = '';
		 var crewRoleText = '';
		 	
		 var rolesCheck = $("#crewoffer_form input[type='checkbox'][name='crewrole']");
		 for(var i = 0; i < rolesCheck.length; i++)
		 {			 
			 var cbk = $(rolesCheck[i]);
			 if (cbk.prop('checked'))
			 {
				 if (crewRoleVal.length > 0)
					 crewRoleVal = crewRoleVal + ',';
				 
			    crewRoleVal = crewRoleVal + cbk.val();
			    
			    if (crewRoleText.length > 0)
			        crewRoleText = crewRoleText + ', ';
			    
			    crewRoleText = crewRoleText + cbk.parent().text();
			 }
		 }
		 		
		 // Viene messo in coda. QUando vado a deserializzare vince sugli altri.
		 if (crewRoleVal && crewRoleVal.length > 0)
		 {
			 // serializedArray.push({ "name": "crewrole", "value": crewRoleVal  });
		     serializedArray.push({ "name": "crewroletext", "value": crewRoleText  });					 
		 }
		 
	     var crewLevelVal = $('#crewoffer_crewlevel').val();
	     var crewLevelText = '';
	     if (crewLevelVal && crewLevelVal.length > 0)
		 {
	    	 crewLevelText = $("#crewoffer_crewlevel option[value='" + crewLevelVal + "']").text();		     
		     serializedArray.push({ "name": "crewleveltext", "value": crewLevelText });
		 }
	     
	     var formAsJsonObject = $.r3Utils.getArrayAsJSONObject(serializedArray);
		 var data = JSON.stringify(formAsJsonObject);		 
		 $('#crewoffer_content').val(data);

	     if (this.photo)
	     {
	    	 $('#crewask_photo').val(JSON.stringify(this.photo));
	   	 }
	     else 
	    	 $('#crewoffer_photo').val();
	     		 		 	    
	     if (crewRoleVal && crewRoleVal.length > 0)
	         $('#crewoffer_title').val(crewRoleText + ' ' + crewLevelText);
	     else $('#crewoffer_title').val($('#crewoffer_ownername').val());	    	
	 },
	 
	 showMessage: function(m)
	 {
		 $('#crewoffer_edit_wrapper .content_fieldsetmessage').formmessage('setText', m);	 
	 }
	 
});



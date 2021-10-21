//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.jsportlet.timeline");

org.r3.jsportlet.timeline.crewask_BBSThreadNode_Profile = Class.extend(
{
	 init: function()
	 {  
	 },
	 
	 getProfileid: function()
	 {
		 return 'crewask';
	 },
	 
	 onOpenActionFormView: function(responseData)
	 {
		    $("#jsportlettimelineform_primarypost_formtemplate").html(tmpl(responseData['crewask_view'], { threadProfile: this }));
			$('#crewask_jsportlettimelineform_form').validate(
		   	{				
		   		errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
		   		rules : org.r3.jsportlet.timeline.crewask_jsportlettimelineform_form_validationRules,
		   		messages : org.r3.jsportlet.timeline.crewask_jsportlettimelineform_form_validationMessages
		   	}); 
			
			$('#crewask_jsportlettimelineform_wrapper .jsportlettimelineform_fieldsetmessage').formmessage({});
	 },
	 
	 resetForm: function()
	 {									
		$('#crewask_jsportlettimelineform_form')[0].reset();
		$('#crewask_jsportlettimelineform_nodeparentid').val(null);
		$('#crewask_jsportlettimelineform_threadnodeid').val(null);
		// $('#crewask_jsportlettimelineform_nodetype').val(null);    
		$('#crewask_jsportlettimelineform_nodetitle').val(null);
		$('#crewask_jsportlettimelineform_nodetext').val(null);	    
	 },

	 getForm: function()
	 {
		 return $('#crewask_jsportlettimelineform_form');
	 },
	 
	 getThreadNodeIdFieldValue: function()
	 {
		 return $('#crewask_jsportlettimelineform_threadnodeid').val();
	 },
	 
	 serializePost: function()
	 {
		 var frm = $('#crewask_jsportlettimelineform_form');
		 var serializedArray = frm.serializeArray();
		 
		 var crewRoleVal = $('#crewask_jsportlettimelineform_crewrole').val();
	     var crewLevelVal = $('#crewask_jsportlettimelineform_crewlevel').val();
	     var crewRoleText = $("#crewask_jsportlettimelineform_crewrole option[value='" + crewRoleVal + "']").text();
	     var crewLevelText = $("#crewask_jsportlettimelineform_crewlevel option[value='" + crewLevelVal + "']").text();
	     
	     serializedArray.push({ "name": "crewroletext", "value": crewRoleText  });
	     serializedArray.push({ "name": "crewleveltext", "value": crewLevelText });
		 
		 var data = JSON.stringify(serializedArray);		 
		 $('#crewask_jsportlettimelineform_nodetext').val(data);
		 		 	    
	     if (crewRoleVal)
	          $('#crewask_jsportlettimelineform_nodetitle').val(crewRoleText + ' ' + crewLevelText);
	     else $('#crewask_jsportlettimelineform_nodetitle').val($('#crewask_jsportlettimelineform_crewname').val());	    	
	 },
	 
	 showMessage: function(m)
	 {
		 $('#crewask_jsportlettimelineform_form .jsportlettimelineform_fieldsetmessage').formmessage('setText', m);	 
	 },	 	 	 
	 
	 initializeForm: function(aBBSThreadNodeDTOAdapter)
	 {		
		// $('#crewask_jsportlettimelineform_nodetitle').val(null);
		// $('#crewask_jsportlettimelineform_nodetext').val("");
		 
		if (aBBSThreadNodeDTOAdapter)
		{
			if (_.isString(aBBSThreadNodeDTOAdapter))
			{
				$('#crewask_jsportlettimelineform_nodeparentid').val(aBBSThreadNodeDTOAdapter);
			}
			else
			{
				$('#crewask_jsportlettimelineform_nodeparentid').val(aBBSThreadNodeDTOAdapter.dataBean.nodeparentid);
				$('#crewask_jsportlettimelineform_threadnodeid').val(aBBSThreadNodeDTOAdapter.dataBean.threadnodeid);
				
				var deserializedObj = this._getNodetextAsJSONObject(aBBSThreadNodeDTOAdapter.dataBean.nodetext);
				$("#crewask_jsportlettimelineform_crewrole").val(deserializedObj.crewrole);
				$("#crewask_jsportlettimelineform_crewlevel").val(deserializedObj.crewlevel);
				$("#crewask_jsportlettimelineform_crewname").val(deserializedObj.crewname);
				$("#crewask_jsportlettimelineform_crewemail").val(deserializedObj.crewemail);
				$("#crewask_jsportlettimelineform_crewphone").val(deserializedObj.crewphone);
				$("#crewask_jsportlettimelineform_crewweight").val(deserializedObj.crewweight);
				$("#crewask_jsportlettimelineform_crewheight").val(deserializedObj.crewheight);
				$("#crewask_jsportlettimelineform_crewage").val(deserializedObj.crewage);
				$("#crewask_jsportlettimelineform_crewinfo").val(deserializedObj.crewinfo);					
			}
		}		
	 },
		
	 _getNodetextAsJSONObject: function(s)
	 {
         var deserializedObj = $.parseJSON(s);
		 
		 // Verificare cosa succede ai checkbox.
		 var objHash = {};
		 for(var i = 0; i < deserializedObj.length; i++)
	     {
			 objHash[deserializedObj[i].name] = deserializedObj[i].value;
		 }
		
		 return objHash;
	},
	 
	 getNewPostTemplate: function()
	 {
		 return  '/org/r3/jsportlet/timeline/crewask_BBSThreadPortletView_FormTemplate.html.jsp';
	 },
	 
	 getPostActions: function()
	 {
		 var postActions = [  
		       { "id": 'edit-primary', "text": 'Modifica', "visibility": "onUserIsOwner" },
		       { "id": 'delete', "text": 'Elimina', "visibility": "onUserIsOwner" }
		 ];
		 
		 return postActions;
	 },
	 
	 getLabels: function()
	 {
		var	labels = {
				newPost: "Nuova Inserzione",
				multiplePosts: "Inserzioni",
				singlePost: "Inserzione",
				newPostPanelHeading: 'Inserimento Inserzione'				
		};
		
		return labels;
	 },
	 


	 postInfoRenderer: function(aBBSTopic, aBBSThread, aPost)
	 {			
			var templatedHtml = tmpl('template-bbsthreadportletviewactionform_postinforenderer', { 
				 "topic": aBBSTopic,
				 "thread": aBBSThread,
				 "post": aPost,
				 "threadProfile": this
		    });
	    	
			return templatedHtml;
	},
	
	postContentRenderer: function(aBBSTopic, aBBSThread, aPost)
	 {
		var deserializedObj = this._getNodetextAsJSONObject(aPost.dataBean.nodetext);
		 
		 var htmlPostText = tmpl('template-bbsthreadportletviewactionform_cimbarco_contentrenderer', deserializedObj);		 		 						
		 return htmlPostText;
	},
	
	 postRenderer: function(aBBSTopic, aBBSThread, aPost)
	 {		  		 
		 var htmlPostText = this.postContentRenderer(aBBSTopic, aBBSThread, aPost);		 		 						
		 var templatedHtml = tmpl('template-timelineportletviewactionform', { 
				 "topic": aBBSTopic,
				 "thread": aBBSThread,
				 "post": aPost,
				 "nodetextashtml": htmlPostText,
				 "threadProfile": this
		  });
	    	
		return templatedHtml;
	}
	

	

	 
       
});

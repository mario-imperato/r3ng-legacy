//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.jsportlet.timeline");

org.r3.jsportlet.timeline.crewoffer_BBSThreadDTO_Profile = Class.extend(
{
	 init: function()
	 {  
	 },
	 
	 getProfileid: function()
	 {
		 return 'crewoffer';
	 },
	 
	 onOpenActionFormView: function(responseData)
	 {
		    $("#jsportlettimelineform_primarypost_formtemplate").html(tmpl(responseData['crewoffer_view'], { threadProfile: this }));
			$('#crewoffer_jsportlettimelineform_form').validate(
		   	{				
		   		errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
		   		rules : org.r3.jsportlet.timeline.crewoffer_jsportlettimelineform_form_validationRules,
		   		messages : org.r3.jsportlet.timeline.crewoffer_jsportlettimelineform_form_validationMessages
		   	}); 
			
			$('#crewoffer_jsportlettimelineform_wrapper .jsportlettimelineform_fieldsetmessage').formmessage({});
	 },
	 
	 resetForm: function()
	 {									
		$('#crewoffer_jsportlettimelineform_form')[0].reset();
		$('#crewoffer_jsportlettimelineform_nodeparentid').val(null);
		$('#crewoffer_jsportlettimelineform_threadnodeid').val(null);
		// $('#crewoffer_jsportlettimelineform_nodetype').val(null);    
		$('#crewoffer_jsportlettimelineform_nodetitle').val(null);
		$('#crewoffer_jsportlettimelineform_nodetext').val(null);	    
	 },
	 
	 getForm: function()
	 {
		 return $('#crewoffer_jsportlettimelineform_form');
	 },
	 
	 getThreadNodeIdFieldValue: function()
	 {
		 return $('#crewoffer_jsportlettimelineform_threadnodeid').val();
	 },
	 
	 serializePost: function()
	 {
		 var frm = $('#crewoffer_jsportlettimelineform_form');
		 var serializedArray = frm.serializeArray();
		 
		 var crewRoleVal = '';
		 var crewRoleText = '';
		 	
		 var rolesCheck = $("#crewoffer_jsportlettimelineform_form input[type='checkbox'][name='crewrole']");
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
		 serializedArray.push({ "name": "crewrole", "value": crewRoleVal  });
		 
	     var crewLevelVal = $('#crewoffer_jsportlettimelineform_crewlevel').val();	     
	     var crewLevelText = $("#crewoffer_jsportlettimelineform_crewlevel option[value='" + crewLevelVal + "']").text();
	     
	     serializedArray.push({ "name": "crewroletext", "value": crewRoleText  });
	     serializedArray.push({ "name": "crewleveltext", "value": crewLevelText });
		 
		 var data = JSON.stringify(serializedArray);		 
		 $('#crewoffer_jsportlettimelineform_nodetext').val(data);
		 		 	    
	     if (crewRoleVal)
	          $('#crewoffer_jsportlettimelineform_nodetitle').val(crewRoleText + ' ' + crewLevelText);
	     else $('#crewoffer_jsportlettimelineform_nodetitle').val($('#crewoffer_jsportlettimelineform_ownername').val());	    	
	 },

	 showMessage: function(m)
	 {
		 $('#crewoffer_jsportlettimelineform_form .jsportlettimelineform_fieldsetmessage').formmessage('setText', m);	 
	 },
	 
	 
	 initializeForm: function(aBBSThreadNodeDTOAdapter)
	 {		
		// $('#crewoffer_jsportlettimelineform_nodetitle').val(null);
		// $('#crewoffer_jsportlettimelineform_nodetext').val("");
		
		if (aBBSThreadNodeDTOAdapter)
		{
			if (_.isString(aBBSThreadNodeDTOAdapter))
			{
				$('#crewoffer_jsportlettimelineform_nodeparentid').val(aBBSThreadNodeDTOAdapter);
			}
			else
			{				
				$('#crewoffer_jsportlettimelineform_nodeparentid').val(aBBSThreadNodeDTOAdapter.dataBean.nodeparentid);
				$('#crewoffer_jsportlettimelineform_threadnodeid').val(aBBSThreadNodeDTOAdapter.dataBean.threadnodeid);
				
				var deserializedObj = this._getNodetextAsJSONObject(aBBSThreadNodeDTOAdapter.dataBean.nodetext);
				
				if (deserializedObj.crewrole && deserializedObj.crewrole.length > 0)
				{
				    var listOfRoles = deserializedObj.crewrole.split(',');
				    if (listOfRoles && listOfRoles.length)
				    {
				        for(var j = 0; j < listOfRoles.length; j++)
				        {
				        	$('#crewoffer_jsportlettimelineform_crewrole_' + listOfRoles[j]).prop('checked', true);
				        }
				    }
				}			
				
				$("#crewoffer_jsportlettimelineform_crewlevel").val(deserializedObj.crewlevel);
				$("#crewoffer_jsportlettimelineform_ownername").val(deserializedObj.ownername);
				$("#crewoffer_jsportlettimelineform_owneremail").val(deserializedObj.owneremail);
				$("#crewoffer_jsportlettimelineform_ownerphone").val(deserializedObj.ownerphone);
				$("#crewoffer_jsportlettimelineform_yachtname").val(deserializedObj.yachtname);
				$("#crewoffer_jsportlettimelineform_yachtmodel").val(deserializedObj.yachtmodel);
				$("#crewoffer_jsportlettimelineform_yachtinfo").val(deserializedObj.yachtinfo);
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
		 return  '/org/r3/jsportlet/timeline/crewoffer_BBSThreadPortletView_FormTemplate.html.jsp';
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
		 
		 var htmlPostText = tmpl('template-bbsthreadportletviewactionform_oimbarco_contentrenderer', deserializedObj);		 		 						
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

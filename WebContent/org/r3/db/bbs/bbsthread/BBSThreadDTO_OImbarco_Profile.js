//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.bbs.bbsthread");

org.r3.db.bbs.bbsthread.BBSThreadDTO_OImbarco_Profile = Class.extend(
{
	 init: function()
	 {  
	 },
	 
	 getNewPostTemplate: function()
	 {
		 return  '/org/r3/jsportlet/bbs/BBSThreadPortletView_NewPostOImbarco_FormTemplate.html.jsp';
	 },
	 
	 getPostActions: function()
	 {
		 var postActions = [  
		       { "id": 'edit', "text": 'Modifica', "visibility": "onUserIsOwner" },
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
	 
	 serializePost: function()
	 {
		 var frm = $('#bbsthreadportletviewactionform_form');
		 var serializedArray = frm.serializeArray();
		 
		 var crewRoleVal = '';
		 var crewRoleText = '';
		 	
		 var rolesCheck = $("#bbsthreadportletviewactionform_form input[type='checkbox'][name='crewrole']");
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
		 
	     var crewLevelVal = $('#bbsthreadportletviewactionform_crewlevel').val();	     
	     var crewLevelText = $("#bbsthreadportletviewactionform_crewlevel option[value='" + crewLevelVal + "']").text();
	     
	     serializedArray.push({ "name": "crewroletext", "value": crewRoleText  });
	     serializedArray.push({ "name": "crewleveltext", "value": crewLevelText });
		 
		 var data = JSON.stringify(serializedArray);		 
		 $('#bbsthreadportletviewactionform_nodetext').val(data);
		 		 	    
	     if (crewRoleVal)
	          $('#bbsthreadportletviewactionform_nodetitle').val(crewRoleText + ' ' + crewLevelText);
	     else $('#bbsthreadportletviewactionform_nodetitle').val($('#bbsthreadportletviewactionform_ownername').val());	    	
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
		 var templatedHtml = tmpl('template-bbsthreadportletviewactionform', { 
				 "topic": aBBSTopic,
				 "thread": aBBSThread,
				 "post": aPost,
				 "nodetextashtml": htmlPostText,
				 "threadProfile": this
		  });
	    	
		return templatedHtml;
	},
	
	initializeForm: function(aBBSThreadNodeDTOAdapter)
	{		
		$('#bbsthreadportletviewactionform_nodetitle').val(null);
		$('#bbsthreadportletviewactionform_nodetext').val("");
		
		if (aBBSThreadNodeDTOAdapter)
		{
			var deserializedObj = this._getNodetextAsJSONObject(aBBSThreadNodeDTOAdapter.dataBean.nodetext);
			
			if (deserializedObj.crewrole && deserializedObj.crewrole.length > 0)
			{
			    var listOfRoles = deserializedObj.crewrole.split(',');
			    if (listOfRoles && listOfRoles.length)
			    {
			        for(var j = 0; j < listOfRoles.length; j++)
			        {
			        	$('#bbsthreadportletviewactionform_crewrole_' + listOfRoles[j]).prop('checked', true);
			        }
			    }
			}			
			
			$("#bbsthreadportletviewactionform_crewlevel").val(deserializedObj.crewlevel);
			$("#bbsthreadportletviewactionform_ownername").val(deserializedObj.ownername);
			$("#bbsthreadportletviewactionform_owneremail").val(deserializedObj.owneremail);
			$("#bbsthreadportletviewactionform_ownerphone").val(deserializedObj.ownerphone);
			$("#bbsthreadportletviewactionform_yachtname").val(deserializedObj.yachtname);
			$("#bbsthreadportletviewactionform_yachtmodel").val(deserializedObj.yachtmodel);
			$("#bbsthreadportletviewactionform_yachtinfo").val(deserializedObj.yachtinfo);
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
	}
	 
       
});

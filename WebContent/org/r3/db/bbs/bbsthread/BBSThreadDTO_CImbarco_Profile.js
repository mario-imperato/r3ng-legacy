//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.bbs.bbsthread");

org.r3.db.bbs.bbsthread.BBSThreadDTO_CImbarco_Profile = Class.extend(
{
	 init: function()
	 {  
	 },
	 
	 getNewPostTemplate: function()
	 {
		 return  '/org/r3/jsportlet/bbs/BBSThreadPortletView_NewPostCImbarco_FormTemplate.html.jsp';
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
		 
		 var crewRoleVal = $('#bbsthreadportletviewactionform_crewrole').val();
	     var crewLevelVal = $('#bbsthreadportletviewactionform_crewlevel').val();
	     var crewRoleText = $("#bbsthreadportletviewactionform_crewrole option[value='" + crewRoleVal + "']").text();
	     var crewLevelText = $("#bbsthreadportletviewactionform_crewlevel option[value='" + crewLevelVal + "']").text();
	     
	     serializedArray.push({ "name": "crewroletext", "value": crewRoleText  });
	     serializedArray.push({ "name": "crewleveltext", "value": crewLevelText });
		 
		 var data = JSON.stringify(serializedArray);		 
		 $('#bbsthreadportletviewactionform_nodetext').val(data);
		 		 	    
	     if (crewRoleVal)
	          $('#bbsthreadportletviewactionform_nodetitle').val(crewRoleText + ' ' + crewLevelText);
	     else $('#bbsthreadportletviewactionform_nodetitle').val($('#bbsthreadportletviewactionform_crewname').val());	    	
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
			$("#bbsthreadportletviewactionform_crewrole").val(deserializedObj.crewrole);
			$("#bbsthreadportletviewactionform_crewlevel").val(deserializedObj.crewlevel);
			$("#bbsthreadportletviewactionform_crewname").val(deserializedObj.crewname);
			$("#bbsthreadportletviewactionform_crewemail").val(deserializedObj.crewemail);
			$("#bbsthreadportletviewactionform_crewphone").val(deserializedObj.crewphone);
			$("#bbsthreadportletviewactionform_crewweight").val(deserializedObj.crewweight);
			$("#bbsthreadportletviewactionform_crewheight").val(deserializedObj.crewheight);
			$("#bbsthreadportletviewactionform_crewage").val(deserializedObj.crewage);
			$("#bbsthreadportletviewactionform_crewinfo").val(deserializedObj.crewinfo);
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

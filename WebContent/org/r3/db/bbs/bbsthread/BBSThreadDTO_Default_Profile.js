//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.db.bbs.bbsthread");

org.r3.db.bbs.bbsthread.BBSThreadDTO_Default_Profile = Class.extend(
{
	 init: function()
	 {  
	 },
	 
	 getNewPostTemplate: function()
	 {
		 return  '/org/r3/jsportlet/bbs/BBSThreadPortletView_NewPost_FormTemplate.html.jsp';
	 },
	 
	 getPostActions: function()
	 {
		 var postActions = [ 
    		    { "id": 'close', "text": 'Chiudi', "visibility": "always" }, 			    
    		    { "id": 'reply', "text": 'Rispondi', "visibility": "onUserLogged" }, 
    		    { "id": 'reply-with-citation', "text": 'Rispondi Citando', "visibility": "onUserLogged" }		    
		 ];
		 
		 return postActions;
	 },
	 
	 getLabels: function()
	 {
		var	labels = {
			newPost: "Nuovo Commento",
			multiplePosts: "Commenti",
			singlePost: "Commento",
			newPostPanelHeading: 'Inserimento Commento'
		};
		
		return labels;
	 },
	 
	 serializePost: function()
	 {
		 
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
			var nodetextAsHtml = XBBCODE.process({
			    text: aPost.dataBean.nodetext,
			    removeMisalignedTags: false,
			    addInLineBreaks: true
			});
			
			return nodetextAsHtml.html;
	},
	
	 postRenderer: function(aBBSTopic, aBBSThread, aPost)
	 {
			var nodetextAsHtml = this.postContentRenderer(aBBSTopic, aBBSThread, aPost);
			
			var templatedHtml = tmpl('template-bbsthreadportletviewactionform', { 
				 "topic": aBBSTopic,
				 "thread": aBBSThread,
				 "post": aPost,
				 "nodetextashtml": nodetextAsHtml,
				 "threadProfile": this
		    });
	    	
			return templatedHtml;	
	},
	
	initializeForm: function(aBBSThreadNodeDTOAdapter)
	{				
		if (aBBSThreadNodeDTOAdapter)
		{
			$('#bbsthreadportletviewactionform_nodetitle').val(aBBSThreadNodeDTOAdapter.dataBean.nodetitle);
			$('#bbsthreadportletviewactionform_nodetext').val(dtoAdapter.dataBean.nodetext);				
		}
		else
		{
			$('#bbsthreadportletviewactionform_nodetitle').val(null);
			$('#bbsthreadportletviewactionform_nodetext').val("");
		}
	}
       
});

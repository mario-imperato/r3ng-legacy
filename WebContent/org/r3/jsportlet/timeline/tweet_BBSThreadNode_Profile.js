//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



jQuery.r3Utils.namespace("org.r3.jsportlet.timeline");

org.r3.jsportlet.timeline.tweet_BBSThreadNode_Profile = Class.extend(
{
	 init: function()
	 {  
	 },
	 
	 getProfileid: function()
	 {
		 return 'tweet';
	 },
	 
	 onOpenActionFormView: function(responseData)
	 {
		    $("#jsportlettimelineform_childpost_formtemplate").html(tmpl(responseData['tweet_view'], { threadProfile: this }));
			$('#tweet_jsportlettimelineform_form').validate(
		   	{				
		   		errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
		   		rules : org.r3.jsportlet.timeline.tweet_jsportlettimelineform_form_validationRules,
		   		messages : org.r3.jsportlet.timeline.tweet_jsportlettimelineform_form_validationMessages
		   	}); 	
			
			$('#tweet_jsportlettimelineform_wrapper .jsportlettimelineform_fieldsetmessage').formmessage({});
	 },
	 
	 resetForm: function()
	 {									
		$('#tweet_jsportlettimelineform_form')[0].reset();
		$('#tweet_jsportlettimelineform_nodeparentid').val(null);
		$('#tweet_jsportlettimelineform_threadnodeid').val(null);
		// $('#tweet_jsportlettimelineform_nodetype').val(null);        
	 },
	 
	 getForm: function()
	 {
		 return $('#tweet_jsportlettimelineform_form');
	 },
	 
	 getThreadNodeIdFieldValue: function()
	 {
		 return $('#tweet_jsportlettimelineform_threadnodeid').val();
	 },
	 
	 serializePost: function()
	 {
		 
	 },
	 
	 showMessage: function(m)
	 {
		 $('#tweet_jsportlettimelineform_form .jsportlettimelineform_fieldsetmessage').formmessage('setText', m);	 
	 },
	 
	 
	 initializeForm: function(aBBSThreadNodeDTOAdapter)
	 {				
		if (aBBSThreadNodeDTOAdapter)
		{
			if (_.isString(aBBSThreadNodeDTOAdapter))
			{
				$('#tweet_jsportlettimelineform_nodeparentid').val(aBBSThreadNodeDTOAdapter);
			}
			else
			{				
				$('#tweet_jsportlettimelineform_nodetitle').val(aBBSThreadNodeDTOAdapter.dataBean.nodetitle);
				$('#tweet_jsportlettimelineform_nodetext').val(aBBSThreadNodeDTOAdapter.dataBean.nodetext);	
				$('#tweet_jsportlettimelineform_nodeparentid').val(aBBSThreadNodeDTOAdapter.dataBean.nodeparentid);
				$('#tweet_jsportlettimelineform_threadnodeid').val(aBBSThreadNodeDTOAdapter.dataBean.threadnodeid);
			}
			
		}
		else
		{
			$('#tweet_jsportlettimelineform_nodetitle').val(null);
			$('#tweet_jsportlettimelineform_nodetext').val("");
		}
	 }, 
	 
	 getNewPostTemplate: function()
	 {
		 return  '/org/r3/jsportlet/bbs/tweet_BBSThreadPortletView_FormTemplate.html.jsp';
	 },
	 
	 getPostActions: function()
	 {
		 var postActions = [ 
		        { "id": 'edit-child', "text": 'Modifica', "visibility": "onUserIsOwner" },
		        { "id": 'delete', "text": 'Elimina', "visibility": "onUserIsOwner" }
		                    
//    		    { "id": 'close', "text": 'Chiudi', "visibility": "always" }, 			    
//    		    { "id": 'reply', "text": 'Rispondi', "visibility": "onUserLogged" }, 
//    		    { "id": 'reply-with-citation', "text": 'Rispondi Citando', "visibility": "onUserLogged" }		    
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
	 

	 
	 postInfoRenderer: function(aBBSTopic, aBBSThread, aPost)
	 {			
			var templatedHtml = tmpl('template-timelineportletviewactionform_postinforenderer', { 
				 "topic": aBBSTopic,
				 "thread": aBBSThread,
				 "post": aPost,
				 "threadProfile": this
		    });
	    	
			return templatedHtml;
	},
	
	// OK
	postContentRenderer: function(aBBSTopic, aBBSThread, aPost)
	{						
			return aPost.dataBean.nodetext;
	},
	
	 postRenderer: function(aBBSTopic, aBBSThread, aPost)
	 {
			var nodetextAsHtml = this.postContentRenderer(aBBSTopic, aBBSThread, aPost);
			
			var templatedHtml = tmpl('template-timelineportletviewactionform', { 
				 "topic": aBBSTopic,
				 "thread": aBBSThread,
				 "post": aPost,
				 "nodetextashtml": nodetextAsHtml,
				 "threadProfile": this
		    });
	    	
			return templatedHtml;	
	},
	

       
});

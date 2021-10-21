$.r3Utils.namespace("org.r3.jsportlet.bbs");


org.r3.jsportlet.bbs.BBSThreadPortletView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.bbsTopicDTOAdapter = null;
		this.bbsThreadDTOAdapter = null;
		this.threadProfile = null;
		this.hasCkEditorField = false;
	},

	close : function()
	{
		this.hide();
	},

	open : function(aBBSTopicId, aBBSThreadId)
	{
		var _self = this;		
		
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];		

		networkRequestsQueue.push(
		{
			id : "bbstopicdetail",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl("GET_BBSTopicDetail", [ aBBSTopicId ]),
			dataType : "json"
		});
		
		networkRequestsQueue.push(
		{
			id : "bbsthreaddetail",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl("GET_BBSThreadDetail", [ aBBSTopicId, aBBSThreadId ]),
			dataType : "json"
		});
		
		networkRequestsQueue.push(
		{
			id : "bbsthreadnodes",
			type : "Get",
			url : org.r3.PageManager.getRESTUrl("GET_BBSThreadNodes_InThread", [ aBBSTopicId, aBBSThreadId ]),
			dataType : "json"
		});
		
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/bbs/BBSThreadPortletView.html.jsp'),
			dataType : "html"
		});
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

			var bbsTopicDTOAdapter = responseData['bbstopicdetail'];
			if (bbsTopicDTOAdapter)
			{
				this.bbsTopicDTOAdapter = new org.r3.db.bbs.bbstopic.BBSTopicDTOAdapter(bbsTopicDTOAdapter);				
			}

			var bbsThreadDTOAdapter = responseData['bbsthreaddetail'];
			if (bbsThreadDTOAdapter)
			{
				this.bbsThreadDTOAdapter = new org.r3.db.bbs.bbsthread.BBSThreadDTOAdapter(bbsThreadDTOAdapter);				
			}

			this.threadProfile = this.bbsThreadDTOAdapter.getThreadProfile();
			
			var bbsThreadNodesDTOAdapter = responseData['bbsthreadnodes'];
			if (bbsThreadNodesDTOAdapter)
			{
				this.bbsThreadNodesDTOAdapter = new org.r3.db.DTOTableAdapter(bbsThreadNodesDTOAdapter, 
						function(aRowDataBean) { return new org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewDTOAdapter(aRowDataBean); });						
			}						
 		    
 		    $(this.htmlContainerId).html(tmpl(responseData['view'], { threadProfile: this.threadProfile })); 	
 		    $('#bbsthreadportletviewactionform_threadtitle').html(this.bbsThreadDTOAdapter.dataBean.threadtitle);

 		    $("#bbsthreadportletviewactionform_form_template").load(
 		    		org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + this.threadProfile.getNewPostTemplate()), 
 		            function() {

 		    			// Attendo che l'html sia disponibile....
 		    			$('#bbsthreadportletviewactionform_form').validate(
 		   				{				
 		   					errorPlacement : $.r3Utils.layoutClassicErrorPlacement,
 		   					rules : org.r3.jsportlet.bbs.bbsthreadportletviewactionform_form_validationRules,
 		   					messages : org.r3.jsportlet.bbs.bbsthreadportletviewactionform_form_validationMessages
 		   				}); 		     		   			
 		    		    
 		     		    if ($("#bbsthreadportletviewactionform_nodetext[class=ckeditor]").length > 0)
 		     		    {
 		     		       $('#bbsthreadportletviewactionform_nodetext').ckeditor( /* { customConfig: '/r3ng/resources/fckeditor_config/bbcode_config.js' } */ );
 		     	 		   _self.hasCkEditorField = true;
 		     		    }
 		    		}
 		    ); 		    
 		   
 		    for(var i = 0; i < this.bbsThreadNodesDTOAdapter.getNumberOfItems(); i++)
 		    {
 		    	this._appendPost(this.bbsTopicDTOAdapte, this.bbsThreadDTOAdapter, this.bbsThreadNodesDTOAdapter.getItem(i));
 		    }
          		    		     		     		    
 		    this._showNumberOfComments(this.bbsThreadNodesDTOAdapter.getNumberOfItems());
 		    		    
			$('#bbsthreadportletviewactionform_fieldset_message').formmessage({});
 		   
 		    $('#bbsthreadportletviewactionform_action_saveitem').unbind().click(
					$.r3Utils.hitch(this, this._onSaveItem));

 		    $('#bbsthreadportletviewactionform_action_startnew').unbind().click(
					$.r3Utils.hitch(this, this._onOpenSubmissionForm));

 		    $('#bbsthreadportletviewactionform_action_clearform').click(
					$.r3Utils.hitch(this, this._onCancelSubmission));
 		   
 		    $('#bbsthreadportletviewactionform_threadposts_cnt').click(
					$.r3Utils.hitch(this, this._onClickOnThreadPosts)); 		    		   
 		    		    		    
 		    if (org.r3.PageManager.userInfo.isGuest())
 		    {
 		    	$('#bbsthreadportletviewactionform_action_startnew_actionbar').hide();
 		    }
 		    
			this.show();			
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
	_showNumberOfComments: function(numberOfPosts)
	{
		var m = numberOfPosts + ' ' + this.threadProfile.getLabels().multiplePosts;
		if (numberOfPosts == 1)
			m = numberOfPosts + ' ' + this.threadProfile.getLabels().singlePost;
		
		$('#bbsthreadportletviewactionform_threadposts_summary').html(m);
	},
	
	_onCancelSubmission: function()
	{
		this._closeSubmissionForm();
		this._resetPostForm();
	},
	
	_onOpenSubmissionForm: function()
	{
		$('#bbsthreadportletviewactionform_form_canvas').show();
		$('#bbsthreadportletviewactionform_action_startnew_actionbar').hide();		
	},

	_closeSubmissionForm: function()
	{
		$('#bbsthreadportletviewactionform_form_canvas').hide();
		$('#bbsthreadportletviewactionform_action_startnew_actionbar').show();		
	},

	_onClickOnThreadPosts: function(e)
	{
		var target = $(e.target);
		var dataAction = target.attr('data-action');
		var dataActionTarget = target;
		var ps = null;
		
		if (!dataAction)
		{
		   ps = target.parents('[data-action]');
		   if (ps.length > 0)
		   {
			   dataActionTarget = $(ps[0]); 
			   dataAction = dataActionTarget.attr('data-action');   
		   }			
		}
	
		if (dataAction != null)
		{
		   switch(dataAction)
		   {
		   case 'close':
		   case 'open-close':
			   ps = dataActionTarget.parents('.comment');
			   if (ps.length > 0)
			   {
				   $(ps[0]).toggleClass('open'); 
			   }	
			   break;
		   case 'reply':
		   case 'reply-with-citation':
			   this._onOpenSubmissionForm();
			   ps = dataActionTarget.parents('.comment-wrapper');
			   if (ps.length > 0)
			   {
				   this._startReply($(ps[0]).attr('id'), dataAction == 'reply-with-citation' ? true : false); 
			   }	
			   break;

		   case 'edit':
			   this._onOpenSubmissionForm();
			   ps = dataActionTarget.parents('.comment-wrapper');
			   if (ps.length > 0)
			   {
				   this._startModify($(ps[0]).attr('id')); 
			   }	
			   break;
			   
			default:
				console.log("Data Action: ", dataAction);		
		   }
		}

		return true;
	},
	
	_startReply: function(aPostId, includeCitation)
	{				
		var threadNodeId = aPostId.substring(4);
		console.log("Start Reply: ", aPostId, threadNodeId, includeCitation);				
		
		var dtoAdapter = this.bbsThreadNodesDTOAdapter.findItem(threadNodeId);
		if (dtoAdapter)
		{
			$('#bbsthreadportletviewactionform_nodeparentid').val(dtoAdapter.dataBean.threadnodeid);
			
			var nt = "Re: " + dtoAdapter.dataBean.nodetitle;
			if (nt.length > 80)
				nt = nt.substring(0, nt.length);
			
			$('#bbsthreadportletviewactionform_nodetitle').val(nt);
			if (includeCitation)
			{
				$('#bbsthreadportletviewactionform_nodetext').val('[quote]' + dtoAdapter.dataBean.nodetext + '[/quote].');	
			}
			else 	$('#bbsthreadportletviewactionform_nodetext').val('');			
		}
		else this._resetPostForm();
		
		// Sembra non funzionare...
		// $('#bbsthreadportletviewactionform_nodetext').ckeditor('focus');
		location.href = '#bbsthreadportletviewactionform_anchor';
		for ( instance in CKEDITOR.instances )
            CKEDITOR.instances[instance].focus();
	},
	
	_startModify: function(aPostId)
	{				
		var threadNodeId = aPostId.substring(4);
		console.log("Start Modify: ", aPostId, threadNodeId);				
		
		var dtoAdapter = this.bbsThreadNodesDTOAdapter.findItem(threadNodeId);
		if (dtoAdapter)
		{
			$('#bbsthreadportletviewactionform_threadnodeid').val(dtoAdapter.dataBean.threadnodeid);
			$('#bbsthreadportletviewactionform_nodeparentid').val(dtoAdapter.dataBean.nodeparentid);
			
			this.threadProfile.initializeForm(dtoAdapter);								
		}
		else this._resetPostForm();
		
		location.href = '#bbsthreadportletviewactionform_anchor';
		
		// Sembra non funzionare...
		// $('#bbsthreadportletviewactionform_nodetext').ckeditor('focus');
		if (this.hasCkEditorField)
		{		
			for ( instance in CKEDITOR.instances )
				CKEDITOR.instances[instance].focus();		
		}

	},
	
	_updatePost: function(aBBSTopic, aBBSThread, aPost)
	{
		var thnode_info = $('#thn_' + aPost.dataBean.threadnodeid + ' > .comment > .info');
		thnode_info.html(this.threadProfile.postInfoRenderer(aBBSTopic, aBBSThread, aPost));
		
		var thnode_content = $('#thn_' + aPost.dataBean.threadnodeid + ' > .comment > .content');
		thnode_content.html(this.threadProfile.postContentRenderer(aBBSTopic, aBBSThread, aPost));
	},
	
	_appendPost: function(aBBSTopic, aBBSThread, aPost, appendMode)
	{
//		var nodetextAsHtml = XBBCODE.process({
//		    text: aPost.dataBean.nodetext,
//		    removeMisalignedTags: false,
//		    addInLineBreaks: true
//		});
//		
//		var templatedHtml = tmpl('template-bbsthreadportletviewactionform', { 
//			 "topic": aBBSTopic,
//			 "thread": aBBSThread,
//			 "post": aPost,
//			 "nodetextashtml": nodetextAsHtml.html,
//			 "options": this.configProfile || {}
//	    });
    	
		var renderedPost = this.threadProfile.postRenderer(aBBSTopic, aBBSThread, aPost);
    	$('#bbsthreadportletviewactionform_threadposts_cnt').append(renderedPost); 		
	},
	
	_resetPostForm: function()
	{
		console.log("Fields: ", $('#bbsthreadportletviewactionform_form input'));
		
		$('#bbsthreadportletviewactionform_form')[0].reset();
		
		// Il campo ckeditor non lo resetta. Gli altri sembra di si'.
		$('#bbsthreadportletviewactionform_nodetext').val('');
		
//			
//		$('#bbsthreadportletviewactionform_nodetitle').val('');	
//		$('#bbsthreadportletviewactionform_nodeparentid').val('');
//		$('#bbsthreadportletviewactionform_threadnodeid').val('');
	},
	
	_onSaveItem : function()
	{
		var _self = this;
		
		var threadNodeId = $('#bbsthreadportletviewactionform_threadnodeid').val();
		
		var theForm = $('#bbsthreadportletviewactionform_form');
		
		if (theForm.valid())
		{		
			if (this.hasCkEditorField)
			{
			   if (!this._validateCKEditorField())	
				   return ;
			}
			
	    	this.threadProfile.serializePost();
		    
		if (org.r3.PageManager.confirmation("org.r3.message.saveconfirm"))
		{
			var topicId = this.bbsTopicDTOAdapter.dataBean.topicid;
			var threadId = this.bbsThreadDTOAdapter.dataBean.threadid;

			var method = null;
			var restUrl = null;
			if (threadNodeId)
			{				
				restUrl = org.r3.PageManager.getRESTUrl('PUT_BBSThreadNode', [ topicId, threadId, threadNodeId ]);
				method = "put";
			}
			else
			{
				restUrl = org.r3.PageManager.getRESTUrl('POST_BBSThreadNode', [ topicId, threadId ]);
				method = "post";
			}
			
			org.r3.PageManager.wait("org.r3.message.waiting");
			theForm.ajaxSubmit(
			{
				"type" : method,
				"url" : restUrl,
				"dataType" : "json",
				"success" : function(responseData)
				{
					org.r3.PageManager.closeNotifier();					
					
					var threadNodeDataBean = new org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewDTOAdapter(responseData);
					
					var thnode = $('#thn_' + threadNodeDataBean.dataBean.threadnodeid);
					if (thnode.length)
					{
						_self.bbsThreadNodesDTOAdapter.replaceItem(threadNodeDataBean.dataBean.threadnodeid, threadNodeDataBean);
						_self._updatePost(_self.bbsTopicDTOAdapte, _self.bbsThreadDTOAdapter, threadNodeDataBean);
					}
					else
					{
						_self.bbsThreadNodesDTOAdapter.addItem(threadNodeDataBean);
						_self._showNumberOfComments(_self.bbsThreadNodesDTOAdapter.getNumberOfItems());
						
						_self._appendPost(_self.bbsTopicDTOAdapte, _self.bbsThreadDTOAdapter, threadNodeDataBean);						
					}
					
					_self._closeSubmissionForm();
					_self._resetPostForm();					
				},
				
				"error": function(jqXHR, timeout, message)
				{
					console.log(arguments);
					org.r3.PageManager.closeNotifier();
					$('#bbsthreadportletviewactionform_fieldset_message').formmessage('setText', { text: message, category: 'error' });
				}
			});
		}
		}
	},
	
	_validateCKEditorField: function()
	{
		var postText = $('#bbsthreadportletviewactionform_nodetext').val();
		if (!postText)
		{
			org.r3.PageManager.alert("org.r3.jsportlet.bbs.message.bbsPostIsEmpty");
			return false;			
		}
		
		if (postText.length > 80)
		{
			org.r3.PageManager.alert("org.r3.jsportlet.bbs.message.bbsPostTextMaxLength");
			return false;
		}
		
		return true;
	}

});

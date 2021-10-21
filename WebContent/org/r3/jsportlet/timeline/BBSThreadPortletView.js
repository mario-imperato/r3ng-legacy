$.r3Utils.namespace("org.r3.jsportlet.timeline");


org.r3.jsportlet.timeline.BBSThreadPortletView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		
		this.bbsTopicDTOAdapter = null;
		this.bbsThreadDTOAdapter = null;
		this.bbsThreadNodesDTOAdapter = {};
		
		this.profiles = [ 'crewask', 'crewoffer', 'tweet' ];
		
		this.primaryProfileId = null;
		this.childProfileId = 'tweet';
				
		this.profileObjects = {};
				
		this.inputContext = 
		{
			mode: 'none',
			targetObj: null
			
//			postid: null,
//			startTweetButton: null,
//			tweetFormWrapper: null
		};
		
		this.fetchPostInfo = 
		{
			keepLoading : false,
			loadingInProgress : false,
			lastPrimaryPostLoaded: null,
			pageSize: 20
		};
		
	},

	close : function()
	{
		this.hide();
	},

	_getProfile: function(aProfileId)
	{
		return this.profileObjects[aProfileId];
	},
	
	_instantiateProfile: function(aProfile)
	{
		 if (!aProfile)
			 return;

		 var p = new org.r3.jsportlet.timeline.tweet_BBSThreadNode_Profile();
		 		 		 
		 switch(aProfile)
		 {
		 case 'crewask':
			 p = new org.r3.jsportlet.timeline.crewask_BBSThreadNode_Profile();
			 break;
		 case 'crewoffer':
			 p = new org.r3.jsportlet.timeline.crewoffer_BBSThreadDTO_Profile();
			 break;
		 }
		 
		 this.profileObjects[aProfile] = p;
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
			url : org.r3.PageManager.getRESTUrl("GET_ThreadTimeline", [ aBBSTopicId, aBBSThreadId, this.fetchPostInfo.pageSize + '', "" ]),
			dataType : "json"
		});
		
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/timeline/BBSThreadPortletView.html.jsp'),
			dataType : "html"
		});

		this.profiles.forEach(function(item) 
		{ 		
			_self._instantiateProfile(item);
			
			networkRequestsQueue.push(
			{
				id : item + "_view",
				type : "Get",
				url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/timeline/' + item + '_BBSThreadPortletView_FormTemplate.html.jsp'),
				dataType : "html"
			});			
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

			this.primaryProfileId = this.bbsThreadDTOAdapter.dataBean.threadprofile;
			this.childProfileId = 'tweet';
			
//			var bbsThreadNodesDTOAdapter = responseData['bbsthreadnodes'];
//			if (bbsThreadNodesDTOAdapter)
//			{
//				this.bbsThreadNodesDTOAdapter = new org.r3.db.DTOTableAdapter(bbsThreadNodesDTOAdapter, 
//						function(aRowDataBean) { return new org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewDTOAdapter(aRowDataBean); });						
//			}						
 		    
 		    $(this.htmlContainerId).html(tmpl(responseData['view'], { threadProfile: this._getProfile(this.primaryProfileId) })); 	
 		    $('#bbsthreadportletviewactionform_threadtitle').html(this.bbsThreadDTOAdapter.dataBean.threadtitle);

 		    this._getProfile(this.primaryProfileId).onOpenActionFormView(responseData);
 		    this._getProfile(this.childProfileId).onOpenActionFormView(responseData);
 		    		   		
 		    this._processPageOfPosts(responseData['bbsthreadnodes']); 		     		    
          		    		     		     		    
 		    // this._showNumberOfComments(this.bbsThreadNodesDTOAdapter.getNumberOfItems());
 		    		    			 		   		    
 		    $('#bbsthreadportletviewactionform_threadposts_cnt').unbind().click(
					$.r3Utils.hitch(this, this._onClickHandler)); 		    		   

 		    $('#jsportlettimelineform_newprimarypost_canvas').unbind().click(
					$.r3Utils.hitch(this, this._onClickHandler)); 		    		   
 		     		   
 		    if (org.r3.PageManager.userInfo.isGuest())
 		    {
 		    	$('#jsportlettimelineform_newprimarypost_actionbar').hide();
 		    }
 		    else 
 		    {
 		    	$('#jsportlettimelineform_newprimarypost_action').unbind().click(
 						$.r3Utils.hitch(this, this._onOpenPrimaryPostForm));
 		    }
 		    
			this.show();		
			
			if (this.fetchPostInfo.keepLoading)
			   org.r3.PageManager.setScrollToBottomCallback($.r3Utils.hitch(this, this._onLoadMorePostsOnScroll));
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
//	_showNumberOfComments: function(numberOfPosts)
//	{
//		var m = numberOfPosts + ' ' + this._getProfile(this.primaryProfileId).getLabels().multiplePosts;
//		if (numberOfPosts == 1)
//			m = numberOfPosts + ' ' + this._getProfile(this.primaryProfileId).getLabels().singlePost;
//		
//		$('#bbsthreadportletviewactionform_threadposts_summary').html(m);
//	},
	
	_onLoadMorePostsOnScroll: function()
	{
		if (this.fetchPostInfo.loadingInProgress || !this.fetchPostInfo.keepLoading)	
			  return ;
		
		this.fetchPostInfo.loadingInProgress = true;
		$('#loadMoreContentProgress').show();
		
		this._loadTimelinePage(this.bbsTopicDTOAdapter, this.bbsThreadDTOAdapter, this.fetchPostInfo.pageSize, this.fetchPostInfo.lastPrimaryPostLoaded);
	},
	
	_loadTimelinePage: function(aBBSTopic, aBBSThread, aPageSize, upperTimelinePostId)
	{		
		var topicId = this.bbsTopicDTOAdapter.dataBean.topicid;
		var threadId = this.bbsThreadDTOAdapter.dataBean.threadid;
		
		var resolvedUrl = org.r3.PageManager.getRESTUrl("GET_ThreadTimeline", [ topicId, threadId, aPageSize, upperTimelinePostId ]);
			
		org.r3.AjaxUtils.ajaxInvoke(
			
			"GET", 
			resolvedUrl, 
			
			$.r3Utils.hitch(this, function(responseData)
			{
				this._resetInputContext();				
				this._processPageOfPosts(responseData);
				this.fetchPostInfo.loadingInProgress = false;	
				$('#loadMoreContentProgress').hide();
			}),
			
			function(jqXHR, timeout, message)
			{
				console.log(arguments);	
				$('#loadMoreContentProgress').hide();
				this.fetchPostInfo.loadingInProgress = false;	
			}
		);				
	},
	
	_processPageOfPosts: function(aPagePosts)
	{
		var numberOfPrimaryPosts = 0;
		var lastPrimaryPost = null;
		
		if (aPagePosts && aPagePosts.aaData && aPagePosts.aaData.length > 0)
		{
			$.each(aPagePosts.aaData, $.r3Utils.hitch(this, function(entryIndex, aRowDataBean)
			{
				var dtoAdapter = new org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewDTOAdapter(aRowDataBean);
				if (!dtoAdapter.dataBean.nodeparentid)
				{
					lastPrimaryPost = dtoAdapter.dataBean.threadnodeid;		
					numberOfPrimaryPosts ++;
				}
				this.bbsThreadNodesDTOAdapter[dtoAdapter.dataBean.threadnodeid] = dtoAdapter;
				this._appendPost(this.bbsTopicDTOAdapter, this.bbsThreadDTOAdapter, dtoAdapter);
			}));
		}	
		
		if (numberOfPrimaryPosts < this.fetchPostInfo.pageSize)
		{
			this.fetchPostInfo.keepLoading = false;
			this.fetchPostInfo.lastPrimaryPostLoaded = null;	
		}
		else
		{
			this.fetchPostInfo.keepLoading = true;
			this.fetchPostInfo.lastPrimaryPostLoaded = lastPrimaryPost;			
		}		
	},
	
	_appendPost: function(aBBSTopic, aBBSThread, aPost, appendMode)
	{
		var tp = this._getProfile(aPost.dataBean.nodetype);		
		
		var renderedPost = tp.postRenderer(aBBSTopic, aBBSThread, aPost);
		
		if (aPost.dataBean.nodeparentid)
		{
			if (appendMode)
			       $('#thn_' + aPost.dataBean.nodeparentid + '_childlist').prepend('<li>' + renderedPost + '</li>');
			else 
				   $('#thn_' + aPost.dataBean.nodeparentid + '_childlist').append('<li>' + renderedPost + '</li>');
		}
		else
		{
			if (appendMode)
			   $('#bbsthreadportletviewactionform_threadposts_cnt').prepend(renderedPost); 			
			else
			   $('#bbsthreadportletviewactionform_threadposts_cnt').append(renderedPost); 
		}
    },
    
	_updatePost: function(aBBSTopic, aBBSThread, aPost)
	{
		var thnode_info = $('#thn_' + aPost.dataBean.threadnodeid + ' > .panel-heading > .date ');
		thnode_info.html(aPost.getCreationDateAsBadge());
		
		var thnode_info = $('#thn_' + aPost.dataBean.threadnodeid + ' > .panel-heading > .moment ');
		thnode_info.html(aPost.getCreationdateAsElapsed());
		
		var thnode_content = $('#thn_' + aPost.dataBean.threadnodeid + '_postcontent');
		
		var tp = this._getProfile(aPost.dataBean.nodetype);	
		
		thnode_content.html(tp.postContentRenderer(aBBSTopic, aBBSThread, aPost));
	},
	
	_updateThreadNodesList: function(threadNodeDataBean)
	{
		var thnode = $('#thn_' + threadNodeDataBean.dataBean.threadnodeid);
		if (thnode.length)
		{
			this.bbsThreadNodesDTOAdapter[threadNodeDataBean.dataBean.threadnodeid] = threadNodeDataBean;
			this._updatePost(this.bbsTopicDTOAdapter, this.bbsThreadDTOAdapter, threadNodeDataBean);
		}
		else
		{
			this.bbsThreadNodesDTOAdapter[threadNodeDataBean.dataBean.threadnodeid] = threadNodeDataBean;
			// this._showNumberOfComments(this.bbsThreadNodesDTOAdapter.getNumberOfItems());
			
			this._appendPost(this.bbsTopicDTOAdapter, this.bbsThreadDTOAdapter, threadNodeDataBean, true);						
		}
	},
	
	_resetInputContext: function()
	{
//		if (!this.inputContext.tweetFormWrapper)
//			this.inputContext.tweetFormWrapper = $('#jsportlettimelinetweetform_wrapper');
		
	    switch(this.inputContext.mode)	
	    {
	    case 'none':
	    	break;
	    	
	    case 'newprimarypost':
	    	$('#jsportlettimelineform_newprimarypost_canvas').hide();
			$('#jsportlettimelineform_newprimarypost_actionbar').show();
			this._getProfile(this.primaryProfileId).resetForm();
	    	break;
	    	
	    case 'editprimarypost':
	    	$('#thn_' + this.inputContext.targetObj.dataBean.threadnodeid + '_editcanvas  > div').appendTo($('#jsportlettimelineform_primarypost_formtemplate'));
			$('#thn_' + this.inputContext.targetObj.dataBean.threadnodeid + '_postcontent').show();	
			
			// In questo caso il bottone potrebbe semplicemente mancare in quanto dovrebbe essere presente solamente in caso di permessi corretti e post di tipo primary.
			$('#thn_' + this.inputContext.targetObj.dataBean.threadnodeid + ' button[data-action="new-child"]').show();
			this._getProfile(this.primaryProfileId).resetForm();
	    	break;
	    	
		case 'newchild':
			$('#thn_' + this.inputContext.targetObj.dataBean.threadnodeid + '_newchildcanvas > div').appendTo($('#jsportlettimelineform_childpost_formtemplate'));
			$('#thn_' + this.inputContext.targetObj.dataBean.threadnodeid + ' button[data-action="new-child"]').show();
			this._getProfile(this.childProfileId).resetForm();
			break;	    	
	    	
		case 'editchild':
			$('#thn_' + this.inputContext.targetObj.dataBean.threadnodeid + '_editcanvas > div').appendTo($('#jsportlettimelineform_childpost_formtemplate'));
			$('#thn_' + this.inputContext.targetObj.dataBean.threadnodeid + '_postcontent').show();	
			
			$('#thn_' + this.inputContext.targetObj.dataBean.threadnodeid + ' button[data-action="new-child"]').show();
			this._getProfile(this.childProfileId).resetForm();
			break;
			
	    }
	    
	    this.inputContext.mode = 'none';
	    this.inputContext.targetObj = null;
//	    this.inputContext.postid = null;
//	    this.inputContext.startTweetButton = null;
	    
	},
	
	_setInputContext: function(aNewMode, aTargetNodeDTOAdapter)
	{
		this._resetInputContext();
		
		this.inputContext.mode = aNewMode;
		this.inputContext.targetObj = aTargetNodeDTOAdapter;
		
		switch(aNewMode)
		{
		case 'newprimarypost':
			$('#jsportlettimelineform_newprimarypost_canvas').show();
			$('#jsportlettimelineform_newprimarypost_actionbar').hide();			
			break;
			
		case 'editprimarypost':
			$('#jsportlettimelineform_primarypost_formtemplate > div').appendTo($('#thn_' + aTargetNodeDTOAdapter.dataBean.threadnodeid + '_editcanvas'));
			$('#thn_' + aTargetNodeDTOAdapter.dataBean.threadnodeid + '_postcontent').hide();
			$('#thn_' + aTargetNodeDTOAdapter.dataBean.threadnodeid + ' button[data-action="new-child"]').hide();				
			this._getProfile(this.primaryProfileId).initializeForm(aTargetNodeDTOAdapter);
			break;
			
		case 'newchild':
			$('#jsportlettimelineform_childpost_formtemplate > div').appendTo($('#thn_' + aTargetNodeDTOAdapter.dataBean.threadnodeid + '_newchildcanvas'));
			$('#thn_' + aTargetNodeDTOAdapter.dataBean.threadnodeid + ' button[data-action="new-child"]').hide();
			this._getProfile(this.childProfileId).initializeForm(aTargetNodeDTOAdapter.dataBean.threadnodeid);
			break;
			
		case 'editchild':
			$('#jsportlettimelineform_childpost_formtemplate > div').appendTo($('#thn_' + aTargetNodeDTOAdapter.dataBean.threadnodeid + '_editcanvas'));
			$('#thn_' + aTargetNodeDTOAdapter.dataBean.threadnodeid + '_postcontent').hide();
			$('#thn_' + aTargetNodeDTOAdapter.dataBean.threadnodeid + ' button[data-action="new-child"]').hide();
			this._getProfile(this.childProfileId).initializeForm(aTargetNodeDTOAdapter);
			break;			
			
		}
	},
	
//	_onCancelSubmission: function()
//	{
//		this._closeSubmissionForm();
//		this._resetPostForm();
//	},
	
	_onOpenPrimaryPostForm: function()
	{

		this._setInputContext('newprimarypost');				
	},

//	_closeSubmissionForm: function()
//	{
//		$('#bbsthreadportletviewactionform_form_canvas').hide();
//		$('#bbsthreadportletviewactionform_action_startnew_actionbar').show();		
//	},

	_extractPostId: function(anId)
	{		
		if (anId && anId.substring(0, 4) == 'thn_')
			anId = anId.substring(4);
		
		return anId;
	},
	
	_onClickHandler: function(e)
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
		   case 'tweet-cancel':
			   this._resetInputContext();
			   break;
		   
		   case 'crewoffer-cancel':
			   this._resetInputContext();
			   break;

		   case 'crewask-cancel':
			   this._resetInputContext();
			   break;
			   
		   case 'crewask-submit':
			   this._onSubmit('crewask');
			   break;
		   
		   case 'crewoffer-submit':
			   this._onSubmit('crewoffer');
			   break;

		   case 'tweet-submit':
			   this._onSubmit('tweet');
			   break;
			   
		   case 'edit-primary':			   
			   ps = dataActionTarget.parents('.timelinepost');
			   if (ps.length > 0)
			   {
				   var dtoAdapter = this.bbsThreadNodesDTOAdapter[this._extractPostId($(ps[0]).attr('id'))];
				   this._setInputContext('editprimarypost', dtoAdapter); 
			   }	
			   break;
			   
		   case 'delete':			
			   this._resetInputContext();
			   ps = dataActionTarget.parents('.timelinepost');
			   if (ps.length > 0)
			   {
				   this._doDelete(ps); 
			   }	
			   break;
			   
		   case 'new-child':
			   ps = dataActionTarget.parents('.timelinepost');
			   if (ps.length > 0)
			   {
				   var dtoAdapter = this.bbsThreadNodesDTOAdapter[this._extractPostId($(ps[0]).attr('id'))];
				   this._setInputContext('newchild', dtoAdapter); 
			   }	
			   break;  
			   
		   case 'edit-child':
			   ps = dataActionTarget.parents('.timelinepost');
			   if (ps.length > 0)
			   {
				   var dtoAdapter = this.bbsThreadNodesDTOAdapter[this._extractPostId($(ps[0]).attr('id'))];
				   this._setInputContext('editchild', dtoAdapter); 
			   }	
			   break;  			   
			           			   			   
			default:
				console.log("Data Action: ", dataAction);		
		   }
		}

		return true;
	},
	

	
//	_startTweeting: function(triggeringWidget, timeLinePostObject)
//	{
//		var aPostId = $(timeLinePostObject[0]).attr('id');
//		if (aPostId)
//			aPostId = aPostId.substring(4);
//				
//		
//				
//		this.inputContext.inputMode = 'newtweet';
//		this.inputContext.startTweetButton = triggeringWidget;
//		this.inputContext.postid = aPostId;
//		
//		triggeringWidget.hide();
//		
//		this.inputContext.tweetFormWrapper.appendTo($('#thn_' + aPostId + '_newtweetcanvas'));	
//		$('#jsportlettimelinetweetform_nodeparentid').val(aPostId);
//		$('#jsportlettimelinetweetform_threadnodeid').val(null);
//		$('#jsportlettimelinetweetform_nodetext').val(null);
//		$('#jsportlettimelinetweetform_wrapper').show();
//	},

//	_startEditingTweet: function(timeLinePostObject)
//	{
//		var aPostId = $(timeLinePostObject[0]).attr('id');
//		if (aPostId)
//			aPostId = aPostId.substring(4);
//							
//		this.inputContext.inputMode = 'edittweet';
//		this.inputContext.postid = aPostId;
//		
//		$('#thn_' + aPostId + '_postcontent').hide();	
//		
//		this.inputContext.tweetFormWrapper.appendTo($('#thn_' + aPostId + '_postcanvas'));	
//		$('#jsportlettimelinetweetform_threadnodeid').val(aPostId);
//		
//		var dtoAdapter = this.bbsThreadNodesDTOAdapter.findItem(aPostId);
//		if (dtoAdapter)
//		{
//			$('#jsportlettimelinetweetform_nodeparentid').val(dtoAdapter.dataBean.nodeparentid);
//			$('#jsportlettimelinetweetform_nodetext').val(dtoAdapter.dataBean.nodetext);
//		}
//		else
//		{
//			$('#jsportlettimelinetweetform_nodeparentid').val(null);
//			$('#jsportlettimelinetweetform_nodetext').val(null);				
//		}
//		
//		$('#jsportlettimelinetweetform_wrapper').show();
//	},
	
//	_cancelTweeting: function()
//	{
//		$('#jsportlettimelinetweetform_nodeparentid').val(null);
//		$('#jsportlettimelinetweetform_threadnodeid').val(null);
//	},
	
//	_onTweetSubmit: function()
//	{
//		var _self = this;
//		
//		var threadNodeId = $('#jsportlettimelinetweetform_threadnodeid').val();
//		var pthn = $('#jsportlettimelinetweetform_nodeparentid').val();
//		
//		var topicId = this.bbsTopicDTOAdapter.dataBean.topicid;
//		var threadId = this.bbsThreadDTOAdapter.dataBean.threadid;
//		
//		var method = null;
//		var restUrl = null;
//		if (threadNodeId)
//		{				
//			restUrl = org.r3.PageManager.getRESTUrl('PUT_BBSThreadNode', [ topicId, threadId, threadNodeId ]);
//			method = "put";
//		}
//		else
//		{
//			restUrl = org.r3.PageManager.getRESTUrl('POST_BBSThreadNode', [ topicId, threadId ]);
//			method = "post";
//		}
//		
//		org.r3.AjaxUtils.submitForm
//		(
//			method, restUrl, $('#jsportlettimelinetweetform_form'),
//			function(responseData) 
//			{
//				var thePost = new org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewDTOAdapter(responseData);
//				_self._clearInput();
//				_self._cancelTweeting();
//				
//				_self._updateThreadNodesList(thePost);
//				// _self._appendPost(_self.bbsTopicDTOAdapter, _self.bbsThreadDTOAdapter, thePost);
//			}, 
//				
//			function(jqXHR, timeout, message)
//			{
//				console.log(arguments);					
//			}
//		);  
//	},
	
	_doDelete: function(aPostWrapperObj)
	{
		var _self = this;
		
		var targetWrapper = $(aPostWrapperObj[0]);
		var aPostId = targetWrapper.attr('id');
		if (aPostId)
			aPostId = aPostId.substring(4);		
							
		var topicId = this.bbsTopicDTOAdapter.dataBean.topicid;
		var threadId = this.bbsThreadDTOAdapter.dataBean.threadid;
		
		org.r3.AjaxUtils.ajaxInvoke(
				'DELETE',
				org.r3.PageManager.getRESTUrl('DELETE_BBSThreadNode', [ topicId, threadId, aPostId ]),
				function(responseData) { targetWrapper.remove(); _self._deleteFromThreadNodesList(aPostId); }, 
				function(jqXHR, timeout, message) {}, 
				false, 
				false);		
	},
	
	_deleteFromThreadNodesList: function(aThreadnodeid)
	{
		this.bbsThreadNodesDTOAdapter[aThreadnodeid] = null;
		// this._showNumberOfComments(this.bbsThreadNodesDTOAdapter.getNumberOfItems());		
	},
	
//	_startModify: function(aPostId)
//	{				
//		var threadNodeId = aPostId.substring(4);
//		console.log("Start Modify: ", aPostId, threadNodeId);				
//		
//		var dtoAdapter = this.bbsThreadNodesDTOAdapter.findItem(threadNodeId);
//		if (dtoAdapter)
//		{
//			$('#bbsthreadportletviewactionform_threadnodeid').val(dtoAdapter.dataBean.threadnodeid);
//			$('#bbsthreadportletviewactionform_nodeparentid').val(dtoAdapter.dataBean.nodeparentid);
//			
//			this.threadProfile.initializeForm(dtoAdapter);								
//		}
//		else this._resetPostForm();
//		
//		location.href = '#bbsthreadportletviewactionform_anchor';
//		
//	},
//	

	

	

	

	
	_onSubmit : function(aProfileId)
	{
		var _self = this;
		var profileObj = this._getProfile(aProfileId);
		
		var threadNodeId = profileObj.getThreadNodeIdFieldValue();		
		var theForm = profileObj.getForm();
		
		if (theForm.valid())
		{		
			
	    	profileObj.serializePost();
		    
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
					_self._updateThreadNodesList(threadNodeDataBean);
										
					_self._resetInputContext();					
				},
				
				"error": function(jqXHR, timeout, message)
				{
					console.log(arguments);
					org.r3.PageManager.closeNotifier();
					profileObj.showMessage({ text: message, category: 'error' });
				}
			});
		}
		}
	}
	

	


});

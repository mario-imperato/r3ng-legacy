$.r3Utils.namespace("org.r3.jsportlet.mongotimeline");

org.r3.jsportlet.mongotimeline.timelineScrollInfo = Class.extend(
{
	init: function(aPageSize)
	{  
    	this.pageSize = aPageSize;
    	this.pageOffset = 0;
    	this.keepLoading = false;
    	this.loadingInProgress = false;
    	
    	this.timelineEventListener = null;
	},
	
	update: function(dataSize)
	{
		if (dataSize < this.pageSize)
		{
			this.keepLoading = false;			
		}
		else
		{
			this.keepLoading = true;
			this.pageOffset += dataSize;
		}	
	},
	
	fixOffsetOnPostAddedDeleted: function(incrementDecrementCount) 
	{
		this.pageOffset += incrementDecrementCount;
	}

});

org.r3.jsportlet.mongotimeline.MapOfPosts = Class.extend(
{
    init: function()
	{  
    	this.theMapOfPosts = {};    	
	},

	addPost: function(aTimelineCollectionDTOAdapter)
	{
		this.theMapOfPosts[aTimelineCollectionDTOAdapter.dataBean.postid] = aTimelineCollectionDTOAdapter;
	},

	getPost: function(aPostId)
	{
		return this.theMapOfPosts[aPostId];
	},

	removePost: function(aPostId)
	{
		this.theMapOfPosts[aPostId] = null;
	},
	
	updatePost: function(aTimelineCollectionDTOAdapter)
	{
		this.theMapOfPosts[aTimelineCollectionDTOAdapter.dataBean.postid] = aTimelineCollectionDTOAdapter;
	},
	
	addOrUpdatePost: function(aTimelineCollectionDTOAdapter)
	{
		this.theMapOfPosts[aTimelineCollectionDTOAdapter.dataBean.postid] = aTimelineCollectionDTOAdapter;
	},
	
	addComment2Post: function(aPostId, aTimelineCommentCollectionDTOAdapter)
	{
		var p = this.getPost(aPostId);
		if (p)
		 return p.addComment(aTimelineCommentCollectionDTOAdapter);
		
		return false;		
	},
	
	updateCommentInPost: function(aPostId, aTimelineCommentCollectionDTOAdapter)
	{
		var p = this.getPost(aPostId);
		if (p)
		 return p.updateComment(aTimelineCommentCollectionDTOAdapter);

		return false;		
	},
	
	addOrUpdateCommentInPost: function(aPostId, aTimelineCommentCollectionDTOAdapter)
	{
		var p = this.getPost(aPostId);
		if (p)
		 return p.addOrUpdateComment(aTimelineCommentCollectionDTOAdapter);
		
		return false;
	},
	
	removeCommentFromPost: function(aPostId, aCommentId)
	{
		var p = this.getPost(aPostId);
		if (p)
		  return p.removeComment(aCommentId);
		
		return false;
	},
	
	getCommentFromPost: function(aPostId, aCommentId)
	{
		var p = this.getPost(aPostId);
		if (p)
		 return p.getComment(aCommentId);
		
		return false;
	}
	
});

org.r3.jsportlet.mongotimeline.TimelineActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);	
		this.timelineParams  = null;
		this.timelineSelector = anHtmlActionFormContainerId;
		this.contentClassForms = null;
		
		$.fn.toggleBox = function () {
			    $.AdminLTE.boxWidget.collapse(this);
	    };
			  
	},

	close : function()
	{
		this.hide();
		
		if (this.timelineEventListener)
		    	this.timelineEventListener.onTimelineEvent({ event: 'close' });
		 
	},

	_getContentClassDefinitionById: function(contentClassDefId)
	{
		var cdefobj = this.contentClassDefinitionDictionary[contentClassDefId];		
		return cdefobj;
	},
	
	_getUserRoleById:function(aRoleId)
	{
		if (this.inputContext && this.inputContext.currentUserEnabledRoles)
		{
			for(var i = 0; i < this.inputContext.currentUserEnabledRoles.listofroles.length; i++)
			{
				if (this.inputContext.currentUserEnabledRoles.listofroles[i].author == aRoleId)
					return this.inputContext.currentUserEnabledRoles.listofroles[i];
			}
		}		
		
		return null;
	},
//	
//	_getProfile: function(aProfileId)
//	{
//		return this.profileObjects[aProfileId];
//	},
//	
//	_instantiateProfile: function(aContentClassConfigObj)
//	{
//		 if (!aContentClassConfigObj)
//			 return;
//
//		 var p = new org.r3.jsportlet.shakeus_timeline.contentclass.tweet_TimelineActionFormView_Profile();
//		 		 		 
//		 switch(aContentClassConfigObj.dataBean.name)
//		 {
//		 case 'crewask':
//			 p = new org.r3.jsportlet.shakeus_timeline.contentclass.crewask_TimelineActionFormView_Profile();
//			 break;
//		 case 'crewoffer':
//			 p = new org.r3.jsportlet.shakeus_timeline.contentclass.crewoffer_TimelineActionFormView_Profile();
//			 break;
//		 case 'shknews':
//			 p = new org.r3.jsportlet.shakeus_timeline.contentclass.shknews_TimelineActionFormView_Profile();
//			 break;	
//		 case 'shkstruct':
//			 p = new org.r3.jsportlet.shakeus_timeline.contentclass.shkstruct_TimelineActionFormView_Profile();
//			 break;				 
//		 case 'shkmessage':
//			 p = new org.r3.jsportlet.shakeus_timeline.contentclass.shkmessage_TimelineActionFormView_Profile();
//			 break;	
//		 case 'shcask':
//			 p = new org.r3.jsportlet.shakeus_timeline.contentclass.shcask_TimelineActionFormView_Profile();
//			 break;					 
//		 case 'shcaskoffer':
//			 p = new org.r3.jsportlet.shakeus_timeline.contentclass.shcaskoffer_TimelineActionFormView_Profile();
//			 break;					 
//		 case 'shcoffer':
//			 p = new org.r3.jsportlet.shakeus_timeline.contentclass.shcoffer_TimelineActionFormView_Profile();
//			 break;					 
//		 case 'shcofferbook':
//			 p = new org.r3.jsportlet.shakeus_timeline.contentclass.shcofferbook_TimelineActionFormView_Profile();
//			 break;					 
//		 }
//		 
//		 p.configure(aContentClassConfigObj);
//		 this.profileObjects[aContentClassConfigObj.dataBean.name] = p;
//		 return p;
//	},
//	

//	
//	_getTimelineConfigurationById: function(aTimelineId)
//	{
//		return this.actionFormManager.getTimelineConfigById(aTimelineId);
//	},
//	
	_getSelector: function(aSelector)
	{
		return $(this.timelineSelector + ' ' + aSelector);
	},
	
	_getEditForm: function(aContentClass)
	{
		var editableContentWrapperId = aContentClass + "_edit_wrapper";
		return $('#' + editableContentWrapperId);
	},
	
	_onOpenInitialization: function()
	{
		//this.timelineCfg = null;
		// this.primaryProfileId = null;
		// this.childProfileId = 'tweet';
		this.mapOfPosts = new org.r3.jsportlet.mongotimeline.MapOfPosts();
		this.contentClassDefinitionDictionary = {};
		
		this.viewPostCanvasTemplate = null;
		this.newPostCanvasTemplate = null;
		this.viewCommentCanvasTemplate = null;
		this.newCommentCanvasTemplate = null;
		
		// this.profileObjects = {};
		
		this.inputContext = 
		{
			mode: 'none',
			targetObj: null,
			currentUserEnabledRoles : null,	
			imageSelectionContext : null
		};
		
		this.fetchPostInfo = new org.r3.jsportlet.mongotimeline.timelineScrollInfo(20);
	},
	
	_getRetrieveURL4PageOfPosts: function(aPageSize, aPageOffset)
	{
		restUrl = $.r3Utils.stringFormat(this.timelineParams.timelineURL, [ aPageSize + '', aPageOffset + '' ]);
		// var r = org.r3.PageManager.getRESTUrl("GET_TimelineOfPosts", [ org.r3.Constants.site, org.r3.Constants.language, aPageSize + '', aPageOffset + '' ]);
		return restUrl;
	},
	
	open : function(aTimelineEventListener, aConfigHash /* aTimelineId */) 
	{
		var _self = this;	
		this.timelineEventListener = aTimelineEventListener;		
		this.timelineParams = aConfigHash;
		
		this._onOpenInitialization();
		
		org.r3.PageManager.wait("org.r3.message.waiting");

		var networkRequestsQueue = [];		
					
		networkRequestsQueue.push(
		{
			id : "timelineposts",
			type : "Get",
			url : this._getRetrieveURL4PageOfPosts(this.fetchPostInfo.pageSize, this.fetchPostInfo.pageOffset),
			dataType : "json"
		});
		
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/mongotimeline/TimelineActionFormView.html.jsp'),
			dataType : "html"
		});

		networkRequestsQueue.push(
		{
			id : "view_viewpostcanvas",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/mongotimeline/TimelineActionFormView_ViewPostCanvas.html.jsp'),
			dataType : "html"
		});
		
		networkRequestsQueue.push(
		{
			id : "view_newpostcanvas",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/mongotimeline/TimelineActionFormView_NewPostCanvas.html.jsp'),
			dataType : "html"
		});
		
		networkRequestsQueue.push(
		{
			id : "view_viewcommentcanvas",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/mongotimeline/TimelineActionFormView_ViewCommentCanvas.html.jsp'),
			dataType : "html"
		});
		
		networkRequestsQueue.push(
		{
			id : "view_newcommentcanvas",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/mongotimeline/TimelineActionFormView_NewCommentCanvas.html.jsp'),
			dataType : "html"
		});
						
		var contentDefLUTUrl = org.r3.PageManager.getRESTUrl('GET_classifier_contentclassdef');
		var contentDefLUT = org.r3.PageManager.lutManager.getLUT(contentDefLUTUrl);
		 
		if (contentDefLUT && contentDefLUT.aaData.length)
		{
		   for(var i = 0; i < contentDefLUT.aaData.length; i++)
		   {			  
			    var contentDefinitionDTOAdapter = new org.r3.db.mongo.contentdefinitioncollection.ContentDefinitionDTOAdapter(contentDefLUT.aaData[i]);
				networkRequestsQueue.push(
				{
					id : contentDefinitionDTOAdapter.dataBean.dtokey + '_edit',
					type : "Get",
					url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + contentDefinitionDTOAdapter.getTimelineEditTemplateURL()),
					dataType : "html"
				});	
						
				networkRequestsQueue.push(
				{
					id : contentDefinitionDTOAdapter.dataBean.dtokey + '_view',
					type : "Get",
					url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + contentDefinitionDTOAdapter.getTimelineViewTemplateURL()),
					dataType : "html"
				});	
				
				this.contentClassDefinitionDictionary[contentDefinitionDTOAdapter.dataBean.dtokey] = contentDefinitionDTOAdapter;
		   }       				   			   
		}	
		   				
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();

 		    $(this.htmlContainerId).html(tmpl(responseData['view'], {  }));
 		    
 		    this.contentClassForms = this._getSelector(' .mongotimeline_edit_content');
  		   
 		    this.viewPostCanvasTemplate = responseData['view_viewpostcanvas'];
 		    this.newPostCanvasTemplate = responseData['view_newpostcanvas'];
 		    this.viewCommentCanvasTemplate = responseData['view_viewcommentcanvas'];
 		    this.newCommentCanvasTemplate = responseData['view_newcommentcanvas'];
 		    
 			if (contentDefLUT && contentDefLUT.aaData.length)
 			{
 			   for(var i = 0; i < contentDefLUT.aaData.length; i++)
 			   {
 				  var cdefobj = _self.contentClassDefinitionDictionary[contentDefLUT.aaData[i].dtokey];
 				  this.contentClassForms.append(tmpl(responseData[cdefobj.dataBean.dtokey + '_edit'], { contentDefinitionDTOAdapter : cdefobj }));
 				  cdefobj.setViewTemplate(responseData[cdefobj.dataBean.dtokey + '_view']);
 				  cdefobj.initializeModelObject();
 			   }
 			}
 			
 			this._processPageOfPosts(responseData['timelineposts']);
 			
 		    this._getSelector(' .mongotimeline_posts_cnt').unbind().click(
					$.r3Utils.hitch(this, this._onClickHandler));
 		    
 		   this._getSelector(' .mongotimeline_newpost_canvas').unbind().click(
					$.r3Utils.hitch(this, this._onClickHandler)); 
 		    
			this.show();	
			
			if (this.fetchPostInfo.keepLoading)
				   org.r3.PageManager.setScrollToBottomCallback($.r3Utils.hitch(this, this._onLoadMorePostsOnScroll));
			
			this.fileUploader = new org.r3.jsportlet.imageupload.FileUploader(
			{
				inputfile_selector: '#mongotimeline_input_file'				
 			});
												
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});

	},
	
	_onLoadMorePostsOnScroll: function()
	{
		if (this.fetchPostInfo.loadingInProgress || !this.fetchPostInfo.keepLoading)	
			  return ;
		
		this.fetchPostInfo.loadingInProgress = true;
		this._getSelector(' .mongotimeline_loadmorecontentprogress').show();
		
		this._loadPageOfPosts(this.fetchPostInfo.pageSize, this.fetchPostInfo.pageOffset);
	},
	
	_loadPageOfPosts: function(aPageSize, anOffset)
	{				
		var resolvedUrl =  this._getRetrieveURL4PageOfPosts(aPageSize, anOffset);
			
		org.r3.AjaxUtils.ajaxInvoke(
			
			"GET", 
			resolvedUrl, 
			
			$.r3Utils.hitch(this, function(responseData)
			{
				this._resetInputContext();				
				this._processPageOfPosts(responseData);
				this.fetchPostInfo.loadingInProgress = false;	
				this._getSelector(' .mongotimeline_loadmorecontentprogress').hide();
			}),
			
			$.r3Utils.hitch(this, function(jqXHR, timeout, message)
			{
				console.log(arguments);	
				this._getSelector(' .mongotimeline_loadmorecontentprogress').hide();
				this.fetchPostInfo.loadingInProgress = false;	
			})
		);				
	},

	_processPageOfPosts: function(aPagePosts)
	{
		var numberOfPrimaryPosts = 0;
		var lastPrimaryPost = null;
		
		if (aPagePosts && aPagePosts.aaData && aPagePosts.aaData.length > 0)
		{
			this.fetchPostInfo.update(aPagePosts.aaData.length);
			
			$.each(aPagePosts.aaData, $.r3Utils.hitch(this, function(entryIndex, aRowDataBean)
			{
				var dtoAdapter = new org.r3.db.mongo.postcollection.PostCollectionDTOAdapter(aRowDataBean);
				if (!dtoAdapter.dataBean.parentpostid)
				{
					lastPrimaryPost = dtoAdapter.dataBean.postid;		
					numberOfPrimaryPosts ++;
				}
				
				this.mapOfPosts.addPost(dtoAdapter);
				this._appendPost(dtoAdapter, false);
				
				if (dtoAdapter.hasComments())
				{
				    for(var j = 0; j < dtoAdapter.dataBean.comments.length; j++)
				    {
				    	var commentDtoAdapter = new org.r3.db.mongo.postcommentcollection.PostCommentCollectionDTOAdapter(dtoAdapter.dataBean.comments[j]);
				    	commentDtoAdapter.setTimelinePostid(dtoAdapter.dataBean.timeline, dtoAdapter.dataBean.postid);
				    	this._appendComment(dtoAdapter, commentDtoAdapter, true);
				    }
				}
			}));
		}	
			
	},
	
	_appendPost: function(aPost, appendMode)
	{
		var tp = this._getContentClassDefinitionById(aPost.dataBean.contentclass);		
		
		var postCanvasHtml = tmpl(this.viewPostCanvasTemplate, { post : aPost, contentClassObj : tp });
		var renderedPost = tp.applyViewTemplate(aPost);
		
		if (aPost.dataBean.parentpostid)
		{
			if (appendMode)
			       $('#post_' + aPost.dataBean.parentpostid + '_childlist').prepend('<li>' + renderedPost + '</li>');
			else 
				   $('#post_' + aPost.dataBean.parentpostid + '_childlist').append('<li>' + renderedPost + '</li>');
		}
		else
		{
			if (appendMode)
				this._getSelector(' .mongotimeline_posts_cnt').prepend(postCanvasHtml); 			
			else
				this._getSelector(' .mongotimeline_posts_cnt').append(postCanvasHtml); 
			
			$("#post_" + aPost.dataBean.postid + "_viewcanvas").html(renderedPost);
				
		}
    },
    
	_updatePost: function(aPost)
	{
		// In questo momento non sto aggiornando le informazioni di header.
		var thnode_info = $('#post_' + aPost.dataBean.postid + ' .user-block > .description ');		
		var thnode_content = $('#post_' + aPost.dataBean.postid + '_viewcanvas');
		
		var tp = this._getContentClassDefinitionById(aPost.dataBean.contentclass);	
		
		thnode_info.html(aPost.getCreationDateAsBadge() + ' - ' + 
				aPost.getCreationdateAsElapsed() + ' - ' + aPost.dataBean.title);
		thnode_content.html(tp.applyViewTemplate(aPost));
	},
	
	_appendComment: function(aPost, aComment, prependMode)
	{
		var tp = this._getContentClassDefinitionById(aComment.dataBean.contentclass);		
		
		var postCanvasHtml = tmpl(this.viewCommentCanvasTemplate, { post : aPost, comment : aComment, contentClassObj : tp  });
		var renderedPost = tp.applyViewTemplate(aComment);
				
		var postCommentCanvas = $("#post_" + aComment.dataBean.postid + " .comments-canvas");
		
		if (prependMode)
			postCommentCanvas.prepend(postCanvasHtml); 			
		else
			postCommentCanvas.append(postCanvasHtml); 
		
		postCommentCanvas.find("#comm_" + aComment.dataBean.commentid + " .comment-content-viewcanvas").html(renderedPost);
				
    },
    
	_replaceComment: function(aPost, aComment)
	{
		var tp = this._getContentClassDefinitionById(aComment.dataBean.contentclass);		
		
		var postCanvasHtml = tmpl(this.viewCommentCanvasTemplate, { post : aPost, comment : aComment, contentClassObj : tp  });
		var renderedPost = tp.applyViewTemplate(aComment);
				
		var postCommentCanvas = $("#comm_" + aComment.dataBean.commentid);
		postCommentCanvas.replaceWith(postCanvasHtml);
		
		$("#comm_" + aComment.dataBean.commentid + " .comment-content-viewcanvas").html(renderedPost);
				
    },
    
    _updateComment: function(aComment)
	{
		var tp = this._getContentClassDefinitionById(aComment.dataBean.contentclass);	
    	var renderedPost = tp.applyViewTemplate(aComment);
    	
    	var commentDOMNode = $("#comm_" + aComment.dataBean.commentid);
    	commentDOMNode.find(".comment-content-viewcanvas").html(renderedPost);
    	commentDOMNode.find(".authorname").html(aComment.dataBean.authorname);
    	commentDOMNode.find(".lastmodified").html(aComment.getCreationDateAsBadge() + ' - ' + aComment.getCreationdateAsElapsed());
	},
	
	_resetInputContext: function()
	{
		
	    switch(this.inputContext.mode)	
	    {
	    case 'none':
	    	break;
	    	
	    case 'newprimarypost':

	    	this._getSelector(' .mongotimeline_primarypost_content > div').appendTo(this.contentClassForms);
	    	// $('#mongotimeline_primarypost_content > div').appendTo(this.contentClassForms);
	    	// $('#mongotimeline_newpost_canvas > div').hide();
	    	this._getSelector(' .mongotimeline_newpost_canvas > div').hide();
			// $('#mongotimeline_newprimarypost_actionbar').show(); -- Bisogne inserire una notifica al tuner.
	    	this._getContentClassDefinitionById(this.inputContext.contentClass).getModelObject().resetForm();
	    	break;
	    	
	    case 'editprimarypost':
	    	$('#post_' + this.inputContext.targetObj.dataBean.postid + '_editcanvas  > div').appendTo(this.contentClassForms);
			$('#post_' + this.inputContext.targetObj.dataBean.postid + '_viewcanvas').show();
			$('#post_' + this.inputContext.targetObj.dataBean.postid + ' .box-footer').show();	
			$('#post_' + this.inputContext.targetObj.dataBean.postid + ' .box-tools .view-mode').show();
			$('#post_' + this.inputContext.targetObj.dataBean.postid + ' .box-tools .edit-mode').hide();
			this._getContentClassDefinitionById(this.inputContext.targetObj.dataBean.contentclass).getModelObject().resetForm();
	    	break;
	    	
		case 'newchild':
			$('#post_' + this.inputContext.targetObj.dataBean.postid + '_newchildcanvas  .mongotimeline_postcomment_content > div').appendTo(this.contentClassForms);
			// $('#post_' + this.inputContext.targetObj.dataBean.postid + '_newchildcanvas  #mongotimeline_postcomment_content > div').appendTo(this.contentClassForms);
			$('#post_' + this.inputContext.targetObj.dataBean.postid + '_newchildcanvas > div').appendTo(this._getSelector(' .mongotimeline_childpost_canvas'));
			$('#post_' + this.inputContext.targetObj.dataBean.postid + ' .new-child-actionbar').show();
	    	this._getContentClassDefinitionById(this.inputContext.contentClass).getModelObject().resetForm();
			break;	    	
	    	
		case 'editchild':
			$('#comm_' + this.inputContext.targetObj.dataBean.commentid + ' .comment-content-editcanvas > div').appendTo(this.contentClassForms);
			$('#comm_' + this.inputContext.targetObj.dataBean.commentid + ' .comment-content-viewcanvas').show();	
						
			$('#comm_' + this.inputContext.targetObj.dataBean.commentid + '  .view-mode').show();
			$('#comm_' + this.inputContext.targetObj.dataBean.commentid + '  .edit-mode').hide();
			this._getContentClassDefinitionById(this.inputContext.targetObj.dataBean.contentclass).getModelObject().resetForm();
			break;
			
	    }
	    
	    this.inputContext.mode = 'none';
	    this.inputContext.timelineConfig = null;
	    this.inputContext.contentClass = 'none';
	    this.inputContext.targetObj = null;
	    this.inputContext.currentUserEnabledRoles = null;
	    
	    if (this.timelineEventListener)
	    	this.timelineEventListener.onTimelineEvent({ event: this.inputContext.mode });
	    	    	    
	},

	_setInputContext: function(aNewMode, aTimelineid, aProfileId, aTargetNodeDTOAdapter, currentUserEnabledRoles)
	{
		this._resetInputContext();
		
		this.inputContext.mode = aNewMode;

	    if (this.timelineEventListener)
	    	this.timelineEventListener.onTimelineEvent({ event: this.inputContext.mode });

		// if (_.isString(aTimeLineConfiguration_or_timelineId))
		//	aTimeLineConfiguration_or_timelineId = this.actionFormManager.getTimelineConfigById(aTimeLineConfiguration_or_timelineId);
		
		// this.inputContext.timelineConfig = aTimeLineConfiguration_or_timelineId;
		this.inputContext.contentClass = aProfileId;
		this.inputContext.targetObj = aTargetNodeDTOAdapter;
		
		var postViewCanvas = null;
		switch(aNewMode)
		{
		case 'newprimarypost':
			
			this.inputContext.currentUserEnabledRoles = currentUserEnabledRoles;
			
			// In questo contesto conosco il tipo del Post
			this._getSelector(' .mongotimeline_newpost_canvas').html(tmpl(this.newPostCanvasTemplate, { 
				contentClassObj : this._getContentClassDefinitionById(aProfileId),
				currentUserEnabledRoles : this.inputContext.currentUserEnabledRoles
			}));
			
			this._getEditForm(aProfileId).appendTo(this._getSelector(' .mongotimeline_primarypost_content'));			
			// this._getEditForm(aProfileId).appendTo($('#mongotimeline_primarypost_content'));
			this._getSelector(' .mongotimeline_newpost_canvas > div').show();
			// $('#jsportlettimelineform_newprimarypost_actionbar').hide();	Sostituire con il tuner.
			// var geolocation = this._handleGeoLocationInfo(this._getContentClassDefinitionById(aProfileId));
			this._getContentClassDefinitionById(aProfileId).getModelObject().initializeForm({ targetnode_or_id: null, timelineid: aTimelineid, authorinfo: this.inputContext.currentUserEnabledRoles.current, objectcanvas: this._getSelector(' .mongotimeline_newpost_canvas') });
			break;
			
		case 'editprimarypost':

			postRootCanvas = $('#post_' + aTargetNodeDTOAdapter.dataBean.postid);
			if (postRootCanvas.hasClass('collapsed-box'))
			{
			    // $('#post_' + aTargetNodeDTOAdapter.dataBean.postid + " button[data-widget='collapse']").toggleBox();			
				postRootCanvas.find("button[data-widget='collapse']").toggleBox();
			}
		    
			this._getEditForm(aTargetNodeDTOAdapter.dataBean.contentclass).appendTo($('#post_' + aTargetNodeDTOAdapter.dataBean.postid + '_editcanvas'));
			$('#post_' + aTargetNodeDTOAdapter.dataBean.postid + '_viewcanvas').hide();
			$('#post_' + aTargetNodeDTOAdapter.dataBean.postid + ' .box-footer').hide();
			
			$('#post_' + aTargetNodeDTOAdapter.dataBean.postid + ' .box-tools .view-mode').hide();
			$('#post_' + aTargetNodeDTOAdapter.dataBean.postid + ' .box-tools .edit-mode').show();
			
			this._getContentClassDefinitionById(aTargetNodeDTOAdapter.dataBean.contentclass).getModelObject().initializeForm({ targetnode_or_id: aTargetNodeDTOAdapter, timelineid: null, authorinfo: null, objectcanvas: $('#post_' + aTargetNodeDTOAdapter.dataBean.postid + '_editcanvas') });
			break;
			
		case 'newchild':
			
			this.inputContext.currentUserEnabledRoles = currentUserEnabledRoles;
			
			this._getSelector(' .mongotimeline_childpost_canvas').html(tmpl(this.newCommentCanvasTemplate, { currentUserEnabledRoles : this.inputContext.currentUserEnabledRoles }));
			
			this._getSelector(' .mongotimeline_childpost_canvas > div').appendTo($('#post_' + aTargetNodeDTOAdapter.dataBean.postid + '_newchildcanvas'));
			// this._getEditForm(aProfileId).appendTo($('#mongotimeline_postcomment_content'));
			this._getEditForm(aProfileId).appendTo(this._getSelector(' .mongotimeline_postcomment_content'));
			$('#post_' + aTargetNodeDTOAdapter.dataBean.postid + ' .new-child-actionbar').hide();
						
			this._getContentClassDefinitionById(aProfileId).getModelObject().initializeForm({ targetnode_or_id: aTargetNodeDTOAdapter.dataBean.postid, timelineid: aTargetNodeDTOAdapter.dataBean.timeline, authorinfo: this.inputContext.currentUserEnabledRoles.current });
			break;
			
		case 'editchild':
			this._getEditForm(aTargetNodeDTOAdapter.dataBean.contentclass).appendTo($('#comm_' + aTargetNodeDTOAdapter.dataBean.commentid + ' .comment-content-editcanvas'));
			$('#comm_' + aTargetNodeDTOAdapter.dataBean.commentid + ' .comment-content-viewcanvas').hide();			
			
			$('#comm_' + aTargetNodeDTOAdapter.dataBean.commentid + '  .view-mode').hide();
			$('#comm_' + aTargetNodeDTOAdapter.dataBean.commentid + '  .edit-mode').show();

			this._getContentClassDefinitionById(aTargetNodeDTOAdapter.dataBean.contentclass).getModelObject().initializeForm({ targetnode_or_id: aTargetNodeDTOAdapter, timelineid: null, authorinfo: null });
			break;			
			
		}
	},

	_extractPostId: function(anId)
	{		
		if (anId && anId.substring(0, 5) == 'post_')
			anId = anId.substring(5);
		
		return anId;
	},
	
	_extractCommentId: function(anId)
	{		
		if (anId && anId.substring(0, 5) == 'comm_')
			anId = anId.substring(5);
		
		return anId;
	},
	
	newPost: function(aContentDefinitionId, aTimelineId)
	{
        var ur = this._getContentClassDefinitionById(aContentDefinitionId).getCurrentUserEnabledRoles4NewPost("new-post");	   
		this._setInputContext('newprimarypost', aTimelineId, aContentDefinitionId, null, ur);	    		
	},
	
	_onClickHandler: function(e)
	{
		var target = $(e.target);
		var dataAction = target.attr('data-action');
		var dataActionTarget = target;
		var ps = null, cm = null;
		
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
		   var dataActionPath = dataAction.split(':');
		   
		   switch(dataActionPath[0])
		   {
//		   case 'newprimary':			   			   			   
//			   if (dataActionPath[1] == 'timeline')
//			   {
//				   var ur = this._getProfile(this.timelineCfg.postcontentclass).getCurrentUserEnabledRoles4NewPost("new-post");	   
//				   this._setInputContext('newprimarypost', this.timelineCfg, this.timelineCfg.postcontentclass, null, ur);
//			   }
//			   else 
//			   {
//				   var tcfg = this._getTimelineConfigurationById(dataActionPath[1]);
//				   var ur = this._getProfile(tcfg.postcontentclass).getCurrentUserEnabledRoles4NewPost("new-post");	
//				   this._setInputContext('newprimarypost', tcfg, tcfg.postcontentclass, null, ur);
//			   }
//			   break;
			   
		   case 'primary-view-position':
			   ps = dataActionTarget.parents('.timelinepost');
			   if (ps.length > 0)
			   {
				   ps.find(".infomessage").show(); 
			   }				   
			   break;
			   
		   case 'primary-edit-position':
			   this._getContentClassDefinitionById(this.inputContext.contentClass).getModelObject().onPositionToolClick();
			   break;
			   
		   case 'child-edit-cancel':
		   case 'primary-edit-cancel':
			   this._resetInputContext();
			   break;
		   
		   case 'primarypost-submit':
			   this._onSubmit(dataActionPath[1]);
			   break;
		   
		   case 'childpost-submit':
			   this._onChildSubmit(dataActionPath[1]);
			   break;
			   
		   case 'edit-primary':			   
			   ps = dataActionTarget.parents('.timelinepost');
			   if (ps.length > 0)
			   {
				   var dtoAdapter = this.mapOfPosts.getPost(this._extractPostId($(ps[0]).attr('id')));
				   this._setInputContext('editprimarypost', dtoAdapter.dataBean.timeline, dtoAdapter.dataBean.contentclass, dtoAdapter); 
			   }	
			   break;
			   
		   case 'delete-post':			
			   this._resetInputContext();
			   ps = dataActionTarget.parents('.timelinepost');
			   if (ps.length > 0)
			   {
				   this._doDeletePost(ps); 
			   }	
			   break;
			   
		   case 'new-child1':
		   case 'new-child':
			   ps = dataActionTarget.parents('.timelinepost');
			   if (ps.length > 0)
			   {
				   var dtoAdapter = this.mapOfPosts.getPost(this._extractPostId($(ps[0]).attr('id')));
				   var ur = this._getContentClassDefinitionById(dtoAdapter.dataBean.contentclass).getCurrentUserEnabledRoles4NewPost(dataActionPath[0], dtoAdapter);	
				   this._setInputContext('newchild', dtoAdapter.dataBean.timeline, dataActionPath[1], dtoAdapter, ur); 
			   }	
			   break;  
			   
		   case 'edit-child':
			   cm = dataActionTarget.parents('.timelinecomment');
			   ps = cm.parents('.timelinepost');
			   if (ps.length > 0)
			   {
				   var dtoAdapter = this.mapOfPosts.getCommentFromPost(
						   this._extractPostId($(ps[0]).attr('id')), 
						   this._extractCommentId($(cm[0]).attr('id')));
				   this._setInputContext('editchild', dtoAdapter.dataBean.timeline, dtoAdapter.dataBean.contentclass, dtoAdapter); 
			   }	
			   break;  			   

		   case 'delete-child':			
			   this._resetInputContext();
			   
			   cm = dataActionTarget.parents('.timelinecomment');
			   ps = cm.parents('.timelinepost');
			   if (ps.length > 0 && cm.length > 0)
			   {
				   this._doDeleteChild(ps, cm); 
			   }	
			   break;

		   case 'image-selection':
			   // this.inputContext.imageSelectionContext = this._getProfile(dataActionPath[1]).getImageSelectionContext('image-selection');
			   var fileUploadOptions = 
				   	   $.extend({}, 
				   			   this._getContentClassDefinitionById(dataActionPath[1]).getTimelinePhotoUploadOptions(), 
				   			   {
				   		   		  onUploadErrorCallback: function() { console.log('On Upload ERROR CallBack'); },
								  modaldialog_selector : '#mongotimeline_photo_dialog',
								  upload_url: org.r3.PageManager.getRESTUrl('POST_PostTemporaryFileInTimeline', [ org.r3.Constants.site, org.r3.Constants.language ]),	
								  upload_method: 'POST',
							      "accept": "image/png,image/jpeg"
				   			   }
				   	   );
			   
			   this.fileUploader.open(fileUploadOptions);
			   break;
			   
		   case 'shakeit':
			   this._resetInputContext();
			   
			   cm = dataActionTarget.parents('.timelinecomment');
			   ps = cm.parents('.timelinepost');
			   if (ps.length > 0 && cm.length > 0)
			   {
				   this._doShakeit(ps, cm); 
			   }				   
			   break;
			   
		   case 'unshakeit':
			   this._resetInputContext();
			   
			   cm = dataActionTarget.parents('.timelinecomment');
			   ps = cm.parents('.timelinepost');
			   if (ps.length > 0 && cm.length > 0)
			   {
				   this._doUnshakeit(ps, cm); 
			   }	
			   break;
			   
		   case 'switch-user-role':
			   console.log("Switch Role With: ", dataActionPath[1]);
			   var userRole = this._getUserRoleById(dataActionPath[1]);
			   if (userRole != null)
			   {
				   // Lo Switch dello user può avvenire solo in una fase di creazione del content. 
				   // In questo caso l'inputContext dovrebbe essere valorizzato..
				   var contentClassObj = this._getContentClassDefinitionById(this.inputContext.contentClass);
				   contentClassObj.setAuhtorInfo(userRole);
				   cm = dataActionTarget.parents('.timelinecomment');
				   if (cm.length > 0)
				   {
					   cm.find(".postauthorname").html('<a href="#">' + userRole.authorname + ' <i class="fa fa-caret-down"></i></a>');
					   cm.find(".postauthorphoto")[0].src = userRole.getAuthorphotourl();
				   }
				   else
				   {
					   ps = dataActionTarget.parents('.timelinepost');	   
					   if (ps.length > 0)
					   {
						   ps.find(".postauthorname").html('<a href="#">' + userRole.authorname + ' <i class="fa fa-caret-down"></i></a>');
						   ps.find(".postauthorphoto")[0].src = userRole.getAuthorphotourl();
					   }
				   }
			   }
			   break;
			   
			default:
				console.log("Data Action: ", dataAction);		
		   }
		}

		return true;
	},
	
	_doDeletePost: function(aPostWrapperObj)
	{
		var _self = this;
		
		var targetWrapper = $(aPostWrapperObj[0]);
		var aPostId = targetWrapper.attr('id');
		if (aPostId)
			aPostId = aPostId.substring(5);		
							
		org.r3.AjaxUtils.ajaxInvoke(
				'DELETE',
				org.r3.PageManager.getRESTUrl('DELETE_Post', [ org.r3.Constants.site, org.r3.Constants.language, aPostId ]),
				function(responseData) 
				{ 
					 targetWrapper.remove(); 		
					 // Il post viene inserito in testa. Dato l'ordinamento previsto per quanto riguarda il fetch dei post debbo aggiornare la finestra di retrieval.
					 _self.fetchPostInfo.fixOffsetOnPostAddedDeleted(-1); 
				     _self.mapOfPosts.removePost(aPostId); 
				}, 
				function(jqXHR, timeout, message) {}, 
				false, 
				false);		
	},
		
	_onSubmit : function(aProfileId)
	{
		var _self = this;
		var profileObj = this._getContentClassDefinitionById(aProfileId);
		
		var theForm = profileObj.getModelObject().getForm();
		var threadNodeId = theForm.find("input[name='postid']").val(); // profileObj.getPostIdFieldValue();	
		// var timelineId = profileObj.getTimelineIdFieldValue();				
		
		if (theForm.valid())
		{					
	    	profileObj.getModelObject().serializeContent();
		    
	    	var method = null;
			var restUrl = null;
			if (threadNodeId)
			{				
				restUrl = org.r3.PageManager.getRESTUrl('PUT_UpdatePostInTimeline', [ org.r3.Constants.site, org.r3.Constants.language, threadNodeId ]);
				method = "put";
			}
			else
			{
				restUrl = org.r3.PageManager.getRESTUrl('POST_AddPostInTimeline', [ org.r3.Constants.site, org.r3.Constants.language ]);
				method = "post";
			}
			
			org.r3.AjaxUtils.submitForm(
					method, 
					restUrl, 
					theForm, 
					function(responseData) 
					{
						_self._processPostSubmitResponse(responseData);											
					}, 
					function(jqXHR, timeout, message) {
						console.log(arguments);
						profileObj.showMessage({ text: message, category: 'error' });						
					}, 
					"org.r3.message.saveconfirm", 
					true);			
		}
	},

	_processPostSubmitResponse: function(responseData)
	{		
		var timelinePostDataBean = new org.r3.db.mongo.postcollection.PostCollectionDTOAdapter(responseData);
		this.mapOfPosts.addOrUpdatePost(timelinePostDataBean);
		
		var profileObj = this._getContentClassDefinitionById(timelinePostDataBean.dataBean.contentclass);		
		// profileObj.onSubmitSuccess();
		
		var thnode = $('#post_' + timelinePostDataBean.dataBean.postid);
		if (thnode.length)
		{
			this._updatePost(timelinePostDataBean);
		}
		else
		{
			this._appendPost(timelinePostDataBean, true);	
			org.r3.PageManager.userCollectionProfileInfo.setUserAnalyticsLastpostauthor(
					timelinePostDataBean.dataBean.author, timelinePostDataBean.dataBean.authortype);
		}
		
		// Il post viene inserito in testa. Dato l'ordinamento previsto per quanto riguarda il fetch dei post debbo aggiornare la finestra di retrieval.
		this.fetchPostInfo.fixOffsetOnPostAddedDeleted(1);
		
		this._resetInputContext();					
	},
		
	_doDeleteChild: function(aPostWrapperObj, aCommentWrapperObj)
	{
		var _self = this;
		
		var postTargetWrapper = $(aPostWrapperObj[0]);
		var aPostId = postTargetWrapper.attr('id');
		if (aPostId)
			aPostId = aPostId.substring(5);		
		
		var commentTargetWrapper = $(aCommentWrapperObj[0]);
		var aCommentId = commentTargetWrapper.attr('id');
		if (aCommentId)
			aCommentId = aCommentId.substring(5);
					
		org.r3.AjaxUtils.ajaxInvoke(
				'DELETE',
				org.r3.PageManager.getRESTUrl('DELETE_CommentFromPost', [ org.r3.Constants.site, org.r3.Constants.language, aPostId, aCommentId ]),
				function(responseData) { commentTargetWrapper.remove(); _self.mapOfPosts.removeCommentFromPost(aPostId, aCommentId); }, 
				function(jqXHR, timeout, message) {}, 
				false, 
				false);		
	},

	_doShakeit: function(aPostWrapperObj, aCommentWrapperObj)
	{
		return this._doShakeUnshakeit('SHAKE_PostComment', aPostWrapperObj, aCommentWrapperObj);
	},

	_doUnshakeit: function(aPostWrapperObj, aCommentWrapperObj)
	{
		return this._doShakeUnshakeit('UNSHAKE_PostComment', aPostWrapperObj, aCommentWrapperObj);
	},
	
	_doShakeUnshakeit: function(aUrlAction, aPostWrapperObj, aCommentWrapperObj)
	{
		var _self = this;
		
		var postTargetWrapper = $(aPostWrapperObj[0]);
		var aPostId = postTargetWrapper.attr('id');
		if (aPostId)
			aPostId = aPostId.substring(5);		
		
		var commentTargetWrapper = $(aCommentWrapperObj[0]);
		var aCommentId = commentTargetWrapper.attr('id');
		if (aCommentId)
			aCommentId = aCommentId.substring(5);
						
		org.r3.AjaxUtils.submitForm(
				'PUT',
				org.r3.PageManager.getRESTUrl(aUrlAction, [  org.r3.Constants.site, org.r3.Constants.language, aPostId, aCommentId ]),
				org.r3.PageManager.jsAppVersionForm,
				function(responseData) { 
					_self._processCommentSubmitResponse(responseData, true);																					 
				}, 
				function(jqXHR, timeout, message) {}, 
				false, 
				false);		
	},
	
	_onChildSubmit : function(aProfileId)
	{
		var _self = this;
		var profileObj = this._getContentClassDefinitionById(aProfileId);

		var theForm = profileObj.getModelObject().getForm();

		var parentPostId = theForm.find("input[name='parentpostid']").val(); // profileObj.getParentPostIdFieldValue();
		var timelineId = theForm.find("input[name='timeline']").val(); // profileObj.getTimelineIdFieldValue();
		var threadNodeId = theForm.find("input[name='postid']").val(); // 		
		
		if (theForm.valid())
		{					
			profileObj.getModelObject().serializeContent();
		    
	    	var method = null;
			var restUrl = null;
			if (threadNodeId)
			{				
				restUrl = org.r3.PageManager.getRESTUrl('PUT_ModifyPostComment', [ org.r3.Constants.site, org.r3.Constants.language, parentPostId, threadNodeId ]);
				method = "put";
			}
			else
			{
				restUrl = org.r3.PageManager.getRESTUrl('POST_AddPostComment', [ org.r3.Constants.site, org.r3.Constants.language, parentPostId  ]);
				method = "post";
			}
			
			org.r3.AjaxUtils.submitForm(
					method, 
					restUrl, 
					theForm, 
					function(responseData) {
						_self._processCommentSubmitResponse(responseData);																
					}, 
					function(jqXHR, timeout, message) {
						console.log(arguments);
						profileObj.showMessage({ text: message, category: 'error' });						
					}, 
					"org.r3.message.saveconfirm", 
					true);			
		}
	},
		
	_processCommentSubmitResponse: function(responseData, replaceFlag)
	{
		var timelinePostCommentDataBean = new org.r3.db.mongo.postcommentcollection.PostCommentCollectionDTOAdapter(responseData);
        		
		var cid = timelinePostCommentDataBean.dataBean.commentid;
		var pid = timelinePostCommentDataBean.dataBean.postid;
		
		var postDtoAdapter = this.mapOfPosts.getPost(pid);
//		var profileObj = this._getProfile(postDtoAdapter.dataBean.contentclass);
//		profileObj.onSubmitSuccess();
		
		var commentDtoAdapter = this.mapOfPosts.addOrUpdateCommentInPost(pid, timelinePostCommentDataBean);				
		
		var postnode = $('#post_' + pid);
		var commentnode = postnode.find('#comm_' + cid);
		if (commentnode.length)
		{
			if (!replaceFlag)
			    this._updateComment(timelinePostCommentDataBean);
			else 
			    this._replaceComment(postDtoAdapter, timelinePostCommentDataBean);				
		}
		else
		{
		    this._appendComment(postDtoAdapter, timelinePostCommentDataBean, true);
		    org.r3.PageManager.userCollectionProfileInfo.setUserAnalyticsLastpostauthor(
		    		timelinePostCommentDataBean.dataBean.author, timelinePostCommentDataBean.dataBean.authortype);
		}				
		
		this._resetInputContext();	
	}
	
	
		

});
